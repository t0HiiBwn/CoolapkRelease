package com.coolapk.market.view.dyhv8.viewholder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemDyhDetailV8Binding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.dyhv8.DyhArticleAction;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u0015R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleDetailViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemDyhDetailV8Binding;", "Lcom/coolapk/market/model/DyhArticle;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "dyhArticle", "dyhViewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "isRequesting", "", "Ljava/lang/Boolean;", "mNinePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "toastShowed", "bindToContent", "", "data", "onActionButtonClick", "onClick", "view", "onPopulateDyhImage", "showDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailViewHolder.kt */
public final class DyhArticleDetailViewHolder extends GenericBindHolder<ItemDyhDetailV8Binding, DyhArticle> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558685;
    private DyhArticle dyhArticle;
    private DyhViewModel dyhViewModel;
    private Boolean isRequesting = false;
    private NinePicViewPart mNinePicViewPart;
    private boolean toastShowed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DyhArticleDetailViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(DyhArticle dyhArticle2) {
        this.dyhArticle = dyhArticle2;
        DyhViewModel dyhViewModel2 = new DyhViewModel();
        this.dyhViewModel = dyhViewModel2;
        Intrinsics.checkNotNull(dyhViewModel2);
        dyhViewModel2.setDyhArticle(dyhArticle2);
        DyhViewModel dyhViewModel3 = this.dyhViewModel;
        Intrinsics.checkNotNull(dyhViewModel3);
        DyhArticle dyhArticle3 = this.dyhArticle;
        Intrinsics.checkNotNull(dyhArticle3);
        dyhViewModel3.setDyhModel(dyhArticle3.getDyhModel());
        ItemDyhDetailV8Binding itemDyhDetailV8Binding = (ItemDyhDetailV8Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDyhDetailV8Binding, "binding");
        itemDyhDetailV8Binding.setModel(this.dyhViewModel);
        ItemDyhDetailV8Binding itemDyhDetailV8Binding2 = (ItemDyhDetailV8Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDyhDetailV8Binding2, "binding");
        int i = 0;
        itemDyhDetailV8Binding2.setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 4), false));
        if (this.mNinePicViewPart == null) {
            DataBindingComponent component = getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            NinePicViewPart ninePicViewPart = new NinePicViewPart(component);
            this.mNinePicViewPart = ninePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart);
            LayoutInflater from = LayoutInflater.from(getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
            ninePicViewPart.createView(from, ((ItemDyhDetailV8Binding) getBinding()).coolPicPartContainer);
            NinePicViewPart ninePicViewPart2 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart2);
            ninePicViewPart2.setV9LikeMode(true);
            FrameLayout frameLayout = ((ItemDyhDetailV8Binding) getBinding()).coolPicPartContainer;
            NinePicViewPart ninePicViewPart3 = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart3);
            frameLayout.addView(ninePicViewPart3.getView());
        }
        onPopulateDyhImage(dyhArticle2);
        ItemDyhDetailV8Binding itemDyhDetailV8Binding3 = (ItemDyhDetailV8Binding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDyhDetailV8Binding3, "binding");
        itemDyhDetailV8Binding3.setClick(this);
        TextView textView = ((ItemDyhDetailV8Binding) getBinding()).extendSubTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.extendSubTitle");
        DyhArticle dyhArticle4 = this.dyhArticle;
        Intrinsics.checkNotNull(dyhArticle4);
        String rawUrl = dyhArticle4.getRawUrl();
        if (rawUrl == null) {
            rawUrl = "";
        }
        textView.setText(StringUtils.getUrlHost(rawUrl));
        TextView textView2 = ((ItemDyhDetailV8Binding) getBinding()).extendSubTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.extendSubTitle");
        DyhArticle dyhArticle5 = this.dyhArticle;
        Intrinsics.checkNotNull(dyhArticle5);
        if (TextUtils.isEmpty(dyhArticle5.getRawUrl())) {
            i = 8;
        }
        textView2.setVisibility(i);
        TextView textView3 = ((ItemDyhDetailV8Binding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionView");
        DyhViewModel dyhViewModel4 = this.dyhViewModel;
        Intrinsics.checkNotNull(dyhViewModel4);
        textView3.setBackground(dyhViewModel4.getIsFollowDyh() ? ShapeUtils.createDyhFollowedRevealBg(getContext()) : ShapeUtils.createDyhUnFollowedRevealBg(getContext()));
        TextView textView4 = ((ItemDyhDetailV8Binding) getBinding()).extendTitle;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.extendTitle");
        DyhViewModel dyhViewModel5 = this.dyhViewModel;
        textView4.setText(dyhViewModel5 != null ? dyhViewModel5.getExtendTitle() : null);
        ((ItemDyhDetailV8Binding) getBinding()).executePendingBindings();
        ((ItemDyhDetailV8Binding) getBinding()).cardView.setOnLongClickListener(new DyhArticleDetailViewHolder$bindToContent$1(this));
    }

    public final void showDialog() {
        DyhArticleAction newInstance = DyhArticleAction.Companion.newInstance(this.dyhArticle);
        Activity activity = UiUtils.getActivity(getContext());
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleDetailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleDetailViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void onPopulateDyhImage(DyhArticle dyhArticle2) {
        if (dyhArticle2 == null || CollectionUtils.safeSize(dyhArticle2.getPicArr()) < 1) {
            NinePicViewPart ninePicViewPart = this.mNinePicViewPart;
            Intrinsics.checkNotNull(ninePicViewPart);
            ninePicViewPart.bindToContent(CollectionsKt.emptyList());
            return;
        }
        NinePicViewPart ninePicViewPart2 = this.mNinePicViewPart;
        Intrinsics.checkNotNull(ninePicViewPart2);
        ninePicViewPart2.setMaxShowCount(-1);
        NinePicViewPart ninePicViewPart3 = this.mNinePicViewPart;
        Intrinsics.checkNotNull(ninePicViewPart3);
        List<String> picArr = dyhArticle2.getPicArr();
        Intrinsics.checkNotNull(picArr);
        Intrinsics.checkNotNullExpressionValue(picArr, "dyhArticle.picArr!!");
        ninePicViewPart3.bindToContent(picArr);
    }

    private final void onActionButtonClick() {
        Observable<Result<String>> observable;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (!loginSession.isLogin()) {
            ActionManager.startLoginActivity(getContext());
            return;
        }
        Boolean bool = this.isRequesting;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            this.isRequesting = true;
            DyhViewModel dyhViewModel2 = this.dyhViewModel;
            Intrinsics.checkNotNull(dyhViewModel2);
            if (!dyhViewModel2.getIsFollowDyh()) {
                DyhViewModel dyhViewModel3 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel3);
                dyhViewModel3.setFollowDyh(true);
                TextView textView = ((ItemDyhDetailV8Binding) getBinding()).actionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
                textView.setBackground(ShapeUtils.createDyhFollowedRevealBg(getContext()));
                DataManager instance2 = DataManager.getInstance();
                DyhViewModel dyhViewModel4 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel4);
                DyhModel dyhModel = dyhViewModel4.getDyhModel();
                Intrinsics.checkNotNullExpressionValue(dyhModel, "dyhViewModel!!.dyhModel");
                observable = instance2.followDyh(dyhModel.getId());
                DyhViewModel dyhViewModel5 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel5);
                DyhModel.Builder newBuilder = DyhModel.newBuilder(dyhViewModel5.getDyhModel());
                DyhViewModel dyhViewModel6 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel6);
                DyhModel dyhModel2 = dyhViewModel6.getDyhModel();
                Intrinsics.checkNotNullExpressionValue(dyhModel2, "dyhViewModel!!.dyhModel");
                DyhModel build = newBuilder.userAction(UserAction.newBuilder(dyhModel2.getUserAction()).follow(1).build()).build();
                DyhViewModel dyhViewModel7 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel7);
                dyhViewModel7.setDyhModel(build);
            } else {
                DyhViewModel dyhViewModel8 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel8);
                dyhViewModel8.setFollowDyh(false);
                TextView textView2 = ((ItemDyhDetailV8Binding) getBinding()).actionView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
                textView2.setBackground(ShapeUtils.createDyhUnFollowedRevealBg(getContext()));
                DataManager instance3 = DataManager.getInstance();
                DyhViewModel dyhViewModel9 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel9);
                DyhModel dyhModel3 = dyhViewModel9.getDyhModel();
                Intrinsics.checkNotNullExpressionValue(dyhModel3, "dyhViewModel!!.dyhModel");
                Observable<Result<String>> unFollowDyh = instance3.unFollowDyh(dyhModel3.getId());
                DyhViewModel dyhViewModel10 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel10);
                DyhModel.Builder newBuilder2 = DyhModel.newBuilder(dyhViewModel10.getDyhModel());
                DyhViewModel dyhViewModel11 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel11);
                DyhModel dyhModel4 = dyhViewModel11.getDyhModel();
                Intrinsics.checkNotNullExpressionValue(dyhModel4, "dyhViewModel!!.dyhModel");
                DyhModel build2 = newBuilder2.userAction(UserAction.newBuilder(dyhModel4.getUserAction()).follow(0).build()).build();
                DyhViewModel dyhViewModel12 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel12);
                dyhViewModel12.setDyhModel(build2);
                observable = unFollowDyh;
            }
            observable.compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).doOnTerminate(new DyhArticleDetailViewHolder$onActionButtonClick$1(this)).subscribe((Subscriber) new DyhArticleDetailViewHolder$onActionButtonClick$2(this));
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        switch (view.getId()) {
            case 2131361982:
                onActionButtonClick();
                return;
            case 2131362205:
                DyhArticle dyhArticle2 = this.dyhArticle;
                Intrinsics.checkNotNull(dyhArticle2);
                if (TextUtils.isEmpty(dyhArticle2.getRawUrl())) {
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(((ItemDyhDetailV8Binding) getBinding()).cardView, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 0.0f, 25.0f, -25.0f, 25.0f, -25.0f, 15.0f, -15.0f, 6.0f, -6.0f, 0.0f));
                    Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ObjectAnimator.ofPropert… 15F, -15F, 6F, -6F, 0F))");
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ofPropertyValuesHolder);
                    animatorSet.setDuration(150L);
                    animatorSet.start();
                    if (!this.toastShowed) {
                        Toast.show$default(getContext(), "没有外链", 0, false, 12, null);
                        this.toastShowed = true;
                        return;
                    }
                    return;
                }
                DyhArticle dyhArticle3 = this.dyhArticle;
                Intrinsics.checkNotNull(dyhArticle3);
                String rawUrl = dyhArticle3.getRawUrl();
                if (rawUrl == null) {
                    rawUrl = "";
                }
                if (UriUtils.isInAppUrl(rawUrl)) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    DyhArticle dyhArticle4 = this.dyhArticle;
                    Intrinsics.checkNotNull(dyhArticle4);
                    ActionManagerCompat.startActivityByUrl$default(context, dyhArticle4.getRawUrl(), null, null, 12, null);
                    return;
                }
                ActionManager.startWebViewForDyhActivity(getContext(), this.dyhArticle);
                return;
            case 2131362489:
                ActionManager.startWebViewForDyhActivity(getContext(), this.dyhArticle);
                return;
            case 2131362900:
                Context context2 = getContext();
                DyhViewModel dyhViewModel2 = this.dyhViewModel;
                Intrinsics.checkNotNull(dyhViewModel2);
                DyhModel dyhModel = dyhViewModel2.getDyhModel();
                Intrinsics.checkNotNullExpressionValue(dyhModel, "dyhViewModel!!.dyhModel");
                ActionManager.startDyhDetailActivity(context2, dyhModel.getId());
                return;
            default:
                return;
        }
    }
}
