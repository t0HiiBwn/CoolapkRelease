package com.kepler.sdk;

import android.content.Context;
import com.jd.jdsdk.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class z {
    public boolean a(Context context, String str) {
        byte[] a;
        try {
            InputStream openRawResource = context.getResources().openRawResource(R.raw.safe);
            if (!(openRawResource == null || (a = a(openRawResource)) == null)) {
                String b = new ac().b(a);
                j.b("suwg", "image-:" + b);
                String b2 = b(context, str);
                j.b("suwg", "get-:" + b2);
                if (b2.equals(b)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i.b.booleanValue()) {
            return true;
        }
        return false;
    }

    private String b(Context context, String str) {
        try {
            x xVar = new x();
            String str2 = x.f(context) + "," + xVar.c(context) + "," + xVar.d(context);
            if (str2.indexOf(";") >= 0) {
                str2 = str2.replace(":", "");
            }
            String str3 = str + "," + str2.toLowerCase();
            j.b("suwg", "get-str:" + str3);
            return new ac().a(str3.getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    private byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } catch (Exception unused) {
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
