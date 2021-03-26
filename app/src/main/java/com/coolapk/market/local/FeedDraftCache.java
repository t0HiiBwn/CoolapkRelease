package com.coolapk.market.local;

import android.text.TextUtils;
import com.coolapk.market.model.FeedDraft;
import java.util.ArrayList;
import java.util.List;

public class FeedDraftCache {
    private static final int MAX_SIZE = 10;
    private List<FeedDraft> feedDraftList;

    public void addFeedDraft(FeedDraft feedDraft) {
        ensureList();
        removeDraft(feedDraft);
        while (this.feedDraftList.size() >= 10) {
            List<FeedDraft> list = this.feedDraftList;
            list.remove(list.size() - 1);
        }
        if (!feedDraft.getImageUriList().isEmpty() || !TextUtils.isEmpty(feedDraft.getMessage())) {
            this.feedDraftList.add(0, feedDraft);
        }
    }

    public FeedDraft getDraftLike(FeedDraft feedDraft) {
        ensureList();
        for (int i = 0; i < this.feedDraftList.size(); i++) {
            FeedDraft feedDraft2 = this.feedDraftList.get(i);
            if (feedDraft2.isTemplateOf(feedDraft)) {
                return feedDraft2;
            }
        }
        return null;
    }

    public void removeDraft(FeedDraft feedDraft) {
        ensureList();
        int i = 0;
        while (i < this.feedDraftList.size()) {
            if (this.feedDraftList.get(i).isTemplateOf(feedDraft)) {
                this.feedDraftList.remove(i);
                i--;
            }
            i++;
        }
    }

    private void ensureList() {
        if (this.feedDraftList == null) {
            this.feedDraftList = new ArrayList(10);
        }
    }
}
