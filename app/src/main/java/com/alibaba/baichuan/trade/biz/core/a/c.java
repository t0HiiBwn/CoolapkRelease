package com.alibaba.baichuan.trade.biz.core.a;

import android.text.TextUtils;
import com.ali.auth.third.core.model.Session;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsCallbackContext;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsResult;
import com.alibaba.baichuan.trade.biz.login.AlibcLogin;
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback;

public class c extends a {
    public static String b = "AliBCLogin";

    private void a(AlibcJsCallbackContext alibcJsCallbackContext) {
        boolean isLogin = AlibcLogin.getInstance().isLogin();
        AlibcJsResult alibcJsResult = new AlibcJsResult();
        alibcJsResult.addData("isLogin", Boolean.valueOf(isLogin));
        alibcJsCallbackContext.success(alibcJsResult);
    }

    private void b(final AlibcJsCallbackContext alibcJsCallbackContext) {
        AlibcLogin instance = AlibcLogin.getInstance();
        if (instance.isLogin()) {
            AlibcJsResult alibcJsResult = new AlibcJsResult();
            Session session = instance.getSession();
            alibcJsResult.addData("userId", session.openId);
            alibcJsResult.addData("nick", session.nick);
            alibcJsCallbackContext.success(alibcJsResult);
            return;
        }
        AlibcLogin.getInstance().showLogin(new AlibcLoginCallback() {
            /* class com.alibaba.baichuan.trade.biz.core.a.c.AnonymousClass1 */

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onFailure(int i, String str) {
                AlibcJsResult alibcJsResult = new AlibcJsResult();
                alibcJsResult.setResultCode(String.valueOf(i));
                alibcJsResult.setResultMsg(str);
                alibcJsCallbackContext.error(alibcJsResult);
            }

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onSuccess(int i, String str, String str2) {
                AlibcJsResult alibcJsResult = new AlibcJsResult();
                alibcJsResult.addData("userId", str);
                alibcJsResult.addData("nick", str2);
                alibcJsCallbackContext.success(alibcJsResult);
            }
        });
    }

    private void c(final AlibcJsCallbackContext alibcJsCallbackContext) {
        AlibcLogin.getInstance().logout(new AlibcLoginCallback() {
            /* class com.alibaba.baichuan.trade.biz.core.a.c.AnonymousClass2 */

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onFailure(int i, String str) {
                AlibcJsResult alibcJsResult = new AlibcJsResult();
                alibcJsResult.setResultCode(String.valueOf(i));
                alibcJsResult.setResultMsg(str);
                alibcJsCallbackContext.error(alibcJsResult);
            }

            @Override // com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
            public void onSuccess(int i, String str, String str2) {
                alibcJsCallbackContext.success();
            }
        });
    }

    @Override // com.alibaba.baichuan.trade.biz.core.a.a, com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin
    public boolean execute(String str, String str2, AlibcJsCallbackContext alibcJsCallbackContext) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || alibcJsCallbackContext == null) {
            AlibcJsResult alibcJsResult = new AlibcJsResult("6");
            alibcJsResult.setResultCode("2");
            if (alibcJsCallbackContext == null) {
                return false;
            }
            alibcJsCallbackContext.error(alibcJsResult);
            return false;
        } else if ("isLogin".equals(str)) {
            a(alibcJsCallbackContext);
            return true;
        } else if ("login".equals(str)) {
            b(alibcJsCallbackContext);
            return true;
        } else if (!"logout".equals(str)) {
            return true;
        } else {
            c(alibcJsCallbackContext);
            return true;
        }
    }
}
