package com.taobao.tao.remotebusiness;

import com.taobao.tao.remotebusiness.a.c;
import com.taobao.tao.remotebusiness.b.e;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.a.c.a;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.init.IMtopInitTask;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: RequestPool */
public class b {
    private Map<String, List<MtopBusiness>> a = new HashMap();
    private Lock b = new ReentrantLock();

    public static String b(String str) {
        return str == null ? "" : str;
    }

    protected b() {
    }

    public final void a(Mtop mtop, String str, MtopBusiness mtopBusiness) {
        this.b.lock();
        try {
            String b2 = b(mtop, str);
            List<MtopBusiness> list = this.a.get(b2);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(mtopBusiness);
            this.a.put(b2, list);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(b2);
                sb.append(" [addToRequestPool] add mtopBuilder to RequestPool.");
                TBSdkLog.e("mtopsdk.RequestPool", mtopBusiness.getMtopContext$6e9e401a() != null ? mtopBusiness.getMtopContext$6e9e401a().h : null, sb.toString());
            }
        } finally {
            this.b.unlock();
        }
    }

    public final void a(Mtop mtop, String str) {
        this.b.lock();
        try {
            String b2 = b(mtop, str);
            List<MtopBusiness> remove = this.a.remove(b2);
            if (remove != null) {
                if (!remove.isEmpty()) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        StringBuilder sb = new StringBuilder(64);
                        sb.append(b2);
                        sb.append(" [retryAllRequest] retry all request,current size=");
                        sb.append(remove.size());
                        TBSdkLog.e("mtopsdk.RequestPool", sb.toString());
                    }
                    for (MtopBusiness mtopBusiness : remove) {
                        if (!mtopBusiness.isTaskCanceled()) {
                            mtopBusiness.a();
                        }
                    }
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    public final void b(Mtop mtop, String str, MtopBusiness mtopBusiness) {
        this.b.lock();
        try {
            String b2 = b(mtop, str);
            List<MtopBusiness> list = this.a.get(b2);
            if (list != null) {
                if (!list.isEmpty()) {
                    StringBuilder sb = new StringBuilder(64);
                    sb.append(b2);
                    sb.append(" [retrySingleRequest] retry single request.");
                    TBSdkLog.e("mtopsdk.RequestPool", mtopBusiness.getMtopContext$6e9e401a() != null ? mtopBusiness.getMtopContext$6e9e401a().h : null, sb.toString());
                    if (!mtopBusiness.isTaskCanceled() && list.contains(mtopBusiness)) {
                        mtopBusiness.a();
                        list.remove(mtopBusiness);
                    }
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    public final void c(Mtop mtop, String str, MtopBusiness mtopBusiness) {
        this.b.lock();
        try {
            String b2 = b(mtop, str);
            List<MtopBusiness> list = this.a.get(b2);
            if (list != null) {
                if (!list.isEmpty()) {
                    StringBuilder sb = new StringBuilder(64);
                    sb.append(b2);
                    sb.append(" [removeRequest] remove single request.");
                    TBSdkLog.e("mtopsdk.RequestPool", mtopBusiness.getMtopContext$6e9e401a() != null ? mtopBusiness.getMtopContext$6e9e401a().h : null, sb.toString());
                    list.remove(mtopBusiness);
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    public final void a(Mtop mtop, String str, String str2, String str3) {
        MtopResponse mtopResponse;
        this.b.lock();
        try {
            String b2 = b(mtop, str);
            List<MtopBusiness> remove = this.a.remove(b2);
            if (remove != null) {
                if (!remove.isEmpty()) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        StringBuilder sb = new StringBuilder(64);
                        sb.append(b2);
                        sb.append(" [failAllRequest]fail all request,current size=");
                        sb.append(remove.size());
                        TBSdkLog.e("mtopsdk.RequestPool", sb.toString());
                    }
                    for (MtopBusiness mtopBusiness : remove) {
                        if (mtopBusiness.request != null) {
                            mtopResponse = new MtopResponse(mtopBusiness.request.getApiName(), mtopBusiness.request.getVersion(), str2, str3);
                        } else {
                            mtopResponse = new MtopResponse(str2, str3);
                        }
                        e mtopContext$6e9e401a = mtopBusiness.getMtopContext$6e9e401a();
                        if (mtopContext$6e9e401a == null) {
                            mtopContext$6e9e401a = mtopBusiness.createMtopContext$643c68d3(mtopBusiness.listener);
                        }
                        mtopContext$6e9e401a.c = mtopResponse;
                        try {
                            a.a.a(mtopContext$6e9e401a);
                        } catch (Exception e) {
                            TBSdkLog.e("mtopsdk.RequestPool", "[failAllRequest] do ErrorCode Mapping error.apiKey=" + mtopResponse.getFullKey(), e);
                        }
                        c a2 = com.taobao.tao.remotebusiness.a.a.a(null, null, mtopBusiness);
                        a2.e = mtopResponse;
                        com.taobao.tao.remotebusiness.a.a.a().obtainMessage(3, a2).sendToTarget();
                    }
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    private static String b(Mtop mtop, String str) {
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return StringUtils.concatStr(mtop.getInstanceId(), str);
    }

    public static String a(Map<String, List<String>> map, String str) {
        List<String> list;
        if (map != null && !map.isEmpty() && !StringUtils.isBlank(str)) {
            Iterator<Map.Entry<String, List<String>>> it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, List<String>> next = it2.next();
                if (str.equalsIgnoreCase(next.getKey())) {
                    list = next.getValue();
                    break;
                }
            }
            if (list != null || list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        list = null;
        if (list != null) {
        }
        return null;
    }

    public static Map<String, List<String>> a(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return hashMap;
    }

    public static IMtopInitTask a(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 2432586:
                if (str.equals("OPEN")) {
                    c = 0;
                    break;
                }
                break;
            case 69817910:
                if (str.equals("INNER")) {
                    c = 1;
                    break;
                }
                break;
            case 408508623:
                if (str.equals("PRODUCT")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return d("mtopsdk.mtop.global.init.OpenMtopInitTask");
            case 1:
                return d("mtopsdk.mtop.global.init.InnerMtopInitTask");
            case 2:
                return d("mtopsdk.mtop.global.init.ProductMtopInitTask");
            default:
                return d("mtopsdk.mtop.global.init.InnerMtopInitTask");
        }
    }

    private static IMtopInitTask d(String str) {
        try {
            Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return (IMtopInitTask) declaredConstructor.newInstance(new Object[0]);
        } catch (Throwable unused) {
            TBSdkLog.e("mtopsdk.MtopInitTaskFactory", "reflect IMtopInitTask instance error.clazzName=" + str);
            return null;
        }
    }

    public static URL a(String str, Map<String, String> map) {
        if (StringUtils.isBlank(str)) {
            TBSdkLog.e("mtopsdk.NetworkConverterUtils", "[initUrl]baseUrl is blank,initUrl error");
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(str);
            if (map != null) {
                String b2 = b(map, "utf-8");
                if (StringUtils.isNotBlank(b2) && !str.contains("?")) {
                    sb.append("?");
                    sb.append(b2);
                }
            }
            return new URL(sb.toString());
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.NetworkConverterUtils", "[initUrl] build fullUrl error", e);
            return null;
        }
    }

    public static String b(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            str = "utf-8";
        }
        StringBuilder sb = new StringBuilder(64);
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, String> next = it2.next();
            try {
                String encode = next.getKey() != null ? URLEncoder.encode(next.getKey(), str) : null;
                String encode2 = next.getValue() != null ? URLEncoder.encode(next.getValue(), str) : null;
                sb.append(encode);
                sb.append("=");
                sb.append((Object) encode2);
                if (it2.hasNext()) {
                    sb.append("&");
                }
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.NetworkConverterUtils", "[createParamQueryStr]getQueryStr error ---" + th.toString());
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("utf-8"));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                StringBuilder sb2 = new StringBuilder(Integer.toHexString(b2 & 255));
                while (sb2.length() < 2) {
                    sb2.insert(0, "0");
                }
                sb.append((CharSequence) sb2);
            }
            return sb.toString();
        } catch (Exception e) {
            TBSdkLog.e("mtopsdk.SecurityUtils", "[getMd5] compute md5 value failed for source str=" + str, e);
            return null;
        }
    }
}
