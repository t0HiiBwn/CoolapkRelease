package com.bytedance.embedapplog;

public class InitConfig {
    private ISensitiveInfoProvider A;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private IPicker g;
    private boolean h;
    private int i = 0;
    private String j;
    private String k;

    /* renamed from: l  reason: collision with root package name */
    private String f1255l;
    private String m;
    private int n;
    private int o;
    private int p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private boolean x = true;
    private boolean y = true;
    private String z;

    public InitConfig(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public InitConfig setReleaseBuild(String str) {
        this.j = str;
        return this;
    }

    public String getReleaseBuild() {
        return this.j;
    }

    public InitConfig setEnablePlay(boolean z2) {
        this.h = z2;
        return this;
    }

    public boolean isPlayEnable() {
        return this.h;
    }

    public String getAid() {
        return this.a;
    }

    public String getChannel() {
        return this.b;
    }

    public InitConfig setGoogleAid(String str) {
        this.c = str;
        return this;
    }

    public String getGoogleAid() {
        return this.c;
    }

    public InitConfig setLanguage(String str) {
        this.d = str;
        return this;
    }

    public String getLanguage() {
        return this.d;
    }

    public InitConfig setRegion(String str) {
        this.e = str;
        return this;
    }

    public String getRegion() {
        return this.e;
    }

    public InitConfig setAliyunUdid(String str) {
        this.f = str;
        return this;
    }

    public String getAliyunUdid() {
        return this.f;
    }

    public InitConfig setProcess(boolean z2) {
        this.i = z2 ? 1 : 2;
        return this;
    }

    public int getProcess() {
        return this.i;
    }

    public IPicker getPicker() {
        return this.g;
    }

    public InitConfig setPicker(IPicker iPicker) {
        this.g = iPicker;
        return this;
    }

    public InitConfig setUriConfig(int i2) {
        ao.a(i2);
        return this;
    }

    public InitConfig setAppName(String str) {
        this.k = str;
        return this;
    }

    public String getAppName() {
        return this.k;
    }

    public InitConfig setVersion(String str) {
        this.f1255l = str;
        return this;
    }

    public String getVersion() {
        return this.f1255l;
    }

    public InitConfig setTweakedChannel(String str) {
        this.m = str;
        return this;
    }

    public String getTweakedChannel() {
        return this.m;
    }

    public InitConfig setVersionCode(int i2) {
        this.n = i2;
        return this;
    }

    public int getVersionCode() {
        return this.n;
    }

    public InitConfig setUpdateVersionCode(int i2) {
        this.o = i2;
        return this;
    }

    public int getUpdateVersionCode() {
        return this.o;
    }

    public InitConfig setManifestVersionCode(int i2) {
        this.p = i2;
        return this;
    }

    public int getManifestVersionCode() {
        return this.p;
    }

    public InitConfig setManifestVersion(String str) {
        this.q = str;
        return this;
    }

    public String getManifestVersion() {
        return this.q;
    }

    public InitConfig setAbClient(String str) {
        this.r = str;
        return this;
    }

    public String getAbClient() {
        return this.r;
    }

    public InitConfig setAbVersion(String str) {
        this.s = str;
        return this;
    }

    public String getAbVersion() {
        return this.s;
    }

    public InitConfig setAbGroup(String str) {
        this.t = str;
        return this;
    }

    public String getAbGroup() {
        return this.t;
    }

    public InitConfig setAbFeature(String str) {
        this.u = str;
        return this;
    }

    public String getAbFeature() {
        return this.u;
    }

    public InitConfig setVersionMinor(String str) {
        this.v = str;
        return this;
    }

    public String getVersionMinor() {
        return this.v;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        this.w = str;
        return this;
    }

    public String getZiJieCloudPkg() {
        return this.w;
    }

    public boolean isMacEnable() {
        return this.x;
    }

    public void setMacEnable(boolean z2) {
        this.x = z2;
    }

    public boolean isImeiEnable() {
        return this.y;
    }

    public void setImeiEnable(boolean z2) {
        this.y = z2;
    }

    public String getAppImei() {
        return this.z;
    }

    public void setAppImei(String str) {
        this.z = str;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        return this.A;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        this.A = iSensitiveInfoProvider;
    }
}
