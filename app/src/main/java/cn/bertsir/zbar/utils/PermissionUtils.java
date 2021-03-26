package cn.bertsir.zbar.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class PermissionUtils {
    private static List<String> PERMISSIONS;
    private static Context mApp;
    private static PermissionUtils sInstance;
    private FullCallback mFullCallback;
    private OnRationaleListener mOnRationaleListener;
    private Set<String> mPermissions = new LinkedHashSet();
    private List<String> mPermissionsDenied;
    private List<String> mPermissionsDeniedForever;
    private List<String> mPermissionsGranted;
    private List<String> mPermissionsRequest;
    private SimpleCallback mSimpleCallback;
    private ThemeCallback mThemeCallback;

    public interface FullCallback {
        void onDenied(List<String> list, List<String> list2);

        void onGranted(List<String> list);
    }

    public interface OnRationaleListener {

        public interface ShouldRequest {
            void again(boolean z);
        }

        void rationale(ShouldRequest shouldRequest);
    }

    public interface SimpleCallback {
        void onDenied();

        void onGranted();
    }

    public interface ThemeCallback {
        void onActivityCreate(Activity activity);
    }

    public static List<String> getPermissions() {
        return getPermissions(mApp.getPackageName());
    }

    public static List<String> getPermissions(String str) {
        try {
            return Arrays.asList(mApp.getPackageManager().getPackageInfo(str, 4096).requestedPermissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static boolean isGranted(String... strArr) {
        for (String str : strArr) {
            if (!isGranted(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGranted(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(mApp, str) == 0;
    }

    public static void launchAppDetailsSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + mApp.getPackageName()));
        mApp.startActivity(intent.addFlags(268435456));
    }

    public static PermissionUtils permission(Context context, String... strArr) {
        mApp = context;
        PERMISSIONS = getPermissions();
        return new PermissionUtils(strArr);
    }

    private PermissionUtils(String... strArr) {
        for (String str : strArr) {
            String[] permissions = PermissionConstants.getPermissions(str);
            for (String str2 : permissions) {
                if (PERMISSIONS.contains(str2)) {
                    this.mPermissions.add(str2);
                }
            }
        }
        sInstance = this;
    }

    public PermissionUtils rationale(OnRationaleListener onRationaleListener) {
        this.mOnRationaleListener = onRationaleListener;
        return this;
    }

    public PermissionUtils callback(SimpleCallback simpleCallback) {
        this.mSimpleCallback = simpleCallback;
        return this;
    }

    public PermissionUtils callback(FullCallback fullCallback) {
        this.mFullCallback = fullCallback;
        return this;
    }

    public PermissionUtils theme(ThemeCallback themeCallback) {
        this.mThemeCallback = themeCallback;
        return this;
    }

    public void request() {
        this.mPermissionsGranted = new ArrayList();
        this.mPermissionsRequest = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            this.mPermissionsGranted.addAll(this.mPermissions);
            requestCallback();
            return;
        }
        for (String str : this.mPermissions) {
            if (isGranted(str)) {
                this.mPermissionsGranted.add(str);
            } else {
                this.mPermissionsRequest.add(str);
            }
        }
        if (this.mPermissionsRequest.isEmpty()) {
            requestCallback();
        } else {
            startPermissionActivity();
        }
    }

    /* access modifiers changed from: private */
    public void startPermissionActivity() {
        this.mPermissionsDenied = new ArrayList();
        this.mPermissionsDeniedForever = new ArrayList();
        PermissionActivity.start(mApp);
    }

    /* access modifiers changed from: private */
    public boolean rationale(Activity activity) {
        boolean z = false;
        if (this.mOnRationaleListener != null) {
            Iterator<String> it2 = this.mPermissionsRequest.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (activity.shouldShowRequestPermissionRationale(it2.next())) {
                        getPermissionsStatus(activity);
                        this.mOnRationaleListener.rationale(new OnRationaleListener.ShouldRequest() {
                            /* class cn.bertsir.zbar.utils.PermissionUtils.AnonymousClass1 */

                            @Override // cn.bertsir.zbar.utils.PermissionUtils.OnRationaleListener.ShouldRequest
                            public void again(boolean z) {
                                if (z) {
                                    PermissionUtils.this.startPermissionActivity();
                                } else {
                                    PermissionUtils.this.requestCallback();
                                }
                            }
                        });
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.mOnRationaleListener = null;
        }
        return z;
    }

    private void getPermissionsStatus(Activity activity) {
        for (String str : this.mPermissionsRequest) {
            if (isGranted(str)) {
                this.mPermissionsGranted.add(str);
            } else {
                this.mPermissionsDenied.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.mPermissionsDeniedForever.add(str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void requestCallback() {
        if (this.mSimpleCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissions.size() == this.mPermissionsGranted.size()) {
                this.mSimpleCallback.onGranted();
            } else if (!this.mPermissionsDenied.isEmpty()) {
                this.mSimpleCallback.onDenied();
            }
            this.mSimpleCallback = null;
        }
        if (this.mFullCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissions.size() == this.mPermissionsGranted.size()) {
                this.mFullCallback.onGranted(this.mPermissionsGranted);
            } else if (!this.mPermissionsDenied.isEmpty()) {
                this.mFullCallback.onDenied(this.mPermissionsDeniedForever, this.mPermissionsDenied);
            }
            this.mFullCallback = null;
        }
        this.mOnRationaleListener = null;
        this.mThemeCallback = null;
    }

    /* access modifiers changed from: private */
    public void onRequestPermissionsResult(Activity activity) {
        getPermissionsStatus(activity);
        requestCallback();
    }

    public static class PermissionActivity extends Activity {
        public static void start(Context context) {
            Intent intent = new Intent(context, PermissionActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }

        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            getWindow().addFlags(262160);
            getWindow().setStatusBarColor(0);
            if (PermissionUtils.sInstance == null) {
                super.onCreate(bundle);
                Log.e("PermissionUtils", "request permissions failed");
                finish();
                return;
            }
            if (PermissionUtils.sInstance.mThemeCallback != null) {
                PermissionUtils.sInstance.mThemeCallback.onActivityCreate(this);
            }
            super.onCreate(bundle);
            if (PermissionUtils.sInstance.rationale(this)) {
                finish();
            } else if (PermissionUtils.sInstance.mPermissionsRequest != null) {
                int size = PermissionUtils.sInstance.mPermissionsRequest.size();
                if (size <= 0) {
                    finish();
                } else {
                    requestPermissions((String[]) PermissionUtils.sInstance.mPermissionsRequest.toArray(new String[size]), 1);
                }
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            PermissionUtils.sInstance.onRequestPermissionsResult(this);
            finish();
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }
    }
}
