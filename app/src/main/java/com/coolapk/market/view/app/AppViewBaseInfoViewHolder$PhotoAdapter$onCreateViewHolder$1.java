package com.coolapk.market.view.app;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemAppViewBaseInfoBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.app.AppViewBaseInfoViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/app/AppViewBaseInfoViewHolder$PhotoAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewBaseInfoViewHolder.kt */
public final class AppViewBaseInfoViewHolder$PhotoAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ AppViewBaseInfoViewHolder.PhotoAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AppViewBaseInfoViewHolder$PhotoAdapter$onCreateViewHolder$1(AppViewBaseInfoViewHolder.PhotoAdapter photoAdapter) {
        this.this$0 = photoAdapter;
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(UiUtils.isInvalidPosition(viewHolder.getAdapterPosition()) || AppViewBaseInfoViewHolder.access$getServiceApp$p(AppViewBaseInfoViewHolder.this).getThumbList() == null || AppViewBaseInfoViewHolder.access$getServiceApp$p(AppViewBaseInfoViewHolder.this).getScreenList() == null)) {
            List<String> screenList = AppViewBaseInfoViewHolder.access$getServiceApp$p(AppViewBaseInfoViewHolder.this).getScreenList();
            Intrinsics.checkNotNull(screenList);
            int size = screenList.size();
            Rect[] rectArr = new Rect[size];
            ItemAppViewBaseInfoBinding itemAppViewBaseInfoBinding = (ItemAppViewBaseInfoBinding) AppViewBaseInfoViewHolder.this.getBinding();
            for (int i = 0; i < size; i++) {
                AppViewBaseInfoViewHolder.PhotoViewHolder photoViewHolder = (AppViewBaseInfoViewHolder.PhotoViewHolder) itemAppViewBaseInfoBinding.thumbnailView.findViewHolderForAdapterPosition(i);
                if (photoViewHolder != null) {
                    View view2 = photoViewHolder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view2, "childHolder.itemView");
                    rectArr[i] = ViewExtendsKt.getGlobalRect(view2);
                }
            }
            Activity activity = UiUtils.getActivity(AppViewBaseInfoViewHolder.this.getContext());
            List<String> screenList2 = AppViewBaseInfoViewHolder.access$getServiceApp$p(AppViewBaseInfoViewHolder.this).getScreenList();
            Intrinsics.checkNotNull(screenList2);
            Intrinsics.checkNotNullExpressionValue(screenList2, "serviceApp.screenList!!");
            Object[] array = screenList2.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            List<String> thumbList = AppViewBaseInfoViewHolder.access$getServiceApp$p(AppViewBaseInfoViewHolder.this).getThumbList();
            Intrinsics.checkNotNull(thumbList);
            Intrinsics.checkNotNullExpressionValue(thumbList, "serviceApp.thumbList!!");
            Object[] array2 = thumbList.toArray(new String[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            ActionManager.startPhotoViewActivity(activity, (String[]) array, (String[]) array2, viewHolder.getAdapterPosition(), null, null, rectArr);
        }
    }
}
