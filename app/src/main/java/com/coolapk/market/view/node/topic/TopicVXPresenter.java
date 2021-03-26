package com.coolapk.market.view.node.topic;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.node.SavedStateListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/node/topic/TopicVXPresenter;", "Lcom/coolapk/market/view/node/SavedStateListener;", "tag", "", "view", "Lcom/coolapk/market/view/node/topic/TopicNodeFragment;", "(Ljava/lang/String;Lcom/coolapk/market/view/node/topic/TopicNodeFragment;)V", "isPostingFollow", "", "()Z", "setPostingFollow", "(Z)V", "getTag", "()Ljava/lang/String;", "getView", "()Lcom/coolapk/market/view/node/topic/TopicNodeFragment;", "followTag", "oldValue", "newValue", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicVXPresenter.kt */
public final class TopicVXPresenter implements SavedStateListener {
    private boolean isPostingFollow;
    private final String tag;
    private final TopicNodeFragment view;

    public TopicVXPresenter(String str, TopicNodeFragment topicNodeFragment) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(topicNodeFragment, "view");
        this.tag = str;
        this.view = topicNodeFragment;
    }

    public final String getTag() {
        return this.tag;
    }

    public final TopicNodeFragment getView() {
        return this.view;
    }

    @Override // com.coolapk.market.view.node.SavedStateListener
    public void onInitSavedInstanceState(Bundle bundle) {
        SavedStateListener.DefaultImpls.onInitSavedInstanceState(this, bundle);
    }

    @Override // com.coolapk.market.view.node.SavedStateListener
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        SavedStateListener.DefaultImpls.onSaveInstanceState(this, bundle);
    }

    public final boolean isPostingFollow() {
        return this.isPostingFollow;
    }

    public final void setPostingFollow(boolean z) {
        this.isPostingFollow = z;
    }

    public final boolean followTag(boolean z, boolean z2) {
        if (this.isPostingFollow) {
            return false;
        }
        StatisticHelper.Companion.getInstance().recordTopicAction("点击关注话题");
        this.isPostingFollow = true;
        if (z) {
            DataManager.getInstance().unFollowTag(this.tag).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new TopicVXPresenter$followTag$1(this, z, z2));
        } else {
            DataManager.getInstance().followTag(this.tag).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new TopicVXPresenter$followTag$2(this, z, z2));
        }
        this.view.onFollowStateChanged(z, z2, null);
        return true;
    }
}
