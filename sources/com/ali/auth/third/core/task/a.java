package com.ali.auth.third.core.task;

import android.os.AsyncTask;
import android.webkit.CookieSyncManager;
import com.ali.auth.third.core.callback.InitResultCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.device.DeviceInfo;
import com.ali.auth.third.core.exception.AlibabaSDKException;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.service.CredentialService;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.ReflectionUtils;
import java.io.File;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

public class a implements Runnable {
    private InitResultCallback a;
    private Integer b;

    public a(InitResultCallback initResultCallback, Integer num) {
        this.a = initResultCallback;
        this.b = num;
    }

    private Object a(String str, String[] strArr, Object[] objArr) {
        try {
            return ReflectionUtils.newInstance(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(com.ali.auth.third.core.registry.a aVar) {
        boolean z;
        String str = "com.ali.auth.third.securityguard.SecurityGuardWrapper";
        SDKLogger.d("init", "registerStorage");
        try {
            Class.forName(str);
            try {
                KernelContext.isMini = false;
                KernelContext.sdkVersion = KernelContext.SDK_VERSION_STD;
            } catch (Throwable unused) {
            }
            z = true;
        } catch (Throwable unused2) {
            z = false;
        }
        if (!z) {
            str = "com.ali.auth.third.core.storage.CommonStorageServiceImpl";
        }
        try {
            aVar.a(new Class[]{StorageService.class}, a(str, null, null), null);
            KernelContext.storageService = (StorageService) aVar.a(StorageService.class, null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean b(com.ali.auth.third.core.registry.a aVar) {
        boolean z;
        String str = "com.ali.auth.third.mtop.rpc.impl.MtopRpcServiceImpl";
        SDKLogger.d("init", "registerRpc");
        try {
            Class.forName(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            str = "com.ali.auth.third.core.rpc.CommRpcServiceImpl";
        }
        try {
            aVar.a(new Class[]{RpcService.class}, a(str, null, null), null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c() {
        DeviceInfo.init(KernelContext.context);
    }

    private boolean c(com.ali.auth.third.core.registry.a aVar) {
        boolean z;
        SDKLogger.d("init", "registerUserTrack");
        String str = "com.ali.auth.third.ut.UserTrackerImpl";
        try {
            Class.forName(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            str = "com.ali.auth.third.core.ut.UserTracer";
        }
        aVar.a(new Class[]{UserTrackerService.class}, a(str, null, null), null);
        return true;
    }

    private boolean d() {
        try {
            Class.forName(AsyncTask.class.getName());
        } catch (Exception unused) {
        }
        KernelContext.wrapServiceRegistry();
        ConfigManager.getInstance().init(this.b.intValue());
        com.ali.auth.third.core.registry.a aVar = KernelContext.serviceRegistry;
        boolean z = false;
        if (!b(aVar) || !a(aVar) || !c(aVar)) {
            return false;
        }
        aVar.a(new Class[]{MemberExecutorService.class, ExecutorService.class}, KernelContext.executorService, Collections.singletonMap("plugin.vendor", "kernel"));
        aVar.a(new Class[]{CredentialService.class}, CredentialManager.INSTANCE, Collections.singletonMap("scop", "system"));
        KernelContext.credentialService = (CredentialService) aVar.a(CredentialService.class, null);
        if (e() || f()) {
            z = true;
        }
        if (!KernelContext.isMini) {
            g();
        }
        SDKLogger.d("init", "INIT SUCCESS");
        return z;
    }

    private boolean e() {
        SDKLogger.d("init", "register login service");
        try {
            ReflectionUtils.invoke("com.ali.auth.third.login.LoginLifecycleAdapter", "init", null, Class.forName("com.ali.auth.third.login.LoginLifecycleAdapter"), null);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean f() {
        SDKLogger.d("init", "register offline login service");
        try {
            ReflectionUtils.invoke("com.ali.auth.third.offline.login.LoginLifecycleAdapter", "init", null, Class.forName("com.ali.auth.third.offline.login.LoginLifecycleAdapter"), null);
            KernelContext.supportOfflineLogin = true;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean g() {
        SDKLogger.d("init", "register account link service");
        try {
            ReflectionUtils.invoke("com.ali.auth.third.accountlink.AccountLinkLifecycleAdapter", "init", null, Class.forName("com.ali.auth.third.accountlink.AccountLinkLifecycleAdapter"), null);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private void h() {
        try {
            long i = i();
            SDKLogger.e("init", "timeStamp=" + i);
            KernelContext.timestamp = i;
        } catch (Exception e) {
            SDKLogger.e("init", e.getMessage(), e);
        }
        if (!a()) {
            SDKLogger.d("init", " INIT FAILURE");
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.auth.third.core.task.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.onFailure(-1, "service register fail");
                    }
                }
            });
            return;
        }
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.core.task.a.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    a.this.a.onSuccess();
                }
            }
        });
        KernelContext.isInitOk = true;
        SDKLogger.d("init", "INIT SUCCESS");
    }

    private long i() {
        File file = new File(KernelContext.context.getFilesDir().getAbsolutePath() + File.separator + "timestamp");
        if (file.exists()) {
            return file.lastModified();
        }
        try {
            file.createNewFile();
            return file.lastModified();
        } catch (Exception e) {
            SDKLogger.e("init", e.getMessage(), e);
            return 0;
        }
    }

    protected void a(Throwable th) {
        String str;
        int i;
        KernelContext.isInitOk = false;
        if (th instanceof AlibabaSDKException) {
            AlibabaSDKException alibabaSDKException = (AlibabaSDKException) th;
            if (alibabaSDKException.getSDKMessage() != null) {
                Message sDKMessage = alibabaSDKException.getSDKMessage();
                i = sDKMessage.code;
                str = sDKMessage.message;
                CommonUtils.onFailure(this.a, i, str);
            }
        }
        i = 10010;
        str = CommonUtils.toString(th);
        CommonUtils.onFailure(this.a, i, str);
    }

    public boolean a() {
        SDKLogger.d("init", "sdk version = " + ConfigManager.SDK_VERSION.toString());
        c();
        if (KernelContext.syncInitialized) {
            return true;
        }
        try {
            CookieSyncManager.createInstance(KernelContext.getApplicationContext());
            if (!d()) {
                return false;
            }
            KernelContext.syncInitialized = true;
            return true;
        } catch (Throwable th) {
            SDKLogger.e("init", "fail to sync start", th);
            a(th);
            return false;
        }
    }

    protected void b() {
        KernelContext.initLock.unlock();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            KernelContext.initLock.lock();
            h();
        } catch (Throwable th) {
            b();
            throw th;
        }
        b();
    }
}
