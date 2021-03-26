package com.bytedance.embedapplog;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.embedapplog.cf;

final class cd implements cf {
    cd() {
    }

    @Override // com.bytedance.embedapplog.cf
    public boolean a(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.bytedance.embedapplog.cf
    public cf.a b(Context context) {
        Bundle bundle;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return null;
                }
                bundle = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                bundle = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (bundle == null) {
                return null;
            }
            if (bundle.getInt("code", -1) == 0) {
                cf.a aVar = new cf.a();
                aVar.b = bundle.getString("id");
                return aVar;
            }
            String string = bundle.getString("message");
            if (!TextUtils.isEmpty(string)) {
                Log.e(ce.a, string);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
