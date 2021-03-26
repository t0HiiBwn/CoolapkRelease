package com.coolapk.market.view.node.topic;

import android.os.Bundle;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.view.node.SavedStateListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0019H\u0016R&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/node/topic/TopicVXViewModel;", "Landroidx/databinding/BaseObservable;", "Lcom/coolapk/market/view/node/SavedStateListener;", "model", "Lcom/coolapk/market/model/Topic;", "(Lcom/coolapk/market/model/Topic;)V", "value", "", "followState", "getFollowState", "()Z", "setFollowState", "(Z)V", "getModel", "()Lcom/coolapk/market/model/Topic;", "topIds", "", "", "getTopIds", "()Ljava/util/List;", "getFollowCount", "", "onInitSavedInstanceState", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicVXViewModel.kt */
public final class TopicVXViewModel extends BaseObservable implements SavedStateListener {
    @Bindable
    private boolean followState;
    private final Topic model;
    @Bindable
    private final List<String> topIds;

    public TopicVXViewModel(Topic topic) {
        Intrinsics.checkNotNullParameter(topic, "model");
        this.model = topic;
        ArrayList arrayList = new ArrayList();
        this.topIds = arrayList;
        UserAction userAction = topic.getUserAction();
        setFollowState(userAction != null && userAction.getFollow() == 1);
        List<String> topIds2 = topic.getTopIds();
        Intrinsics.checkNotNullExpressionValue(topIds2, "model.topIds");
        ArrayList arrayList2 = new ArrayList();
        for (T t : topIds2) {
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            if (t2.length() > 0) {
                arrayList2.add(t);
            }
        }
        arrayList.addAll(arrayList2);
    }

    public final Topic getModel() {
        return this.model;
    }

    public final List<String> getTopIds() {
        return this.topIds;
    }

    public final boolean getFollowState() {
        return this.followState;
    }

    public final void setFollowState(boolean z) {
        if (this.followState != z) {
            this.followState = z;
            notifyPropertyChanged(122);
        }
    }

    public final int getFollowCount() {
        UserAction userAction = this.model.getUserAction();
        boolean z = userAction != null && userAction.getFollow() == 1;
        if (z && !this.followState) {
            return this.model.getFollowNum() - 1;
        }
        if (z || !this.followState) {
            return this.model.getFollowNum();
        }
        return this.model.getFollowNum() + 1;
    }

    @Override // com.coolapk.market.view.node.SavedStateListener
    public void onInitSavedInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.topIds.clear();
            List<String> list = this.topIds;
            ArrayList<String> stringArrayList = bundle.getStringArrayList("TOP_IDS");
            if (stringArrayList != null) {
                list.addAll(stringArrayList);
                setFollowState(bundle.getBoolean("FOLLOW_STATE"));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // com.coolapk.market.view.node.SavedStateListener
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putStringArrayList("TOP_IDS", new ArrayList<>(this.topIds));
        bundle.putBoolean("FOLLOW_STATE", this.followState);
    }
}
