package com.coolapk.market.util;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/util/Container;", "", "container", "(Ljava/lang/Object;)V", "valueRef", "Ljava/lang/ref/WeakReference;", "asContext", "Landroid/content/Context;", "asFragment", "Landroidx/fragment/app/Fragment;", "getActivity", "Landroid/app/Activity;", "getContext", "getFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getValue", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: Container.kt */
public final class Container {
    public static final Companion Companion = new Companion(null);
    private final WeakReference<Object> valueRef;

    private Container(Object obj) {
        this.valueRef = new WeakReference<>(obj);
    }

    public /* synthetic */ Container(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/util/Container$Companion;", "", "()V", "with", "Lcom/coolapk/market/util/Container;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Container.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Container with(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Container(context, null);
        }

        public final Container with(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return new Container(fragment, null);
        }
    }

    public final Object getValue() {
        return this.valueRef.get();
    }

    public final Context asContext() {
        Object value = getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type android.content.Context");
        return (Context) value;
    }

    public final Fragment asFragment() {
        Object value = getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) value;
    }

    public final Context getContext() {
        Object value = getValue();
        if (value instanceof Context) {
            Object value2 = getValue();
            Objects.requireNonNull(value2, "null cannot be cast to non-null type android.content.Context");
            return (Context) value2;
        } else if (value instanceof Fragment) {
            FragmentActivity activity = asFragment().getActivity();
            Intrinsics.checkNotNull(activity);
            Intrinsics.checkNotNullExpressionValue(activity, "asFragment().activity!!");
            return activity;
        } else {
            throw new RuntimeException("Unknown value type " + getValue());
        }
    }

    public final Activity getActivity() {
        Object value = getValue();
        if (value instanceof Activity) {
            Object value2 = getValue();
            Objects.requireNonNull(value2, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) value2;
        } else if (value instanceof Fragment) {
            FragmentActivity activity = asFragment().getActivity();
            Intrinsics.checkNotNull(activity);
            Intrinsics.checkNotNullExpressionValue(activity, "asFragment().activity!!");
            return activity;
        } else {
            throw new RuntimeException("Unknown value type " + getValue());
        }
    }

    public final FragmentManager getFragmentManager() {
        Object value = getValue();
        if (value instanceof Activity) {
            Activity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "(getActivity() as Fragme…y).supportFragmentManager");
            return supportFragmentManager;
        } else if (value instanceof Fragment) {
            FragmentManager childFragmentManager = asFragment().getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "asFragment().childFragmentManager");
            return childFragmentManager;
        } else {
            throw new RuntimeException("Unknown value type " + getValue());
        }
    }
}
