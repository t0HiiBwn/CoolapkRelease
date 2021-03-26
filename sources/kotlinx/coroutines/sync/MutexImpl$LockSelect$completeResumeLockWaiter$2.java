package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: Mutex.kt */
final class MutexImpl$LockSelect$completeResumeLockWaiter$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MutexImpl.LockSelect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$LockSelect$completeResumeLockWaiter$2(MutexImpl.LockSelect lockSelect) {
        super(1);
        this.this$0 = lockSelect;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        MutexImpl.this.unlock(this.this$0.owner);
    }
}
