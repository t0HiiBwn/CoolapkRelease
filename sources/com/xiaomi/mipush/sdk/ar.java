package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

class ar extends Handler {
    final /* synthetic */ aq a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ar(aq aqVar, Looper looper) {
        super(looper);
        this.a = aqVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        aq aqVar;
        av avVar;
        HashMap<String, String> a2;
        aq aqVar2;
        av avVar2;
        if (message.what == 19) {
            String str = (String) message.obj;
            int i = message.arg1;
            synchronized (ag.class) {
                if (ag.a(aq.a(this.a)).m37a(str)) {
                    if (ag.a(aq.a(this.a)).a(str) < 10) {
                        if (av.DISABLE_PUSH.ordinal() == i && "syncing".equals(ag.a(aq.a(this.a)).a(av.DISABLE_PUSH))) {
                            aqVar2 = this.a;
                            avVar2 = av.DISABLE_PUSH;
                        } else if (av.ENABLE_PUSH.ordinal() != i || !"syncing".equals(ag.a(aq.a(this.a)).a(av.ENABLE_PUSH))) {
                            if (av.UPLOAD_HUAWEI_TOKEN.ordinal() == i && "syncing".equals(ag.a(aq.a(this.a)).a(av.UPLOAD_HUAWEI_TOKEN))) {
                                aqVar = this.a;
                                avVar = av.UPLOAD_HUAWEI_TOKEN;
                                a2 = h.a(aq.a(this.a), d.ASSEMBLE_PUSH_HUAWEI);
                            } else if (av.UPLOAD_FCM_TOKEN.ordinal() == i && "syncing".equals(ag.a(aq.a(this.a)).a(av.UPLOAD_FCM_TOKEN))) {
                                aqVar = this.a;
                                avVar = av.UPLOAD_FCM_TOKEN;
                                a2 = h.a(aq.a(this.a), d.ASSEMBLE_PUSH_FCM);
                            } else if (av.UPLOAD_COS_TOKEN.ordinal() != i || !"syncing".equals(ag.a(aq.a(this.a)).a(av.UPLOAD_COS_TOKEN))) {
                                if (av.UPLOAD_FTOS_TOKEN.ordinal() == i && "syncing".equals(ag.a(aq.a(this.a)).a(av.UPLOAD_FTOS_TOKEN))) {
                                    aqVar = this.a;
                                    avVar = av.UPLOAD_FTOS_TOKEN;
                                    a2 = h.a(aq.a(this.a), d.ASSEMBLE_PUSH_FTOS);
                                }
                                ag.a(aq.a(this.a)).b(str);
                            } else {
                                aqVar = this.a;
                                avVar = av.UPLOAD_COS_TOKEN;
                                a2 = h.a(aq.a(this.a), d.ASSEMBLE_PUSH_COS);
                            }
                            aqVar.a(str, avVar, false, a2);
                            ag.a(aq.a(this.a)).b(str);
                        } else {
                            aqVar2 = this.a;
                            avVar2 = av.ENABLE_PUSH;
                        }
                        aqVar2.a(str, avVar2, true, (HashMap<String, String>) null);
                        ag.a(aq.a(this.a)).b(str);
                    } else {
                        ag.a(aq.a(this.a)).c(str);
                    }
                }
            }
        }
    }
}
