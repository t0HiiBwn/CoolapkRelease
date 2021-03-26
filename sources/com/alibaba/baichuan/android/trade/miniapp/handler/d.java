package com.alibaba.baichuan.android.trade.miniapp.handler;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.b;
import com.alibaba.baichuan.android.trade.miniapp.a;
import com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.usertracker.monitor.c;
import com.alibaba.baichuan.trade.biz.applink.AlibcApplinkData;
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplink;
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeShowParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTrackParam;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ExtendDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ParamDO;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlTypeUtil;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcAidComponent;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.biz.utils.AlibcTradeHelper;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.JSONUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d extends UrlHandler {
    private AlibcApplinkData a(String str, String str2) {
        String str3;
        String str4 = "";
        if ("detail".equals(str2)) {
            try {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    str4 = parse.getQueryParameter("id");
                }
                String d = d(str4);
                if (!TextUtils.isEmpty(d)) {
                    return new AlibcApplinkData(1, d);
                }
            } catch (Exception unused) {
                str3 = "解析详情url异常";
                AlibcLogger.e("NativeHandler", str3);
                return new AlibcApplinkData(3, str);
            }
        } else if ("shop".equals(str2)) {
            try {
                Uri parse2 = Uri.parse(str);
                if (parse2 != null) {
                    str4 = parse2.getQueryParameter("shop_id");
                }
                if (!TextUtils.isEmpty(str4)) {
                    return new AlibcApplinkData(2, str4);
                }
            } catch (Exception unused2) {
                str3 = "解析店铺url异常";
                AlibcLogger.e("NativeHandler", str3);
                return new AlibcApplinkData(3, str);
            }
        }
        return new AlibcApplinkData(3, str);
    }

    private AlibcFailModeType a(AlibcTradeShowParam alibcTradeShowParam) {
        AlibcFailModeType alibcFailModeType;
        AlibcFailModeType alibcFailModeType2 = AlibcFailModeType.AlibcNativeFailModeJumpDOWNLOAD;
        if (alibcTradeShowParam == null || alibcTradeShowParam.getNativeOpenFailedMode() == null) {
            ConfigDO config = AlibcConfigService.getInstance().getConfig();
            if (config != null) {
                ExtendDO misc = config.getMisc();
                if (misc != null) {
                    String failMode = misc.getFailMode();
                    if ("none".equals(failMode)) {
                        alibcFailModeType = AlibcFailModeType.AlibcNativeFailModeNONE;
                    } else if ("browser".equals(failMode)) {
                        alibcFailModeType = AlibcFailModeType.AlibcNativeFailModeJumpBROWER;
                    } else if ("download".equals(failMode)) {
                        alibcFailModeType = AlibcFailModeType.AlibcNativeFailModeJumpDOWNLOAD;
                    } else if ("h5".equals(failMode)) {
                        alibcFailModeType = AlibcFailModeType.AlibcNativeFailModeJumpH5;
                    }
                    alibcFailModeType2 = alibcFailModeType;
                }
            } else {
                AlibcLogger.i("NativeHandler", "配置读取拉端失败模式失败");
            }
        } else {
            alibcFailModeType2 = alibcTradeShowParam.getNativeOpenFailedMode();
        }
        AlibcLogger.d("NativeHandler", "native打开流程传递下来的failMode = " + alibcFailModeType2);
        return alibcFailModeType2;
    }

    private static void a() {
        AlibcUserTradeHelper.sendUsabilitySuccess("Page_Native");
    }

    private void a(Context context, UrlRequest urlRequest, String str, AlibcTradeShowParam alibcTradeShowParam, AlibcTradeTaokeParam alibcTradeTaokeParam, Map<String, String> map, c cVar, UrlCallBack urlCallBack, String str2, String str3, AlibcFailModeType alibcFailModeType, ALPSmartLinkCallback aLPSmartLinkCallback) {
        String str4;
        String str5;
        String str6;
        String backUrl = (alibcTradeShowParam == null || TextUtils.isEmpty(alibcTradeShowParam.getBackUrl())) ? "" : alibcTradeShowParam.getBackUrl();
        AlibcLogger.d("NativeHandler", "native打开backUrl = " + backUrl);
        if (alibcFailModeType.equals(AlibcFailModeType.AlibcNativeFailModeJumpH5)) {
            str6 = str;
            str4 = str6;
            str5 = str2;
        } else {
            str6 = str;
            str5 = str2;
            str4 = "";
        }
        AlibcApplinkData a = a(str6, str5);
        if (cVar != null) {
            cVar.b();
        }
        a(context, urlRequest, str4, alibcTradeTaokeParam, map, a, backUrl, str3, alibcFailModeType, cVar, urlCallBack, aLPSmartLinkCallback);
    }

    private void a(Context context, UrlRequest urlRequest, String str, AlibcTradeTaokeParam alibcTradeTaokeParam, Map<String, String> map, AlibcApplinkData alibcApplinkData, String str2, String str3, AlibcFailModeType alibcFailModeType, c cVar, UrlCallBack urlCallBack, ALPSmartLinkCallback aLPSmartLinkCallback) {
        if (context == null || alibcApplinkData == null || alibcApplinkData.param == null) {
            urlCallBack.a(false, urlRequest);
            return;
        }
        if (cVar != null) {
            cVar.e();
        }
        int i = alibcApplinkData.type;
        if (i == 1) {
            AlibcLogger.d("NativeHandler", "调用jumpDetail流程");
            AlibcApplink.getInstance().jumpDetail(context, alibcApplinkData.param, str, alibcFailModeType, str2, str3, alibcTradeTaokeParam, map, aLPSmartLinkCallback);
        } else if (i == 2) {
            AlibcLogger.d("NativeHandler", "调用jumpShop流程");
            AlibcApplink.getInstance().jumpShop(context, alibcApplinkData.param, str, alibcFailModeType, str2, str3, alibcTradeTaokeParam, map, aLPSmartLinkCallback);
        } else if (i == 3) {
            AlibcLogger.d("NativeHandler", "调用jumpUrl流程");
            AlibcApplink.getInstance().jumpTBURI(context, alibcApplinkData.param, str, alibcFailModeType, str2, str3, alibcTradeTaokeParam, map, aLPSmartLinkCallback);
        }
    }

    private static void a(String str, AlibcTradeTaokeParam alibcTradeTaokeParam, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            if (!TextUtils.isEmpty(AlibcTradeCommon.getAppKey())) {
                hashMap.put("appkey", AlibcTradeCommon.getAppKey());
            }
            hashMap.put("taokeParam", alibcTradeTaokeParam == null ? "{}" : alibcTradeTaokeParam.toString());
            AlibcUserTracker.getInstance().sendCustomHit(str, "", hashMap);
        }
    }

    private void a(Map<String, String> map, boolean z, int i) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(AlibcTradeCommon.getAppKey())) {
            hashMap.put("appkey", AlibcTradeCommon.getAppKey());
        }
        if (map != null && map.size() > 0) {
            hashMap.put("param", JSONUtils.objectToJson("param", map));
            hashMap.put("ybhpss", TextUtils.isEmpty(map.get("ybhpss")) ? "" : map.get("ybhpss"));
        }
        hashMap.put("from", "nbsdk");
        hashMap.put("isSuccess", z ? "1" : "0");
        hashMap.put("errorCode", z ? "" : String.valueOf(i));
        AlibcUserTracker.getInstance().sendCustomHit(UserTrackerConstants.E_SHOW_APPLINK, "", hashMap);
    }

    private void a(boolean z, c cVar, String str, a aVar, AlibcTradeContext alibcTradeContext) {
        String str2;
        if (z) {
            AlibcLogger.d("NativeHandler", "跳转成功");
            if (cVar != null) {
                int d = aVar.d();
                if (d == 100) {
                    b c = aVar.c();
                    cVar.b = c.f();
                    str2 = c.d();
                } else if (d == 200) {
                    AlibcBasePage b = aVar.b();
                    cVar.b = b.getPerformancePageType();
                    str2 = b.getApi();
                } else {
                    str2 = "";
                }
                cVar.f();
                cVar.d();
                cVar.h();
                a(str2, alibcTradeContext.taokeParam, alibcTradeContext.urlParam);
                a();
                return;
            }
            return;
        }
        AlibcLogger.e("NativeHandler", "跳转失败,具体错误信息");
        b(str);
    }

    /* access modifiers changed from: private */
    public void a(boolean z, c cVar, String str, a aVar, AlibcTradeContext alibcTradeContext, UrlRequest urlRequest, String str2, int i, int i2, UrlCallBack urlCallBack) {
        a(alibcTradeContext.urlParam, z, i2);
        a(z, cVar, str, aVar, alibcTradeContext);
        if (z) {
            AlibcLogger.i("NativeHandler", "Native:pid方式打开成功");
            urlCallBack.a(1000);
            return;
        }
        AlibcLogger.i("NativeHandler", "降级url: " + str2);
        String degradeUrl = alibcTradeContext.showParam.getDegradeUrl();
        if (!TextUtils.isEmpty(degradeUrl)) {
            urlRequest.setUrl(degradeUrl);
        } else {
            urlRequest.setUrl(str2);
        }
        urlCallBack.a(false, urlRequest);
    }

    private boolean a(final Context context, final String str, UrlRequest urlRequest, final String str2, final AlibcTradeShowParam alibcTradeShowParam, final AlibcTradeTaokeParam alibcTradeTaokeParam, final Map<String, String> map, final AlibcFailModeType alibcFailModeType, UrlCallBack urlCallBack, final ALPSmartLinkCallback aLPSmartLinkCallback) {
        if (alibcTradeTaokeParam != null && !TextUtils.isEmpty(alibcTradeTaokeParam.adzoneid)) {
            AlibcAidComponent.genTaokeUrl(true, map, str2, alibcTradeTaokeParam, new AlibcTaokeTraceCallback() {
                /* class com.alibaba.baichuan.android.trade.miniapp.handler.d.AnonymousClass5 */

                @Override // com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback
                public void getTaokeUrl(int i2, String str) {
                    ALPSmartLinkCallback aLPSmartLinkCallback;
                    Map<String, String> map;
                    AlibcTradeTaokeParam alibcTradeTaokeParam;
                    String str2;
                    AlibcFailModeType alibcFailModeType;
                    String str3;
                    AlibcTradeShowParam alibcTradeShowParam = alibcTradeShowParam;
                    String str4 = "";
                    String backUrl = (alibcTradeShowParam == null || TextUtils.isEmpty(alibcTradeShowParam.getBackUrl())) ? str4 : alibcTradeShowParam.getBackUrl();
                    AlibcLogger.d("NativeHandler", "native打开backUrl = " + backUrl);
                    if (alibcFailModeType.equals(AlibcFailModeType.AlibcNativeFailModeJumpH5)) {
                        str4 = str2;
                    }
                    boolean isEmpty = TextUtils.isEmpty(str);
                    AlibcApplink instance = AlibcApplink.getInstance();
                    Context context = context;
                    if (!isEmpty) {
                        alibcFailModeType = alibcFailModeType;
                        str2 = str;
                        alibcTradeTaokeParam = alibcTradeTaokeParam;
                        map = map;
                        aLPSmartLinkCallback = aLPSmartLinkCallback;
                        str3 = str;
                    } else {
                        str3 = str2;
                        alibcFailModeType = alibcFailModeType;
                        str2 = str;
                        alibcTradeTaokeParam = alibcTradeTaokeParam;
                        map = map;
                        aLPSmartLinkCallback = aLPSmartLinkCallback;
                    }
                    instance.jumpTBURI(context, str3, str4, alibcFailModeType, backUrl, str2, alibcTradeTaokeParam, map, aLPSmartLinkCallback);
                }
            });
        }
        return true;
    }

    private boolean a(AlibcTradeTaokeParam alibcTradeTaokeParam, String str, String str2) {
        if ("detail".equals(str) && alibcTradeTaokeParam != null) {
            return true;
        }
        if (!"shop".equals(str) || alibcTradeTaokeParam == null || !alibcTradeTaokeParam.isAdZoneIdExist()) {
            return a(str2) && alibcTradeTaokeParam != null && alibcTradeTaokeParam.isAdZoneIdExist();
        }
        return true;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return AlibcURLCheck.regular.check(AlibcContext.tunionUrlPatterns, str.trim());
    }

    private void b(String str) {
        String c = c(str);
        AlibcUserTradeHelper.sendUsabilityFailure("Page_Native", "applink调用失败", "11" + c + "03");
    }

    private String c(String str) {
        return "detail".equals(str) ? "01" : "shop".equals(str) ? "02" : "03";
    }

    private String d(String str) {
        return !TextUtils.isEmpty(str) ? str.matches("^\\d+$") ? str : String.valueOf(AlibcSecurityGuard.getInstance().analyzeItemId(str)) : "";
    }

    @Override // com.alibaba.baichuan.android.trade.miniapp.handler.UrlHandler
    protected void handleInternal(final UrlRequest urlRequest, final UrlCallBack urlCallBack, final AlibcTradeContext alibcTradeContext, final a aVar) {
        String str;
        d dVar;
        Activity activity;
        UrlRequest urlRequest2;
        String str2;
        AlibcTradeShowParam alibcTradeShowParam;
        AlibcTradeTaokeParam alibcTradeTaokeParam;
        AlibcTradeTrackParam alibcTradeTrackParam;
        c cVar;
        UrlCallBack urlCallBack2;
        String str3;
        String str4;
        AlibcFailModeType alibcFailModeType;
        AnonymousClass2 r12;
        d dVar2;
        Activity activity2;
        String str5;
        UrlRequest urlRequest3;
        String str6;
        AlibcTradeShowParam alibcTradeShowParam2;
        AlibcTradeTaokeParam alibcTradeTaokeParam2;
        AlibcTradeTrackParam alibcTradeTrackParam2;
        AlibcFailModeType alibcFailModeType2;
        UrlCallBack urlCallBack3;
        AnonymousClass1 r10;
        AlibcLogger.i("NativeHandler", "execute handleInternal");
        final c cVar2 = new c();
        cVar2.c();
        cVar2.a();
        HashMap<String, Object> fields = urlRequest.getFields();
        if (fields.containsKey("urlType")) {
            AlibcTradeShowParam alibcTradeShowParam3 = alibcTradeContext.showParam;
            AlibcTradeTaokeParam alibcTradeTaokeParam3 = alibcTradeContext.taokeParam;
            String clientType = alibcTradeShowParam3.getClientType();
            if (TextUtils.isEmpty(clientType)) {
                clientType = "taobao";
            }
            String str7 = "";
            final String pageType = urlRequest.getPageType();
            List<ActionDO> actionPriorityList = urlRequest.getActionPriorityList();
            if (!(actionPriorityList == null || actionPriorityList.size() == 0)) {
                for (ActionDO actionDO : actionPriorityList) {
                    if ("native".equals(actionDO.getOpenType())) {
                        ParamDO param = actionDO.getParam();
                        String clientType2 = param.getClientType();
                        if (clientType2 != null) {
                            clientType = clientType2;
                        }
                        String targetPath = param.getTargetPath();
                        if (!TextUtils.isEmpty(targetPath)) {
                            str7 = targetPath;
                        }
                        pageType = param.getClientPage();
                    }
                }
            }
            AlibcFailModeType a = a(alibcTradeShowParam3);
            if ("miniapp".equals(fields.get("urlType"))) {
                str = "小程序拉端";
            } else if ("h5".equals(fields.get("urlType"))) {
                if (!TextUtils.isEmpty(str7)) {
                    urlRequest.setUrl(str7);
                    String verifyUrlType = UrlTypeUtil.verifyUrlType(str7, null);
                    if ("h5".equals(verifyUrlType)) {
                        if (alibcTradeTaokeParam3 == null || !a(alibcTradeTaokeParam3, pageType, str7) || !alibcTradeTaokeParam3.isAdZoneIdExist()) {
                            Activity activity3 = alibcTradeContext.activity.get();
                            AlibcTradeTrackParam alibcTradeTrackParam3 = alibcTradeContext.urlParam;
                            AnonymousClass4 r18 = new ALPSmartLinkCallback() {
                                /* class com.alibaba.baichuan.android.trade.miniapp.handler.d.AnonymousClass4 */

                                @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                                public void getLinkUrl(boolean z, String str, String str2, int i) {
                                    d.this.a(z, cVar2, pageType, aVar, alibcTradeContext, urlRequest, str2, 1000, i, urlCallBack);
                                }
                            };
                            dVar = this;
                            activity = activity3;
                            urlRequest2 = urlRequest;
                            str2 = str7;
                            alibcTradeShowParam = alibcTradeShowParam3;
                            alibcTradeTaokeParam = alibcTradeTaokeParam3;
                            alibcTradeTrackParam = alibcTradeTrackParam3;
                            cVar = null;
                            urlCallBack2 = urlCallBack;
                            str3 = pageType;
                            str4 = clientType;
                            alibcFailModeType = a;
                            r12 = r18;
                            dVar.a(activity, urlRequest2, str2, alibcTradeShowParam, alibcTradeTaokeParam, alibcTradeTrackParam, cVar, urlCallBack2, str3, str4, alibcFailModeType, r12);
                            return;
                        }
                        Activity activity4 = alibcTradeContext.activity.get();
                        AlibcTradeTrackParam alibcTradeTrackParam4 = alibcTradeContext.urlParam;
                        AnonymousClass3 r17 = new ALPSmartLinkCallback() {
                            /* class com.alibaba.baichuan.android.trade.miniapp.handler.d.AnonymousClass3 */

                            @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                            public void getLinkUrl(boolean z, String str, String str2, int i) {
                                d.this.a(z, cVar2, pageType, aVar, alibcTradeContext, urlRequest, str2, 1100, i, urlCallBack);
                            }
                        };
                        dVar2 = this;
                        activity2 = activity4;
                        str5 = clientType;
                        urlRequest3 = urlRequest;
                        str6 = str7;
                        alibcTradeShowParam2 = alibcTradeShowParam3;
                        alibcTradeTaokeParam2 = alibcTradeTaokeParam3;
                        alibcTradeTrackParam2 = alibcTradeTrackParam4;
                        alibcFailModeType2 = a;
                        urlCallBack3 = urlCallBack;
                        r10 = r17;
                    } else if ("miniapp".equals(verifyUrlType)) {
                        str = "链接类型为小程序";
                    } else {
                        return;
                    }
                } else if (alibcTradeTaokeParam3 == null || !a(alibcTradeTaokeParam3, pageType, urlRequest.getUrl()) || !alibcTradeTaokeParam3.isAdZoneIdExist()) {
                    Activity activity5 = alibcTradeContext.activity.get();
                    String url = urlRequest.getUrl();
                    AlibcTradeTrackParam alibcTradeTrackParam5 = alibcTradeContext.urlParam;
                    AnonymousClass2 r172 = new ALPSmartLinkCallback() {
                        /* class com.alibaba.baichuan.android.trade.miniapp.handler.d.AnonymousClass2 */

                        @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                        public void getLinkUrl(boolean z, String str, String str2, int i) {
                            d.this.a(z, cVar2, pageType, aVar, alibcTradeContext, urlRequest, str2, 1000, i, urlCallBack);
                        }
                    };
                    dVar = this;
                    activity = activity5;
                    urlRequest2 = urlRequest;
                    str2 = url;
                    alibcTradeShowParam = alibcTradeShowParam3;
                    alibcTradeTaokeParam = alibcTradeTaokeParam3;
                    alibcTradeTrackParam = alibcTradeTrackParam5;
                    cVar = null;
                    urlCallBack2 = urlCallBack;
                    str3 = pageType;
                    str4 = clientType;
                    alibcFailModeType = a;
                    r12 = r172;
                    dVar.a(activity, urlRequest2, str2, alibcTradeShowParam, alibcTradeTaokeParam, alibcTradeTrackParam, cVar, urlCallBack2, str3, str4, alibcFailModeType, r12);
                    return;
                } else {
                    Activity activity6 = alibcTradeContext.activity.get();
                    String url2 = urlRequest.getUrl();
                    AlibcTradeTrackParam alibcTradeTrackParam6 = alibcTradeContext.urlParam;
                    AnonymousClass1 r16 = new ALPSmartLinkCallback() {
                        /* class com.alibaba.baichuan.android.trade.miniapp.handler.d.AnonymousClass1 */

                        @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                        public void getLinkUrl(boolean z, String str, String str2, int i) {
                            d.this.a(z, cVar2, pageType, aVar, alibcTradeContext, urlRequest, str2, 1100, i, urlCallBack);
                        }
                    };
                    dVar2 = this;
                    activity2 = activity6;
                    str5 = clientType;
                    urlRequest3 = urlRequest;
                    str6 = url2;
                    alibcTradeShowParam2 = alibcTradeShowParam3;
                    alibcTradeTaokeParam2 = alibcTradeTaokeParam3;
                    alibcTradeTrackParam2 = alibcTradeTrackParam6;
                    alibcFailModeType2 = a;
                    urlCallBack3 = urlCallBack;
                    r10 = r16;
                }
                dVar2.a(activity2, str5, urlRequest3, str6, alibcTradeShowParam2, alibcTradeTaokeParam2, alibcTradeTrackParam2, alibcFailModeType2, urlCallBack3, r10);
                return;
            } else {
                return;
            }
            AlibcLogger.i("NativeHandler", str);
        }
    }

    @Override // com.alibaba.baichuan.android.trade.miniapp.handler.UrlHandler
    protected boolean shouldHandle(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, a aVar, boolean z) {
        if (!z) {
            return false;
        }
        if (AlibcTradeHelper.verifyUrl(AlibcConfigService.getInstance().getUrls(), urlRequest.getUrl())) {
            AlibcLogger.i("NativeHandler", "url not match pattern url list");
            return false;
        }
        List<ActionDO> actionPriorityList = urlRequest.getActionPriorityList();
        AlibcLogger.i("NativeHandler", "request: " + urlRequest.getActionPriorityList());
        if (!(actionPriorityList == null || actionPriorityList.size() == 0)) {
            for (ActionDO actionDO : actionPriorityList) {
                if ("native".equals(actionDO.getOpenType())) {
                    return true;
                }
            }
        }
        return alibcTradeContext.showParam.getOpenType().equals(AlibcTradeShowParam.OpenType.Native);
    }
}
