package com.coolapk.market.view.user.edit;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import rx.Observable;

public class UserEmailViewModel extends EditUserBaseViewModel {
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
        return "输入新邮箱中的验证码";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeTitleText() {
        return "验证码";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeType() {
        return "EMAIL_CODE";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getDialogMessage() {
        return "确定要将绑定邮箱改为：";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getDialogTitle() {
        return "确认修改";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getEditType() {
        return "EMAIL";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getHintText() {
        return "输入新邮箱地址";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getImgCodeText() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getTitleText() {
        return "邮箱";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean hasCode() {
        return true;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean hasImgCode() {
        return false;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String tipInfo() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public Observable<Result<String>> chanageUserInfo() {
        return DataManager.getInstance().changeEmail(getChanageText(), getCodeText());
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public Observable<Result<String>> getCode() {
        return DataManager.getInstance().getChangeEmailCode(getChanageText());
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getChanageText() {
        return this.chanageText;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeText() {
        return this.codeText;
    }
}
