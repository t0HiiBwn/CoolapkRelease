package com.coolapk.market.view.dyhv8;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.coolapk.market.view.base.TabActivity;

public class DyhListActivity extends TabActivity {
    public static final String KEY_LIST_TYPE = "LIST_TYPE";

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"我关注的", "我管理的"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        return getTabTitles()[i];
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        boolean booleanExtra = getIntent().getBooleanExtra("isFollow", false);
        getToolbar().setTitle(booleanExtra ? "我的看看号" : "更多看看号");
        if (i == 0) {
            String stringExtra = getIntent().getStringExtra("LIST_TYPE");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "";
            }
            return MyDyhListFragment.newInstance(booleanExtra, stringExtra);
        } else if (i != 1) {
            return null;
        } else {
            return MyEditDyhListFragment.newInstance();
        }
    }
}
