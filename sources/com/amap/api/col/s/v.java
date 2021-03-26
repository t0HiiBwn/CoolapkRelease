package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* compiled from: NearbyUpdateHandler */
public final class v extends b<UploadInfo, Integer> {
    private Context j;
    private UploadInfo k;

    public v(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.j = context;
        this.k = uploadInfo;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.j));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.k.getUserID());
        LatLonPoint point = this.k.getPoint();
        stringBuffer.append("&location=");
        stringBuffer.append(((float) ((int) (point.getLongitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(((float) ((int) (point.getLatitude() * 1000000.0d))) / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.k.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.c() + "/nearby/data/create";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return 0;
    }
}
