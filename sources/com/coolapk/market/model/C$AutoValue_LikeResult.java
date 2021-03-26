package com.coolapk.market.model;

import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_LikeResult  reason: invalid class name */
abstract class C$AutoValue_LikeResult extends LikeResult {
    private final int count;
    private final List<String> recentLikeList;
    private final List<RelatedData> userLikeList;

    C$AutoValue_LikeResult(int i, List<String> list, List<RelatedData> list2) {
        this.count = i;
        Objects.requireNonNull(list, "Null recentLikeList");
        this.recentLikeList = list;
        this.userLikeList = list2;
    }

    @Override // com.coolapk.market.model.LikeResult
    public int getCount() {
        return this.count;
    }

    @Override // com.coolapk.market.model.LikeResult
    public List<String> getRecentLikeList() {
        return this.recentLikeList;
    }

    @Override // com.coolapk.market.model.LikeResult
    public List<RelatedData> getUserLikeList() {
        return this.userLikeList;
    }

    public String toString() {
        return "LikeResult{count=" + this.count + ", recentLikeList=" + this.recentLikeList + ", userLikeList=" + this.userLikeList + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LikeResult)) {
            return false;
        }
        LikeResult likeResult = (LikeResult) obj;
        if (this.count == likeResult.getCount() && this.recentLikeList.equals(likeResult.getRecentLikeList())) {
            List<RelatedData> list = this.userLikeList;
            if (list == null) {
                if (likeResult.getUserLikeList() == null) {
                    return true;
                }
            } else if (list.equals(likeResult.getUserLikeList())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.count ^ 1000003) * 1000003) ^ this.recentLikeList.hashCode()) * 1000003;
        List<RelatedData> list = this.userLikeList;
        return hashCode ^ (list == null ? 0 : list.hashCode());
    }
}
