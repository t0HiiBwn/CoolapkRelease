package androidx.core.view;

public interface ScrollingView {
    @Override // androidx.core.view.ScrollingView
    int computeHorizontalScrollExtent();

    @Override // androidx.core.view.ScrollingView
    int computeHorizontalScrollOffset();

    @Override // androidx.core.view.ScrollingView
    int computeHorizontalScrollRange();

    @Override // androidx.core.view.ScrollingView
    int computeVerticalScrollExtent();

    @Override // androidx.core.view.ScrollingView
    int computeVerticalScrollOffset();

    @Override // androidx.core.view.ScrollingView
    int computeVerticalScrollRange();
}
