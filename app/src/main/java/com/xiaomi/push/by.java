package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public class by extends ca {
    public by(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static by a(Context context, String str, int i) {
        b.b("delete  messages when db size is too bigger");
        String a = ce.a(context).m171a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new by(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        if (this.f264a != null && this.f264a.length > 0) {
            this.f264a[0] = String.valueOf(j);
        }
    }

    @Override // com.xiaomi.push.ce.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = ck.a(a());
            long j = bw.f245a;
            if (a > j) {
                long j2 = (long) (((((double) (a - j)) * 1.2d) / ((double) j)) * ((double) longValue));
                a(j2);
                bs a2 = bs.a(context);
                a2.a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
                super.a(context, obj);
                return;
            }
            b.b("db size is suitable");
        }
    }
}
