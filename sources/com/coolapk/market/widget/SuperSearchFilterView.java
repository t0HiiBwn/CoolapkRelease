package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.view.base.refresh.RefreshRecyclerFragment;
import group.infotech.drawable.dsl.ShapesKt;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuperSearchFilterView.kt */
public final class SuperSearchFilterView extends FrameLayout {
    private final View backgroundView;
    private final FrameLayout contentFragmentLayout;
    private final float contentHeight;
    private final int contentId;
    private float height;
    private boolean isShow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperSearchFilterView(Context context, int i, float f) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentId = i;
        this.contentHeight = f;
        setVisibility(4);
        View view = new View(context);
        this.backgroundView = view;
        view.setBackgroundColor(838860800);
        view.setAlpha(0.0f);
        addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        this.contentFragmentLayout = frameLayout;
        frameLayout.setId(i);
        frameLayout.setBackground(createBackground());
        frameLayout.setTranslationY(-f);
        frameLayout.setElevation((float) NumberExtendsKt.getDp((Number) 3));
        addView(frameLayout, new FrameLayout.LayoutParams(-1, (int) f));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(2131231062);
        imageView.setZ((float) NumberExtendsKt.getDp((Number) 3));
        addView(imageView, new FrameLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(2131165598)));
    }

    public final float getContentHeight() {
        return this.contentHeight;
    }

    public final int getContentId() {
        return this.contentId;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    @Override // android.view.View
    public final float getHeight() {
        return this.height;
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public final void resetView() {
        removeAllViews();
        setVisibility(4);
        addView(this.backgroundView);
        this.contentFragmentLayout.setTranslationY(-this.height);
        addView(this.contentFragmentLayout, new FrameLayout.LayoutParams(-1, (int) this.height));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(2131231062);
        imageView.setZ((float) NumberExtendsKt.getDp((Number) 3));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        addView(imageView, new FrameLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(2131165598)));
    }

    public final void show() {
        this.isShow = true;
        setVisibility(0);
        ViewCompat.animate(this.contentFragmentLayout).translationY(0.0f).setDuration(250).setListener(null).start();
        ViewCompat.animate(this.backgroundView).alpha(1.0f).setDuration(250).setListener(null).start();
    }

    public static /* synthetic */ void hide$default(SuperSearchFilterView superSearchFilterView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        superSearchFilterView.hide(z);
    }

    public final void hide(boolean z) {
        this.isShow = false;
        long j = 250;
        ViewCompat.animate(this.contentFragmentLayout).translationY(-this.contentHeight).setDuration(250).setListener(null).start();
        ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this.backgroundView).alpha(0.0f);
        if (z) {
            j = 0;
        }
        alpha.setDuration(j).setListener(new SuperSearchFilterView$hide$1(this)).start();
    }

    public final void notifyDataSetChanged(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Fragment fragment = getFragment(fragmentManager);
        Objects.requireNonNull(fragment, "null cannot be cast to non-null type com.coolapk.market.view.base.refresh.RefreshRecyclerFragment");
        RecyclerView recyclerView = ((RefreshRecyclerFragment) fragment).getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "(getFragment(fragmentMan…            .recyclerView");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.notifyDataSetChanged();
    }

    public final Fragment getFragment(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        return fragmentManager.findFragmentById(this.contentId);
    }

    private final GradientDrawable createBackground() {
        float dp = (float) NumberExtendsKt.getDp((Number) 8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        ShapesKt.setSolidColor(gradientDrawable, AppHolder.getAppTheme().getContentBackgroundColor());
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dp, dp, dp, dp});
        return gradientDrawable;
    }
}
