package com.coolapk.market.model;

import java.util.Objects;

final class AutoValue_Article extends Article {
    private final String content;
    private final String coverUrl;
    private final long created;
    private final long id;
    private final long modified;
    private final String title;

    AutoValue_Article(long j, String str, String str2, String str3, long j2, long j3) {
        this.id = j;
        Objects.requireNonNull(str, "Null title");
        this.title = str;
        Objects.requireNonNull(str2, "Null coverUrl");
        this.coverUrl = str2;
        Objects.requireNonNull(str3, "Null content");
        this.content = str3;
        this.modified = j2;
        this.created = j3;
    }

    @Override // com.coolapk.market.model.Article
    public long id() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Article
    public String title() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Article
    public String coverUrl() {
        return this.coverUrl;
    }

    @Override // com.coolapk.market.model.Article
    public String content() {
        return this.content;
    }

    @Override // com.coolapk.market.model.Article
    public long modified() {
        return this.modified;
    }

    @Override // com.coolapk.market.model.Article
    public long created() {
        return this.created;
    }

    public String toString() {
        return "Article{id=" + this.id + ", title=" + this.title + ", coverUrl=" + this.coverUrl + ", content=" + this.content + ", modified=" + this.modified + ", created=" + this.created + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Article)) {
            return false;
        }
        Article article = (Article) obj;
        if (this.id != article.id() || !this.title.equals(article.title()) || !this.coverUrl.equals(article.coverUrl()) || !this.content.equals(article.content()) || this.modified != article.modified() || this.created != article.created()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int hashCode = this.title.hashCode();
        long j2 = this.modified;
        long hashCode2 = (long) (((int) (((long) ((((((hashCode ^ (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003)) * 1000003) ^ this.coverUrl.hashCode()) * 1000003) ^ this.content.hashCode()) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003);
        long j3 = this.created;
        return (int) (hashCode2 ^ (j3 ^ (j3 >>> 32)));
    }
}
