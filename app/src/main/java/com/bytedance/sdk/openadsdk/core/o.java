package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: InteractionManager */
public class o {
    private final l a;
    private a b;
    private final Context c;
    private final TTNativeAd d;
    private List<View> e = new ArrayList();
    private String f = "embeded_ad";
    private TTNativeAd.AdInteractionListener g;

    public o(Context context, TTNativeAd tTNativeAd, l lVar, String str) {
        this.d = tTNativeAd;
        this.a = lVar;
        this.c = context;
        this.f = str;
        if (lVar.T() == 4) {
            this.b = com.bytedance.sdk.openadsdk.downloadnew.a.a(context, lVar, this.f);
        }
    }

    public void a(Activity activity) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(activity);
        }
    }

    public void a(View view, int i) {
        TTNativeAd.AdInteractionListener adInteractionListener = this.g;
        if (adInteractionListener != null) {
            adInteractionListener.onAdCreativeClick(view, this.d);
        }
    }

    public a a() {
        return this.b;
    }

    public void a(final ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, final TTNativeAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
        a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
        d.a(this.a);
        EmptyView a2 = a(viewGroup);
        if (a2 == null) {
            a2 = new EmptyView(this.c, viewGroup);
            viewGroup.addView(a2);
        }
        a2.a();
        a2.setRefClickViews(list2);
        a2.setRefCreativeViews(list3);
        a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(a2);
        }
        this.e = list;
        Context context = this.c;
        l lVar = this.a;
        String str = this.f;
        b bVar = new b(context, lVar, str, aj.a(str));
        bVar.a(viewGroup);
        bVar.b(view);
        bVar.a(this.b);
        bVar.a(this.d);
        bVar.a(new b.a() {
            /* class com.bytedance.sdk.openadsdk.core.o.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                TTNativeAd.AdInteractionListener adInteractionListener = adInteractionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdClicked(view, o.this.d);
                }
            }
        });
        Context context2 = this.c;
        l lVar2 = this.a;
        String str2 = this.f;
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = new com.bytedance.sdk.openadsdk.core.a.a(context2, lVar2, str2, aj.a(str2));
        aVar3.a(viewGroup);
        aVar3.b(view);
        aVar3.a(this.b);
        aVar3.a(this.d);
        aVar3.a(new b.a() {
            /* class com.bytedance.sdk.openadsdk.core.o.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                TTNativeAd.AdInteractionListener adInteractionListener = adInteractionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdCreativeClick(view, o.this.d);
                }
            }
        });
        a2.a(list2, bVar);
        a2.a(list3, aVar3);
        a2.setCallback(new EmptyView.a() {
            /* class com.bytedance.sdk.openadsdk.core.o.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (o.this.b == null) {
                    return;
                }
                if (z) {
                    o.this.b.b();
                } else {
                    o.this.b.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (o.this.b != null) {
                    o.this.b.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (o.this.b != null) {
                    o.this.b.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                HashMap hashMap = new HashMap();
                if (o.this.e != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (View view2 : o.this.e) {
                        if (view2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("width", view2.getWidth());
                                jSONObject.put("height", view2.getHeight());
                                jSONObject.put("alpha", (double) view2.getAlpha());
                            } catch (Throwable unused) {
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                    hashMap.put("image_view", jSONArray.toString());
                }
                if (viewGroup != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("width", viewGroup.getWidth());
                        jSONObject2.put("height", viewGroup.getHeight());
                        jSONObject2.put("alpha", (double) viewGroup.getAlpha());
                    } catch (Throwable unused2) {
                    }
                    hashMap.put("root_view", jSONObject2.toString());
                }
                d.a(o.this.c, o.this.a, o.this.f, hashMap);
                u.e("AdEvent", "pangolin ad show " + aj.a(o.this.a, view));
                TTNativeAd.AdInteractionListener adInteractionListener = adInteractionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow(o.this.d);
                }
            }
        });
        a2.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }
}
