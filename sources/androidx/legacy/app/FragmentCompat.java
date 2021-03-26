package androidx.legacy.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

@Deprecated
public class FragmentCompat {
    static final FragmentCompatImpl IMPL;
    private static PermissionCompatDelegate sDelegate;

    interface FragmentCompatImpl {
        void requestPermissions(Fragment fragment, String[] strArr, int i);

        void setUserVisibleHint(Fragment fragment, boolean z);

        boolean shouldShowRequestPermissionRationale(Fragment fragment, String str);
    }

    @Deprecated
    public interface OnRequestPermissionsResultCallback {
        @Deprecated
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    @Deprecated
    public interface PermissionCompatDelegate {
        @Deprecated
        boolean requestPermissions(Fragment fragment, String[] strArr, int i);
    }

    static class FragmentCompatBaseImpl implements FragmentCompatImpl {
        @Override // androidx.legacy.app.FragmentCompat.FragmentCompatImpl
        public void setUserVisibleHint(Fragment fragment, boolean z) {
        }

        @Override // androidx.legacy.app.FragmentCompat.FragmentCompatImpl
        public boolean shouldShowRequestPermissionRationale(Fragment fragment, String str) {
            return false;
        }

        FragmentCompatBaseImpl() {
        }

        @Override // androidx.legacy.app.FragmentCompat.FragmentCompatImpl
        public void requestPermissions(final Fragment fragment, final String[] strArr, final int i) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class androidx.legacy.app.FragmentCompat.FragmentCompatBaseImpl.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    Activity activity = fragment.getActivity();
                    if (activity != null) {
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                        }
                    } else {
                        Arrays.fill(iArr, -1);
                    }
                    ((OnRequestPermissionsResultCallback) fragment).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    static class FragmentCompatApi15Impl extends FragmentCompatBaseImpl {
        FragmentCompatApi15Impl() {
        }

        @Override // androidx.legacy.app.FragmentCompat.FragmentCompatBaseImpl, androidx.legacy.app.FragmentCompat.FragmentCompatImpl
        public void setUserVisibleHint(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    static class FragmentCompatApi23Impl extends FragmentCompatApi15Impl {
        FragmentCompatApi23Impl() {
        }

        @Override // androidx.legacy.app.FragmentCompat.FragmentCompatBaseImpl, androidx.legacy.app.FragmentCompat.FragmentCompatImpl
        public void requestPermissions(Fragment fragment, String[] strArr, int i) {
            fragment.requestPermissions(strArr, i);
        }

        @Override // androidx.legacy.app.FragmentCompat.FragmentCompatBaseImpl, androidx.legacy.app.FragmentCompat.FragmentCompatImpl
        public boolean shouldShowRequestPermissionRationale(Fragment fragment, String str) {
            return fragment.shouldShowRequestPermissionRationale(str);
        }
    }

    static class FragmentCompatApi24Impl extends FragmentCompatApi23Impl {
        FragmentCompatApi24Impl() {
        }

        @Override // androidx.legacy.app.FragmentCompat.FragmentCompatApi15Impl, androidx.legacy.app.FragmentCompat.FragmentCompatBaseImpl, androidx.legacy.app.FragmentCompat.FragmentCompatImpl
        public void setUserVisibleHint(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            IMPL = new FragmentCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new FragmentCompatApi23Impl();
        } else if (Build.VERSION.SDK_INT >= 15) {
            IMPL = new FragmentCompatApi15Impl();
        } else {
            IMPL = new FragmentCompatBaseImpl();
        }
    }

    @Deprecated
    public static void setPermissionCompatDelegate(PermissionCompatDelegate permissionCompatDelegate) {
        sDelegate = permissionCompatDelegate;
    }

    @Deprecated
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Deprecated
    public static void setMenuVisibility(Fragment fragment, boolean z) {
        fragment.setMenuVisibility(z);
    }

    @Deprecated
    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        IMPL.setUserVisibleHint(fragment, z);
    }

    @Deprecated
    public static void requestPermissions(Fragment fragment, String[] strArr, int i) {
        PermissionCompatDelegate permissionCompatDelegate = sDelegate;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.requestPermissions(fragment, strArr, i)) {
            IMPL.requestPermissions(fragment, strArr, i);
        }
    }

    @Deprecated
    public static boolean shouldShowRequestPermissionRationale(Fragment fragment, String str) {
        return IMPL.shouldShowRequestPermissionRationale(fragment, str);
    }
}
