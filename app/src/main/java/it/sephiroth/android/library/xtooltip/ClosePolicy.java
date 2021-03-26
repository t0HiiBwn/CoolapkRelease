package it.sephiroth.android.library.xtooltip;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lit/sephiroth/android/library/xtooltip/ClosePolicy;", "", "policy", "", "(I)V", "anywhere", "", "consume", "inside", "outside", "toString", "", "Builder", "Companion", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: Tooltip.kt */
public final class ClosePolicy {
    private static final int CONSUME = 8;
    public static final Companion Companion = new Companion(null);
    private static final int NONE = 0;
    private static final ClosePolicy TOUCH_ANYWHERE_CONSUME = new ClosePolicy(14);
    private static final ClosePolicy TOUCH_ANYWHERE_NO_CONSUME = new ClosePolicy(6);
    private static final int TOUCH_INSIDE = 2;
    private static final ClosePolicy TOUCH_INSIDE_CONSUME = new ClosePolicy(10);
    private static final ClosePolicy TOUCH_INSIDE_NO_CONSUME = new ClosePolicy(2);
    private static final ClosePolicy TOUCH_NONE = new ClosePolicy(0);
    private static final int TOUCH_OUTSIDE = 4;
    private static final ClosePolicy TOUCH_OUTSIDE_CONSUME = new ClosePolicy(12);
    private static final ClosePolicy TOUCH_OUTSIDE_NO_CONSUME = new ClosePolicy(4);
    private final int policy;

    public ClosePolicy(int i) {
        this.policy = i;
    }

    public final boolean consume() {
        return (this.policy & 8) == 8;
    }

    public final boolean inside() {
        return (this.policy & 2) == 2;
    }

    public final boolean outside() {
        return (this.policy & 4) == 4;
    }

    public final boolean anywhere() {
        return inside() & outside();
    }

    public String toString() {
        return "ClosePolicy{policy: " + this.policy + ", inside:" + inside() + ", outside: " + outside() + ", anywhere: " + anywhere() + ", consume: " + consume() + '}';
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lit/sephiroth/android/library/xtooltip/ClosePolicy$Builder;", "", "()V", "policy", "", "build", "Lit/sephiroth/android/library/xtooltip/ClosePolicy;", "clear", "", "consume", "value", "", "inside", "outside", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Tooltip.kt */
    public static final class Builder {
        private int policy;

        public final Builder consume(boolean z) {
            this.policy = z ? this.policy | 8 : this.policy & -9;
            return this;
        }

        public final Builder inside(boolean z) {
            this.policy = z ? this.policy | 2 : this.policy & -3;
            return this;
        }

        public final Builder outside(boolean z) {
            this.policy = z ? this.policy | 4 : this.policy & -5;
            return this;
        }

        public final void clear() {
            this.policy = 0;
        }

        public final ClosePolicy build() {
            return new ClosePolicy(this.policy);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"Lit/sephiroth/android/library/xtooltip/ClosePolicy$Companion;", "", "()V", "CONSUME", "", "NONE", "TOUCH_ANYWHERE_CONSUME", "Lit/sephiroth/android/library/xtooltip/ClosePolicy;", "getTOUCH_ANYWHERE_CONSUME", "()Lit/sephiroth/android/library/xtooltip/ClosePolicy;", "TOUCH_ANYWHERE_NO_CONSUME", "getTOUCH_ANYWHERE_NO_CONSUME", "TOUCH_INSIDE", "TOUCH_INSIDE_CONSUME", "getTOUCH_INSIDE_CONSUME", "TOUCH_INSIDE_NO_CONSUME", "getTOUCH_INSIDE_NO_CONSUME", "TOUCH_NONE", "getTOUCH_NONE", "TOUCH_OUTSIDE", "TOUCH_OUTSIDE_CONSUME", "getTOUCH_OUTSIDE_CONSUME", "TOUCH_OUTSIDE_NO_CONSUME", "getTOUCH_OUTSIDE_NO_CONSUME", "xtooltip_release"}, k = 1, mv = {1, 1, 13})
    /* compiled from: Tooltip.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClosePolicy getTOUCH_NONE() {
            return ClosePolicy.TOUCH_NONE;
        }

        public final ClosePolicy getTOUCH_INSIDE_CONSUME() {
            return ClosePolicy.TOUCH_INSIDE_CONSUME;
        }

        public final ClosePolicy getTOUCH_INSIDE_NO_CONSUME() {
            return ClosePolicy.TOUCH_INSIDE_NO_CONSUME;
        }

        public final ClosePolicy getTOUCH_OUTSIDE_CONSUME() {
            return ClosePolicy.TOUCH_OUTSIDE_CONSUME;
        }

        public final ClosePolicy getTOUCH_OUTSIDE_NO_CONSUME() {
            return ClosePolicy.TOUCH_OUTSIDE_NO_CONSUME;
        }

        public final ClosePolicy getTOUCH_ANYWHERE_NO_CONSUME() {
            return ClosePolicy.TOUCH_ANYWHERE_NO_CONSUME;
        }

        public final ClosePolicy getTOUCH_ANYWHERE_CONSUME() {
            return ClosePolicy.TOUCH_ANYWHERE_CONSUME;
        }
    }
}
