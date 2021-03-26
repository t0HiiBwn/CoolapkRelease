package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;

public class ax extends az {
    public ax(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static ax a(Context context, String str, int i) {
        c.b("delete  messages when db size is too bigger");
        String a = be.a(context).a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new ax(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        if (this.d != null && this.d.length > 0) {
            this.d[0] = String.valueOf(j);
        }
    }

    @Override // com.xiaomi.push.be.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = bk.a(c());
            long j = av.b;
            if (a > j) {
                long j2 = (long) (((((double) (a - j)) * 1.2d) / ((double) j)) * ((double) longValue));
                a(j2);
                ar a2 = ar.a(context);
                a2.a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
                super.a(context, obj);
                return;
            }
            c.b("db size is suitable");
        }
    }
}
