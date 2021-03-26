package com.coolapk.market.view.collectionList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.CollectionUpdataEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/coolapk/market/model/Collection;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CreateCollectionActivity.kt */
final class CreateCollectionActivity$post$2<T> implements Action1<Collection> {
    final /* synthetic */ ProgressDialog $pDialog;
    final /* synthetic */ CreateCollectionActivity this$0;

    CreateCollectionActivity$post$2(CreateCollectionActivity createCollectionActivity, ProgressDialog progressDialog) {
        this.this$0 = createCollectionActivity;
        this.$pDialog = progressDialog;
    }

    public final void call(Collection collection) {
        List<Activity> activityList;
        int indexOf;
        EventBus.getDefault().post(new CollectionUpdataEvent(collection, CreateCollectionActivity.access$getCollectionViewModel$p(this.this$0).getCollectionIsEdit() ? 1 : 0));
        CollectionListViewModel access$getCollectionViewModel$p = CreateCollectionActivity.access$getCollectionViewModel$p(this.this$0);
        Intrinsics.checkNotNullExpressionValue(collection, "it");
        access$getCollectionViewModel$p.setCollectionId(collection.getId());
        this.$pDialog.dismiss();
        if (CreateCollectionActivity.access$getCollectionViewModel$p(this.this$0).getCollectionCreateAndBack()) {
            this.this$0.getActivity().setResult(-1, new Intent().putExtra("KEY_ID", collection.getId()));
            this.this$0.getActivity().finish();
            return;
        }
        if (CreateCollectionActivity.access$getCollectionViewModel$p(this.this$0).getCollectionIsEdit() && (indexOf = (activityList = AppHolder.getActivityStackManager().getActivityList()).indexOf(this.this$0)) > 0) {
            int i = indexOf - 1;
            if (activityList.get(i) instanceof CollectionDetailActivity) {
                activityList.get(i).finish();
            }
        }
        ActionManager.startCollectionDetailActivity(this.this$0.getActivity(), collection.getId());
        this.this$0.finish();
    }
}
