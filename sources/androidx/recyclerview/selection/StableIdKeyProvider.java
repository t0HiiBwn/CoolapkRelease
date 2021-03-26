package androidx.recyclerview.selection;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

public final class StableIdKeyProvider extends ItemKeyProvider<Long> {
    private final Map<Long, Integer> mKeyToPosition = new HashMap();
    private final SparseArray<Long> mPositionToKey = new SparseArray<>();
    private final RecyclerView mRecyclerView;

    public StableIdKeyProvider(RecyclerView recyclerView) {
        super(1);
        this.mRecyclerView = recyclerView;
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            /* class androidx.recyclerview.selection.StableIdKeyProvider.AnonymousClass1 */

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                StableIdKeyProvider.this.onAttached(view);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                StableIdKeyProvider.this.onDetached(view);
            }
        });
    }

    void onAttached(View view) {
        RecyclerView.ViewHolder findContainingViewHolder = this.mRecyclerView.findContainingViewHolder(view);
        int adapterPosition = findContainingViewHolder.getAdapterPosition();
        long itemId = findContainingViewHolder.getItemId();
        if (adapterPosition != -1 && itemId != -1) {
            this.mPositionToKey.put(adapterPosition, Long.valueOf(itemId));
            this.mKeyToPosition.put(Long.valueOf(itemId), Integer.valueOf(adapterPosition));
        }
    }

    void onDetached(View view) {
        RecyclerView.ViewHolder findContainingViewHolder = this.mRecyclerView.findContainingViewHolder(view);
        int adapterPosition = findContainingViewHolder.getAdapterPosition();
        long itemId = findContainingViewHolder.getItemId();
        if (adapterPosition != -1 && itemId != -1) {
            this.mPositionToKey.delete(adapterPosition);
            this.mKeyToPosition.remove(Long.valueOf(itemId));
        }
    }

    @Override // androidx.recyclerview.selection.ItemKeyProvider
    public Long getKey(int i) {
        return this.mPositionToKey.get(i, null);
    }

    public int getPosition(Long l) {
        if (this.mKeyToPosition.containsKey(l)) {
            return this.mKeyToPosition.get(l).intValue();
        }
        return -1;
    }
}
