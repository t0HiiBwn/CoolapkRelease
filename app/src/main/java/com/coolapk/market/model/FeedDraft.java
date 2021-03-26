package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_FeedDraft;
import java.util.ArrayList;
import java.util.List;

public abstract class FeedDraft implements Parcelable {
    public static final String TYPE_ARTICLE_REPLY = "article_reply";
    public static final String TYPE_DYH_ARTICLE_COMMENT = "dyh_article_comment";
    public static final String TYPE_DYH_ARTICLE_REPLY = "dyh_article_reply";
    public static final String TYPE_FEED_COMMENT = "feed_comment";
    public static final String TYPE_FORWARD = "forward";
    public static final String TYPE_LIVE_DISCUSS = "live_discuss";
    public static final String TYPE_LIVE_MESSAGE = "live_message";
    public static final String TYPE_PM = "message";
    public static final String TYPE_REPLY = "reply";

    public static abstract class Builder {
        public abstract FeedDraft build();

        public abstract Builder setExtraData(String str);

        public abstract Builder setExtraId(String str);

        public abstract Builder setImageUriList(List<ImageUrl> list);

        public abstract Builder setMessage(String str);

        public abstract Builder setType(String str);
    }

    public abstract String getExtraData();

    public abstract String getExtraId();

    public abstract List<ImageUrl> getImageUriList();

    public abstract String getMessage();

    public abstract String getType();

    public int getImageCount() {
        return getImageUriList().size();
    }

    public static Builder builder() {
        return new C$AutoValue_FeedDraft.Builder().setImageUriList(new ArrayList());
    }

    public static Builder builder(FeedDraft feedDraft) {
        return new C$AutoValue_FeedDraft.Builder(feedDraft);
    }

    public boolean isTemplateOf(FeedDraft feedDraft) {
        return getType().equals(feedDraft.getType()) && (getExtraId() != null ? getExtraId().equals(feedDraft.getExtraId()) : feedDraft.getExtraId() == null) && (getExtraData() != null ? getExtraData().equals(feedDraft.getExtraData()) : feedDraft.getExtraData() == null);
    }
}
