package com.coolapk.market.view.base.refresh;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.PopupMenu;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ReflectUtils;

public class BasePopMenu extends PopupMenu {
    public BasePopMenu(Context context, View view) {
        super(context, view);
    }

    @Override // androidx.appcompat.widget.PopupMenu
    public void show() {
        super.show();
        try {
            View view = (View) ReflectUtils.wrap(this).getChildField("mPopup").callMethod("getPopup", new Object[0]).callMethod("getListView", new Object[0]).get();
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    view = (ViewGroup) parent;
                }
                if (view.getBackground() instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground();
                    gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
                    gradientDrawable.invalidateSelf();
                    return;
                }
                view.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
            }
        } catch (Throwable unused) {
        }
    }
}
