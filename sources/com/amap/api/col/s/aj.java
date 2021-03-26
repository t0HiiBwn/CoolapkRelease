package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RoutePOISearchHandler */
public final class aj extends b<RoutePOISearchQuery, RoutePOISearchResult> {
    public aj(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0021: INVOKE  (r2v2 int) = 
      (wrap: com.amap.api.services.routepoisearch.RoutePOISearchQuery : 0x001f: CHECK_CAST (r2v1 com.amap.api.services.routepoisearch.RoutePOISearchQuery) = (com.amap.api.services.routepoisearch.RoutePOISearchQuery) (wrap: java.lang.Object : 0x001d: IGET  (r2v0 java.lang.Object) = (r4v0 'this' com.amap.api.col.s.aj A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.aj.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.routepoisearch.RoutePOISearchQuery.getRange():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x00bb: INVOKE  (r3v2 int) = 
      (wrap: com.amap.api.services.routepoisearch.RoutePOISearchQuery : 0x00b9: CHECK_CAST (r3v1 com.amap.api.services.routepoisearch.RoutePOISearchQuery) = (com.amap.api.services.routepoisearch.RoutePOISearchQuery) (wrap: java.lang.Object : 0x00b7: IGET  (r3v0 java.lang.Object) = (r4v0 'this' com.amap.api.col.s.aj A[IMMUTABLE_TYPE, THIS]) com.amap.api.col.s.aj.b java.lang.Object))
     type: VIRTUAL call: com.amap.api.services.routepoisearch.RoutePOISearchQuery.getMode():int)] */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.e));
        stringBuffer.append("&range=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RoutePOISearchQuery) this.b).getRange());
        stringBuffer.append(sb.toString());
        String str = "";
        try {
            switch (AnonymousClass1.a[((RoutePOISearchQuery) this.b).getSearchType().ordinal()]) {
                case 1:
                    str = "0101";
                    break;
                case 2:
                    str = "0300";
                    break;
                case 3:
                    str = "1603";
                    break;
                case 4:
                    str = "2003";
                    break;
                case 5:
                    str = "0103";
                    break;
                case 6:
                    str = "180301";
                    break;
            }
        } catch (Exception unused) {
        }
        if (((RoutePOISearchQuery) this.b).getPolylines() == null || ((RoutePOISearchQuery) this.b).getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RoutePOISearchQuery) this.b).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RoutePOISearchQuery) this.b).getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((RoutePOISearchQuery) this.b).getMode());
            stringBuffer.append(sb2.toString());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(i.a(((RoutePOISearchQuery) this.b).getPolylines()));
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    /* renamed from: com.amap.api.col.s.aj$1  reason: invalid class name */
    /* compiled from: RoutePOISearchHandler */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoutePOISearch.RoutePOISearchType.values().length];
            a = iArr;
            try {
                iArr[RoutePOISearch.RoutePOISearchType.TypeGasStation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoutePOISearch.RoutePOISearchType.TypeMaintenanceStation.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoutePOISearch.RoutePOISearchType.TypeATM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoutePOISearch.RoutePOISearchType.TypeToilet.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoutePOISearch.RoutePOISearchType.TypeFillingStation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoutePOISearch.RoutePOISearchType.TypeServiceArea.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public RoutePOISearchResult a(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = p.i(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.b);
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.a() + "/place/route?";
    }
}
