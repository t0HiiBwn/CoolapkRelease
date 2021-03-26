package mtopsdk.mtop.a.b.a;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.b;
import com.taobao.tao.remotebusiness.b.e;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.network.domain.ParcelableRequestBodyImpl;
import mtopsdk.network.domain.Request;

/* compiled from: AbstractNetworkConverter */
public abstract class a implements mtopsdk.mtop.a.b.a {
    protected abstract Map<String, String> a();

    @Override // mtopsdk.mtop.a.b.a
    public final Request a(e eVar) {
        Request request;
        Throwable th;
        URL url;
        byte[] bArr;
        Iterator<Map.Entry<String, String>> it2;
        MtopNetworkProp mtopNetworkProp = eVar.d;
        MtopConfig mtopConfig = eVar.a.getMtopConfig();
        String str = eVar.h;
        Request.Builder builder = new Request.Builder();
        builder.seqNo(str);
        builder.reqContext(mtopNetworkProp.reqContext);
        if (!TextUtils.isEmpty(mtopNetworkProp.bizIdStr)) {
            builder.bizId(mtopNetworkProp.bizIdStr);
        } else {
            builder.bizId(mtopNetworkProp.bizId);
        }
        builder.connectTimeout(mtopNetworkProp.connTimeout);
        builder.readTimeout(mtopNetworkProp.socketTimeout);
        builder.retryTimes(mtopNetworkProp.retryTimes);
        builder.appKey(mtopNetworkProp.reqAppKey);
        builder.authCode(mtopNetworkProp.authCode);
        EnvModeEnum envModeEnum = mtopConfig.envMode;
        if (envModeEnum != null) {
            int i = b.a[envModeEnum.ordinal()];
            if (i == 1) {
                builder.env(0);
            } else if (i == 2) {
                builder.env(1);
            } else if (i == 3 || i == 4) {
                builder.env(2);
            }
        }
        MethodEnum methodEnum = mtopNetworkProp.method;
        Map<String, String> map = eVar.i;
        Map<String, String> map2 = mtopNetworkProp.requestHeaders;
        Map<String, String> map3 = mtopConfig.mtopGlobalHeaders;
        if (!map3.isEmpty()) {
            if (map2 != null) {
                for (Map.Entry<String, String> entry : map3.entrySet()) {
                    String key = entry.getKey();
                    if (!map2.containsKey(key)) {
                        map2.put(key, entry.getValue());
                    }
                }
            } else {
                map2 = map3;
            }
        }
        Map<String, String> a = a(map, map2, mtopConfig.enableHeaderUrlEncode);
        try {
            String remove = map.remove("api");
            builder.api(remove);
            String a2 = a(eVar, remove, map.remove("v"));
            Mtop mtop = eVar.a;
            if (SwitchConfig.getInstance().isMtopsdkPropertySwitchOpen()) {
                Iterator<Map.Entry<String, String>> it3 = mtop.getMtopConfig().getMtopProperties().entrySet().iterator();
                while (it3.hasNext()) {
                    Map.Entry<String, String> next = it3.next();
                    try {
                        String key2 = next.getKey();
                        if (!StringUtils.isNotBlank(key2) || !key2.startsWith("mtopsdk.")) {
                            it2 = it3;
                            it3 = it2;
                        } else {
                            it2 = it3;
                            try {
                                map.put(key2.substring(8), next.getValue());
                            } catch (Exception unused) {
                            }
                            it3 = it2;
                        }
                    } catch (Exception unused2) {
                        it2 = it3;
                        TBSdkLog.e("mtopsdk.AbstractNetworkConverter", "[addMtopSdkProperty]get mtopsdk properties error,key=" + next.getKey() + ",value=" + next.getValue());
                        it3 = it2;
                    }
                }
            }
            if (mtopNetworkProp.queryParameterMap != null && !mtopNetworkProp.queryParameterMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : mtopNetworkProp.queryParameterMap.entrySet()) {
                    map.put(entry2.getKey(), entry2.getValue());
                }
            }
            Map<String, String> map4 = mtopConfig.mtopGlobalQuerys;
            if (!map4.isEmpty()) {
                for (Map.Entry<String, String> entry3 : map4.entrySet()) {
                    String key3 = entry3.getKey();
                    if (!map.containsKey(key3)) {
                        map.put(key3, entry3.getValue());
                    }
                }
            }
            a.put("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            if (MethodEnum.POST.getMethod().equals(methodEnum.getMethod())) {
                String b = b.b(map, "utf-8");
                if (b != null) {
                    try {
                        bArr = b.getBytes("utf-8");
                    } catch (Exception unused3) {
                        TBSdkLog.e("mtopsdk.AbstractNetworkConverter", "[createParamPostData]getPostData error");
                    }
                    builder.method(methodEnum.getMethod(), new ParcelableRequestBodyImpl("application/x-www-form-urlencoded;charset=UTF-8", bArr));
                    request = null;
                    url = b.a(a2, (Map<String, String>) null);
                }
                bArr = null;
                builder.method(methodEnum.getMethod(), new ParcelableRequestBodyImpl("application/x-www-form-urlencoded;charset=UTF-8", bArr));
                request = null;
                try {
                    url = b.a(a2, (Map<String, String>) null);
                } catch (Throwable th2) {
                    th = th2;
                    TBSdkLog.e("mtopsdk.AbstractNetworkConverter", str, "[convert]convert Request failed!", th);
                    return request;
                }
            } else {
                if (!(eVar.e instanceof MtopCallback.MtopCacheListener) && !mtopNetworkProp.useCache) {
                    a.put("cache-control", "no-cache");
                }
                url = b.a(a2, map);
            }
            if (url != null) {
                eVar.g.domain = url.getHost();
                builder.url(url.toString());
            }
            builder.headers(a);
            return builder.build();
        } catch (Throwable th3) {
            th = th3;
            request = null;
            TBSdkLog.e("mtopsdk.AbstractNetworkConverter", str, "[convert]convert Request failed!", th);
            return request;
        }
    }

    private Map<String, String> a(Map<String, String> map, Map<String, String> map2, boolean z) {
        Map<String, String> a = a();
        if (a == null) {
            TBSdkLog.e("mtopsdk.AbstractNetworkConverter", "[buildRequestHeaders]headerConversionMap is null,buildRequestHeaders error.");
            return map2;
        }
        HashMap hashMap = new HashMap(64);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (z) {
                    if (value != null) {
                        try {
                            value = URLEncoder.encode(value, "utf-8");
                        } catch (Exception unused) {
                            TBSdkLog.e("mtopsdk.AbstractNetworkConverter", "[buildRequestHeaders]urlEncode " + key + "=" + value + "error");
                        }
                    } else {
                        value = null;
                    }
                }
                hashMap.put(key, value);
            }
        }
        for (Map.Entry<String, String> entry2 : a.entrySet()) {
            String key2 = entry2.getKey();
            String remove = map.remove(entry2.getValue());
            if (remove != null) {
                try {
                    hashMap.put(key2, URLEncoder.encode(remove, "utf-8"));
                } catch (Exception unused2) {
                    TBSdkLog.e("mtopsdk.AbstractNetworkConverter", "[buildRequestHeaders]urlEncode " + key2 + "=" + remove + "error");
                }
            }
        }
        String remove2 = map.remove("lng");
        String remove3 = map.remove("lat");
        if (!(remove2 == null || remove3 == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append(remove2);
            sb.append(",");
            sb.append(remove3);
            try {
                hashMap.put("x-location", URLEncoder.encode(sb.toString(), "utf-8"));
            } catch (Exception unused3) {
                TBSdkLog.e("mtopsdk.AbstractNetworkConverter", "[buildRequestHeaders]urlEncode x-location=" + sb.toString() + "error");
            }
        }
        return hashMap;
    }

    private String a(e eVar, String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder(64);
        try {
            MtopConfig mtopConfig = eVar.a.getMtopConfig();
            MtopNetworkProp mtopNetworkProp = eVar.d;
            mtopNetworkProp.envMode = mtopConfig.envMode;
            sb.append(mtopNetworkProp.protocol.getProtocol());
            MtopNetworkProp mtopNetworkProp2 = eVar.d;
            if (StringUtils.isNotBlank(mtopNetworkProp2.customDomain)) {
                str3 = mtopNetworkProp2.customDomain;
            } else {
                int i = b.a[mtopNetworkProp2.envMode.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (StringUtils.isNotBlank(mtopNetworkProp2.customDailyDomain)) {
                                str3 = mtopNetworkProp2.customDailyDomain;
                            }
                        }
                    } else if (StringUtils.isNotBlank(mtopNetworkProp2.customPreDomain)) {
                        str3 = mtopNetworkProp2.customPreDomain;
                    }
                } else if (StringUtils.isNotBlank(mtopNetworkProp2.customOnlineDomain)) {
                    str3 = mtopNetworkProp2.customOnlineDomain;
                }
                str3 = null;
            }
            if (StringUtils.isNotBlank(str3)) {
                sb.append(str3);
            } else {
                sb.append(mtopConfig.mtopDomain.getDomain(eVar.d.envMode));
            }
            sb.append("/");
            sb.append(mtopConfig.entrance.getEntrance());
            sb.append("/");
            sb.append(str);
            sb.append("/");
            sb.append(str2);
            sb.append("/");
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.AbstractNetworkConverter", eVar.h, "[buildBaseUrl] build mtop baseUrl error.", e);
        }
        return sb.toString();
    }
}
