package com.coolapk.market.view.contact;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.ToolbarActivity;

public class ContactPickActivity extends ToolbarActivity<ContactPickFragment> {
    @Override // com.coolapk.market.view.base.ToolbarActivity
    public ContactPickFragment onCreateFragment() {
        return ContactPickFragment.newInstance(getIntent().getIntExtra("EXTRA_MAX_COUNT", Integer.MAX_VALUE), getIntent().getStringExtra("EXTRA_ERROR_TEXT"));
    }

    /* access modifiers changed from: protected */
    public void onFragmentCreated(ContactPickFragment contactPickFragment) {
        contactPickFragment.setPresenter(new ContactPickPresenter(contactPickFragment, DataManager.getInstance().getLoginSession().getUid()));
    }
}
