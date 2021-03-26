package com.ali.auth.third.login.bridge;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.task.BindByUsernameTask;
import com.ali.auth.third.login.task.LoginByQrCodeTask;
import com.ali.auth.third.login.task.LoginByUsernameTask;
import com.ali.auth.third.login.task.QrLoginConfirmTask;
import com.ali.auth.third.ui.context.a;
import com.ali.auth.third.ui.webview.BridgeMethod;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginBridge {
    @BridgeMethod
    public void auth(a aVar, String str) {
        new LoginByUsernameTask(aVar).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{str});
    }

    @BridgeMethod
    public void bindByUsername(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("params");
                if (optJSONObject != null) {
                    new BindByUsernameTask(aVar).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{JSONUtils.optString(optJSONObject, "loginInfo")});
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @BridgeMethod
    public void loginByQrCode(a aVar, String str) {
        new LoginByQrCodeTask(aVar, false).execute(new String[]{str});
    }

    @BridgeMethod
    public void loginByUsername(a aVar, String str) {
        new LoginByUsernameTask(aVar).executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new String[]{str});
    }

    @BridgeMethod
    public void qrLoginConfirm(a aVar, String str) {
        new QrLoginConfirmTask(aVar).execute(new String[]{str});
    }

    @BridgeMethod
    public void unbindByUsername(a aVar, String str) {
    }
}
