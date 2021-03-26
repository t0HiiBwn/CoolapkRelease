package group.infotech.drawable.dsl;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lgroup/infotech/drawable/dsl/ViewStates;", "", "()V", "checked", "", "disabled", "enabled", "notPressed", "notSelected", "pressed", "selected", "unchecked", "build_release"}, k = 1, mv = {1, 1, 7})
/* compiled from: states.kt */
public final class ViewStates {
    public static final ViewStates INSTANCE = null;

    public final int[] checked() {
        return new int[]{16842912};
    }

    public final int[] disabled() {
        return new int[]{-16842910};
    }

    public final int[] enabled() {
        return new int[]{16842910};
    }

    public final int[] notPressed() {
        return new int[]{-16842919};
    }

    public final int[] notSelected() {
        return new int[]{-16842913};
    }

    public final int[] pressed() {
        return new int[]{16842919};
    }

    public final int[] selected() {
        return new int[]{16842913};
    }

    public final int[] unchecked() {
        return new int[]{-16842912};
    }

    static {
        new ViewStates();
    }

    private ViewStates() {
        INSTANCE = this;
    }
}
