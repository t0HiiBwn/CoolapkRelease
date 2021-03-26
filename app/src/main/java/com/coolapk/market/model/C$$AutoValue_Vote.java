package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Vote  reason: invalid class name */
abstract class C$$AutoValue_Vote extends Vote {
    private final int anonymousStatus;
    private final int blockStatus;
    private final int createTime;
    private final String createUid;
    private final long endTime;
    private final String id;
    private final String lastUpdate;
    private final String linkPage;
    private final String linkTag;
    private final Topic linkTagEntity;
    private final int maxSelectNum;
    private final String messageTitle;
    private final int minSelectNum;
    private final String recommendIds;
    private final int showAuthor;
    private final int startTime;
    private final int status;
    private final String topIds;
    private final int totalCommentNum;
    private final int totalOptionNum;
    private final int totalVoteNum;
    private final int type;
    private final int updateTime;
    private final String updateUid;
    private final int userAnonymousStatus;
    private final int userChangeVoteStatus;
    private final String userSelectedOptions;
    private final int userVoteCommentStatus;
    private final List<VoteOption> voteOptions;

    C$$AutoValue_Vote(int i, int i2, int i3, String str, long j, String str2, String str3, String str4, String str5, int i4, int i5, String str6, int i6, int i7, String str7, int i8, int i9, int i10, int i11, int i12, String str8, List<VoteOption> list, String str9, String str10, int i13, int i14, int i15, int i16, Topic topic) {
        this.anonymousStatus = i;
        this.blockStatus = i2;
        this.createTime = i3;
        this.createUid = str;
        this.endTime = j;
        Objects.requireNonNull(str2, "Null id");
        this.id = str2;
        this.lastUpdate = str3;
        this.linkPage = str4;
        this.linkTag = str5;
        this.maxSelectNum = i4;
        this.minSelectNum = i5;
        this.recommendIds = str6;
        this.startTime = i6;
        this.status = i7;
        this.topIds = str7;
        this.totalCommentNum = i8;
        this.totalOptionNum = i9;
        this.totalVoteNum = i10;
        this.type = i11;
        this.updateTime = i12;
        this.updateUid = str8;
        Objects.requireNonNull(list, "Null voteOptions");
        this.voteOptions = list;
        this.messageTitle = str9;
        this.userSelectedOptions = str10;
        this.userAnonymousStatus = i13;
        this.userVoteCommentStatus = i14;
        this.userChangeVoteStatus = i15;
        this.showAuthor = i16;
        this.linkTagEntity = topic;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("anonymous_status")
    public int getAnonymousStatus() {
        return this.anonymousStatus;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("create_time")
    public int getCreateTime() {
        return this.createTime;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("create_uid")
    public String getCreateUid() {
        return this.createUid;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("end_time")
    public long getEndTime() {
        return this.endTime;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("last_update")
    public String getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("link_page")
    public String getLinkPage() {
        return this.linkPage;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("link_tag")
    public String getLinkTag() {
        return this.linkTag;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("max_select_num")
    public int getMaxSelectNum() {
        return this.maxSelectNum;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("min_select_num")
    public int getMinSelectNum() {
        return this.minSelectNum;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("recommend_ids")
    public String getRecommendIds() {
        return this.recommendIds;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("start_time")
    public int getStartTime() {
        return this.startTime;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("status")
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("top_ids")
    public String getTopIds() {
        return this.topIds;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("total_comment_num")
    public int getTotalCommentNum() {
        return this.totalCommentNum;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("total_option_num")
    public int getTotalOptionNum() {
        return this.totalOptionNum;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("total_vote_num")
    public int getTotalVoteNum() {
        return this.totalVoteNum;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("type")
    public int getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("update_time")
    public int getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("update_uid")
    public String getUpdateUid() {
        return this.updateUid;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("options")
    public List<VoteOption> getVoteOptions() {
        return this.voteOptions;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("message_title")
    public String getMessageTitle() {
        return this.messageTitle;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("user_selected_option")
    public String getUserSelectedOptions() {
        return this.userSelectedOptions;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("user_anonymous_status")
    public int getUserAnonymousStatus() {
        return this.userAnonymousStatus;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("user_vote_comment_status")
    public int getUserVoteCommentStatus() {
        return this.userVoteCommentStatus;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("user_change_vote_status")
    public int getUserChangeVoteStatus() {
        return this.userChangeVoteStatus;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("show_author")
    public int getShowAuthor() {
        return this.showAuthor;
    }

    @Override // com.coolapk.market.model.Vote
    @SerializedName("link_tag_entity")
    public Topic getLinkTagEntity() {
        return this.linkTagEntity;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Vote{anonymousStatus=" + this.anonymousStatus + ", blockStatus=" + this.blockStatus + ", createTime=" + this.createTime + ", createUid=" + this.createUid + ", endTime=" + this.endTime + ", id=" + this.id + ", lastUpdate=" + this.lastUpdate + ", linkPage=" + this.linkPage + ", linkTag=" + this.linkTag + ", maxSelectNum=" + this.maxSelectNum + ", minSelectNum=" + this.minSelectNum + ", recommendIds=" + this.recommendIds + ", startTime=" + this.startTime + ", status=" + this.status + ", topIds=" + this.topIds + ", totalCommentNum=" + this.totalCommentNum + ", totalOptionNum=" + this.totalOptionNum + ", totalVoteNum=" + this.totalVoteNum + ", type=" + this.type + ", updateTime=" + this.updateTime + ", updateUid=" + this.updateUid + ", voteOptions=" + this.voteOptions + ", messageTitle=" + this.messageTitle + ", userSelectedOptions=" + this.userSelectedOptions + ", userAnonymousStatus=" + this.userAnonymousStatus + ", userVoteCommentStatus=" + this.userVoteCommentStatus + ", userChangeVoteStatus=" + this.userChangeVoteStatus + ", showAuthor=" + this.showAuthor + ", linkTagEntity=" + this.linkTagEntity + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vote)) {
            return false;
        }
        Vote vote = (Vote) obj;
        if (this.anonymousStatus == vote.getAnonymousStatus() && this.blockStatus == vote.getBlockStatus() && this.createTime == vote.getCreateTime() && ((str = this.createUid) != null ? str.equals(vote.getCreateUid()) : vote.getCreateUid() == null) && this.endTime == vote.getEndTime() && this.id.equals(vote.getId()) && ((str2 = this.lastUpdate) != null ? str2.equals(vote.getLastUpdate()) : vote.getLastUpdate() == null) && ((str3 = this.linkPage) != null ? str3.equals(vote.getLinkPage()) : vote.getLinkPage() == null) && ((str4 = this.linkTag) != null ? str4.equals(vote.getLinkTag()) : vote.getLinkTag() == null) && this.maxSelectNum == vote.getMaxSelectNum() && this.minSelectNum == vote.getMinSelectNum() && ((str5 = this.recommendIds) != null ? str5.equals(vote.getRecommendIds()) : vote.getRecommendIds() == null) && this.startTime == vote.getStartTime() && this.status == vote.getStatus() && ((str6 = this.topIds) != null ? str6.equals(vote.getTopIds()) : vote.getTopIds() == null) && this.totalCommentNum == vote.getTotalCommentNum() && this.totalOptionNum == vote.getTotalOptionNum() && this.totalVoteNum == vote.getTotalVoteNum() && this.type == vote.getType() && this.updateTime == vote.getUpdateTime() && ((str7 = this.updateUid) != null ? str7.equals(vote.getUpdateUid()) : vote.getUpdateUid() == null) && this.voteOptions.equals(vote.getVoteOptions()) && ((str8 = this.messageTitle) != null ? str8.equals(vote.getMessageTitle()) : vote.getMessageTitle() == null) && ((str9 = this.userSelectedOptions) != null ? str9.equals(vote.getUserSelectedOptions()) : vote.getUserSelectedOptions() == null) && this.userAnonymousStatus == vote.getUserAnonymousStatus() && this.userVoteCommentStatus == vote.getUserVoteCommentStatus() && this.userChangeVoteStatus == vote.getUserChangeVoteStatus() && this.showAuthor == vote.getShowAuthor()) {
            Topic topic = this.linkTagEntity;
            if (topic == null) {
                if (vote.getLinkTagEntity() == null) {
                    return true;
                }
            } else if (topic.equals(vote.getLinkTagEntity())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = (((((this.anonymousStatus ^ 1000003) * 1000003) ^ this.blockStatus) * 1000003) ^ this.createTime) * 1000003;
        String str = this.createUid;
        int i2 = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.endTime;
        int hashCode2 = ((((int) (((long) ((i ^ hashCode) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str2 = this.lastUpdate;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.linkPage;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.linkTag;
        int hashCode5 = (((((hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003) ^ this.maxSelectNum) * 1000003) ^ this.minSelectNum) * 1000003;
        String str5 = this.recommendIds;
        int hashCode6 = (((((hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003) ^ this.startTime) * 1000003) ^ this.status) * 1000003;
        String str6 = this.topIds;
        int hashCode7 = (((((((((((hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003) ^ this.totalCommentNum) * 1000003) ^ this.totalOptionNum) * 1000003) ^ this.totalVoteNum) * 1000003) ^ this.type) * 1000003) ^ this.updateTime) * 1000003;
        String str7 = this.updateUid;
        int hashCode8 = (((hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003) ^ this.voteOptions.hashCode()) * 1000003;
        String str8 = this.messageTitle;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.userSelectedOptions;
        int hashCode10 = (((((((((hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003) ^ this.userAnonymousStatus) * 1000003) ^ this.userVoteCommentStatus) * 1000003) ^ this.userChangeVoteStatus) * 1000003) ^ this.showAuthor) * 1000003;
        Topic topic = this.linkTagEntity;
        if (topic != null) {
            i2 = topic.hashCode();
        }
        return hashCode10 ^ i2;
    }
}
