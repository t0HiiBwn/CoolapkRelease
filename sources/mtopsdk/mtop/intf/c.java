package mtopsdk.mtop.intf;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;

/* compiled from: Mtop */
final class c implements Runnable {
    private /* synthetic */ EnvModeEnum a;
    private /* synthetic */ Mtop b;

    c(Mtop mtop, EnvModeEnum envModeEnum) {
        this.b = mtop;
        this.a = envModeEnum;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.checkMtopSDKInit();
        if (this.b.c.envMode == this.a) {
            TBSdkLog.i("mtopsdk.Mtop", this.b.b + " [switchEnvMode] Current EnvMode matches target EnvMode,envMode=" + this.a);
            return;
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.Mtop", this.b.b + " [switchEnvMode]MtopSDK switchEnvMode start");
        }
        this.b.c.envMode = this.a;
        try {
            this.b.a();
            if (EnvModeEnum.ONLINE == this.a) {
                TBSdkLog.setPrintLog(false);
            }
            this.b.d.executeCoreTask(this.b.c);
            this.b.d.executeExtraTask(this.b.c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.Mtop", this.b.b + " [switchEnvMode]MtopSDK switchEnvMode end. envMode =" + this.a);
        }
    }
}
