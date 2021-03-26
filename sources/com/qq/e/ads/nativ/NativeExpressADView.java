package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeExpressADView extends FrameLayout implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    private NEADVI a;
    private boolean b = false;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private NativeExpressMediaListener e;
    public Map<String, String> ext = new HashMap();
    private AdData f;
    private volatile boolean g = false;
    private ViewBindStatusListener h;
    private DownloadConfirmListener i;

    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(final NEADI neadi, final Context context, final ADSize aDSize, final String str, final String str2, final JSONObject jSONObject, final HashMap<String, Object> hashMap) {
        super(context);
        this.f = a(hashMap);
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
            /* class com.qq.e.ads.nativ.NativeExpressADView.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.qq.e.ads.nativ.NativeExpressADView.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        NativeExpressADView.this.a = pOFactory.getNativeExpressADView(neadi, context, NativeExpressADView.this, aDSize, str, str2, jSONObject, hashMap);
                                        NativeExpressADView.this.b = true;
                                        if (NativeExpressADView.this.e != null) {
                                            NativeExpressADView.this.setMediaListener(NativeExpressADView.this.e);
                                        }
                                        if (NativeExpressADView.this.c) {
                                            NativeExpressADView.this.preloadVideo();
                                        }
                                        if (NativeExpressADView.this.d) {
                                            NativeExpressADView.this.render();
                                        }
                                        if (NativeExpressADView.this.g) {
                                            NativeExpressADView.this.negativeFeedback();
                                        }
                                    }
                                } catch (Throwable th) {
                                    NativeExpressADView.this.b = true;
                                    throw th;
                                }
                                NativeExpressADView.this.b = true;
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init Native Express AD View plugin", th);
                    }
                } else {
                    GDTLogger.e("Fail to init ADManager");
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c A[RETURN] */
    private static AdData a(HashMap<String, Object> hashMap) {
        Object obj;
        JSONObject jSONObject;
        if (hashMap != null) {
            try {
                jSONObject = (JSONObject) hashMap.get("adinfo");
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            obj = jSONObject.get("adinfo");
            if (!(obj instanceof AdData)) {
                return (AdData) obj;
            }
            return null;
        }
        obj = null;
        if (!(obj instanceof AdData)) {
        }
    }

    public void destroy() {
        NEADVI neadvi = this.a;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NEADVI neadvi = this.a;
        if (neadvi != null) {
            return neadvi.getApkInfoUrl();
        }
        return null;
    }

    public AdData getBoundData() {
        return this.f;
    }

    public void negativeFeedback() {
        if (!this.b) {
            this.g = true;
            return;
        }
        NEADVI neadvi = this.a;
        if (neadvi != null) {
            neadvi.reportAdNegative();
            this.g = false;
            return;
        }
        GDTLogger.e("Native Express negativeFeedback  core is null");
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.i;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ViewBindStatusListener viewBindStatusListener = this.h;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    public void preloadVideo() {
        if (!this.b) {
            this.c = true;
            return;
        }
        NEADVI neadvi = this.a;
        if (neadvi != null) {
            neadvi.preloadVideo();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void render() {
        if (!this.b) {
            this.d = true;
            return;
        }
        NEADVI neadvi = this.a;
        if (neadvi != null) {
            neadvi.render();
        } else {
            GDTLogger.e("Native Express AD View Init Error");
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.a;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.i = downloadConfirmListener;
        NEADVI neadvi = this.a;
        if (neadvi != null) {
            neadvi.setDownloadConfirmListener(this);
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        this.e = nativeExpressMediaListener;
        NEADVI neadvi = this.a;
        if (neadvi != null && nativeExpressMediaListener != null) {
            neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        this.h = viewBindStatusListener;
    }
}
