package com.coolapk.market.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.Toast;
import java.lang.ref.WeakReference;

public class FragmentUtils {

    public interface OnCloneCompletionListener {
        void onComplete(Fragment fragment);
    }

    public static Fragment cloneFragment(FragmentManager fragmentManager, int i, String str) {
        if (fragmentManager == null || i < 0) {
            throw new IllegalArgumentException("delay < 0");
        }
        try {
            return internalCloneFragment(fragmentManager, i, str);
        } catch (Throwable th) {
            th.printStackTrace();
            Toast.error(AppHolder.getApplication(), th);
            return null;
        }
    }

    @Deprecated
    public static void cloneFragment(FragmentManager fragmentManager, final int i, final String str, int i2, OnCloneCompletionListener onCloneCompletionListener) {
        if (i2 < 0 || fragmentManager == null || i < 0) {
            throw new IllegalArgumentException("delay < 0");
        } else if (i2 == 0) {
            Fragment cloneFragment = cloneFragment(fragmentManager, i, str);
            if (onCloneCompletionListener != null) {
                onCloneCompletionListener.onComplete(cloneFragment);
            }
        } else {
            final WeakReference weakReference = new WeakReference(fragmentManager);
            final WeakReference weakReference2 = new WeakReference(onCloneCompletionListener);
            AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
                /* class com.coolapk.market.util.FragmentUtils.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    FragmentManager fragmentManager = (FragmentManager) weakReference.get();
                    if (fragmentManager != null) {
                        try {
                            Fragment internalCloneFragment = FragmentUtils.internalCloneFragment(fragmentManager, i, str);
                            OnCloneCompletionListener onCloneCompletionListener = (OnCloneCompletionListener) weakReference2.get();
                            if (onCloneCompletionListener != null) {
                                onCloneCompletionListener.onComplete(internalCloneFragment);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            Toast.error(AppHolder.getApplication(), th);
                        }
                    }
                }
            }, (long) i2);
        }
    }

    /* access modifiers changed from: private */
    public static Fragment internalCloneFragment(FragmentManager fragmentManager, int i, String str) throws Throwable {
        Fragment findFragmentById = fragmentManager.findFragmentById(i);
        if (findFragmentById == null) {
            findFragmentById = fragmentManager.findFragmentByTag(str);
        }
        Fragment fragment = (Fragment) findFragmentById.getClass().newInstance();
        fragment.setInitialSavedState(fragmentManager.saveFragmentInstanceState(findFragmentById));
        fragment.setArguments(findFragmentById.getArguments());
        fragmentManager.beginTransaction().remove(findFragmentById).add(i, fragment, str).commitAllowingStateLoss();
        return fragment;
    }
}
