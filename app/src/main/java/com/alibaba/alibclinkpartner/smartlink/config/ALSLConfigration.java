package com.alibaba.alibclinkpartner.smartlink.config;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.a.a;
import com.alibaba.alibclinkpartner.smartlink.b.a.g;
import com.alibaba.alibclinkpartner.smartlink.b.a.i;
import com.alibaba.alibclinkpartner.smartlink.b.a.m;
import com.alibaba.alibclinkpartner.smartlink.b.a.n;
import com.alibaba.alibclinkpartner.smartlink.callback.MatrixDataGetCallback;
import com.alibaba.alibclinkpartner.smartlink.callback.SmartLinkDataGetCallback;
import com.alibaba.alibclinkpartner.smartlink.data.MAtrixAppData;
import com.alibaba.alibclinkpartner.smartlink.data.SmartLinkData;
import com.alibaba.alibclinkpartner.smartlink.manager.ALSLAppCheckManager;
import com.alibaba.alibclinkpartner.smartlink.manager.b;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.c;
import com.alibaba.alibclinkpartner.smartlink.util.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ALSLConfigration {
    private static final String MATRIX_APP_REQUEST_URL = "https://userlink.alicdn.com/matrix_app/android/matrix_app_config.json";
    public static final String SAFE_PACKAGE_URL = "https://userlink.alicdn.com/matrix_app/android/safe_package_config.json";
    private static final String SMART_LINK_REQUEST_URL = "https://userlink.alicdn.com/smart_link/smart_link_config.json";
    public static final String SMART_LINK_SWITCH_URL = "https://userlink.alicdn.com/smart_link/android/alsl_switch_config.json";
    public static MAtrixAppData sMatrixAPPData = new MAtrixAppData();
    public static SmartLinkData sSmartLinkData = new SmartLinkData();

    public static void getMatrixAppDetailData(MatrixDataGetCallback matrixDataGetCallback) {
        f.a("last_matrix_config_request_time", Long.valueOf(System.currentTimeMillis()));
        b.a(new g());
        com.alibaba.alibclinkpartner.smartlink.a.b a = a.a("https://userlink.alicdn.com/matrix_app/android/matrix_app_config.json", (Map<String, String>) null);
        MAtrixAppData a2 = c.a(a.b);
        if (a2 == null || com.alibaba.alibclinkpartner.smartlink.util.b.a(a.b, a2.sign)) {
            matrixDataGetCallback.getData(a2);
            ALSLLogUtil.d("ALSLConfigration", "getMatrixAppDetailData", "拉到的矩阵APP信息：" + a.b);
            if (a.a == 200) {
                b.a(new i());
                f.a("last_matrix_config_detect_time", Long.valueOf(System.currentTimeMillis()));
            }
            if (!TextUtils.equals(sMatrixAPPData.version, a2.version)) {
                sMatrixAPPData = a2;
                f.c("matrix_config_data", a2);
                return;
            }
            return;
        }
        matrixDataGetCallback.getData(new MAtrixAppData());
    }

    public static void getMatrixAppList(final Application application) {
        com.alibaba.alibclinkpartner.smartlink.a.a(new Runnable() {
            /* class com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                MatrixDataGetCallback r2;
                if (ALSLConfigration.sMatrixAPPData.appinfo == null || ALSLConfigration.sMatrixAPPData.appinfo.size() == 0) {
                    ALSLConfigration.sMatrixAPPData = (MAtrixAppData) f.d("matrix_config_data", new MAtrixAppData());
                }
                if (ALSLConfigration.sMatrixAPPData.appinfo == null || ALSLConfigration.sMatrixAPPData.appinfo.size() == 0) {
                    ALSLConfigration.sMatrixAPPData = c.a("{\"appinfo\":{\"taobao\":{\"appkey\":\"21640297\",\"appname\":\"手机淘宝\",\"scheme\":\"tbopen://\",\"action\":\"com.taobao.open.intent.action.GETWAY\",\"packageName\":\"com.taobao.taobao\",\"uri\":\"tbopen://m.taobao.com/tbopen/index.html?h5Url=${url}&backURL=${backUrl}&visa=${visa}\",\"downloadUrl\":\"https://h5.m.taobao.com/hd/downLoadAnroidSimple.html\"},\"tmall\":{\"appkey\":\"23181017\",\"appname\":\"手机天猫\",\"scheme\":\"tmall://\",\"action\":\"com.tmall.wireless.intent.action.APPLINK\",\"packageName\":\"com.tmall.wireless\",\"uri\":\"tmall://page.tm/appLink?h5Url=${url}&backURL=${backUrl}&visa=${visa}\",\"downloadUrl\":\"https://pages.tmall.com/wow/mit/act/download\"},\"alipay\":{\"appkey\":\"12231321\",\"appname\":\"支付宝\",\"scheme\":\"alipays://\",\"action\":\"\",\"packageName\":\"com.eg.android.AlipayGphone\",\"uri\":\"alipays://platformapi/startapp?appId=2018030502317859&page=h5page/pages/h5page/h5page?targetURI=${url}\",\"downloadUrl\":\"\"}},\"version\":\"0\",\"validtime\":\"604800000\",\"sign\":}");
                }
                try {
                    if (!(ALSLConfigration.sMatrixAPPData == null || ALSLConfigration.sMatrixAPPData.appinfo == null)) {
                        if (ALSLConfigration.sMatrixAPPData.appinfo.size() != 0) {
                            long j = 0;
                            long longValue = ((Long) f.b("last_matrix_config_request_time", 0L)).longValue();
                            try {
                                j = Long.parseLong(ALSLConfigration.sMatrixAPPData.validtime);
                            } catch (Exception e) {
                                ALSLLogUtil.d("ALSLSmartLinkSDK", "getMatrixAppList", "过期时间转换异常：" + e.toString());
                            }
                            if (System.currentTimeMillis() - longValue > j) {
                                ALSLLogUtil.d("ALSLSmartLinkSDK", "getMatrixAppList", "本地配置信息过期，请求拉取");
                                r2 = new MatrixDataGetCallback() {
                                    /* class com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.AnonymousClass1.AnonymousClass2 */

                                    @Override // com.alibaba.alibclinkpartner.smartlink.callback.MatrixDataGetCallback
                                    public void getData(MAtrixAppData mAtrixAppData) {
                                        boolean z;
                                        Application application;
                                        if (!TextUtils.equals(ALSLConfigration.sMatrixAPPData.version, mAtrixAppData.version)) {
                                            application = application;
                                            z = true;
                                        } else {
                                            application = application;
                                            z = false;
                                        }
                                        ALSLConfigration.matrixAppDetectiveAndSend(application, mAtrixAppData, z);
                                    }
                                };
                                ALSLConfigration.getMatrixAppDetailData(r2);
                            }
                            return;
                        }
                    }
                    ALSLLogUtil.d("ALSLSmartLinkSDK", "getMatrixAppList", "本地无矩阵APP配置信息，请求拉取数据");
                    r2 = new MatrixDataGetCallback() {
                        /* class com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.AnonymousClass1.AnonymousClass1 */

                        @Override // com.alibaba.alibclinkpartner.smartlink.callback.MatrixDataGetCallback
                        public void getData(MAtrixAppData mAtrixAppData) {
                            ALSLConfigration.matrixAppDetectiveAndSend(application, mAtrixAppData, true);
                        }
                    };
                    ALSLConfigration.getMatrixAppDetailData(r2);
                } catch (Exception e2) {
                    ALSLLogUtil.e("ALSLSmartLinkSDK", "getMatrixAppList", "方法异常：" + e2.toString());
                }
            }
        });
    }

    public static void getSmartLinkData(Context context, String str) {
        requestSmartLinkData(str, new SmartLinkDataGetCallback() {
            /* class com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.AnonymousClass2 */

            @Override // com.alibaba.alibclinkpartner.smartlink.callback.SmartLinkDataGetCallback
            public void getData(SmartLinkData smartLinkData) {
                f.a("last_smart_link_config_request_time", Long.valueOf(System.currentTimeMillis()));
                if (smartLinkData != null && !TextUtils.equals(smartLinkData.version, ALSLConfigration.sSmartLinkData.version)) {
                    ALSLLogUtil.d("ALSLConfigration", "requestSmartLinkData", "智能唤端配置请求成功：version不同，表示配置有更新  更新本地变量");
                    ALSLConfigration.sSmartLinkData = smartLinkData;
                    f.c("smart_link_data", ALSLConfigration.sSmartLinkData);
                    if (!TextUtils.equals(ALSLConfigration.sSmartLinkData.appConfigVersion, ALSLConfigration.sMatrixAPPData.version)) {
                        ALSLConfigration.getMatrixAppDetailData(new MatrixDataGetCallback() {
                            /* class com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration.AnonymousClass2.AnonymousClass1 */

                            @Override // com.alibaba.alibclinkpartner.smartlink.callback.MatrixDataGetCallback
                            public void getData(MAtrixAppData mAtrixAppData) {
                                ALSLConfigration.matrixAppDetectiveAndSend(ALSLContext.instance().mApplication, mAtrixAppData, true);
                            }
                        });
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void matrixAppDetectiveAndSend(Application application, MAtrixAppData mAtrixAppData, boolean z) {
        long longValue = ((Long) f.b("last_matrix_config_detect_time", 0L)).longValue();
        if (!z && System.currentTimeMillis() - longValue < 86400000) {
            ALSLLogUtil.d("ALSLSmartLinkSDK", "getMatrixAppList", "距离上次请求矩阵APP小于一天，不再重新请求");
        }
        List<String> installAppList = ALSLAppCheckManager.getInstallAppList(application, com.alibaba.alibclinkpartner.smartlink.util.a.a(sMatrixAPPData));
        com.alibaba.alibclinkpartner.smartlink.b.a.b bVar = new com.alibaba.alibclinkpartner.smartlink.b.a.b();
        bVar.a = installAppList;
        b.a(bVar);
        ALSLLogUtil.d("ALSLSmartLinkSDK", "getMatrixAppList", "上报设备探针信息：" + bVar.b());
    }

    public static void requestSmartLinkData(String str, SmartLinkDataGetCallback smartLinkDataGetCallback) {
        b.a(new m());
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", str);
        com.alibaba.alibclinkpartner.smartlink.a.b a = a.a("https://userlink.alicdn.com/smart_link/smart_link_config.json", hashMap);
        if (a.a != 200) {
            ALSLLogUtil.d("ALSLConfigration", "requestSmartLinkData", "智能唤端接口请求失败，错误码：：" + a.a);
            return;
        }
        SmartLinkData b = c.b(a.b);
        if (!com.alibaba.alibclinkpartner.smartlink.util.b.a(a.b, b.sign)) {
            smartLinkDataGetCallback.getData(new SmartLinkData());
            return;
        }
        smartLinkDataGetCallback.getData(b);
        ALSLLogUtil.d("ALSLConfigration", "requestSmartLinkData", "智能唤端配置请求成功：" + a.b);
        if (a.a == 200) {
            b.a(new n());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public static void updateSmartLinkData(Context context, String str) {
        long j;
        String str2;
        Exception e;
        if (sSmartLinkData.data == null) {
            sSmartLinkData = (SmartLinkData) f.d("smart_link_data", new SmartLinkData());
        }
        if (sSmartLinkData.data == null) {
            str2 = "本地智能唤端数据为空，进行智能唤端配置请求";
        } else {
            long j2 = 0;
            try {
                j = Long.valueOf(sSmartLinkData.validtime).longValue();
                try {
                    j2 = ((Long) f.b("last_smart_link_config_request_time", 0L)).longValue();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                j = 0;
                ALSLLogUtil.d("ALSLConfigration", "updateSmartLinkData", "异常信息：" + e.toString());
                if (System.currentTimeMillis() - j2 <= j) {
                }
            }
            if (System.currentTimeMillis() - j2 <= j) {
                str2 = "本地智能唤端数据过期，请求新的配置";
            } else {
                return;
            }
        }
        ALSLLogUtil.d("ALSLConfigration", "updateSmartLinkData", str2);
        getSmartLinkData(context, str);
    }
}
