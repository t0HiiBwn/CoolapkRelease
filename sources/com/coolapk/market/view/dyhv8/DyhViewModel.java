package com.coolapk.market.view.dyhv8;

import android.text.TextUtils;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Unread;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.StringUtils;
import java.util.List;

public class DyhViewModel extends BaseObservable {
    private DyhArticle dyhArticle;
    private String dyhFollowNum;
    private String dyhIncludInfo;
    private String dyhListType;
    private DyhModel dyhModel;
    private boolean isFollowDyh;
    private boolean isFollowed;
    private boolean isInForward;
    private boolean isLoading;
    private boolean isShowActionView;
    private boolean isShowRedPoint;
    private List<String> logoList;
    private Integer maxArticleWords = 120;

    @Bindable
    public DyhModel getDyhModel() {
        return this.dyhModel;
    }

    public void setDyhModel(DyhModel dyhModel2) {
        this.dyhModel = dyhModel2;
        boolean z = true;
        setShowRedPoint(dyhModel2 != null && dyhModel2.hasUnread());
        if (!(dyhModel2 == null || dyhModel2.getUserAction() == null)) {
            if (dyhModel2.getUserAction().getFollow() <= 0) {
                z = false;
            }
            this.isFollowDyh = z;
        }
        notifyPropertyChanged(85);
        notifyPropertyChanged(167);
        notifyPropertyChanged(81);
    }

    @Bindable
    public boolean getIsShowActionView() {
        return this.isShowActionView;
    }

    public void setIsShowActionView(boolean z) {
        this.isShowActionView = z;
        notifyPropertyChanged(172);
    }

    @Bindable
    public boolean isFollowDyhLoading() {
        return this.isLoading;
    }

    public void setLoading(boolean z) {
        this.isLoading = z;
        notifyPropertyChanged(119);
    }

    @Bindable
    public boolean isShowAction() {
        return !this.isLoading && this.isShowActionView;
    }

    @Bindable
    public Integer getMaxArticleWords() {
        return this.maxArticleWords;
    }

    public void setMaxWords(Integer num) {
        this.maxArticleWords = num;
        notifyPropertyChanged(194);
    }

    @Bindable
    public boolean getFollowedDyhHeader() {
        return this.isFollowed;
    }

    public void setFollowed(boolean z) {
        this.isFollowed = z;
        setFollowDyh(z);
        notifyPropertyChanged(124);
    }

    @Bindable
    public String getDyhListType() {
        if (getDyhModel() != null) {
            return EntityUtils.isDyhUnreadType(getDyhModel().getEntityTemplate()) ? "followList" : "allList";
        }
        return this.dyhListType;
    }

    @Bindable
    public String getUserAvatar() {
        if (getDyhModel() == null || getDyhModel().getUserInfo() == null) {
            return null;
        }
        return getDyhModel().getUserInfo().getUserAvatar();
    }

    @Bindable
    public boolean isDatelineVisible() {
        return EntityExtendsKt.isDatelineVisible(getDyhArticle());
    }

    @Bindable
    public boolean isShowNews() {
        return isArticleNewsTemplate() || isArticleTemplate();
    }

    @Bindable
    public boolean isArticleTemplate() {
        return EntityUtils.isDyhArticleType(getDyhArticle().getEntityTemplate());
    }

    @Bindable
    public boolean isShowMiniHeader() {
        return isArticleTemplate() || getIsInForward();
    }

    @Bindable
    public boolean getIsInForward() {
        return this.isInForward;
    }

    public void setInForward(boolean z) {
        this.isInForward = z;
        notifyPropertyChanged(169);
    }

    @Bindable
    public boolean isArticleNewsTemplate() {
        return EntityUtils.isDyhArticleNewsType(getDyhArticle().getEntityTemplate());
    }

    @Bindable
    public boolean isArticleFeedTemplate() {
        return EntityUtils.isDyhArticleFeedType(getDyhArticle().getEntityTemplate());
    }

    @Bindable
    public boolean isArticleItemTemplate() {
        return EntityUtils.isDyhArticleItemType(getDyhArticle().getEntityTemplate());
    }

