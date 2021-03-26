package com.coolapk.market.view.user.edit;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import com.coolapk.market.network.Result;
import rx.Observable;

public abstract class EditUserBaseViewModel extends BaseObservable {
    public String chanageText;
    public String codeText;
    public String imgCodeText;

    public abstract boolean canEdit();

    public abstract Observable<Result<String>> chanageUserInfo();

    public abstract String getActionText();

    public abstract String getChanageText();

    public abstract Observable<Result<String>> getCode();

    public abstract String getCodeHintText();

    public abstract String getCodeText();

    public abstract String getCodeTitleText();

    public abstract String getCodeType();

    public abstract String getDialogMessage();

    public abstract String getDialogTitle();

    public abstract String getEditType();

    public abstract String getHintText();

    public abstract String getImgCodeText();

    public abstract String getTitleText();

    public abstract boolean hasCode();

    public abstract boolean hasImgCode();

    public abstract String tipInfo();

    public boolean isEditUserName() {
        return TextUtils.equals(getEditType(), "USERNAME");
    }

    public boolean isEditEmail() {
        return TextUtils.equals(getEditType(), "EMAIL");
    }

    public boolean isEditPhoneNumber() {
        return TextUtils.equals(getEditType(), "PHONE");
    }

    public void setChanageText(String str) {
        this.chanageText = str;
    }

    public void setCodeText(String str) {
        this.codeText = str;
    }

    public void setImgCodeText(String str) {
        this.imgCodeText = str;
    }
}
