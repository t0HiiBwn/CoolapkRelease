package com.alibaba.alibclinkpartner.smartlink;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.b.a.d;
import com.alibaba.alibclinkpartner.smartlink.b.a.e;
import com.alibaba.alibclinkpartner.smartlink.b.a.h;
import com.alibaba.alibclinkpartner.smartlink.b.a.j;
import com.alibaba.alibclinkpartner.smartlink.b.a.k;
import com.alibaba.alibclinkpartner.smartlink.b.a.l;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkData;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkDetail;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkSwitch;
import com.alibaba.alibclinkpartner.smartlink.manager.ALSLAppCheckManager;
import com.alibaba.alibclinkpartner.smartlink.manager.a;
import com.alibaba.alibclinkpartner.smartlink.manager.b;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLSystemUtil;
import com.alibaba.alibclinkpartner.smartlink.util.c;
import com.alibaba.alibclinkpartner.smartlink.util.f;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import com.ta.utdid2.device.UTDevice;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ALSLSmartLinkSDK {
    private static String formatParams(ALSLUri aLSLUri, String str) {
        HashMap hashMap = new HashMap();
        StringBuffer stringBuffer = new StringBuffer();
        hashMap.put("appkey", ALSLContext.instance().appkey);
        hashMap.put("appName", ALSLSystemUtil.getAppName(ALSLContext.instance().mContext));
        hashMap.put("packageName", aLSLUri.packageName);
        hashMap.put("v", ALSLContext.instance().ALSLSDKVersion);
        hashMap.put("source", "alsl");
        hashMap.put("action", "ali.open.nav");
        hashMap.put("module", aLSLUri.module);
        hashMap.put("bc_fl_src", aLSLUri.bcFlSrc);
        hashMap.put("bootImage", "0");
        hashMap.put("sdkName", "linkPartner");
        if (aLSLUri.extraParam != null && aLSLUri.extraParam.size() > 0) {
            String str2 = (String) aLSLUri.extraParam.get("tag");
            String str3 = (String) aLSLUri.extraParam.get("utdid");
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("tag", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("utdid", str3);
            } else {
                hashMap.put("utdid", UTDevice.getUtdid(ALSLContext.instance().mContext));
            }
            aLSLUri.extraParam.remove("tag");
            aLSLUri.extraParam.remove("utdid");
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                try {
                    String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
                    String encode2 = URLEncoder.encode((String) entry.getValue(), "UTF-8");
                    stringBuffer.append(encode);
                    stringBuffer.append("=");
                    stringBuffer.append(encode2);
                    stringBuffer.append("&");
                } catch (Throwable th) {
                    ALSLLogUtil.e("ALSLSmartLinkSDK", "formatParams", "url encode error t=" + th.toString());
                }
            }
        }
        if (aLSLUri.extraParam.size() > 0) {
            stringBuffer.append("params=");
            stringBuffer.append(c.a(aLSLUri.extraParam));
        }
        if (stringBuffer.toString().endsWith("&")) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (str.contains("?")) {
            return str + "&" + stringBuffer.toString();
        }
        return str + "?" + stringBuffer.toString();
    }

    private static void getBackUrlPackage() {
        try {
            if (System.currentTimeMillis() - ((Long) f.b("last_safe_config_request_time", 0L)).longValue() < ((Long) f.b("safe_package_validate_time", 0L)).longValue()) {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "本地数据没过期，不拉数据");
                return;
            }
            ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "本地数据过期，开始拉取数据");
            a.a(new b());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getH5DegradeUrl(ALSLUri aLSLUri) {
        String str = (aLSLUri.degradeH5Url == null || aLSLUri.degradeH5Url.length() <= 0) ? aLSLUri.url : aLSLUri.degradeH5Url;
        if (str.contains("?")) {
            return str + "&source=alsl";
        }
        return str + "?source=alsl";
    }

    private static String getRegexUrl(ALSLUri aLSLUri, MatrixAppInfoDetail matrixAppInfoDetail) {
        String str;
        String str2 = matrixAppInfoDetail.uri;
        Matcher matcher = Pattern.compile("\\$\\{(.*?)\\}").matcher(matrixAppInfoDetail.uri);
        while (matcher.find()) {
            String group2 = matcher.group(0);
            String str3 = "${url}";
            String str4 = "";
            if (TextUtils.equals(str3, group2) || TextUtils.equals("${#url}", group2)) {
                if (!TextUtils.isEmpty(aLSLUri.url)) {
                    str = aLSLUri.url;
                }
                str2 = str2.replace(str3, str4);
            } else {
                str3 = "${backUrl}";
                if (TextUtils.equals(str3, group2) || TextUtils.equals("${#backUrl}", group2)) {
                    if (!TextUtils.isEmpty(aLSLUri.backUrl)) {
                        str = aLSLUri.backUrl;
                    }
                    str2 = str2.replace(str3, str4);
                } else if (group2.length() >= 3) {
                    String substring = group2.substring(2, group2.length() - 1);
                    if (!TextUtils.isEmpty(substring)) {
                        if (substring.contains("#")) {
                            substring = substring.substring(1, substring.length() - 1);
                        }
                        if (!TextUtils.isEmpty(substring)) {
                            if (aLSLUri.extraParam != null) {
                                String str5 = (String) aLSLUri.extraParam.get(substring);
                                if (!TextUtils.isEmpty(str5)) {
                                    str4 = str5;
                                }
                                str2 = str2.replace(group2, g.d(str4));
                                aLSLUri.extraParam.remove(substring);
                            }
                        }
                    }
                    str2 = str2.replace(group2, str4);
                }
            }
            str2 = str2.replace(str3, g.d(str));
        }
        return str2;
    }

    public static void getSmartLinkSwitch() {
        try {
            if (System.currentTimeMillis() - ((Long) f.b("smart_link_switch_time", 0L)).longValue() < 300000) {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "距离上次请求不到五分钟，不拉数据");
                return;
            }
            ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "距离上次超过五分钟，开始拉取数据");
            a.a(new c());
        } catch (Exception e) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "getSmartLinkSwitch", "异常：" + e.getMessage());
        }
    }

    private static void go2DegradeWithUrl(ALSLUri aLSLUri, String str, boolean z, ALPSmartLinkCallback aLPSmartLinkCallback, int i) {
        String str2;
        String h5DegradeUrl;
        if (aLSLUri.degradeType == ALSLUri.ALSLdegradeType.NONE) {
            str2 = aLSLUri.target;
            h5DegradeUrl = "";
        } else if (aLSLUri.degradeType != ALSLUri.ALSLdegradeType.H5 && aLSLUri.degradeType == ALSLUri.ALSLdegradeType.Download) {
            aLPSmartLinkCallback.getLinkUrl(false, aLSLUri.target, str, i);
            j jVar = new j();
            jVar.d = aLSLUri.degradeType;
            jVar.a = aLSLUri.target;
            jVar.c = aLSLUri.url;
            jVar.e = z;
            jVar.b = getH5DegradeUrl(aLSLUri);
            b.a(jVar);
        } else {
            str2 = aLSLUri.target;
            h5DegradeUrl = getH5DegradeUrl(aLSLUri);
        }
        aLPSmartLinkCallback.getLinkUrl(false, str2, h5DegradeUrl, i);
        j jVar = new j();
        jVar.d = aLSLUri.degradeType;
        jVar.a = aLSLUri.target;
        jVar.c = aLSLUri.url;
        jVar.e = z;
        jVar.b = getH5DegradeUrl(aLSLUri);
        b.a(jVar);
    }

    public static int init(Application application, String str) {
        if (application == null) {
            ALSLLogUtil.e("ALSLSmartLinkSDK", "init", "application is null");
            return 301;
        } else if (ALSLContext.instance().isInit()) {
            ALSLLogUtil.e("ALSLSmartLinkSDK", "init", "已经初始化成功，无需再次初始化");
            return 201;
        } else {
            ALSLContext.instance().initContext(application, str);
            f.a(application, "smart_link_sp");
            b.a(new e());
            ALSLConfigration.getMatrixAppList(application);
            getSmartLinkSwitch();
            if (Build.VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(new a());
            }
            getBackUrlPackage();
            ALSLContext.instance().setInit(true);
            ALSLLogUtil.d("ALSLSmartLinkSDK", "init", "初始化成功");
            return 201;
        }
    }

    private static void isSmartOpen(Context context, ALSLUri aLSLUri, ALPSmartLinkCallback aLPSmartLinkCallback, String str) {
        String str2;
        int abs = Math.abs(UTDevice.getUtdid(context).hashCode()) % 10000;
        SmartLinkSwitch smartLinkSwitch = (SmartLinkSwitch) f.d("smart_link_switch", new SmartLinkSwitch());
        if (smartLinkSwitch != null) {
            boolean z = abs < smartLinkSwitch.smartLinkGray;
            if (!smartLinkSwitch.smartLinkSwitch || !z || ALSLContext.instance().disableSmartLink) {
                go2DegradeWithUrl(aLSLUri, str, false, aLPSmartLinkCallback, 310);
                str2 = "关闭智能唤端，走降级逻辑";
            } else {
                openUrlWithSmart(context, aLSLUri, str, aLPSmartLinkCallback);
                str2 = "走智能唤端逻辑";
            }
            ALSLLogUtil.d("ALSLSmartLinkSDK", "init", str2);
        }
    }

    public static void openUrl(Context context, ALSLUri aLSLUri, ALPSmartLinkCallback aLPSmartLinkCallback) {
        String str;
        String str2;
        String str3;
        String str4;
        if (!ALSLContext.instance().isInit()) {
            str2 = "ALSLSmartLinkSDK";
            str3 = "init";
            str4 = "唤端之前必须要初始化SDK";
        } else if (context == null) {
            str2 = "ALPDistribution";
            str3 = "invoke";
            str4 = "context is null";
        } else {
            com.alibaba.alibclinkpartner.smartlink.b.a.c cVar = new com.alibaba.alibclinkpartner.smartlink.b.a.c();
            cVar.c = aLSLUri.degradeType;
            cVar.a = aLSLUri.target;
            cVar.b = aLSLUri.url;
            b.a(cVar);
            MatrixAppInfoDetail matrixAppInfoDetail = ALSLConfigration.sMatrixAPPData.appinfo.get(aLSLUri.target);
            if (matrixAppInfoDetail == null) {
                str = "";
            } else if (tryOpenApp(context, aLSLUri, matrixAppInfoDetail)) {
                aLPSmartLinkCallback.getLinkUrl(true, aLSLUri.target, getH5DegradeUrl(aLSLUri), 202);
                d dVar = new d();
                dVar.c = aLSLUri.degradeType;
                dVar.a = aLSLUri.target;
                dVar.b = aLSLUri.url;
                b.a(dVar);
                return;
            } else {
                str = matrixAppInfoDetail.downloadUrl;
            }
            isSmartOpen(context, aLSLUri, aLPSmartLinkCallback, str);
            return;
        }
        ALSLLogUtil.e(str2, str3, str4);
    }

    private static void openUrlWithSmart(Context context, ALSLUri aLSLUri, String str, ALPSmartLinkCallback aLPSmartLinkCallback) {
        int i;
        String str2;
        ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "进入能唤端逻辑");
        a.a(new d(context));
        if (ALSLConfigration.sSmartLinkData.data == null) {
            ALSLConfigration.sSmartLinkData = (SmartLinkData) f.d("smart_link_data", new SmartLinkData());
        }
        List<SmartLinkDetail> list = ALSLConfigration.sSmartLinkData.data;
        boolean z = false;
        if (list == null || list.size() == 0) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "智能唤端信息为空，走降级逻辑");
            go2DegradeWithUrl(aLSLUri, str, false, aLPSmartLinkCallback, 302);
            return;
        }
        k kVar = new k();
        kVar.b = aLSLUri.target;
        kVar.a = aLSLUri.url;
        kVar.c = aLSLUri.degradeType;
        b.a(kVar);
        ArrayList arrayList = new ArrayList();
        Iterator<SmartLinkDetail> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            SmartLinkDetail next = it2.next();
            List<String> list2 = next.excludes;
            String str3 = ALSLContext.instance().appkey;
            if (list2 == null || list2.size() <= 0 || !list2.contains(str3)) {
                List<String> list3 = next.patterns;
                if (list3.size() == 0) {
                    continue;
                } else {
                    Iterator<String> it3 = list3.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (Pattern.compile(it3.next()).matcher(aLSLUri.url).matches()) {
                                arrayList.addAll(next.targets);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (arrayList.size() > 0) {
                        ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "匹配到的业务规则为：" + arrayList.size());
                        break;
                    }
                }
            } else {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "需要智能唤端打开的APP在黑名单中，不能进行智能唤端");
            }
        }
        if (arrayList.size() > 0) {
            l lVar = new l();
            lVar.a = aLSLUri.url;
            lVar.c = aLSLUri.degradeType;
            lVar.b = aLSLUri.target;
            lVar.d = arrayList;
            b.a(lVar);
            Iterator it4 = arrayList.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    str2 = "";
                    break;
                }
                str2 = (String) it4.next();
                if (tryOpenApp(context, aLSLUri, ALSLConfigration.sMatrixAPPData.appinfo.get(str2))) {
                    z = true;
                    break;
                }
            }
            if (z) {
                aLPSmartLinkCallback.getLinkUrl(true, str2, getH5DegradeUrl(aLSLUri), 202);
                h hVar = new h();
                hVar.a = aLSLUri.target;
                hVar.c = aLSLUri.degradeType;
                hVar.d = str2;
                hVar.b = aLSLUri.url;
                b.a(hVar);
                return;
            }
            ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "没有匹配到任何业务规则，进行降级：");
            i = 304;
        } else {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "openUrlWithSmart", "没有匹配到任何业务规则，进行降级：" + arrayList.size());
            i = 305;
        }
        go2DegradeWithUrl(aLSLUri, str, true, aLPSmartLinkCallback, i);
    }

    public static boolean processIntent(Intent intent, Context context, ALSLUri aLSLUri) {
        if (aLSLUri.intentProcessor == null) {
            return true;
        }
        String str = intent.getPackage();
        String str2 = null;
        if (intent.getComponent() != null) {
            if (TextUtils.isEmpty(str)) {
                str = intent.getComponent().getPackageName();
            }
            str2 = intent.getComponent().getClassName();
        } else {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (!(resolveActivity == null || resolveActivity.activityInfo == null)) {
                if (TextUtils.isEmpty(str)) {
                    str = resolveActivity.activityInfo.packageName;
                }
                str2 = resolveActivity.activityInfo.name;
            }
        }
        return aLSLUri.intentProcessor.process(intent, str, str2, context);
    }

    private static boolean tryOpenApp(Context context, ALSLUri aLSLUri, MatrixAppInfoDetail matrixAppInfoDetail) {
        if (TextUtils.isEmpty(matrixAppInfoDetail.uri)) {
            ALSLLogUtil.e("ALSLSmartLinkSDK", "getMatrixAppList", "uri为空，打开失败");
            return false;
        } else if (!ALSLAppCheckManager.isAppCanOpen(context, matrixAppInfoDetail.packageName)) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "尝试唤端，但是APP未安装，走降级逻辑");
            return false;
        } else {
            String regexUrl = getRegexUrl(aLSLUri, matrixAppInfoDetail);
            int a = com.alibaba.alibclinkpartner.smartlink.util.a.a(regexUrl, "?");
            if (a > 0 && regexUrl.length() > 0) {
                for (int i = 1; i < a; i++) {
                    try {
                        int lastIndexOf = regexUrl.lastIndexOf("?");
                        if (lastIndexOf > 0) {
                            int lastIndexOf2 = regexUrl.substring(0, lastIndexOf - 1).lastIndexOf("=") + 1;
                            regexUrl = regexUrl.substring(0, lastIndexOf2) + g.d(regexUrl.substring(lastIndexOf2, regexUrl.length() - 1));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            String formatParams = formatParams(aLSLUri, regexUrl);
            ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "最终的唤端URL：" + formatParams);
            f.a(matrixAppInfoDetail.packageName, formatParams);
            Intent intent = new Intent();
            intent.setData(Uri.parse(formatParams));
            intent.setPackage(matrixAppInfoDetail.packageName);
            if (!TextUtils.isEmpty(matrixAppInfoDetail.action)) {
                intent.setAction(matrixAppInfoDetail.action);
            }
            if (!processIntent(intent, context, aLSLUri)) {
                return false;
            }
            intent.setFlags(805339136);
            try {
                context.startActivity(intent);
                ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "打开APP成功,包名为：" + matrixAppInfoDetail.packageName);
                return true;
            } catch (Exception e2) {
                ALSLLogUtil.d("ALSLSmartLinkSDK", "tryOpenApp", "尝试拉起：" + matrixAppInfoDetail.packageName + " 失败: " + e2.getMessage());
                return false;
            }
        }
    }

    public static void turnOnDebug(boolean z) {
        ALSLLogUtil.isLog = z;
    }
}
