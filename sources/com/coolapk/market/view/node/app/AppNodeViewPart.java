package com.coolapk.market.view.node.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.percentlayout.widget.PercentFrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.AppNodeHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.NewHeadLine;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.User;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.main.SceneRelatedAppsHelper;
import com.coolapk.market.view.main.SceneRelatedAppsViewPart;
import com.coolapk.market.view.node.BitmapSizeTransformation;
import com.coolapk.market.view.node.NodeHelper;
import com.coolapk.market.view.node.NodePaletteBackgroundTarget;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.IndicatorView;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.viewpart.TripleAvatarViewPart;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00056789:B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\"H\u0002J*\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0018\u0010)\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\"0*H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0014J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0016J\u001a\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020\"H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeViewPart;", "Lcom/coolapk/market/view/node/app/BaseAppNodeViewPart;", "Lcom/coolapk/market/databinding/AppNodeHeaderBinding;", "activity", "Landroid/app/Activity;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "presenter", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "(Landroid/app/Activity;Lcom/coolapk/market/view/node/app/AppNodeViewModel;Lcom/coolapk/market/view/node/app/AppNodePresenter;)V", "categoryAdapter", "Lcom/coolapk/market/view/node/app/AppNodeViewPart$CategoryAdapter;", "component", "Lcom/coolapk/market/binding/ContextBindingComponent;", "couponAdapter", "Lcom/coolapk/market/view/node/app/AppNodeViewPart$CouponAdapter;", "giftAdapter", "Lcom/coolapk/market/view/node/app/AppNodeViewPart$GiftAdapter;", "relateAppAdapter", "Lcom/coolapk/market/view/node/app/AppNodeViewPart$RelateAppAdapter;", "sceneRelatedAppsViewPart", "Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart;", "getSceneRelatedAppsViewPart", "()Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart;", "sceneRelatedAppsViewPart$delegate", "Lkotlin/Lazy;", "thumbnailAdapter", "Lcom/coolapk/market/view/node/app/AppNodeViewPart$ThumbnailAdapter;", "tripleViewPart", "Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "getTripleViewPart", "()Lcom/coolapk/market/widget/viewpart/TripleAvatarViewPart;", "tripleViewPart$delegate", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "bindRatingContent", "loadLogoAndBG", "data", "Lcom/coolapk/market/model/ServiceApp;", "callback", "Lkotlin/Function2;", "", "onBindToContent", "onClick", "view", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "CategoryAdapter", "CouponAdapter", "GiftAdapter", "RelateAppAdapter", "ThumbnailAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeViewPart.kt */
public final class AppNodeViewPart extends BaseAppNodeViewPart<AppNodeHeaderBinding> {
    private final Activity activity;
    private final CategoryAdapter categoryAdapter;
    private final ContextBindingComponent component;
    private final CouponAdapter couponAdapter;
    private final GiftAdapter giftAdapter;
    private final AppNodePresenter presenter;
    private final RelateAppAdapter relateAppAdapter;
    private final Lazy sceneRelatedAppsViewPart$delegate = LazyKt.lazy(new AppNodeViewPart$sceneRelatedAppsViewPart$2(this));
    private final ThumbnailAdapter thumbnailAdapter;
    private final Lazy tripleViewPart$delegate = LazyKt.lazy(new AppNodeViewPart$tripleViewPart$2(this));
    private final AppNodeViewModel viewModel;

    /* access modifiers changed from: private */
    public final SceneRelatedAppsViewPart getSceneRelatedAppsViewPart() {
        return (SceneRelatedAppsViewPart) this.sceneRelatedAppsViewPart$delegate.getValue();
    }

    private final TripleAvatarViewPart getTripleViewPart() {
        return (TripleAvatarViewPart) this.tripleViewPart$delegate.getValue();
    }

