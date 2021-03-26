package com.coolapk.market.view.dyhv8.viewholder;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.ItemDyharticleActionBinding;
import com.coolapk.market.event.DyhArticleEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxLogin;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

public class DyhArticleActionViewPart extends BindingViewPart<ItemDyharticleActionBinding, DyhArticle> {
    public static final int LAYOUT_ID = 2131558691;
    private ClickCallBack clickCallBack;
    private boolean fromDetail;
    private boolean hasLiked;
    private final int likeResrouce = 2131231693;
    private final int likedResrouce = 2131231257;
    private final DataBindingComponent mComponent;
    private DyhArticle mDyhArticle;
    private boolean posting;

    public interface ClickCallBack {
        void actionClick(View view);
    }

    private DyhArticleActionViewPart(DataBindingComponent dataBindingComponent) {
        this.mComponent = dataBindingComponent;
    }

    public void setClickCallBack(ClickCallBack clickCallBack2) {
        this.clickCallBack = clickCallBack2;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemDyharticleActionBinding) getBinding()).setClick(this);
    }

    public static DyhArticleActionViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent) {
        DyhArticleActionViewPart dyhArticleActionViewPart = new DyhArticleActionViewPart(dataBindingComponent);
        dyhArticleActionViewPart.createView(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        return dyhArticleActionViewPart;
    }

    public void onBindToContent(DyhArticle dyhArticle) {
        this.mDyhArticle = dyhArticle;
        this.hasLiked = dyhArticle.isLiked();
        ItemDyharticleActionBinding itemDyharticleActionBinding = (ItemDyharticleActionBinding) getBinding();
        itemDyharticleActionBinding.setModel(dyhArticle);
        itemDyharticleActionBinding.executePendingBindings();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemDyharticleActionBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ItemDyharticleActionBinding) DataBindingUtil.inflate(layoutInflater, 2131558691, viewGroup, false, this.mComponent);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == 2131362296) {
            ClickCallBack clickCallBack2 = this.clickCallBack;
            if (clickCallBack2 != null) {
                clickCallBack2.actionClick(view);
            }
        } else if (id == 2131362600) {
            ActionManager.startNewFeedForDyhActivity(UiUtils.getActivity(getContext()), this.mDyhArticle);
        } else if (id == 2131362862) {
            RxLogin.getInstance(getContext()).requestLogin().subscribe((Subscriber<? super Boolean>) new Subscriber<Boolean>() {
                /* class com.coolapk.market.view.dyhv8.viewholder.DyhArticleActionViewPart.AnonymousClass1 */

                @Override // rx.Observer
                public void onCompleted() {
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                }

                public void onNext(Boolean bool) {
                    if (bool.booleanValue() && !DyhArticleActionViewPart.this.posting) {
                        DyhArticleActionViewPart.this.posting = true;
                        if (DyhArticleActionViewPart.this.hasLiked) {
                            DataManager.getInstance().dyhArticleUnLike(DyhArticleActionViewPart.this.mDyhArticle.getId()).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<Integer>>() {
                                /* class com.coolapk.market.view.dyhv8.viewholder.DyhArticleActionViewPart.AnonymousClass1.AnonymousClass1 */

                                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                public void onError(Throwable th) {
                                    Toast.error(UiUtils.getActivity(DyhArticleActionViewPart.this.getContext()), th);
                                    DyhArticleActionViewPart.this.onLike(DyhArticleActionViewPart.this.mDyhArticle);
                                }

                                public void onNext(Result<Integer> result) {
                                    if (result != null) {
                                        if (result.getData() != null) {
                                            int intValue = result.getData().intValue();
                                            DyhArticleActionViewPart.this.posting = false;
                                            EventBus.getDefault().post(new DyhArticleEvent(0, intValue, DyhArticleActionViewPart.this.mDyhArticle.getId(), false));
                                            return;
                                        }
                                        Toast.show(UiUtils.getActivity(DyhArticleActionViewPart.this.getContext()), result.getMessage());
                                        DyhArticleActionViewPart.this.onLike(DyhArticleActionViewPart.this.mDyhArticle);
                                    }
                                }
                            });
                            DyhArticleActionViewPart.this.hasLiked = false;
                            ((ItemDyharticleActionBinding) DyhArticleActionViewPart.this.getBinding()).likeNum.setText(DyhArticleActionViewPart.this.mDyhArticle.getLikeNum() - 1 > 0 ? String.valueOf(DyhArticleActionViewPart.this.mDyhArticle.getLikeNum() - 1) : "赞");
                            Drawable mutate = ContextCompat.getDrawable(DyhArticleActionViewPart.this.getContext(), 2131231693).mutate();
                            mutate.setTint(Color.parseColor("#9E9E9E"));
                            ((ItemDyharticleActionBinding) DyhArticleActionViewPart.this.getBinding()).likeIcon.setImageDrawable(mutate);
                            return;
                        }
                        DataManager.getInstance().dyhArticleLike(DyhArticleActionViewPart.this.mDyhArticle.getId()).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<Integer>>() {
                            /* class com.coolapk.market.view.dyhv8.viewholder.DyhArticleActionViewPart.AnonymousClass1.AnonymousClass2 */

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                Toast.error(UiUtils.getActivity(DyhArticleActionViewPart.this.getContext()), th);
                                DyhArticleActionViewPart.this.onLike(DyhArticleActionViewPart.this.mDyhArticle);
                            }

                            public void onNext(Result<Integer> result) {
                                if (result != null) {
                                    if (result.getData() != null) {
                                        int intValue = result.getData().intValue();
                                        DyhArticleActionViewPart.this.posting = false;
                                        EventBus.getDefault().post(new DyhArticleEvent(0, intValue, DyhArticleActionViewPart.this.mDyhArticle.getId(), true));
                                        return;
                                    }
                                    Toast.show(UiUtils.getActivity(DyhArticleActionViewPart.this.getContext()), result.getMessage());
                                    DyhArticleActionViewPart.this.onLike(DyhArticleActionViewPart.this.mDyhArticle);
                                }
                            }
                        });
                        DyhArticleActionViewPart.this.hasLiked = true;
                        ((ItemDyharticleActionBinding) DyhArticleActionViewPart.this.getBinding()).likeNum.setText(String.valueOf(DyhArticleActionViewPart.this.mDyhArticle.getLikeNum() + 1));
                        Drawable mutate2 = ContextCompat.getDrawable(DyhArticleActionViewPart.this.getContext(), 2131231257).mutate();
                        mutate2.setTint(Color.parseColor("#9E9E9E"));
                        ((ItemDyharticleActionBinding) DyhArticleActionViewPart.this.getBinding()).likeIcon.setImageDrawable(mutate2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onLike(DyhArticle dyhArticle) {
        int likeNum = dyhArticle.getLikeNum();
        boolean isLiked = dyhArticle.isLiked();
        ((ItemDyharticleActionBinding) getBinding()).likeNum.setText(likeNum > 0 ? String.valueOf(likeNum) : "赞");
        Drawable mutate = ContextCompat.getDrawable(getContext(), isLiked ? 2131231257 : 2131231693).mutate();
        mutate.setTint(Color.parseColor("#9E9E9E"));
        ((ItemDyharticleActionBinding) getBinding()).likeIcon.setImageDrawable(mutate);
        this.posting = false;
    }
}
