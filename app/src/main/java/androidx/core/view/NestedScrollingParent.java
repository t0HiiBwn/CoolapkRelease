package androidx.core.view;

import android.view.View;

public interface NestedScrollingParent {
    @Override // androidx.core.view.NestedScrollingParent
    int getNestedScrollAxes();

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    boolean onNestedFling(View view, float f, float f2, boolean z);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    boolean onNestedPreFling(View view, float f, float f2);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onNestedPreScroll(View view, int i, int i2, int[] iArr);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onNestedScroll(View view, int i, int i2, int i3, int i4);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onNestedScrollAccepted(View view, View view2, int i);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    boolean onStartNestedScroll(View view, View view2, int i);

    @Override // android.view.ViewParent, androidx.core.view.NestedScrollingParent
    void onStopNestedScroll(View view);
}