    public AppNodeViewPart(Activity activity2, AppNodeViewModel appNodeViewModel, AppNodePresenter appNodePresenter) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(appNodePresenter, "presenter");
        this.activity = activity2;
        this.viewModel = appNodeViewModel;
        this.presenter = appNodePresenter;
        this.thumbnailAdapter = new ThumbnailAdapter(appNodeViewModel);
        this.categoryAdapter = new CategoryAdapter(appNodeViewModel);
        this.relateAppAdapter = new RelateAppAdapter(appNodeViewModel);
        this.giftAdapter = new GiftAdapter(appNodeViewModel);
        this.couponAdapter = new CouponAdapter(appNodeViewModel);
        this.component = new ContextBindingComponent(activity2);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public AppNodeHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558465, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (AppNodeHeaderBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((AppNodeHeaderBinding) getBinding()).setClick(this);
        TextView textView = ((AppNodeHeaderBinding) getBinding()).scoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreView");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(getContext()));
        RoundedImageView roundedImageView = ((AppNodeHeaderBinding) getBinding()).logoView;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "binding.logoView");
        ViewExtendsKt.darkForegroundIfNeed(roundedImageView);
        BaseMultiTypeAdapter.register$default(this.thumbnailAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558600).suitedClass(String.class).constructor(new AppNodeViewPart$onViewCreated$1(this)).build(), 0, 2, null);
        RecyclerView recyclerView = ((AppNodeHeaderBinding) getBinding()).thumbnailList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.thumbnailList");
        recyclerView.setAdapter(this.thumbnailAdapter);
        RecyclerView recyclerView2 = ((AppNodeHeaderBinding) getBinding()).thumbnailList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.thumbnailList");
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        RecyclerViewDivider build = RecyclerViewDivider.Companion.with(this.activity).asSpace().size(NumberExtendsKt.getDp((Number) 8)).hideLastDivider().build();
        RecyclerView recyclerView3 = ((AppNodeHeaderBinding) getBinding()).thumbnailList;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.thumbnailList");
        build.addTo(recyclerView3);
        BaseMultiTypeAdapter.register$default(this.categoryAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558599).suitedClass(String.class).constructor(new AppNodeViewPart$onViewCreated$2(this)).build(), 0, 2, null);
        RecyclerView recyclerView4 = ((AppNodeHeaderBinding) getBinding()).categoryList;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.categoryList");
        recyclerView4.setAdapter(this.categoryAdapter);
        RecyclerView recyclerView5 = ((AppNodeHeaderBinding) getBinding()).categoryList;
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.categoryList");
        recyclerView5.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        RecyclerViewDivider build2 = RecyclerViewDivider.Companion.with(this.activity).asSpace().size(NumberExtendsKt.getDp((Number) 10)).hideLastDivider().build();
        RecyclerView recyclerView6 = ((AppNodeHeaderBinding) getBinding()).categoryList;
        Intrinsics.checkNotNullExpressionValue(recyclerView6, "binding.categoryList");
        build2.addTo(recyclerView6);
        BaseMultiTypeAdapter.register$default(this.relateAppAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558942).suitedClass(ServiceApp.class).constructor(new AppNodeViewPart$onViewCreated$3(this)).doAfterBind(AppNodeViewPart$onViewCreated$4.INSTANCE).build(), 0, 2, null);
        RecyclerView recyclerView7 = ((AppNodeHeaderBinding) getBinding()).relateAppList;
        Intrinsics.checkNotNullExpressionValue(recyclerView7, "binding.relateAppList");
        recyclerView7.setAdapter(this.relateAppAdapter);
        RecyclerView recyclerView8 = ((AppNodeHeaderBinding) getBinding()).relateAppList;
        Intrinsics.checkNotNullExpressionValue(recyclerView8, "binding.relateAppList");
        recyclerView8.setLayoutManager(new LinearLayoutManager(this.activity, 0, false));
        BaseMultiTypeAdapter.register$default(this.giftAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558598).suitedClass(Gift.class).constructor(new AppNodeViewPart$onViewCreated$5(this)).build(), 0, 2, null);
        RecyclerView recyclerView9 = ((AppNodeHeaderBinding) getBinding()).giftList;
        Intrinsics.checkNotNullExpressionValue(recyclerView9, "binding.giftList");
        recyclerView9.setAdapter(this.giftAdapter);
        RecyclerView recyclerView10 = ((AppNodeHeaderBinding) getBinding()).giftList;
        Intrinsics.checkNotNullExpressionValue(recyclerView10, "binding.giftList");
        recyclerView10.setLayoutManager(new LinearLayoutManager(this.activity));
        BaseMultiTypeAdapter.register$default(this.couponAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558597).suitedClass(CouponInfo.class).constructor(new AppNodeViewPart$onViewCreated$6(this)).build(), 0, 2, null);
        RecyclerView recyclerView11 = ((AppNodeHeaderBinding) getBinding()).couponList;
        Intrinsics.checkNotNullExpressionValue(recyclerView11, "binding.couponList");
        recyclerView11.setAdapter(this.couponAdapter);
        RecyclerView recyclerView12 = ((AppNodeHeaderBinding) getBinding()).couponList;
        Intrinsics.checkNotNullExpressionValue(recyclerView12, "binding.couponList");
        recyclerView12.setLayoutManager(new LinearLayoutManager(this.activity));
        this.viewModel.getCouponList().addOnListChangedCallback(new AdapterListChangedCallback(this.couponAdapter));
        this.viewModel.getSceneRelatedHelper().addOnCardChangedCallback(new AppNodeViewPart$onViewCreated$7(this));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0051: APUT  (r3v3 java.lang.String[]), (0 ??[int, short, byte, char]), (r4v1 java.lang.String) */
    /* access modifiers changed from: protected */
    public void onBindToContent(ServiceApp serviceApp) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(serviceApp, "data");
        super.onBindToContent((AppNodeViewPart) serviceApp);
        NodeHelper nodeHelper = NodeHelper.INSTANCE;
        LinearAdapterLayout linearAdapterLayout = ((AppNodeHeaderBinding) getBinding()).linearView;
        Intrinsics.checkNotNullExpressionValue(linearAdapterLayout, "binding.linearView");
        List<NewHeadLine> recommendRows = serviceApp.getRecommendRows();
        Intrinsics.checkNotNullExpressionValue(recommendRows, "data.recommendRows");
        nodeHelper.setupRecommendRows(linearAdapterLayout, recommendRows);
        NodeHelper nodeHelper2 = NodeHelper.INSTANCE;
        ViewPager viewPager = ((AppNodeHeaderBinding) getBinding()).imageViewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.imageViewPager");
        IndicatorView indicatorView = ((AppNodeHeaderBinding) getBinding()).indicatorView;
        Intrinsics.checkNotNullExpressionValue(indicatorView, "binding.indicatorView");
        String[] strArr = new String[1];
        String cover = serviceApp.getCover();
        if (cover == null) {
            cover = "";
        }
        Intrinsics.checkNotNullExpressionValue(cover, "data.cover\n                ?: \"\"");
        strArr[0] = cover;
        nodeHelper2.setupIndicatorAndViewPager(viewPager, indicatorView, CollectionsKt.mutableListOf(strArr), new AppNodeViewPart$onBindToContent$1(ImageArgs.Companion));
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
        TransitionManager.beginDelayedTransition(((AppNodeHeaderBinding) getBinding()).itemView);
        ((AppNodeHeaderBinding) getBinding()).setModel(this.viewModel);
        ((AppNodeHeaderBinding) getBinding()).executePendingBindings();
        this.thumbnailAdapter.notifyDataSetChanged();
        this.categoryAdapter.notifyDataSetChanged();
        this.relateAppAdapter.notifyDataSetChanged();
        this.giftAdapter.notifyDataSetChanged();
        CoolEllipsizeTextView coolEllipsizeTextView = ((AppNodeHeaderBinding) getBinding()).changeLogView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.changeLogView");
        CoolEllipsizeTextView coolEllipsizeTextView2 = coolEllipsizeTextView;
        if (!ViewCompat.isLaidOut(coolEllipsizeTextView2) || coolEllipsizeTextView2.isLayoutRequested()) {
            coolEllipsizeTextView2.addOnLayoutChangeListener(new AppNodeViewPart$onBindToContent$$inlined$doOnLayout$1(this));
        } else {
            CoolEllipsizeTextView coolEllipsizeTextView3 = ((AppNodeHeaderBinding) getBinding()).changeLogView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView3, "binding.changeLogView");
            if (!coolEllipsizeTextView3.isCollapsing()) {
                LinearLayout linearLayout = ((AppNodeHeaderBinding) getBinding()).changeLogActionView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.changeLogActionView");
                linearLayout.setVisibility(8);
                ((AppNodeHeaderBinding) getBinding()).changeLogLayout.setOnClickListener(null);
            }
        }
        CoolEllipsizeTextView coolEllipsizeTextView4 = ((AppNodeHeaderBinding) getBinding()).introduceView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView4, "binding.introduceView");
        CoolEllipsizeTextView coolEllipsizeTextView5 = coolEllipsizeTextView4;
        if (!ViewCompat.isLaidOut(coolEllipsizeTextView5) || coolEllipsizeTextView5.isLayoutRequested()) {
            coolEllipsizeTextView5.addOnLayoutChangeListener(new AppNodeViewPart$onBindToContent$$inlined$doOnLayout$2(this));
        } else {
            CoolEllipsizeTextView coolEllipsizeTextView6 = ((AppNodeHeaderBinding) getBinding()).introduceView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView6, "binding.introduceView");
            if (!coolEllipsizeTextView6.isCollapsing()) {
                LinearLayout linearLayout2 = ((AppNodeHeaderBinding) getBinding()).introduceActionView;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.introduceActionView");
                linearLayout2.setVisibility(8);
                ((AppNodeHeaderBinding) getBinding()).introductionLayout.setOnClickListener(null);
            }
        }
        ActionButton.bindWithApp$default(((AppNodeHeaderBinding) getBinding()).actionButton, serviceApp, false, 2, null);
        bindRatingContent();
    }

    @Override // com.coolapk.market.view.node.app.BaseAppNodeViewPart
    public void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        if (serviceApp != null) {
            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get() ?: return");
            MaxWidthFrameLayout maxWidthFrameLayout = ((AppNodeHeaderBinding) getBinding()).coverViewContainer;
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

    private final void bindRatingContent() {
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        if (serviceApp != null) {
            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get() ?: return");
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            AppNodeViewPart$bindRatingContent$1 appNodeViewPart$bindRatingContent$1 = AppNodeViewPart$bindRatingContent$1.INSTANCE;
            AppNodeViewPart$bindRatingContent$2 appNodeViewPart$bindRatingContent$2 = new AppNodeViewPart$bindRatingContent$2(0.01f, intRef);
            int votenum1 = serviceApp.getVotenum1();
            int votenum2 = serviceApp.getVotenum2();
            int votenum3 = serviceApp.getVotenum3();
            int votenum4 = serviceApp.getVotenum4();
            int votenum5 = serviceApp.getVotenum5();
            TextView textView = ((AppNodeHeaderBinding) getBinding()).rateNum1;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.rateNum1");
            textView.setText(String.valueOf(votenum1));
            TextView textView2 = ((AppNodeHeaderBinding) getBinding()).rateNum2;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.rateNum2");
            textView2.setText(String.valueOf(votenum2));
            TextView textView3 = ((AppNodeHeaderBinding) getBinding()).rateNum3;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.rateNum3");
            textView3.setText(String.valueOf(votenum3));
            TextView textView4 = ((AppNodeHeaderBinding) getBinding()).rateNum4;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.rateNum4");
            textView4.setText(String.valueOf(votenum4));
            TextView textView5 = ((AppNodeHeaderBinding) getBinding()).rateNum5;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.rateNum5");
            textView5.setText(String.valueOf(votenum5));
            intRef.element = appNodeViewPart$bindRatingContent$1.invoke(new int[]{votenum1, votenum2, votenum3, votenum4, votenum5});
            ImageView imageView = ((AppNodeHeaderBinding) getBinding()).ratingImageView1;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ratingImageView1");
            ImageView imageView2 = imageView;
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
            PercentFrameLayout.LayoutParams layoutParams2 = (PercentFrameLayout.LayoutParams) layoutParams;
            layoutParams2.getPercentLayoutInfo().widthPercent = appNodeViewPart$bindRatingContent$2.invoke(votenum1);
            imageView2.setLayoutParams(layoutParams2);
            ImageView imageView3 = ((AppNodeHeaderBinding) getBinding()).ratingImageView2;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ratingImageView2");
            ImageView imageView4 = imageView3;
            ViewGroup.LayoutParams layoutParams3 = imageView4.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
            PercentFrameLayout.LayoutParams layoutParams4 = (PercentFrameLayout.LayoutParams) layoutParams3;
            layoutParams4.getPercentLayoutInfo().widthPercent = appNodeViewPart$bindRatingContent$2.invoke(votenum2);
            imageView4.setLayoutParams(layoutParams4);
            ImageView imageView5 = ((AppNodeHeaderBinding) getBinding()).ratingImageView3;
            Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ratingImageView3");
            ImageView imageView6 = imageView5;
            ViewGroup.LayoutParams layoutParams5 = imageView6.getLayoutParams();
            Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
            PercentFrameLayout.LayoutParams layoutParams6 = (PercentFrameLayout.LayoutParams) layoutParams5;
            layoutParams6.getPercentLayoutInfo().widthPercent = appNodeViewPart$bindRatingContent$2.invoke(votenum3);
            imageView6.setLayoutParams(layoutParams6);
            ImageView imageView7 = ((AppNodeHeaderBinding) getBinding()).ratingImageView4;
            Intrinsics.checkNotNullExpressionValue(imageView7, "binding.ratingImageView4");
            ImageView imageView8 = imageView7;
            ViewGroup.LayoutParams layoutParams7 = imageView8.getLayoutParams();
            Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
            PercentFrameLayout.LayoutParams layoutParams8 = (PercentFrameLayout.LayoutParams) layoutParams7;
            layoutParams8.getPercentLayoutInfo().widthPercent = appNodeViewPart$bindRatingContent$2.invoke(votenum4);
            imageView8.setLayoutParams(layoutParams8);
            ImageView imageView9 = ((AppNodeHeaderBinding) getBinding()).ratingImageView5;
            Intrinsics.checkNotNullExpressionValue(imageView9, "binding.ratingImageView5");
            ImageView imageView10 = imageView9;
            ViewGroup.LayoutParams layoutParams9 = imageView10.getLayoutParams();
            Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type androidx.percentlayout.widget.PercentFrameLayout.LayoutParams");
            PercentFrameLayout.LayoutParams layoutParams10 = (PercentFrameLayout.LayoutParams) layoutParams9;
            layoutParams10.getPercentLayoutInfo().widthPercent = appNodeViewPart$bindRatingContent$2.invoke(votenum5);
            imageView10.setLayoutParams(layoutParams10);
            ((AppNodeHeaderBinding) getBinding()).executePendingBindings();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        switch (view.getId()) {
            case 2131361877:
                ActionButton actionButton = ((AppNodeHeaderBinding) getBinding()).actionButton;
                Intrinsics.checkNotNullExpressionValue(actionButton, "binding.actionButton");
                CharSequence text = actionButton.getText();
                Intrinsics.checkNotNullExpressionValue(text, "binding.actionButton.text");
                String string = getContext().getString(2131886128);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.action_download)");
                if (StringsKt.startsWith$default(text, (CharSequence) string, false, 2, (Object) null)) {
                    SceneRelatedAppsHelper sceneRelatedHelper = this.viewModel.getSceneRelatedHelper();
                    ServiceApp serviceApp = this.viewModel.getServiceApp().get();
                    Intrinsics.checkNotNull(serviceApp);
                    Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
                    sceneRelatedHelper.loadCard(serviceApp);
                }
                this.viewModel.startDownload(view);
                return;
            case 2131361880:
                Toast.show$default(getContext(), "应用暂未上架，还不能下载哦~", 0, false, 12, null);
                return;
            case 2131362222:
                this.viewModel.getShowAllChangeLog().set(!this.viewModel.getShowAllChangeLog().get());
                return;
            case 2131362337:
                this.viewModel.getShowAllCoupon().set(true);
                return;
            case 2131362393:
                ServiceApp serviceApp2 = this.viewModel.getServiceApp().get();
                if (serviceApp2 != null) {
                    Intrinsics.checkNotNullExpressionValue(serviceApp2, "it");
                    User developerProfile = serviceApp2.getDeveloperProfile();
                    Intrinsics.checkNotNull(developerProfile);
                    Intrinsics.checkNotNullExpressionValue(developerProfile, "it.developerProfile!!");
                    String uid = developerProfile.getUid();
                    User developerProfile2 = serviceApp2.getDeveloperProfile();
                    Intrinsics.checkNotNull(developerProfile2);
                    Intrinsics.checkNotNullExpressionValue(developerProfile2, "it.developerProfile!!");
                    ActionManager.startUserSpaceActivity(((AppNodeHeaderBinding) getBinding()).avatarView, uid, developerProfile2.getUserAvatar());
                    return;
                }
                return;
            case 2131362586:
                ServiceApp serviceApp3 = this.viewModel.getServiceApp().get();
                Intrinsics.checkNotNull(serviceApp3);
                Intrinsics.checkNotNullExpressionValue(serviceApp3, "viewModel.serviceApp.get()!!");
                boolean z = this.viewModel.isFollow().get();
                boolean z2 = !z;
                this.presenter.followApp(serviceApp3.getApkId(), z, z2);
                this.viewModel.isFollow().set(z2);
                return;
            case 2131362592:
                Context context = getContext();
                ServiceApp serviceApp4 = this.viewModel.getServiceApp().get();
                Intrinsics.checkNotNull(serviceApp4);
                Intrinsics.checkNotNullExpressionValue(serviceApp4, "viewModel.serviceApp.get()!!");
                ActionManager.startAppFollowerListActivity(context, serviceApp4.getApkId());
                return;
            case 2131362618:
                ServiceApp serviceApp5 = this.viewModel.getServiceApp().get();
                if (serviceApp5 != null) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(serviceApp5, "it");
                    ActionManager.startGiftListActivity(context2, serviceApp5.getApkId(), serviceApp5.getAppName());
                    return;
                }
                return;
            case 2131362757:
                this.viewModel.getShowAllIntroduce().set(!this.viewModel.getShowAllIntroduce().get());
                return;
            case 2131362900:
                ServiceApp serviceApp6 = this.viewModel.getServiceApp().get();
                Intrinsics.checkNotNull(serviceApp6);
                Intrinsics.checkNotNullExpressionValue(serviceApp6, "viewModel.serviceApp.get()!!");
                ActionManager.startPhotoViewActivity(((AppNodeHeaderBinding) getBinding()).logoView, serviceApp6.getLogo(), null);
                return;
            case 2131363228:
                ServiceApp serviceApp7 = this.viewModel.getServiceApp().get();
                if (serviceApp7 != null) {
                    Context context3 = getContext();
                    StringBuilder sb = new StringBuilder();
                    Intrinsics.checkNotNullExpressionValue(serviceApp7, "it");
                    sb.append(serviceApp7.getAppName());
                    sb.append("的评分");
                    ActionManager.startNodeRatingListActivity(context3, sb.toString(), "1", serviceApp7.getApkId(), String.valueOf(serviceApp7.getVersionCode()));
                    return;
                }
                return;
            case 2131363242:
                ServiceApp serviceApp8 = this.viewModel.getServiceApp().get();
                if (serviceApp8 != null) {
                    Context context4 = getContext();
                    Intrinsics.checkNotNullExpressionValue(serviceApp8, "it");
                    ActionManager.startRelatedAppsActivity(context4, serviceApp8.getKeywords());
                    return;
                }
                return;
            case 2131363291:
                AppNodePresenter.ratingAppV10$default(this.presenter, this.viewModel, this.activity, 0, true, 4, null);
                return;
            case 2131363292:
                Toast.show$default(getContext(), "应用暂未上架，还不能写点评哦~", 0, false, 12, null);
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
        AppNodeViewPart$loadLogoAndBG$wrapCallback$1 appNodeViewPart$loadLogoAndBG$wrapCallback$1 = new AppNodeViewPart$loadLogoAndBG$wrapCallback$1(this, !(cover == null || StringsKt.isBlank(cover)), function2);
        Integer stringToColor = ColorUtils.stringToColor(serviceApp.getBgColor());
        if (stringToColor != null) {
            Pair<Integer, Integer> nodeColors = NodePaletteBackgroundTarget.Companion.getNodeColors(stringToColor.intValue());
            int intValue = nodeColors.component1().intValue();
            int intValue2 = nodeColors.component2().intValue();
            View view = ((AppNodeHeaderBinding) getBinding()).backgroundTopView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.backgroundTopView");
            view.setBackground(NodePaletteBackgroundTarget.Companion.createShapeDrawable(intValue, intValue2));
            appNodeViewPart$loadLogoAndBG$wrapCallback$1.invoke((AppNodeViewPart$loadLogoAndBG$wrapCallback$1) Integer.valueOf(intValue), Integer.valueOf(intValue2));
            return;
        }
        GlideRequest priority = GlideApp.with(this.activity).as(PaletteBitmap.class).load(serviceApp.getLogo()).transform((Transformation<Bitmap>) new BitmapSizeTransformation(24, 24)).priority(Priority.IMMEDIATE);
        View view2 = ((AppNodeHeaderBinding) getBinding()).backgroundTopView;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.backgroundTopView");
        Intrinsics.checkNotNullExpressionValue(priority.into((GlideRequest) new NodePaletteBackgroundTarget(view2, ((AppNodeHeaderBinding) getBinding()).backgroundBottomView, false, appNodeViewPart$loadLogoAndBG$wrapCallback$1, 4, null)), "GlideApp.with(activity)\n…callback = wrapCallback))");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeViewPart$ThumbnailAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "getViewModel", "()Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNodeViewPart.kt */
    private static final class ThumbnailAdapter extends BaseMultiTypeAdapter {
        private final AppNodeViewModel viewModel;

        public ThumbnailAdapter(AppNodeViewModel appNodeViewModel) {
            Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
            this.viewModel = appNodeViewModel;
        }

        public final AppNodeViewModel getViewModel() {
            return this.viewModel;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            List<String> thumbList;
            ServiceApp serviceApp = this.viewModel.getServiceApp().get();
            if (serviceApp == null || (thumbList = serviceApp.getThumbList()) == null) {
                return null;
            }
            return thumbList.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> thumbList;
            ServiceApp serviceApp = this.viewModel.getServiceApp().get();
            if (serviceApp == null || (thumbList = serviceApp.getThumbList()) == null) {
                return 0;
            }
            return thumbList.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeViewPart$CategoryAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "getViewModel", "()Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNodeViewPart.kt */
    private static final class CategoryAdapter extends BaseMultiTypeAdapter {
        private final AppNodeViewModel viewModel;

        public CategoryAdapter(AppNodeViewModel appNodeViewModel) {
            Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
            this.viewModel = appNodeViewModel;
        }

        public final AppNodeViewModel getViewModel() {
            return this.viewModel;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            return this.viewModel.getAppTagList().get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.viewModel.getAppTagList().size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeViewPart$RelateAppAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "getViewModel", "()Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNodeViewPart.kt */
    private static final class RelateAppAdapter extends BaseMultiTypeAdapter {
        private final AppNodeViewModel viewModel;

        public RelateAppAdapter(AppNodeViewModel appNodeViewModel) {
            Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
            this.viewModel = appNodeViewModel;
        }

        public final AppNodeViewModel getViewModel() {
            return this.viewModel;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            List<ServiceApp> relatedRows;
            ServiceApp serviceApp = this.viewModel.getServiceApp().get();
            if (serviceApp == null || (relatedRows = serviceApp.getRelatedRows()) == null) {
                return null;
            }
            return relatedRows.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<ServiceApp> relatedRows;
            ServiceApp serviceApp = this.viewModel.getServiceApp().get();
            if (serviceApp == null || (relatedRows = serviceApp.getRelatedRows()) == null) {
                return 0;
            }
            return relatedRows.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeViewPart$GiftAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "getViewModel", "()Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNodeViewPart.kt */
    private static final class GiftAdapter extends BaseMultiTypeAdapter {
        private final AppNodeViewModel viewModel;

        public GiftAdapter(AppNodeViewModel appNodeViewModel) {
            Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
            this.viewModel = appNodeViewModel;
        }

        public final AppNodeViewModel getViewModel() {
            return this.viewModel;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            List<Gift> giftRows;
            ServiceApp serviceApp = this.viewModel.getServiceApp().get();
            if (serviceApp == null || (giftRows = serviceApp.getGiftRows()) == null) {
                return null;
            }
            return giftRows.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Gift> giftRows;
            ServiceApp serviceApp = this.viewModel.getServiceApp().get();
            if (serviceApp == null || (giftRows = serviceApp.getGiftRows()) == null) {
                return 0;
            }
            return giftRows.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeViewPart$CouponAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "getViewModel", "()Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNodeViewPart.kt */
    private static final class CouponAdapter extends BaseMultiTypeAdapter {
        private final AppNodeViewModel viewModel;

        public CouponAdapter(AppNodeViewModel appNodeViewModel) {
            Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
            this.viewModel = appNodeViewModel;
        }

        public final AppNodeViewModel getViewModel() {
            return this.viewModel;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            return this.viewModel.getCouponList().get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return Math.min(this.viewModel.getShowAllCoupon().get() ? Integer.MAX_VALUE : 3, this.viewModel.getCouponList().size());
        }
    }
}
