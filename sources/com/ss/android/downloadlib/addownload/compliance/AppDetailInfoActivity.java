package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.downloadlib.R;
import com.ss.android.downloadlib.addownload.b.b;
import com.ss.android.socialbase.appdownloader.c;
import java.util.List;

public class AppDetailInfoActivity extends Activity {
    private ImageView a;
    private TextView b;
    private LinearLayout c;
    private RecyclerView d;
    private long e;
    private long f;
    private List<Pair<String, String>> g;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        a();
        b();
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void a() {
        this.e = getIntent().getLongExtra("app_info_id", 0);
        b a2 = c.a().a(this.e);
        this.f = a2.b;
        this.g = a2.h;
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_detail_back);
        this.b = (TextView) findViewById(R.id.tv_empty);
        this.d = (RecyclerView) findViewById(R.id.permission_list);
        this.c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.g.isEmpty()) {
            this.d.setVisibility(8);
            this.b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.d.setLayoutManager(linearLayoutManager);
            this.d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f);
                b.a().b(AppDetailInfoActivity.this.f);
                c.a((Activity) AppDetailInfoActivity.this);
                c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_detail_click_close", this.f);
        super.onBackPressed();
    }

    private class a extends RecyclerView.Adapter<Object> {
        private a() {
        }
    }
}