    public void setDyhListType(String str) {
        this.dyhListType = str;
        notifyPropertyChanged(83);
    }

    @Bindable
    public String getDyhIncludInfo() {
        if (TextUtils.isEmpty(this.dyhIncludInfo)) {
            this.dyhIncludInfo = getDyhModel().getFollowNum() + "订阅  " + getDyhModel().getNewsNum() + "篇文章";
        }
        return this.dyhIncludInfo;
    }

    public void setDyhIncludInfo(String str) {
        this.dyhIncludInfo = str;
        notifyPropertyChanged(82);
    }

    @Bindable
    public String getTime() {
        return DateUtils.getTimeDescription(AppHolder.getApplication(), getLastUpdateTime());
    }

    @Bindable
    public String getExtraPic() {
        if (getDyhArticle() == null || TextUtils.isEmpty(getDyhArticle().getPic())) {
            return null;
        }
        return getDyhArticle().getThumbSquarePic();
    }

    @Bindable
    public String getExtendTitle() {
        if (!TextUtils.isEmpty(getDyhArticle().getTitle())) {
            return getDyhArticle().getTitle();
        }
        if (!TextUtils.isEmpty(getDyhArticle().getFinalMessage())) {
            return getDyhArticle().getFinalMessage();
        }
        return null;
    }

    @Bindable
    public boolean getIsDyhFollowList() {
        return TextUtils.equals(getDyhModel().getEntityTemplate(), "dyhUnRead");
    }

    @Bindable
    public boolean isFollowList() {
        return TextUtils.equals(getDyhModel().getEntityTemplate(), "dyhUnRead");
    }

    @Bindable
    public boolean isShowSubTile() {
        if (isFollowList()) {
            return !TextUtils.isEmpty(getDyhUnreadTitle());
        }
        return true;
    }

    @Bindable
    public String getActionText() {
        if (getIsDyhEditor()) {
            return "写文章";
        }
        return getIsFollowDyh() ? "已订阅" : "订阅";
    }

    @Bindable
    public String getActionTextColor() {
        if (!getIsDyhEditor() && getIsFollowDyh()) {
            return "textColorSecondary";
        }
        return "white";
    }

    @Bindable
    public boolean getIsDyhEditor() {
        if (getDyhModel() != null) {
            return TextUtils.equals(getDyhModel().getUid(), DataManager.getInstance().getLoginSession().getUid());
        }
        return false;
    }

    @Bindable
    public String getUserName() {
        if (getDyhModel() == null || TextUtils.isEmpty(getDyhModel().getUserName())) {
            return null;
        }
        if (getDyhModel().getUserInfo() != null) {
            return "<a href='" + getDyhModel().getUserInfo().getUrl() + "'>" + getDyhModel().getUserInfo().getDisplayUserName() + "</a>";
        }
        return "<a href='/u/" + getDyhModel().getUid() + "'>" + getDyhModel().getUserName() + "</a>";
    }

    @Bindable
    public boolean isShowRedPoint() {
        return this.dyhModel.hasUnread() && isFollowList();
    }

    public void cleanRedPoint() {
        setDyhModel(DyhModel.newBuilder(getDyhModel()).unread(Unread.newBuilder(getDyhModel().getUnread()).unreadNum(0).build()).build());
        setShowRedPoint(false);
    }

    public void setShowRedPoint(boolean z) {
        this.isShowRedPoint = z;
        notifyPropertyChanged(256);
    }

    @Bindable
    public String getDyhFollowNum() {
        this.dyhFollowNum = String.valueOf(this.dyhModel.getFollowNum());
        return StringUtils.emptyIfNull(AppHolder.getCurrentActivity().getString(2131886759, new Object[]{this.dyhFollowNum}));
    }

    public void setDyhFollowNum(String str) {
        this.dyhFollowNum = str;
        notifyPropertyChanged(81);
    }

