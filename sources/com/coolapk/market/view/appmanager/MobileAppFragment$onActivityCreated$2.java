package com.coolapk.market.view.appmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.selection.SelectionTracker;
import com.coolapk.market.view.appmanager.MobileAppFragment;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/appmanager/MobileAppFragment$onActivityCreated$2", "Landroidx/recyclerview/selection/SelectionTracker$SelectionObserver;", "", "onSelectionChanged", "", "updateTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MobileAppFragment.kt */
public final class MobileAppFragment$onActivityCreated$2 extends SelectionTracker.SelectionObserver<Long> {
    final /* synthetic */ MobileAppFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    MobileAppFragment$onActivityCreated$2(MobileAppFragment mobileAppFragment) {
        this.this$0 = mobileAppFragment;
    }

    @Override // androidx.recyclerview.selection.SelectionTracker.SelectionObserver
    public void onSelectionChanged() {
        SelectionTracker selectionTracker = this.this$0.tracker;
        Intrinsics.checkNotNull(selectionTracker);
        if (selectionTracker.hasSelection() && this.this$0.actionMode == null) {
            MobileAppFragment mobileAppFragment = this.this$0;
            FragmentActivity activity = mobileAppFragment.getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            mobileAppFragment.actionMode = ((AppCompatActivity) activity).startSupportActionMode(new MobileAppFragment.ActionModeController());
            updateTitle();
        } else if (selectionTracker.hasSelection() || this.this$0.actionMode == null) {
            updateTitle();
        } else {
            ActionMode actionMode = this.this$0.actionMode;
            if (actionMode != null) {
                actionMode.finish();
            }
            this.this$0.actionMode = null;
        }
    }

    public final void updateTitle() {
        ActionMode actionMode = this.this$0.actionMode;
        if (actionMode != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("选择");
            SelectionTracker selectionTracker = this.this$0.tracker;
            Intrinsics.checkNotNull(selectionTracker);
            sb.append(selectionTracker.getSelection().size());
            sb.append((char) 20010);
            actionMode.setTitle(sb.toString());
        }
    }
}
