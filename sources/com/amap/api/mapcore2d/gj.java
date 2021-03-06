package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: MapParser */
public final class gj {
    private StringBuilder a = new StringBuilder();

    public final gg a(String str, Context context, ey eyVar) {
        gg ggVar = new gg("");
        ggVar.setErrorCode(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                StringBuilder sb = this.a;
                sb.append("json is error " + str);
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            if (string.equals("0")) {
                StringBuilder sb2 = this.a;
                sb2.append("auth fail:" + string2);
            }
        } catch (Throwable th) {
            StringBuilder sb3 = this.a;
            sb3.append("json exception error:" + th.getMessage());
            gu.a(th, "MapParser", "paseAuthFailurJson");
        }
        try {
            StringBuilder sb4 = this.a;
            sb4.append("#SHA1AndPackage#");
            sb4.append(cq.e(context));
            String str2 = eyVar.b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb5 = this.a;
                sb5.append(" #gsid#");
                sb5.append(str2);
            }
            String str3 = eyVar.c;
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb6 = this.a;
                sb6.append(" #csid#" + str3);
            }
        } catch (Throwable unused) {
        }
        ggVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            StringBuilder sb7 = this.a;
            sb7.delete(0, sb7.length());
        }
        return ggVar;
    }

    public final gg a(byte[] bArr) {
        gg ggVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ByteBuffer byteBuffer = null;
        try {
            ggVar = new gg("");
            if (bArr == null) {
                ggVar.setErrorCode(5);
                this.a.append("byte[] is null");
                ggVar.setLocationDetail(this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
                return ggVar;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.get() == 0) {
                ggVar.b(String.valueOf((int) wrap.getShort()));
                wrap.clear();
                if (wrap != null) {
                    wrap.clear();
                }
                return ggVar;
            }
            ggVar.setLongitude(gy.a(((double) wrap.getInt()) / 1000000.0d));
            ggVar.setLatitude(gy.a(((double) wrap.getInt()) / 1000000.0d));
            ggVar.setAccuracy((float) wrap.getShort());
            ggVar.c(String.valueOf((int) wrap.get()));
            ggVar.d(String.valueOf((int) wrap.get()));
            if (wrap.get() == 1) {
                byte[] bArr2 = new byte[(wrap.get() & 255)];
                wrap.get(bArr2);
                try {
                    ggVar.setCountry(new String(bArr2, "UTF-8"));
                } catch (Throwable unused) {
                }
                byte[] bArr3 = new byte[(wrap.get() & 255)];
                wrap.get(bArr3);
                try {
                    str = new String(bArr3, "UTF-8");
                    try {
                        ggVar.setProvince(str);
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    str = "";
                }
                byte[] bArr4 = new byte[(wrap.get() & 255)];
                wrap.get(bArr4);
                try {
                    str2 = new String(bArr4, "UTF-8");
                    try {
                        ggVar.setCity(str2);
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable unused5) {
                    str2 = "";
                }
                byte[] bArr5 = new byte[(wrap.get() & 255)];
                wrap.get(bArr5);
                try {
                    str3 = new String(bArr5, "UTF-8");
                    try {
                        ggVar.setDistrict(str3);
                    } catch (Throwable unused6) {
                    }
                } catch (Throwable unused7) {
                    str3 = "";
                }
                byte[] bArr6 = new byte[(wrap.get() & 255)];
                wrap.get(bArr6);
                try {
                    str4 = new String(bArr6, "UTF-8");
                    try {
                        ggVar.setStreet(str4);
                        ggVar.setRoad(str4);
                    } catch (Throwable unused8) {
                    }
                } catch (Throwable unused9) {
                    str4 = "";
                }
                byte[] bArr7 = new byte[(wrap.get() & 255)];
                wrap.get(bArr7);
                try {
                    ggVar.setNumber(new String(bArr7, "UTF-8"));
                } catch (Throwable unused10) {
                }
                byte[] bArr8 = new byte[(wrap.get() & 255)];
                wrap.get(bArr8);
                try {
                    str5 = new String(bArr8, "UTF-8");
                    try {
                        ggVar.setPoiName(str5);
                    } catch (Throwable unused11) {
                    }
                } catch (Throwable unused12) {
                    str5 = "";
                }
                byte[] bArr9 = new byte[(wrap.get() & 255)];
                wrap.get(bArr9);
                try {
                    ggVar.setAoiName(new String(bArr9, "UTF-8"));
                } catch (Throwable unused13) {
                }
                byte[] bArr10 = new byte[(wrap.get() & 255)];
                wrap.get(bArr10);
                try {
                    str6 = new String(bArr10, "UTF-8");
                    try {
                        ggVar.setAdCode(str6);
                    } catch (Throwable unused14) {
                    }
                } catch (Throwable unused15) {
                    str6 = "";
                }
                byte[] bArr11 = new byte[(wrap.get() & 255)];
                wrap.get(bArr11);
                try {
                    ggVar.setCityCode(new String(bArr11, "UTF-8"));
                } catch (Throwable unused16) {
                }
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(str);
                    sb2.append(" ");
                }
                if (!TextUtils.isEmpty(str2) && (!str.contains("???") || !str.equals(str2))) {
                    sb2.append(str2);
                    sb2.append(" ");
                }
                if (!TextUtils.isEmpty(str3)) {
                    sb2.append(str3);
                    sb2.append(" ");
                }
                if (!TextUtils.isEmpty(str4)) {
                    sb2.append(str4);
                    sb2.append(" ");
                }
                if (!TextUtils.isEmpty(str5)) {
                    if (!TextUtils.isEmpty(str6)) {
                        sb2.append("??????");
                    }
                    sb2.append(str5);
                    sb2.append(" ");
                }
                Bundle bundle = new Bundle();
                bundle.putString("citycode", ggVar.getCityCode());
                bundle.putString("desc", sb2.toString());
                bundle.putString("adcode", ggVar.getAdCode());
                ggVar.setExtras(bundle);
                ggVar.e(sb2.toString());
                String adCode = ggVar.getAdCode();
                ggVar.setAddress((adCode == null || adCode.trim().length() <= 0) ? sb2.toString() : sb2.toString().replace(" ", ""));
            }
            wrap.get(new byte[(wrap.get() & 255)]);
            if (wrap.get() == 1) {
                wrap.getInt();
                wrap.getInt();
                wrap.getShort();
            }
            if (wrap.get() == 1) {
                byte[] bArr12 = new byte[(wrap.get() & 255)];
                wrap.get(bArr12);
                try {
                    ggVar.setBuildingId(new String(bArr12, "UTF-8"));
                } catch (Throwable unused17) {
                }
                byte[] bArr13 = new byte[(wrap.get() & 255)];
                wrap.get(bArr13);
                try {
                    ggVar.setFloor(new String(bArr13, "UTF-8"));
                } catch (Throwable unused18) {
                }
            }
            if (wrap.get() == 1) {
                wrap.get();
                wrap.getInt();
                wrap.get();
            }
            if (wrap.get() == 1) {
                ggVar.setTime(wrap.getLong());
            }
            byte[] bArr14 = new byte[wrap.getShort()];
            wrap.get(bArr14);
            try {
                ggVar.a(new String(bArr14, "UTF-8"));
            } catch (Throwable unused19) {
            }
            if (wrap != null) {
                wrap.clear();
            }
            if (this.a.length() > 0) {
                StringBuilder sb3 = this.a;
                sb3.delete(0, sb3.length());
            }
            return ggVar;
        } catch (Throwable th) {
            if (0 != 0) {
                byteBuffer.clear();
            }
            throw th;
        }
    }
}
