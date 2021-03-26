package com.coolapk.market.view.collectionList;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolapk.market.event.DyhArticleEvent;
import com.coolapk.market.event.FeedFavoriteEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.FeedUtils;
import com.coolapk.market.util.GsonUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.Toast;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: CollectionSelectActivity.kt */
final class CollectionSelectActivity$ActionDone$1 implements View.OnClickListener {
    final /* synthetic */ CollectionSelectActivity this$0;

    CollectionSelectActivity$ActionDone$1(CollectionSelectActivity collectionSelectActivity) {
        this.this$0 = collectionSelectActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ProgressBar progressBar = CollectionSelectActivity.access$getBinding$p(this.this$0).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        int i = 0;
        progressBar.setVisibility(0);
        TextView textView = CollectionSelectActivity.access$getBinding$p(this.this$0).actionDone;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
        textView.setVisibility(4);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        LinkedHashMap linkedHashMap = this.this$0.collectionMap;
        Intrinsics.checkNotNull(linkedHashMap);
        if (!(!linkedHashMap.isEmpty())) {
            LinkedHashMap linkedHashMap2 = this.this$0.cancelMap;
            Intrinsics.checkNotNull(linkedHashMap2);
            if (!(!linkedHashMap2.isEmpty())) {
                return;
            }
        }
        LinkedHashMap linkedHashMap3 = this.this$0.collectionMap;
        Intrinsics.checkNotNull(linkedHashMap3);
        Collection<com.coolapk.market.model.Collection> values = linkedHashMap3.values();
        Intrinsics.checkNotNullExpressionValue(values, "collectionMap!!.values");
        int i2 = 0;
        for (com.coolapk.market.model.Collection collection : values) {
            Intrinsics.checkNotNullExpressionValue(collection, "any");
            sb.append(collection.getId());
            LinkedHashMap linkedHashMap4 = this.this$0.collectionMap;
            Intrinsics.checkNotNull(linkedHashMap4);
            if (i2 >= linkedHashMap4.values().size() - 1) {
                break;
            }
            sb.append(",");
            i2++;
        }
        LinkedHashMap linkedHashMap5 = this.this$0.cancelMap;
        Intrinsics.checkNotNull(linkedHashMap5);
        Collection<com.coolapk.market.model.Collection> values2 = linkedHashMap5.values();
        Intrinsics.checkNotNullExpressionValue(values2, "cancelMap!!.values");
        for (com.coolapk.market.model.Collection collection2 : values2) {
            Intrinsics.checkNotNullExpressionValue(collection2, "any");
            sb2.append(collection2.getId());
            LinkedHashMap linkedHashMap6 = this.this$0.cancelMap;
            Intrinsics.checkNotNull(linkedHashMap6);
            if (i >= linkedHashMap6.values().size() - 1) {
                break;
            }
            sb2.append(",");
            i++;
        }
        DataManager.getInstance().addToCollection(sb.toString(), sb2.toString(), this.this$0.feedId, this.this$0.type).compose(RxUtils.applyIOSchedulers()).subscribe(new Action1<ResponseBody>(this) {
            /* class com.coolapk.market.view.collectionList.CollectionSelectActivity$ActionDone$1.AnonymousClass1 */
            final /* synthetic */ CollectionSelectActivity$ActionDone$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(ResponseBody responseBody) {
                int i;
                JsonElement parse = new JsonParser().parse(responseBody.string());
                Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(it.string())");
                JsonObject asJsonObject = parse.getAsJsonObject();
                String str = null;
                JsonElement jsonElement = asJsonObject.has("data") ? asJsonObject.get("data") : null;
                boolean z = false;
                if (jsonElement == null) {
                    if (asJsonObject.has("status")) {
                        JsonElement jsonElement2 = asJsonObject.get("status");
                        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject.get(\"status\")");
                        i = jsonElement2.getAsInt();
                    } else {
                        i = 1;
                    }
                    if (asJsonObject.has("message")) {
                        JsonElement jsonElement3 = asJsonObject.get("message");
                        Intrinsics.checkNotNullExpressionValue(jsonElement3, "jsonObject.get(\"message\")");
                        str = jsonElement3.getAsString();
                    }
                    if ((i < 0 || i > 400) && str != null) {
                        Toast.show$default(this.this$0.this$0.getActivity(), str, 0, false, 12, null);
                        ProgressBar progressBar = CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).loadingView;
                        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                        progressBar.setVisibility(8);
                        TextView textView = CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).actionDone;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
                        textView.setVisibility(0);
                        CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).bottomSheet.dismissView();
                        return;
                    }
                }
                Intrinsics.checkNotNull(jsonElement);
                Integer optInt = GsonUtils.optInt(jsonElement.getAsJsonObject(), "favnum");
                Integer optInt2 = GsonUtils.optInt(jsonElement.getAsJsonObject(), "collect");
                ProgressBar progressBar2 = CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).loadingView;
                Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.loadingView");
                progressBar2.setVisibility(8);
                TextView textView2 = CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).actionDone;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionDone");
                textView2.setVisibility(0);
                if (FeedUtils.isFeedType(this.this$0.this$0.type)) {
                    EventBus eventBus = EventBus.getDefault();
                    if (optInt2 != null && optInt2.intValue() == 1) {
                        z = true;
                    }
                    Intrinsics.checkNotNullExpressionValue(optInt, "favnum");
                    eventBus.post(new FeedFavoriteEvent(z, optInt.intValue(), this.this$0.this$0.feedId));
                } else if (FeedUtils.isAlbumType(this.this$0.this$0.type)) {
                    EventBus eventBus2 = EventBus.getDefault();
                    if (optInt2 != null && optInt2.intValue() == 1) {
                        z = true;
                    }
                    Intrinsics.checkNotNullExpressionValue(optInt, "favnum");
                    eventBus2.post(new FeedFavoriteEvent(z, optInt.intValue(), this.this$0.this$0.feedId));
                } else if (TextUtils.equals("article", this.this$0.this$0.type)) {
                    EventBus eventBus3 = EventBus.getDefault();
                    Intrinsics.checkNotNullExpressionValue(optInt, "favnum");
                    int intValue = optInt.intValue();
                    String str2 = this.this$0.this$0.feedId;
                    if (optInt2 != null && optInt2.intValue() == 1) {
                        z = true;
                    }
                    eventBus3.post(new DyhArticleEvent(1, intValue, str2, z));
                } else if (EntityUtils.isApkType(this.this$0.this$0.type)) {
                    BaseActivity activity = this.this$0.this$0.getActivity();
                    Intent intent = new Intent();
                    Intrinsics.checkNotNullExpressionValue(optInt2, "collect");
                    activity.setResult(-1, intent.putExtra("KEY_DATA", optInt2.intValue()));
                    CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).bottomSheet.dismissView();
                }
                LinkedHashMap linkedHashMap = this.this$0.this$0.collectionMap;
                Intrinsics.checkNotNull(linkedHashMap);
                if (linkedHashMap.isEmpty()) {
                    LinkedHashMap linkedHashMap2 = this.this$0.this$0.cancelMap;
                    Intrinsics.checkNotNull(linkedHashMap2);
                    if (!linkedHashMap2.isEmpty()) {
                        Toast.show$default(this.this$0.this$0.getActivity(), "取消收藏成功", 0, false, 12, null);
                        CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).bottomSheet.dismissView();
                    }
                }
                Toast.show$default(this.this$0.this$0.getActivity(), "收藏成功", 0, false, 12, null);
                CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).bottomSheet.dismissView();
            }
        }, new Action1<Throwable>(this) {
            /* class com.coolapk.market.view.collectionList.CollectionSelectActivity$ActionDone$1.AnonymousClass2 */
            final /* synthetic */ CollectionSelectActivity$ActionDone$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Throwable th) {
                Toast.error(this.this$0.this$0.getActivity(), th);
                ProgressBar progressBar = CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).loadingView;
                Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                progressBar.setVisibility(8);
                TextView textView = CollectionSelectActivity.access$getBinding$p(this.this$0.this$0).actionDone;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.actionDone");
                textView.setVisibility(0);
            }
        });
    }
}
