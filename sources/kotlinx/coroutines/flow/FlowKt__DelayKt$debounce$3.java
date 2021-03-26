package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.time.Duration;
import kotlinx.coroutines.DelayKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "emittedItem", "invoke", "(Ljava/lang/Object;)J"}, k = 3, mv = {1, 4, 0})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounce$3 extends Lambda implements Function1<T, Long> {
    final /* synthetic */ Function1 $timeout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounce$3(Function1 function1) {
        super(1);
        this.$timeout = function1;
    }

    /* Return type fixed from 'long' to match base method */
    /* JADX WARN: Type inference failed for: r0v2, types: [long, java.lang.Long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(T t) {
        return DelayKt.m1401toDelayMillisLRDsOJo(((Duration) this.$timeout.invoke(t)).m1386unboximpl());
    }
}
