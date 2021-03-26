package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ai;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.bm;
import com.xiaomi.push.bp;
import com.xiaomi.push.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a {
    private static final int a = (l.m568a() ? 30 : 10);

    /* renamed from: a */
    private static volatile a f111a;

    /* renamed from: a */
    private Context f112a;

    /* renamed from: a */
    private Config f113a;

    /* renamed from: a */
    private IEventProcessor f114a;

    /* renamed from: a */
    private IPerfProcessor f115a;

    /* renamed from: a */
    private String f116a;

    /* renamed from: a */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f117a = new HashMap<>();

    /* renamed from: a */
    private ExecutorService f118a = Executors.newSingleThreadExecutor();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    private a(Context context) {
        this.f112a = context;
    }

    private int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.b;
        if (hashMap == null) {
            return 0;
        }
        int i = 0;
        for (String str : hashMap.keySet()) {
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.b.get(str);
            i += arrayList != null ? arrayList.size() : 0;
        }
        return i;
    }

    public static a a(Context context) {
        if (f111a == null) {
            synchronized (a.class) {
                if (f111a == null) {
                    f111a = new a(context);
                }
            }
        }
        return f111a;
    }

    private void a(ai.a aVar, int i) {
        ai.a(this.f112a).b(aVar, i);
    }

    private int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f117a;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f117a.get(str);
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        com.xiaomi.clientreport.data.a aVar = hashMap2.get(str2);
                        if (aVar instanceof PerfClientReport) {
                            i = (int) (((long) i) + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i;
    }

    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f114a;
        if (iEventProcessor != null) {
            iEventProcessor.mo46a(eventClientReport);
            if (a() >= 10) {
                d();
                ai.a(this.f112a).m103a("100888");
                return;
            }
            a(new d(this), a);
        }
    }

    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f115a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo46a(perfClientReport);
            if (b() >= 10) {
                e();
                ai.a(this.f112a).m103a("100889");
                return;
            }
            a(new f(this), a);
        }
    }

    private void d() {
        try {
            this.f114a.b();
        } catch (Exception e) {
            b.d("we: " + e.getMessage());
        }
    }

    private void e() {
        try {
            this.f115a.b();
        } catch (Exception e) {
            b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f112a).m43a().isEventUploadSwitchOpen()) {
            bj bjVar = new bj(this.f112a);
            int eventUploadFrequency = (int) a(this.f112a).m43a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bp.a(this.f112a).a("sp_client_report_status", "event_last_upload_time", 0L) > ((long) (eventUploadFrequency * 1000))) {
                ai.a(this.f112a).a(new h(this, bjVar), 10);
            }
            synchronized (a.class) {
                if (!ai.a(this.f112a).a((ai.a) bjVar, eventUploadFrequency)) {
                    ai.a(this.f112a).m103a("100886");
                    ai.a(this.f112a).a((ai.a) bjVar, eventUploadFrequency);
                }
            }
        }
    }

    private void g() {
        if (a(this.f112a).m43a().isPerfUploadSwitchOpen()) {
            bk bkVar = new bk(this.f112a);
            int perfUploadFrequency = (int) a(this.f112a).m43a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - bp.a(this.f112a).a("sp_client_report_status", "perf_last_upload_time", 0L) > ((long) (perfUploadFrequency * 1000))) {
                ai.a(this.f112a).a(new i(this, bkVar), 15);
            }
            synchronized (a.class) {
                if (!ai.a(this.f112a).a((ai.a) bkVar, perfUploadFrequency)) {
                    ai.a(this.f112a).m103a("100887");
                    ai.a(this.f112a).a((ai.a) bkVar, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized Config m43a() {
        if (this.f113a == null) {
            this.f113a = Config.defaultConfig(this.f112a);
        }
        return this.f113a;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bi.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f112a.getPackageName());
        eventClientReport.setSdkVersion(this.f116a);
        return eventClientReport;
    }

    /* renamed from: a */
    public void m44a() {
        a(this.f112a).f();
        a(this.f112a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f113a = config;
        this.f114a = iEventProcessor;
        this.f115a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f115a.setPerfMap(this.f117a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m43a().isEventUploadSwitchOpen()) {
            this.f118a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m43a().isPerfUploadSwitchOpen()) {
            this.f118a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f116a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f113a;
        if (config == null) {
            return;
        }
        if (z != config.isEventUploadSwitchOpen() || z2 != this.f113a.isPerfUploadSwitchOpen() || j != this.f113a.getEventUploadFrequency() || j2 != this.f113a.getPerfUploadFrequency()) {
            long eventUploadFrequency = this.f113a.getEventUploadFrequency();
            long perfUploadFrequency = this.f113a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bm.a(this.f112a)).setEventEncrypted(this.f113a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f112a);
            this.f113a = build;
            if (!build.isEventUploadSwitchOpen()) {
                ai.a(this.f112a).m103a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                b.c(this.f112a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f113a.isPerfUploadSwitchOpen()) {
                ai.a(this.f112a).m103a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                b.c(this.f112a.getPackageName() + "reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b */
    public void m45b() {
        if (m43a().isEventUploadSwitchOpen()) {
            bl blVar = new bl();
            blVar.a(this.f112a);
            blVar.a(this.f114a);
            this.f118a.execute(blVar);
        }
    }

    public void c() {
        if (m43a().isPerfUploadSwitchOpen()) {
            bl blVar = new bl();
            blVar.a(this.f115a);
            blVar.a(this.f112a);
            this.f118a.execute(blVar);
        }
    }
}
