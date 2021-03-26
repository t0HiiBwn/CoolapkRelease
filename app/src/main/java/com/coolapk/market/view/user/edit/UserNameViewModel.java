package com.coolapk.market.view.user.edit;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import rx.Observable;

public class UserNameViewModel extends EditUserBaseViewModel {
    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean canEdit() {
        return true;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getActionText() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public Observable<Result<String>> getCode() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeHintText() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeText() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeTitleText() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getCodeType() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getDialogMessage() {
        return "请确认，是否将用户名修改为：";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getDialogTitle() {
        return "只有一次机会呦~";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getEditType() {
        return "USERNAME";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getHintText() {
        return "输入新的用户名";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getImgCodeText() {
        return null;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getTitleText() {
        return "用户名";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean hasCode() {
        return false;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public boolean hasImgCode() {
        return false;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String tipInfo() {
        return "· 用户名需大于5位且小于20位\n· 不能为纯数字或以数字开头\n· 禁止包含非法字符及违禁关键词";
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public Observable<Result<String>> chanageUserInfo() {
        return DataManager.getInstance().chanageUserName(this.chanageText);
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public void setChanageText(String str) {
        this.chanageText = str;
    }

    @Override // com.coolapk.market.view.user.edit.EditUserBaseViewModel
    public String getChanageText() {
        return this.chanageText;
    }
}
