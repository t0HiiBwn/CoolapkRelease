package com.bytedance.tea.crash.upload;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.tea.crash.b.a;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.g.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class CrashUploadService extends IntentService {
    public CrashUploadService() {
        super("CrashUploadService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            c cVar = null;
            if (intent.hasExtra("crash_type")) {
                cVar = (c) intent.getSerializableExtra("crash_type");
            }
            String stringExtra = intent.getStringExtra("upload_url");
            String stringExtra2 = intent.getStringExtra("crash_json_value");
            String stringExtra3 = intent.getStringExtra("crash_info_file_path");
            String stringExtra4 = intent.getStringExtra("crash_dump_file_path");
            a.a().a(getApplication());
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra) && !a.a().a(stringExtra3) && a(stringExtra, stringExtra2, stringExtra4, cVar).a()) {
                if (cVar == c.NATIVE) {
                    if (!d.a(new File(stringExtra3).getParentFile(), true)) {
                        a.a().a(com.bytedance.tea.crash.b.a.a.a(stringExtra3));
                    }
                } else if (!TextUtils.isEmpty(stringExtra3) && !d.a(stringExtra3)) {
                    a.a().a(com.bytedance.tea.crash.b.a.a.a(stringExtra3));
                }
            }
        }
    }

    private f a(String str, String str2, String str3, c cVar) {
        if (cVar == null) {
            return new f(201);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("upload_scene", "new_process");
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (cVar == c.NATIVE) {
            return b.a(str, str2, str3);
        }
        if (cVar == c.LAUNCH) {
            return b.a(str, str2);
        }
        return b.a(str, str2, b.a());
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
