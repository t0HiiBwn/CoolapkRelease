package com.coolapk.market.view.center;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.ToolbarActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/center/MyCardManagerActivity;", "Lcom/coolapk/market/view/base/ToolbarActivity;", "Lcom/coolapk/market/view/center/MyCardManagerFragment;", "()V", "onBackPressed", "", "onCreateFragment", "onSlideClosed", "submitCardConfig", "fragment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MyCardManagerActivity.kt */
public final class MyCardManagerActivity extends ToolbarActivity<MyCardManagerFragment> {
    @Override // com.coolapk.market.view.base.ToolbarActivity
    public MyCardManagerFragment onCreateFragment() {
        setTitle("卡片管理");
        getToolbar().setNavigationOnClickListener(new MyCardManagerActivity$onCreateFragment$1(this));
        return MyCardManagerFragment.Companion.newInstance();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSlideClosed() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131363614);
        if (findFragmentById != null && (findFragmentById instanceof MyCardManagerFragment)) {
            MyCardManagerFragment myCardManagerFragment = (MyCardManagerFragment) findFragmentById;
            if (myCardManagerFragment.isEdited()) {
                submitCardConfig(myCardManagerFragment);
                return;
            }
        }
        super.onSlideClosed();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131363614);
        if (findFragmentById != null && (findFragmentById instanceof MyCardManagerFragment)) {
            MyCardManagerFragment myCardManagerFragment = (MyCardManagerFragment) findFragmentById;
            if (myCardManagerFragment.isEdited()) {
                submitCardConfig(myCardManagerFragment);
                return;
            }
        }
        super.onBackPressed();
    }

    private final void submitCardConfig(MyCardManagerFragment myCardManagerFragment) {
        ProgressDialogFragment newInstance = ProgressDialogFragment.Companion.newInstance();
        newInstance.setCancelable(false);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        DataManager.getInstance().updateTitleConfig(myCardManagerFragment.submitData()).compose(RxUtils.applyIOSchedulers()).subscribe(new MyCardManagerActivity$submitCardConfig$1(this, newInstance), new MyCardManagerActivity$submitCardConfig$2(this, newInstance));
    }
}
