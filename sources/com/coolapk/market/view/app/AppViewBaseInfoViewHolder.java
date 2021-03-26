package com.coolapk.market.view.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.AppPhotoThumbnailBinding;
import com.coolapk.market.databinding.ItemAppViewBaseInfoBinding;
import com.coolapk.market.databinding.ItemAppViewBaseInfoCouponItemBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Gift;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.State;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.BlurTransform;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.RxLogin;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.app.AppViewContract;
import com.coolapk.market.view.app.AppViewViewModel;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.StateViewHolder;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import com.github.florent37.arclayout.ArcLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

/* compiled from: AppViewBaseInfoViewHolder.kt */
public final class AppViewBaseInfoViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558603;
    private final ItemAppViewBaseInfoBinding binding;
    private final CouponAdapter couponAdapter;
    private boolean isCoverLoaded;
    private final OnImageLoadListener onCoverImageLoadListener;
    private final OnImageLoadListener onPhotoImageLoadListener = new AppViewBaseInfoViewHolder$onPhotoImageLoadListener$1(this);
    private final PhotoAdapter photoAdapter;
    private final AppViewBaseInfoViewHolder$photoObserver$1 photoObserver;
    private final AppViewContract.Presenter presenter;
    private ServiceApp serviceApp;
    private final AppViewViewModel viewModel;

    public static final /* synthetic */ ServiceApp access$getServiceApp$p(AppViewBaseInfoViewHolder appViewBaseInfoViewHolder) {
        ServiceApp serviceApp2 = appViewBaseInfoViewHolder.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        return serviceApp2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppViewBaseInfoViewHolder(View view, DataBindingComponent dataBindingComponent, AppViewViewModel appViewViewModel, AppViewContract.Presenter presenter2) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(appViewViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(presenter2, "presenter");
        this.viewModel = appViewViewModel;
        this.presenter = presenter2;
        ItemAppViewBaseInfoBinding itemAppViewBaseInfoBinding = (ItemAppViewBaseInfoBinding) getBinding();
        this.binding = itemAppViewBaseInfoBinding;
        AppViewBaseInfoViewHolder$photoObserver$1 appViewBaseInfoViewHolder$photoObserver$1 = new AppViewBaseInfoViewHolder$photoObserver$1(this);
        this.photoObserver = appViewBaseInfoViewHolder$photoObserver$1;
        this.onCoverImageLoadListener = new AppViewBaseInfoViewHolder$onCoverImageLoadListener$1(this);
        PhotoAdapter photoAdapter2 = new PhotoAdapter();
        this.photoAdapter = photoAdapter2;
        CouponAdapter couponAdapter2 = new CouponAdapter();
        this.couponAdapter = couponAdapter2;
        RecyclerView recyclerView = itemAppViewBaseInfoBinding.thumbnailView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.thumbnailView");
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = itemAppViewBaseInfoBinding.thumbnailView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.thumbnailView");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView3 = itemAppViewBaseInfoBinding.thumbnailView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.thumbnailView");
        recyclerView3.setItemAnimator(null);
        ThemeUtils.setRatingBarColor(itemAppViewBaseInfoBinding.ratingBarAverage, Color.parseColor("#ffb712"));
        itemAppViewBaseInfoBinding.thumbnailView.addItemDecoration(ItemDecorations.horizontal(getContext()).first(2131231073).type(2131558601, 2131231073).last(2131231073).create());
        ColorDrawable colorDrawable = new ColorDrawable(AppHolder.getAppTheme().getColorAccent());
        colorDrawable.setAlpha(26);
        Drawable createSelectableItemBackgroundWith = ShapeUtils.createSelectableItemBackgroundWith(getContext(), colorDrawable);
        LinearLayout linearLayout = itemAppViewBaseInfoBinding.changeLogLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.changeLogLayout");
        Intrinsics.checkNotNullExpressionValue(createSelectableItemBackgroundWith, "colorAccentSelectableBackground");
        Drawable.ConstantState constantState = createSelectableItemBackgroundWith.getConstantState();
        Intrinsics.checkNotNull(constantState);
        linearLayout.setBackground(constantState.newDrawable());
        LinearLayout linearLayout2 = itemAppViewBaseInfoBinding.xposedPluginLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.xposedPluginLayout");
        Drawable.ConstantState constantState2 = createSelectableItemBackgroundWith.getConstantState();
        Intrinsics.checkNotNull(constantState2);
        linearLayout2.setBackground(constantState2.newDrawable());
        photoAdapter2.registerAdapterDataObserver(appViewBaseInfoViewHolder$photoObserver$1);
        RecyclerView recyclerView4 = itemAppViewBaseInfoBinding.thumbnailView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.thumbnailView");
        recyclerView4.setAdapter(photoAdapter2);
        appViewViewModel.addThumbnailCallback(photoAdapter2);
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecyclerViewDivider build = companion.with(context).size(NumberExtendsKt.getDp((Number) 8)).asSpace().hideLastDivider().build();
        RecyclerView recyclerView5 = itemAppViewBaseInfoBinding.couponList;
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.couponList");
        build.addTo(recyclerView5);
        RecyclerView recyclerView6 = itemAppViewBaseInfoBinding.couponList;
        Intrinsics.checkNotNullExpressionValue(recyclerView6, "binding.couponList");
        recyclerView6.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView7 = itemAppViewBaseInfoBinding.couponList;
        Intrinsics.checkNotNullExpressionValue(recyclerView7, "binding.couponList");
        recyclerView7.setAdapter(couponAdapter2);
        AppViewBaseInfoViewHolder appViewBaseInfoViewHolder = this;
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.moreView, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.xposedPluginLayout, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.actionFollow, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.actionRank, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.actionContainer, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.actionOpenWithPlay, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.detailClickLayout, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.logoView, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.allCouponView, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.giftLayout.allGiftView, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.giftLayout.fetchGiftView, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.giftLayout.fetchGiftView2, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.giftLayout.giftView, appViewBaseInfoViewHolder);
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.giftLayout.giftView2, appViewBaseInfoViewHolder);
        TextView textView = itemAppViewBaseInfoBinding.actionFollow;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionFollow");
        UiUtils.setDrawableStrokeColors(textView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        TextView textView2 = itemAppViewBaseInfoBinding.actionRank;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionRank");
        UiUtils.setDrawableStrokeColors(textView2.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        TextView textView3 = itemAppViewBaseInfoBinding.actionOpenWithPlay;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionOpenWithPlay");
        UiUtils.setDrawableStrokeColors(textView3.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        String logo = appViewViewModel.getLogo();
        Intrinsics.checkNotNullExpressionValue(itemAppViewBaseInfoBinding, "binding");
        loadCover(logo, itemAppViewBaseInfoBinding);
        int actionBarSize = UiUtils.getActionBarSize(getContext()) + UiUtils.getStatusBarHeight(getContext());
        ArcLayout arcLayout = itemAppViewBaseInfoBinding.arcLayout;
        Intrinsics.checkNotNullExpressionValue(arcLayout, "binding.arcLayout");
        arcLayout.getLayoutParams().height += actionBarSize;
        ImageView imageView = itemAppViewBaseInfoBinding.logoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = actionBarSize;
    }

    /* compiled from: AppViewBaseInfoViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        ServiceApp serviceApp2 = this.viewModel.getServiceApp();
        Intrinsics.checkNotNull(serviceApp2);
        this.serviceApp = serviceApp2;
        AppViewViewModel appViewViewModel = this.viewModel;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        appViewViewModel.setAppName(serviceApp2.getAppName());
        ItemAppViewBaseInfoBinding itemAppViewBaseInfoBinding = (ItemAppViewBaseInfoBinding) getBinding();
        RecyclerView recyclerView = itemAppViewBaseInfoBinding.thumbnailView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.thumbnailView");
        ServiceApp serviceApp3 = this.serviceApp;
        if (serviceApp3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        int i = 8;
        recyclerView.setVisibility(CollectionUtils.isEmpty(serviceApp3.getThumbList()) ? 8 : 0);
        Intrinsics.checkNotNullExpressionValue(itemAppViewBaseInfoBinding, "binding");
        itemAppViewBaseInfoBinding.setViewModel(this.viewModel);
        itemAppViewBaseInfoBinding.executePendingBindings();
        CouponAdapter couponAdapter2 = this.couponAdapter;
        ServiceApp serviceApp4 = this.serviceApp;
        if (serviceApp4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        couponAdapter2.setServiceApp(serviceApp4);
        ServiceApp serviceApp5 = this.serviceApp;
        if (serviceApp5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        List<CouponInfo> couponInfo = serviceApp5.getCouponInfo();
        ServiceApp serviceApp6 = this.serviceApp;
        if (serviceApp6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        if (!serviceApp6.getHasCoupon() || couponInfo == null || !(!couponInfo.isEmpty())) {
            LinearLayout linearLayout = itemAppViewBaseInfoBinding.couponLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.couponLayout");
            linearLayout.setVisibility(8);
        } else {
            RecyclerView recyclerView2 = itemAppViewBaseInfoBinding.couponList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.couponList");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(recyclerView2);
            if (marginParams != null) {
                marginParams.bottomMargin = NumberExtendsKt.getDp(couponInfo.size() > 3 ? 0 : 16);
            }
            LinearLayout linearLayout2 = itemAppViewBaseInfoBinding.allCouponView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.allCouponView");
            if (couponInfo.size() > 3) {
                i = 0;
            }
            linearLayout2.setVisibility(i);
            LinearLayout linearLayout3 = itemAppViewBaseInfoBinding.couponLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.couponLayout");
            linearLayout3.setVisibility(0);
            CouponAdapter couponAdapter3 = this.couponAdapter;
            if (couponInfo.size() > 3) {
                couponInfo = couponInfo.subList(0, 3);
            }
            couponAdapter3.setDataList(couponInfo);
            this.couponAdapter.notifyDataSetChanged();
        }
        TextView textView = itemAppViewBaseInfoBinding.changeLogContentView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.changeLogContentView");
        ViewExtendsKt.onceOnGlobalLayoutListener(textView, new AppViewBaseInfoViewHolder$bindTo$1(this, itemAppViewBaseInfoBinding));
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.changeLogLayout, new AppViewBaseInfoViewHolder$bindTo$2(this));
        ViewUtil.clickListener(itemAppViewBaseInfoBinding.introduceClickView, new AppViewBaseInfoViewHolder$bindTo$3(this));
    }

    private final void loadCover(String str, ItemAppViewBaseInfoBinding itemAppViewBaseInfoBinding) {
        if (!TextUtils.isEmpty(str) && !this.isCoverLoaded) {
            this.isCoverLoaded = true;
            ImageView imageView = itemAppViewBaseInfoBinding.coverView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.coverView");
            imageView.setVisibility(4);
            AppHolder.getContextImageLoader().displayImage(getContext(), str, itemAppViewBaseInfoBinding.coverView, ImageLoaderOptions.newBuilder().bitmapOnly(true).build(), this.onCoverImageLoadListener, (OnBitmapTransformListener) new BlurTransform());
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        int i = 0;
        switch (view.getId()) {
            case 2131361887:
                doAction(fragmentActivity, view);
                return;
            case 2131361910:
                RxLogin.getInstance(getContext()).requestLogin().subscribe((Subscriber<? super Boolean>) new AppViewBaseInfoViewHolder$onClick$2(this));
                return;
            case 2131361941:
                Context context2 = getContext();
                ServiceApp serviceApp2 = this.serviceApp;
                if (serviceApp2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                ActionManager.startExternalMarketByName(context2, null, null, serviceApp2.getPackageName());
                return;
            case 2131361949:
                RatingDialog newInstance = RatingDialog.newInstance();
                newInstance.setViewModel(this.viewModel);
                newInstance.setPresenter(this.presenter);
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(fragmentActivity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return;
            case 2131362051:
                ServiceApp serviceApp3 = this.serviceApp;
                if (serviceApp3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                List<CouponInfo> couponInfo = serviceApp3.getCouponInfo();
                CouponAdapter couponAdapter2 = this.couponAdapter;
                Intrinsics.checkNotNull(couponInfo);
                couponAdapter2.setDataList(couponInfo);
                this.couponAdapter.notifyDataSetChanged();
                LinearLayout linearLayout = this.binding.allCouponView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.allCouponView");
                linearLayout.setVisibility(8);
                RecyclerView recyclerView = this.binding.couponList;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.couponList");
                ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(recyclerView);
                if (marginParams != null) {
                    marginParams.bottomMargin = NumberExtendsKt.getDp((Number) 16);
                    return;
                }
                return;
            case 2131362053:
                Context context3 = getContext();
                ServiceApp serviceApp4 = this.serviceApp;
                if (serviceApp4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                String apkId = serviceApp4.getApkId();
                ServiceApp serviceApp5 = this.serviceApp;
                if (serviceApp5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                ActionManager.startGiftListActivity(context3, apkId, serviceApp5.getAppName());
                return;
            case 2131362390:
            case 2131362982:
                Context context4 = getContext();
                ServiceApp serviceApp6 = this.serviceApp;
                if (serviceApp6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                ActionManager.startAppDetailActivity(context4, serviceApp6);
                return;
            case 2131362555:
            case 2131362556:
                ServiceApp serviceApp7 = this.serviceApp;
                if (serviceApp7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                if (!CollectionUtils.isEmpty(serviceApp7.getGiftRows())) {
                    if (view.getId() != 2131362555) {
                        i = 1;
                    }
                    ServiceApp serviceApp8 = this.serviceApp;
                    if (serviceApp8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                    }
                    List<Gift> giftRows = serviceApp8.getGiftRows();
                    Intrinsics.checkNotNull(giftRows);
                    Gift gift = giftRows.get(i);
                    Intrinsics.checkNotNullExpressionValue(gift, "gift");
                    if (gift.isRequireInstalled()) {
                        Context context5 = getContext();
                        ServiceApp serviceApp9 = this.serviceApp;
                        if (serviceApp9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                        }
                        if (!PackageUtils.isInstalled(context5, serviceApp9.getPackageName())) {
                            SimpleDialog newInstance2 = SimpleDialog.newInstance();
                            newInstance2.setMessage(getContext().getString(2131886884));
                            newInstance2.setPositiveButton(2131886128, new AppViewBaseInfoViewHolder$onClick$1(this));
                            newInstance2.setNegativeButton(2131886115);
                            FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(fragmentActivity).getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.requireAppCompa…().supportFragmentManager");
                            newInstance2.show(supportFragmentManager2, (String) null);
                            return;
                        }
                    }
                    ServiceApp serviceApp10 = this.serviceApp;
                    if (serviceApp10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                    }
                    FetchGiftDialog newInstance3 = FetchGiftDialog.newInstance(gift, serviceApp10);
                    FragmentManager supportFragmentManager3 = ContextExtendsKt.requireAppCompatActivity(fragmentActivity).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "activity.requireAppCompa…().supportFragmentManager");
                    newInstance3.show(supportFragmentManager3, (String) null);
                    return;
                }
                return;
            case 2131362626:
            case 2131362627:
                ServiceApp serviceApp11 = this.serviceApp;
                if (serviceApp11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                if (!CollectionUtils.isEmpty(serviceApp11.getGiftRows())) {
                    if (view.getId() != 2131362626) {
                        i = 1;
                    }
                    ServiceApp serviceApp12 = this.serviceApp;
                    if (serviceApp12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                    }
                    List<Gift> giftRows2 = serviceApp12.getGiftRows();
                    Intrinsics.checkNotNull(giftRows2);
                    Gift gift2 = giftRows2.get(i);
                    Context context6 = getContext();
                    Intrinsics.checkNotNullExpressionValue(gift2, "gift");
                    String giftUrl = UriUtils.getGiftUrl(gift2);
                    ServiceApp serviceApp13 = this.serviceApp;
                    if (serviceApp13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                    }
                    ActionManager.startGiftWebViewActivity(context6, giftUrl, gift2, serviceApp13);
                    return;
                }
                return;
            case 2131362900:
                ActionManager.startPhotoViewActivity(((ItemAppViewBaseInfoBinding) getBinding()).logoView, this.viewModel.getLogo(), null);
                return;
            case 2131364008:
                ActionManager.startAppViewActivity(getContext(), "de.robv.android.xposed.installer");
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0039: APUT  
      (r5v0 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x0035: INVOKE  (r6v1 java.lang.String) = (r6v0 com.coolapk.market.model.ServiceApp), (0 int) type: VIRTUAL call: com.coolapk.market.model.ServiceApp.getDownloadUrlMd5(int):java.lang.String)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0112: APUT  
      (r3v3 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x010e: INVOKE  (r5v8 java.lang.String) = (r5v7 com.coolapk.market.model.ServiceApp), (0 int) type: VIRTUAL call: com.coolapk.market.model.ServiceApp.getDownloadUrlMd5(int):java.lang.String)
     */
    public final void doAction(Activity activity, View view) {
        String str = null;
        UpgradeInfo upgradeInfo = null;
        DataManager instance = DataManager.getInstance();
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        MobileApp mobileAppExistFast = instance.getMobileAppExistFast(serviceApp2.getPackageName());
        if (mobileAppExistFast != null) {
            upgradeInfo = mobileAppExistFast.getUpgradeInfo();
        }
        ServiceApp serviceApp3 = this.serviceApp;
        if (serviceApp3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        String packageName = serviceApp3.getPackageName();
        String[] strArr = new String[4];
        ServiceApp serviceApp4 = this.serviceApp;
        if (serviceApp4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        strArr[0] = serviceApp4.getDownloadUrlMd5(0);
        ServiceApp serviceApp5 = this.serviceApp;
        if (serviceApp5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        strArr[1] = serviceApp5.getDownloadUrlMd5(2);
        strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
        strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
        State findLatestState = StateUtils.findLatestState(packageName, strArr);
        if (findLatestState == null || ((findLatestState instanceof DownloadState) && ((DownloadState) findLatestState).getState() == 0)) {
            ServiceApp serviceApp6 = this.serviceApp;
            if (serviceApp6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (!TextUtils.isEmpty(serviceApp6.getExtendFile())) {
                ServiceApp serviceApp7 = this.serviceApp;
                if (serviceApp7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                DownloadExtendDialog newInstance = DownloadExtendDialog.newInstance(serviceApp7, false);
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return;
            }
            ServiceApp serviceApp8 = this.serviceApp;
            if (serviceApp8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            if (serviceApp8.getSupportAndroidVersion() > Build.VERSION.SDK_INT) {
                ServiceApp serviceApp9 = this.serviceApp;
                if (serviceApp9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
                }
                VersionLowerAlertDialog newInstance2 = VersionLowerAlertDialog.newInstance(serviceApp9, 0, 0);
                FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.requireAppCompa…().supportFragmentManager");
                newInstance2.show(supportFragmentManager2, (String) null);
                return;
            }
        }
        ServiceApp serviceApp10 = this.serviceApp;
        if (serviceApp10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        ClickInfo.Builder newBuilder = ClickInfo.newBuilder(serviceApp10);
        ServiceApp serviceApp11 = this.serviceApp;
        if (serviceApp11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        ClickInfo.Builder packageName2 = newBuilder.packageName(serviceApp11.getPackageName());
        ServiceApp serviceApp12 = this.serviceApp;
        if (serviceApp12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        ClickInfo.Builder targetUrl = packageName2.targetUrl(serviceApp12.getDownloadUrl(0));
        ServiceApp serviceApp13 = this.serviceApp;
        if (serviceApp13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        ClickInfo.Builder uninstallKey = targetUrl.uninstallKey(serviceApp13.getPackageName());
        String[] strArr2 = new String[4];
        ServiceApp serviceApp14 = this.serviceApp;
        if (serviceApp14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        strArr2[0] = serviceApp14.getDownloadUrlMd5(0);
        ServiceApp serviceApp15 = this.serviceApp;
        if (serviceApp15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        strArr2[1] = serviceApp15.getDownloadUrlMd5(2);
        strArr2[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
        if (upgradeInfo != null) {
            str = upgradeInfo.getDownloadUrlMd5(1);
        }
        strArr2[3] = str;
        StateUtils.handleClick(activity, uninstallKey.downloadKeys(strArr2).build(), view);
    }

    public final void scrollToFirst() {
        ItemAppViewBaseInfoBinding itemAppViewBaseInfoBinding = (ItemAppViewBaseInfoBinding) getBinding();
        if (!UiUtils.canScrollRight(itemAppViewBaseInfoBinding.thumbnailView)) {
            RecyclerView recyclerView = itemAppViewBaseInfoBinding.thumbnailView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.thumbnailView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
        }
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
        }
        return StateViewHolder.isEventBelongTo(event, serviceApp2);
    }

    /* compiled from: AppViewBaseInfoViewHolder.kt */
    private static final class PhotoViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558601;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhotoViewHolder(View view, DataBindingComponent dataBindingComponent, OnImageLoadListener onImageLoadListener, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(onImageLoadListener, "imageLoadListener");
            Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
            AppPhotoThumbnailBinding appPhotoThumbnailBinding = (AppPhotoThumbnailBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(appPhotoThumbnailBinding, "binding");
            appPhotoThumbnailBinding.setOnImageLoad(onImageLoadListener);
            ViewUtil.clickListener(appPhotoThumbnailBinding.image, this);
        }

        /* compiled from: AppViewBaseInfoViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            AppPhotoThumbnailBinding appPhotoThumbnailBinding = (AppPhotoThumbnailBinding) getBinding();
            AppViewViewModel.ImageSize imageSize = (AppViewViewModel.ImageSize) obj;
            Intrinsics.checkNotNullExpressionValue(appPhotoThumbnailBinding, "binding");
            if (appPhotoThumbnailBinding.getUrl() == null && (!Intrinsics.areEqual(imageSize.url, appPhotoThumbnailBinding.getUrl()))) {
                appPhotoThumbnailBinding.setUrl(imageSize.url);
            }
            if (imageSize.width == 0 || imageSize.height == 0) {
                ImageView imageView = appPhotoThumbnailBinding.image;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.image");
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                ImageView imageView2 = appPhotoThumbnailBinding.image;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.image");
                imageView2.setLayoutParams(layoutParams);
            } else {
                int dp2px = ConvertUtils.dp2px(160.0f);
                int i = (imageSize.width * dp2px) / imageSize.height;
                ImageView imageView3 = appPhotoThumbnailBinding.image;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.image");
                ViewGroup.LayoutParams layoutParams2 = imageView3.getLayoutParams();
                layoutParams2.width = i;
                layoutParams2.height = dp2px;
                ImageView imageView4 = appPhotoThumbnailBinding.image;
                Intrinsics.checkNotNullExpressionValue(imageView4, "binding.image");
                imageView4.setLayoutParams(layoutParams2);
            }
            appPhotoThumbnailBinding.executePendingBindings();
        }
    }

    /* compiled from: AppViewBaseInfoViewHolder.kt */
    private final class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 2131558601;
        }

        public PhotoAdapter() {
            AppViewBaseInfoViewHolder.this = r1;
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(AppViewBaseInfoViewHolder.this.getContext()).inflate(i, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            DataBindingComponent component = AppViewBaseInfoViewHolder.this.getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            return new PhotoViewHolder(inflate, component, AppViewBaseInfoViewHolder.this.onPhotoImageLoadListener, new AppViewBaseInfoViewHolder$PhotoAdapter$onCreateViewHolder$1(this));
        }

        public void onBindViewHolder(PhotoViewHolder photoViewHolder, int i) {
            Intrinsics.checkNotNullParameter(photoViewHolder, "holder");
            AppViewViewModel.ImageSize thumbnailSize = AppViewBaseInfoViewHolder.this.viewModel.getThumbnailSize(i);
            Intrinsics.checkNotNullExpressionValue(thumbnailSize, "viewModel.getThumbnailSize(position)");
            photoViewHolder.bindTo(thumbnailSize);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return AppViewBaseInfoViewHolder.this.viewModel.getThumbnailCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return AppViewBaseInfoViewHolder.this.viewModel.getThumbnailSize(i).id;
        }
    }

    /* compiled from: AppViewBaseInfoViewHolder.kt */
    private static final class CouponViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558604;
        private final ItemAppViewBaseInfoCouponItemBinding binding;
        private CouponInfo couponInfo;
        private ServiceApp serviceApp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CouponViewHolder(View view, ServiceApp serviceApp2, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(serviceApp2, "serviceApp");
            Intrinsics.checkNotNullParameter(itemActionHandler, "handler");
            this.serviceApp = serviceApp2;
            ItemAppViewBaseInfoCouponItemBinding itemAppViewBaseInfoCouponItemBinding = (ItemAppViewBaseInfoCouponItemBinding) getBinding();
            this.binding = itemAppViewBaseInfoCouponItemBinding;
            itemAppViewBaseInfoCouponItemBinding.itemView.setOnClickListener(this);
        }

        /* compiled from: AppViewBaseInfoViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            linearLayout.setTag(obj);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.CouponInfo");
            this.couponInfo = (CouponInfo) obj;
            ItemAppViewBaseInfoCouponItemBinding itemAppViewBaseInfoCouponItemBinding = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemAppViewBaseInfoCouponItemBinding, "binding");
            CouponInfo couponInfo2 = this.couponInfo;
            if (couponInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
            }
            itemAppViewBaseInfoCouponItemBinding.setCoupon(couponInfo2);
            this.binding.executePendingBindings();
            if (DataManager.getInstance().getMobileAppExistFast(this.serviceApp.getPackageName()) == null) {
                TextView textView = this.binding.fetchCouponView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.fetchCouponView");
                textView.setText("下载领取");
                return;
            }
            TextView textView2 = this.binding.fetchCouponView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.fetchCouponView");
            textView2.setText("打开领取");
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            super.onClick(view);
            CouponInfo couponInfo2 = this.couponInfo;
            if (couponInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
            }
            if (!couponInfo2.getIsClicked() && DataManager.getInstance().getMobileAppExistFast(this.serviceApp.getPackageName()) != null) {
                CouponInfo couponInfo3 = this.couponInfo;
                if (couponInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
                }
                CouponInfo build = CouponInfo.builder(couponInfo3).setIsClicked(true).build();
                Intrinsics.checkNotNullExpressionValue(build, "CouponInfo.builder(coupo…etIsClicked(true).build()");
                this.couponInfo = build;
                List<CouponInfo> couponInfo4 = this.serviceApp.getCouponInfo();
                int i = 0;
                if (couponInfo4 != null) {
                    Intrinsics.checkNotNullExpressionValue(couponInfo4, "it");
                    Iterator<CouponInfo> it2 = couponInfo4.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        CouponInfo next = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next, "it");
                        String couponId = next.getCouponId();
                        CouponInfo couponInfo5 = this.couponInfo;
                        if (couponInfo5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
                        }
                        if (Intrinsics.areEqual(couponId, couponInfo5.getCouponId())) {
                            break;
                        }
                        i2++;
                    }
                    CouponInfo couponInfo6 = this.couponInfo;
                    if (couponInfo6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
                    }
                    couponInfo4.set(i2, couponInfo6);
                } else {
                    couponInfo4 = null;
                }
                ServiceApp build2 = ServiceApp.builder(this.serviceApp).setCouponInfo(couponInfo4).build();
                Intrinsics.checkNotNullExpressionValue(build2, "ServiceApp.builder(servi…o(couponInfoList).build()");
                this.serviceApp = build2;
                ImageView imageView = this.binding.couponFetchedView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.couponFetchedView");
                CouponInfo couponInfo7 = this.couponInfo;
                if (couponInfo7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
                }
                imageView.setVisibility(couponInfo7.getIsClicked() ? 0 : 8);
                TextView textView = this.binding.fetchCouponView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.fetchCouponView");
                CouponInfo couponInfo8 = this.couponInfo;
                if (couponInfo8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
                }
                if (couponInfo8.getIsClicked()) {
                    i = 8;
                }
                textView.setVisibility(i);
            }
        }
    }

    /* compiled from: AppViewBaseInfoViewHolder.kt */
    private final class CouponAdapter extends RecyclerView.Adapter<CouponViewHolder> {
        private List<? extends CouponInfo> dataList;
        public ServiceApp serviceApp;

        public CouponAdapter() {
            AppViewBaseInfoViewHolder.this = r1;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.CouponInfo>, java.util.List<com.coolapk.market.model.CouponInfo> */
        public final List<CouponInfo> getDataList() {
            return this.dataList;
        }

        public final void setDataList(List<? extends CouponInfo> list) {
            this.dataList = list;
        }

        public final ServiceApp getServiceApp() {
            ServiceApp serviceApp2 = this.serviceApp;
            if (serviceApp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            return serviceApp2;
        }

        public final void setServiceApp(ServiceApp serviceApp2) {
            Intrinsics.checkNotNullParameter(serviceApp2, "<set-?>");
            this.serviceApp = serviceApp2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public CouponViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558604, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare…LAYOUT_ID, parent, false)");
            ServiceApp serviceApp2 = this.serviceApp;
            if (serviceApp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceApp");
            }
            return new CouponViewHolder(inflate, serviceApp2, new AppViewBaseInfoViewHolder$CouponAdapter$onCreateViewHolder$1(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends CouponInfo> list = this.dataList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void onBindViewHolder(CouponViewHolder couponViewHolder, int i) {
            Intrinsics.checkNotNullParameter(couponViewHolder, "holder");
            List<? extends CouponInfo> list = this.dataList;
            couponViewHolder.bindTo(list != null ? (CouponInfo) list.get(i) : null);
        }
    }
}
