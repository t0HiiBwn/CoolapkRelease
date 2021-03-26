package com.coolapk.market.view.feed;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.TabActivity;

public class SpamActivity extends TabActivity {
    public static final int ALJH = 0;
    public static final String TYPE = "TYPE";
    public static final int TYPE_ALI = 0;
    public static final int TYPE_YIDUN = 1;
    public static final int WYYD = 1;
    private boolean isAL;
    private int type;

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i = getIntent().getExtras().getInt("TYPE");
        this.type = i;
        this.isAL = i == 0;
        super.onCreate(bundle);
        if (!DataManager.getInstance().getLoginSession().isAdmin()) {
            throw new RuntimeException("Access Refuse!!!");
        } else if (this.isAL) {
            getToolbar().setTitle("阿里鉴黄");
        } else {
            getToolbar().setTitle("网易鉴黄");
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        if (this.isAL) {
            return new String[]{"色情", "政治", "广告", "文本", "色情回复", "政治回复", "广告回复", "文本回复"};
        }
        return new String[]{"色情", "政治", "广告", "文本", "色情回复", "政治回复", "广告回复", "文本回复"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return onCreateTabs().length < 5 ? 1 : 0;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        switch (i) {
            case 0:
                if (this.isAL) {
                    return SpamFeedListFragment.newInstance("ali", "porn", "image");
                }
                return SpamFeedListFragment.newInstance("yidun", "porn", "image");
            case 1:
                if (this.isAL) {
                    return SpamFeedListFragment.newInstance("ali", "political", "image");
                }
                return SpamFeedListFragment.newInstance("yidun", "political", "image");
            case 2:
                if (this.isAL) {
                    return SpamFeedListFragment.newInstance("ali", "ad", "image");
                }
                return SpamFeedListFragment.newInstance("yidun", "ad", "image");
            case 3:
                if (this.isAL) {
                    return SpamFeedListFragment.newInstance("ali", "", "text");
                }
                return SpamFeedListFragment.newInstance("yidun", "", "text");
            case 4:
                if (this.isAL) {
                    return SpamFeedReplyListFragment.newInstance("ali", "porn", "image");
                }
                return SpamFeedReplyListFragment.newInstance("yidun", "porn", "image");
            case 5:
                if (this.isAL) {
                    return SpamFeedReplyListFragment.newInstance("ali", "political", "image");
                }
                return SpamFeedReplyListFragment.newInstance("yidun", "political", "image");
            case 6:
                if (this.isAL) {
                    return SpamFeedReplyListFragment.newInstance("ali", "ad", "image");
                }
                return SpamFeedReplyListFragment.newInstance("yidun", "ad", "image");
            case 7:
                if (this.isAL) {
                    return SpamFeedReplyListFragment.newInstance("ali", "", "text");
                }
                return SpamFeedReplyListFragment.newInstance("yidun", "", "text");
            default:
                throw new RuntimeException("fuck fuck fuck...");
        }
    }
}
