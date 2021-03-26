package com.coolapk.market.view.search;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface SearchFeedContract {
    public static final String SEARCH_TYPE_COMMENT = "feed";
    public static final String SEARCH_TYPE_DISCOVERY = "discovery";
    public static final String SEARCH_TYPE_FEED = "comment";
    public static final String SEARCH_TYPE_PICTURE = "picture";

    @Retention(RetentionPolicy.SOURCE)
    public @interface SearchFeedType {
    }
}
