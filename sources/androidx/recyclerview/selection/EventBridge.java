package androidx.recyclerview.selection;

import android.util.Log;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

public class EventBridge {
    private static final String TAG = "EventsRelays";

    public static <K> void install(RecyclerView.Adapter<?> adapter, SelectionTracker<K> selectionTracker, ItemKeyProvider<K> itemKeyProvider) {
        new TrackerToAdapterBridge(selectionTracker, itemKeyProvider, adapter);
        adapter.registerAdapterDataObserver(selectionTracker.getAdapterDataObserver());
    }

    private static final class TrackerToAdapterBridge<K> extends SelectionTracker.SelectionObserver<K> {
        private final RecyclerView.Adapter<?> mAdapter;
        private final ItemKeyProvider<K> mKeyProvider;

        TrackerToAdapterBridge(SelectionTracker<K> selectionTracker, ItemKeyProvider<K> itemKeyProvider, RecyclerView.Adapter<?> adapter) {
            selectionTracker.addObserver(this);
            boolean z = true;
            Preconditions.checkArgument(itemKeyProvider != null);
            Preconditions.checkArgument(adapter == null ? false : z);
            this.mKeyProvider = itemKeyProvider;
            this.mAdapter = adapter;
        }

        @Override // androidx.recyclerview.selection.SelectionTracker.SelectionObserver
        public void onItemStateChanged(K k, boolean z) {
            int position = this.mKeyProvider.getPosition(k);
            if (position < 0) {
                Log.w("EventsRelays", "Item change notification received for unknown item: " + ((Object) k));
                return;
            }
            this.mAdapter.notifyItemChanged(position, "Selection-Changed");
        }
    }

    private EventBridge() {
    }
}
