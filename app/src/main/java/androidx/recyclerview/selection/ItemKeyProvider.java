package androidx.recyclerview.selection;

import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ItemKeyProvider<K> {
    public static final int SCOPE_CACHED = 1;
    public static final int SCOPE_MAPPED = 0;
    private final int mScope;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scope {
    }

    public abstract K getKey(int i);

    public abstract int getPosition(K k);

    protected ItemKeyProvider(int i) {
        boolean z = true;
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.mScope = i;
    }

    final boolean hasAccess(int i) {
        return i == this.mScope;
    }
}
