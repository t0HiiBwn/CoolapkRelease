package com.coolapk.market.event;

import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.UserAction;

public class DyhArticleEvent {
    private int actionNum;
    private int actionType;
    private final String id;
    private boolean isSecelted;

    public DyhArticleEvent(int i, int i2, String str, boolean z) {
        this.actionNum = i2;
        this.actionType = i;
        this.id = str;
        this.isSecelted = z;
    }

    public boolean isSecelted() {
        return this.isSecelted;
    }

    public int getActionNum() {
        return this.actionNum;
    }

    public String getId() {
        return this.id;
    }

    public int getActionType() {
        return this.actionType;
    }

    public DyhArticle handleEvent(DyhArticle dyhArticle) {
        if (this.actionType == 0) {
            DyhArticle.Builder newBuilder = DyhArticle.newBuilder(dyhArticle);
            if (isSecelted()) {
                newBuilder.userAction(UserAction.newBuilder(dyhArticle.getUserAction()).like(1).build());
            } else {
                newBuilder.userAction(UserAction.newBuilder(dyhArticle.getUserAction()).like(0).build());
            }
            newBuilder.likeNum(this.actionNum);
            return newBuilder.build();
        }
        DyhArticle.Builder newBuilder2 = DyhArticle.newBuilder(dyhArticle);
        if (isSecelted()) {
            newBuilder2.userAction(UserAction.newBuilder(dyhArticle.getUserAction()).collect(1).build());
        } else {
            newBuilder2.userAction(UserAction.newBuilder(dyhArticle.getUserAction()).collect(0).build());
        }
        newBuilder2.favNum(this.actionNum);
        return newBuilder2.build();
    }
}
