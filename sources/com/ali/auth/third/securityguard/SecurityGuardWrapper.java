package com.ali.auth.third.securityguard;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.exception.SecRuntimeException;
import com.ali.auth.third.core.service.StorageService;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

public class SecurityGuardWrapper implements StorageService {
    public static final String TAG = "SecurityGuardWrapper";

    private SecurityGuardManager a() {
        try {
            return SecurityGuardManager.getInstance(KernelContext.context);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    private String a(String str, String str2) {
        try {
            return a().getSafeTokenComp().signWithToken(str, str2.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (SecException e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private byte[] a(byte[] bArr, String str) {
        try {
            return a().getStaticKeyEncryptComp().encrypt(16, str, bArr);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    private byte[] b(byte[] bArr, String str) {
        try {
            return a().getStaticKeyEncryptComp().decrypt(16, str, bArr);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = a().getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp != null) {
                String dynamicDecrypt = dynamicDataEncryptComp.dynamicDecrypt(str);
                return TextUtils.isEmpty(dynamicDecrypt) ? str : dynamicDecrypt;
            }
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("SessionManagerDecryptNull");
            uTCustomHitBuilder.setEventPage("Page_Extend");
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
            return "";
        } catch (Exception e) {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder2 = new UTHitBuilders.UTCustomHitBuilder("SessionManagerDecryptException");
            uTCustomHitBuilder2.setEventPage("Page_Extend");
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder2.build());
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String encode(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                IDynamicDataEncryptComponent dynamicDataEncryptComp = a().getDynamicDataEncryptComp();
                if (dynamicDataEncryptComp != null) {
                    String dynamicEncrypt = dynamicDataEncryptComp.dynamicEncrypt(str);
                    return TextUtils.isEmpty(dynamicEncrypt) ? str : dynamicEncrypt;
                }
                UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("SessionManagerEncryptNull");
                uTCustomHitBuilder.setEventPage("Page_Extend");
                UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
            } catch (Exception e) {
                UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder2 = new UTHitBuilders.UTCustomHitBuilder("SessionManagerEncodeException");
                uTCustomHitBuilder2.setEventPage("Page_Extend");
                UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder2.build());
                e.printStackTrace();
            }
        }
        return str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getAppKey() {
        try {
            return a().getStaticDataStoreComp().getAppKeyByIndex(ConfigManager.getAppKeyIndex(), ConfigManager.POSTFIX_OF_SECURITY_JPG);
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getDDpExValue(String str) {
        try {
            return a().getDynamicDataStoreComp().getStringDDpEx(str, 0);
        } catch (SecException unused) {
            return null;
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getUmid() {
        try {
            return a().getUMIDComp().getSecurityToken();
        } catch (SecException e) {
            throw new SecRuntimeException(e.getErrorCode(), e);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getValue(String str, boolean z) {
        if (!z) {
            return a().getStaticDataStoreComp().getExtraData(str, ConfigManager.POSTFIX_OF_SECURITY_JPG);
        }
        try {
            return a().getDynamicDataStoreComp().getString(str);
        } catch (SecException unused) {
            return null;
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void putDDpExValue(String str, String str2) {
        try {
            a().getDynamicDataStoreComp().putStringDDpEx(str, str2, 0);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void putValue(String str, String str2, boolean z) {
        try {
            a().getDynamicDataStoreComp().putString(str, str2);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeDDpExValue(String str) {
        try {
            a().getDynamicDataStoreComp().removeStringDDpEx(str, 0);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeSafeToken(String str) {
        try {
            a().getSafeTokenComp().removeToken(str);
        } catch (SecException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeValue(String str, boolean z) {
        if (z) {
            try {
                a().getDynamicDataStoreComp().removeString(str);
            } catch (SecException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public synchronized boolean saveSafeToken(String str, String str2) {
        if (TextUtils.isEmpty(str) || a() == null) {
            return false;
        }
        try {
            ISafeTokenComponent safeTokenComp = a().getSafeTokenComp();
            if (safeTokenComp == null) {
                return false;
            }
            return safeTokenComp.saveToken(str, str2, new String[]{"", "", "", ""}[0], 0);
        } catch (SecException e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void setUmid(String str) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String signMap(String str, TreeMap<String, String> treeMap) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        String substring = sb.substring(0, sb.length() - 1);
        Log.e("TAG", "map=" + substring);
        return a(str, substring);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symDecrypt(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 8);
            if (TextUtils.isEmpty(str2)) {
                str2 = "seed_key";
            }
            try {
                return new String(b(decode, str2), "UTF-8");
            } catch (SecRuntimeException e) {
                throw e;
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symEncrypt(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (TextUtils.isEmpty(str2)) {
                str2 = "seed_key";
            }
            try {
                return Base64.encodeToString(a(bytes, str2), 11);
            } catch (SecRuntimeException e) {
                throw e;
            }
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException();
        }
    }
}
