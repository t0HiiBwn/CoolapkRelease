package com.coolapk.market.view.contact;

import android.os.Bundle;
import com.coolapk.market.view.base.ToolbarActivity;

public class FriendListActivity extends ToolbarActivity<FriendListFragment> {
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_UID = "uid";

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getIntent().getStringExtra("title"));
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public FriendListFragment onCreateFragment() {
        return FriendListFragment.newInstance();
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(FriendListFragment friendListFragment) {
        super.onFragmentCreated((FriendListActivity) friendListFragment);
        friendListFragment.setPresenter(new FriendContactPresenter(friendListFragment, getIntent().getStringExtra("uid")));
    }
}
