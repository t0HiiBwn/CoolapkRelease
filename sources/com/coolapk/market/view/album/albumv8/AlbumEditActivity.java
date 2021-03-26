package com.coolapk.market.view.album.albumv8;

import android.os.Parcelable;
import com.coolapk.market.model.Album;
import com.coolapk.market.view.base.ToolbarActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEditActivity;", "Lcom/coolapk/market/view/base/ToolbarActivity;", "Lcom/coolapk/market/view/album/albumv8/AlbumEditListFragment;", "()V", "initSearchMenu", "", "isNavigationBarTranslucent", "", "onCreateFragment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumEditActivity.kt */
public final class AlbumEditActivity extends ToolbarActivity<AlbumEditListFragment> {
    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public AlbumEditListFragment onCreateFragment() {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("album");
        Intrinsics.checkNotNull(parcelableExtra);
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtra<Album>(\"album\")!!");
        setTitle(getString(2131886111));
        return AlbumEditListFragment.Companion.newInstance((Album) parcelableExtra);
    }
}
