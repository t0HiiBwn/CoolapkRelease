package com.coolapk.market.view.app;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.app.RelateDataListContract;
import com.coolapk.market.view.base.ToolbarActivity;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import java.util.List;
import rx.Observable;

public class RelateDataListActivity extends ToolbarActivity<RelateDataListFragment> {
    public static final String ACTION_DISCOVERY_OF_THEIRS = "ACTION_DISCOVERY_OF_THEIRS";
    public static final String ACTION_RATING_OF_THEIRS = "ACTION_RATING_OF_THEIRS";
    public static final String KEY_APK_ID = "APK_ID";

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public RelateDataListFragment onCreateFragment() {
        String action = getIntent().getAction();
        action.hashCode();
        if (action.equals("ACTION_DISCOVERY_OF_THEIRS")) {
            setTitle(getString(2131887307));
        } else if (!action.equals("ACTION_RATING_OF_THEIRS")) {
            throw new RuntimeException("Unknown action: " + action);
        } else {
            setTitle(getString(2131887357));
        }
        return RelateDataListFragment.newInstance();
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(RelateDataListFragment relateDataListFragment) {
        super.onFragmentCreated((RelateDataListActivity) relateDataListFragment);
        setPresenter();
    }

    private void setPresenter() {
        AsyncListContract.Presenter presenter;
        String action = getIntent().getAction();
        String stringExtra = getIntent().getStringExtra("APK_ID");
        action.hashCode();
        if (action.equals("ACTION_DISCOVERY_OF_THEIRS")) {
            presenter = new DiscoveryPresenter((RelateDataListContract.View) getContentFragment(), stringExtra);
        } else if (!action.equals("ACTION_RATING_OF_THEIRS")) {
            throw new RuntimeException("Unknown action: " + action);
        } else {
            presenter = new RatingPresenter((RelateDataListContract.View) getContentFragment(), stringExtra);
        }
        ((RelateDataListFragment) getContentFragment()).setPresenter(presenter);
    }

    private static class DiscoveryPresenter extends RelateDataListContract.Presenter {
        private String apkId;
        private final RelateDataListContract.View view;

        public DiscoveryPresenter(RelateDataListContract.View view2, String str) {
            super(view2);
            this.view = view2;
            this.apkId = str;
        }

        @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
        protected Observable<Result<List<RelatedData>>> onCreateRequest(boolean z, int i) {
            return DataManager.getInstance().getDiscovererList(this.apkId, i, this.view.findFirstItem(), this.view.findLastItem());
        }
    }

    private static class RatingPresenter extends RelateDataListContract.Presenter {
        private String apkId;
        private final RelateDataListContract.View view;

        public RatingPresenter(RelateDataListContract.View view2, String str) {
            super(view2);
            this.view = view2;
            this.apkId = str;
        }

        @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
        protected Observable<Result<List<RelatedData>>> onCreateRequest(boolean z, int i) {
            return DataManager.getInstance().getRatingUserList(this.apkId, i, this.view.findFirstItem(), this.view.findLastItem());
        }
    }
}
