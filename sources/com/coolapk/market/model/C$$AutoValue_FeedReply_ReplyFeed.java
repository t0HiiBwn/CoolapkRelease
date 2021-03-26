package com.coolapk.market.model;

import com.coolapk.market.model.FeedReply;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedReply_ReplyFeed  reason: invalid class name */
abstract class C$$AutoValue_FeedReply_ReplyFeed extends FeedReply.ReplyFeed {
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String displayUserName;
    private final String id;
    private final String message;
    private final String pic;
    private final String uid;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_FeedReply_ReplyFeed(String str, UserInfo userInfo2, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.deprecatedUserAvatar = str;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str2;
        this.displayUserName = str3;
        this.id = str4;
        this.uid = str5;
        this.message = str6;
        this.pic = str7;
        this.url = str8;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("userAvatar")
    public String getDeprecatedUserAvatar() {
        return this.deprecatedUserAvatar;
    }

    @Override // com.coolapk.market.model.IUser
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.FeedReply.ReplyFeed
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.FeedReply.ReplyFeed, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.FeedReply.ReplyFeed
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.FeedReply.ReplyFeed
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.FeedReply.ReplyFeed
    public String getUrl() {
        return this.url;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ReplyFeed{deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", uid=" + this.uid + ", message=" + this.message + ", pic=" + this.pic + ", url=" + this.url + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedReply.ReplyFeed)) {
            return false;
        }
        FeedReply.ReplyFeed replyFeed = (FeedReply.ReplyFeed) obj;
        String str = this.deprecatedUserAvatar;
        if (str != null ? str.equals(replyFeed.getDeprecatedUserAvatar()) : replyFeed.getDeprecatedUserAvatar() == null) {
            UserInfo userInfo2 = this.userInfo;
            if (userInfo2 != null ? userInfo2.equals(replyFeed.getUserInfo()) : replyFeed.getUserInfo() == null) {
                String str2 = this.deprecatedUserName;
                if (str2 != null ? str2.equals(replyFeed.getDeprecatedUserName()) : replyFeed.getDeprecatedUserName() == null) {
                    String str3 = this.displayUserName;
                    if (str3 != null ? str3.equals(replyFeed.getDisplayUserName()) : replyFeed.getDisplayUserName() == null) {
                        String str4 = this.id;
                        if (str4 != null ? str4.equals(replyFeed.getId()) : replyFeed.getId() == null) {
                            String str5 = this.uid;
                            if (str5 != null ? str5.equals(replyFeed.getUid()) : replyFeed.getUid() == null) {
                                String str6 = this.message;
                                if (str6 != null ? str6.equals(replyFeed.getMessage()) : replyFeed.getMessage() == null) {
                                    String str7 = this.pic;
                                    if (str7 != null ? str7.equals(replyFeed.getPic()) : replyFeed.getPic() == null) {
                                        String str8 = this.url;
                                        if (str8 == null) {
                                            if (replyFeed.getUrl() == null) {
                                                return true;
                                            }
                                        } else if (str8.equals(replyFeed.getUrl())) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.deprecatedUserAvatar;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode2 = (hashCode ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str2 = this.deprecatedUserName;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.displayUserName;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.id;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.uid;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.message;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.pic;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.url;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode8 ^ i;
    }
}
