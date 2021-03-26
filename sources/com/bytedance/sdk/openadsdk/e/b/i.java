package com.bytedance.sdk.openadsdk.e.b;

import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.e.a.d;
import com.bytedance.sdk.openadsdk.e.a.f;
import com.bytedance.sdk.openadsdk.e.a.q;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: ShowAppDetailOrPrivacyDialogMethod */
public class i extends d<JSONObject, JSONObject> {
    private WeakReference<x> a;

    public static void a(q qVar, final x xVar) {
        qVar.a("showAppDetailOrPrivacyDialog", (d.b) new d.b() {
            /* class com.bytedance.sdk.openadsdk.e.b.i.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.e.a.d.b
            public d a() {
                return new i(xVar);
            }
        });
    }

    public i(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        if (com.bytedance.sdk.openadsdk.core.i.d().v()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            u.b("ShowAppDetailOrPrivacyDialogMethod", sb.toString());
        }
        WeakReference<x> weakReference = this.a;
        if (weakReference != null) {
            x xVar = weakReference.get();
            if (xVar == null) {
                c();
            } else if (jSONObject != null) {
                int optInt = jSONObject.optInt("show_dialog_style");
                if (optInt == 1) {
                    xVar.j();
                    u.b("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppDetailDialog ");
                } else if (optInt == 2) {
                    xVar.i();
                    u.b("ShowAppDetailOrPrivacyDialogMethod", "ShowAppDetailOrPrivacyDialogMethod showAppPrivacyDialog ");
                }
            }
        }
    }
}
