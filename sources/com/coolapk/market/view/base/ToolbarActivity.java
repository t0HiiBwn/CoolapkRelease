package com.coolapk.market.view.base;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.ToolbarLayoutBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.FastReturnView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class ToolbarActivity<FragmentType extends Fragment> extends FakeStatusBarActivity implements TranslucentActivity {
    private ToolbarLayoutBinding binding;
    private FragmentType contentFragment;
    private FloatingActionButton fab;
    private Toolbar toolbar;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public abstract FragmentType onCreateFragment();

    protected void onFragmentCreated(FragmentType fragmenttype) {
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ToolbarLayoutBinding toolbarLayoutBinding = (ToolbarLayoutBinding) DataBindingUtil.setContentView(this, 2131559207);
        this.binding = toolbarLayoutBinding;
        Toolbar toolbar2 = toolbarLayoutBinding.toolbar;
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        this.toolbar.setTitle(getTitle());
        this.toolbar.setNavigationIcon(2131231166);
        ViewExtendsKt.setTintColor(this.toolbar);
        ViewUtil.doubleClickListener(this.toolbar, new ViewUtil.OnDoubleClickListener() {
            /* class com.coolapk.market.view.base.ToolbarActivity.AnonymousClass1 */

            @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
            public boolean onDoubleClick(View view) {
                Fragment fragment = ToolbarActivity.this.contentFragment;
                if (!(fragment instanceof ScrollableFragment) || !fragment.isVisible()) {
                    return false;
                }
                ((ScrollableFragment) fragment).scrollToTop(true);
                return true;
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentType fragmenttype = (FragmentType) supportFragmentManager.findFragmentById(2131363614);
        this.contentFragment = fragmenttype;
        if (fragmenttype == null) {
            FragmentType onCreateFragment = onCreateFragment();
            this.contentFragment = onCreateFragment;
            if (onCreateFragment == null) {
                finish();
                return;
            }
            supportFragmentManager.beginTransaction().add(2131363614, this.contentFragment).commit();
        }
        FragmentType fragmenttype2 = this.contentFragment;
        if (fragmenttype2 != null) {
            onFragmentCreated(fragmenttype2);
            setupFastReturnView();
        }
    }

    protected void setupFastReturnView() {
        FastReturnView fastReturnView = new FastReturnView(this);
        fastReturnView.addTo(this.binding.mainContent);
        fastReturnView.bindFragment(this.contentFragment);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public Toolbar getToolbar() {
        return this.toolbar;
    }

    public AppBarLayout getAppBarLayout() {
        return this.binding.appBar;
    }

    public ToolbarLayoutBinding getBinding() {
        return this.binding;
    }

    public FragmentType getContentFragment() {
        return this.contentFragment;
    }

    public int getContentId() {
        return this.binding.toolbarContentFragment.getId();
    }

    public FloatingActionButton getFab() {
        ensureFab();
        return this.fab;
    }

    private void ensureFab() {
        if (this.fab == null) {
            this.binding.fabStub.getViewStub().inflate();
            this.fab = (FloatingActionButton) this.binding.fabStub.getRoot();
            fixFabLayout();
        }
    }

    private void fixFabLayout() {
        if (isNavigationBarTranslucent()) {
            int navigationBarHeight = UiUtils.getNavigationBarHeight(getActivity());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fab.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin + navigationBarHeight);
            this.fab.requestLayout();
        }
    }

    public boolean isFragmentVisible() {
        FragmentType fragmenttype = this.contentFragment;
        return fragmenttype != null && fragmenttype.isVisible();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
        changeBaseTheme();
        ViewExtendsKt.setTintColor(this.toolbar);
        this.binding.appBar.setBackgroundColor(appTheme.getColorPrimary());
        FloatingActionButton floatingActionButton = this.fab;
        if (floatingActionButton != null) {
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(appTheme.getColorAccent()));
        }
        recreateFragmentOnThemeChange();
    }

    private void recreateFragmentOnThemeChange() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(2131363614);
        FragmentType onCreateFragment = onCreateFragment();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        if (findFragmentById != null && findFragmentById.isAdded()) {
            onCreateFragment.setInitialSavedState(supportFragmentManager.saveFragmentInstanceState(findFragmentById));
            beginTransaction.remove(findFragmentById);
        }
        onFragmentCreated(onCreateFragment);
        beginTransaction.add(2131363614, onCreateFragment).commitAllowingStateLoss();
        this.contentFragment = onCreateFragment;
        this.binding.toolbarContentFragment.post(new Runnable() {
            /* class com.coolapk.market.view.base.$$Lambda$ToolbarActivity$GzAxyNSoJUbrPvB4izFAl525s */

            @Override // java.lang.Runnable
            public final void run() {
                ToolbarActivity.this.lambda$recreateFragmentOnThemeChange$0$ToolbarActivity();
            }
        });
    }

    public /* synthetic */ void lambda$recreateFragmentOnThemeChange$0$ToolbarActivity() {
        View view = this.contentFragment.getView();
        if (view != null && view.getMeasuredWidth() <= 0) {
            ViewExtendsKt.requestLayoutRecursive(view);
        }
    }
}
