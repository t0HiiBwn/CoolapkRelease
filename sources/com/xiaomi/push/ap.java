package com.xiaomi.push;

import com.xiaomi.a.a.a.c;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ap implements ez {
    public static boolean a;
    private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");
    private em c = null;
    private a d = null;
    private a e = null;
    private ep f = null;
    private final String g = "[Slim] ";

    class a implements er, fa {
        String a;

        a(boolean z) {
            ap.this = r1;
            this.a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.er
        public void a(ef efVar) {
            String str;
            StringBuilder sb;
            if (ap.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ap.this.b.format(new Date()));
                sb.append(this.a);
                str = efVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ap.this.b.format(new Date()));
                sb.append(this.a);
                sb.append(" Blob [");
                sb.append(efVar.a());
                sb.append(",");
                sb.append(efVar.c());
                sb.append(",");
                sb.append(efVar.h());
                str = "]";
            }
            sb.append(str);
            c.c(sb.toString());
        }

        @Override // com.xiaomi.push.fa
        public boolean a(fe feVar) {
            return true;
        }

        @Override // com.xiaomi.push.er
        public void b(fe feVar) {
            String str;
            StringBuilder sb;
            if (ap.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ap.this.b.format(new Date()));
                sb.append(this.a);
                sb.append(" PKT ");
                str = feVar.c();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ap.this.b.format(new Date()));
                sb.append(this.a);
                sb.append(" PKT [");
                sb.append(feVar.l());
                sb.append(",");
                sb.append(feVar.k());
                str = "]";
            }
            sb.append(str);
            c.c(sb.toString());
        }
    }

    public ap(em emVar) {
        this.c = emVar;
        a();
    }

    private void a() {
        this.d = new a(true);
        this.e = new a(false);
        em emVar = this.c;
        a aVar = this.d;
        emVar.a(aVar, aVar);
        em emVar2 = this.c;
        a aVar2 = this.e;
        emVar2.b(aVar2, aVar2);
        this.f = new aq(this);
    }
}
