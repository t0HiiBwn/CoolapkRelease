package com.coolapk.market.view.center;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemAppUpdataManagerBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/center/AppUpdateViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemAppUpdataManagerBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppUpdateViewHolder.kt */
public final class AppUpdateViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558598;
    private final ItemAppUpdataManagerBinding binding = ((ItemAppUpdataManagerBinding) getBinding());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppUpdateViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/AppUpdateViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppUpdateViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        String str;
        ArrayList arrayList = new ArrayList();
        List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
        Intrinsics.checkNotNullExpressionValue(mobileAppUpgradeListFast, "it");
        if (mobileAppUpgradeListFast.size() > 1) {
            CollectionsKt.sortWith(mobileAppUpgradeListFast, new AppUpdateViewHolder$$special$$inlined$sortByDescending$1());
        }
        Intrinsics.checkNotNullExpressionValue(mobileAppUpgradeListFast, "updateList");
        if (!mobileAppUpgradeListFast.isEmpty()) {
            List<MobileApp> list = mobileAppUpgradeListFast;
            ArrayList<String> arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                arrayList2.add(t.getPackageName());
            }
            int i = 0;
            for (String str2 : arrayList2) {
                if (i > 3) {
                    break;
                }
                arrayList.add(str2);
                i++;
            }
            str = mobileAppUpgradeListFast.size() + "个应用待更新";
        } else {
            arrayList.clear();
            str = "您的应用都是最新的";
        }
        int size = arrayList.size();
        if (size == 1) {
            ImageView imageView = this.binding.iconView1;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView1");
            imageView.setVisibility(8);
            ImageView imageView2 = this.binding.iconView2;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.iconView2");
            imageView2.setVisibility(8);
            ImageView imageView3 = this.binding.iconView3;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.iconView3");
            imageView3.setVisibility(8);
            this.binding.iconView1.setImageBitmap(null);
            this.binding.iconView2.setImageBitmap(null);
            this.binding.iconView3.setImageBitmap(null);
            ImageView imageView4 = this.binding.iconView4;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.iconView4");
            imageView4.setVisibility(0);
            this.binding.iconView4.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(0)));
        } else if (size == 2) {
            ImageView imageView5 = this.binding.iconView4;
            Intrinsics.checkNotNullExpressionValue(imageView5, "binding.iconView4");
            imageView5.setVisibility(0);
            ImageView imageView6 = this.binding.iconView3;
            Intrinsics.checkNotNullExpressionValue(imageView6, "binding.iconView3");
            imageView6.setVisibility(0);
            ImageView imageView7 = this.binding.iconView1;
            Intrinsics.checkNotNullExpressionValue(imageView7, "binding.iconView1");
            imageView7.setVisibility(8);
            this.binding.iconView1.setImageBitmap(null);
            ImageView imageView8 = this.binding.iconView2;
            Intrinsics.checkNotNullExpressionValue(imageView8, "binding.iconView2");
            imageView8.setVisibility(8);
            this.binding.iconView2.setImageBitmap(null);
            this.binding.iconView4.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(1)));
            this.binding.iconView3.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(0)));
        } else if (size == 3) {
            ImageView imageView9 = this.binding.iconView4;
            Intrinsics.checkNotNullExpressionValue(imageView9, "binding.iconView4");
            imageView9.setVisibility(0);
            ImageView imageView10 = this.binding.iconView3;
            Intrinsics.checkNotNullExpressionValue(imageView10, "binding.iconView3");
            imageView10.setVisibility(0);
            ImageView imageView11 = this.binding.iconView2;
            Intrinsics.checkNotNullExpressionValue(imageView11, "binding.iconView2");
            imageView11.setVisibility(0);
            ImageView imageView12 = this.binding.iconView1;
            Intrinsics.checkNotNullExpressionValue(imageView12, "binding.iconView1");
            imageView12.setVisibility(8);
            this.binding.iconView4.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(2)));
            this.binding.iconView3.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(1)));
            this.binding.iconView2.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(0)));
            this.binding.iconView1.setImageBitmap(null);
        } else if (size != 4) {
            ImageView imageView13 = this.binding.iconView4;
            Intrinsics.checkNotNullExpressionValue(imageView13, "binding.iconView4");
            imageView13.setVisibility(4);
            ImageView imageView14 = this.binding.iconView3;
            Intrinsics.checkNotNullExpressionValue(imageView14, "binding.iconView3");
            imageView14.setVisibility(4);
            ImageView imageView15 = this.binding.iconView2;
            Intrinsics.checkNotNullExpressionValue(imageView15, "binding.iconView2");
            imageView15.setVisibility(4);
            ImageView imageView16 = this.binding.iconView1;
            Intrinsics.checkNotNullExpressionValue(imageView16, "binding.iconView1");
            imageView16.setVisibility(4);
            this.binding.iconView1.setImageBitmap(null);
            this.binding.iconView2.setImageBitmap(null);
            this.binding.iconView3.setImageBitmap(null);
            this.binding.iconView4.setImageBitmap(null);
        } else {
            ImageView imageView17 = this.binding.iconView4;
            Intrinsics.checkNotNullExpressionValue(imageView17, "binding.iconView4");
            imageView17.setVisibility(0);
            ImageView imageView18 = this.binding.iconView3;
            Intrinsics.checkNotNullExpressionValue(imageView18, "binding.iconView3");
            imageView18.setVisibility(0);
            ImageView imageView19 = this.binding.iconView2;
            Intrinsics.checkNotNullExpressionValue(imageView19, "binding.iconView2");
            imageView19.setVisibility(0);
            ImageView imageView20 = this.binding.iconView1;
            Intrinsics.checkNotNullExpressionValue(imageView20, "binding.iconView1");
            imageView20.setVisibility(0);
            this.binding.iconView4.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(3)));
            this.binding.iconView3.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(2)));
            this.binding.iconView2.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(1)));
            this.binding.iconView1.setImageBitmap(BitmapUtil.getIconBitmap(getContext(), (String) arrayList.get(0)));
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.HolderItem");
        HolderItem holderItem = (HolderItem) obj;
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(str);
        ItemAppUpdataManagerBinding itemAppUpdataManagerBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemAppUpdataManagerBinding, "binding");
        itemAppUpdataManagerBinding.setClick(this);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        ActionManager.startAppManagerActivity(getContext());
    }
}
