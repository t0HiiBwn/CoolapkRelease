package androidx.core.view;

public interface NestedScrollingChild {
    @Override // androidx.core.view.NestedScrollingChild
    boolean dispatchNestedFling(float f, float f2, boolean z);

    @Override // androidx.core.view.NestedScrollingChild
    boolean dispatchNestedPreFling(float f, float f2);

    @Override // androidx.core.view.NestedScrollingChild
    boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2);

    @Override // androidx.core.view.NestedScrollingChild
    boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr);

    @Override // androidx.core.view.NestedScrollingChild
    boolean hasNestedScrollingParent();

    @Override // androidx.core.view.NestedScrollingChild
    boolean isNestedScrollingEnabled();

    @Override // androidx.core.view.NestedScrollingChild
    void setNestedScrollingEnabled(boolean z);

    @Override // androidx.core.view.NestedScrollingChild
    boolean startNestedScroll(int i);

    @Override // androidx.core.view.NestedScrollingChild
    void stopNestedScroll();
}
