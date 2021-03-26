package com.qq.e.comm.pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import java.util.HashMap;
import org.json.JSONObject;

interface InnerPOFactory {
    void config(int i, String str);

    SVSD getAPKDownloadServiceDelegate(Service service);

    ACTD getActivityDelegate(String str, Activity activity);

    RVADI2 getExpressRewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener);

    DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    NUADI getNativeAdManagerDelegate(Context context, String str, String str2, ADListener aDListener);

    NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, ADListener aDListener);

    NEIADI getNativeExpressADDelegate2(Context context, String str, String str2, ADListener aDListener);

    NEADVI getNativeExpressADView(NEADI neadi, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, Object> hashMap);

    NSPVI getNativeSplashAdView(Context context, String str, String str2);

    RVADI getRewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener);

    UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener);

    UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener);
}
