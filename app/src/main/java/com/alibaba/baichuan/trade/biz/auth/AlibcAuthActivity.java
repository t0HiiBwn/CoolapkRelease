package com.alibaba.baichuan.trade.biz.auth;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.alibaba.baichuan.trade.biz.auth.AlibcAuth;
import com.alibaba.baichuan.trade.common.utils.ResourceUtils;
import java.util.Set;

public class AlibcAuthActivity extends Activity implements View.OnClickListener {
    static int a;
    private boolean b = false;

    private class a implements AlibcAuthListener {
        AlibcAuth.a a;

        private a() {
            this.a = AlibcAuth.a.get(Integer.valueOf(AlibcAuthActivity.a));
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onCancel() {
            this.a.e.onCancel();
            AlibcAuth.a.remove(Integer.valueOf(AlibcAuthActivity.a));
            AlibcAuthActivity.this.finish();
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onError(String str, String str2) {
            if (TextUtils.equals("FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE", str)) {
                this.a.e.onError(str, str2);
                AlibcAuth.a.remove(Integer.valueOf(AlibcAuthActivity.a));
                return;
            }
            AlibcAuthActivity.this.b = true;
            AlibcAuthActivity.this.a();
            onReTry();
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onReTry() {
            this.a.e.onReTry();
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onSuccess() {
            this.a.e.onSuccess();
            AlibcAuth.a.remove(Integer.valueOf(AlibcAuthActivity.a));
            AlibcAuthActivity.this.finish();
        }
    }

    private class b implements AlibcAuthListener {
        AlibcAuth.a a;

        private b() {
            this.a = AlibcAuth.a.get(Integer.valueOf(AlibcAuthActivity.a));
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onCancel() {
            this.a.e.onCancel();
            AlibcAuth.a.remove(Integer.valueOf(AlibcAuthActivity.a));
            AlibcAuthActivity.this.finish();
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onError(String str, String str2) {
            AlibcAuthActivity.this.b = true;
            AlibcAuthActivity.this.a();
            onReTry();
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onReTry() {
            this.a.e.onReTry();
        }

        @Override // com.alibaba.baichuan.trade.biz.auth.AlibcAuthListener
        public void onSuccess() {
            AlibcAuthActivity.this.b = false;
            AlibcAuthActivity.this.a();
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        String str;
        if (!isFinishing()) {
            AlibcAuth.a aVar = AlibcAuth.a.get(Integer.valueOf(a));
            String charSequence = getApplicationInfo().loadLabel(getPackageManager()).toString();
            TextView textView = (TextView) findViewById(ResourceUtils.getIdentifier(this, "id", "open_auth_title"));
            TextView textView2 = (TextView) findViewById(ResourceUtils.getIdentifier(this, "id", "open_auth_desc"));
            TextView textView3 = (TextView) findViewById(ResourceUtils.getIdentifier(this, "id", "open_auth_btn_grant"));
            findViewById(ResourceUtils.getIdentifier(this, "id", "open_auth_rl")).setVisibility(0);
            c();
            if (this.b) {
                textView.setText("淘宝授权失败");
                textView2.setText("请确认网络环境后再试试？");
                str = "重试";
            } else {
                textView.setText(charSequence + "将获取");
                StringBuffer stringBuffer = new StringBuffer();
                if (aVar.a != null) {
                    for (String str2 : a.b(aVar.a)) {
                        String a2 = a.a(str2);
                        stringBuffer.append(TextUtils.isEmpty(a2) ? "访问您淘宝账号信息的权限(" + str2 + ")" : a2 + "\n");
                    }
                } else if (aVar.c != null) {
                    for (String str3 : aVar.c) {
                        String a3 = a.a(str3);
                        stringBuffer.append(TextUtils.isEmpty(a3) ? "访问您淘宝账号信息的权限(" + str3 + ")" : a3 + "\n");
                    }
                }
                stringBuffer.delete(stringBuffer.lastIndexOf("\n"), stringBuffer.length());
                boolean isEmpty = TextUtils.isEmpty(stringBuffer);
                String str4 = stringBuffer;
                if (isEmpty) {
                    str4 = "访问您淘宝账号信息的权限";
                }
                textView2.setText(str4);
                str = "确认授权";
            }
            textView3.setText(str);
            textView3.setOnClickListener(this);
            findViewById(ResourceUtils.getIdentifier(this, "id", "open_auth_btn_cancel")).setOnClickListener(this);
            findViewById(ResourceUtils.getIdentifier(this, "id", "open_auth_btn_close")).setOnClickListener(this);
        }
    }

    private void b() {
        findViewById(ResourceUtils.getIdentifier(this, "id", "com_alibc_auth_progressbar")).setVisibility(0);
    }

    private void c() {
        findViewById(ResourceUtils.getIdentifier(this, "id", "com_alibc_auth_progressbar")).setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == ResourceUtils.getIdentifier(this, "id", "open_auth_btn_cancel") || id == ResourceUtils.getIdentifier(this, "id", "open_auth_btn_close")) {
            synchronized (this) {
                AlibcAuth.a aVar = AlibcAuth.a.get(Integer.valueOf(a));
                if (aVar != null) {
                    aVar.e.onCancel();
                    AlibcAuth.a.remove(Integer.valueOf(a));
                }
                finish();
            }
        } else if (id == ResourceUtils.getIdentifier(this, "id", "open_auth_btn_grant")) {
            synchronized (this) {
                AlibcAuth.a aVar2 = AlibcAuth.a.get(Integer.valueOf(a));
                if (aVar2 == null) {
                    finish();
                    return;
                }
                b();
                findViewById(ResourceUtils.getIdentifier(this, "id", "open_auth_rl")).setVisibility(8);
                if (!TextUtils.isEmpty(aVar2.a)) {
                    Set<String> b2 = a.b(aVar2.a);
                    if (b2 != null) {
                        if (b2.size() > 0) {
                            AlibcAuth.a(b2, new a(), false);
                        }
                    }
                    AlibcAuth.a(aVar2.a, new b(), false, false);
                } else {
                    AlibcAuth.a(aVar2.c, new a(), false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(ResourceUtils.getIdentifier(this, "layout", "com_alibc_auth_actiivty"));
        try {
            a = getIntent().getExtras().getInt("authId");
            AlibcAuth.a aVar = AlibcAuth.a.get(Integer.valueOf(a));
            if (aVar.c == null) {
                AlibcAuth.a(aVar.a, new b(), false, false);
            } else {
                a();
            }
        } catch (Exception unused) {
        }
    }
}
