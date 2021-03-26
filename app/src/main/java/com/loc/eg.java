package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocationClientOption;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Parser */
public final class eg {
    private StringBuilder a = new StringBuilder();
    private AMapLocationClientOption b = new AMapLocationClientOption();

    private void a(ds dsVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str2) && (this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN ? !str.contains("市") || !str.equals(str2) : !str2.equals(str))) {
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
            sb2.append(str5);
            sb2.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            if (TextUtils.isEmpty(str7) || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
                sb2.append("Near " + str6);
                sb = new StringBuilder("Near ");
                sb.append(str6);
            } else {
                sb2.append("靠近");
                sb2.append(str6);
                sb2.append(" ");
                sb = new StringBuilder("在");
                sb.append(str6);
                sb.append("附近");
            }
            dsVar.setDescription(sb.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", dsVar.getCityCode());
        bundle.putString("desc", sb2.toString());
        bundle.putString("adcode", dsVar.getAdCode());
        dsVar.setExtras(bundle);
        dsVar.g(sb2.toString());
        String adCode = dsVar.getAdCode();
        dsVar.setAddress((adCode == null || adCode.trim().length() <= 0 || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) ? sb2.toString() : sb2.toString().replace(" ", ""));
    }

    private static String b(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x02a7 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02b3  */
    public final ds a(ds dsVar, byte[] bArr, dm dmVar) {
        String str;
        ByteBuffer byteBuffer;
        Throwable th;
        ByteBuffer byteBuffer2;
        String str2;
        byte b2;
        ByteBuffer byteBuffer3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ds dsVar2 = dsVar;
        if (bArr == null) {
            try {
                dsVar2.setErrorCode(5);
                dmVar.f("#0504");
                this.a.append("binaryResult is null#0504");
                dsVar2.setLocationDetail(this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
                return dsVar2;
            } catch (Throwable th2) {
                th = th2;
                str = "";
                byteBuffer = null;
                try {
                    ds dsVar3 = new ds(str);
                    dsVar3.setErrorCode(5);
                    dmVar.f("#0505");
                    StringBuilder sb2 = this.a;
                    sb2.append("parser data error:" + th.getMessage() + "#0505");
                    en.a((String) null, 2054);
                    dsVar3.setLocationDetail(this.a.toString());
                    dsVar2 = dsVar3;
                    if (this.a.length() > 0) {
                    }
                    return dsVar2;
                } finally {
                    if (byteBuffer != null) {
                        byteBuffer.clear();
                    }
                }
            }
        } else {
            byteBuffer = ByteBuffer.wrap(bArr);
            try {
                if (byteBuffer.get() == 0) {
                    try {
                        dsVar2.b(String.valueOf((int) byteBuffer.getShort()));
                        byteBuffer.clear();
                        if (byteBuffer != null) {
                            byteBuffer.clear();
                        }
                        return dsVar2;
                    } catch (Throwable th3) {
                        th = th3;
                        str = "";
                        ds dsVar3 = new ds(str);
                        dsVar3.setErrorCode(5);
                        dmVar.f("#0505");
                        StringBuilder sb2 = this.a;
                        sb2.append("parser data error:" + th.getMessage() + "#0505");
                        en.a((String) null, 2054);
                        dsVar3.setLocationDetail(this.a.toString());
                        dsVar2 = dsVar3;
                        if (this.a.length() > 0) {
                        }
                        return dsVar2;
                    }
                } else {
                    dsVar2.setLongitude(ep.a(((double) byteBuffer.getInt()) / 1000000.0d));
                    dsVar2.setLatitude(ep.a(((double) byteBuffer.getInt()) / 1000000.0d));
                    dsVar2.setAccuracy((float) byteBuffer.getShort());
                    dsVar2.c(String.valueOf((int) byteBuffer.get()));
                    dsVar2.d(String.valueOf((int) byteBuffer.get()));
                    if (byteBuffer.get() == 1) {
                        try {
                            byte[] bArr2 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr2);
                            try {
                                dsVar2.setCountry(new String(bArr2, "UTF-8"));
                            } catch (Throwable unused) {
                            }
                            byte[] bArr3 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr3);
                            try {
                                str3 = new String(bArr3, "UTF-8");
                                try {
                                    dsVar2.setProvince(str3);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable unused3) {
                                str3 = "";
                            }
                            byte[] bArr4 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr4);
                            try {
                                str4 = new String(bArr4, "UTF-8");
                                try {
                                    dsVar2.setCity(str4);
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                                str4 = "";
                            }
                            byte[] bArr5 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr5);
                            try {
                                str5 = new String(bArr5, "UTF-8");
                                try {
                                    dsVar2.setDistrict(str5);
                                } catch (Throwable unused6) {
                                }
                            } catch (Throwable unused7) {
                                str5 = "";
                            }
                            byte[] bArr6 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr6);
                            try {
                                str6 = new String(bArr6, "UTF-8");
                                try {
                                    dsVar2.setStreet(str6);
                                    dsVar2.setRoad(str6);
                                } catch (Throwable unused8) {
                                }
                            } catch (Throwable unused9) {
                                str6 = "";
                            }
                            byte[] bArr7 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr7);
                            try {
                                str7 = new String(bArr7, "UTF-8");
                                try {
                                    dsVar2.setNumber(str7);
                                } catch (Throwable unused10) {
                                }
                            } catch (Throwable unused11) {
                                str7 = "";
                            }
                            byte[] bArr8 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr8);
                            try {
                                str8 = new String(bArr8, "UTF-8");
                                try {
                                    dsVar2.setPoiName(str8);
                                } catch (Throwable unused12) {
                                }
                            } catch (Throwable unused13) {
                                str8 = "";
                            }
                            byte[] bArr9 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr9);
                            try {
                                dsVar2.setAoiName(new String(bArr9, "UTF-8"));
                            } catch (Throwable unused14) {
                            }
                            byte[] bArr10 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr10);
                            try {
                                str9 = new String(bArr10, "UTF-8");
                                try {
                                    dsVar2.setAdCode(str9);
                                } catch (Throwable unused15) {
                                }
                            } catch (Throwable unused16) {
                                str9 = "";
                            }
                            byte[] bArr11 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr11);
                            try {
                                dsVar2.setCityCode(new String(bArr11, "UTF-8"));
                            } catch (Throwable unused17) {
                            }
                            str2 = "UTF-8";
                            b2 = 1;
                            byteBuffer2 = byteBuffer;
                            str = "";
                            try {
                                a(dsVar, str3, str4, str5, str6, str7, str8, str9);
                            } catch (Throwable th4) {
                                th = th4;
                                byteBuffer = byteBuffer2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str = "";
                            ds dsVar3 = new ds(str);
                            dsVar3.setErrorCode(5);
                            dmVar.f("#0505");
                            StringBuilder sb2 = this.a;
                            sb2.append("parser data error:" + th.getMessage() + "#0505");
                            en.a((String) null, 2054);
                            dsVar3.setLocationDetail(this.a.toString());
                            dsVar2 = dsVar3;
                            if (this.a.length() > 0) {
                            }
                            return dsVar2;
                        }
                    } else {
                        str2 = "UTF-8";
                        byteBuffer2 = byteBuffer;
                        str = "";
                        b2 = 1;
                    }
                    try {
                        byteBuffer3 = byteBuffer2;
                        try {
                            byteBuffer3.get(new byte[(byteBuffer2.get() & 255)]);
                            if (byteBuffer3.get() == b2) {
                                byteBuffer3.getInt();
                                byteBuffer3.getInt();
                                byteBuffer3.getShort();
                            }
                            if (byteBuffer3.get() == b2) {
                                byte[] bArr12 = new byte[(byteBuffer3.get() & 255)];
                                byteBuffer3.get(bArr12);
                                try {
                                    dsVar2.setBuildingId(new String(bArr12, str2));
                                } catch (Throwable unused18) {
                                }
                                byte[] bArr13 = new byte[(byteBuffer3.get() & 255)];
                                byteBuffer3.get(bArr13);
                                try {
                                    dsVar2.setFloor(new String(bArr13, str2));
                                } catch (Throwable unused19) {
                                }
                            }
                            if (byteBuffer3.get() == b2) {
                                byteBuffer3.get();
                                byteBuffer3.getInt();
                                byteBuffer3.get();
                            }
                            if (byteBuffer3.get() == b2) {
                                dsVar2.setTime(byteBuffer3.getLong());
                            }
                            int i = byteBuffer3.getShort();
                            if (i > 0) {
                                byte[] bArr14 = new byte[i];
                                byteBuffer3.get(bArr14);
                                if (i > 0) {
                                    try {
                                        dsVar2.a(new String(Base64.decode(bArr14, 0), str2));
                                    } catch (Throwable unused20) {
                                    }
                                }
                            }
                            int i2 = byteBuffer3.getShort();
                            if (i2 > 0) {
                                byteBuffer3.get(new byte[i2]);
                            }
                            if (Double.valueOf("5.1").doubleValue() >= 5.1d) {
                                short s = byteBuffer3.getShort();
                                if (!"-1".equals(dsVar.d())) {
                                    if (s == -1) {
                                        s = 0;
                                    } else if (s == 0) {
                                        s = -1;
                                    }
                                } else if (s == 101) {
                                    s = 100;
                                }
                                dsVar2.setConScenario(s);
                                byteBuffer3.get();
                            }
                            if (byteBuffer3 != null) {
                                byteBuffer3.clear();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            byteBuffer = byteBuffer3;
                            ds dsVar3 = new ds(str);
                            dsVar3.setErrorCode(5);
                            dmVar.f("#0505");
                            StringBuilder sb2 = this.a;
                            sb2.append("parser data error:" + th.getMessage() + "#0505");
                            en.a((String) null, 2054);
                            dsVar3.setLocationDetail(this.a.toString());
                            dsVar2 = dsVar3;
                            if (this.a.length() > 0) {
                            }
                            return dsVar2;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        byteBuffer3 = byteBuffer2;
                        byteBuffer = byteBuffer3;
                        ds dsVar3 = new ds(str);
                        dsVar3.setErrorCode(5);
                        dmVar.f("#0505");
                        StringBuilder sb2 = this.a;
                        sb2.append("parser data error:" + th.getMessage() + "#0505");
                        en.a((String) null, 2054);
                        dsVar3.setLocationDetail(this.a.toString());
                        dsVar2 = dsVar3;
                        if (this.a.length() > 0) {
                        }
                        return dsVar2;
                    }
                    if (this.a.length() > 0) {
                        StringBuilder sb3 = this.a;
                        sb3.delete(0, sb3.length());
                    }
                    return dsVar2;
                }
            } catch (Throwable th8) {
                th = th8;
                str = "";
                ds dsVar3 = new ds(str);
                dsVar3.setErrorCode(5);
                dmVar.f("#0505");
                StringBuilder sb2 = this.a;
                sb2.append("parser data error:" + th.getMessage() + "#0505");
                en.a((String) null, 2054);
                dsVar3.setLocationDetail(this.a.toString());
                dsVar2 = dsVar3;
                if (this.a.length() > 0) {
                }
                return dsVar2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081 A[Catch:{ all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ef  */
    public final ds a(String str) {
        JSONArray optJSONArray;
        String str2;
        JSONArray optJSONArray2;
        try {
            ds dsVar = new ds("");
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            dsVar.setCountry(b(optJSONObject2.optString("country")));
            String b2 = b(optJSONObject2.optString("province"));
            dsVar.setProvince(b2);
            String b3 = b(optJSONObject2.optString("citycode"));
            dsVar.setCityCode(b3);
            String optString = optJSONObject2.optString("city");
            if (!b3.endsWith("010") && !b3.endsWith("021") && !b3.endsWith("022")) {
                if (!b3.endsWith("023")) {
                    optString = b(optString);
                    dsVar.setCity(optString);
                    if (TextUtils.isEmpty(optString)) {
                        dsVar.setCity(b2);
                        optString = b2;
                    }
                    String b4 = b(optJSONObject2.optString("district"));
                    dsVar.setDistrict(b4);
                    String b5 = b(optJSONObject2.optString("adcode"));
                    dsVar.setAdCode(b5);
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("streetNumber");
                    String b6 = b(optJSONObject3.optString("street"));
                    dsVar.setStreet(b6);
                    dsVar.setRoad(b6);
                    String b7 = b(optJSONObject3.optString("number"));
                    dsVar.setNumber(b7);
                    optJSONArray = optJSONObject.optJSONArray("pois");
                    if (optJSONArray.length() <= 0) {
                        String b8 = b(optJSONArray.getJSONObject(0).optString("name"));
                        dsVar.setPoiName(b8);
                        str2 = b8;
                    } else {
                        str2 = null;
                    }
                    optJSONArray2 = optJSONObject.optJSONArray("aois");
                    if (optJSONArray2.length() > 0) {
                        dsVar.setAoiName(b(optJSONArray2.getJSONObject(0).optString("name")));
                    }
                    a(dsVar, b2, optString, b4, b6, b7, str2, b5);
                    return dsVar;
                }
            }
            if (b2 != null && b2.length() > 0) {
                dsVar.setCity(b2);
                optString = b2;
            }
            if (TextUtils.isEmpty(optString)) {
            }
            String b4 = b(optJSONObject2.optString("district"));
            dsVar.setDistrict(b4);
            String b5 = b(optJSONObject2.optString("adcode"));
            dsVar.setAdCode(b5);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("streetNumber");
            String b6 = b(optJSONObject3.optString("street"));
            dsVar.setStreet(b6);
            dsVar.setRoad(b6);
            String b7 = b(optJSONObject3.optString("number"));
            dsVar.setNumber(b7);
            optJSONArray = optJSONObject.optJSONArray("pois");
            if (optJSONArray.length() <= 0) {
            }
            optJSONArray2 = optJSONObject.optJSONArray("aois");
            if (optJSONArray2.length() > 0) {
            }
            a(dsVar, b2, optString, b4, b6, b7, str2, b5);
            return dsVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final ds a(String str, Context context, aw awVar, dm dmVar) {
        ds dsVar = new ds("");
        dsVar.setErrorCode(7);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("#SHA1AndPackage#");
            stringBuffer.append(k.e(context));
            String str2 = awVar.b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("#gsid#");
                stringBuffer.append(str2);
            }
            String str3 = awVar.c;
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("#csid#" + str3);
            }
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                dmVar.f("#0702");
                StringBuilder sb = this.a;
                sb.append("json is error:");
                sb.append(str);
                sb.append(stringBuffer);
                sb.append("#0702");
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                dmVar.f("#0701");
                StringBuilder sb2 = this.a;
                sb2.append("auth fail:");
                sb2.append(string2);
                sb2.append(stringBuffer);
                sb2.append("#0701");
                en.a(awVar.d, string3, string2);
            }
        } catch (Throwable th) {
            dmVar.f("#0703");
            StringBuilder sb3 = this.a;
            sb3.append("json exception error:");
            sb3.append(th.getMessage());
            sb3.append(stringBuffer);
            sb3.append("#0703");
            ej.a(th, "parser", "paseAuthFailurJson");
        }
        dsVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            StringBuilder sb4 = this.a;
            sb4.delete(0, sb4.length());
        }
        return dsVar;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.b = new AMapLocationClientOption();
        } else {
            this.b = aMapLocationClientOption;
        }
    }
}
