package com.ali.auth.third.ui.iv;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.ali.auth.third.core.callback.ResultCallback;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.ui.R;
import com.ali.auth.third.ui.iv.AliUserSmsCodeView;
import java.util.Map;

public class SMSVerificationView extends ScrollView implements SmsVerifyFormView {
    public static final String PAGE_NAME = "Page_Reg";
    public static final String TAG = "login.numAuthReg";
    private ResultCallback<String> a;
    protected IVParam mIVParams;
    protected SMSVerifyPresenter mPresenter;
    protected CountDownButton mSendSMSCodeBtn;
    protected AliUserSmsCodeView mSmsCodeView;

    public SMSVerificationView(Context context) {
        this(context, null);
    }

    public SMSVerificationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIVParams = new IVParam();
        LayoutInflater.from(context).inflate(getLayoutId(), this);
    }

    protected int getLayoutId() {
        return R.layout.ali_auth_sms_verification;
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public String getPageName() {
        return "";
    }

    public void init(Map<String, Object> map) {
        if (map != null) {
            this.mIVParams.mobileNum = (String) map.get("mobile");
            this.mIVParams.ivToken = (String) map.get("iv_token");
            this.mIVParams.validatorTag = "8";
        }
        this.mPresenter = new SMSVerifyPresenter(this);
        initViews();
        this.mPresenter.sendSMS(this.mIVParams);
    }

    protected void initViews() {
        if (!TextUtils.isEmpty(this.mIVParams.mobileNum)) {
            Context context = getContext();
            int i = R.string.ali_auth_sms_veri_title;
            ((TextView) getRootView().findViewById(R.id.ali_auth_mobile_tv)).setText(context.getString(i, " " + this.mIVParams.mobileNum + " "));
        }
        AliUserSmsCodeView aliUserSmsCodeView = (AliUserSmsCodeView) getRootView().findViewById(R.id.ali_auth_sms_code_view);
        this.mSmsCodeView = aliUserSmsCodeView;
        aliUserSmsCodeView.setOnCompletedListener(new AliUserSmsCodeView.OnCompletedListener() {
            /* class com.ali.auth.third.ui.iv.SMSVerificationView.AnonymousClass1 */

            @Override // com.ali.auth.third.ui.iv.AliUserSmsCodeView.OnCompletedListener
            public void onCompleted(String str) {
                SMSVerificationView.this.submitRegisterForm();
            }
        });
        this.mSmsCodeView.focus();
        CountDownButton countDownButton = (CountDownButton) getRootView().findViewById(R.id.ali_auth_send_smscode_btn);
        this.mSendSMSCodeBtn = countDownButton;
        countDownButton.setGetCodeTitle(R.string.ali_auth_verification_reGetCode);
        this.mSendSMSCodeBtn.setTickTitleRes(R.string.ali_auth_sms_code_success_hint);
        this.mSendSMSCodeBtn.startCountDown(60000, 1000);
        this.mSendSMSCodeBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.ali.auth.third.ui.iv.SMSVerificationView.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SMSVerificationView.this.sendCodeAction();
            }
        });
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onSMSSendFail(RpcResponse rpcResponse) {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
    }

    protected void onSendSMSAction() {
        this.mPresenter.sendSMS(this.mIVParams);
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onSendSMSSuccess(long j) {
        this.mSendSMSCodeBtn.startCountDown(j, 1000);
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onVerifyFail(int i, String str) {
        Context context = getContext();
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(R.string.aliuser_network_error);
        }
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ali.auth.third.ui.iv.SmsVerifyFormView
    public void onVerifySuccess(String str) {
        ResultCallback<String> resultCallback = this.a;
        if (resultCallback != null) {
            resultCallback.onSuccess(str);
        }
    }

    protected void sendCodeAction() {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            aliUserSmsCodeView.clearText();
        }
        try {
            onSendSMSAction();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setResultCallback(ResultCallback resultCallback) {
        this.a = resultCallback;
    }

    public void submitRegisterForm() {
        AliUserSmsCodeView aliUserSmsCodeView = this.mSmsCodeView;
        if (aliUserSmsCodeView != null) {
            this.mIVParams.checkCode = aliUserSmsCodeView.getText();
            this.mPresenter.verifyCode(this.mIVParams);
        }
    }
}
