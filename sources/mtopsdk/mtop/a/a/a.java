package mtopsdk.mtop.a.a;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.b.e;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.security.ISign;
import mtopsdk.xstate.XState;

/* compiled from: ProtocolParamBuilder */
public class a {
    public Map<String, String> a(e eVar) {
        long currentTimeMillis = System.currentTimeMillis();
        String instanceId = eVar.a.getInstanceId();
        MtopConfig mtopConfig = eVar.a.getMtopConfig();
        if (mtopConfig.sign == null) {
            String str = eVar.h;
            TBSdkLog.e("mtopsdk.OpenProtocolParamBuilderImpl", str, instanceId + " [buildParams] ISign in mtopConfig of mtopInstance  is null");
            return null;
        }
        MtopRequest mtopRequest = eVar.b;
        MtopNetworkProp mtopNetworkProp = eVar.d;
        Mtop mtop = eVar.a;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api", mtopRequest.getApiName().toLowerCase(Locale.US));
        hashMap.put("v", mtopRequest.getVersion().toLowerCase(Locale.US));
        hashMap.put("data", mtopRequest.getData());
        if (StringUtils.isBlank(mtopNetworkProp.reqAppKey)) {
            mtopNetworkProp.reqAppKey = mtopConfig.appKey;
            mtopNetworkProp.authCode = mtopConfig.authCode;
        }
        String str2 = mtopNetworkProp.reqAppKey;
        String str3 = mtopNetworkProp.authCode;
        hashMap.put("appKey", str2);
        hashMap.put("accessToken", XState.getValue(StringUtils.concatStr(mtop.getInstanceId(), mtopNetworkProp.openAppKey), "accessToken"));
        hashMap.put("t", String.valueOf(SDKUtils.getCorrectionTime()));
        hashMap.put("utdid", eVar.a.getUtdid());
        hashMap.put("pv", "1.3");
        hashMap.put("x-features", String.valueOf(MtopFeatureManager.getMtopTotalFeatures(mtop)));
        hashMap.put("ttid", mtopNetworkProp.ttid);
        hashMap.put("sid", mtop.getMultiAccountSid(mtopNetworkProp.userInfo));
        if (!TextUtils.isEmpty(mtopNetworkProp.openBiz)) {
            hashMap.put("open-biz", mtopNetworkProp.openBiz);
            if (!TextUtils.isEmpty(mtopNetworkProp.miniAppKey)) {
                hashMap.put("mini-appkey", mtopNetworkProp.miniAppKey);
            }
            if (!TextUtils.isEmpty(mtopNetworkProp.reqAppKey)) {
                hashMap.put("req-appkey", mtopNetworkProp.requestSourceAppKey);
            }
            if (!TextUtils.isEmpty(mtopNetworkProp.openBizData)) {
                hashMap.put("open-biz-data", mtopNetworkProp.openBizData);
            }
            mtopNetworkProp.accessToken = XState.getValue(StringUtils.concatStr(mtop.getInstanceId(), mtopNetworkProp.miniAppKey), "accessToken");
            if (!TextUtils.isEmpty(mtopNetworkProp.accessToken)) {
                hashMap.put("accessToken", mtopNetworkProp.accessToken);
            }
        }
        ISign iSign = mtopConfig.sign;
        HashMap<String, String> hashMap2 = new HashMap<>();
        String str4 = "";
        hashMap2.put("pageId", TextUtils.isEmpty(mtopNetworkProp.pageUrl) ? str4 : mtopNetworkProp.pageUrl);
        if (!TextUtils.isEmpty(mtopNetworkProp.pageName)) {
            str4 = mtopNetworkProp.pageName;
        }
        hashMap2.put("pageName", str4);
        boolean z = mtopNetworkProp.wuaFlag >= 0 || mtopNetworkProp.wuaRetry;
        long currentTimeMillis2 = eVar.g.currentTimeMillis();
        HashMap<String, String> unifiedSign = iSign.getUnifiedSign(hashMap, hashMap2, str2, str3, z);
        eVar.g.computeSignTime = eVar.g.currentTimeMillis() - currentTimeMillis2;
        if (unifiedSign != null) {
            String str5 = unifiedSign.get("x-sign");
            if (StringUtils.isBlank(str5)) {
                String str6 = eVar.h;
                TBSdkLog.e("mtopsdk.OpenProtocolParamBuilderImpl", str6, "[buildParams]get sign failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str3);
                return hashMap;
            }
            hashMap.put("sign", str5);
            if (z) {
                String str7 = unifiedSign.get("wua");
                hashMap.put("wua", str7);
                if (StringUtils.isBlank(str7)) {
                    String str8 = eVar.h;
                    TBSdkLog.e("mtopsdk.OpenProtocolParamBuilderImpl", str8, "[buildParams]get wua failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str3);
                }
            }
            String str9 = unifiedSign.get("x-mini-wua");
            hashMap.put("x-mini-wua", str9);
            if (StringUtils.isBlank(str9)) {
                String str10 = eVar.h;
                TBSdkLog.e("mtopsdk.OpenProtocolParamBuilderImpl", str10, "[buildParams]get mini wua failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str3);
            }
            String str11 = unifiedSign.get("x-umt");
            hashMap.put("umt", str11);
            if (StringUtils.isBlank(str11)) {
                String str12 = eVar.h;
                TBSdkLog.e("mtopsdk.OpenProtocolParamBuilderImpl", str12, "[buildParams]get umt failed empty output , apiKey=" + mtopRequest.getKey() + ",authCode=" + str3);
            }
            String str13 = unifiedSign.get("x-sgext");
            if (StringUtils.isNotBlank(str13)) {
                hashMap.put("x-sgext", str13);
            }
        }
        String str14 = eVar.a.getMtopConfig().appVersion;
        if (StringUtils.isNotBlank(str14)) {
            hashMap.put("x-app-ver", str14);
        }
        String value = XState.getValue("ua");
        if (value != null) {
            hashMap.put("user-agent", value);
        }
        String value2 = XState.getValue("lat");
        if (StringUtils.isNotBlank(value2)) {
            String value3 = XState.getValue("lng");
            if (StringUtils.isNotBlank(value3)) {
                hashMap.put("lat", value2);
                hashMap.put("lng", value3);
            }
        }
        eVar.g.buildParamsTime = System.currentTimeMillis() - currentTimeMillis;
        return hashMap;
    }
}
