package androidx.recyclerview.selection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Selection<K> implements Iterable<K> {
    final Set<K> mProvisionalSelection;
    final Set<K> mSelection;

    Selection() {
        this.mSelection = new HashSet();
        this.mProvisionalSelection = new HashSet();
    }

    Selection(Set<K> set) {
        this.mSelection = set;
        this.mProvisionalSelection = new HashSet();
    }

    public boolean contains(K k) {
        return this.mSelection.contains(k) || this.mProvisionalSelection.contains(k);
    }

    @Override // java.lang.Iterable
    public Iterator<K> iterator() {
        return this.mSelection.iterator();
    }

    public int size() {
        return this.mSelection.size() + this.mProvisionalSelection.size();
    }

    public boolean isEmpty() {
        return this.mSelection.isEmpty() && this.mProvisionalSelection.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.util.Set<K> */
    /* JADX WARN: Multi-variable type inference failed */
    Map<K, Boolean> setProvisionalSelection(Set<K> set) {
        HashMap hashMap = new HashMap();
        for (K k : this.mProvisionalSelection) {
            if (!set.contains(k) && !this.mSelection.contains(k)) {
                hashMap.put(k, false);
            }
        }
        for (K k2 : this.mSelection) {
            if (!set.contains(k2)) {
                hashMap.put(k2, false);
            }
        }
        for (K k3 : set) {
            if (!this.mSelection.contains(k3) && !this.mProvisionalSelection.contains(k3)) {
                hashMap.put(k3, true);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            Object key = entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue()) {
                this.mProvisionalSelection.add(key);
            } else {
                this.mProvisionalSelection.remove(key);
            }
        }
        return hashMap;
    }

    void mergeProvisionalSelection() {
        this.mSelection.addAll(this.mProvisionalSelection);
        this.mProvisionalSelection.clear();
    }

    void clearProvisionalSelection() {
        this.mProvisionalSelection.clear();
    }

    boolean add(K k) {
        return this.mSelection.add(k);
    }

    boolean remove(K k) {
        return this.mSelection.remove(k);
    }

    void clear() {
        this.mSelection.clear();
    }

    void copyFrom(Selection<K> selection) {
        this.mSelection.clear();
        this.mSelection.addAll(selection.mSelection);
        this.mProvisionalSelection.clear();
        this.mProvisionalSelection.addAll(selection.mProvisionalSelection);
    }

    @Override // java.lang.Object
    public String toString() {
        if (size() <= 0) {
            return "size=0, items=[]";
        }
        StringBuilder sb = new StringBuilder(size() * 28);
        sb.append("Selection{");
        sb.append("primary{size=" + this.mSelection.size());
        sb.append(", entries=" + this.mSelection);
        sb.append("}, provisional{size=" + this.mProvisionalSelection.size());
        sb.append(", entries=" + this.mProvisionalSelection);
        sb.append("}}");
        return sb.toString();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.mSelection.hashCode() ^ this.mProvisionalSelection.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Selection) && isEqualTo((Selection) obj));
    }

    private boolean isEqualTo(Selection selection) {
        return this.mSelection.equals(selection.mSelection) && this.mProvisionalSelection.equals(selection.mProvisionalSelection);
    }
}
