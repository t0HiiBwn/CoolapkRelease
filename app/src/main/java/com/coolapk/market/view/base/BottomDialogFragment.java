package com.coolapk.market.view.base;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BottomDialogFragment extends BaseDialogFragment {
    @Override // com.coolapk.market.view.base.BaseDialogFragment
    public int getDialogCornerRadius() {
        return -1;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        final View decorView = window.getDecorView();
        decorView.post(new Runnable() {
            /* class com.coolapk.market.view.base.BottomDialogFragment.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                decorView.setPadding(0, 0, 0, 0);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getDialog().requestWindowFeature(1);
    }
}
