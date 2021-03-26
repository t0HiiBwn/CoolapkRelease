package com.coolapk.market.view.feed;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J(\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J0\u0010\f\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J(\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/feed/FeedEventListener$callback$1", "Landroidx/databinding/ObservableList$OnListChangedCallback;", "Landroidx/databinding/ObservableArrayList;", "Lcom/coolapk/market/model/Entity;", "onChanged", "", "sender", "onItemRangeChanged", "positionStart", "", "itemCount", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedEventListener.kt */
public final class FeedEventListener$callback$1 extends ObservableList.OnListChangedCallback<ObservableArrayList<Entity>> {
    final /* synthetic */ FeedEventListener this$0;

    public void onChanged(ObservableArrayList<Entity> observableArrayList) {
    }

    public void onItemRangeInserted(ObservableArrayList<Entity> observableArrayList, int i, int i2) {
    }

    public void onItemRangeMoved(ObservableArrayList<Entity> observableArrayList, int i, int i2, int i3) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedEventListener$callback$1(FeedEventListener feedEventListener) {
        this.this$0 = feedEventListener;
    }

    public void onItemRangeRemoved(ObservableArrayList<Entity> observableArrayList, int i, int i2) {
        Function0<Unit> onDelete = this.this$0.getOnDelete();
        if (onDelete != null) {
            onDelete.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.coolapk.market.model.Entity] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void onItemRangeChanged(ObservableArrayList<Entity> observableArrayList, int i, int i2) {
        Function1<Feed, Unit> onUpdate;
        Feed feed = observableArrayList != null ? (Entity) observableArrayList.get(0) : null;
        if (i == 0 && i2 == 1 && (feed instanceof Feed) && (onUpdate = this.this$0.getOnUpdate()) != null) {
            onUpdate.invoke(feed);
        }
    }
}
