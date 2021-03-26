package com.coolapk.market.view.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.CouponInfo;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.AppViewBaseInfoViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/app/AppViewBaseInfoViewHolder$CouponAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewBaseInfoViewHolder.kt */
public final class AppViewBaseInfoViewHolder$CouponAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ AppViewBaseInfoViewHolder.CouponAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppViewBaseInfoViewHolder$CouponAdapter$onCreateViewHolder$1(AppViewBaseInfoViewHolder.CouponAdapter couponAdapter) {
        this.this$0 = couponAdapter;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (DataManager.getInstance().getMobileAppExistFast(this.this$0.getServiceApp().getPackageName()) == null) {
            AppViewBaseInfoViewHolder appViewBaseInfoViewHolder = AppViewBaseInfoViewHolder.this;
            Activity activity = UiUtils.getActivity(AppViewBaseInfoViewHolder.this.getContext());
            Intrinsics.checkNotNullExpressionValue(activity, "UiUtils.getActivity(context)");
            AppViewBaseInfoViewHolder.access$doAction(appViewBaseInfoViewHolder, activity, null);
            return;
        }
        ActionManager.reportCoupon(AppViewBaseInfoViewHolder.this.getContext(), this.this$0.getServiceApp().getExtraAnalysisData(), AppViewBaseInfoViewHolder.this.getAdapterPosition(), this.this$0.getServiceApp().getApkId());
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.CouponInfo");
        CouponInfo couponInfo = (CouponInfo) tag;
        int couponType = couponInfo.getCouponType();
        if (couponType == 1) {
            String adH5url = couponInfo.getAdH5url();
            if (!TextUtils.isEmpty(adH5url)) {
                Context context = AppViewBaseInfoViewHolder.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, adH5url, null, null);
            }
        } else if (couponType == 2) {
            String adApplink = couponInfo.getAdApplink();
            if (!TextUtils.isEmpty(adApplink)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(adApplink));
                Context context2 = AppViewBaseInfoViewHolder.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                ComponentName resolveActivity = intent.resolveActivity(context2.getPackageManager());
                if (resolveActivity != null) {
                    intent.setComponent(resolveActivity);
                    AppViewBaseInfoViewHolder.this.getContext().startActivity(intent);
                }
            }
        }
    }
}
