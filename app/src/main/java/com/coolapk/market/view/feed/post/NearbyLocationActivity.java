package com.coolapk.market.view.feed.post;

import android.os.Bundle;
import android.text.TextUtils;
import com.coolapk.market.model.LocationInfo;
import com.coolapk.market.view.base.ToolbarActivity;

public class NearbyLocationActivity extends ToolbarActivity<NearbyLocationFragment> {
    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public NearbyLocationFragment onCreateFragment() {
        setTitle("附近的地点");
        LocationInfo locationInfo = (LocationInfo) getIntent().getParcelableExtra("locationInfo");
        String stringExtra = getIntent().getStringExtra("KEY_BIND_TYPE");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "feed";
        }
        return NearbyLocationFragment.newInstance(locationInfo, stringExtra);
    }
}
