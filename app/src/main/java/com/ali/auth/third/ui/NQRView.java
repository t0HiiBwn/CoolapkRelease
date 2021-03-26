package com.ali.auth.third.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ali.auth.third.core.callback.LoginCallback;
import com.ali.auth.third.core.callback.NQrCodeLoginCallback;
import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.model.Session;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.task.LoadQrCodePicTask;
import com.ali.auth.third.login.task.LoginByIVTokenTask;
import com.ali.auth.third.login.task.LoginByQrCodeTask;
import com.ali.auth.third.ui.a;
import com.ali.auth.third.ui.context.a;
import com.ali.auth.third.ui.iv.DataRepository;
import com.ali.auth.third.ui.iv.SMSVerificationView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NQRView extends FrameLayout {
    private static long a;
    private LinearLayout b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private ImageView f;
    private TextView g;
    private Button h;
    private LoginCallback i;
    private RelativeLayout j;
    private LinearLayout k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1186l;
    private NQrCodeLoginCallback m;
    Handler mHandler;

    public NQRView(Context context) {
        this(context, null);
    }

    public NQRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler();
        this.f1186l = true;
        this.m = new NQrCodeLoginCallback() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass1 */

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                NQRView.this.a(R.string.auth_sdk_message_10010_message);
                NQRView.this.i.onFailure(i, str);
            }

            @Override // com.ali.auth.third.core.callback.NQrCodeLoginCallback
            public void onQrImageLoaded(String str, Bitmap bitmap, NQrCodeLoginCallback.NQrCodeLoginController nQrCodeLoginController) {
                NQRView.this.f.setImageBitmap(bitmap);
                NQRView.this.c();
            }

            @Override // com.ali.auth.third.core.callback.NQrCodeLoginCallback
            public void onQrImageStatusChanged(String str, int i) {
                int i2;
                NQRView nQRView;
                if (i == 4) {
                    return;
                }
                if (i != 5) {
                    if (i != 6) {
                        NQRView.this.a();
                        nQRView = NQRView.this;
                        i2 = R.string.auth_sdk_message_10010_message;
                    } else {
                        NQRView.this.a();
                        nQRView = NQRView.this;
                        i2 = R.string.auth_sdk_message_qr_expired;
                    }
                    nQRView.a(i2);
                    return;
                }
                NQRView.this.d();
            }

            @Override // com.ali.auth.third.core.callback.LoginCallback
            public void onSuccess(Session session) {
                NQRView.this.a();
                NQRView.this.e();
                NQRView.this.i.onSuccess(session);
            }
        };
        LayoutInflater.from(context).inflate(getLayoutId(), this);
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.mHandler != null) {
            this.f1186l = true;
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i2) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass11 */

            @Override // java.lang.Runnable
            public void run() {
                NQRView.this.b();
                NQRView.this.b.setVisibility(8);
                NQRView.this.e.setVisibility(8);
                NQRView.this.g.setText(i2);
                NQRView.this.c.setVisibility(0);
                NQRView.this.d.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, final NQrCodeLoginCallback nQrCodeLoginCallback) {
        QRView.mLoginCallback = new LoginCallback() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass4 */

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
            }

            @Override // com.ali.auth.third.core.callback.LoginCallback
            public void onSuccess(Session session) {
                NQRView.this.a();
                nQrCodeLoginCallback.onSuccess(session);
            }
        };
        this.k.setVisibility(0);
        this.j.setVisibility(8);
        new LoadQrCodePicTask(new ResultCallback() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass5 */

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                nQrCodeLoginCallback.onFailure(i, str);
            }

            @Override // com.ali.auth.third.core.callback.ResultCallback
            public void onSuccess(Object obj) {
                Map map = (Map) obj;
                final String str = (String) map.get("at");
                HashMap hashMap = new HashMap();
                hashMap.put("qrCodeInfo", map);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("params", hashMap);
                final String jSONObject = JSONUtils.toJsonObject(hashMap2).toString();
                nQrCodeLoginCallback.onQrImageLoaded(str, (Bitmap) map.remove("imageBitMap"), null);
                long unused = NQRView.a = System.currentTimeMillis();
                NQRView.this.mHandler.postDelayed(new Runnable() {
                    /* class com.ali.auth.third.ui.NQRView.AnonymousClass5.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        if (!NQRView.this.f1186l) {
                            NQRView.this.a(str, jSONObject, nQrCodeLoginCallback);
                            NQRView.this.mHandler.postDelayed(this, 2000);
                        }
                    }
                }, 3000);
                NQRView.this.f1186l = false;
            }
        }).execute(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), null});
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("scene");
            String optString2 = jSONObject.optString("iv_token");
            final String optString3 = jSONObject.optString("login_token");
            if (TextUtils.equals("true", jSONObject.optString("nativeIv")) && !TextUtils.isEmpty(optString2)) {
                DataRepository.fetchIVStrategys(optString2, "8", new RpcRequestCallbackWithCode() {
                    /* class com.ali.auth.third.ui.NQRView.AnonymousClass8 */

                    @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
                    public void onError(String str, RpcResponse rpcResponse) {
                        if (rpcResponse != null && rpcResponse.code == 13078) {
                            try {
                                String optString = new JSONObject((String) rpcResponse.returnValue).optString("havana_iv_token");
                                LoginByIVTokenTask loginByIVTokenTask = new LoginByIVTokenTask(null, new LoginCallback() {
                                    /* class com.ali.auth.third.ui.NQRView.AnonymousClass8.AnonymousClass1 */

                                    @Override // com.ali.auth.third.core.callback.FailureCallback
                                    public void onFailure(int i, String str) {
                                        NQRView.this.a(R.string.auth_sdk_message_10010_message);
                                        NQRView.this.i.onFailure(1003, "");
                                    }

                                    @Override // com.ali.auth.third.core.callback.LoginCallback
                                    public void onSuccess(Session session) {
                                        NQRView.this.e();
                                        NQRView.this.i.onSuccess(session);
                                    }
                                });
                                Executor executor = ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor;
                                loginByIVTokenTask.executeOnExecutor(executor, new String[]{optString3, optString, "havana_iv_token=" + optString});
                                return;
                            } catch (Throwable unused) {
                            }
                        }
                        NQRView.this.a(R.string.auth_sdk_message_10010_message);
                        NQRView.this.i.onFailure(1004, "");
                    }

                    @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
                    public void onSuccess(RpcResponse rpcResponse) {
                        try {
                            JSONObject jSONObject = new JSONObject((String) rpcResponse.returnValue);
                            JSONArray optJSONArray = jSONObject.optJSONArray("products");
                            String optString = jSONObject.optString("hToken");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                int i = 0;
                                while (true) {
                                    if (i >= optJSONArray.length()) {
                                        break;
                                    }
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                    if (TextUtils.equals("8", optJSONObject.optString("tag"))) {
                                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("validatorList");
                                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                                JSONObject jSONObject2 = optJSONArray2.optJSONObject(i2).getJSONObject("valueAttrbute");
                                                if (jSONObject2 != null) {
                                                    HashMap hashMap = new HashMap();
                                                    hashMap.put("mobile", jSONObject2.keys().next());
                                                    hashMap.put("iv_token", optString);
                                                    hashMap.put("iv_type", "8");
                                                    hashMap.put("scene", optString);
                                                    NQRView.this.showIVPage(hashMap, optString, optString3);
                                                    return;
                                                }
                                            }
                                        }
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        NQRView.this.a(R.string.auth_sdk_message_10010_message);
                        NQRView.this.i.onFailure(1001, "");
                    }

                    @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
                    public void onSystemError(String str, RpcResponse rpcResponse) {
                        NQRView.this.a(R.string.auth_sdk_message_10010_message);
                        NQRView.this.i.onFailure(1002, "");
                    }
                });
            }
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: private */
    public void a(final String str, String str2, final NQrCodeLoginCallback nQrCodeLoginCallback) {
        new LoginByQrCodeTask(new a() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass6 */

            @Override // com.ali.auth.third.ui.context.a
            public Activity a() {
                return null;
            }

            @Override // com.ali.auth.third.ui.context.a
            public void a(int i, String str) {
                if (i == 13060) {
                    NQRView.this.a();
                    NQRView.this.a(str);
                    return;
                }
                nQrCodeLoginCallback.onFailure(i, str);
            }

            @Override // com.ali.auth.third.ui.context.a
            public void a(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (System.currentTimeMillis() - NQRView.a > 900000) {
                        NQRView.this.a();
                        nQrCodeLoginCallback.onQrImageStatusChanged(str, 10022);
                        return;
                    }
                    nQrCodeLoginCallback.onQrImageStatusChanged(str, jSONObject.getInt("code"));
                    if (jSONObject.getInt("code") == 6) {
                        NQRView.this.a();
                    }
                } catch (JSONException e) {
                    Log.e("NQRView", "check qrcode status error ", e);
                }
            }

            @Override // com.ali.auth.third.ui.context.a
            public void b(String str) {
                nQrCodeLoginCallback.onFailure(1, str);
            }
        }, true).execute(new String[]{str2});
    }

    /* access modifiers changed from: private */
    public void b() {
        this.k.setVisibility(0);
        this.j.setVisibility(8);
        this.j.removeAllViews();
    }

    /* access modifiers changed from: private */
    public void c() {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass10 */

            @Override // java.lang.Runnable
            public void run() {
                NQRView.this.b();
                NQRView.this.b.setVisibility(0);
                NQRView.this.c.setVisibility(8);
                NQRView.this.e.setVisibility(8);
                NQRView.this.d.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    public void d() {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                NQRView.this.b.setVisibility(8);
                NQRView.this.c.setVisibility(8);
                NQRView.this.d.setVisibility(8);
                NQRView.this.e.setVisibility(0);
            }
        });
    }

    /* access modifiers changed from: private */
    public void e() {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                NQRView.this.b();
                NQRView.this.b.setVisibility(8);
                NQRView.this.c.setVisibility(8);
                NQRView.this.e.setVisibility(8);
                NQRView.this.d.setVisibility(0);
            }
        });
    }

    protected int getLayoutId() {
        return R.layout.ali_auth_nqrview;
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
        if (this.f != null) {
            this.f = null;
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.k = (LinearLayout) findViewById(R.id.ali_auth_nqrview);
        this.f = (ImageView) findViewById(R.id.ali_auth_nqrview_qr_image);
        this.h = (Button) findViewById(R.id.ali_auth_nqrview_error_refresh);
        this.b = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_qr);
        this.c = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_errortips);
        this.e = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_scanedtips);
        this.d = (LinearLayout) findViewById(R.id.ali_auth_nqrview_lay_successedtips);
        this.g = (TextView) findViewById(R.id.ali_auth_nqrview_error_main);
        this.h.setOnClickListener(new View.OnClickListener() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass7 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NQRView.this.c.setVisibility(8);
                NQRView nQRView = NQRView.this;
                nQRView.a(nQRView.getWidth(), NQRView.this.getHeight(), NQRView.this.m);
            }
        });
        this.j = (RelativeLayout) findViewById(R.id.ali_auth_verify_rl);
    }

    public void setNQrCodeLoginCallback(NQrCodeLoginCallback nQrCodeLoginCallback) {
        if (nQrCodeLoginCallback != null) {
            this.m = nQrCodeLoginCallback;
        }
    }

    public void showIVPage(Map map, final String str, final String str2) {
        this.k.setVisibility(8);
        this.j.setVisibility(0);
        SMSVerificationView sMSVerificationView = a.C0008a.b != null ? a.C0008a.b : new SMSVerificationView(getContext());
        this.j.addView(sMSVerificationView, new FrameLayout.LayoutParams(-1, -1));
        invalidate();
        sMSVerificationView.init(map);
        sMSVerificationView.setResultCallback(new ResultCallback<String>() {
            /* class com.ali.auth.third.ui.NQRView.AnonymousClass9 */

            /* renamed from: a */
            public void onSuccess(String str) {
                LoginByIVTokenTask loginByIVTokenTask = new LoginByIVTokenTask(null, new LoginCallback() {
                    /* class com.ali.auth.third.ui.NQRView.AnonymousClass9.AnonymousClass1 */

                    @Override // com.ali.auth.third.core.callback.FailureCallback
                    public void onFailure(int i, String str) {
                        NQRView.this.a(R.string.auth_sdk_message_10010_message);
                        NQRView.this.i.onFailure(1003, "");
                    }

                    @Override // com.ali.auth.third.core.callback.LoginCallback
                    public void onSuccess(Session session) {
                        NQRView.this.e();
                        NQRView.this.i.onSuccess(session);
                    }
                });
                Executor executor = ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor;
                loginByIVTokenTask.executeOnExecutor(executor, new String[]{str2, str, "havana_iv_token=" + str});
            }

            @Override // com.ali.auth.third.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                NQRView.this.a(R.string.auth_sdk_message_10010_message);
                NQRView.this.i.onFailure(i, str);
            }
        });
    }

    public void showQR(LoginCallback loginCallback) {
        this.i = loginCallback;
        a(getWidth(), getHeight(), this.m);
    }

    public void showQR(Map<String, String> map, LoginCallback loginCallback) {
        this.i = loginCallback;
        a(Integer.parseInt(map.get("width")), Integer.parseInt(map.get("height")), this.m);
    }
}
