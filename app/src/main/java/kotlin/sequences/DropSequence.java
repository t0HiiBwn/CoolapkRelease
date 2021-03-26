package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(Sequence<? extends T> sequence2, int i) {
        Intrinsics.checkNotNullParameter(sequence2, "sequence");
        this.sequence = sequence2;
        this.count = i;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int i) {
        int i2 = this.count + i;
        return i2 < 0 ? new DropSequence(this, i) : new DropSequence(this.sequence, i2);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int i) {
        int i2 = this.count;
        int i3 = i2 + i;
        return i3 < 0 ? new TakeSequence(this, i) : new SubSequence(this.sequence, i2, i3);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }
}
