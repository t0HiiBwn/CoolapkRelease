package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bq implements fu {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private a f232a = null;

    /* renamed from: a  reason: collision with other field name */
    private fi f233a = null;

    /* renamed from: a  reason: collision with other field name */
    private fl f234a = null;

    /* renamed from: a  reason: collision with other field name */
    private final String f235a = "[Slim] ";

    /* renamed from: a  reason: collision with other field name */
    private SimpleDateFormat f236a = new SimpleDateFormat("hh:mm:ss aaa");
    private a b = null;

    class a implements fn, fv {

        /* renamed from: a  reason: collision with other field name */
        String f237a;

        a(boolean z) {
            this.f237a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fn
        public void a(fb fbVar) {
            String str;
            StringBuilder sb;
            if (bq.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(bq.this.f236a.format(new Date()));
                sb.append(this.f237a);
                str = fbVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(bq.this.f236a.format(new Date()));
                sb.append(this.f237a);
                sb.append(" Blob [");
                sb.append(fbVar.m317a());
                sb.append(",");
                sb.append(fbVar.a());
                sb.append(",");
                sb.append(fbVar.e());
                str = "]";
            }
            sb.append(str);
            b.c(sb.toString());
        }

        @Override // com.xiaomi.push.fn, com.xiaomi.push.fv
        /* renamed from: a */
        public void mo148a(fz fzVar) {
            String str;
            StringBuilder sb;
            if (bq.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(bq.this.f236a.format(new Date()));
                sb.append(this.f237a);
                sb.append(" PKT ");
                str = fzVar.m352a();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(bq.this.f236a.format(new Date()));
                sb.append(this.f237a);
                sb.append(" PKT [");
                sb.append(fzVar.k());
                sb.append(",");
                sb.append(fzVar.j());
                str = "]";
            }
            sb.append(str);
            b.c(sb.toString());
        }

        @Override // com.xiaomi.push.fn, com.xiaomi.push.fv
        /* renamed from: a  reason: collision with other method in class */
        public boolean mo148a(fz fzVar) {
            return true;
        }
    }

    public bq(fi fiVar) {
        this.f233a = fiVar;
        a();
    }

    private void a() {
        this.f232a = new a(true);
        this.b = new a(false);
        fi fiVar = this.f233a;
        a aVar = this.f232a;
        fiVar.a(aVar, aVar);
        fi fiVar2 = this.f233a;
        a aVar2 = this.b;
        fiVar2.b(aVar2, aVar2);
        this.f234a = new br(this);
    }
}
