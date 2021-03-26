package com.coolapk.market.view.user.edit;

import com.coolapk.market.view.base.ToolbarActivity;

public class CountyListActivity extends ToolbarActivity<CountyListFragment> {
    @Override // com.coolapk.market.view.base.ToolbarActivity
    public CountyListFragment onCreateFragment() {
        return new CountyListFragment();
    }
}
