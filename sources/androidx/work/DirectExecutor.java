package androidx.work;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016j\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/work/DirectExecutor;", "", "Ljava/util/concurrent/Executor;", "(Ljava/lang/String;I)V", "execute", "", "command", "Ljava/lang/Runnable;", "toString", "", "INSTANCE", "work-runtime-ktx_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DirectExecutor.kt */
public enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "DirectExecutor";
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "command");
        runnable.run();
    }
}
