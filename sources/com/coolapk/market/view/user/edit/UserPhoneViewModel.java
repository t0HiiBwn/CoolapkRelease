package com.coolapk.market.view.user.edit;

import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import rx.Observable;

public class UserPhoneViewModel extends EditUserBaseViewModel {
    private String countyCode;

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean canEdit() {
        return true;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getActionText() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeHintText() {
        return "输入短信验证码";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeTitleText() {
        return "短信验证码";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeType() {
        return "PHONE_CODE";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getDialogMessage() {
        return "确定要绑定手机号：";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getDialogTitle() {
        return "确认修改";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getEditType() {
        return "PHONE";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getHintText() {
        return "输入手机号";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getTitleText() {
        return "+86";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean hasCode() {
        return true;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean hasImgCode() {
        return true;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String tipInfo() {
        return "· 发送短信验证码需要先输入手机号+图形验证码\n· 点击验证码图片可刷新";
    }

    public boolean canShowCode() {
        return !TextUtils.isEmpty(getCodeType());
    }

    public String getCountyCode() {
        return TextUtils.isEmpty(this.countyCode) ? "86" : this.countyCode;
    }

    public void setCountyCode(String str) {
        this.countyCode = str;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public Observable<Result<String>> chanageUserInfo() {
        return DataManager.getInstance().changeMobile(getChanageText(), getCountyCode(), getCodeText());
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public Observable<Result<String>> getCode() {
        return DataManager.getInstance().sendChangeMobileCode(getChanageText(), getCountyCode(), getImgCodeText());
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getChanageText() {
        return this.chanageText;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeText() {
        return this.codeText;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getImgCodeText() {
        return this.imgCodeText;
    }
}
