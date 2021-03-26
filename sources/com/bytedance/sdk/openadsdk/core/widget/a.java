package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AppDetailFullDialog */
public class a extends AlertDialog {
    protected Context a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ListView g;
    private Button h;
    private AbstractC0047a i;
    private String j = "补充中，可于应用官网查看";
    private String k = "暂无";

    /* renamed from: l  reason: collision with root package name */
    private String f1324l;
    private String m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
    private String n;
    private HashMap<String, String> o;
    private View p;
    private TextView q;
    private boolean r = false;
    private List<c> s = new ArrayList();

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AppDetailFullDialog */
    public interface AbstractC0047a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    public a a(AbstractC0047a aVar) {
        this.i = aVar;
        return this;
    }

    public a(Context context, String str) {
        super(context, ac.g(context, "DialogFullscreen"));
        this.a = context;
        if (context == null) {
            this.a = p.a();
        }
        this.n = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.a, "tt_app_detail_full_dialog"));
        a();
        b();
    }

    protected void a() {
        if (TextUtils.isEmpty(this.n)) {
            this.k = "暂无";
            this.j = "补充中，可于应用官网查看";
            this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
            a(this.o);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(this.n));
            if (b2 != null) {
                String b3 = b2.b();
                this.k = b3;
                if (TextUtils.isEmpty(b3)) {
                    this.k = "暂无";
                }
                String c2 = b2.c();
                this.j = c2;
                if (TextUtils.isEmpty(c2)) {
                    this.j = "补充中，可于应用官网查看";
                }
                String d2 = b2.d();
                this.m = d2;
                if (TextUtils.isEmpty(d2)) {
                    this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                }
                String g2 = b2.g();
                if (!TextUtils.isEmpty(g2)) {
                    this.f1324l = g2;
                }
                HashMap<String, String> a2 = b2.a();
                this.o = a2;
                a(a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(HashMap<String, String> hashMap) {
        List<c> list = this.s;
        if (list != null && list.size() > 0) {
            this.s.clear();
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        if (hashMap == null || hashMap.size() <= 0) {
            this.s.add(new c("补充中，可于应用官网查看", ""));
            return;
        }
        for (String str : hashMap.keySet()) {
            this.s.add(new c(str, hashMap.get(str)));
        }
    }

    protected void b() {
        View inflate = getLayoutInflater().inflate(ac.f(this.a, "tt_app_detail_full_dialog_list_head"), (ViewGroup) null);
        this.p = inflate;
        this.b = (TextView) inflate.findViewById(ac.e(this.a, "tt_app_developer_tv"));
        this.d = (TextView) this.p.findViewById(ac.e(this.a, "tt_app_privacy_url_tv"));
        this.q = (TextView) this.p.findViewById(ac.e(this.a, "tt_app_privacy_tv"));
        this.f = (TextView) this.p.findViewById(ac.e(this.a, "tt_app_name_tv"));
        this.c = (TextView) this.p.findViewById(ac.e(this.a, "tt_app_version_tv"));
        this.h = (Button) findViewById(ac.e(this.a, "tt_download_app_btn"));
        this.g = (ListView) findViewById(ac.e(this.a, "tt_privacy_list"));
        this.e = (TextView) findViewById(ac.e(this.a, "tt_app_detail_back_tv"));
        this.g.addHeaderView(this.p);
        if (this.r) {
            this.h.setVisibility(0);
            this.h.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.core.widget.a.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.i != null) {
                        a.this.i.a(a.this);
                    }
                }
            });
        } else {
            this.h.setVisibility(8);
        }
        this.e.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.a.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.b(a.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.a.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.c(a.this);
                }
            }
        });
        List<c> list = this.s;
        if (list != null && list.size() > 0) {
            Context context = this.a;
            this.g.setAdapter((ListAdapter) new b(context, ac.f(context, "tt_app_detail_listview_item"), this.s));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    public a a(String str) {
        this.f1324l = str;
        return this;
    }

    public void a(boolean z) {
        this.r = z;
    }

    private void c() {
        if (this.b != null) {
            this.b.setText(String.format(ac.a(this.a, "tt_open_app_detail_developer"), this.j));
        }
        if (this.c != null) {
            this.c.setText(String.format(ac.a(this.a, "tt_open_app_version"), this.k));
        }
        String str = this.m;
        if (str != null) {
            this.d.setText(str);
        }
        if (this.f != null) {
            this.f.setText(String.format(ac.a(this.a, "tt_open_app_name"), this.f1324l));
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        AbstractC0047a aVar = this.i;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    /* compiled from: AppDetailFullDialog */
    class c {
        private String b;
        private String c;

        public c(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    /* compiled from: AppDetailFullDialog */
    class b extends ArrayAdapter<c> {
        public b(Context context, int i, List<c> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0048a aVar;
            c cVar = (c) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(ac.f(a.this.a, "tt_app_detail_listview_item"), viewGroup, false);
                aVar = new C0048a();
                aVar.a = (TextView) view.findViewById(ac.e(a.this.a, "tt_item_title_tv"));
                aVar.b = (TextView) view.findViewById(ac.e(a.this.a, "tt_item_desc_tv"));
                aVar.c = (ImageView) view.findViewById(ac.e(a.this.a, "tt_item_select_img"));
                view.setTag(aVar);
            } else {
                aVar = (C0048a) view.getTag();
            }
            aVar.c.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(cVar.a())) {
                aVar.c.setVisibility(4);
            }
            aVar.a.setText(cVar.a());
            aVar.b.setText(cVar.b());
            return view;
        }

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$b$a  reason: collision with other inner class name */
        /* compiled from: AppDetailFullDialog */
        class C0048a {
            TextView a;
            TextView b;
            ImageView c;

            C0048a() {
            }
        }
    }
}
