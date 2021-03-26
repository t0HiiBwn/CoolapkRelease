package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.n;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import org.json.JSONObject;

public class TTMiddlePageActivity extends Activity {
    private LinearLayout a;
    private TTNativeExpressAd b;
    private l c;
    private AdSlot d;
    private b e;
    private boolean f = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        x jsObject;
        super.onCreate(bundle);
        setContentView(ac.f(this, "tt_activity_middle_page"));
        Intent intent = getIntent();
        if (intent != null) {
            try {
                l a2 = c.a(new JSONObject(intent.getStringExtra("middle_page_material_meta")));
                this.c = a2;
                AdSlot b2 = b(a2);
                this.d = b2;
                this.b = new n(this, this.c, b2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        TTNativeExpressAd tTNativeExpressAd = this.b;
        if (tTNativeExpressAd == null) {
            finish();
            return;
        }
        View expressAdView = tTNativeExpressAd.getExpressAdView();
        if (expressAdView == null) {
            finish();
            return;
        }
        this.a = (LinearLayout) findViewById(ac.e(this, "tt_middle_page_layout"));
        if (expressAdView instanceof NativeExpressVideoView) {
            this.e = ((NativeExpressVideoView) expressAdView).getClickListener();
        } else if (expressAdView instanceof NativeExpressView) {
            this.e = ((NativeExpressView) expressAdView).getClickListener();
        }
        l lVar = this.c;
        if (lVar != null && lVar.aA() == 2 && (expressAdView instanceof NativeExpressView) && (jsObject = ((NativeExpressView) expressAdView).getJsObject()) != null) {
            jsObject.a(this.d);
        }
        this.b.setCanInterruptVideoPlay(true);
        this.a.removeAllViews();
        this.a.addView(expressAdView);
        this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() {
            /* class com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                if (!TTMiddlePageActivity.this.f) {
                    if (!(TTMiddlePageActivity.this.c == null || TTMiddlePageActivity.this.c.aA() != 1 || TTMiddlePageActivity.this.e == null)) {
                        TTMiddlePageActivity.this.f = true;
                        TTMiddlePageActivity.this.e.e();
                    }
                    TTMiddlePageActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                d.b(p.a(), TTMiddlePageActivity.this.c, "feed_video_middle_page", "middle_page_show");
            }
        });
        this.b.render();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
    }

    private AdSlot b(l lVar) {
        if (lVar == null || lVar.aj() == null) {
            return null;
        }
        String str = aj.d(lVar.aj()) + "";
        float b2 = (float) ak.b(this, (float) ak.c(this));
        float f2 = 0.0f;
        try {
            f2 = ak.i(getApplicationContext());
        } catch (Throwable unused) {
        }
        return new AdSlot.Builder().setCodeId(str).setExpressViewAcceptedSize(b2, (float) ak.b(this, ((float) ak.d(this)) - f2)).build();
    }

    public static boolean a(Context context, l lVar) {
        if (!(lVar == null || context == null)) {
            boolean z = lVar.aA() == 1;
            l.a N = lVar.N();
            if (z && N != null) {
                String jSONObject = lVar.aF().toString();
                Intent intent = new Intent(context, TTMiddlePageActivity.class);
                intent.putExtra("middle_page_material_meta", jSONObject);
                com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context, l lVar) {
        if (context == null || !a(lVar)) {
            return false;
        }
        String jSONObject = lVar.aF().toString();
        Intent intent = new Intent(context, TTMiddlePageActivity.class);
        intent.putExtra("middle_page_material_meta", jSONObject);
        com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
        return true;
    }

    public static boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        return (lVar.aA() == 2) && lVar.N() != null;
    }
}
