package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;

    public abstract void handleOnBackPressed();

    public OnBackPressedCallback(boolean z) {
        this.mEnabled = z;
    }

    public final void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        Iterator<Cancellable> it2 = this.mCancellables.iterator();
        while (it2.hasNext()) {
            it2.next().cancel();
        }
    }

    void addCancellable(Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    void removeCancellable(Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }
}
