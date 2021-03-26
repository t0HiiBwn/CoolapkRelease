package com.xiaomi.push;

import com.xiaomi.a.a.a.c;
import java.util.Date;

class aq implements ep {
    final /* synthetic */ ap a;

    aq(ap apVar) {
        this.a = apVar;
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar) {
        c.c("[Slim] " + ap.a(this.a).format(new Date()) + " Connection reconnected (" + ap.b(this.a).hashCode() + ")");
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar, int i, Exception exc) {
        c.c("[Slim] " + ap.a(this.a).format(new Date()) + " Connection closed (" + ap.b(this.a).hashCode() + ")");
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar, Exception exc) {
        c.c("[Slim] " + ap.a(this.a).format(new Date()) + " Reconnection failed due to an exception (" + ap.b(this.a).hashCode() + ")");
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.ep
    public void b(em emVar) {
        c.c("[Slim] " + ap.a(this.a).format(new Date()) + " Connection started (" + ap.b(this.a).hashCode() + ")");
    }
}
