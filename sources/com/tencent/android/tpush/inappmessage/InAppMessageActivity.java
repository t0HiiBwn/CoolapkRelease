package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.inappmessage.a.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class InAppMessageActivity extends Activity {
    private Context a;
    private Handler b;
    private c c;
    private Intent d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.a = this;
            this.b = new Handler();
            Intent intent = getIntent();
            this.d = intent;
            if (a(intent)) {
                String stringExtra = this.d.getStringExtra("inAppMsg");
                this.d.putExtra("pushChannel", 100);
                a(stringExtra);
                return;
            }
            finish();
        } catch (Throwable th) {
            TLogger.e("InAppMessageActivity", "InAppMsg finish InAppMessageActivity :" + th.toString());
        }
    }

    private boolean a(Intent intent) {
        if (intent != null && intent.hasExtra("inapp_protect")) {
            String stringExtra = intent.getStringExtra("inapp_protect");
            if (!j.b(stringExtra)) {
                try {
                    Long valueOf = Long.valueOf(Rijndael.decrypt(stringExtra));
                    if (valueOf.longValue() <= 0 || System.currentTimeMillis() < valueOf.longValue()) {
                        return false;
                    }
                    return true;
                } catch (NumberFormatException e) {
                    TLogger.e("InAppMessageActivity", "InAppMsg checkIntent :" + e.toString());
                }
            }
        }
        return false;
    }

    private void a(final String str) {
        TLogger.i("InAppMessageActivity", "InAppMsg parseData :" + str);
        if (str != null && !TextUtils.isEmpty(str)) {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.inappmessage.InAppMessageActivity.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    Throwable th;
                    JSONObject jSONObject;
                    String str;
                    String str2;
                    String str3;
                    int length;
                    String str4;
                    String str5;
                    String str6;
                    JSONObject jSONObject2;
                    int optInt;
                    int optInt2;
                    try {
                        final HashMap hashMap = new HashMap();
                        JSONObject optJSONObject = new JSONObject(str).optJSONObject("dispContent");
                        if (optJSONObject != null) {
                            hashMap.put("Message.template.type", Integer.valueOf(optJSONObject.optInt("templateType", 1)));
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("titleLabel");
                            if (optJSONObject2 != null) {
                                try {
                                    String optString = optJSONObject2.optString("text", "");
                                    String optString2 = optJSONObject2.optString("color", "");
                                    int optInt3 = optJSONObject2.optInt("size", 20);
                                    String optString3 = optJSONObject2.optString("font", "");
                                    int optInt4 = optJSONObject2.optInt("style", 0);
                                    int optInt5 = optJSONObject2.optInt("alignment", 17);
                                    int optInt6 = optJSONObject2.optInt("location", 0);
                                    hashMap.put("Title.Text", optString);
                                    hashMap.put("Title.Color", optString2);
                                    hashMap.put("Title.Size", Integer.valueOf(optInt3));
                                    hashMap.put("Title.Align", Integer.valueOf(optInt5));
                                    hashMap.put("Title.Paint", optString3);
                                    hashMap.put("Title.Typeface", Integer.valueOf(optInt4));
                                    hashMap.put(Integer.valueOf(optInt6), "Title.Location");
                                    hashMap.put("Title Is Have", true);
                                } catch (Throwable th2) {
                                    th = th2;
                                    TLogger.e("InAppMessageActivity", "unexpected for InAppMsg:" + th.toString());
                                }
                            } else {
                                hashMap.put("Title Is Have", false);
                            }
                            JSONObject optJSONObject3 = optJSONObject.optJSONObject("contentLabel");
                            if (optJSONObject3 != null) {
                                String optString4 = optJSONObject3.optString("text", "");
                                String optString5 = optJSONObject3.optString("color", "");
                                int optInt7 = optJSONObject3.optInt("size", 20);
                                String optString6 = optJSONObject3.optString("font", "");
                                int optInt8 = optJSONObject3.optInt("style", 0);
                                int optInt9 = optJSONObject3.optInt("alignment", 17);
                                int optInt10 = optJSONObject3.optInt("location", 0);
                                hashMap.put("Message.Size", Integer.valueOf(optInt7));
                                hashMap.put("Message.Align", Integer.valueOf(optInt9));
                                hashMap.put("Message.Paint", optString6);
                                hashMap.put("Message.Typeface", Integer.valueOf(optInt8));
                                hashMap.put("Message.Text", optString4);
                                hashMap.put("Message.Color", optString5);
                                hashMap.put(Integer.valueOf(optInt10), "Message.Location");
                                hashMap.put("Message Is Have", true);
                            } else {
                                hashMap.put("Message Is Have", false);
                            }
                            JSONObject optJSONObject4 = optJSONObject.optJSONObject("mediaView");
                            if (optJSONObject4 != null) {
                                String optString7 = optJSONObject4.optString("url", "");
                                try {
                                    int optInt11 = optJSONObject4.optInt("width", i.a(InAppMessageActivity.this.a, 255.0f));
                                    int optInt12 = optJSONObject4.optInt("height", i.a(InAppMessageActivity.this.a, 215.0f));
                                    int optInt13 = optJSONObject4.optInt("location", 0);
                                    hashMap.put("Media url", optString7);
                                    hashMap.put("Media width", Integer.valueOf(optInt11));
                                    hashMap.put("Media heigh", Integer.valueOf(optInt12));
                                    hashMap.put(Integer.valueOf(optInt13), "Media.Location");
                                    hashMap.put("Media Is Have", true);
                                } catch (Throwable th3) {
                                    th = th3;
                                    TLogger.e("InAppMessageActivity", "unexpected for InAppMsg:" + th.toString());
                                }
                            } else {
                                hashMap.put("Media Is Have", false);
                            }
                            hashMap.put("Close button", Integer.valueOf(optJSONObject.optInt("showCloseBtn", 1)));
                            JSONArray optJSONArray = optJSONObject.optJSONArray("customBtns");
                            if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
                                jSONObject = optJSONObject;
                                str = "url";
                                str3 = "corner";
                                str2 = "action";
                            } else {
                                JSONObject jSONObject3 = optJSONArray.getJSONObject(0);
                                if (jSONObject3 == null || (optInt2 = jSONObject3.optInt("buttonId", 0)) == 0) {
                                    jSONObject = optJSONObject;
                                    str = "url";
                                    str4 = "corner";
                                    str5 = "action";
                                    str6 = "textColor";
                                } else {
                                    String optString8 = jSONObject3.optString("bgColor", "");
                                    str = "url";
                                    String optString9 = jSONObject3.optString("text", "");
                                    jSONObject = optJSONObject;
                                    String optString10 = jSONObject3.optString("textColor", "");
                                    str6 = "textColor";
                                    int optInt14 = jSONObject3.optInt("textSize", 20);
                                    int optInt15 = jSONObject3.optInt("corner", 0);
                                    int optInt16 = jSONObject3.optInt("location", 0);
                                    String optString11 = jSONObject3.optString("action", "");
                                    str5 = "action";
                                    str4 = "corner";
                                    int optInt17 = jSONObject3.optInt("actionType", 0);
                                    hashMap.put("Accept button.Text", optString9);
                                    hashMap.put("Accept button.Background color", optString8);
                                    hashMap.put("Accept button.Text color", optString10);
                                    hashMap.put("Accept button.Text size", Integer.valueOf(optInt14));
                                    hashMap.put("Accept button.corner", Integer.valueOf(optInt15));
                                    hashMap.put("Accept button.id", Integer.valueOf(optInt2));
                                    hashMap.put("Accept button.action", optString11);
                                    hashMap.put(Integer.valueOf(optInt16), "Button.Location");
                                    hashMap.put("Accept button.count", Integer.valueOf(length));
                                    hashMap.put("Accept button.action.type", Integer.valueOf(optInt17));
                                }
                                if (length != 2 || (jSONObject2 = optJSONArray.getJSONObject(1)) == null || (optInt = jSONObject2.optInt("buttonId", 0)) == 0) {
                                    str2 = str5;
                                    str3 = str4;
                                } else {
                                    String optString12 = jSONObject2.optString("bgColor", "");
                                    String optString13 = jSONObject2.optString("text", "");
                                    String optString14 = jSONObject2.optString(str6, "");
                                    int optInt18 = jSONObject2.optInt("textSize", 20);
                                    str3 = str4;
                                    int optInt19 = jSONObject2.optInt(str3, 0);
                                    str2 = str5;
                                    String optString15 = jSONObject2.optString(str2, "");
                                    int optInt20 = jSONObject3.optInt("actionType", 0);
                                    hashMap.put("Accept sec button.Text", optString13);
                                    hashMap.put("Accept sec button.Background color", optString12);
                                    hashMap.put("Accept sec button.Text color", optString14);
                                    hashMap.put("Accept sec button.Text size", Integer.valueOf(optInt18));
                                    hashMap.put("Accept sec button.corner", Integer.valueOf(optInt19));
                                    hashMap.put("Accept sec button.id", Integer.valueOf(optInt));
                                    hashMap.put("Accept sec button.action", optString15);
                                    hashMap.put("Accept sec button.action.type", Integer.valueOf(optInt20));
                                }
                            }
                            JSONObject optJSONObject5 = jSONObject.optJSONObject("bgCard");
                            if (optJSONObject5 != null) {
                                String optString16 = optJSONObject5.optString(str, "");
                                String optString17 = optJSONObject5.optString(str2, "");
                                int optInt21 = optJSONObject5.optInt(str3, 0);
                                hashMap.put("Background color", optJSONObject5.optString("bgColor", ""));
                                hashMap.put("Background image url", optString16);
                                hashMap.put("Background action", optString17);
                                hashMap.put("Background corner", Integer.valueOf(optInt21));
                            }
                            hashMap.put("Layout.Width", 303);
                            hashMap.put("Layout.Height", 600);
                            InAppMessageActivity.this.b.post(new Runnable() {
                                /* class com.tencent.android.tpush.inappmessage.InAppMessageActivity.AnonymousClass1.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        d dVar = new d(new a("center_popup", hashMap, "message_id"));
                                        InAppMessageActivity.this.c = new c((InAppMessageActivity) InAppMessageActivity.this.a, dVar, InAppMessageActivity.this.d);
                                        InAppMessageActivity.this.c.show();
                                        ServiceStat.appReportSDKReceived(b.e(), InAppMessageActivity.this.d);
                                    } catch (Throwable th) {
                                        TLogger.e("InAppMessageActivity", "init CenterPopup :" + th.toString());
                                    }
                                }
                            });
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        TLogger.e("InAppMessageActivity", "unexpected for InAppMsg:" + th.toString());
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.dismiss();
        }
        super.onDestroy();
    }
}
