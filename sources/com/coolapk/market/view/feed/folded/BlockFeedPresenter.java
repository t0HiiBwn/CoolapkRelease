package com.coolapk.market.view.feed.folded;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.feed.FeedContract;
import java.util.List;
import rx.Observable;

public class BlockFeedPresenter extends FeedContract.Presenter {
    private String listType;
    private String tag;
    private final FeedContract.View view;

    public BlockFeedPresenter(FeedContract.View view2, String str, String str2) {
        super(view2);
        this.view = view2;
        this.tag = str;
        this.listType = str2;
    }

    @Override // com.coolapk.market.view.feed.FeedContract.Presenter
    public Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        String str = this.listType;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 380987267:
                if (str.equals("TYPE_COMMENT_LIST")) {
                    c = 0;
                    break;
                }
                break;
            case 1464296872:
                if (str.equals("TYPE_TAG_LIST")) {
                    c = 1;
                    break;
                }
                break;
            case 1948944825:
                if (str.equals("TYPE_PHONE_TAG_LIST")) {
                    c = 2;
                    break;
                }
                break;
            case 2123995098:
                if (str.equals("TYPE_FEED_LIST")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 3:
                return DataManager.getInstance().getAdminNewestList(this.listType, i, this.view.findFirstItem(), this.view.findLastItem(), 1);
            case 1:
                return DataManager.getInstance().getTagFeedList(this.tag, i, this.view.findFirstItem(), this.view.findLastItem(), 1);
            case 2:
                return DataManager.getInstance().getPhoneTopicDetail(this.tag, i, this.view.findFirstItem(), this.view.findLastItem(), "all", 1);
            default:
                return null;
        }
    }
}
