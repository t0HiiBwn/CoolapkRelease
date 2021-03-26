package com.huawei.hms.stats;

import android.content.Context;

public class bt {

    public static class a {
        p a;
        p b;
        Context c;
        String d;

        public a(Context context) {
            if (context != null) {
                this.c = context.getApplicationContext();
            }
            this.a = new p();
            this.b = new p();
        }

        public a a(int i, String str) {
            p pVar;
            af.b("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i);
            if (!bc.a(str)) {
                str = "";
            }
            if (i == 0) {
                pVar = this.a;
            } else if (i != 1) {
                af.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            } else {
                pVar = this.b;
            }
            pVar.b(str);
            return this;
        }

        public a a(String str) {
            af.b("hmsSdk", "Builder.setAppID is execute");
            this.d = str;
            return this;
        }

        public void a() {
            if (this.c == null) {
                af.d("hmsSdk", "analyticsConf create(): context is null,create failed!");
                return;
            }
            af.b("hmsSdk", "Builder.create() is execute.");
            bq bqVar = new bq("_hms_config_tag");
            bqVar.c(new p(this.a));
            bqVar.a(new p(this.b));
            bo.a().a(this.c);
            bp.a().a(this.c);
            bv.a().a(bqVar);
            bo.a().b(this.d);
        }

        public void a(boolean z) {
            af.b("hmsSdk", "Builder.refresh() is execute.");
            p pVar = new p(this.b);
            p pVar2 = new p(this.a);
            bq b2 = bv.a().b();
            if (b2 == null) {
                af.c("hmsSdk", "HiAnalyticsInstance.Builder.Refresh(): calling refresh before create. TAG: _hms_config_tag has no instance. ");
                return;
            }
            b2.a(1, pVar);
            b2.a(0, pVar2);
            if (this.d != null) {
                bo.a().b(this.d);
            }
            if (z) {
                bo.a().a("_hms_config_tag");
            }
        }

        @Deprecated
        public a b(boolean z) {
            af.b("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
            this.a.b().c(z);
            this.b.b().c(z);
            return this;
        }

        @Deprecated
        public a c(boolean z) {
            af.b("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
            this.a.b().b(z);
            this.b.b().b(z);
            return this;
        }

        @Deprecated
        public a d(boolean z) {
            af.b("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
            this.a.b().a(z);
            this.b.b().a(z);
            return this;
        }
    }
}
