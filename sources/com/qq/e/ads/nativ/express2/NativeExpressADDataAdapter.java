package com.qq.e.ads.nativ.express2;

import android.app.Activity;
import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;

public class NativeExpressADDataAdapter implements NativeExpressADData2, DownloadConfirmListener {
    private NativeExpressADData2 a;
    private MediaEventListener b;
    private AdEventListener c;
    private DownloadConfirmListener d;

    public NativeExpressADDataAdapter(NativeExpressADData2 nativeExpressADData2) {
        this.a = nativeExpressADData2;
        if (nativeExpressADData2 instanceof ADEventListener) {
            ((ADEventListener) nativeExpressADData2).setAdListener(new ADListener() {
                /* class com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter.AnonymousClass1 */

                @Override // com.qq.e.comm.adevent.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    if (aDEvent.getType() < 201) {
                        NativeExpressADDataAdapter.a(NativeExpressADDataAdapter.this, aDEvent);
                    } else {
                        NativeExpressADDataAdapter.b(NativeExpressADDataAdapter.this, aDEvent);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.c != null) {
            switch (aDEvent.getType()) {
                case 101:
                    nativeExpressADDataAdapter.c.onClick();
                    return;
                case 102:
                    nativeExpressADDataAdapter.c.onExposed();
                    return;
                case 103:
                    nativeExpressADDataAdapter.c.onRenderSuccess();
                    return;
                case 104:
                    nativeExpressADDataAdapter.c.onRenderFail();
                    return;
                case 105:
                    nativeExpressADDataAdapter.c.onAdClosed();
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void b(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.b != null) {
            switch (aDEvent.getType()) {
                case 201:
                    nativeExpressADDataAdapter.b.onVideoCache();
                    return;
                case 202:
                    nativeExpressADDataAdapter.b.onVideoStart();
                    return;
                case 203:
                    nativeExpressADDataAdapter.b.onVideoResume();
                    return;
                case 204:
                case 205:
                    nativeExpressADDataAdapter.b.onVideoPause();
                    return;
                case 206:
                    nativeExpressADDataAdapter.b.onVideoComplete();
                    return;
                case 207:
                    nativeExpressADDataAdapter.b.onVideoError();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        this.a.destroy();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        return this.a.getAdView();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NativeExpressADData2 nativeExpressADData2 = this.a;
        if (nativeExpressADData2 != null) {
            return nativeExpressADData2.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        return this.a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        return this.a.isVideoAd();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        this.a.render();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
        this.c = adEventListener;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.d = downloadConfirmListener;
        NativeExpressADData2 nativeExpressADData2 = this.a;
        if (nativeExpressADData2 != null) {
            nativeExpressADData2.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
        this.b = mediaEventListener;
    }
}
