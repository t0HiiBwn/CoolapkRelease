package com.coolapk.market.event;

import com.coolapk.market.model.DyhArticle;

public class DyhArticleSetTopEvent {
    private String dyhArticleId;
    private boolean isTop;

    public DyhArticleSetTopEvent(boolean z, String str) {
        this.isTop = z;
        this.dyhArticleId = str;
    }

    public String getDyhArticleId() {
        return this.dyhArticleId;
    }

    public boolean isTop() {
        return this.isTop;
    }

    public DyhArticle handleEvent(DyhArticle dyhArticle) {
        DyhArticle.Builder newBuilder = DyhArticle.newBuilder(dyhArticle);
        newBuilder.isStickTop(this.isTop ? 1 : 0);
        return newBuilder.build();
    }
}
