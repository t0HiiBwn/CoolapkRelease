package androidx.recyclerview.selection;

import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class OperationMonitor {
    private static final String TAG = "OperationMonitor";
    private List<OnChangeListener> mListeners = new ArrayList();
    private int mNumOps = 0;

    public interface OnChangeListener {
        void onChanged();
    }

    synchronized void start() {
        int i = this.mNumOps + 1;
        this.mNumOps = i;
        if (i == 1) {
            for (OnChangeListener onChangeListener : this.mListeners) {
                onChangeListener.onChanged();
            }
        }
    }

    synchronized void stop() {
        Preconditions.checkState(this.mNumOps > 0);
        int i = this.mNumOps - 1;
        this.mNumOps = i;
        if (i == 0) {
            for (OnChangeListener onChangeListener : this.mListeners) {
                onChangeListener.onChanged();
            }
        }
    }

    public synchronized boolean isStarted() {
        return this.mNumOps > 0;
    }

    public void addListener(OnChangeListener onChangeListener) {
        Preconditions.checkArgument(onChangeListener != null);
        this.mListeners.add(onChangeListener);
    }

    public void removeListener(OnChangeListener onChangeListener) {
        Preconditions.checkArgument(onChangeListener != null);
        this.mListeners.remove(onChangeListener);
    }

    void checkStarted() {
        Preconditions.checkState(this.mNumOps > 0);
    }

    void checkStopped() {
        Preconditions.checkState(this.mNumOps == 0);
    }
}
