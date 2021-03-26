package mtopsdk.common.util;

import java.util.Map;
import mtopsdk.common.config.MtopConfigListener;

/* compiled from: SwitchConfigUtil */
public final class d {
    private static MtopConfigListener a;

    public static void a(MtopConfigListener mtopConfigListener) {
        if (mtopConfigListener != null) {
            a = mtopConfigListener;
        }
    }

    public static Map<String, String> a(String str) {
        MtopConfigListener mtopConfigListener = a;
        if (mtopConfigListener != null) {
            return mtopConfigListener.getSwitchConfigByGroupName(str);
        }
        TBSdkLog.w("mtopsdk.SwitchConfigUtil", "[getSwitchConfigByGroupName] MtopConfigListener is null");
        return null;
    }
}
