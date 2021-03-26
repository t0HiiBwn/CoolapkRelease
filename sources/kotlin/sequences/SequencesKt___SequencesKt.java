package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: _Sequences.kt */
class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Sequence<T> asSequence(Sequence<? extends T> sequence) {
        return sequence;
    }

    public static final <T> boolean contains(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$contains");
        return SequencesKt.indexOf(sequence, t) >= 0;
    }

    public static final <T> T elementAt(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "$this$elementAt");
        return (T) SequencesKt.elementAtOrElse(sequence, i, new SequencesKt___SequencesKt$elementAt$1(i));
    }

    public static final <T> T elementAtOrElse(Sequence<? extends T> sequence, int i, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (i < 0) {
            return (T) function1.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return (T) function1.invoke(Integer.valueOf(i));
    }

    public static final <T> T elementAtOrNull(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "$this$elementAtOrNull");
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T t : sequence) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return null;
    }

    public static final <T> T first(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$first");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            return (T) it2.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T first(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            ?? r0 = (Object) it2.next();
            if (function1.invoke(r0).booleanValue()) {
                return r0;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> T firstOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$firstOrNull");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        return (T) it2.next();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T firstOrNull(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            ?? r0 = (Object) it2.next();
            if (function1.invoke(r0).booleanValue()) {
                return r0;
            }
        }
        return null;
    }

    public static final <T> int indexOf(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$indexOf");
        int i = 0;
        for (Object obj : sequence) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function1.invoke(obj).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = -1;
        int i2 = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function1.invoke(obj).booleanValue()) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    public static final <T> T last(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$last");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T t = (T) it2.next();
            while (it2.hasNext()) {
                t = (T) it2.next();
            }
            return t;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T last(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        T t = null;
        boolean z = false;
        while (it2.hasNext()) {
            ?? r2 = (Object) it2.next();
            if (function1.invoke(r2).booleanValue()) {
                t = r2;
                z = true;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$lastIndexOf");
        int i = -1;
        int i2 = 0;
        for (Object obj : sequence) {
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, obj)) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    public static final <T> T lastOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$lastOrNull");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t = (T) it2.next();
        while (it2.hasNext()) {
            t = (T) it2.next();
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T lastOrNull(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        T t = null;
        while (it2.hasNext()) {
            ?? r1 = (Object) it2.next();
            if (function1.invoke(r1).booleanValue()) {
                t = r1;
            }
        }
        return t;
    }

    public static final <T> T single(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$single");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            T t = (T) it2.next();
            if (!it2.hasNext()) {
                return t;
            }
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T single(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        T t = null;
        boolean z = false;
        while (it2.hasNext()) {
            ?? r2 = (Object) it2.next();
            if (function1.invoke(r2).booleanValue()) {
                if (!z) {
                    t = r2;
                    z = true;
                } else {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> T singleOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$singleOrNull");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t = (T) it2.next();
        if (it2.hasNext()) {
            return null;
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T singleOrNull(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        boolean z = false;
        T t = null;
        while (it2.hasNext()) {
            ?? r3 = (Object) it2.next();
            if (function1.invoke(r3).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = r3;
            }
        }
        if (!z) {
            return null;
        }
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> drop(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "$this$drop");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return sequence;
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).drop(i);
            }
            return new DropSequence(sequence, i);
        }
    }

    public static final <T> Sequence<T> dropWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new DropWhileSequence(sequence, function1);
    }

    public static final <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new FilteringSequence(sequence, true, function1);
    }

    public static final <T> Sequence<T> filterIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        return new TransformingSequence(new FilteringSequence(new IndexingSequence(sequence), true, new SequencesKt___SequencesKt$filterIndexed$1(function2)), SequencesKt___SequencesKt$filterIndexed$2.INSTANCE);
    }

    public static final /* synthetic */ <R> Sequence<R> filterIsInstance(Sequence<?> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIsInstance");
        Intrinsics.needClassReification();
        Sequence<R> filter = SequencesKt.filter(sequence, SequencesKt___SequencesKt$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return filter;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Sequence<?> sequence, C c) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIsInstanceTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (Object obj : sequence) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new FilteringSequence(sequence, false, function1);
    }

    public static final <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNotNull");
        Sequence<T> filterNot = SequencesKt.filterNot(sequence, SequencesKt___SequencesKt$filterNotNull$1.INSTANCE);
        Objects.requireNonNull(filterNot, "null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
        return filterNot;
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Sequence<? extends T> sequence, C c) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNotNullTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (Object obj : sequence) {
            if (obj != null) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Sequence<? extends T> sequence, C c, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            if (!function1.invoke(obj).booleanValue()) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Sequence<? extends T> sequence, C c, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            if (function1.invoke(obj).booleanValue()) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T> Sequence<T> take(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return SequencesKt.emptySequence();
        } else {
            if (sequence instanceof DropTakeSequence) {
                return ((DropTakeSequence) sequence).take(i);
            }
            return new TakeSequence(sequence, i);
        }
    }

    public static final <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return new TakeWhileSequence(sequence, function1);
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sorted(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sorted");
        return new SequencesKt___SequencesKt$sorted$1(sequence);
    }

    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return SequencesKt.sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return SequencesKt.sortedWith(sequence, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedDescending");
        return SequencesKt.sortedWith(sequence, ComparisonsKt.reverseOrder());
    }

    public static final <T> Sequence<T> sortedWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new SequencesKt___SequencesKt$sortedWith$1(sequence, comparator);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(Sequence<? extends T> sequence, Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it2.next());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, T> associateBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            linkedHashMap.put(function1.invoke(obj), obj);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associateBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            linkedHashMap.put(function1.invoke(obj), function12.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Sequence<? extends T> sequence, M m, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            m.put(function1.invoke(obj), obj);
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Sequence<? extends T> sequence, M m, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            m.put(function1.invoke(obj), function12.invoke(obj));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Sequence<? extends T> sequence, M m, Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it2.next());
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> associateWith(Sequence<? extends K> sequence, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateWith");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            linkedHashMap.put(obj, function1.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Sequence<? extends K> sequence, M m, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        Iterator<? extends K> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            m.put(obj, function1.invoke(obj));
        }
        return m;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C c) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c, "destination");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            c.add(it2.next());
        }
        return c;
    }

    public static final <T> HashSet<T> toHashSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toHashSet");
        return (HashSet) SequencesKt.toCollection(sequence, new HashSet());
    }

    public static final <T> List<T> toList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toList");
        return CollectionsKt.optimizeReadOnlyList(SequencesKt.toMutableList(sequence));
    }

    public static final <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toMutableList");
        return (List) SequencesKt.toCollection(sequence, new ArrayList());
    }

    public static final <T> Set<T> toSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toSet");
        return SetsKt.optimizeReadOnlySet((Set) SequencesKt.toCollection(sequence, new LinkedHashSet()));
    }

    public static final <T, R> Sequence<R> flatMapIterable(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new FlatteningSequence(sequence, function1, SequencesKt___SequencesKt$flatMap$1.INSTANCE);
    }

    public static final <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new FlatteningSequence(sequence, function1, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    public static final <T, R> Sequence<R> flatMapIndexedIterable(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return SequencesKt.flatMapIndexed(sequence, function2, SequencesKt___SequencesKt$flatMapIndexed$1.INSTANCE);
    }

    public static final <T, R> Sequence<R> flatMapIndexedSequence(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return SequencesKt.flatMapIndexed(sequence, function2, SequencesKt___SequencesKt$flatMapIndexed$2.INSTANCE);
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(Sequence<? extends T> sequence, C c, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> function2) {
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            CollectionsKt.addAll(c, (Iterable) function2.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return c;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(Sequence<? extends T> sequence, C c, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> function2) {
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            CollectionsKt.addAll(c, (Sequence) function2.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapIterableTo(Sequence<? extends T> sequence, C c, Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(c, (Iterable) function1.invoke((Object) it2.next()));
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Sequence<? extends T> sequence, C c, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(c, (Sequence) function1.invoke((Object) it2.next()));
        }
        return c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K> Map<K, List<T>> groupBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = linkedHashMap.get(invoke);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(invoke, obj2);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, List<V>> groupBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = linkedHashMap.get(invoke);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(invoke, obj2);
            }
            ((List) obj2).add(function12.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: M extends java.util.Map<? super K, java.util.List<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Sequence<? extends T> sequence, M m, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = m.get(invoke);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                m.put(invoke, obj2);
            }
            ((List) obj2).add(obj);
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: M extends java.util.Map<? super K, java.util.List<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Sequence<? extends T> sequence, M m, Function1<? super T, ? extends K> function1, Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = m.get(invoke);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                m.put(invoke, obj2);
            }
            ((List) obj2).add(function12.invoke(obj));
        }
        return m;
    }

    public static final <T, K> Grouping<T, K> groupingBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$groupingBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        return new SequencesKt___SequencesKt$groupingBy$1(sequence, function1);
    }

    public static final <T, R> Sequence<R> map(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return new TransformingSequence(sequence, function1);
    }

    public static final <T, R> Sequence<R> mapIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return new TransformingIndexedSequence(sequence, function2);
    }

    public static final <T, R> Sequence<R> mapIndexedNotNull(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexedNotNull");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return SequencesKt.filterNotNull(new TransformingIndexedSequence(sequence, function2));
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Sequence<? extends T> sequence, C c, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            c.add(function2.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return c;
    }

    public static final <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapNotNull");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return SequencesKt.filterNotNull(new TransformingSequence(sequence, function1));
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Sequence<? extends T> sequence, C c, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            c.add(function1.invoke((Object) it2.next()));
        }
        return c;
    }

    public static final <T> Sequence<IndexedValue<T>> withIndex(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$withIndex");
        return new IndexingSequence(sequence);
    }

    public static final <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$distinct");
        return SequencesKt.distinctBy(sequence, SequencesKt___SequencesKt$distinct$1.INSTANCE);
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new DistinctSequence(sequence, function1);
    }

    public static final <T> Set<T> toMutableSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$toMutableSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(it2.next());
        }
        return linkedHashSet;
    }

    public static final <T> boolean all(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            if (!function1.invoke((Object) it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$any");
        return sequence.iterator().hasNext();
    }

    public static final <T> boolean any(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            if (function1.invoke((Object) it2.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> int count(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$count");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            it2.next();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public static final <T> int count(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (function1.invoke((Object) it2.next()).booleanValue() && (i = i + 1) < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwCountOverflow();
                } else {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i;
    }

    public static final <T, R> R fold(Sequence<? extends T> sequence, R r, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            r = (R) function2.invoke(r, (Object) it2.next());
        }
        return r;
    }

    public static final <T, R> R foldIndexed(Sequence<? extends T> sequence, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            r = (R) function3.invoke(Integer.valueOf(i), r, obj);
            i = i2;
        }
        return r;
    }

    public static final <T> void forEach(Sequence<? extends T> sequence, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            function1.invoke((Object) it2.next());
        }
    }

    public static final <T> void forEachIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            function2.invoke(Integer.valueOf(i), obj);
            i = i2;
        }
    }

    /* renamed from: max */
    public static final Double m1308max(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$max");
        return SequencesKt.maxOrNull((Sequence<? extends Double>) sequence);
    }

    /* renamed from: max */
    public static final Float m1309max(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$max");
        return SequencesKt.maxOrNull((Sequence<? extends Float>) sequence);
    }

    public static final <T extends Comparable<? super T>> T max(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$max");
        return (T) SequencesKt.maxOrNull(sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        T t;
        Intrinsics.checkNotNullParameter(sequence, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        ?? r0 = (Object) it2.next();
        if (!it2.hasNext()) {
            return r0;
        }
        T t2 = r0;
        Comparable comparable = (Comparable) function1.invoke(r0);
        do {
            ?? r2 = (Object) it2.next();
            Comparable comparable2 = (Comparable) function1.invoke(r2);
            int compareTo = comparable.compareTo(comparable2);
            t = t2;
            Comparable comparable3 = comparable;
            if (compareTo < 0) {
                comparable3 = comparable2;
                t = r2;
            }
            t2 = t;
            comparable = comparable3;
        } while (it2.hasNext());
        return t;
    }

    private static final <T> double maxOf(Sequence<? extends T> sequence, Function1<? super T, Double> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            double doubleValue = function1.invoke((Object) it2.next()).doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.max(doubleValue, function1.invoke((Object) it2.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOf */
    private static final <T> float m1310maxOf(Sequence<? extends T> sequence, Function1<? super T, Float> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            float floatValue = function1.invoke((Object) it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.max(floatValue, function1.invoke((Object) it2.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Comparable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: maxOf */
    private static final <T, R extends Comparable<? super R>> R m1311maxOf(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            R r = (R) ((Comparable) function1.invoke((Object) it2.next()));
            while (it2.hasNext()) {
                ?? r1 = (Comparable) function1.invoke((Object) it2.next());
                if (r.compareTo(r1) < 0) {
                    r = r1;
                }
            }
            return r;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOfOrNull */
    private static final <T> Double m1312maxOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Double> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = function1.invoke((Object) it2.next()).doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.max(doubleValue, function1.invoke((Object) it2.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull */
    private static final <T> Float m1313maxOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Float> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = function1.invoke((Object) it2.next()).floatValue();
        while (it2.hasNext()) {
            floatValue = Math.max(floatValue, function1.invoke((Object) it2.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Comparable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R r = (R) ((Comparable) function1.invoke((Object) it2.next()));
        while (it2.hasNext()) {
            ?? r1 = (Comparable) function1.invoke((Object) it2.next());
            if (r.compareTo(r1) < 0) {
                r = r1;
            }
        }
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T, R> R maxOfWith(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            R r = (R) function1.invoke((Object) it2.next());
            while (it2.hasNext()) {
                ?? r1 = (Object) function1.invoke((Object) it2.next());
                if (comparator.compare(r, r1) < 0) {
                    r = r1;
                }
            }
            return r;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T, R> R maxOfWithOrNull(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R r = (R) function1.invoke((Object) it2.next());
        while (it2.hasNext()) {
            ?? r1 = (Object) function1.invoke((Object) it2.next());
            if (comparator.compare(r, r1) < 0) {
                r = r1;
            }
        }
        return r;
    }

    /* renamed from: maxOrNull */
    public static final Double m1314maxOrNull(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxOrNull");
        Iterator<Double> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.max(doubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOrNull */
    public static final Float m1315maxOrNull(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxOrNull");
        Iterator<Float> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            floatValue = Math.max(floatValue, it2.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T extends Comparable<? super T>> T maxOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxOrNull");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t = (T) ((Comparable) it2.next());
        while (it2.hasNext()) {
            ?? r1 = (Comparable) it2.next();
            if (t.compareTo(r1) < 0) {
                t = r1;
            }
        }
        return t;
    }

    public static final <T> T maxWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) SequencesKt.maxWithOrNull(sequence, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T maxWithOrNull(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t = (T) it2.next();
        while (it2.hasNext()) {
            ?? r1 = (Object) it2.next();
            if (comparator.compare(t, r1) < 0) {
                t = r1;
            }
        }
        return t;
    }

    /* renamed from: min */
    public static final Double m1316min(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$min");
        return SequencesKt.minOrNull((Sequence<? extends Double>) sequence);
    }

    /* renamed from: min */
    public static final Float m1317min(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$min");
        return SequencesKt.minOrNull((Sequence<? extends Float>) sequence);
    }

    public static final <T extends Comparable<? super T>> T min(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$min");
        return (T) SequencesKt.minOrNull(sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static final <T, R extends Comparable<? super R>> T minByOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        T t;
        Intrinsics.checkNotNullParameter(sequence, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        ?? r0 = (Object) it2.next();
        if (!it2.hasNext()) {
            return r0;
        }
        T t2 = r0;
        Comparable comparable = (Comparable) function1.invoke(r0);
        do {
            ?? r2 = (Object) it2.next();
            Comparable comparable2 = (Comparable) function1.invoke(r2);
            int compareTo = comparable.compareTo(comparable2);
            t = t2;
            Comparable comparable3 = comparable;
            if (compareTo > 0) {
                comparable3 = comparable2;
                t = r2;
            }
            t2 = t;
            comparable = comparable3;
        } while (it2.hasNext());
        return t;
    }

    private static final <T> double minOf(Sequence<? extends T> sequence, Function1<? super T, Double> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            double doubleValue = function1.invoke((Object) it2.next()).doubleValue();
            while (it2.hasNext()) {
                doubleValue = Math.min(doubleValue, function1.invoke((Object) it2.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOf */
    private static final <T> float m1318minOf(Sequence<? extends T> sequence, Function1<? super T, Float> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            float floatValue = function1.invoke((Object) it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.min(floatValue, function1.invoke((Object) it2.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Comparable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: minOf */
    private static final <T, R extends Comparable<? super R>> R m1319minOf(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            R r = (R) ((Comparable) function1.invoke((Object) it2.next()));
            while (it2.hasNext()) {
                ?? r1 = (Comparable) function1.invoke((Object) it2.next());
                if (r.compareTo(r1) > 0) {
                    r = r1;
                }
            }
            return r;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOfOrNull */
    private static final <T> Double m1320minOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Double> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = function1.invoke((Object) it2.next()).doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.min(doubleValue, function1.invoke((Object) it2.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull */
    private static final <T> Float m1321minOfOrNull(Sequence<? extends T> sequence, Function1<? super T, Float> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = function1.invoke((Object) it2.next()).floatValue();
        while (it2.hasNext()) {
            floatValue = Math.min(floatValue, function1.invoke((Object) it2.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Comparable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T, R extends Comparable<? super R>> R minOfOrNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R r = (R) ((Comparable) function1.invoke((Object) it2.next()));
        while (it2.hasNext()) {
            ?? r1 = (Comparable) function1.invoke((Object) it2.next());
            if (r.compareTo(r1) > 0) {
                r = r1;
            }
        }
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T, R> R minOfWith(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            R r = (R) function1.invoke((Object) it2.next());
            while (it2.hasNext()) {
                ?? r1 = (Object) function1.invoke((Object) it2.next());
                if (comparator.compare(r, r1) > 0) {
                    r = r1;
                }
            }
            return r;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super T */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T, R> R minOfWithOrNull(Sequence<? extends T> sequence, Comparator<? super R> comparator, Function1<? super T, ? extends R> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        R r = (R) function1.invoke((Object) it2.next());
        while (it2.hasNext()) {
            ?? r1 = (Object) function1.invoke((Object) it2.next());
            if (comparator.compare(r, r1) > 0) {
                r = r1;
            }
        }
        return r;
    }

    /* renamed from: minOrNull */
    public static final Double m1322minOrNull(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minOrNull");
        Iterator<Double> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        double doubleValue = it2.next().doubleValue();
        while (it2.hasNext()) {
            doubleValue = Math.min(doubleValue, it2.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOrNull */
    public static final Float m1323minOrNull(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minOrNull");
        Iterator<Float> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        float floatValue = it2.next().floatValue();
        while (it2.hasNext()) {
            floatValue = Math.min(floatValue, it2.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T extends Comparable<? super T>> T minOrNull(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minOrNull");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t = (T) ((Comparable) it2.next());
        while (it2.hasNext()) {
            ?? r1 = (Comparable) it2.next();
            if (t.compareTo(r1) > 0) {
                t = r1;
            }
        }
        return t;
    }

    public static final <T> T minWith(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) SequencesKt.minWithOrNull(sequence, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static final <T> T minWithOrNull(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t = (T) it2.next();
        while (it2.hasNext()) {
            ?? r1 = (Object) it2.next();
            if (comparator.compare(t, r1) > 0) {
                t = r1;
            }
        }
        return t;
    }

    public static final <T> boolean none(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$none");
        return !sequence.iterator().hasNext();
    }

    public static final <T> boolean none(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            if (function1.invoke((Object) it2.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> Sequence<T> onEach(Sequence<? extends T> sequence, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$onEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        return SequencesKt.map(sequence, new SequencesKt___SequencesKt$onEach$1(function1));
    }

    public static final <T> Sequence<T> onEachIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        return SequencesKt.mapIndexed(sequence, new SequencesKt___SequencesKt$onEachIndexed$1(function2));
    }

    public static final <S, T extends S> S reduce(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            S s = (S) it2.next();
            while (it2.hasNext()) {
                s = (S) function2.invoke(s, (Object) it2.next());
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (it2.hasNext()) {
            S s = (S) it2.next();
            int i = 1;
            while (it2.hasNext()) {
                int i2 = i + 1;
                if (i < 0) {
                    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                        CollectionsKt.throwIndexOverflow();
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                s = (S) function3.invoke(Integer.valueOf(i), s, (Object) it2.next());
                i = i2;
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexedOrNull(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        S s = (S) it2.next();
        int i = 1;
        while (it2.hasNext()) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            s = (S) function3.invoke(Integer.valueOf(i), s, (Object) it2.next());
            i = i2;
        }
        return s;
    }

    public static final <S, T extends S> S reduceOrNull(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        S s = (S) it2.next();
        while (it2.hasNext()) {
            s = (S) function2.invoke(s, (Object) it2.next());
        }
        return s;
    }

    public static final <T, R> Sequence<R> runningFold(Sequence<? extends T> sequence, R r, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningFold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return SequencesKt.sequence(new SequencesKt___SequencesKt$runningFold$1(sequence, r, function2, null));
    }

    public static final <T, R> Sequence<R> runningFoldIndexed(Sequence<? extends T> sequence, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return SequencesKt.sequence(new SequencesKt___SequencesKt$runningFoldIndexed$1(sequence, r, function3, null));
    }

    public static final <S, T extends S> Sequence<S> runningReduce(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return SequencesKt.sequence(new SequencesKt___SequencesKt$runningReduce$1(sequence, function2, null));
    }

    public static final <S, T extends S> Sequence<S> runningReduceIndexed(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return SequencesKt.sequence(new SequencesKt___SequencesKt$runningReduceIndexed$1(sequence, function3, null));
    }

    public static final <T, R> Sequence<R> scan(Sequence<? extends T> sequence, R r, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scan");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return SequencesKt.runningFold(sequence, r, function2);
    }

    public static final <T, R> Sequence<R> scanIndexed(Sequence<? extends T> sequence, R r, Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return SequencesKt.runningFoldIndexed(sequence, r, function3);
    }

    public static final <S, T extends S> Sequence<S> scanReduce(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scanReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        return SequencesKt.runningReduce(sequence, function2);
    }

    public static final <S, T extends S> Sequence<S> scanReduceIndexed(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(sequence, "$this$scanReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        return SequencesKt.runningReduceIndexed(sequence, function3);
    }

    public static final <T> int sumBy(Sequence<? extends T> sequence, Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += function1.invoke((Object) it2.next()).intValue();
        }
        return i;
    }

    public static final <T> double sumByDouble(Sequence<? extends T> sequence, Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        double d = 0.0d;
        while (it2.hasNext()) {
            d += function1.invoke((Object) it2.next()).doubleValue();
        }
        return d;
    }

    private static final <T> double sumOfDouble(Sequence<? extends T> sequence, Function1<? super T, Double> function1) {
        double d = (double) 0;
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            d += function1.invoke((Object) it2.next()).doubleValue();
        }
        return d;
    }

    private static final <T> int sumOfInt(Sequence<? extends T> sequence, Function1<? super T, Integer> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += function1.invoke((Object) it2.next()).intValue();
        }
        return i;
    }

    private static final <T> long sumOfLong(Sequence<? extends T> sequence, Function1<? super T, Long> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        long j = 0;
        while (it2.hasNext()) {
            j += function1.invoke((Object) it2.next()).longValue();
        }
        return j;
    }

    private static final <T> int sumOfUInt(Sequence<? extends T> sequence, Function1<? super T, UInt> function1) {
        int r0 = UInt.m171constructorimpl(0);
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            r0 = UInt.m171constructorimpl(r0 + function1.invoke((Object) it2.next()).m214unboximpl());
        }
        return r0;
    }

    private static final <T> long sumOfULong(Sequence<? extends T> sequence, Function1<? super T, ULong> function1) {
        long r0 = ULong.m241constructorimpl((long) 0);
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            r0 = ULong.m241constructorimpl(r0 + function1.invoke((Object) it2.next()).m284unboximpl());
        }
        return r0;
    }

    public static final <T> Sequence<T> requireNoNulls(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$requireNoNulls");
        return SequencesKt.map(sequence, new SequencesKt___SequencesKt$requireNoNulls$1(sequence));
    }

    public static final <T> Sequence<List<T>> chunked(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "$this$chunked");
        return SequencesKt.windowed(sequence, i, i, true);
    }

    public static final <T, R> Sequence<R> chunked(Sequence<? extends T> sequence, int i, Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$chunked");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return SequencesKt.windowed(sequence, i, i, true, function1);
    }

    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        return new SequencesKt___SequencesKt$minus$1(sequence, t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, T[] tArr) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length == 0) {
            return sequence;
        }
        return new SequencesKt___SequencesKt$minus$2(sequence, tArr);
    }

    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        return new SequencesKt___SequencesKt$minus$3(sequence, iterable);
    }

    public static final <T> Sequence<T> minus(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minus");
        Intrinsics.checkNotNullParameter(sequence2, "elements");
        return new SequencesKt___SequencesKt$minus$4(sequence, sequence2);
    }

    private static final <T> Sequence<T> minusElement(Sequence<? extends T> sequence, T t) {
        return SequencesKt.minus((Sequence) sequence, (Object) t);
    }

    public static final <T> Pair<List<T>, List<T>> partition(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        return SequencesKt.flatten(SequencesKt.sequenceOf(sequence, SequencesKt.sequenceOf(t)));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, T[] tArr) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return SequencesKt.plus((Sequence) sequence, (Iterable) ArraysKt.asList(tArr));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        return SequencesKt.flatten(SequencesKt.sequenceOf(sequence, CollectionsKt.asSequence(iterable)));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$plus");
        Intrinsics.checkNotNullParameter(sequence2, "elements");
        return SequencesKt.flatten(SequencesKt.sequenceOf(sequence, sequence2));
    }

    private static final <T> Sequence<T> plusElement(Sequence<? extends T> sequence, T t) {
        return SequencesKt.plus((Sequence) sequence, (Object) t);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return SequencesKt.windowed(sequence, i, i2, z);
    }

    public static final <T> Sequence<List<T>> windowed(Sequence<? extends T> sequence, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(sequence, "$this$windowed");
        return SlidingWindowKt.windowedSequence(sequence, i, i2, z, false);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence sequence, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return SequencesKt.windowed(sequence, i, i2, z, function1);
    }

    public static final <T, R> Sequence<R> windowed(Sequence<? extends T> sequence, int i, int i2, boolean z, Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$windowed");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return SequencesKt.map(SlidingWindowKt.windowedSequence(sequence, i, i2, z, true), function1);
    }

    public static final <T, R> Sequence<Pair<T, R>> zip(Sequence<? extends T> sequence, Sequence<? extends R> sequence2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zip");
        Intrinsics.checkNotNullParameter(sequence2, "other");
        return new MergingSequence(sequence, sequence2, SequencesKt___SequencesKt$zip$1.INSTANCE);
    }

    public static final <T, R, V> Sequence<V> zip(Sequence<? extends T> sequence, Sequence<? extends R> sequence2, Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zip");
        Intrinsics.checkNotNullParameter(sequence2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return new MergingSequence(sequence, sequence2, function2);
    }

    public static final <T> Sequence<Pair<T, T>> zipWithNext(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zipWithNext");
        return SequencesKt.zipWithNext(sequence, SequencesKt___SequencesKt$zipWithNext$1.INSTANCE);
    }

    public static final <T, R> Sequence<R> zipWithNext(Sequence<? extends T> sequence, Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$zipWithNext");
        Intrinsics.checkNotNullParameter(function2, "transform");
        return SequencesKt.sequence(new SequencesKt___SequencesKt$zipWithNext$2(sequence, function2, null));
    }

    public static /* synthetic */ Appendable joinTo$default(Sequence sequence, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        return SequencesKt.joinTo(sequence, appendable, (i2 & 2) != 0 ? ", " : charSequence, (i2 & 4) != 0 ? "" : charSequence2, (i2 & 8) != 0 ? "" : charSequence3, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (Object obj : sequence) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt.appendElement(a, obj, function1);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return SequencesKt.joinToString(sequence, charSequence, charSequence2, charSequence3, i3, charSequence4, function1);
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) SequencesKt.joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$asIterable");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static final double averageOfByte(Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Byte b : sequence) {
            d += (double) b.byteValue();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    public static final double averageOfShort(Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Short sh : sequence) {
            d += (double) sh.shortValue();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    public static final double averageOfInt(Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Integer num : sequence) {
            d += (double) num.intValue();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    public static final double averageOfLong(Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Long l : sequence) {
            d += (double) l.longValue();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    public static final double averageOfFloat(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Float f : sequence) {
            d += (double) f.floatValue();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    public static final double averageOfDouble(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Double d2 : sequence) {
            d += d2.doubleValue();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    public static final int sumOfByte(Sequence<Byte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i = 0;
        for (Byte b : sequence) {
            i += b.byteValue();
        }
        return i;
    }

    public static final int sumOfShort(Sequence<Short> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i = 0;
        for (Short sh : sequence) {
            i += sh.shortValue();
        }
        return i;
    }

    public static final int sumOfInt(Sequence<Integer> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i = 0;
        for (Integer num : sequence) {
            i += num.intValue();
        }
        return i;
    }

    public static final long sumOfLong(Sequence<Long> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        long j = 0;
        for (Long l : sequence) {
            j += l.longValue();
        }
        return j;
    }

    public static final float sumOfFloat(Sequence<Float> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        float f = 0.0f;
        for (Float f2 : sequence) {
            f += f2.floatValue();
        }
        return f;
    }

    public static final double sumOfDouble(Sequence<Double> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        double d = 0.0d;
        for (Double d2 : sequence) {
            d += d2.doubleValue();
        }
        return d;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T> T find(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            ?? r0 = (Object) it2.next();
            if (function1.invoke(r0).booleanValue()) {
                return r0;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static final <T> T findLast(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        Iterator<? extends T> it2 = sequence.iterator();
        T t = null;
        while (it2.hasNext()) {
            ?? r1 = (Object) it2.next();
            if (function1.invoke(r1).booleanValue()) {
                t = r1;
            }
        }
        return t;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Sequence<? extends T> sequence, C c, Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function2.invoke(Integer.valueOf(i), obj).booleanValue()) {
                c.add(obj);
            }
            i = i2;
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Sequence<? extends T> sequence, C c, Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapIndexedNotNullTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (it2.hasNext()) {
            Object obj = (Object) it2.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            Object invoke = function2.invoke(Integer.valueOf(i), obj);
            if (invoke != null) {
                c.add(invoke);
            }
            i = i2;
        }
        return c;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Sequence<? extends T> sequence, C c, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$mapNotNullTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it2 = sequence.iterator();
        while (it2.hasNext()) {
            Object invoke = function1.invoke((Object) it2.next());
            if (invoke != null) {
                c.add(invoke);
            }
        }
        return c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R extends Comparable<? super R>> T maxBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Object obj = (Object) it2.next();
        if (it2.hasNext()) {
            Comparable comparable = (Comparable) function1.invoke(obj);
            do {
                Object obj2 = (Object) it2.next();
                Comparable comparable2 = (Comparable) function1.invoke(obj2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo < 0) {
                    obj = (Object) obj2;
                    comparable3 = comparable2;
                }
                comparable = comparable3;
            } while (it2.hasNext());
        }
        return (T) obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R extends Comparable<? super R>> T minBy(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sequence, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Object obj = (Object) it2.next();
        if (it2.hasNext()) {
            Comparable comparable = (Comparable) function1.invoke(obj);
            do {
                Object obj2 = (Object) it2.next();
                Comparable comparable2 = (Comparable) function1.invoke(obj2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo > 0) {
                    obj = (Object) obj2;
                    comparable3 = comparable2;
                }
                comparable = comparable3;
            } while (it2.hasNext());
        }
        return (T) obj;
    }
}
