package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.d.a;
import com.ss.android.socialbase.appdownloader.h;
import com.ss.android.socialbase.appdownloader.i;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpUnknownSourceActivity extends Activity {
    private k a;
    private Intent b;
    private Intent c;
    private int d;
    private JSONObject e;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        h.a().a(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        h.a().a(this);
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.b = intent;
        if (intent != null) {
            this.c = (Intent) intent.getParcelableExtra("intent");
            this.d = intent.getIntExtra("id", -1);
            try {
                this.e = new JSONObject(intent.getStringExtra("config"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        b();
        k kVar = this.a;
        if (kVar != null && !kVar.b()) {
            this.a.a();
        } else if (this.a == null) {
            finish();
        }
    }

    private void b() {
        if (this.a == null && this.b != null) {
            try {
                c a2 = d.j().a();
                l lVar = null;
                if (a2 != null) {
                    lVar = a2.a(this);
                }
                if (lVar == null) {
                    lVar = new a(this);
                }
                int a3 = i.a(this, "tt_appdownloader_tip");
                int a4 = i.a(this, "tt_appdownloader_label_ok");
                int a5 = i.a(this, "tt_appdownloader_label_cancel");
                String optString = this.e.optString("jump_unknown_source_tips");
                if (TextUtils.isEmpty(optString)) {
                    optString = getString(i.a(this, "tt_appdownloader_jump_unknown_source_tips"));
                }
                lVar.a(a3).a(optString).a(a4, new DialogInterface.OnClickListener() {
                    /* class com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.AnonymousClass3 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        if (!b.a(jumpUnknownSourceActivity, jumpUnknownSourceActivity.c, JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.e)) {
                            JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                            b.a((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.c, true);
                        } else {
                            b.c(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.e);
                        }
                        b.a(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.e);
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).b(a5, new DialogInterface.OnClickListener() {
                    /* class com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.AnonymousClass2 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (JumpUnknownSourceActivity.this.c != null) {
                            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                            b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.c, true);
                        }
                        b.b(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.e);
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).a(new DialogInterface.OnCancelListener() {
                    /* class com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.AnonymousClass1 */

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (JumpUnknownSourceActivity.this.c != null) {
                            JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                            b.a((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.c, true);
                        }
                        b.b(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.e);
                        JumpUnknownSourceActivity.this.finish();
                    }
                }).a(false);
                this.a = lVar.a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
