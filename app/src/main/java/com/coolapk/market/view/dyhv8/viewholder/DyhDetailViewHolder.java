package com.coolapk.market.view.dyhv8.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.DyhHeaderViewBinding;
import com.coolapk.market.event.DyhHandleEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.BlurTransform;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.feedv8.FeedArgsFactoryKt;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

public class DyhDetailViewHolder extends GenericBindHolder<DyhHeaderViewBinding, Entity> {
    public static final int LAYOUT_ID = 2131558543;
    private boolean isCoverLoaded;
    private boolean isRequesting;
    private DyhHeaderViewBinding mBinding = ((DyhHeaderViewBinding) getBinding());
    private DyhViewModel viewModel = new DyhViewModel();

    public DyhDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        DyhModel dyhModel = (DyhModel) entity;
        this.viewModel.setDyhModel(dyhModel);
        loadCover(dyhModel.getLogo());
        this.mBinding.setModel(this.viewModel);
        this.mBinding.editView.setBackground(ShapeUtils.createStrokeBg(getContext(), 14));
        this.mBinding.setTransformer(new CircleTransform());
        this.mBinding.actionView.setBackground((!this.viewModel.getIsFollowDyh() || this.viewModel.getIsDyhEditor()) ? ShapeUtils.createDyhUnFollowedRevealBg(getContext()) : ShapeUtils.createDyhFollowedRevealBg(getContext()));
        this.mBinding.executePendingBindings();
        ViewUtil.clickListener(this.mBinding.actionView, new View.OnClickListener() {
            /* class com.coolapk.market.view.dyhv8.viewholder.DyhDetailViewHolder.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DyhDetailViewHolder.this.onActionButtonClick((ActionButtonFrameLayout) view);
            }
        });
        ViewUtil.clickListener(this.mBinding.editView, new View.OnClickListener() {
            /* class com.coolapk.market.view.dyhv8.viewholder.DyhDetailViewHolder.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActionManager.startWebViewActivity(DyhDetailViewHolder.this.getContext(), UriUtils.getDyhEditUrl(DyhDetailViewHolder.this.viewModel.getDyhModel().getId()));
            }
        });
    }

    @Bindable
    public String getActionButtonBackground() {
        return this.viewModel.getIsFollowDyh() ? "followed" : "follow";
    }

    /* access modifiers changed from: private */
    public void onActionButtonClick(final ActionButtonFrameLayout actionButtonFrameLayout) {
        Observable<Result<String>> observable;
        if (!DataManager.getInstance().getLoginSession().isLogin()) {
            ActionManager.startLoginActivity(getContext());
        } else if (this.viewModel.getIsDyhEditor()) {
            Activity activity = UiUtils.getActivity(getContext());
            ActionManager.startSubmitFeedV8Activity(activity, FeedArgsFactoryKt.applyDyh(FeedArgsFactoryKt.applyHtml(FeedArgsFactory.uiConfigForFeed(activity)), this.viewModel.getDyhModel()).build(), FeedArgsFactoryKt.applyDyh(FeedArgsFactory.multiPartForFeed(), this.viewModel.getDyhModel()).build());
        } else if (!this.isRequesting) {
            this.isRequesting = true;
            if (!this.viewModel.getIsFollowDyh()) {
                this.viewModel.setFollowDyh(true);
                this.viewModel.setDyhModel(DyhModel.newBuilder(this.viewModel.getDyhModel()).userAction(UserAction.newBuilder(this.viewModel.getDyhModel().getUserAction()).follow(1).build()).followNum(this.viewModel.getDyhModel().getFollowNum() + 1).build());
                ((DyhHeaderViewBinding) getBinding()).actionButton.setText("已订阅");
                ((DyhHeaderViewBinding) getBinding()).actionButton.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                followButton(actionButtonFrameLayout);
                observable = DataManager.getInstance().followDyh(this.viewModel.getDyhModel().getId());
            } else {
                this.viewModel.setFollowDyh(false);
                this.viewModel.setDyhModel(DyhModel.newBuilder(this.viewModel.getDyhModel()).userAction(UserAction.newBuilder(this.viewModel.getDyhModel().getUserAction()).follow(0).build()).followNum(this.viewModel.getDyhModel().getFollowNum() - 1).build());
                ((DyhHeaderViewBinding) getBinding()).actionButton.setText("订阅");
                ((DyhHeaderViewBinding) getBinding()).actionButton.setTextColor(AppHolder.getAppTheme().getContentBackgroundColor());
                unFollowButton(actionButtonFrameLayout);
                observable = DataManager.getInstance().unFollowDyh(this.viewModel.getDyhModel().getId());
            }
            observable.compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).doOnTerminate(new Action0() {
                /* class com.coolapk.market.view.dyhv8.viewholder.DyhDetailViewHolder.AnonymousClass4 */

                @Override // rx.functions.Action0
                public void call() {
                    DyhDetailViewHolder.this.isRequesting = false;
                }
            }).subscribe((Subscriber) new EmptySubscriber<Result<String>>() {
                /* class com.coolapk.market.view.dyhv8.viewholder.DyhDetailViewHolder.AnonymousClass3 */

                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                public void onError(Throwable th) {
                    super.onError(th);
                    Toast.error(DyhDetailViewHolder.this.getContext(), th);
                    DyhDetailViewHolder.this.viewModel.setFollowDyh(!DyhDetailViewHolder.this.viewModel.getIsFollowDyh());
                    ((DyhHeaderViewBinding) DyhDetailViewHolder.this.getBinding()).actionButton.setText(DyhDetailViewHolder.this.viewModel.getIsFollowDyh() ? "已订阅" : "订阅");
                    ((DyhHeaderViewBinding) DyhDetailViewHolder.this.getBinding()).actionButton.setTextColor(DyhDetailViewHolder.this.viewModel.getIsFollowDyh() ? AppHolder.getAppTheme().getTextColorSecondary() : AppHolder.getAppTheme().getContentBackgroundColor());
                    if (DyhDetailViewHolder.this.viewModel.getIsFollowDyh()) {
                        DyhDetailViewHolder.this.followButton(actionButtonFrameLayout);
                    } else {
                        DyhDetailViewHolder.this.unFollowButton(actionButtonFrameLayout);
                    }
                }

                public void onNext(Result<String> result) {
                    EventBus.getDefault().post(new DyhHandleEvent(DyhDetailViewHolder.this.viewModel.getDyhModel()));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void followButton(ActionButtonFrameLayout actionButtonFrameLayout) {
        actionButtonFrameLayout.setOtherActionBackground(ShapeUtils.createDyhFollowedRevealBg(getContext()), ShapeUtils.createDyhFollowBg(getContext()), null);
    }

    /* access modifiers changed from: private */
    public void unFollowButton(ActionButtonFrameLayout actionButtonFrameLayout) {
        actionButtonFrameLayout.setOtherActionBackground(ShapeUtils.createDyhUnFollowedRevealBg(getContext()), ShapeUtils.createDyhUnFollowBg(getContext()), null);
    }

    private void loadCover(String str) {
        if (!UiUtils.getActivity(getContext()).isFinishing() && !TextUtils.isEmpty(str) && !this.isCoverLoaded) {
            this.isCoverLoaded = true;
            this.mBinding.coverView.setVisibility(4);
            BlurTransform blurTransform = new BlurTransform();
            AnonymousClass5 r8 = new OnImageLoadListener() {
                /* class com.coolapk.market.view.dyhv8.viewholder.DyhDetailViewHolder.AnonymousClass5 */

                @Override // com.coolapk.market.app.OnImageLoadListener
                public void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
                    DyhDetailViewHolder.this.mBinding.coverView.setVisibility(0);
                }
            };
            AppHolder.getContextImageLoader().displayImage((Context) UiUtils.getActivity(getContext()), str, this.mBinding.coverView, ImageLoaderOptions.newBuilder().bitmapOnly(true).build(), (OnImageLoadListener) r8, (OnBitmapTransformListener) blurTransform);
        }
    }
}
