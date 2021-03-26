package com.coolapk.market.view.goodsList;

import android.app.ProgressDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.coolapk.market.event.GoodsEditEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsListEditDialog.kt */
final class GoodsListEditDialog$onCreateDialog$1 implements View.OnClickListener {
    final /* synthetic */ GoodsListEditDialog this$0;

    GoodsListEditDialog$onCreateDialog$1(GoodsListEditDialog goodsListEditDialog) {
        this.this$0 = goodsListEditDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this.this$0.getActivity());
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(true);
        progressDialog.setMessage(this.this$0.getString(2131886579));
        progressDialog.show();
        GoodsListEditDialog goodsListEditDialog = this.this$0;
        EditText access$getTitleView$p = GoodsListEditDialog.access$getTitleView$p(goodsListEditDialog);
        Intrinsics.checkNotNull(access$getTitleView$p);
        GoodsListEditDialog.access$setGoodsListTitle$p(goodsListEditDialog, access$getTitleView$p.getText().toString());
        GoodsListEditDialog goodsListEditDialog2 = this.this$0;
        EditText access$getIntro$p = GoodsListEditDialog.access$getIntro$p(goodsListEditDialog2);
        Intrinsics.checkNotNull(access$getIntro$p);
        GoodsListEditDialog.access$setGoodsListDescription$p(goodsListEditDialog2, access$getIntro$p.getText().toString());
        if (TextUtils.isEmpty(GoodsListEditDialog.access$getGoodsListTitle$p(this.this$0)) || TextUtils.isEmpty(GoodsListEditDialog.access$getGoodsListDescription$p(this.this$0))) {
            Toast.show$default(this.this$0.getActivity(), this.this$0.getString(2131886576), 0, false, 12, null);
            progressDialog.dismiss();
            return;
        }
        GoodsListEditDialog.access$setEditSubscription$p(this.this$0, DataManager.getInstance().editGoodsList(GoodsListEditDialog.access$getId$p(this.this$0), GoodsListEditDialog.access$getGoodsListTitle$p(this.this$0), GoodsListEditDialog.access$getGoodsListDescription$p(this.this$0), GoodsListEditDialog.access$getMGoodsListDetailViewModel$p(this.this$0).getCoverUrl()).compose(RxUtils.apiCommon()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>(this) {
            /* class com.coolapk.market.view.goodsList.GoodsListEditDialog$onCreateDialog$1.AnonymousClass1 */
            final /* synthetic */ GoodsListEditDialog$onCreateDialog$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // rx.Observer
            public void onCompleted() {
                progressDialog.dismiss();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "e");
                progressDialog.dismiss();
                Toast.error(this.this$0.this$0.getActivity(), th);
            }

            public void onNext(Result<String> result) {
                GoodsListEditDialog.access$getMGoodsListDetailViewModel$p(this.this$0.this$0).setGoodsListTitle(GoodsListEditDialog.access$getGoodsListTitle$p(this.this$0.this$0));
                GoodsListEditDialog.access$getMGoodsListDetailViewModel$p(this.this$0.this$0).setGoodsListMessage(GoodsListEditDialog.access$getGoodsListDescription$p(this.this$0.this$0));
                Feed build = Feed.newBuilder(GoodsListEditDialog.access$getMGoodsListDetailViewModel$p(this.this$0.this$0).getGoodsList()).extraPic(GoodsListEditDialog.access$getMGoodsListDetailViewModel$p(this.this$0.this$0).getCoverUrl()).title(GoodsListEditDialog.access$getMGoodsListDetailViewModel$p(this.this$0.this$0).getGoodsListTitle()).message(GoodsListEditDialog.access$getMGoodsListDetailViewModel$p(this.this$0.this$0).getGoodsListMessage()).build();
                EventBus eventBus = EventBus.getDefault();
                Intrinsics.checkNotNullExpressionValue(build, "feed");
                eventBus.post(new GoodsEditEvent(build));
                progressDialog.dismiss();
                this.this$0.this$0.dismiss();
            }
        }));
    }
}
