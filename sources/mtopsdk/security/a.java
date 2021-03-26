package mtopsdk.security;

import java.util.HashMap;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;

/* compiled from: AbstractSignImpl */
public abstract class a implements ISign {
    MtopConfig a = null;
    private EnvModeEnum b = null;

    @Override // mtopsdk.security.ISign
    public String getAvmpSign(String str, String str2, int i) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getMiniWua(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getSign(HashMap<String, String> hashMap, String str) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public HashMap<String, String> getUnifiedSign(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2, boolean z) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public String getWua(HashMap<String, String> hashMap, String str) {
        return null;
    }

    @Override // mtopsdk.security.ISign
    public void init(MtopConfig mtopConfig) {
        this.a = mtopConfig;
        if (mtopConfig != null) {
            this.b = mtopConfig.envMode;
        }
    }

    final int a() {
        if (this.b == null) {
            return 0;
        }
        int i = b.a[this.b.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i == 3 || i == 4) {
            return 2;
        }
        return 0;
    }

    final String b() {
        MtopConfig mtopConfig = this.a;
        return mtopConfig != null ? mtopConfig.authCode : "";
    }

    final String c() {
        MtopConfig mtopConfig = this.a;
        return mtopConfig != null ? mtopConfig.instanceId : "";
    }
}
