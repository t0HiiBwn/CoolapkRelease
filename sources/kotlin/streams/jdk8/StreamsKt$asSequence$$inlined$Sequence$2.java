package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: Sequences.kt */
public final class StreamsKt$asSequence$$inlined$Sequence$2 implements Sequence<Integer> {
    final /* synthetic */ IntStream $this_asSequence$inlined;

    public StreamsKt$asSequence$$inlined$Sequence$2(IntStream intStream) {
        this.$this_asSequence$inlined = intStream;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Integer> iterator() {
        PrimitiveIterator.OfInt it2 = this.$this_asSequence$inlined.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator()");
        return it2;
    }
}
