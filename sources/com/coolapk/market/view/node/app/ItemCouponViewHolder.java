package com.coolapk.market.view.node.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemAppNodeCouponBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemCouponViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "(Landroid/view/View;Lcom/coolapk/market/view/node/app/AppNodeViewModel;)V", "binding", "Lcom/coolapk/market/databinding/ItemAppNodeCouponBinding;", "kotlin.jvm.PlatformType", "couponInfo", "Lcom/coolapk/market/model/CouponInfo;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemCouponViewHolder.kt */
public final class ItemCouponViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558593;
    private final ItemAppNodeCouponBinding binding = ((ItemAppNodeCouponBinding) getBinding());
    private CouponInfo couponInfo;
    private AppNodeViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemCouponViewHolder(View view, AppNodeViewModel appNodeViewModel) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(appNodeViewModel, "viewModel");
        this.viewModel = appNodeViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/app/ItemCouponViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemCouponViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.CouponInfo");
        this.couponInfo = (CouponInfo) obj;
        ItemAppNodeCouponBinding itemAppNodeCouponBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemAppNodeCouponBinding, "binding");
        CouponInfo couponInfo2 = this.couponInfo;
        if (couponInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
        }
        itemAppNodeCouponBinding.setCoupon(couponInfo2);
        ItemAppNodeCouponBinding itemAppNodeCouponBinding2 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemAppNodeCouponBinding2, "binding");
        itemAppNodeCouponBinding2.setClick(this);
        this.binding.executePendingBindings();
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        Intrinsics.checkNotNull(serviceApp);
        Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
        ServiceApp serviceApp2 = serviceApp;
        CouponInfo couponInfo3 = this.couponInfo;
        if (couponInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
        }
        if (couponInfo3.getIsClicked()) {
            TextView textView = this.binding.fetchCouponTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.fetchCouponTextView");
            textView.setText("已领取");
        } else if (DataManager.getInstance().getMobileAppExistFast(serviceApp2.getPackageName()) == null) {
            TextView textView2 = this.binding.fetchCouponTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.fetchCouponTextView");
            textView2.setText("下载领取");
        } else {
            TextView textView3 = this.binding.fetchCouponTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.fetchCouponTextView");
            textView3.setText("打开领取");
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ServiceApp serviceApp = this.viewModel.getServiceApp().get();
        Intrinsics.checkNotNull(serviceApp);
        Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
        ServiceApp serviceApp2 = serviceApp;
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp2.getPackageName());
        CouponInfo couponInfo2 = this.couponInfo;
        if (couponInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
        }
        if (!couponInfo2.getIsClicked() && mobileAppExistFast != null) {
            CouponInfo couponInfo3 = this.couponInfo;
            if (couponInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
            }
            CouponInfo build = CouponInfo.builder(couponInfo3).setIsClicked(true).build();
            Intrinsics.checkNotNullExpressionValue(build, "CouponInfo.builder(coupo…etIsClicked(true).build()");
            this.couponInfo = build;
            AppNodeViewModel appNodeViewModel = this.viewModel;
            if (build == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
            }
            appNodeViewModel.updateCouponInfo(build);
        }
        if (mobileAppExistFast == null) {
            this.viewModel.startDownload(view);
            return;
        }
        ActionManager.reportCoupon(getContext(), serviceApp2.getExtraAnalysisData(), getAdapterPosition(), serviceApp2.getApkId());
        CouponInfo couponInfo4 = this.couponInfo;
        if (couponInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
        }
        int couponType = couponInfo4.getCouponType();
        if (couponType == 1) {
            CouponInfo couponInfo5 = this.couponInfo;
            if (couponInfo5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
            }
            String adH5url = couponInfo5.getAdH5url();
            if (!TextUtils.isEmpty(adH5url)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, adH5url, null, null);
            }
        } else if (couponType == 2) {
            CouponInfo couponInfo6 = this.couponInfo;
            if (couponInfo6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponInfo");
            }
            String adApplink = couponInfo6.getAdApplink();
            if (!TextUtils.isEmpty(adApplink)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(adApplink));
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                ComponentName resolveActivity = intent.resolveActivity(context2.getPackageManager());
                if (resolveActivity != null) {
                    intent.setComponent(resolveActivity);
                    getContext().startActivity(intent);
                }
            }
        }
    }
}
