package com.ali.auth.third.login;

import android.app.Activity;
import android.graphics.Bitmap;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.callback.NQrCodeLoginCallback;
import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.task.LoadQrCodePicTask;
import com.ali.auth.third.login.task.LoginByQrCodeTask;
import com.ali.auth.third.ui.QRView;
import com.ali.auth.third.ui.context.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class QRComponent {
    private static Timer a;
    private static long b;

    private static void a(int i, int i2, final NQrCodeLoginCallback nQrCodeLoginCallback) {
        QRView.mLoginCallback = new LoginCallback() {
            /* class com.ali.auth.third.login.QRComponent.AnonymousClass1 */

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
            }

            @Override // com.ali.auth.third.core.callback.LoginCallback
            public void onSuccess(Session session) {
                QRComponent.d();
                nQrCodeLoginCallback.onSuccess(session);
            }
        };
        new LoadQrCodePicTask(new ResultCallback() {
            /* class com.ali.auth.third.login.QRComponent.AnonymousClass2 */

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                nQrCodeLoginCallback.onFailure(i, str);
            }

            @Override // com.ali.auth.third.core.callback.ResultCallback
            public void onSuccess(Object obj) {
                Map map = (Map) obj;
                Bitmap bitmap = (Bitmap) map.remove("imageBitMap");
                final String str = (String) map.get("at");
                HashMap hashMap = new HashMap();
                hashMap.put("qrCodeInfo", map);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("params", hashMap);
                final String jSONObject = JSONUtils.toJsonObject(hashMap2).toString();
                if (QRComponent.a == null) {
                    Timer unused = QRComponent.a = new Timer();
                    long unused2 = QRComponent.b = System.currentTimeMillis();
                }
                QRComponent.a.schedule(new TimerTask() {
                    /* class com.ali.auth.third.login.QRComponent.AnonymousClass2.AnonymousClass1 */

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        new LoginByQrCodeTask(new a() {
                            /* class com.ali.auth.third.login.QRComponent.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                            @Override // com.ali.auth.third.ui.context.a
                            public Activity a() {
                                return null;
                            }

                            @Override // com.ali.auth.third.ui.context.a
                            public void a(int i, String str) {
                                nQrCodeLoginCallback.onFailure(i, str);
                            }

                            @Override // com.ali.auth.third.ui.context.a
                            public void a(String str) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (System.currentTimeMillis() - QRComponent.b > 900000) {
                                        QRComponent.d();
                                        nQrCodeLoginCallback.onQrImageStatusChanged(str, 10022);
                                        return;
                                    }
                                    nQrCodeLoginCallback.onQrImageStatusChanged(str, jSONObject.getInt("code"));
                                    if (jSONObject.getInt("code") == 6) {
                                        QRComponent.d();
                                    }
                                } catch (JSONException unused) {
                                }
                            }

                            @Override // com.ali.auth.third.ui.context.a
                            public void b(String str) {
                                nQrCodeLoginCallback.onFailure(1, str);
                            }
                        }, false).execute(new String[]{jSONObject});
                    }
                }, 3000, 2000);
                nQrCodeLoginCallback.onQrImageLoaded(str, bitmap, new NQrCodeLoginCallback.NQrCodeLoginController() {
                    /* class com.ali.auth.third.login.QRComponent.AnonymousClass2.AnonymousClass2 */

                    @Override // com.ali.auth.third.core.callback.NQrCodeLoginCallback.NQrCodeLoginController
                    public void cancle() {
                        QRComponent.d();
                    }
                });
            }
        }).execute(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), null});
    }

    /* access modifiers changed from: private */
    public static void d() {
        Timer timer = a;
        if (timer != null) {
            timer.cancel();
            a = null;
        }
    }

    public static void start(int i, int i2, NQrCodeLoginCallback nQrCodeLoginCallback) {
        a(i, i2, nQrCodeLoginCallback);
    }
}
