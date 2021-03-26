package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: InlineList.kt */
public final class InlineList<E> {
    private final Object holder;

    /* renamed from: box-impl */
    public static final /* synthetic */ InlineList m1427boximpl(Object obj) {
        return new InlineList(obj);
    }

    /* renamed from: constructor-impl */
    public static Object m1428constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl */
    public static boolean m1430equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.areEqual(obj, ((InlineList) obj2).m1436unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m1431equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: hashCode-impl */
    public static int m1433hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl */
    public static String m1435toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return m1430equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m1433hashCodeimpl(this.holder);
    }

    public String toString() {
        return m1435toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ Object m1436unboximpl() {
        return this.holder;
    }

    private /* synthetic */ InlineList(Object obj) {
        this.holder = obj;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ Object m1429constructorimpl$default(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m1428constructorimpl(obj);
    }

    /* renamed from: plus-UZ7vuAc */
    public static final Object m1434plusUZ7vuAc(Object obj, E e) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(e instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            return m1428constructorimpl(e);
        } else {
            if (obj instanceof ArrayList) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
                ((ArrayList) obj).add(e);
                return m1428constructorimpl(obj);
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            return m1428constructorimpl(arrayList);
        }
    }

    /* renamed from: forEachReversed-impl */
    public static final void m1432forEachReversedimpl(Object obj, Function1<? super E, Unit> function1) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                function1.invoke(obj);
                return;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            ArrayList arrayList = (ArrayList) obj;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                function1.invoke((Object) arrayList.get(size));
            }
        }
    }
}
