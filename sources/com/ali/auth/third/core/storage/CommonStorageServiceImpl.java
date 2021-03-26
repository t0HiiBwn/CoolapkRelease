package com.ali.auth.third.core.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.exception.SecRuntimeException;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.storage.aes.AESCrypt;
import com.ali.auth.third.core.storage.aes.MD5;
import java.security.GeneralSecurityException;
import java.util.TreeMap;

public class CommonStorageServiceImpl implements StorageService {
    private SharedPreferences a;
    private Context b;
    private String c;

    public CommonStorageServiceImpl() {
        Context applicationContext = KernelContext.getApplicationContext();
        this.b = applicationContext;
        this.a = applicationContext.getSharedPreferences(Constants.TB_SESSION, 0);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String decrypt(String str) {
        return str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String encode(String str) {
        return str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getAppKey() {
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            Object obj = applicationInfo.metaData.get("com.alibaba.app.appkey");
            if (obj == null) {
                return null;
            }
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getDDpExValue(String str) {
        return null;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getUmid() {
        return this.c;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String getValue(String str, boolean z) {
        String string = this.a.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        return symDecrypt(string, MD5.getMD5(KernelContext.timestamp + ""));
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void putDDpExValue(String str, String str2) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void putValue(String str, String str2, boolean z) {
        String symEncrypt = symEncrypt(str2, MD5.getMD5(KernelContext.timestamp + ""));
        if (Build.VERSION.SDK_INT >= 9) {
            this.a.edit().putString(str, symEncrypt).apply();
        } else {
            this.a.edit().putString(str, symEncrypt).commit();
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeDDpExValue(String str) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeSafeToken(String str) {
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void removeValue(String str, boolean z) {
        this.a.edit().remove(str);
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public boolean saveSafeToken(String str, String str2) {
        return false;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public void setUmid(String str) {
        this.c = str;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String signMap(String str, TreeMap<String, String> treeMap) {
        return null;
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symDecrypt(String str, String str2) {
        try {
            return AESCrypt.decrypt(str2, str);
        } catch (GeneralSecurityException e) {
            throw new SecRuntimeException(-2, e);
        }
    }

    @Override // com.ali.auth.third.core.service.StorageService
    public String symEncrypt(String str, String str2) {
        try {
            return AESCrypt.encrypt(str2, str);
        } catch (GeneralSecurityException e) {
            throw new SecRuntimeException(-1, e);
        }
    }
}
