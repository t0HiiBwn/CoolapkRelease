package mtopsdk.mtop.intf;

import mtopsdk.common.config.MtopConfigListener;
import mtopsdk.mtop.global.MtopConfig;

/* compiled from: MtopSetting */
final class h implements Runnable {
    private /* synthetic */ MtopConfigListener a;

    h(MtopConfigListener mtopConfigListener) {
        this.a = mtopConfigListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != null) {
            MtopConfig a2 = MtopSetting.a(null);
            if (a2.context != null) {
                this.a.initConfig(a2.context);
            }
        }
    }
}
