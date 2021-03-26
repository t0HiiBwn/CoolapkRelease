package com.ali.auth.third.ui.iv;

import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import org.json.JSONObject;

public class SMSVerifyPresenter {
    private static final String a = "SMSVerifyPresenter";
    private SmsVerifyFormView b;

    public SMSVerifyPresenter(SmsVerifyFormView smsVerifyFormView) {
        this.b = smsVerifyFormView;
    }

    public void sendSMS(IVParam iVParam) {
        DataRepository.sendSMSCode(iVParam.ivToken, iVParam.validatorTag, iVParam.mobileNum, new RpcRequestCallbackWithCode() {
            /* class com.ali.auth.third.ui.iv.SMSVerifyPresenter.AnonymousClass1 */

            @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                if (SMSVerifyPresenter.this.b != null && SMSVerifyPresenter.this.b != null) {
                    SMSVerifyPresenter.this.b.onSMSSendFail(rpcResponse);
                }
            }

            @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (SMSVerifyPresenter.this.b != null && SMSVerifyPresenter.this.b != null) {
                    SMSVerifyPresenter.this.b.onSendSMSSuccess(60000);
                }
            }

            @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                if (SMSVerifyPresenter.this.b != null && SMSVerifyPresenter.this.b != null) {
                    SMSVerifyPresenter.this.b.onSMSSendFail(rpcResponse);
                }
            }
        });
    }

    public void verifyCode(IVParam iVParam) {
        DataRepository.checkCommonCode(iVParam.ivToken, iVParam.checkCode, iVParam.mobileNum, new RpcRequestCallbackWithCode() {
            /* class com.ali.auth.third.ui.iv.SMSVerifyPresenter.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
            @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                String str2;
                if (SMSVerifyPresenter.this.b != null && SMSVerifyPresenter.this.b != null) {
                    if (rpcResponse != null) {
                        try {
                            str2 = new JSONObject((String) rpcResponse.returnValue).optString("message");
                        } catch (Throwable unused) {
                        }
                        SMSVerifyPresenter.this.b.onVerifyFail(rpcResponse != null ? 1101 : rpcResponse.code, str2);
                    }
                    str2 = "";
                    SMSVerifyPresenter.this.b.onVerifyFail(rpcResponse != null ? 1101 : rpcResponse.code, str2);
                }
            }

            @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (SMSVerifyPresenter.this.b != null && SMSVerifyPresenter.this.b != null) {
                    try {
                        SMSVerifyPresenter.this.b.onVerifySuccess(new JSONObject((String) rpcResponse.returnValue).optString("havana_iv_token"));
                    } catch (Throwable unused) {
                        SMSVerifyPresenter.this.b.onVerifyFail(1102, "数据异常");
                    }
                }
            }

            @Override // com.ali.auth.third.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                if (SMSVerifyPresenter.this.b != null && SMSVerifyPresenter.this.b != null) {
                    SMSVerifyPresenter.this.b.onVerifyFail(rpcResponse == null ? 1101 : rpcResponse.code, rpcResponse == null ? "" : rpcResponse.message);
                }
            }
        });
    }
}
