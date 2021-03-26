package com.coolapk.market.view.feed;

import android.os.Bundle;
import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.view.cardlist.CompatFeedListFragment;

public class EditorChoiceActivity extends ToolbarActivity<CompatFeedListFragment> {
    public static final String KEY_TITLE = "title";

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getIntent().getStringExtra("title"));
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public CompatFeedListFragment onCreateFragment() {
        return CompatFeedListFragment.newInstance();
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(CompatFeedListFragment compatFeedListFragment) {
        super.onFragmentCreated((EditorChoiceActivity) compatFeedListFragment);
        compatFeedListFragment.setPresenter(new EditorChoicePresenter(compatFeedListFragment));
    }
}
