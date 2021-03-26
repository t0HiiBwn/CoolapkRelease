package com.coolapk.market.view.node;

import android.app.Activity;
import android.content.Intent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/node/TopicNodeLoader;", "Lcom/coolapk/market/view/node/Loader;", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "(Landroid/app/Activity;Landroid/content/Intent;)V", "getActivity", "()Landroid/app/Activity;", "getIntent", "()Landroid/content/Intent;", "checkIdentity", "", "loadData", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/Entity;", "loadingPlaceHolderRes", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
public final class TopicNodeLoader implements Loader {
    private final Activity activity;
    private final Intent intent;

    public TopicNodeLoader(Activity activity2, Intent intent2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(intent2, "intent");
        this.activity = activity2;
        this.intent = intent2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    @Override // com.coolapk.market.view.node.Loader
    public int loadingPlaceHolderRes() {
        return AppHolder.getAppTheme().isDarkTheme() ? 2131231785 : 2131231786;
    }

    @Override // com.coolapk.market.view.node.Loader
    public boolean checkIdentity() {
        return this.intent.hasExtra("TOPIC_TITLE");
    }

    @Override // com.coolapk.market.view.node.Loader
    public Observable<Result<Entity>> loadData() {
        Observable<Result<Entity>> topicCompatProduct = DataManager.getInstance().getTopicCompatProduct(this.intent.getStringExtra("TOPIC_TITLE"));
        Intrinsics.checkNotNullExpressionValue(topicCompatProduct, "DataManager.getInstance(…opicCompatProduct(tagKey)");
        return topicCompatProduct;
    }
}
