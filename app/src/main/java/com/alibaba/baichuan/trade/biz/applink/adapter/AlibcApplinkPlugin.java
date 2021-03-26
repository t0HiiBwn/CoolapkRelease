package com.alibaba.baichuan.trade.biz.applink.adapter;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsCallbackContext;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsResult;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcAidComponent;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

public class AlibcApplinkPlugin extends AlibcApiPlugin {
    public static String API_NAME = "AliBCAppLink";
    public static String[] detailPatterns = {"^http(s)?://h5\\.(.*)\\.taobao.com/cm/snap/index\\.html(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/core/detail\\.htm(.*)", "^http(s)?://detail\\.(.*)\\.tmall\\.(com|hk)/item\\.htm(.*)"};
    public static final String[] shopPatterns = {"^http(s)?://shop\\.(.*)\\.taobao.com/shop/shop_index.htm(.*)", "^http(s)?://shop\\.(.*)\\.tmall.com/shop/shop_index.htm(.*)", "^http(s)?://shop(.*)\\.(.*)\\.taobao.com/shop/shopIndex.htm(.*)"};

    /* access modifiers changed from: private */
    public AlibcFailModeType a(String str) {
        return TextUtils.isEmpty(str) ? AlibcFailModeType.AlibcNativeFailModeNONE : str.toLowerCase().trim().equals("h5") ? AlibcFailModeType.AlibcNativeFailModeJumpH5 : str.toLowerCase().trim().equals("download") ? AlibcFailModeType.AlibcNativeFailModeJumpDOWNLOAD : str.toLowerCase().trim().equals("browser") ? AlibcFailModeType.AlibcNativeFailModeJumpBROWER : str.toLowerCase().trim().equals("none") ? AlibcFailModeType.AlibcNativeFailModeNONE : AlibcFailModeType.AlibcNativeFailModeNONE;
    }

    /* access modifiers changed from: private */
    public String a(Map<String, Object> map) {
        if (!(map == null || map.size() == 0)) {
            String obj2String = StringUtils.obj2String(map.get("needBackBtn"));
            if (TextUtils.isEmpty(obj2String) || !obj2String.trim().equals("0")) {
                String obj2String2 = StringUtils.obj2String(map.get("backURL"));
                if (!TextUtils.isEmpty(obj2String2)) {
                    return obj2String2;
                }
            }
        }
        return null;
    }

