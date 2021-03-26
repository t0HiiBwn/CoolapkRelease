package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: InlineList.kt */
public final class InlineList<E> {
    private final Object holder;

    /* renamed from: box-impl */
    public static final /* synthetic */ InlineList m2015boximpl(Object obj) {
        return new InlineList(obj);
    }

    /* renamed from: constructor-impl */
    public static Object m2016constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl */
    public static boolean m2018equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.areEqual(obj, ((InlineList) obj2).m2024unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m2019equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: hashCode-impl */
    public static int m2021hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl */
    public static String m2023toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return m2018equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m2021hashCodeimpl(this.holder);
    }

    public String toString() {
        return m2023toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ Object m2024unboximpl() {
        return this.holder;
    }

    private /* synthetic */ InlineList(Object obj) {
        this.holder = obj;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ Object m2017constructorimpl$default(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m2016constructorimpl(obj);
    }

    /* renamed from: plus-impl */
    public static final Object m2022plusimpl(Object obj, E e) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(e instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            return m2016constructorimpl(e);
        } else {
            if (!(obj instanceof ArrayList)) {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(obj);
                arrayList.add(e);
                return m2016constructorimpl(arrayList);
            } else if (obj != null) {
                ((ArrayList) obj).add(e);
                return m2016constructorimpl(obj);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
        }
    }

    /* renamed from: forEachReversed-impl */
    public static final void m2020forEachReversedimpl(Object obj, Function1<? super E, Unit> function1) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                function1.invoke(obj);
            } else if (obj != null) {
                ArrayList arrayList = (ArrayList) obj;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    function1.invoke((Object) arrayList.get(size));
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
        }
    }
}
