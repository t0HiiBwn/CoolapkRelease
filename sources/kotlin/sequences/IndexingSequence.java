package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
public final class IndexingSequence<T> implements Sequence<IndexedValue<? extends T>> {
    private final Sequence<T> sequence;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public IndexingSequence(Sequence<? extends T> sequence2) {
        Intrinsics.checkNotNullParameter(sequence2, "sequence");
        this.sequence = sequence2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IndexedValue<T>> iterator() {
        return new IndexingSequence$iterator$1(this);
    }
}
