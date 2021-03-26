package com.bun.miitmdid.content;

import android.content.Context;
import com.bun.miitmdid.interfaces.IdConfig;
import com.bun.miitmdid.provider.vivo.VivoConfig;
import com.netease.nis.sdkwrapper.Utils;
import org.json.JSONObject;

public class ProviderConfig implements IdConfig {
    public SupplierConfig supplier = new SupplierConfig();

    public class SupplierConfig {
        public VivoConfig vivo;

        public SupplierConfig() {
        }
    }

    private ProviderConfig() {
    }

    public static ProviderConfig LoadSetting(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 7;
        objArr[3] = 1606976968479L;
        return (ProviderConfig) Utils.rL(objArr);
    }

    private static boolean PraseVivo(ProviderConfig providerConfig, JSONObject jSONObject) {
        Object[] objArr = new Object[5];
        objArr[1] = providerConfig;
        objArr[2] = jSONObject;
        objArr[3] = 8;
        objArr[4] = 1606976968480L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }

    @Override // com.bun.miitmdid.interfaces.IdConfig
    public String getVivoAppID() {
        return (String) Utils.rL(new Object[]{this, 9, 1606976968481L});
    }
}
