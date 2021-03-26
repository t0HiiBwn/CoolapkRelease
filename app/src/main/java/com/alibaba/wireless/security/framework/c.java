package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import com.alibaba.wireless.security.framework.utils.a;
import com.alibaba.wireless.security.framework.utils.d;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;

public class c implements ISGPluginInfo {
    private String a;
    private String b;
    private ClassLoader c;
    private AssetManager d;
    private a e;
    private ISecurityGuardPlugin f;
    private ISGPluginManager g;

    public c(String str, ISGPluginManager iSGPluginManager, String str2, ClassLoader classLoader, a aVar, ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.a = str;
        this.g = iSGPluginManager;
        this.b = str2;
        this.c = classLoader;
        this.e = aVar;
        this.f = iSecurityGuardPlugin;
    }

    public String a(String str) {
        return this.e.a != null ? this.e.a.applicationInfo.metaData.getString(str) : this.e.a(str);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public AssetManager getAssetManager() {
        AssetManager assetManager = this.d;
        if (assetManager != null) {
            return assetManager;
        }
        try {
            AssetManager assetManager2 = (AssetManager) AssetManager.class.newInstance();
            d.a(assetManager2).a("addAssetPath", this.a);
            this.d = assetManager2;
            return assetManager2;
        } catch (Exception e2) {
            a.a("", e2);
            return null;
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ClassLoader getClassLoader() {
        return this.c;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public PackageInfo getPackageInfo() {
        return this.e.a;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginName() {
        return this.b;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginPath() {
        return this.a;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISecurityGuardPlugin getSGPluginEntry() {
        return this.f;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISGPluginManager getSGPluginManager() {
        return this.g;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getVersion() {
        return this.e.a != null ? this.e.a.versionName : this.e.a("version");
    }
}
