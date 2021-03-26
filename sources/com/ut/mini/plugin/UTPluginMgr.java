package com.ut.mini.plugin;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UTPluginMgr implements UTMCAppStatusCallbacks {
    public static final String PARTNERPLUGIN_UTPREF = "com.ut.mini.perf.UTPerfPlugin";
    private static UTPluginMgr a = new UTPluginMgr();
    private HandlerThread b = null;
    private Handler mHandler = null;
    private List<UTPlugin> n = new LinkedList();
    private List<String> o = new ArrayList();
    private List<String> p = new ArrayList<String>() {
        /* class com.ut.mini.plugin.UTPluginMgr.AnonymousClass1 */

        {
            add("com.ut.mini.perf.UTPerfPlugin");
        }
    };
    private List<UTPlugin> q = new LinkedList();

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    private UTPluginMgr() {
        if (Build.VERSION.SDK_INT >= 14) {
            UTMCAppStatusRegHelper.registerAppStatusCallbacks(this);
        }
    }

    public static UTPluginMgr getInstance() {
        return a;
    }

    private void L() {
        HandlerThread handlerThread = new HandlerThread("UT-PLUGIN-ASYNC");
        this.b = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.b.getLooper()) {
            /* class com.ut.mini.plugin.UTPluginMgr.AnonymousClass2 */

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && (message.obj instanceof a)) {
                    a aVar = (a) message.obj;
                    UTPlugin a = aVar.a();
                    int i = aVar.i();
                    Object msgObj = aVar.getMsgObj();
                    if (a != null) {
                        try {
                            if (msgObj instanceof UTPluginMsgDispatchDelegate) {
                                UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) msgObj;
                                if (uTPluginMsgDispatchDelegate.isMatchPlugin(a)) {
                                    a.onPluginMsgArrivedFromSDK(i, uTPluginMsgDispatchDelegate.getDispatchObject(a));
                                    return;
                                }
                                return;
                            }
                            a.onPluginMsgArrivedFromSDK(i, msgObj);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    public boolean isPartnerPluginExist(String str) {
        return this.o.contains(str);
    }

    private synchronized void a(int i, UTPluginContextValueDispatchDelegate uTPluginContextValueDispatchDelegate) {
        if (uTPluginContextValueDispatchDelegate != null) {
            for (UTPlugin uTPlugin : this.q) {
                uTPluginContextValueDispatchDelegate.onPluginContextValueChange(uTPlugin.getPluginContext());
                uTPlugin.onPluginContextValueUpdate(i);
            }
        }
    }

    public void updatePluginContextValue(int i) {
        if (i == 1) {
            a(i, new UTPluginContextValueDispatchDelegate() {
                /* class com.ut.mini.plugin.UTPluginMgr.AnonymousClass3 */

                @Override // com.ut.mini.plugin.UTPluginContextValueDispatchDelegate
                public void onPluginContextValueChange(UTPluginContext uTPluginContext) {
                    uTPluginContext.setDebugLogFlag(i.l());
                }
            });
        }
    }

    public void runPartnerPlugin() {
        List<String> list = this.p;
        if (list != null && list.size() > 0) {
            for (String str : this.p) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        Object newInstance = Class.forName(str).newInstance();
                        if (newInstance instanceof UTPlugin) {
                            registerPlugin((UTPlugin) newInstance, true);
                            i.a("runPartnerPlugin[OK]:" + str, new String[0]);
                            this.o.add(str);
                        }
                    } catch (ClassNotFoundException unused) {
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private UTPluginContext a() {
        UTPluginContext uTPluginContext = new UTPluginContext();
        uTPluginContext.setContext(b.a().getContext());
        if (i.l()) {
            uTPluginContext.setDebugLogFlag(i.l());
        }
        return uTPluginContext;
    }

    public synchronized void registerPlugin(UTPlugin uTPlugin, boolean z) {
        if (uTPlugin != null) {
            if (!this.q.contains(uTPlugin)) {
                uTPlugin.a(a());
                this.q.add(uTPlugin);
                if (!z) {
                    this.n.add(uTPlugin);
                }
                uTPlugin.onRegistered();
            }
        }
    }

    public synchronized void unregisterPlugin(UTPlugin uTPlugin) {
        if (uTPlugin != null) {
            if (this.q.contains(uTPlugin)) {
                this.q.remove(uTPlugin);
                uTPlugin.onUnRegistered();
                uTPlugin.a(null);
            }
        }
        List<UTPlugin> list = this.n;
        if (list != null && list.contains(uTPlugin)) {
            this.n.remove(uTPlugin);
        }
    }

    private boolean a(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        boolean z = false;
        for (int i2 : iArr) {
            if (i2 == i) {
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean dispatchPluginMsg(int i, Object obj) {
        boolean z;
        if (this.mHandler == null) {
            L();
        }
        z = false;
        if (this.q.size() > 0) {
            for (UTPlugin uTPlugin : this.q) {
                int[] returnRequiredMsgIds = uTPlugin.returnRequiredMsgIds();
                if (returnRequiredMsgIds != null && a(i, returnRequiredMsgIds)) {
                    if (i != 1) {
                        List<UTPlugin> list = this.n;
                        if (list == null || !list.contains(uTPlugin)) {
                            a aVar = new a();
                            aVar.g(i);
                            aVar.c(obj);
                            aVar.a(uTPlugin);
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = aVar;
                            this.mHandler.sendMessage(obtain);
                            z = true;
                        }
                    }
                    try {
                        if (obj instanceof UTPluginMsgDispatchDelegate) {
                            UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) obj;
                            if (uTPluginMsgDispatchDelegate.isMatchPlugin(uTPlugin)) {
                                uTPlugin.onPluginMsgArrivedFromSDK(i, uTPluginMsgDispatchDelegate.getDispatchObject(uTPlugin));
                            }
                        } else {
                            uTPlugin.onPluginMsgArrivedFromSDK(i, obj);
                        }
                        z = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    private static class a {
        private int L;
        private UTPlugin a;
        private Object g;

        private a() {
            this.L = 0;
            this.g = null;
            this.a = null;
        }

        public int i() {
            return this.L;
        }

        public void g(int i) {
            this.L = i;
        }

        public Object getMsgObj() {
            return this.g;
        }

        public void c(Object obj) {
            this.g = obj;
        }

        public UTPlugin a() {
            return this.a;
        }

        public void a(UTPlugin uTPlugin) {
            this.a = uTPlugin;
        }
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        dispatchPluginMsg(2, null);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        dispatchPluginMsg(8, null);
    }
}
