package com.ali.auth.third.login.task;

import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.rpc.PureHttpConnectionHelper;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.login.util.QRCodeUtil;
import java.util.HashMap;
import org.json.JSONObject;

public class LoadQrCodePicTask extends AbsAsyncTask {
    private ResultCallback a;

    public LoadQrCodePicTask(ResultCallback resultCallback) {
        this.a = resultCallback;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected Object asyncExecute(Object[] objArr) {
        try {
            final HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(PureHttpConnectionHelper.get(ConfigManager.getQrCodeContentUrl));
            JSONUtils.toMap(hashMap, jSONObject);
            int i = 480;
            int intValue = (objArr == null || objArr.length < 1) ? 480 : ((Integer) objArr[0]).intValue();
            if (objArr != null && objArr.length >= 2) {
                i = ((Integer) objArr[1]).intValue();
            }
            hashMap.put("imageBitMap", QRCodeUtil.createQRCodeBitmap(jSONObject.getString("url"), intValue, i, (objArr == null || objArr.length < 3) ? null : (String) objArr[2]));
            KernelContext.executorService.postUITask(new Runnable() {
                /* class com.ali.auth.third.login.task.LoadQrCodePicTask.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    LoadQrCodePicTask.this.a.onSuccess(hashMap);
                }
            });
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    protected void doWhenException(Throwable th) {
        KernelContext.executorService.postUITask(new Runnable() {
            /* class com.ali.auth.third.login.task.LoadQrCodePicTask.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                LoadQrCodePicTask.this.a.onFailure(0, "");
            }
        });
    }
}
