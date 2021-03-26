package androidx.recyclerview.selection;

public final class MutableSelection<K> extends Selection<K> {
    @Override // androidx.recyclerview.selection.Selection
    public boolean add(K k) {
        return super.add(k);
    }

    @Override // androidx.recyclerview.selection.Selection
    public boolean remove(K k) {
        return super.remove(k);
    }

    @Override // androidx.recyclerview.selection.Selection
    public void copyFrom(Selection<K> selection) {
        super.copyFrom(selection);
    }

    @Override // androidx.recyclerview.selection.Selection
    public void clear() {
        super.clear();
    }
}
