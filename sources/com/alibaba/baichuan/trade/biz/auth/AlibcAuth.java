package com.alibaba.baichuan.trade.biz.auth;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.Environment;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTradeHelper;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.StringUtils;
import com.alibaba.baichuan.trade.common.utils.http.HttpHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AlibcAuth {
    public static final int ERR_CODE = 104;
    public static final String ERR_MSG = "授权服务初始化失败";
    static Map<Integer, a> a = new ConcurrentHashMap();
    private static AlibcAuthRemote b;

    public static class a {
        public String a;
        public String b;
        public Set<String> c;
        public boolean d;
        public AlibcAuthListener e;

        public a() {
        }

        public a(String str, boolean z, AlibcAuthListener alibcAuthListener) {
            this.b = str;
            this.d = z;
            this.e = alibcAuthListener;
        }
    }

    static class b implements NetworkClient.NetworkRequestListener {
        private AlibcAuthListener a;
        private String b;
        private boolean c;

        public b(AlibcAuthListener alibcAuthListener, String str, boolean z) {
            this.a = alibcAuthListener;
            this.b = str;
            this.c = z;
        }

        @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient.NetworkRequestListener
        public void onError(int i, NetworkResponse networkResponse) {
            AlibcAuthListener alibcAuthListener = this.a;
            if (alibcAuthListener != null) {
                alibcAuthListener.onError(networkResponse.errorCode, networkResponse.errorMsg);
            }
            AlibcAuth.d(networkResponse.errorCode);
        }

        @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient.NetworkRequestListener
        public void onSuccess(int i, NetworkResponse networkResponse) {
            Map<String, Object> map = networkResponse.data;
            if (map == null || !networkResponse.isSuccess) {
                AlibcAuthListener alibcAuthListener = this.a;
                if (alibcAuthListener != null) {
                    alibcAuthListener.onError(networkResponse.errorCode, networkResponse.errorMsg);
                }
                AlibcAuth.d(networkResponse.errorCode);
                return;
            }
            AlibcUserTracker.getInstance().sendUsabilitySuccess("BCPCSDK", "Mtop_Auth", AlibcUserTradeHelper.getArgs());
            if (!this.c || TextUtils.equals(this.b, AlibcAuthInfo.getInstance().getAuthOldToken())) {
                AlibcAuthInfo.getInstance().setToken(map.get("token").toString(), StringUtils.obj2Long(map.get("expires")).longValue());
                AlibcAuthListener alibcAuthListener2 = this.a;
                if (alibcAuthListener2 != null) {
                    alibcAuthListener2.onSuccess();
                    return;
                }
                return;
            }
            AlibcAuthListener alibcAuthListener3 = this.a;
            if (alibcAuthListener3 != null) {
                alibcAuthListener3.onSuccess();
            }
        }
    }

    static List<String> a(String str) {
        AlibcAuthRemote alibcAuthRemote = b;
        if (alibcAuthRemote != null) {
            return alibcAuthRemote.getHintList(str);
        }
        return null;
    }

    private static void a(int i) {
        Intent intent = new Intent(AlibcTradeCommon.context, AlibcAuthActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("authId", i);
        AlibcTradeCommon.context.startActivity(intent);
    }

    static void a(final String str, final AlibcAuthListener alibcAuthListener, final boolean z, final boolean z2) {
        new AsyncTask<String, String, String>() {
            /* class com.alibaba.baichuan.trade.biz.auth.AlibcAuth.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public String doInBackground(String... strArr) {
                String format = AlibcTradeCommon.getEnvironment() == Environment.TEST ? String.format("http://100.69.205.47/authHint.htm?apiList=[\"%s\"]", str.replace("$", "_")) : AlibcTradeCommon.getEnvironment() == Environment.PRE ? String.format("http://pre.nbsdk-baichuan.taobao.com/authHint.htm?apiList=[\"%s\"]", str.replace("$", "_")) : String.format("https://nbsdk-baichuan.alicdn.com/authHint.htm?apiList=[\"%s\"]", str.replace("$", "_"));
                String str = "";
                try {
                    AlibcLogger.e("alibc", "getHint : url  " + format);
                    str = HttpHelper.get(format, null);
                    AlibcLogger.e("alibc", "getHint : url  " + format + " " + str);
                    return str;
                } catch (Exception e) {
                    e.printStackTrace();
                    return str;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void onPostExecute(String str) {
                Map<String, Object> obj2MapObject;
                try {
                    if (TextUtils.isEmpty(str)) {
                        alibcAuthListener.onError(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
                        return;
                    }
                    JSONObject parseObject = JSON.parseObject(str);
                    HashSet hashSet = null;
                    if (StringUtils.obj2Boolean(parseObject.get("success")) && (obj2MapObject = StringUtils.obj2MapObject(parseObject.get("authHintMap"))) != null && obj2MapObject.size() > 0) {
                        hashSet = new HashSet(obj2MapObject.size());
                        for (String str2 : obj2MapObject.keySet()) {
                            Map<String, String> obj2MapString = StringUtils.obj2MapString(obj2MapObject.get(str2));
                            if (obj2MapString != null) {
                                a.a(obj2MapString.get("hintId"), obj2MapString.get("hintName"));
                                hashSet.add(obj2MapString.get("hintId"));
                            }
                        }
                        a.a(str, hashSet);
                    }
                    if (hashSet != null) {
                        if (hashSet.size() > 0) {
                            if (z2) {
                                AlibcAuth.a(hashSet, alibcAuthListener, z);
                                return;
                            } else {
                                alibcAuthListener.onSuccess();
                                return;
                            }
                        }
                    }
                    alibcAuthListener.onError(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
                } catch (Exception e) {
                    alibcAuthListener.onError(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
                    e.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }

    static void a(Set<String> set, AlibcAuthListener alibcAuthListener, boolean z) {
        String authOldToken = AlibcAuthInfo.getInstance().getAuthOldToken();
        if (set != null || !TextUtils.isEmpty(authOldToken)) {
            new com.alibaba.baichuan.trade.biz.auth.a.a().a(set, authOldToken, new b(alibcAuthListener, authOldToken, z));
        } else if (alibcAuthListener != null) {
            alibcAuthListener.onError(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
        }
    }

    public static void auth(String str, String str2, boolean z, AlibcAuthListener alibcAuthListener) {
        List<String> c = c(str2);
        if (c == null || c.size() <= 0) {
            a aVar = new a(str2, z, alibcAuthListener);
            aVar.a = str;
            int hashCode = aVar.hashCode();
            a.put(Integer.valueOf(hashCode), aVar);
            if (z) {
                a(hashCode);
            } else {
                a(str, alibcAuthListener, false, true);
            }
        } else {
            auth(c, (String) null, z, alibcAuthListener);
        }
    }

    public static void auth(List<String> list, String str, boolean z, AlibcAuthListener alibcAuthListener) {
        List<String> c = c(str);
        HashSet hashSet = c == null ? null : new HashSet(c);
        if (hashSet != null) {
            hashSet.addAll(list);
        } else {
            hashSet = list == null ? new HashSet() : new HashSet(list);
        }
        if (hashSet == null || hashSet.size() <= 0) {
            alibcAuthListener.onError(AliAuthError.HINTLIST_NULL.code, AliAuthError.HINTLIST_NULL.msg);
            return;
        }
        a aVar = new a(str, z, alibcAuthListener);
        aVar.c = hashSet;
        int hashCode = aVar.hashCode();
        a.put(Integer.valueOf(hashCode), aVar);
        if (z) {
            a(hashCode);
        } else {
            a(hashSet, alibcAuthListener, false);
        }
    }

    public static void authRefresh() {
        a(null, null, true);
    }

    private static List<String> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }

    public static void cleanAuth() {
        AlibcAuthInfo.getInstance().cleanToken();
    }

    /* access modifiers changed from: private */
    public static void d(String str) {
        String str2 = AliAuthError.mMtopErrorCode.get(str);
        if (str2 == null) {
            str2 = "00";
        }
        AlibcUserTracker instance = AlibcUserTracker.getInstance();
        String args = AlibcUserTradeHelper.getArgs();
        instance.sendUsabilityFailure("BCPCSDK", "Mtop_Auth", args, "2101" + str2, "授权失败");
    }

    public static boolean init() {
        AlibcLogger.d("Alibc", "AlibcAuth init");
        RemoteAuth.setAuthImpl(b.a());
        return true;
    }

    public static void postHintList(String str, String str2) {
        List<String> c = c(str2);
        AlibcAuthRemote alibcAuthRemote = b;
        if (alibcAuthRemote != null && c != null) {
            alibcAuthRemote.postHintList(str, c);
        }
    }

    public static void registAuthEvent(AlibcAuthRemote alibcAuthRemote) {
        b = alibcAuthRemote;
    }

    public static void unregistAuthEvent() {
        b = null;
    }
}
