package com.coolapk.market.view.node.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.transition.TransitionManager;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.AppNodeCommunityHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.User;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.NodeHelper;
import com.coolapk.market.view.node.NodePaletteBackgroundTarget;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.viewpart.TripleAvatarViewPart;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J*\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeCommunityViewPart;", "Lcom/coolapk/market/view/node/app/BaseAppNodeViewPart;", "Lcom/coolapk/market/databinding/AppNodeCommunityHeaderBinding;", "activity", "Landroid/app/Activity;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "presenter", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "(Landroid/app/Activity;Lcom/coolapk/market/view/node/app/AppNodeViewModel;Lcom/coolapk/market/view/node/app/AppNodePresenter;)V", "component", "Lcom/coolapk/market/binding/ContextBindingComponent;", "tripleViewPart", "Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "getTripleViewPart", "()Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "tripleViewPart$delegate", "Lkotlin/Lazy;", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "loadLogoAndBG", "data", "Lcom/coolapk/market/model/ServiceApp;", "callback", "Lkotlin/Function2;", "", "onBindToContent", "onClick", "view", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeCommunityViewPart.kt */
public final class AppNodeCommunityViewPart extends BaseAppNodeViewPart<AppNodeCommunityHeaderBinding> {
    private final Activity activity;
    private final ContextBindingComponent component;
    private final AppNodePresenter presenter;
    private final Lazy tripleViewPart$delegate = LazyKt.lazy(new AppNodeCommunityViewPart$tripleViewPart$2(this));
    private final AppNodeViewModel viewModel;

    private final TripleAvatarViewPart getTripleViewPart() {
        return (TripleAvatarViewPart) this.tripleViewPart$delegate.getValue();
    }