    private String a(Map<String, Object> map, String str) {
        if (!(map == null || map.size() == 0 || TextUtils.isEmpty(str))) {
            if (str.equals("url")) {
                return e(map);
            }
            if (str.equals("shop") && c(map) != null) {
                return String.format("https://shop.m.taobao.com/shop/shop_index.htm?shop_id=%s", c(map));
            }
            if (str.equals("detail") && d(map) != null) {
                return String.format("https://h5.m.taobao.com/awp/core/detail.htm?id=%s", d(map));
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    public AlibcTradeTaokeParam b(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        String valueOf = map.get("pid") == null ? null : String.valueOf(map.get("pid"));
        String valueOf2 = map.get("subpid") == null ? null : String.valueOf(map.get("subpid"));
        String valueOf3 = map.get("unionId") == null ? null : String.valueOf(map.get("unionId"));
        String valueOf4 = map.get("adzoneid") == null ? null : String.valueOf(map.get("adzoneid"));
        if (TextUtils.isEmpty(valueOf) && TextUtils.isEmpty(valueOf2) && TextUtils.isEmpty(valueOf3) && TextUtils.isEmpty(valueOf4)) {
            return null;
        }
        AlibcTradeTaokeParam alibcTradeTaokeParam = new AlibcTradeTaokeParam("", "", "");
        alibcTradeTaokeParam.setPid(valueOf).setSubPid(valueOf2).setUnionId(valueOf3).setAdzoneid(valueOf4);
        if (alibcTradeTaokeParam.isAdZoneIdExist()) {
            alibcTradeTaokeParam.setPid(null);
            map.remove("pid");
        }
        return alibcTradeTaokeParam;
    }

    private boolean b(String str) {
        return AlibcURLCheck.regular.check(detailPatterns, str);
    }

    private boolean b(Map<String, Object> map, String str) {
        AlibcTradeTaokeParam b;
        if (map == null || map.size() == 0 || TextUtils.isEmpty(str) || (b = b(map)) == null || !b.isAdZoneIdExist()) {
            return false;
        }
        if (!str.equals("shop") && !str.equals("detail")) {
            String e = e(map);
            if (TextUtils.isEmpty(e)) {
                return false;
            }
            if (!b(e) && !c(e)) {
                return false;
            }
        }
        return true;
    }

    private String c(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return String.valueOf(map.get("shopId"));
    }

    private boolean c(String str) {
        return AlibcURLCheck.regular.check(shopPatterns, str);
    }

    private String d(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return String.valueOf(map.get("itemId"));
    }

    private String e(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return String.valueOf(map.get("url"));
    }

    /* access modifiers changed from: private */
    public String f(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return String.valueOf(map.get("linkKey"));
    }

    /* access modifiers changed from: private */
    public Map<String, String> g(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A[ADDED_TO_REGION] */
    @Override // com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin
    public boolean execute(String str, String str2, final AlibcJsCallbackContext alibcJsCallbackContext) {
        final Map<String, Object> map;
        String str3;
        Exception e;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || alibcJsCallbackContext == null) {
            AlibcJsResult alibcJsResult = new AlibcJsResult("6");
            alibcJsResult.setResultCode("2");
            if (alibcJsCallbackContext == null) {
                return false;
            }
            alibcJsCallbackContext.error(alibcJsResult);
            return false;
        }
        new AlibcNavResult();
        try {
            Map<String, Object> obj2MapObject = StringUtils.obj2MapObject(JSON.parse(str2));
            str3 = StringUtils.obj2String(obj2MapObject.get("type"));
            try {
                map = StringUtils.obj2MapObject(obj2MapObject.get("params"));
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                map = null;
                if (str3 != null) {
                }
                AlibcJsResult alibcJsResult2 = new AlibcJsResult("6");
                alibcJsResult2.setResultCode("2");
                alibcJsCallbackContext.error(alibcJsResult2);
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            str3 = null;
            e.printStackTrace();
            map = null;
            if (str3 != null) {
            }
            AlibcJsResult alibcJsResult2 = new AlibcJsResult("6");
            alibcJsResult2.setResultCode("2");
            alibcJsCallbackContext.error(alibcJsResult2);
            return true;
        }
        if (str3 != null || map == null) {
            AlibcJsResult alibcJsResult2 = new AlibcJsResult("6");
            alibcJsResult2.setResultCode("2");
            alibcJsCallbackContext.error(alibcJsResult2);
            return true;
        }
        a(map);
        final String obj2String = StringUtils.obj2String(map.get("failMode"));
        final Application application = AlibcTradeCommon.context;
        if (application == null) {
            AlibcJsResult alibcJsResult3 = new AlibcJsResult("6");
            alibcJsResult3.setResultCode("2");
            alibcJsCallbackContext.error(alibcJsResult3);
            return true;
        } else if (!b(map, str3)) {
            if (str3.equals("shop")) {
                AlibcApplink.getInstance().jumpShop(application, c(map), "", a(obj2String), a(map), f(map), b(map), g(map), new ALPSmartLinkCallback() {
                    /* class com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplinkPlugin.AnonymousClass2 */

                    @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                    public void getLinkUrl(boolean z, String str, String str2, int i) {
                        if (z) {
                            alibcJsCallbackContext.success(AlibcJsResult.RET_SUCCESS);
                        } else {
                            alibcJsCallbackContext.error(AlibcJsResult.RET_FAIL);
                        }
                    }
                });
            } else if (str3.equals("detail")) {
                AlibcApplink.getInstance().jumpDetail(application, d(map), "", a(obj2String), a(map), f(map), b(map), g(map), new ALPSmartLinkCallback() {
                    /* class com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplinkPlugin.AnonymousClass3 */

                    @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                    public void getLinkUrl(boolean z, String str, String str2, int i) {
                        if (z) {
                            alibcJsCallbackContext.success(AlibcJsResult.RET_SUCCESS);
                        } else {
                            alibcJsCallbackContext.error(AlibcJsResult.RET_FAIL);
                        }
                    }
                });
            } else if (str3.equals("url")) {
                AlibcApplink.getInstance().jumpTBURI(application, e(map), "", a(obj2String), a(map), f(map), b(map), g(map), new ALPSmartLinkCallback() {
                    /* class com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplinkPlugin.AnonymousClass4 */

                    @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                    public void getLinkUrl(boolean z, String str, String str2, int i) {
                        if (z) {
                            alibcJsCallbackContext.success(AlibcJsResult.RET_SUCCESS);
                        } else {
                            alibcJsCallbackContext.error(AlibcJsResult.RET_FAIL);
                        }
                    }
                });
            }
            return true;
        } else if (AlibcApplink.isApplinkSupported(f(map)) || !AlibcFailModeType.AlibcNativeFailModeNONE.equals(a(obj2String))) {
            String a = a(map, str3);
            if (TextUtils.isEmpty(a)) {
                AlibcJsResult alibcJsResult4 = new AlibcJsResult("6");
                alibcJsResult4.setResultCode("2");
                alibcJsCallbackContext.error(alibcJsResult4);
                return true;
            }
            AlibcAidComponent.genTaokeUrl(true, g(map), a, b(map), new AlibcTaokeTraceCallback() {
                /* class com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplinkPlugin.AnonymousClass1 */

                @Override // com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback
                public void getTaokeUrl(int i, String str) {
                    if (!TextUtils.isEmpty(str)) {
                        AlibcApplink.getInstance().jumpTBURI(application, str, "", AlibcApplinkPlugin.this.a(obj2String), AlibcApplinkPlugin.this.a(map), AlibcApplinkPlugin.this.f(map), AlibcApplinkPlugin.this.b(map), AlibcApplinkPlugin.this.g(map), new ALPSmartLinkCallback() {
                            /* class com.alibaba.baichuan.trade.biz.applink.adapter.AlibcApplinkPlugin.AnonymousClass1.AnonymousClass1 */

                            @Override // com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback
                            public void getLinkUrl(boolean z, String str, String str2, int i) {
                                if (z) {
                                    alibcJsCallbackContext.success(AlibcJsResult.RET_SUCCESS);
                                } else {
                                    alibcJsCallbackContext.error(AlibcJsResult.RET_FAIL);
                                }
                            }
                        });
                    }
                }
            });
            alibcJsCallbackContext.success(AlibcJsResult.RET_SUCCESS);
            return true;
        } else {
            AlibcJsResult alibcJsResult5 = new AlibcJsResult("6");
            alibcJsResult5.setResultCode("8");
            alibcJsCallbackContext.error(alibcJsResult5);
            return true;
        }
    }
}