    @Bindable
    public String getDyhDescription() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 != null) {
            return dyhModel2.getDescription();
        }
        return null;
    }

    @Bindable
    public String getDyhAuthor() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 != null) {
            return dyhModel2.getAuthor();
        }
        return null;
    }

    @Bindable
    public boolean getIsFollowDyh() {
        return this.isFollowDyh;
    }

    @Bindable
    public String getDyhUnreadTitle() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 == null || dyhModel2.getUnread() == null) {
            return "";
        }
        if (this.dyhModel.getUnread().getUnreadNum() <= 0) {
            return this.dyhModel.getUnread().getUnreadTitle();
        }
        return "[" + this.dyhModel.getUnread().getUnreadNum() + "条] " + this.dyhModel.getUnread().getUnreadTitle();
    }

    @Bindable
    public String getEntityTemplate() {
        return getDyhModel().getEntityTemplate();
    }

    @Bindable
    public String getNewBuildEntityTemplate() {
        return TextUtils.equals(getEntityTemplate(), "dyhUnRead") ? "dyhUnRead" : "dyh";
    }

    public void setFollowDyh(boolean z) {
        this.isFollowDyh = z;
        setDyhModel(DyhModel.newBuilder(getDyhModel()).userAction(UserAction.newBuilder(getDyhModel().getUserAction()).follow(z ? 1 : 0).build()).build());
        notifyPropertyChanged(167);
    }

    @Bindable
    public List<String> getLogoList() {
        return this.logoList;
    }

    public void setLogoList(List<String> list) {
        this.logoList = list;
    }

    @Bindable
    public String getFollowText() {
        if (this.dyhModel == null || !getIsFollowDyh()) {
            return "订阅";
        }
        return "已订阅";
    }

    @Bindable
    public DyhArticle getFirstArticle() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 == null || CollectionUtils.isEmpty(dyhModel2.getEntities())) {
            return null;
        }
        return this.dyhModel.getEntities().get(0);
    }

    @Bindable
    public String getDyhTitle() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 != null) {
            return dyhModel2.getTitle();
        }
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 != null) {
            return dyhArticle2.getDyhName();
        }
        return null;
    }

    @Bindable
    public String getShortTitle() {
        if (getDyhTitle() == null) {
            return null;
        }
        if (getDyhTitle().length() > 10) {
            return StringUtils.getShortString(getDyhTitle(), 10);
        }
        return getDyhTitle();
    }

    @Bindable
    public Long getLastUpdateTime() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 != null) {
            return dyhModel2.getLastUpdate();
        }
        return null;
    }

    @Bindable
    public String getDyhLogo() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 != null) {
            return dyhModel2.getLogo();
        }
        return null;
    }

    @Bindable
    public String getFromInfo() {
        DyhModel dyhModel2 = this.dyhModel;
        if (dyhModel2 != null && !TextUtils.isEmpty(dyhModel2.getFromInfo())) {
            return this.dyhModel.getFromInfo();
        }
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 != null) {
            return dyhArticle2.getFromInfo();
        }
        return null;
    }

    public void setDyhArticle(DyhArticle dyhArticle2) {
        this.dyhArticle = dyhArticle2;
        if (dyhArticle2.getDyhModel() != null) {
            this.dyhModel = dyhArticle2.getDyhModel();
        }
        if (dyhArticle2 != null && EntityUtils.isDyhArticleFeedType(dyhArticle2.getEntityTemplate())) {
            boolean z = false;
            boolean z2 = dyhArticle2.getDyhModel() == null || dyhArticle2.getDyhModel().isDyhFollowed();
            if (!DataManager.getInstance().getLoginSession().isLogin() || !z2) {
                z = true;
            }
            setIsShowActionView(z);
        }
        notifyPropertyChanged(78);
        notifyPropertyChanged(85);
    }

    @Bindable
    public DyhArticle getDyhArticle() {
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 != null) {
            return dyhArticle2;
        }
        return null;
    }

    @Bindable
    public String getEditLevel() {
        if (getDyhModel() == null || getDyhModel().getEditorInfo() == null || TextUtils.isEmpty(getDyhModel().getEditorInfo().getEditorLevel())) {
            return null;
        }
        return getDyhModel().getEditorInfo().getEditorLevel();
    }
}
