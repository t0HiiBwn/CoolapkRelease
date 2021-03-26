package com.coolapk.market.view.feed;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.TabActivity;

public class AllFeedActivity extends TabActivity {
    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 0;
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DataManager.getInstance().getLoginSession().isAdmin()) {
            getToolbar().setTitle("全站动态");
            return;
        }
        throw new RuntimeException("Access Refuse!!!");
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"全部", "动态", "回复", "评论", "应用集", "发现", "链接", "酷图", "问题", "回答", "图文", "点评"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        switch (i) {
            case 0:
                return AdminFeedFragment.Companion.newInstance("all", false);
            case 1:
                return AdminFeedFragment.Companion.newInstance("feed", false);
            case 2:
                return AdminFeedReplyFragment.newInstance(false);
            case 3:
                return AdminFeedFragment.Companion.newInstance("comment", false);
            case 4:
                return AdminFeedFragment.Companion.newInstance("album", false);
            case 5:
                return AdminFeedFragment.Companion.newInstance("discovery", false);
            case 6:
                return AdminFeedFragment.Companion.newInstance("url", false);
            case 7:
                return AllPictureFragment.newInstance("picture", false);
            case 8:
                return AdminFeedFragment.Companion.newInstance("question", false);
            case 9:
                return AdminFeedFragment.Companion.newInstance("answer", false);
            case 10:
                return AdminFeedFragment.Companion.newInstance("feedArticle", false);
            case 11:
                return AdminFeedFragment.Companion.newInstance("rating", false);
            default:
                throw new RuntimeException("fuck fuck fuck...");
        }
    }
}
