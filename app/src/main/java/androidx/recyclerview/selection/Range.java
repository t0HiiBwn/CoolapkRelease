package androidx.recyclerview.selection;

import android.util.Log;
import androidx.core.util.Preconditions;

final class Range {
    private static final String TAG = "Range";
    static final int TYPE_PRIMARY = 0;
    static final int TYPE_PROVISIONAL = 1;
    private final int mBegin;
    private final Callbacks mCallbacks;
    private int mEnd = -1;

    Range(int i, Callbacks callbacks) {
        this.mBegin = i;
        this.mCallbacks = callbacks;
    }

    void extendRange(int i, int i2) {
        Preconditions.checkArgument(i != -1, "Position cannot be NO_POSITION.");
        int i3 = this.mEnd;
        if (i3 == -1 || i3 == this.mBegin) {
            this.mEnd = -1;
            establishRange(i, i2);
            return;
        }
        reviseRange(i, i2);
    }

    private void establishRange(int i, int i2) {
        Preconditions.checkArgument(this.mEnd == -1, "End has already been set.");
        this.mEnd = i;
        int i3 = this.mBegin;
        if (i > i3) {
            updateRange(i3 + 1, i, true, i2);
        } else if (i < i3) {
            updateRange(i, i3 - 1, true, i2);
        }
    }

    private void reviseRange(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(this.mEnd != -1, "End must already be set.");
        if (this.mBegin == this.mEnd) {
            z = false;
        }
        Preconditions.checkArgument(z, "Beging and end point to same position.");
        int i3 = this.mEnd;
        int i4 = this.mBegin;
        if (i3 > i4) {
            reviseAscending(i, i2);
        } else if (i3 < i4) {
            reviseDescending(i, i2);
        }
        this.mEnd = i;
    }

    private void reviseAscending(int i, int i2) {
        int i3 = this.mEnd;
        if (i < i3) {
            int i4 = this.mBegin;
            if (i < i4) {
                updateRange(i4 + 1, i3, false, i2);
                updateRange(i, this.mBegin - 1, true, i2);
                return;
            }
            updateRange(i + 1, i3, false, i2);
        } else if (i > i3) {
            updateRange(i3 + 1, i, true, i2);
        }
    }

    private void reviseDescending(int i, int i2) {
        int i3 = this.mEnd;
        if (i > i3) {
            int i4 = this.mBegin;
            if (i > i4) {
                updateRange(i3, i4 - 1, false, i2);
                updateRange(this.mBegin + 1, i, true, i2);
                return;
            }
            updateRange(i3, i - 1, false, i2);
        } else if (i < i3) {
            updateRange(i, i3 - 1, true, i2);
        }
    }

    private void updateRange(int i, int i2, boolean z, int i3) {
        this.mCallbacks.updateForRange(i, i2, z, i3);
    }

    public String toString() {
        return "Range{begin=" + this.mBegin + ", end=" + this.mEnd + "}";
    }

    private void log(int i, String str) {
        String str2 = i == 0 ? "PRIMARY" : "PROVISIONAL";
        Log.d("Range", String.valueOf(this) + ": " + str + " (" + str2 + ")");
    }

    static abstract class Callbacks {
        abstract void updateForRange(int i, int i2, boolean z, int i3);

        Callbacks() {
        }
    }
}
