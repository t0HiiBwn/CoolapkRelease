package com.coolapk.market.view.album;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DateUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlbumDetailViewModel extends BaseObservable {
    private Album album;
    private int albumApkNum;
    private String albumFavNum;
    private boolean albumFavState;
    private String albumInfo;
    private String albumIntro;
    private Integer albumMaxWords = 60;
    private int albumReplyNum;
    private String albumTitle;
    private String albumUserName;
    private final Context context;
    private String icon;
    private boolean isAlbumUserFollow;
    private boolean isLoading = true;
    private boolean isRecommend;
    private boolean myAlbum;
    private boolean showContentView;

    public AlbumDetailViewModel(Context context2) {
        this.context = context2.getApplicationContext();
    }

    @Bindable
    public Album getAlbum() {
        return this.album;
    }

    @Bindable
    public boolean getShowContent() {
        return this.album != null;
    }

    public int getAlbumReplyNum() {
        return this.albumReplyNum;
    }

    @Bindable
    public boolean getShowContentView() {
        return this.showContentView;
    }

    public void setShowContentView(boolean z) {
        this.showContentView = z;
        notifyPropertyChanged(247);
    }

    @Bindable
    private List<AlbumItem> getAlbumItems() {
        Album album2 = this.album;
        if (album2 != null) {
            return album2.getAlbumItems();
        }
        return new ArrayList();
    }

    public void setAlbum(Album album2) {
        this.album = album2;
        boolean z = true;
        this.isRecommend = album2.getRecommend() > 0;
        this.isLoading = false;
        if (album2.getUserAction() == null || album2.getUserAction().getFollowAuthor() <= 0) {
            z = false;
        }
        this.isAlbumUserFollow = z;
        this.myAlbum = TextUtils.equals(album2.getUid(), DataManager.getInstance().getLoginSession().getUid());
        this.albumTitle = album2.getTitle();
        this.albumUserName = album2.getUserName();
        setAlbumInfo(album2);
        notifyPropertyChanged(8);
        notifyPropertyChanged(22);
        notifyPropertyChanged(293);
        notifyPropertyChanged(23);
        notifyPropertyChanged(21);
        notifyPropertyChanged(13);
        notifyPropertyChanged(14);
        notifyPropertyChanged(10);
        notifyPropertyChanged(17);
        notifyPropertyChanged(11);
        notifyPropertyChanged(18);
        notifyPropertyChanged(232);
        notifyPropertyChanged(201);
        notifyPropertyChanged(149);
        notifyPropertyChanged(9);
        notifyPropertyChanged(170);
        notifyPropertyChanged(20);
        notifyPropertyChanged(246);
    }

    @Bindable
    public boolean getIsLoading() {
        return getAlbum() == null;
    }

    @Bindable
    public String getUserAvatar() {
        if (getAlbum() != null) {
            return getAlbum().getUserAvatar();
        }
        return null;
    }

    @Bindable
    private int getAlbumApkNum() {
        if (getAlbum() != null) {
            return getAlbum().getTotalApkNum();
        }
        return this.albumApkNum;
    }

    public void setAlbumApkNum(int i) {
        this.albumApkNum = i;
        notifyPropertyChanged(9);
    }

    @Bindable
    public String getIcon() {
        Album album2 = this.album;
        if (album2 != null) {
            return album2.getIcon();
        }
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
        notifyPropertyChanged(149);
    }

    @Bindable
    public boolean isMe() {
        Album album2 = this.album;
        if (album2 != null) {
            return TextUtils.equals(album2.getUid(), DataManager.getInstance().getLoginSession().getUid());
        }
        return false;
    }

    @Bindable
    public boolean getMyAlbum() {
        return this.myAlbum;
    }

    public void setMyAlbum(boolean z) {
        this.myAlbum = z;
        notifyPropertyChanged(201);
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
        notifyPropertyChanged(170);
    }

    @Bindable
    public boolean getAlbumRecommend() {
        return this.isRecommend;
    }

    public void setRecommend(boolean z) {
        this.isRecommend = z;
        notifyPropertyChanged(20);
    }

    @Bindable
    public String getUrl() {
        Album album2 = this.album;
        if (album2 != null) {
            return album2.getAlbumUrl();
        }
        return null;
    }

    @Bindable
    public String getAlbumId() {
        if (getAlbum() != null) {
            return getAlbum().getAlbumId();
        }
        return null;
    }

    public Context getContext() {
        return this.context;
    }

    @Bindable
    public String getAlbumTitle() {
        if (!TextUtils.isEmpty(this.albumTitle)) {
            return this.albumTitle;
        }
        if (getAlbum() != null) {
            return getAlbum().getTitle();
        }
        return null;
    }

    public void setAlbumTitle(String str) {
        this.albumTitle = str;
        notifyPropertyChanged(21);
    }

    @Bindable
    public String getDeviceTitle() {
        return getAlbum() != null ? getAlbum().getDeviceTitle() : "";
    }

    @Bindable
    public boolean isAlbumUserFollow() {
        return this.isAlbumUserFollow;
    }

    public void setFollow(boolean z) {
        this.isAlbumUserFollow = z;
        notifyPropertyChanged(22);
    }

    @Bindable
    public String getUserActionInfo() {
        StringBuilder sb = new StringBuilder();
        if (getAlbum() != null) {
            sb.append(getAlbum().getUserName());
            if (getAlbum().getLikeNum() > 0) {
                sb.append(" · ");
                sb.append(getAlbum().getLikeNum());
                sb.append("赞");
            }
            if (getAlbum().getFavoriteNum() > 0) {
                sb.append(" · ");
                sb.append(getAlbum().getFavoriteNum());
                sb.append("收藏");
            }
        }
        return sb.toString();
    }

    @Bindable
    public String getUserInfoText() {
        StringBuilder sb = new StringBuilder();
        Album album2 = getAlbum();
        if (album2 != null) {
            if (album2.getLikeNum() > 0) {
                sb.append(album2.getLikeNum());
                sb.append("赞");
                sb.append(" · ");
            }
            if (album2.getFavoriteNum() > 0) {
                sb.append(album2.getFavoriteNum());
                sb.append("收藏");
                sb.append(" · ");
            }
            sb.append(DateUtils.getTimeDescription(this.context, album2.getLastUpdate()));
            sb.append("更新");
        }
        return sb.toString();
    }

    @Bindable
    public int getReplyNum() {
        if (getAlbum() != null) {
            return getAlbum().getReplyNum();
        }
        return 0;
    }

    public void setAlbumReplyNum(int i) {
        this.albumReplyNum = i;
        notifyPropertyChanged(232);
    }

    @Bindable
    public String getAlbumUserName() {
        if (!TextUtils.isEmpty(this.albumUserName)) {
            return this.albumUserName;
        }
        if (getAlbum() != null) {
            return getAlbum().getUserName();
        }
        return null;
    }

    public List<String> getApkRowsIcon() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        Album album2 = getAlbum();
        Objects.requireNonNull(album2);
        sb.append(album2.getMoreCount());
        arrayList.add(sb.toString());
        for (AlbumItem albumItem : getAlbumItems()) {
            arrayList.add(albumItem.getPic());
        }
        return arrayList;
    }

    public void setAlbumUserName(String str) {
        this.albumUserName = str;
        notifyPropertyChanged(23);
    }

    public void setAlbumIntro(String str) {
        this.albumIntro = str;
        notifyPropertyChanged(14);
    }

    @Bindable
    public String getAlbumIntro() {
        if (!TextUtils.isEmpty(this.albumIntro)) {
            return this.albumIntro;
        }
        if (getAlbum() != null) {
            return getAlbum().getIntroduce();
        }
        return null;
    }

    private void setAlbumInfo(Album album2) {
        String str;
        if (album2 != null) {
            Album album3 = getAlbum();
            Objects.requireNonNull(album3);
            str = String.format("%s · %s个应用 · %s更新", album3.getUserName(), Integer.valueOf(getAlbumApkNum()), DateUtils.getTimeDescription(this.context, getAlbum().getLastUpdate()));
        } else {
            str = "";
        }
        this.albumInfo = str;
    }

    @Bindable
    public String getAlbumInfo() {
        if (!TextUtils.isEmpty(this.albumInfo)) {
            return this.albumInfo;
        }
        String format = getAlbum() != null ? String.format("%s · %s个应用 · %s更新", getAlbum().getUserName(), Integer.valueOf(getAlbumApkNum()), DateUtils.getTimeDescription(this.context, getAlbum().getLastUpdate())) : "";
        this.albumInfo = format;
        return format;
    }

    @Bindable
    public Integer getAlbumMaxWords() {
        return this.albumMaxWords;
    }

    public void setAlbumMaxWords(Integer num) {
        this.albumMaxWords = num;
        notifyPropertyChanged(19);
    }

    @Bindable
    public String getAlbumLikeNum() {
        Album album2 = getAlbum();
        Objects.requireNonNull(album2);
        return String.valueOf(album2.getLikeNum());
    }

    public void setAlbumLikeNum(int i) {
        if (i == 0) {
            this.context.getString(2131886790);
        } else {
            String.valueOf(i);
        }
        notifyPropertyChanged(17);
    }

    @Bindable
    public String getAlbumFavNum() {
        return this.albumFavNum;
    }

    public void setAlbumFavNum(int i) {
        String str;
        if (i == 0) {
            str = this.context.getString(2131886786);
        } else {
            str = String.valueOf(i);
        }
        this.albumFavNum = str;
        notifyPropertyChanged(10);
    }

    @Bindable
    public boolean getAlbumLikeState() {
        UserAction userAction = getAlbum().getUserAction();
        Objects.requireNonNull(userAction);
        return userAction.getLike() > 0;
    }

    public void setAlbumLikeState(boolean z) {
        notifyPropertyChanged(18);
    }

    @Bindable
    public boolean getAlbumFavState() {
        if (getAlbum() == null) {
            return this.albumFavState;
        }
        UserAction userAction = getAlbum().getUserAction();
        Objects.requireNonNull(userAction);
        return userAction.getFavorite() > 0;
    }

    public void setAlbumFavState(boolean z) {
        this.albumFavState = z;
        notifyPropertyChanged(11);
    }

    public void updateAlbum() {
        notifyPropertyChanged(8);
        notifyPropertyChanged(22);
        notifyPropertyChanged(293);
        notifyPropertyChanged(23);
        notifyPropertyChanged(21);
        notifyPropertyChanged(13);
        notifyPropertyChanged(14);
        notifyPropertyChanged(10);
        notifyPropertyChanged(17);
        notifyPropertyChanged(11);
        notifyPropertyChanged(18);
        notifyPropertyChanged(232);
        notifyPropertyChanged(201);
        notifyPropertyChanged(149);
        notifyPropertyChanged(9);
        notifyPropertyChanged(170);
        notifyPropertyChanged(20);
    }
}
