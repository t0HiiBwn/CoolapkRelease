package androidx.recyclerview.selection;

import android.os.Bundle;
import androidx.core.util.Preconditions;
import androidx.recyclerview.selection.Range;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DefaultSelectionTracker<K> extends SelectionTracker<K> {
    private static final String EXTRA_SELECTION_PREFIX = "androidx.recyclerview.selection";
    private static final String TAG = "DefaultSelectionTracker";
    private final AdapterObserver mAdapterObserver;
    private final ItemKeyProvider<K> mKeyProvider;
    private final List<SelectionTracker.SelectionObserver> mObservers = new ArrayList(1);
    private Range mRange;
    private final DefaultSelectionTracker<K>.RangeCallbacks mRangeCallbacks;
    private final Selection<K> mSelection = new Selection<>();
    private final String mSelectionId;
    private final SelectionTracker.SelectionPredicate<K> mSelectionPredicate;
    private final boolean mSingleSelect;
    private final StorageStrategy<K> mStorage;

    public DefaultSelectionTracker(String str, ItemKeyProvider itemKeyProvider, SelectionTracker.SelectionPredicate selectionPredicate, StorageStrategy<K> storageStrategy) {
        boolean z = false;
        Preconditions.checkArgument(str != null);
        Preconditions.checkArgument(!str.trim().isEmpty());
        Preconditions.checkArgument(itemKeyProvider != null);
        Preconditions.checkArgument(selectionPredicate != null);
        Preconditions.checkArgument(storageStrategy != null ? true : z);
        this.mSelectionId = str;
        this.mKeyProvider = itemKeyProvider;
        this.mSelectionPredicate = selectionPredicate;
        this.mStorage = storageStrategy;
        this.mRangeCallbacks = new RangeCallbacks();
        this.mSingleSelect = !selectionPredicate.canSelectMultiple();
        this.mAdapterObserver = new AdapterObserver(this);
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void addObserver(SelectionTracker.SelectionObserver selectionObserver) {
        Preconditions.checkArgument(selectionObserver != null);
        this.mObservers.add(selectionObserver);
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public boolean hasSelection() {
        return !this.mSelection.isEmpty();
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public Selection getSelection() {
        return this.mSelection;
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void copySelection(MutableSelection mutableSelection) {
        mutableSelection.copyFrom(this.mSelection);
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public boolean isSelected(K k) {
        return this.mSelection.contains(k);
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    protected void restoreSelection(Selection selection) {
        Preconditions.checkArgument(selection != null);
        setItemsSelectedQuietly(selection.mSelection, true);
        notifySelectionRestored();
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public boolean setItemsSelected(Iterable<K> iterable, boolean z) {
        boolean itemsSelectedQuietly = setItemsSelectedQuietly(iterable, z);
        notifySelectionChanged();
        return itemsSelectedQuietly;
    }

    private boolean setItemsSelectedQuietly(Iterable<K> iterable, boolean z) {
        boolean z2 = false;
        for (K k : iterable) {
            boolean z3 = true;
            if (!z ? !canSetState(k, false) || !this.mSelection.remove(k) : !canSetState(k, true) || !this.mSelection.add(k)) {
                z3 = false;
            }
            if (z3) {
                notifyItemStateChanged(k, z);
            }
            z2 |= z3;
        }
        return z2;
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public boolean clearSelection() {
        if (!hasSelection()) {
            return false;
        }
        clearProvisionalSelection();
        clearPrimarySelection();
        return true;
    }

    private void clearPrimarySelection() {
        if (hasSelection()) {
            notifySelectionCleared(clearSelectionQuietly());
            notifySelectionChanged();
        }
    }

    private Selection clearSelectionQuietly() {
        this.mRange = null;
        MutableSelection mutableSelection = new MutableSelection();
        if (hasSelection()) {
            copySelection(mutableSelection);
            this.mSelection.clear();
        }
        return mutableSelection;
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public boolean select(K k) {
        Preconditions.checkArgument(k != null);
        if (this.mSelection.contains(k) || !canSetState(k, true)) {
            return false;
        }
        if (this.mSingleSelect && hasSelection()) {
            notifySelectionCleared(clearSelectionQuietly());
        }
        this.mSelection.add(k);
        notifyItemStateChanged(k, true);
        notifySelectionChanged();
        return true;
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public boolean deselect(K k) {
        Preconditions.checkArgument(k != null);
        if (!this.mSelection.contains(k) || !canSetState(k, false)) {
            return false;
        }
        this.mSelection.remove(k);
        notifyItemStateChanged(k, false);
        notifySelectionChanged();
        if (this.mSelection.isEmpty() && isRangeActive()) {
            endRange();
        }
        return true;
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void startRange(int i) {
        if (this.mSelection.contains(this.mKeyProvider.getKey(i)) || select(this.mKeyProvider.getKey(i))) {
            anchorRange(i);
        }
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void extendRange(int i) {
        extendRange(i, 0);
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void endRange() {
        this.mRange = null;
        clearProvisionalSelection();
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void anchorRange(int i) {
        Preconditions.checkArgument(i != -1);
        Preconditions.checkArgument(this.mSelection.contains(this.mKeyProvider.getKey(i)));
        this.mRange = new Range(i, this.mRangeCallbacks);
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void extendProvisionalRange(int i) {
        if (!this.mSingleSelect) {
            Preconditions.checkState(isRangeActive(), "Range start point not set.");
            extendRange(i, 1);
        }
    }

    private void extendRange(int i, int i2) {
        Preconditions.checkState(isRangeActive(), "Range start point not set.");
        this.mRange.extendRange(i, i2);
        notifySelectionChanged();
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void setProvisionalSelection(Set<K> set) {
        if (!this.mSingleSelect) {
            for (Map.Entry<K, Boolean> entry : this.mSelection.setProvisionalSelection(set).entrySet()) {
                notifyItemStateChanged(entry.getKey(), entry.getValue().booleanValue());
            }
            notifySelectionChanged();
        }
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void mergeProvisionalSelection() {
        this.mSelection.mergeProvisionalSelection();
        notifySelectionChanged();
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public void clearProvisionalSelection() {
        for (K k : this.mSelection.mProvisionalSelection) {
            notifyItemStateChanged(k, false);
        }
        this.mSelection.clearProvisionalSelection();
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public boolean isRangeActive() {
        return this.mRange != null;
    }

    private boolean canSetState(K k, boolean z) {
        return this.mSelectionPredicate.canSetStateForKey(k, z);
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    RecyclerView.AdapterDataObserver getAdapterDataObserver() {
        return this.mAdapterObserver;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: androidx.recyclerview.selection.DefaultSelectionTracker<K> */
    /* JADX WARN: Multi-variable type inference failed */
    void onDataSetChanged() {
        this.mSelection.clearProvisionalSelection();
        notifySelectionRefresh();
        Iterator<K> it2 = this.mSelection.iterator();
        ArrayList<Object> arrayList = null;
        while (it2.hasNext()) {
            K next = it2.next();
            if (!canSetState(next, true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            } else {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    this.mObservers.get(size).onItemStateChanged(next, true);
                }
            }
        }
        if (arrayList != null) {
            for (Object obj : arrayList) {
                deselect(obj);
            }
        }
        notifySelectionChanged();
    }

    private void notifyItemStateChanged(K k, boolean z) {
        Preconditions.checkArgument(k != null);
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            this.mObservers.get(size).onItemStateChanged(k, z);
        }
    }

    private void notifySelectionCleared(Selection<K> selection) {
        for (K k : selection.mSelection) {
            notifyItemStateChanged(k, false);
        }
        for (K k2 : selection.mProvisionalSelection) {
            notifyItemStateChanged(k2, false);
        }
    }

    private void notifySelectionChanged() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            this.mObservers.get(size).onSelectionChanged();
        }
    }

    private void notifySelectionRestored() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            this.mObservers.get(size).onSelectionRestored();
        }
    }

    private void notifySelectionRefresh() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            this.mObservers.get(size).onSelectionRefresh();
        }
    }

    private void updateForRange(int i, int i2, boolean z, int i3) {
        if (i3 == 0) {
            updateForRegularRange(i, i2, z);
        } else if (i3 == 1) {
            updateForProvisionalRange(i, i2, z);
        } else {
            throw new IllegalArgumentException("Invalid range type: " + i3);
        }
    }

    void updateForRegularRange(int i, int i2, boolean z) {
        Preconditions.checkArgument(i2 >= i);
        while (i <= i2) {
            K key = this.mKeyProvider.getKey(i);
            if (key != null) {
                if (z) {
                    select(key);
                } else {
                    deselect(key);
                }
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[SYNTHETIC] */
    void updateForProvisionalRange(int i, int i2, boolean z) {
        boolean z2;
        Preconditions.checkArgument(i2 >= i);
        while (i <= i2) {
            K key = this.mKeyProvider.getKey(i);
            if (key != null) {
                if (!z) {
                    this.mSelection.mProvisionalSelection.remove(key);
                } else if (!canSetState(key, true) || this.mSelection.mSelection.contains(key)) {
                    z2 = false;
                    if (!z2) {
                        notifyItemStateChanged(key, z);
                    }
                } else {
                    this.mSelection.mProvisionalSelection.add(key);
                }
                z2 = true;
                if (!z2) {
                }
            }
            i++;
        }
        notifySelectionChanged();
    }

    String getInstanceStateKey() {
        return "androidx.recyclerview.selection:" + this.mSelectionId;
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public final void onSaveInstanceState(Bundle bundle) {
        if (!this.mSelection.isEmpty()) {
            bundle.putBundle(getInstanceStateKey(), this.mStorage.asBundle(this.mSelection));
        }
    }

    @Override // androidx.recyclerview.selection.SelectionTracker
    public final void onRestoreInstanceState(Bundle bundle) {
        Bundle bundle2;
        Selection<K> asSelection;
        if (bundle != null && (bundle2 = bundle.getBundle(getInstanceStateKey())) != null && (asSelection = this.mStorage.asSelection(bundle2)) != null && !asSelection.isEmpty()) {
            restoreSelection(asSelection);
        }
    }

    private final class RangeCallbacks extends Range.Callbacks {
        RangeCallbacks() {
        }

        @Override // androidx.recyclerview.selection.Range.Callbacks
        void updateForRange(int i, int i2, boolean z, int i3) {
            if (i3 == 0) {
                DefaultSelectionTracker.this.updateForRegularRange(i, i2, z);
            } else if (i3 == 1) {
                DefaultSelectionTracker.this.updateForProvisionalRange(i, i2, z);
            } else {
                throw new IllegalArgumentException("Invalid range type: " + i3);
            }
        }
    }

    private static final class AdapterObserver extends RecyclerView.AdapterDataObserver {
        private final DefaultSelectionTracker<?> mSelectionTracker;

        AdapterObserver(DefaultSelectionTracker<?> defaultSelectionTracker) {
            Preconditions.checkArgument(defaultSelectionTracker != null);
            this.mSelectionTracker = defaultSelectionTracker;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.mSelectionTracker.onDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            if (!"Selection-Changed".equals(obj)) {
                this.mSelectionTracker.onDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            this.mSelectionTracker.endRange();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            this.mSelectionTracker.endRange();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            this.mSelectionTracker.endRange();
        }
    }
}
