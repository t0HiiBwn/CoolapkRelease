package com.coolapk.market.view.album.albumv8;

import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.UiUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumDetailListFragment$onActivityCreated$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "toolbarHeight", "", "getToolbarHeight", "()I", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "disallowIntercept", "onTouchEvent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailListFragment.kt */
public final class AlbumDetailListFragment$onActivityCreated$1 implements RecyclerView.OnItemTouchListener {
    final /* synthetic */ AlbumDetailListFragment this$0;
    private final int toolbarHeight;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AlbumDetailListFragment$onActivityCreated$1(AlbumDetailListFragment albumDetailListFragment) {
        this.this$0 = albumDetailListFragment;
        this.toolbarHeight = UiUtils.getStatusBarHeight(albumDetailListFragment.getActivity()) + UiUtils.getActionBarSize(albumDetailListFragment.getActivity());
    }

    public final int getToolbarHeight() {
        return this.toolbarHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        FragmentActivity activity = this.this$0.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.album.albumv8.AlbumDetailActivity");
        AlbumDetailActivity albumDetailActivity = (AlbumDetailActivity) activity;
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.this$0.downY = y;
        } else if (action != 1 || albumDetailActivity.getFilter() == 1.0f) {
            return false;
        } else {
            if (y > this.this$0.downY) {
                this.this$0.getRecyclerView().post(new AlbumDetailListFragment$onActivityCreated$1$onInterceptTouchEvent$1(this));
                return true;
            } else if (this.this$0.downY - y > ((float) 10)) {
                this.this$0.getRecyclerView().post(new AlbumDetailListFragment$onActivityCreated$1$onInterceptTouchEvent$2(this, albumDetailActivity));
                return true;
            }
        }
        return false;
    }
}
