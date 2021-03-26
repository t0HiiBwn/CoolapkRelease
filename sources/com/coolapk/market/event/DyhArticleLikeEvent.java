package com.coolapk.market.event;

import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.UserAction;

public class DyhArticleLikeEvent {
    private final String id;
    private final boolean liked;
    private final int result;

    public DyhArticleLikeEvent(String str, boolean z, int i) {
        this.id = str;
        this.liked = z;
        this.result = i;
    }

    public int getResult() {
        return this.result;
    }

    public String getId() {
        return this.id;
    }

    public boolean isLiked() {
        return this.liked;
    }

    public DyhArticle handleEvent(DyhArticle dyhArticle) {
        DyhArticle.Builder newBuilder = DyhArticle.newBuilder(dyhArticle);
        if (isLiked()) {
            newBuilder.userAction(UserAction.newBuilder(dyhArticle.getUserAction()).like(1).build());
        } else {
            newBuilder.userAction(UserAction.newBuilder(dyhArticle.getUserAction()).like(0).build());
        }
        newBuilder.likeNum(this.result);
        return newBuilder.build();
    }
}
