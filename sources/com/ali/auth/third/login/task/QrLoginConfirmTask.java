package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.ui.context.a;
import java.util.Map;
import org.json.JSONObject;

public class QrLoginConfirmTask extends AbsAsyncTask<String, Void, Void> {
    private a a;

    public QrLoginConfirmTask(a aVar) {
        this.a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void asyncExecute(String... strArr) {
        Activity a2;
        ResultCode resultCode;
        if (!TextUtils.isEmpty(strArr[0])) {
            try {
                Map map = (Map) JSONUtils.toMap(new JSONObject(strArr[0]).optJSONObject("params")).get("qrConfirmInfo");
                if (map != null) {
                    int intValue = ((Integer) map.get("action")).intValue();
                    if (intValue == 0) {
                        a2 = this.a.a();
                        resultCode = ResultCode.SUCCESS;
                    } else {
                        if (-1 == intValue) {
                            a2 = this.a.a();
                            resultCode = ResultCode.USER_CANCEL;
                        }
                        this.a.a().finish();
                        return null;
                    }
                    a2.setResult(resultCode.code);
                    this.a.a().finish();
                    return null;
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        a2 = this.a.a();
        resultCode = ResultCode.SUCCESS;
        a2.setResult(resultCode.code);
        this.a.a().finish();
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        Message createMessage = MessageUtils.createMessage(10010, th.getMessage());
        SDKLogger.log("login", createMessage, th);
        this.a.a(createMessage.code, createMessage.message);
    }
}
