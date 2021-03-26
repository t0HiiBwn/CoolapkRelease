package mtopsdk.mtop.global.init;

import android.os.Process;
import mtopsdk.a.b.a.b;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.impl.DefaultCallFactory;
import mtopsdk.security.ISign;
import mtopsdk.security.c;
import mtopsdk.xstate.XState;

public class OpenMtopInitTask implements IMtopInitTask {
    private static final String TAG = "mtopsdk.OpenMtopInitTask";

    @Override // mtopsdk.mtop.global.init.IMtopInitTask
    public void executeCoreTask(MtopConfig mtopConfig) {
        if (MtopConfig.logAdapterImpl != null) {
            TBSdkLog.setLogAdapter(MtopConfig.logAdapterImpl);
        }
        String str = mtopConfig.instanceId;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.OpenMtopInitTask", str + " [executeInitCoreTask]MtopSDK initcore start. ");
        }
        try {
            MtopFeatureManager.setMtopFeatureFlag(mtopConfig.mtopInstance, 5, true);
            XState.init(mtopConfig.context);
            XState.setValue(str, "ttid", mtopConfig.ttid);
            c cVar = new c();
            cVar.init(mtopConfig);
            mtopConfig.entrance = EntranceEnum.GW_OPEN;
            mtopConfig.sign = cVar;
            mtopConfig.appKey = cVar.getAppKey(new ISign.a(mtopConfig.appKeyIndex, mtopConfig.authCode));
            mtopConfig.processId = Process.myPid();
            mtopConfig.filterManager = new b();
            if (mtopConfig.callFactory == null) {
                mtopConfig.callFactory = new DefaultCallFactory(mtopConfig.context, MtopSDKThreadPoolExecutorFactory.getRequestThreadPoolExecutor());
            }
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.OpenMtopInitTask", str + " [executeInitCoreTask]MtopSDK initcore error.", th);
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.OpenMtopInitTask", str + " [executeInitCoreTask]MtopSDK initcore end");
        }
    }

    @Override // mtopsdk.mtop.global.init.IMtopInitTask
    public void executeExtraTask(MtopConfig mtopConfig) {
        String str = mtopConfig.instanceId;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.OpenMtopInitTask", str + " [executeInitExtraTask]MtopSDK initextra start");
        }
        try {
            SwitchConfig.getInstance().initConfig(mtopConfig.context);
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.OpenMtopInitTask", str + " [executeInitExtraTask] execute MtopSDK initExtraTask error.", th);
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.OpenMtopInitTask", str + " [executeInitExtraTask]MtopSDK initextra end");
        }
    }
}
