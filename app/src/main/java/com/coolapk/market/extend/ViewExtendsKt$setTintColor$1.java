package com.coolapk.market.extend;

import android.content.res.ColorStateList;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"tintToolbarChildView", "", "childView", "Landroid/view/View;", "filter", "Landroid/graphics/PorterDuffColorFilter;", "color", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ViewExtends.kt */
final class ViewExtendsKt$setTintColor$1 extends Lambda implements Function3<View, PorterDuffColorFilter, Integer, Unit> {
    public static final ViewExtendsKt$setTintColor$1 INSTANCE = new ViewExtendsKt$setTintColor$1();

    ViewExtendsKt$setTintColor$1() {
        super(3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(View view, PorterDuffColorFilter porterDuffColorFilter, Integer num) {
        invoke(view, porterDuffColorFilter, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final View view, final PorterDuffColorFilter porterDuffColorFilter, final int i) {
        Intrinsics.checkNotNullParameter(view, "childView");
        Intrinsics.checkNotNullParameter(porterDuffColorFilter, "filter");
        if (view instanceof ActionMenuView) {
            ActionMenuView actionMenuView = (ActionMenuView) view;
            actionMenuView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener(this) {
                /* class com.coolapk.market.extend.ViewExtendsKt$setTintColor$1.AnonymousClass1 */
                final /* synthetic */ ViewExtendsKt$setTintColor$1 this$0;

                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewRemoved(View view, View view2) {
                    Intrinsics.checkNotNullParameter(view, "parent");
                    Intrinsics.checkNotNullParameter(view2, "child");
                }

                {
                    this.this$0 = r1;
                }

                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewAdded(View view, View view2) {
                    Intrinsics.checkNotNullParameter(view, "parent");
                    Intrinsics.checkNotNullParameter(view2, "child");
                    this.this$0.invoke(view, porterDuffColorFilter, i);
                }
            });
            int childCount = actionMenuView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = actionMenuView.getChildAt(i2);
                if (childAt instanceof TextView) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        TextView textView = (TextView) childAt;
                        ColorStateList compoundDrawableTintList = textView.getCompoundDrawableTintList();
                        if (compoundDrawableTintList == null || compoundDrawableTintList.getDefaultColor() != i) {
                            textView.setCompoundDrawableTintList(ColorStateList.valueOf(i));
                        }
                    } else {
                        TextView textView2 = (TextView) childAt;
                        Drawable drawable = textView2.getCompoundDrawables()[0];
                        if (drawable != null && (!Intrinsics.areEqual(porterDuffColorFilter, drawable.getColorFilter()))) {
                            Drawable mutate = drawable.mutate();
                            mutate.setColorFilter(porterDuffColorFilter);
                            textView2.setCompoundDrawables(mutate, null, null, null);
                        }
                    }
                    ((TextView) childAt).setTextColor(i);
                }
                if (childAt instanceof ImageView) {
                    ImageView imageView = (ImageView) childAt;
                    if (!Intrinsics.areEqual(porterDuffColorFilter, imageView.getColorFilter())) {
                        imageView.setColorFilter(porterDuffColorFilter);
                    }
                }
            }
        } else if (view instanceof ImageView) {
            ImageView imageView2 = (ImageView) view;
            if (!Intrinsics.areEqual(porterDuffColorFilter, imageView2.getColorFilter())) {
                imageView2.setColorFilter(porterDuffColorFilter);
            }
        }
    }
}
