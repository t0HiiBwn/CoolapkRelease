package com.coolapk.market.view.album.albumv8;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.AlbumAppBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.view.album.albumv8.AlbumDetailListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumDetailListFragment$DataAdapter$onCreateViewHolder$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onItemLongClick", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailListFragment.kt */
public final class AlbumDetailListFragment$DataAdapter$onCreateViewHolder$1 extends ItemActionHandler {
    final /* synthetic */ AlbumDetailListFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AlbumDetailListFragment$DataAdapter$onCreateViewHolder$1(AlbumDetailListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00fa: APUT  (r3v6 java.lang.String[]), (1 ??[boolean, int, float, short, byte, char]), (r0v9 java.lang.String) */
    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (viewHolder.getAdapterPosition() != -1) {
            Object obj = AlbumDetailListFragment.this.dataList.get(viewHolder.getAdapterPosition());
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.AlbumItem");
            AlbumItem albumItem = (AlbumItem) obj;
            int id = view.getId();
            if (id == 2131361887) {
                String str = null;
                if (TextUtils.equals(albumItem.getApkId(), "0")) {
                    ActionManager.startExternalMarketByName(AlbumDetailListFragment.this.getActivity(), null, null, albumItem.getPackageName());
                    return;
                }
                UpgradeInfo upgradeInfo = null;
                MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(albumItem.getPackageName());
                if (mobileAppExistFast != null) {
                    upgradeInfo = mobileAppExistFast.getUpgradeInfo();
                }
                ClickInfo.Builder targetUrl = ClickInfo.newBuilder(albumItem).packageName(albumItem.getPackageName()).targetUrl(albumItem.getDownloadUrl());
                String[] strArr = new String[3];
                strArr[0] = albumItem.getDownloadUrlMd5();
                strArr[1] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                if (upgradeInfo != null) {
                    str = upgradeInfo.getDownloadUrlMd5(1);
                }
                strArr[2] = str;
                StateUtils.handleClick(AlbumDetailListFragment.this.getActivity(), targetUrl.downloadKeys(strArr).build(), view);
            } else if (id == 2131362020) {
                if (TextUtils.equals(albumItem.getApkId(), "0")) {
                    ActionManager.startExternalMarketByName(AlbumDetailListFragment.this.getActivity(), albumItem.getUrl(), albumItem.getSourceName(), albumItem.getPackageName());
                    return;
                }
                ViewDataBinding binding = ((BindingViewHolder) viewHolder).getBinding();
                Objects.requireNonNull(binding, "null cannot be cast to non-null type com.coolapk.market.databinding.AlbumAppBinding");
                ImageView imageView = ((AlbumAppBinding) binding).iconView;
                Intrinsics.checkNotNullExpressionValue(imageView, "((holder as BindingViewH…AlbumAppBinding).iconView");
                ActionManager.startAppViewActivity(AlbumDetailListFragment.this.getActivity(), imageView, albumItem.getPackageName(), albumItem.getLogoUrl(), albumItem.getTitle(), albumItem.getExtraAnalysisData(), null, null);
            }
        }
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = AlbumDetailListFragment.this.dataList.get(viewHolder.getAdapterPosition());
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.AlbumItem");
        AlbumItem albumItem = (AlbumItem) obj;
        if (viewHolder.getAdapterPosition() == -1) {
            return false;
        }
        ActionManager.startTextViewActivity(AlbumDetailListFragment.this.getActivity(), albumItem.getTitle() + "\n\n" + albumItem.getNote());
        return true;
    }
}
