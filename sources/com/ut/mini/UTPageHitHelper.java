package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.base.UTMIVariables;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UTPageHitHelper {
    private static UTPageHitHelper a = new UTPageHitHelper();
    private Map<String, UTPageEventObject> A = new HashMap();
    private Map<String, String> B = new HashMap();
    private Map<Object, String> C = new HashMap();
    private boolean O = false;

    /* renamed from: a  reason: collision with other field name */
    private Queue<UTPageEventObject> f96a = new LinkedList();
    private String ah = null;
    private String ai = null;
    private Map<String, String> z = new HashMap();

    public static class UTPageEventObject {
        private long A = 0;
        private boolean P = false;
        private boolean Q = false;
        private boolean R = false;
        private Uri a = null;

        /* renamed from: a  reason: collision with other field name */
        private UTPageStatus f97a = null;
        private String aj = null;
        private String ak = null;
        private String al = null;
        private Map<String, String> z = new HashMap();

        public void setCacheKey(String str) {
            this.al = str;
        }

        public String getCacheKey() {
            return this.al;
        }

        public void resetPropertiesWithoutSkipFlagAndH5Flag() {
            this.z = new HashMap();
            this.A = 0;
            this.a = null;
            this.aj = null;
            this.ak = null;
            UTPageStatus uTPageStatus = this.f97a;
            if (uTPageStatus == null || uTPageStatus != UTPageStatus.UT_H5_IN_WebView) {
                this.f97a = null;
            }
            this.P = false;
            this.R = false;
        }

        public boolean isH5Called() {
            return this.R;
        }

        public void setH5Called() {
            this.R = true;
        }

        public void setToSkipPage() {
            this.Q = true;
        }

        public boolean isSkipPage() {
            return this.Q;
        }

        public void setPageAppearCalled() {
            this.P = true;
        }

        public boolean isPageAppearCalled() {
            return this.P;
        }

        public void setPageStatus(UTPageStatus uTPageStatus) {
            this.f97a = uTPageStatus;
        }

        public UTPageStatus getPageStatus() {
            return this.f97a;
        }

        public Map<String, String> getPageProperties() {
            return this.z;
        }

        public void setPageProperties(Map<String, String> map) {
            this.z = map;
        }

        public long getPageStayTimstamp() {
            return this.A;
        }

        public void setPageStayTimstamp(long j) {
            this.A = j;
        }

        public Uri getPageUrl() {
            return this.a;
        }

        public void setPageUrl(Uri uri) {
            this.a = uri;
        }

        public void setPageName(String str) {
            this.aj = str;
        }

        public String getPageName() {
            return this.aj;
        }

        public void setRefPage(String str) {
            this.ak = str;
        }

        public String getRefPage() {
            return this.ak;
        }
    }

    public static UTPageHitHelper getInstance() {
        return a;
    }

    synchronized Map<String, String> c() {
        Map<String, String> map = this.B;
        if (map == null || map.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.B);
        this.B.clear();
        return hashMap;
    }

    synchronized void a(UTPageEventObject uTPageEventObject) {
        uTPageEventObject.resetPropertiesWithoutSkipFlagAndH5Flag();
        if (!this.f96a.contains(uTPageEventObject)) {
            this.f96a.add(uTPageEventObject);
        }
        if (this.f96a.size() > 200) {
            for (int i = 0; i < 100; i++) {
                UTPageEventObject poll = this.f96a.poll();
                if (poll != null && this.A.containsKey(poll.getCacheKey())) {
                    this.A.remove(poll.getCacheKey());
                }
            }
        }
    }

    @Deprecated
    public synchronized void turnOffAutoPageTrack() {
        this.O = true;
    }

    public String getCurrentPageName() {
        return this.ai;
    }

    void pageAppearByAuto(Activity activity) {
        if (!this.O) {
            pageAppear(activity);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m35a(Object obj) {
        String str;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = obj.getClass().getSimpleName();
        }
        int hashCode = obj.hashCode();
        return str + hashCode;
    }

    /* renamed from: a  reason: collision with other method in class */
    synchronized boolean m38a(Object obj) {
        if (obj != null) {
            UTPageEventObject a2 = a(obj);
            if (a2.getPageStatus() != null && a2.getPageStatus() == UTPageStatus.UT_H5_IN_WebView) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    synchronized void m37a(Object obj) {
        if (obj != null) {
            UTPageEventObject a2 = a(obj);
            if (a2.getPageStatus() != null) {
                a2.setH5Called();
            }
        }
    }

    private synchronized UTPageEventObject a(Object obj) {
        String a2 = m35a(obj);
        if (this.A.containsKey(a2)) {
            return this.A.get(a2);
        }
        UTPageEventObject uTPageEventObject = new UTPageEventObject();
        this.A.put(a2, uTPageEventObject);
        uTPageEventObject.setCacheKey(a2);
        return uTPageEventObject;
    }

    private synchronized void a(String str, UTPageEventObject uTPageEventObject) {
        this.A.put(str, uTPageEventObject);
    }

    private synchronized void b(UTPageEventObject uTPageEventObject) {
        if (this.A.containsKey(uTPageEventObject.getCacheKey())) {
            this.A.remove(uTPageEventObject.getCacheKey());
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private synchronized void m36b(Object obj) {
        String a2 = m35a(obj);
        if (this.A.containsKey(a2)) {
            this.A.remove(a2);
        }
    }

    @Deprecated
    public synchronized void pageAppear(Object obj) {
        a(obj, null, false);
    }

    synchronized void a(Object obj, String str, boolean z2) {
        if (obj != null) {
            String a2 = m35a(obj);
            if (a2 == null || !a2.equals(this.ah)) {
                if (this.ah != null) {
                    i.a("lost 2001", "Last page requires leave(" + this.ah + ").");
                }
                UTPageEventObject a3 = a(obj);
                if (z2 || !a3.isSkipPage()) {
                    String h5Url = UTMIVariables.getInstance().getH5Url();
                    if (h5Url != null) {
                        try {
                            this.z.put("spm", Uri.parse(h5Url).getQueryParameter("spm"));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        UTMIVariables.getInstance().setH5Url(null);
                    }
                    String b = b(obj);
                    if (TextUtils.isEmpty(str)) {
                        str = b;
                    }
                    if (!TextUtils.isEmpty(a3.getPageName())) {
                        str = a3.getPageName();
                    }
                    this.ai = str;
                    a3.setPageName(str);
                    a3.setPageStayTimstamp(SystemClock.elapsedRealtime());
                    a3.setRefPage(UTMIVariables.getInstance().getRefPage());
                    a3.setPageAppearCalled();
                    if (this.B != null) {
                        Map<String, String> pageProperties = a3.getPageProperties();
                        if (pageProperties == null) {
                            a3.setPageProperties(this.B);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.putAll(pageProperties);
                            hashMap.putAll(this.B);
                            a3.setPageProperties(hashMap);
                        }
                    }
                    this.B = null;
                    this.ah = m35a(obj);
                    b(a3);
                    a(m35a(obj), a3);
                } else {
                    i.a("skip page[pageAppear]", "page name:" + obj.getClass().getSimpleName());
                }
            }
        } else {
            i.a("pageAppear", "The page object should not be null");
        }
    }

    synchronized void pageAppear(Object obj, String str) {
        a(obj, str, false);
    }

    @Deprecated
    public synchronized void updatePageProperties(Map<String, String> map) {
        if (map != null) {
            this.z.putAll(map);
        }
    }

    synchronized void updatePageProperties(Object obj, Map<String, String> map) {
        if (!(obj == null || map == null)) {
            if (map.size() != 0) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                UTPageEventObject a2 = a(obj);
                Map<String, String> pageProperties = a2.getPageProperties();
                if (pageProperties == null) {
                    a2.setPageProperties(hashMap);
                } else {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.putAll(pageProperties);
                    hashMap2.putAll(hashMap);
                    a2.setPageProperties(hashMap2);
                }
                return;
            }
        }
        i.a("updatePageProperties", "failed to update project, parameters should not be null and the map should not be empty");
    }

    synchronized void updatePageName(Object obj, String str) {
        if (obj != null) {
            if (!TextUtils.isEmpty(str)) {
                a(obj).setPageName(str);
                this.ai = str;
            }
        }
    }

    synchronized void updatePageUrl(Object obj, Uri uri) {
        if (obj != null && uri != null) {
            Log.i("url", "url" + uri.toString());
            a(obj).setPageUrl(uri);
        }
    }

    synchronized void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        if (obj != null && uTPageStatus != null) {
            a(obj).setPageStatus(uTPageStatus);
        }
    }

    synchronized void updateNextPageProperties(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            this.B = hashMap;
        }
    }

    void pageDisAppearByAuto(Activity activity) {
        if (!this.O) {
            pageDisAppear(activity);
        }
    }

    synchronized void skipPage(Object obj) {
        if (obj != null) {
            a(obj).setToSkipPage();
        }
    }

    @Deprecated
    public synchronized void pageDisAppear(Object obj) {
        if (obj == null) {
            i.a("pageDisAppear", "The page object should not be null");
        } else if (this.ah != null) {
            UTPageEventObject a2 = a(obj);
            if (!a2.isPageAppearCalled()) {
                i.a("UT", "Please call pageAppear first(" + b(obj) + ").");
            } else if (a2.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != a2.getPageStatus() || !a2.isH5Called()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a2.getPageStayTimstamp();
                if (a2.getPageUrl() == null && (obj instanceof Activity) && ((Activity) obj).getIntent() != null) {
                    a2.setPageUrl(((Activity) obj).getIntent().getData());
                }
                String pageName = a2.getPageName();
                String refPage = a2.getRefPage();
                if (refPage == null || refPage.length() == 0) {
                    refPage = "-";
                }
                Map<String, String> map = this.z;
                if (map == null) {
                    map = new HashMap<>();
                }
                if (a2.getPageProperties() != null) {
                    map.putAll(a2.getPageProperties());
                }
                if (obj instanceof IUTPageTrack) {
                    IUTPageTrack iUTPageTrack = (IUTPageTrack) obj;
                    String referPage = iUTPageTrack.getReferPage();
                    if (!TextUtils.isEmpty(referPage)) {
                        refPage = referPage;
                    }
                    Map<String, String> pageProperties = iUTPageTrack.getPageProperties();
                    if (pageProperties != null && pageProperties.size() > 0) {
                        this.z.putAll(pageProperties);
                        map = this.z;
                    }
                    String pageName2 = iUTPageTrack.getPageName();
                    if (!TextUtils.isEmpty(pageName2)) {
                        pageName = pageName2;
                    }
                }
                Uri pageUrl = a2.getPageUrl();
                if (pageUrl != null) {
                    try {
                        HashMap hashMap = new HashMap();
                        String queryParameter = pageUrl.getQueryParameter("spm");
                        if (TextUtils.isEmpty(queryParameter)) {
                            try {
                                pageUrl = Uri.parse(URLDecoder.decode(pageUrl.toString(), "UTF-8"));
                                queryParameter = pageUrl.getQueryParameter("spm");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                        if (!TextUtils.isEmpty(queryParameter)) {
                            boolean z2 = false;
                            if (this.C.containsKey(obj) && queryParameter.equals(this.C.get(obj))) {
                                z2 = true;
                            }
                            if (!z2) {
                                hashMap.put("spm", queryParameter);
                                this.C.put(obj, queryParameter);
                            }
                        }
                        String queryParameter2 = pageUrl.getQueryParameter("scm");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            hashMap.put("scm", queryParameter2);
                        }
                        String a3 = a(pageUrl);
                        if (!TextUtils.isEmpty(a3)) {
                            c.a().e(a3);
                        }
                        if (hashMap.size() > 0) {
                            map.putAll(hashMap);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                UTHitBuilders.UTPageHitBuilder uTPageHitBuilder = new UTHitBuilders.UTPageHitBuilder(pageName);
                uTPageHitBuilder.setReferPage(refPage).setDurationOnPage(elapsedRealtime).setProperties(map);
                UTMIVariables.getInstance().setRefPage(pageName);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTPageHitBuilder.build());
                } else {
                    i.a("Record page event error", "Fatal Error,must call setRequestAuthentication method first.");
                }
            } else {
                a(a2);
                return;
            }
            this.z = new HashMap();
            if (a2.isSkipPage()) {
                a(a2);
            } else if (a2.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != a2.getPageStatus()) {
                m36b(obj);
            } else {
                a(a2);
            }
            this.ah = null;
            this.ai = null;
        }
    }

    private static String a(Uri uri) {
        List<String> queryParameters;
        if (uri == null || (queryParameters = uri.getQueryParameters("ttid")) == null) {
            return null;
        }
        for (String str : queryParameters) {
            if (!(str.contains("@") || str.contains("%40"))) {
                return str;
            }
        }
        return null;
    }

    private static String b(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return (simpleName == null || !simpleName.toLowerCase().endsWith("activity")) ? simpleName : simpleName.substring(0, simpleName.length() - 8);
    }
}
