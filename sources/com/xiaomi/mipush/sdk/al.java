package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

class al extends Handler {
    final /* synthetic */ ak a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    al(ak akVar, Looper looper) {
        super(looper);
        this.a = akVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        ak akVar;
        ap apVar;
        HashMap<String, String> a2;
        ak akVar2;
        ap apVar2;
        if (message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (ab.class) {
                if (ab.a(ak.a(this.a)).m58a(str)) {
                    if (ab.a(ak.a(this.a)).a(str) < 10) {
                        if (ap.DISABLE_PUSH.ordinal() == i && "syncing".equals(ab.a(ak.a(this.a)).a(ap.DISABLE_PUSH))) {
                            akVar2 = this.a;
                            apVar2 = ap.DISABLE_PUSH;
                        } else if (ap.ENABLE_PUSH.ordinal() != i || !"syncing".equals(ab.a(ak.a(this.a)).a(ap.ENABLE_PUSH))) {
                            if (ap.UPLOAD_HUAWEI_TOKEN.ordinal() == i && "syncing".equals(ab.a(ak.a(this.a)).a(ap.UPLOAD_HUAWEI_TOKEN))) {
                                akVar = this.a;
                                apVar = ap.UPLOAD_HUAWEI_TOKEN;
                                a2 = h.a(ak.a(this.a), d.ASSEMBLE_PUSH_HUAWEI);
                            } else if (ap.UPLOAD_FCM_TOKEN.ordinal() == i && "syncing".equals(ab.a(ak.a(this.a)).a(ap.UPLOAD_FCM_TOKEN))) {
                                akVar = this.a;
                                apVar = ap.UPLOAD_FCM_TOKEN;
                                a2 = h.a(ak.a(this.a), d.ASSEMBLE_PUSH_FCM);
                            } else if (ap.UPLOAD_COS_TOKEN.ordinal() != i || !"syncing".equals(ab.a(ak.a(this.a)).a(ap.UPLOAD_COS_TOKEN))) {
                                if (ap.UPLOAD_FTOS_TOKEN.ordinal() == i && "syncing".equals(ab.a(ak.a(this.a)).a(ap.UPLOAD_FTOS_TOKEN))) {
                                    akVar = this.a;
                                    apVar = ap.UPLOAD_FTOS_TOKEN;
                                    a2 = h.a(ak.a(this.a), d.ASSEMBLE_PUSH_FTOS);
                                }
                                ab.a(ak.a(this.a)).b(str);
                            } else {
                                akVar = this.a;
                                apVar = ap.UPLOAD_COS_TOKEN;
                                a2 = h.a(ak.a(this.a), d.ASSEMBLE_PUSH_COS);
                            }
                            akVar.a(str, apVar, false, a2);
                            ab.a(ak.a(this.a)).b(str);
                        } else {
                            akVar2 = this.a;
                            apVar2 = ap.ENABLE_PUSH;
                        }
                        akVar2.a(str, apVar2, true, (HashMap<String, String>) null);
                        ab.a(ak.a(this.a)).b(str);
                    } else {
                        ab.a(ak.a(this.a)).c(str);
                    }
                }
            }
        }
    }
}
