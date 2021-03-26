package com.pgl.sys.a;

import android.content.Context;
import android.util.Log;
import com.pgl.a.b.f;
import com.pgl.sys.a.a.a;
import java.util.Calendar;
import org.json.JSONObject;

public class b implements Runnable {
    private a a;
    private Context b;

    b(Context context, a aVar) {
        this.a = aVar;
        this.b = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e2, code lost:
        if (r4 != 200) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e4, code lost:
        com.pgl.sys.a.a.b = true;
        com.pgl.sys.a.a.d = r5.getString("token_id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ec, code lost:
        if (r4 != 202) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ee, code lost:
        com.pgl.sys.a.a.b = true;
        r1 = r5.getString("token_id");
        com.pgl.sys.a.a.d = r1;
        com.pgl.sys.ces.a.meta(302, r11.b, r1);
     */
    @Override // java.lang.Runnable
    public void run() {
        StringBuilder sb;
        com.pgl.sys.ces.b bVar;
        String str;
        byte[] bArr;
        String valueOf = String.valueOf(System.currentTimeMillis());
        try {
            str = com.pgl.a.a.a.b() + "/v1/getInfoPgl";
            long j = 0;
            long timeInMillis = com.pgl.sys.ces.b.a().a ? Calendar.getInstance().getTimeInMillis() : 0;
            bArr = (byte[]) com.pgl.sys.ces.a.meta(301, this.b, null);
            if (com.pgl.sys.ces.b.a().a) {
                j = Calendar.getInstance().getTimeInMillis();
            }
            if (com.pgl.sys.ces.b.a().a) {
                Log.d("CZL_Efficient", "[Efficient] selas : " + (j - timeInMillis));
            }
        } catch (Throwable th) {
            com.pgl.sys.ces.b.a().reportNow("SS-" + a.a);
            throw th;
        }
        if (bArr == null || bArr.length <= 0) {
            throw new NullPointerException("NullPointerException");
        }
        String str2 = str + "?os=android&app_key=" + a.c + "&did=" + com.pgl.sys.ces.b.c() + "&version=1.0.5&version_code=5&time=" + valueOf;
        int i = 0;
        int i2 = 504;
        while (true) {
            if (i >= 3) {
                break;
            }
            JSONObject jSONObject = new JSONObject(com.pgl.sys.a.b.a.a(str2, bArr));
            i2 = jSONObject.getInt("code");
            if (i2 == 200 || i2 == 202) {
                break;
            }
            i++;
            f.a((long) (i * 3 * 1000));
        }
        a.a = i2;
        bVar = com.pgl.sys.ces.b.a();
        sb = new StringBuilder();
        sb.append("SS-");
        sb.append(a.a);
        bVar.reportNow(sb.toString());
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(a.a());
        }
    }
}
