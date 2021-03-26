package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public class a {
    protected HashMap<String, b> a = new HashMap<>();

    /* renamed from: com.tencent.open.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    public static class C0134a {
        protected WeakReference<WebView> a;
        protected long b;
        protected String c;

        public C0134a(WebView webView, long j, String str) {
            this.a = new WeakReference<>(webView);
            this.b = j;
            this.c = str;
        }

        public void a(Object obj) {
            String str;
            WebView webView = this.a.get();
            if (webView != null) {
                if (obj instanceof String) {
                    String replace = ((String) obj).replace("\\", "\\\\").replace("'", "\\'");
                    str = "'" + ((Object) replace) + "'";
                } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                    str = obj.toString();
                } else {
                    str = obj instanceof Boolean ? obj.toString() : "'undefined'";
                }
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':0,'result':" + str + "});");
            }
        }

        public void a() {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.b + ",{'r':1,'result':'no such method'})");
            }
        }

        public void a(String str) {
            WebView webView = this.a.get();
            if (webView != null) {
                webView.loadUrl("javascript:" + str);
            }
        }
    }

    /* compiled from: ProGuard */
    public static class b {
        public boolean customCallback() {
            return false;
        }

        public void call(String str, List<String> list, C0134a aVar) {
            String str2;
            Method method;
            Object obj;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                str2 = null;
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i++;
            }
            if (method != null) {
                try {
                    int size = list.size();
                    if (size == 0) {
                        obj = method.invoke(this, new Object[0]);
                    } else if (size == 1) {
                        obj = method.invoke(this, list.get(0));
                    } else if (size == 2) {
                        obj = method.invoke(this, list.get(0), list.get(1));
                    } else if (size == 3) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2));
                    } else if (size == 4) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3));
                    } else if (size != 5) {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
                    } else {
                        obj = method.invoke(this, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                    }
                    Class<?> returnType = method.getReturnType();
                    f.b("openSDK_LOG.JsBridge", "-->call, result: " + obj + " | ReturnType: " + returnType.getName());
                    if (!"void".equals(returnType.getName())) {
                        if (returnType != Void.class) {
                            if (aVar != null && customCallback()) {
                                if (obj != null) {
                                    str2 = obj.toString();
                                }
                                aVar.a(str2);
                                return;
                            }
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.a((Object) null);
                    }
                } catch (Exception e) {
                    f.b("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            } else if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a(b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, C0134a aVar) {
        f.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode(list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = this.a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, aVar);
            return;
        }
        f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean a(WebView webView, String str) {
        f.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        List<String> subList = arrayList.subList(4, arrayList.size() - 1);
        C0134a aVar = new C0134a(webView, 4, str);
        webView.getUrl();
        a((String) arrayList.get(2), (String) arrayList.get(3), subList, aVar);
        return true;
    }
}
