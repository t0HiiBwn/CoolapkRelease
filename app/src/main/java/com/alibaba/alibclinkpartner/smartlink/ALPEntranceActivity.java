package com.alibaba.alibclinkpartner.smartlink;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.a.c;
import com.alibaba.alibclinkpartner.smartlink.data.SafeConfig;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.a;
import com.alibaba.alibclinkpartner.smartlink.util.f;
import java.util.Iterator;

public class ALPEntranceActivity extends Activity {
    private void a(Intent intent, Activity activity) {
        Uri data;
        boolean z = false;
        try {
            String a = a.a(activity);
            Iterator<String> it2 = ((SafeConfig) f.d("safe_package_config", new SafeConfig())).getWhiteList().iterator();
            String str = null;
            String str2 = null;
            Intent intent2 = null;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (TextUtils.equals(it2.next(), a) && (data = (intent2 = (Intent) intent.getParcelableExtra("linkIntent")).getData()) != null) {
                    str = (String) f.b(a, "");
                    str2 = Uri.parse(str).getQueryParameter("backURL");
                    if (TextUtils.equals(data.toString(), str2)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                b(intent2);
            } else {
                ALSLLogUtil.e("ALPEntranceActivity", "onCreate", "callingPackage = " + a + "  uri是 = " + str + " backUrl = " + str2);
            }
            new com.alibaba.alibclinkpartner.smartlink.b.a.f().a.put("intentData", intent.getExtras().toString());
        } catch (Exception e) {
            ALSLLogUtil.e("ALPEntranceActivity", "jumpThird", " t=" + e.toString());
        }
    }

    private boolean a(Intent intent) {
        return intent != null;
    }

    private void b(Intent intent) {
        if (intent != null) {
            try {
                startActivity(intent);
                ALSLLogUtil.d("ALPEntranceActivity", "startNewActivity", "数据一致，startNewActivity");
            } catch (Throwable th) {
                ALSLLogUtil.e("ALPEntranceActivity", "startNewActivity", "startActivityError t=" + th.toString());
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
        Intent intent = getIntent();
        if (!a(intent)) {
            ALSLLogUtil.e("ALPEntranceActivity", "onCreate", " check intent fail,param miss");
            return;
        }
        String stringExtra = intent.getStringExtra("pluginRules");
        if (stringExtra != null && stringExtra.equals("forward")) {
            a(intent, this);
        } else if (stringExtra != null) {
            c.a(intent.getStringExtra("sourcePackageName"), stringExtra, intent.getExtras().getInt("resultCode", 0), intent.getExtras());
        } else {
            ALSLLogUtil.e("ALPEntranceActivity", "onCreate", " module is null");
        }
    }
}
