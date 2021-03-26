package com.coolapk.market.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_VoteOption  reason: invalid class name */
abstract class C$$AutoValue_VoteOption extends VoteOption {
    private final String color;
    private final String id;
    private final int order;
    private final String title;
    private final int totalCommentNum;
    private final int totalSelectNum;
    private final String voteId;

    C$$AutoValue_VoteOption(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        this.color = str;
        this.order = i;
        Objects.requireNonNull(str2, "Null id");
        this.id = str2;
        this.title = str3;
        this.totalCommentNum = i2;
        this.totalSelectNum = i3;
        this.voteId = str4;
    }

    @Override // com.coolapk.market.model.VoteOption
    @SerializedName("color")
    public String getColor() {
        return this.color;
    }

    @Override // com.coolapk.market.model.VoteOption
    @SerializedName("order")
    public int getOrder() {
        return this.order;
    }

    @Override // com.coolapk.market.model.VoteOption
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.VoteOption
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.VoteOption
    @SerializedName("total_comment_num")
    public int getTotalCommentNum() {
        return this.totalCommentNum;
    }

    @Override // com.coolapk.market.model.VoteOption
    @SerializedName("total_select_num")
    public int getTotalSelectNum() {
        return this.totalSelectNum;
    }

    @Override // com.coolapk.market.model.VoteOption
    @SerializedName("vote_id")
    public String getVoteId() {
        return this.voteId;
    }

    @Override // java.lang.Object
    public String toString() {
        return "VoteOption{color=" + this.color + ", order=" + this.order + ", id=" + this.id + ", title=" + this.title + ", totalCommentNum=" + this.totalCommentNum + ", totalSelectNum=" + this.totalSelectNum + ", voteId=" + this.voteId + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoteOption)) {
            return false;
        }
        VoteOption voteOption = (VoteOption) obj;
        String str2 = this.color;
        if (str2 != null ? str2.equals(voteOption.getColor()) : voteOption.getColor() == null) {
            if (this.order == voteOption.getOrder() && this.id.equals(voteOption.getId()) && ((str = this.title) != null ? str.equals(voteOption.getTitle()) : voteOption.getTitle() == null) && this.totalCommentNum == voteOption.getTotalCommentNum() && this.totalSelectNum == voteOption.getTotalSelectNum()) {
                String str3 = this.voteId;
                if (str3 == null) {
                    if (voteOption.getVoteId() == null) {
                        return true;
                    }
                } else if (str3.equals(voteOption.getVoteId())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.color;
        int i = 0;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.order) * 1000003) ^ this.id.hashCode()) * 1000003;
        String str2 = this.title;
        int hashCode2 = (((((hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.totalCommentNum) * 1000003) ^ this.totalSelectNum) * 1000003;
        String str3 = this.voteId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 ^ i;
    }
}
