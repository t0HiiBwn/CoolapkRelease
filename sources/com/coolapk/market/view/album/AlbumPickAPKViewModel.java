package com.coolapk.market.view.album;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.MobileApp;

public class AlbumPickAPKViewModel extends BaseObservable {
    private boolean isCheck;
    private String packageName;
    private MobileApp pickApp;
    private String pickAppNote;

    @Bindable
    public String getpickAppName() {
        return getPickApp().getAppName();
    }

    public void setPickAppName(String str) {
        notifyPropertyChanged(222);
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
        notifyPropertyChanged(164);
    }

    public void setPickApp(MobileApp mobileApp) {
        this.pickApp = mobileApp;
        notifyPropertyChanged(221);
    }

    @Bindable
    private MobileApp getPickApp() {
        return this.pickApp;
    }

    @Bindable
    public String getPackageName() {
        return getPickApp().getPackageName();
    }

    @Bindable
    public boolean getIsCheck() {
        return this.isCheck;
    }

    @Bindable
    public String getPickAppNote() {
        return this.pickAppNote;
    }

    public void setPickAppNote(String str) {
        this.pickAppNote = str;
        notifyPropertyChanged(223);
    }
}
