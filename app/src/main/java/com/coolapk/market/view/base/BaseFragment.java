package com.coolapk.market.view.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import kotlin.random.Random;

public class BaseFragment extends Fragment {
    private static final String KEY_IDENTITY = "IDENTITY~~";
    private static final String KEY_PERSIST_ID = "PERSIST_ID";
    private String mFragmentStateID;
    private String mIdentity;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.base.BaseFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseFragment> T getFragment() {
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.mIdentity) && bundle != null) {
            this.mIdentity = bundle.getString("IDENTITY~~");
        }
        if (bundle != null) {
            this.mFragmentStateID = bundle.getString("PERSIST_ID");
            return;
        }
        this.mFragmentStateID = getClass().getSimpleName() + "_" + hashCode() + "_" + Random.Default.nextInt(100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("IDENTITY~~", this.mIdentity);
        bundle.putString("PERSIST_ID", this.mFragmentStateID);
    }

    public String getFragmentStateID() {
        return this.mFragmentStateID;
    }

    public void setRecordId(String str) {
        this.mIdentity = str;
    }

    public String getRecordId() {
        return this.mIdentity;
    }

    public String getFixedRecordId() {
        String str = this.mIdentity;
        return TextUtils.isEmpty(str) ? getClass().getSimpleName() : str;
    }
}
