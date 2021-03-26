package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.model.TileProvider;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: TileServerHandler */
class bw extends bj<ArrayList<bs>, ArrayList<bs>> {
    private an f = null;
    private TileProvider g;

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> g() {
        return null;
    }

    public bw(ArrayList<bs> arrayList, TileProvider tileProvider) {
        super(arrayList);
        this.g = tileProvider;
        a(cy.a(ar.a));
        a(5000);
        b(50000);
    }

    public void a(an anVar) {
        this.f = anVar;
    }

    @Override // com.amap.api.mapcore2d.bj
    protected byte[] b() throws AMapException {
        TileProvider tileProvider = this.g;
        if (tileProvider != null) {
            return tileProvider.getTile(((bs) ((ArrayList) this.b).get(0)).b, ((bs) ((ArrayList) this.b).get(0)).c, ((bs) ((ArrayList) this.b).get(0)).d).data;
        }
        return super.b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public ArrayList<bs> d() {
        ArrayList<bs> arrayList = new ArrayList<>();
        Iterator it2 = ((ArrayList) this.b).iterator();
        while (it2.hasNext()) {
            arrayList.add(new bs((bs) it2.next()));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ArrayList<bs> a(byte[] bArr) throws AMapException {
        ArrayList<bs> arrayList = null;
        if (!(this.b == null || bArr == null)) {
            try {
                int size = ((ArrayList) this.b).size();
                for (int i = 0; i < size; i++) {
                    bs bsVar = (bs) ((ArrayList) this.b).get(i);
                    if (a(bArr, bsVar) < 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        bs bsVar2 = new bs(bsVar);
                        if (this.f.h && bsVar2.d > 9 && !cl.a(bsVar2.b, bsVar2.c, bsVar2.d)) {
                            bsVar2.i = true;
                        }
                        arrayList.add(bsVar2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public int a(byte[] bArr, bs bsVar) {
        an anVar;
        Throwable th;
        int i = -1;
        if (bsVar == null || bArr == null || (anVar = this.f) == null || anVar.n == null) {
            return -1;
        }
        try {
            int a = this.f.n.a(null, bArr, false, null, bsVar.c());
            if (a < 0) {
                return -1;
            }
            try {
                a(bsVar, a);
                an anVar2 = this.f;
                if (anVar2 == null || !anVar2.f) {
                    return a;
                }
                byte[] a2 = a(this.f.n.a(a));
                an anVar3 = this.f;
                if (anVar3 == null || anVar3.o == null) {
                    return a;
                }
                this.f.o.a(a2, bsVar);
                return a;
            } catch (Throwable th2) {
                th = th2;
                i = a;
                cm.a(th, "TileServerHandler", "saveImgToMemory");
                return i;
            }
        } catch (Throwable th3) {
            th = th3;
            cm.a(th, "TileServerHandler", "saveImgToMemory");
            return i;
        }
    }

    private byte[] a(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            cm.a(th, "TileServerHandler", "Bitmap2Bytes");
            return null;
        }
    }

    private void a(bs bsVar, int i) {
        an anVar;
        if (bsVar != null && i >= 0 && (anVar = this.f) != null && anVar.p != null) {
            bn<bs> bnVar = this.f.p;
            synchronized (this.f) {
                int size = bnVar.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (i2 < bnVar.size()) {
                        bs bsVar2 = bnVar.get(i2);
                        if (bsVar2 != null) {
                            if (bsVar2.equals(bsVar)) {
                                bsVar2.h = i;
                                break;
                            }
                        }
                    }
                    i2++;
                }
            }
        }
    }

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", "AMAP_SDK_Android_2DMap_6.0.0");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "6.0.0", "2dmap"));
        hashMap.put("X-INFO", ct.a(ar.a));
        hashMap.put("key", cq.f(ar.a));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.mapcore2d.ew
    public String h() {
        int i = ((bs) ((ArrayList) this.b).get(0)).b;
        int i2 = ((bs) ((ArrayList) this.b).get(0)).c;
        int i3 = ((bs) ((ArrayList) this.b).get(0)).d;
        if (q.i == 0 && i3 > 9 && !cl.a(i, i2, i3)) {
            return String.format(Locale.US, ax.a().d(), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
        }
        int pow = (int) Math.pow(2.0d, (double) ((bs) ((ArrayList) this.b).get(0)).d);
        int i4 = ((bs) ((ArrayList) this.b).get(0)).b;
        if (i4 >= pow) {
            i4 -= pow;
        } else if (i4 < 0) {
            i4 += pow;
        }
        String a = this.f.j.a(i4, i2, i3);
        if (TextUtils.isEmpty(q.h)) {
            a = a + a(a);
        }
        ((bs) ((ArrayList) this.b).get(0)).b();
        return a;
    }

    public String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str) && !str.startsWith(ax.a().c())) {
            stringBuffer.append("&key=");
            stringBuffer.append(cq.f(ar.a));
        }
        stringBuffer.append("&channel=amapapi");
        return stringBuffer.toString();
    }
}