    public AppNodeCommunityViewPart(Activity activity2, AppNodeViewModel appNodeViewModel, AppNodePresenter appNodePresenter) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(appNodePresenter, "presenter");
        this.activity = activity2;
        this.viewModel = appNodeViewModel;
        this.presenter = appNodePresenter;
        this.component = new ContextBindingComponent(activity2);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public AppNodeCommunityHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558463, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (AppNodeCommunityHeaderBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((AppNodeCommunityHeaderBinding) getBinding()).setClick(this);
        RoundedImageView roundedImageView = ((AppNodeCommunityHeaderBinding) getBinding()).logoView;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "binding.logoView");
        ViewExtendsKt.darkForegroundIfNeed(roundedImageView);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0051: APUT  (r3v3 java.lang.String[]), (0 ??[int, short, byte, char]), (r4v1 java.lang.String) */
    /* access modifiers changed from: protected */
    public void onBindToContent(ServiceApp serviceApp) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(serviceApp, "data");
        super.onBindToContent((AppNodeCommunityViewPart) serviceApp);
        NodeHelper nodeHelper = NodeHelper.INSTANCE;
        LinearAdapterLayout linearAdapterLayout = ((AppNodeCommunityHeaderBinding) getBinding()).linearView;
        Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.linearView");
        List<NewHeadLine> recommendRows = serviceApp.getRecommendRows();
        Intrinsics.checkNotNullExpressionValue(recommendRows, "data.recommendRows");
        nodeHelper.setupRecommendRows(linearAdapterLayout, recommendRows);
        NodeHelper nodeHelper2 = NodeHelper.INSTANCE;
        ViewPager viewPager = ((AppNodeCommunityHeaderBinding) getBinding()).imageViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.imageViewPager");
        IndicatorView indicatorView = ((AppNodeCommunityHeaderBinding) getBinding()).indicatorView;
        Intrinsics.checkNotNullExpressionValue(indicatorView, "binding.indicatorView");
        String[] strArr = new String[1];
        String cover = serviceApp.getCover();
        if (cover == null) {
            cover = "";
        }
        Intrinsics.checkNotNullExpressionValue(cover, "data.cover\n                ?: \"\"");
        strArr[0] = cover;
        nodeHelper2.setupIndicatorAndViewPager(viewPager, indicatorView, CollectionsKt.mutableListOf(strArr), new AppNodeCommunityViewPart$onBindToContent$1(ImageArgs.Companion));
        List<User> recentFollowList = serviceApp.getRecentFollowList();
        if (recentFollowList != null) {
            ArrayList arrayList2 = new ArrayList();
            for (T t : recentFollowList) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                arrayList2.add(t.getUserAvatar());
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        getTripleViewPart().bindToContent(arrayList != null ? arrayList : CollectionsKt.emptyList());
        TransitionManager.beginDelayedTransition(((AppNodeCommunityHeaderBinding) getBinding()).itemView);
        ((AppNodeCommunityHeaderBinding) getBinding()).setModel(this.viewModel);
        ((AppNodeCommunityHeaderBinding) getBinding()).executePendingBindings();
        CoolEllipsizeTextView coolEllipsizeTextView = ((AppNodeCommunityHeaderBinding) getBinding()).introduceView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.introduceView");
        CoolEllipsizeTextView coolEllipsizeTextView2 = coolEllipsizeTextView;
        if (!ViewCompat.isLaidOut(coolEllipsizeTextView2) || coolEllipsizeTextView2.isLayoutRequested()) {
            coolEllipsizeTextView2.addOnLayoutChangeListener(new AppNodeCommunityViewPart$onBindToContent$$inlined$doOnLayout$1(this));
            return;
        }
        CoolEllipsizeTextView coolEllipsizeTextView3 = ((AppNodeCommunityHeaderBinding) getBinding()).introduceView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView3, "binding.introduceView");
        if (!coolEllipsizeTextView3.isCollapsing()) {
            LinearLayout linearLayout = ((AppNodeCommunityHeaderBinding) getBinding()).introduceActionView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.introduceActionView");
            linearLayout.setVisibility(8);
            ((AppNodeCommunityHeaderBinding) getBinding()).introductionLayout.setOnClickListener(null);
        }
    }

    @Override // com.coolapk.market.view.node.app.BaseAppNodeViewPart
    public void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        if (serviceApp != null) {
            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get() ?: return");
            MaxWidthFrameLayout maxWidthFrameLayout = ((AppNodeCommunityHeaderBinding) getBinding()).coverViewContainer;
            String cover = serviceApp.getCover();
            if (cover == null || StringsKt.isBlank(cover)) {
                MaxWidthFrameLayout maxWidthFrameLayout2 = maxWidthFrameLayout;
                ViewGroup.LayoutParams layoutParams = maxWidthFrameLayout2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UiUtils.getActionBarSize(maxWidthFrameLayout.getContext()) + rect.top;
                    maxWidthFrameLayout2.setLayoutParams(layoutParams);
                    maxWidthFrameLayout2.setVisibility(4);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            MaxWidthFrameLayout maxWidthFrameLayout3 = maxWidthFrameLayout;
            ViewGroup.LayoutParams layoutParams2 = maxWidthFrameLayout3.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = NumberExtendsKt.getDp((Number) 203);
                maxWidthFrameLayout3.setLayoutParams(layoutParams2);
                maxWidthFrameLayout3.setVisibility(0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        switch (view.getId()) {
            case 2131362578:
                ServiceApp serviceApp = this.viewModel.getServiceApp().get();
                Intrinsics.checkNotNull(serviceApp);
                Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
                boolean z = this.viewModel.isFollow().get();
                boolean z2 = !z;
                this.presenter.followApp(serviceApp.getApkId(), z, z2);
                this.viewModel.isFollow().set(z2);
                return;
            case 2131362584:
                Context context = getContext();
                ServiceApp serviceApp2 = this.viewModel.getServiceApp().get();
                Intrinsics.checkNotNull(serviceApp2);
                Intrinsics.checkNotNullExpressionValue(serviceApp2, "viewModel.serviceApp.get()!!");
                ActionManager.startAppFollowerListActivity(context, serviceApp2.getApkId());
                return;
            case 2131362746:
                this.viewModel.getShowAllIntroduce().set(!this.viewModel.getShowAllIntroduce().get());
                return;
            case 2131362889:
                ServiceApp serviceApp3 = this.viewModel.getServiceApp().get();
                Intrinsics.checkNotNull(serviceApp3);
                Intrinsics.checkNotNullExpressionValue(serviceApp3, "viewModel.serviceApp.get()!!");
                ActionManager.startPhotoViewActivity(((AppNodeCommunityHeaderBinding) getBinding()).logoView, serviceApp3.getLogo(), null);
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.node.app.BaseAppNodeViewPart
    public void loadLogoAndBG(ServiceApp serviceApp, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(serviceApp, "data");
        Intrinsics.checkNotNullParameter(function2, "callback");
        String cover = serviceApp.getCover();
        AppNodeCommunityViewPart$loadLogoAndBG$wrapCallback$1 appNodeCommunityViewPart$loadLogoAndBG$wrapCallback$1 = new AppNodeCommunityViewPart$loadLogoAndBG$wrapCallback$1(this, !(cover == null || StringsKt.isBlank(cover)), function2);
        Integer stringToColor = ColorUtils.stringToColor(serviceApp.getBgColor());
        if (stringToColor != null) {
            Pair<Integer, Integer> nodeColors = NodePaletteBackgroundTarget.Companion.getNodeColors(stringToColor.intValue());
            int intValue = nodeColors.component1().intValue();
            int intValue2 = nodeColors.component2().intValue();
            View view = ((AppNodeCommunityHeaderBinding) getBinding()).backgroundTopView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.backgroundTopView");
            view.setBackground(NodePaletteBackgroundTarget.Companion.createShapeDrawable(intValue, intValue2));
            appNodeCommunityViewPart$loadLogoAndBG$wrapCallback$1.invoke((AppNodeCommunityViewPart$loadLogoAndBG$wrapCallback$1) Integer.valueOf(intValue), Integer.valueOf(intValue2));
            return;
        }
        GlideRequest priority = GlideApp.with(this.activity).as(PaletteBitmap.class).load(serviceApp.getLogo()).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE);
        View view2 = ((AppNodeCommunityHeaderBinding) getBinding()).backgroundTopView;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.backgroundTopView");
        Intrinsics.checkNotNullExpressionValue(priority.into((GlideRequest) new NodePaletteBackgroundTarget(view2, ((AppNodeCommunityHeaderBinding) getBinding()).backgroundBottomView, false, appNodeCommunityViewPart$loadLogoAndBG$wrapCallback$1, 4, null)), "GlideApp.with(activity)\n…callback = wrapCallback))");
    }
}
