package kotlinx.coroutines.debug;

import kotlin.Metadata;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import sun.misc.Signal;
import sun.misc.SignalHandler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lsun/misc/Signal;", "kotlin.jvm.PlatformType", "handle"}, k = 3, mv = {1, 4, 0})
/* compiled from: AgentPremain.kt */
final class AgentPremain$installSignalHandler$1 implements SignalHandler {
    public static final AgentPremain$installSignalHandler$1 INSTANCE = new AgentPremain$installSignalHandler$1();

    AgentPremain$installSignalHandler$1() {
    }

    public final void handle(Signal signal) {
        if (DebugProbesImpl.INSTANCE.isInstalled$kotlinx_coroutines_core()) {
            DebugProbesImpl.INSTANCE.dumpCoroutines(System.out);
        } else {
            System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
        }
    }
}
