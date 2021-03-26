package com.coolapk.market.view.album;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.main.AlbumListContract;
import com.coolapk.market.view.main.AlbumListFragment;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;

public class UserAlbumListActivity extends AlphaToolbarActivity {
    public static final String EXTRA_UID = "uid";
    private String uid;

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uid = getIntent().getStringExtra("uid");
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.album.$$Lambda$UserAlbumListActivity$kBzA3THzhfYL_IpL_14mU8TVW4 */

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserAlbumListActivity.this.lambda$onCreate$0$UserAlbumListActivity(view);
            }
        });
        setToolbarTitle("我的应用集");
        this.binding.mainContent.addOnInsetChangeListener(new DrawSystemBarFrameLayout.OnInsetChangeListener() {
            /* class com.coolapk.market.view.album.$$Lambda$UserAlbumListActivity$FuFh21RGLYlAaEQXRlhHJYXe0gs */

            @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
            public final void onInsetChange(Rect rect) {
                UserAlbumListActivity.this.lambda$onCreate$1$UserAlbumListActivity(rect);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$UserAlbumListActivity(View view) {
        finish();
    }

    public /* synthetic */ void lambda$onCreate$1$UserAlbumListActivity(Rect rect) {
        this.binding.contentView.setPadding(0, UiUtils.getActionBarSize(getActivity()) + rect.top, 0, 0);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public AlbumListFragment onCreateFragment() {
        return AlbumListFragment.newInstance();
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    protected void onFragmentCreated(Fragment fragment) {
        super.onFragmentCreated(fragment);
        if (fragment instanceof AlbumListFragment) {
            ((AlbumListFragment) fragment).setPresenter(new UserAlbumListPresenter((AlbumListContract.View) fragment, this.uid));
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623938, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131361856) {
            return false;
        }
        AlbumCreateDialog.newInstance().show(getSupportFragmentManager(), (String) null);
        return true;
    }
}
