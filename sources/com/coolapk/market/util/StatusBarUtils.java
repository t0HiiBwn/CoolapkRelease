package com.coolapk.market.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;

public class StatusBarUtils {
    private static final int CONTENT_STATUS_BAR_ID = 2131362515;
    private static final int DECOR_STATUS_BAR_ID = 2131362516;
    public static final int STATUS_MASK_LIGHT = 0;
    public static final int STATUS_MASK_NORMAL = 805306368;
    public static final int STATUS_MASK_SINGLE = 1140850688;

    public static View getFakeDecorStatusBarView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(2131362516);
        if (findViewById != null) {
            return findViewById;
        }
        View createStatusBarView = createStatusBarView(activity);
        createStatusBarView.setId(2131362516);
        viewGroup.addView(createStatusBarView);
        makeStatusBarFitSystemWindow(activity);
        return createStatusBarView;
    }

    public static View getFakeContentStatusBarView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(2131362515);
        if (findViewById != null) {
            return findViewById;
        }
        View createStatusBarView = createStatusBarView(activity);
        createStatusBarView.setId(2131362515);
        viewGroup.addView(createStatusBarView);
        makeStatusBarFitSystemWindow(activity);
        return createStatusBarView;
    }

    private static View createStatusBarView(Activity activity) {
        View view = new View(activity);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, UiUtils.getStatusBarHeight(activity)));
        return view;
    }

    private static void makeStatusBarFitSystemWindow(Activity activity) {
        final ArrayList arrayList = new ArrayList();
        View findViewById = activity.findViewById(2131362515);
        if (findViewById != null) {
            arrayList.add(findViewById);
        }
        View findViewById2 = activity.findViewById(2131362516);
        if (findViewById2 != null) {
            arrayList.add(findViewById2);
        }
        if (!arrayList.isEmpty()) {
            UiUtils.getContentView(activity).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                /* class com.coolapk.market.util.StatusBarUtils.AnonymousClass1 */

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    for (View view2 : arrayList) {
                        view2.getLayoutParams().height = windowInsets.getSystemWindowInsetTop();
                        view2.setLayoutParams(view2.getLayoutParams());
                    }
                    return windowInsets;
                }
            });
        }
    }
}
