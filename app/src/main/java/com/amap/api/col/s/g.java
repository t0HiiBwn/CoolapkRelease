package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchKeywordsHandler */
public final class g extends e<CloudSearch.Query, CloudResult> {
    private int j = 0;

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        return null;
    }

    public g(Context context, CloudSearch.Query query) {
        super(context, query);
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        String str = h.d() + "/datasearch";
        String shape = ((CloudSearch.Query) this.b).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        } else if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon";
        } else if (!shape.equals("Local")) {
            return str;
        } else {
            return str + "/local";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str == null || str.equals("")) {
            return CloudResult.createPagedResult((CloudSearch.Query) this.b, this.j, ((CloudSearch.Query) this.b).getBound(), ((CloudSearch.Query) this.b).getPageSize(), null);
        }
        try {
            arrayList = c(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return CloudResult.createPagedResult((CloudSearch.Query) this.b, this.j, ((CloudSearch.Query) this.b).getBound(), ((CloudSearch.Query) this.b).getPageSize(), arrayList);
    }

    private ArrayList<CloudItem> c(JSONObject jSONObject) throws JSONException {
        int i;
        JSONObject optJSONObject;
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray a = a(jSONObject);
        if (a == null) {
            return arrayList;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
            i = 0;
        } else {
            i = optJSONObject.optInt("count");
        }
        this.j = i;
        for (int i2 = 0; i2 < a.length(); i2++) {
            JSONObject optJSONObject3 = a.optJSONObject(i2);
            CloudItemDetail b = b(optJSONObject3);
            a(b, optJSONObject3);
            arrayList.add(b);
        }
        return arrayList;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01dd: INVOKE  (r2v11 int) = 
      (wrap: com.amap.api.services.cloud.CloudSearch$Query : 0x01db: CHECK_CAST (r2v10 com.amap.api.services.cloud.CloudSearch$Query) = (com.amap.api.services.cloud.CloudSearch$Query) (wrap: java.lang.Object : 0x01d9: IGET  (r2v9 java.lang.Object) = (r14v0 'this' com.amap.api.col.s.g A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.g.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.cloud.CloudSearch.Query.getPageSize():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01f6: INVOKE  (r2v15 int) = 
      (wrap: com.amap.api.services.cloud.CloudSearch$Query : 0x01f4: CHECK_CAST (r2v14 com.amap.api.services.cloud.CloudSearch$Query) = (com.amap.api.services.cloud.CloudSearch$Query) (wrap: java.lang.Object : 0x01f2: IGET  (r2v13 java.lang.Object) = (r14v0 'this' com.amap.api.col.s.g A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.g.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.cloud.CloudSearch.Query.getPageNum():int)] */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", bi.f(this.e));
        hashtable.put("output", "json");
        if (((CloudSearch.Query) this.b).getBound() != null) {
            if (((CloudSearch.Query) this.b).getBound().getShape().equals("Bound")) {
                double a = i.a(((CloudSearch.Query) this.b).getBound().getCenter().getLongitude());
                double a2 = i.a(((CloudSearch.Query) this.b).getBound().getCenter().getLatitude());
                hashtable.put("center", a + "," + a2);
                StringBuilder sb = new StringBuilder();
                sb.append(((CloudSearch.Query) this.b).getBound().getRange());
                hashtable.put("radius", sb.toString());
            } else if (((CloudSearch.Query) this.b).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.b).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.b).getBound().getUpperRight();
                double a3 = i.a(lowerLeft.getLatitude());
                double a4 = i.a(lowerLeft.getLongitude());
                double a5 = i.a(upperRight.getLatitude());
                double a6 = i.a(upperRight.getLongitude());
                hashtable.put("polygon", a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((CloudSearch.Query) this.b).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.b).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", i.a(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) this.b).getBound().getShape().equals("Local")) {
                hashtable.put("city", ((CloudSearch.Query) this.b).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) this.b).getTableID());
        if (!i.a(i())) {
            hashtable.put("sortrule", i());
        }
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.b).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.b).getFilterNumString();
        stringBuffer.append(filterString);
        if (!i.a(filterString) && !i.a(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        String stringBuffer2 = stringBuffer.toString();
        if (!i.a(stringBuffer2)) {
            hashtable.put("filter", stringBuffer2);
        }
        String queryString = ((CloudSearch.Query) this.b).getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put("keywords", "");
        } else {
            hashtable.put("keywords", queryString);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((CloudSearch.Query) this.b).getPageSize());
        hashtable.put("pageSize", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) this.b).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String a7 = bl.a();
        String a8 = bl.a(this.e, a7, d(a(hashtable)));
        hashtable.put("ts", a7);
        hashtable.put("scode", a8);
        return hashtable;
    }

    private static String d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str != null) {
                str = str.replace("&&", "%26%26");
            }
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2 != null) {
                stringBuffer2 = stringBuffer2.replace("%26%26", "&&");
            }
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            cd.a(th, "ut", "sPa");
        }
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private String i() {
        return ((CloudSearch.Query) this.b).getSortingrules() != null ? ((CloudSearch.Query) this.b).getSortingrules().toString() : "";
    }
}
