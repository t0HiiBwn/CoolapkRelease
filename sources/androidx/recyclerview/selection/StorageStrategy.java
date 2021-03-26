package androidx.recyclerview.selection;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class StorageStrategy<K> {
    static final String SELECTION_ENTRIES = "androidx.recyclerview.selection.entries";
    static final String SELECTION_KEY_TYPE = "androidx.recyclerview.selection.type";
    private final Class<K> mType;

    public abstract Bundle asBundle(Selection<K> selection);

    public abstract Selection<K> asSelection(Bundle bundle);

    public StorageStrategy(Class<K> cls) {
        Preconditions.checkArgument(cls != null);
        this.mType = cls;
    }

    String getKeyTypeName() {
        return this.mType.getCanonicalName();
    }

    public static <K extends Parcelable> StorageStrategy<K> createParcelableStorage(Class<K> cls) {
        return new ParcelableStorageStrategy(cls);
    }

    public static StorageStrategy<String> createStringStorage() {
        return new StringStorageStrategy();
    }

    public static StorageStrategy<Long> createLongStorage() {
        return new LongStorageStrategy();
    }

    private static class StringStorageStrategy extends StorageStrategy<String> {
        StringStorageStrategy() {
            super(String.class);
        }

        @Override // androidx.recyclerview.selection.StorageStrategy
        public Selection<String> asSelection(Bundle bundle) {
            ArrayList<String> stringArrayList;
            String string = bundle.getString("androidx.recyclerview.selection.type", null);
            if (string == null || !string.equals(getKeyTypeName()) || (stringArrayList = bundle.getStringArrayList("androidx.recyclerview.selection.entries")) == null) {
                return null;
            }
            Selection<String> selection = new Selection<>();
            selection.mSelection.addAll(stringArrayList);
            return selection;
        }

        @Override // androidx.recyclerview.selection.StorageStrategy
        public Bundle asBundle(Selection<String> selection) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.recyclerview.selection.type", getKeyTypeName());
            ArrayList<String> arrayList = new ArrayList<>(selection.size());
            arrayList.addAll(selection.mSelection);
            bundle.putStringArrayList("androidx.recyclerview.selection.entries", arrayList);
            return bundle;
        }
    }

    private static class LongStorageStrategy extends StorageStrategy<Long> {
        LongStorageStrategy() {
            super(Long.class);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Set<K> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.selection.StorageStrategy
        public Selection<Long> asSelection(Bundle bundle) {
            long[] longArray;
            String string = bundle.getString("androidx.recyclerview.selection.type", null);
            if (string == null || !string.equals(getKeyTypeName()) || (longArray = bundle.getLongArray("androidx.recyclerview.selection.entries")) == null) {
                return null;
            }
            Selection<Long> selection = new Selection<>();
            for (long j : longArray) {
                selection.mSelection.add(Long.valueOf(j));
            }
            return selection;
        }

        @Override // androidx.recyclerview.selection.StorageStrategy
        public Bundle asBundle(Selection<Long> selection) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.recyclerview.selection.type", getKeyTypeName());
            long[] jArr = new long[selection.size()];
            Iterator<Long> it2 = selection.iterator();
            int i = 0;
            while (it2.hasNext()) {
                jArr[i] = it2.next().longValue();
                i++;
            }
            bundle.putLongArray("androidx.recyclerview.selection.entries", jArr);
            return bundle;
        }
    }

    private static class ParcelableStorageStrategy<K extends Parcelable> extends StorageStrategy<K> {
        ParcelableStorageStrategy(Class<K> cls) {
            super(cls);
            Preconditions.checkArgument(Parcelable.class.isAssignableFrom(cls));
        }

        @Override // androidx.recyclerview.selection.StorageStrategy
        public Selection<K> asSelection(Bundle bundle) {
            ArrayList parcelableArrayList;
            String string = bundle.getString("androidx.recyclerview.selection.type", null);
            if (string == null || !string.equals(getKeyTypeName()) || (parcelableArrayList = bundle.getParcelableArrayList("androidx.recyclerview.selection.entries")) == null) {
                return null;
            }
            Selection<K> selection = new Selection<>();
            selection.mSelection.addAll(parcelableArrayList);
            return selection;
        }

        @Override // androidx.recyclerview.selection.StorageStrategy
        public Bundle asBundle(Selection<K> selection) {
            Bundle bundle = new Bundle();
            bundle.putString("androidx.recyclerview.selection.type", getKeyTypeName());
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(selection.size());
            arrayList.addAll(selection.mSelection);
            bundle.putParcelableArrayList("androidx.recyclerview.selection.entries", arrayList);
            return bundle;
        }
    }
}
