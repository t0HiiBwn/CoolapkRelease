package com.bytedance.embedapplog.tracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.location.Location;
import android.preference.PreferenceFragment;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.embedapplog.ar;
import com.bytedance.embedapplog.bc;
import com.bytedance.embedapplog.be;
import com.bytedance.embedapplog.bo;
import com.bytedance.embedapplog.f;
import com.bytedance.embedapplog.k;

public class Tracker {
    private static float a;
    private static float b;
    private static int[] c = new int[2];
    public static ar sClick;

    public static void dismiss(Dialog dialog) {
    }

    public static void hide(Dialog dialog) {
    }

    public static boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    public static void onLocationChanged(Location location) {
    }

    public static void onLongClick(View view) {
    }

    public static void show(Dialog dialog) {
    }

    public static void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        onClick(compoundButton);
    }

    public static void onCheckedChanged(RadioGroup radioGroup, int i) {
        onClick(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
    }

    public static boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        onClick(view);
        return false;
    }

    public static void onClick(View view) {
        if (view != null && bo.a) {
            ar a2 = be.a(view);
            if (a2 != null) {
                if (bo.b) {
                    sClick = a2;
                }
                view.getLocationOnScreen(c);
                int[] iArr = c;
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = (int) (a - ((float) i));
                int i4 = (int) (b - ((float) i2));
                if (i3 >= 0 && i3 <= view.getWidth() && i4 >= 0 && i4 <= view.getHeight()) {
                    a2.n = i3;
                    a2.o = i4;
                }
                a = 0.0f;
                b = 0.0f;
                if (bo.b) {
                    bo.a("tracker:on click: width = " + view.getWidth() + " height = " + view.getHeight() + " touchX = " + a2.n + " touchY = " + a2.o, null);
                }
                k.a(a2);
                return;
            }
            bo.a(null);
        }
    }

    public static void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof AlertDialog) {
            onClick(((AlertDialog) dialogInterface).getButton(i));
        } else if (bc.i(dialogInterface)) {
            onClick(((androidx.appcompat.app.AlertDialog) dialogInterface).getButton(i));
        } else if (bc.j(dialogInterface)) {
            onClick(((androidx.appcompat.app.AlertDialog) dialogInterface).getButton(i));
        }
    }

    public static void onFocusChange(View view, boolean z) {
        if (view instanceof TextView) {
            onClick(view);
        }
    }

    public static boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        onClick(view);
        return true;
    }

    public static void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        onClick(view);
    }

    public static void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        onItemClick(adapterView, view, i, j);
    }

    public static boolean onMenuItemClick(MenuItem menuItem) {
        onClick(be.a(menuItem));
        return false;
    }

    public static void onOptionsItemSelected(MenuItem menuItem) {
        onMenuItemClick(menuItem);
    }

    public static void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        if (z) {
            onClick(ratingBar);
        }
    }

    public static void onStopTrackingTouch(SeekBar seekBar) {
        onClick(seekBar);
    }

    public static void onResume(Fragment fragment) {
        f.a(fragment);
    }

    public static void onPause(Fragment fragment) {
        f.b(fragment);
    }

    public static void onHiddenChanged(Fragment fragment, boolean z) {
        if (z) {
            f.b(fragment);
        } else {
            f.a(fragment);
        }
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        if (z) {
            f.a(fragment);
        } else {
            f.b(fragment);
        }
    }

    public static void onResume(android.app.Fragment fragment) {
        f.a(fragment);
    }

    public static void onPause(android.app.Fragment fragment) {
        f.b(fragment);
    }

    public static void onHiddenChanged(android.app.Fragment fragment, boolean z) {
        if (z) {
            f.b(fragment);
        } else {
            f.a(fragment);
        }
    }

    public static void setUserVisibleHint(android.app.Fragment fragment, boolean z) {
        if (z) {
            f.a(fragment);
        } else {
            f.b(fragment);
        }
    }

    public static void onResume(WebViewFragment webViewFragment) {
        f.a(webViewFragment);
    }

    public static void onPause(WebViewFragment webViewFragment) {
        f.b(webViewFragment);
    }

    public static void onHiddenChanged(WebViewFragment webViewFragment, boolean z) {
        if (z) {
            f.b(webViewFragment);
        } else {
            f.a(webViewFragment);
        }
    }

    public static void setUserVisibleHint(WebViewFragment webViewFragment, boolean z) {
        if (z) {
            f.a(webViewFragment);
        } else {
            f.b(webViewFragment);
        }
    }

    public static void onResume(PreferenceFragment preferenceFragment) {
        f.a(preferenceFragment);
    }

    public static void onPause(PreferenceFragment preferenceFragment) {
        f.b(preferenceFragment);
    }

    public static void onHiddenChanged(PreferenceFragment preferenceFragment, boolean z) {
        if (z) {
            f.b(preferenceFragment);
        } else {
            f.a(preferenceFragment);
        }
    }

    public static void setUserVisibleHint(PreferenceFragment preferenceFragment, boolean z) {
        if (z) {
            f.a(preferenceFragment);
        } else {
            f.b(preferenceFragment);
        }
    }

    public static void onResume(ListFragment listFragment) {
        f.a(listFragment);
    }

    public static void onPause(ListFragment listFragment) {
        f.b(listFragment);
    }

    public static void onHiddenChanged(ListFragment listFragment, boolean z) {
        if (z) {
            f.b(listFragment);
        } else {
            f.a(listFragment);
        }
    }

    public static void setUserVisibleHint(ListFragment listFragment, boolean z) {
        if (z) {
            f.a(listFragment);
        } else {
            f.b(listFragment);
        }
    }

    public static void onPageStarted(WebViewClient webViewClient, WebView webView, String str, Bitmap bitmap) {
        WebViewJsUtil.injectJsCallback(webView);
    }

    public static void onPageFinished(WebViewClient webViewClient, WebView webView, String str) {
        WebViewJsUtil.injectJs(webView);
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (bo.b) {
                bo.a("tracker:enter dispatchTouchEvent", null);
            }
            a = motionEvent.getRawX();
            b = motionEvent.getRawY();
        }
    }
}
