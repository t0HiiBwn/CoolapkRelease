package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.util.Date;

class br implements fl {
    final /* synthetic */ bq a;

    br(bq bqVar) {
        this.a = bqVar;
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar) {
        b.c("[Slim] " + this.a.f236a.format(new Date()) + " Connection reconnected (" + this.a.f233a.hashCode() + ")");
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar, int i, Exception exc) {
        b.c("[Slim] " + this.a.f236a.format(new Date()) + " Connection closed (" + this.a.f233a.hashCode() + ")");
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar, Exception exc) {
        b.c("[Slim] " + this.a.f236a.format(new Date()) + " Reconnection failed due to an exception (" + this.a.f233a.hashCode() + ")");
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fl
    public void b(fi fiVar) {
        b.c("[Slim] " + this.a.f236a.format(new Date()) + " Connection started (" + this.a.f233a.hashCode() + ")");
    }
}
