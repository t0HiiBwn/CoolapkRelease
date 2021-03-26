package com.umeng.cconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.icu.number.FormattedNumber;
import android.text.TextUtils;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ag;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.ak;
import com.umeng.cconfig.listener.OnConfigStatusChangedListener;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

public class UMRemoteConfig {
    public static final Pattern a = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]{1,255}");
    public static boolean b = true;
    private static final String c = "UMRemoteConfig";
    private static final String d = "ucc";
    private static final int e = 1000;
    private static Context f = null;
    private static Map<String, ae> g = new HashMap();
    private static Map<String, ae> h = new HashMap();
    private static Map<String, String> i = new HashMap();
    private int j;
    private RemoteConfigSettings k;
    private OnConfigStatusChangedListener l;
    private final ReadWriteLock m;

    public static UMRemoteConfig getInstance() {
        return a.a;
    }

    private UMRemoteConfig() {
        this.m = new ReentrantReadWriteLock(true);
    }

    private static class a {
        private static final UMRemoteConfig a = new UMRemoteConfig();

        private a() {
        }
    }

    public synchronized void setDefaults(int i2) {
        if (!b) {
            MLog.d("ucc", "remote config disable");
        } else {
            this.j = i2;
        }
    }

    public synchronized void setConfigSettings(RemoteConfigSettings remoteConfigSettings) {
        if (!b) {
            MLog.d("ucc", "remote config disable");
            return;
        }
        if (remoteConfigSettings != null) {
            this.k = remoteConfigSettings;
        }
    }

    public synchronized void setOnNewConfigfecthed(OnConfigStatusChangedListener onConfigStatusChangedListener) {
        if (!b) {
            MLog.d("ucc", "remote config disable");
            return;
        }
        if (onConfigStatusChangedListener != null) {
            this.l = onConfigStatusChangedListener;
        }
    }

    public String getConfigValue(String str) {
        String str2 = null;
        if (!b) {
            MLog.d("ucc", "remote config disable");
            return null;
        }
        Context context = f;
        if (context == null) {
            MLog.d("ucc", "UMRemoteConfig did not init");
            return null;
        } else if (!UMUtils.isMainProgress(context)) {
            MLog.d("ucc", "can not be called in child process");
            return null;
        } else {
            try {
                this.m.readLock().lock();
                ae aeVar = g.get(str);
                if (aeVar != null) {
                    str2 = aeVar.b();
                    if (!TextUtils.isEmpty(aeVar.d())) {
                        JSONArray a2 = ag.a(aeVar, f);
                        ULog.d("jessie", "[ablog] ablog params : " + a2.toString());
                        if (a2 != null) {
                            aj.a(new ai("https://pslog.umeng.com/ablog", a2));
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.m.readLock().unlock();
                throw th;
            }
            this.m.readLock().unlock();
            return str2;
        }
    }

    public void init(Context context) {
        try {
            if (!b) {
                MLog.d("ucc", "remote config disable");
            } else if (context != null) {
                if (f == null) {
                    f = context.getApplicationContext();
                }
                if (!UMUtils.isMainProgress(context)) {
                    MLog.d("ucc", "can not be called in child process");
                } else if (this.k == null) {
                    MLog.d("ucc", "please set RemoteConfigSettings using UMRemoteConfig.getInstance().setConfigSettings");
                } else {
                    a(f, this.j);
                    a(aa.a(f).d());
                    a(f);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void handlerMessage(int i2, Object obj, String str) {
        OnConfigStatusChangedListener onConfigStatusChangedListener;
        if (i2 == 1) {
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.m.writeLock().lock();
                    JSONObject jSONObject = new JSONObject(str2);
                    String str3 = "";
                    String string = jSONObject.has("cc") ? jSONObject.getString("cc") : str3;
                    if (jSONObject.has("ts")) {
                        str3 = jSONObject.getString("ts");
                    }
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(str3)) {
                        aa.a(f).a(str3, string, "0");
                        aa.a(f).e();
                        MLog.i("ucc", "get new config success");
                        RemoteConfigSettings remoteConfigSettings = this.k;
                        if (remoteConfigSettings != null) {
                            if (!remoteConfigSettings.isAutoUpdateModeEnabled()) {
                                OnConfigStatusChangedListener onConfigStatusChangedListener2 = this.l;
                                if (onConfigStatusChangedListener2 != null) {
                                    onConfigStatusChangedListener2.onFetchComplete();
                                }
                            } else {
                                activeFetchConfig();
                            }
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.m.writeLock().unlock();
                    throw th;
                }
                this.m.writeLock().unlock();
            }
        } else if (i2 == 2) {
            try {
                this.m.writeLock().lock();
                if (TextUtils.isEmpty((String) obj) && !TextUtils.isEmpty(str)) {
                    ag.a(f, str);
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                this.m.writeLock().unlock();
                throw th2;
            }
            this.m.writeLock().unlock();
        } else if (i2 == 3) {
            try {
                this.m.writeLock().lock();
                if (((Boolean) obj).booleanValue()) {
                    a(f, this.j);
                    a(aa.a(f).d());
                    MLog.i("ucc", "active new config success");
                    if (!(this.k == null || (onConfigStatusChangedListener = this.l) == null)) {
                        onConfigStatusChangedListener.onActiveComplete();
                    }
                }
            } catch (Exception unused3) {
            } catch (Throwable th3) {
                this.m.writeLock().unlock();
                throw th3;
            }
            this.m.writeLock().unlock();
        }
    }

    public void activeFetchConfig() {
        if (!b) {
            MLog.d("ucc", "remote config disable");
            return;
        }
        Context context = f;
        if (context == null) {
            MLog.d("ucc", "UMRemoteConfig did not init");
        } else if (!UMUtils.isMainProgress(context)) {
            MLog.d("ucc", "can not be called in child process");
        } else {
            try {
                new ak(f).run();
            } catch (Exception unused) {
            }
        }
    }

    private void a(Context context, int i2) {
        ReadWriteLock readWriteLock;
        if (context != null && i2 > 0) {
            try {
                this.m.writeLock().lock();
                XmlResourceParser xml = context.getResources().getXml(i2);
                int eventType = xml.getEventType();
                String str = null;
                String str2 = null;
                String str3 = null;
                while (true) {
                    if (eventType != 1) {
                        if (eventType == 2) {
                            str = xml.getName();
                        } else if (eventType == 3) {
                            if (!(!"entry".equals(xml.getName()) || str2 == null || str3 == null)) {
                                if (a.matcher(str2.trim()).matches()) {
                                    i.put(str2, str3);
                                    ae aeVar = new ae();
                                    aeVar.a(str2);
                                    aeVar.b(str3);
                                    h.put(str2, aeVar);
                                    str2 = null;
                                    str3 = null;
                                }
                                if (i.size() > 1000) {
                                    break;
                                }
                            }
                            str = null;
                        } else if (eventType == 4) {
                            if ("key".equals(str)) {
                                str2 = xml.getText();
                            } else if ("value".equals(str)) {
                                str3 = xml.getText();
                            }
                        }
                        eventType = xml.next();
                    }
                }
                try {
                    readWriteLock = this.m;
                    readWriteLock.writeLock().unlock();
                } catch (Exception unused) {
                    ULog.e("jessie", "[xmlLoad] xml load fail");
                }
            } catch (XmlPullParserException unused2) {
                ULog.e("jessie", "[xmlLoad] xml load fail");
                readWriteLock = this.m;
            } catch (IOException unused3) {
                ULog.e("jessie", "[xmlLoad] xml load fail");
                readWriteLock = this.m;
            } catch (Throwable th) {
                this.m.writeLock().unlock();
                throw th;
            }
        }
    }

    private void a(af afVar) {
        if (afVar != null) {
            String b2 = afVar.b();
            try {
                this.m.writeLock().lock();
                if (!TextUtils.isEmpty(b2)) {
                    JSONArray jSONArray = new JSONArray(b2);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject = new JSONObject(jSONArray.getString(i2));
                        String str = "";
                        try {
                            ae aeVar = new ae();
                            if (jSONObject.has("k")) {
                                str = jSONObject.getString("k");
                                aeVar.a(str);
                            }
                            if (jSONObject.has("v")) {
                                aeVar.b(jSONObject.getString("v"));
                            }
                            if (jSONObject.has("e")) {
                                aeVar.c(jSONObject.getString("e"));
                            }
                            if (jSONObject.has("g")) {
                                aeVar.d(jSONObject.getString("g"));
                            }
                            if (!TextUtils.isEmpty(str)) {
                                h.put(jSONObject.getString("k"), aeVar);
                            }
                        } catch (Exception unused) {
                            ULog.e("jessie", "[active] new config active false");
                        }
                    }
                }
                g.clear();
                g.putAll(h);
                h.clear();
                ULog.i("jessie", "[active] new config active success i");
            } catch (Exception unused2) {
                ULog.e("jessie", "[active] new config active false");
            } catch (Throwable th) {
                this.m.writeLock().unlock();
                throw th;
            }
            this.m.writeLock().unlock();
            return;
        }
        try {
            this.m.writeLock().lock();
            g.clear();
            g.putAll(h);
            h.clear();
            ULog.i("[active] new config active success ii");
        } catch (Exception unused3) {
        } catch (Throwable th2) {
            this.m.writeLock().unlock();
            throw th2;
        }
        this.m.writeLock().unlock();
    }

    private void a(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback("ucc", new UMImprintChangeCallback() {
            /* class com.umeng.cconfig.UMRemoteConfig.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: android.icu.number.FormattedNumber */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                SharedPreferences a2;
                try {
                    if ("ucc".equals(str)) {
                        ULog.i("jessie", "[imprint] key: " + str + " value: " + str2);
                        String[] split = str2.split("@");
                        FormattedNumber formattedNumber = split[3];
                        if (!TextUtils.isEmpty(formattedNumber) && "1".equals(formattedNumber)) {
                            String str3 = split[0];
                            if (!TextUtils.isEmpty(str3) && (a2 = ab.a(UMRemoteConfig.f)) != null) {
                                String string = a2.getString("cconfig_sp_last_request_time", "");
                                if (!TextUtils.isEmpty(string)) {
                                    if (str3.equals(string)) {
                                        ULog.i("jessie", "[imprint] newTimeStamp.equals(oldTimeStamp)");
                                        return;
                                    }
                                }
                                SharedPreferences.Editor edit = a2.edit();
                                edit.putString("cconfig_sp_last_request_time", str3);
                                edit.commit();
                                JSONObject b = ag.b(UMRemoteConfig.f);
                                if (b != null) {
                                    try {
                                        ULog.i("jessie", "[imprint] send request. body: " + b.toString());
                                        aj.a(new ai("https://ucc.umeng.com/v1/fetch", b));
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                    ULog.e("jessie", "[imprint] fail");
                }
            }
        });
    }

    private static void b() {
        b = false;
    }
}
