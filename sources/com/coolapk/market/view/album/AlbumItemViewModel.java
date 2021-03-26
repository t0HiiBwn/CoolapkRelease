package com.coolapk.market.view.album;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.model.AlbumItem;

public class AlbumItemViewModel extends BaseObservable {
    private AlbumItem albumItem;
    private final Context context;
    private String note;

    @Bindable
    public String getNullApkId() {
        return "0";
    }

    public AlbumItemViewModel(Context context2) {
        this.context = context2.getApplicationContext();
    }

    @Bindable
    public AlbumItem getAlbumItem() {
        return this.albumItem;
    }

    @Bindable
    public String getNote() {
        if (!TextUtils.isEmpty(this.note)) {
            return this.note;
        }
        return getAlbumItem() != null ? getAlbumItem().getNote() : "";
    }

    @Bindable
    public String getTitle() {
        return getAlbumItem() != null ? getAlbumItem().getTitle() : "";
    }

    public void setAlbumItem(AlbumItem albumItem2) {
        this.albumItem = albumItem2;
    }

    public void setNote(String str) {
        this.note = str;
        notifyPropertyChanged(208);
    }

    @Bindable
    public String getLogoUrl() {
        return getAlbumItem() != null ? getAlbumItem().getLogoUrl() : "";
    }

    private Context getContext() {
        return this.context;
    }

    @Bindable
    public String getSourceName() {
        if (!TextUtils.isEmpty(getAlbumItem().getSourceName())) {
            return getContext().getString(2131886642, getAlbumItem().getSourceName());
        }
        return null;
    }

    @Bindable
    public String getApkName() {
        return getAlbumItem().getPackageName();
    }
}
