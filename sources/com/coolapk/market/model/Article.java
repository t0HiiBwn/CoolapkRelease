package com.coolapk.market.model;

public abstract class Article {
    public abstract String content();

    public abstract String coverUrl();

    public abstract long created();

    public abstract long id();

    public abstract long modified();

    public abstract String title();

    public static Article create(long j, String str, String str2, String str3, long j2, long j3) {
        return new AutoValue_Article(j, str, str2, str3, j2, j3);
    }
}
