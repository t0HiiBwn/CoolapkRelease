package com.coolapk.market.view.main;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.RankViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RankFragment.kt */
final class RankFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ RankFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RankFragment$onActivityCreated$2(RankFragment rankFragment) {
        super(1);
        this.this$0 = rankFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new RankViewHolder(view, new FragmentBindingComponent(this.this$0), this.this$0.podiumCardIndex, new ItemActionHandler(this) {
            /* class com.coolapk.market.view.main.RankFragment$onActivityCreated$2.AnonymousClass1 */
            final /* synthetic */ RankFragment$onActivityCreated$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00be: APUT  (r4v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r10v4 java.lang.String) */
            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                if (viewHolder.getAdapterPosition() != -1) {
                    int id = view.getId();
                    if (id == 2131361886) {
                        Object tag = view.getTag(2131362753);
                        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                        ServiceApp serviceApp = (ServiceApp) tag;
                        String str = null;
                        UpgradeInfo upgradeInfo = null;
                        DataManager instance = DataManager.getInstance();
                        Intrinsics.checkNotNull(serviceApp);
                        MobileApp mobileAppExistFast = instance.getMobileAppExistFast(serviceApp.getPackageName());
                        if (mobileAppExistFast != null) {
                            upgradeInfo = mobileAppExistFast.getUpgradeInfo();
                        }
                        ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                        String[] strArr = new String[4];
                        strArr[0] = serviceApp.getDownloadUrlMd5(0);
                        strArr[1] = serviceApp.getDownloadUrlMd5(2);
                        strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                        if (upgradeInfo != null) {
                            str = upgradeInfo.getDownloadUrlMd5(1);
                        }
                        strArr[3] = str;
                        StateUtils.handleClick(this.this$0.this$0.getActivity(), targetUrl.downloadKeys(strArr).build(), view);
                    } else if (id == 2131362768) {
                        Object tag2 = view.getTag(2131362753);
                        Objects.requireNonNull(tag2, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                        ServiceApp serviceApp2 = (ServiceApp) tag2;
                        ViewDataBinding binding = ((BindingViewHolder) viewHolder).getBinding();
                        Objects.requireNonNull(binding, "null cannot be cast to non-null type com.coolapk.market.databinding.ServiceAppBinding");
                        ImageView imageView = ((ServiceAppBinding) binding).iconView;
                        Intrinsics.checkNotNullExpressionValue(imageView, "((holder as BindingViewH…rviceAppBinding).iconView");
                        ActionManager.startAppViewActivity(this.this$0.this$0.getActivity(), imageView, serviceApp2.getPackageName(), serviceApp2.getLogo(), serviceApp2.getAppName(), serviceApp2.getExtraAnalysisData(), serviceApp2.getRequestContext(), serviceApp2.getExtraFromApi());
                    }
                }
            }
        });
    }
}
