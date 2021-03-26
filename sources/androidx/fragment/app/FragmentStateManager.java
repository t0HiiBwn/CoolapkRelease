package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;

class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;
    private final Fragment mFragment;
    private int mFragmentManagerState = -1;

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        Fragment instantiate = fragmentFactory.instantiate(classLoader, fragmentState.mClassName);
        this.mFragment = instantiate;
        if (fragmentState.mArguments != null) {
            fragmentState.mArguments.setClassLoader(classLoader);
        }
        instantiate.setArguments(fragmentState.mArguments);
        instantiate.mWho = fragmentState.mWho;
        instantiate.mFromLayout = fragmentState.mFromLayout;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.mFragmentId;
        instantiate.mContainerId = fragmentState.mContainerId;
        instantiate.mTag = fragmentState.mTag;
        instantiate.mRetainInstance = fragmentState.mRetainInstance;
        instantiate.mRemoving = fragmentState.mRemoving;
        instantiate.mDetached = fragmentState.mDetached;
        instantiate.mHidden = fragmentState.mHidden;
        instantiate.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        if (fragmentState.mSavedFragmentState != null) {
            instantiate.mSavedFragmentState = fragmentState.mSavedFragmentState;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, Fragment fragment, FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        fragment.mTargetWho = fragment.mTarget != null ? fragment.mTarget.mWho : null;
        fragment.mTarget = null;
        if (fragmentState.mSavedFragmentState != null) {
            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }

    Fragment getFragment() {
        return this.mFragment;
    }

    void setFragmentManagerState(int i) {
        this.mFragmentManagerState = i;
    }

    int computeMaxState() {
        int i = this.mFragmentManagerState;
        if (this.mFragment.mFromLayout) {
            if (this.mFragment.mInLayout) {
                i = Math.max(this.mFragmentManagerState, 1);
            } else if (this.mFragmentManagerState < 2) {
                i = Math.min(i, this.mFragment.mState);
            } else {
                i = Math.min(i, 1);
            }
        }
        if (!this.mFragment.mAdded) {
            i = Math.min(i, 1);
        }
        if (this.mFragment.mRemoving) {
            if (this.mFragment.isInBackStack()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (this.mFragment.mDeferStart && this.mFragment.mState < 3) {
            i = Math.min(i, 2);
        }
        int i2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[this.mFragment.mMaxState.ordinal()];
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return Math.min(i, 3);
        }
        if (i2 != 3) {
            return Math.min(i, -1);
        }
        return Math.min(i, 1);
    }

    /* renamed from: androidx.fragment.app.FragmentStateManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    void ensureInflatedView() {
        if (this.mFragment.mFromLayout && this.mFragment.mInLayout && !this.mFragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
            }
            Fragment fragment = this.mFragment;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
            if (this.mFragment.mView != null) {
                this.mFragment.mView.setSaveFromParentEnabled(false);
                this.mFragment.mView.setTag(R.id.fragment_container_view_tag, this.mFragment);
                if (this.mFragment.mHidden) {
                    this.mFragment.mView.setVisibility(8);
                }
                Fragment fragment2 = this.mFragment;
                fragment2.onViewCreated(fragment2.mView, this.mFragment.mSavedFragmentState);
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                Fragment fragment3 = this.mFragment;
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment3, fragment3.mView, this.mFragment.mSavedFragmentState, false);
            }
        }
    }

    void restoreState(ClassLoader classLoader) {
        if (this.mFragment.mSavedFragmentState != null) {
            this.mFragment.mSavedFragmentState.setClassLoader(classLoader);
            Fragment fragment = this.mFragment;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.mFragment;
            fragment2.mTargetWho = fragment2.mSavedFragmentState.getString("android:target_state");
            if (this.mFragment.mTargetWho != null) {
                Fragment fragment3 = this.mFragment;
                fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            if (this.mFragment.mSavedUserVisibleHint != null) {
                Fragment fragment4 = this.mFragment;
                fragment4.mUserVisibleHint = fragment4.mSavedUserVisibleHint.booleanValue();
                this.mFragment.mSavedUserVisibleHint = null;
            } else {
                Fragment fragment5 = this.mFragment;
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            if (!this.mFragment.mUserVisibleHint) {
                this.mFragment.mDeferStart = true;
            }
        }
    }

    void attach(FragmentHostCallback<?> fragmentHostCallback, FragmentManager fragmentManager, Fragment fragment) {
        this.mFragment.mHost = fragmentHostCallback;
        this.mFragment.mParentFragment = fragment;
        this.mFragment.mFragmentManager = fragmentManager;
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, fragmentHostCallback.getContext(), false);
        this.mFragment.performAttach();
        if (this.mFragment.mParentFragment == null) {
            fragmentHostCallback.onAttachFragment(this.mFragment);
        } else {
            this.mFragment.mParentFragment.onAttachFragment(this.mFragment);
        }
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, fragmentHostCallback.getContext(), false);
    }

    void create() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.mFragment);
        }
        if (!this.mFragment.mIsCreated) {
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.mFragment;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher2 = this.mDispatcher;
            Fragment fragment3 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher2.dispatchOnFragmentCreated(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        Fragment fragment4 = this.mFragment;
        fragment4.restoreChildFragmentState(fragment4.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    void createView(FragmentContainer fragmentContainer) {
        String str;
        if (!this.mFragment.mFromLayout) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
            }
            ViewGroup viewGroup = null;
            if (this.mFragment.mContainer != null) {
                viewGroup = this.mFragment.mContainer;
            } else if (this.mFragment.mContainerId != 0) {
                if (this.mFragment.mContainerId != -1) {
                    viewGroup = (ViewGroup) fragmentContainer.onFindViewById(this.mFragment.mContainerId);
                    if (viewGroup == null && !this.mFragment.mRestored) {
                        try {
                            str = this.mFragment.getResources().getResourceName(this.mFragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + str + ") for fragment " + this.mFragment);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
                }
            }
            this.mFragment.mContainer = viewGroup;
            Fragment fragment = this.mFragment;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), viewGroup, this.mFragment.mSavedFragmentState);
            if (this.mFragment.mView != null) {
                boolean z = false;
                this.mFragment.mView.setSaveFromParentEnabled(false);
                this.mFragment.mView.setTag(R.id.fragment_container_view_tag, this.mFragment);
                if (viewGroup != null) {
                    viewGroup.addView(this.mFragment.mView);
                }
                if (this.mFragment.mHidden) {
                    this.mFragment.mView.setVisibility(8);
                }
                ViewCompat.requestApplyInsets(this.mFragment.mView);
                Fragment fragment2 = this.mFragment;
                fragment2.onViewCreated(fragment2.mView, this.mFragment.mSavedFragmentState);
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                Fragment fragment3 = this.mFragment;
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment3, fragment3.mView, this.mFragment.mSavedFragmentState, false);
                Fragment fragment4 = this.mFragment;
                if (fragment4.mView.getVisibility() == 0 && this.mFragment.mContainer != null) {
                    z = true;
                }
                fragment4.mIsNewlyAdded = z;
            }
        }
    }

    void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.mFragment);
        }
        Fragment fragment = this.mFragment;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment2 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(fragment2, fragment2.mSavedFragmentState, false);
    }

    void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.mFragment);
        }
        if (this.mFragment.mView != null) {
            Fragment fragment = this.mFragment;
            fragment.restoreViewState(fragment.mSavedFragmentState);
        }
        this.mFragment.mSavedFragmentState = null;
    }

    void start() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.mFragment);
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    void resume() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.mFragment);
        }
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        this.mFragment.mSavedFragmentState = null;
        this.mFragment.mSavedViewState = null;
    }

    void pause() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.mFragment);
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    void stop() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.mFragment);
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }

    FragmentState saveState() {
        FragmentState fragmentState = new FragmentState(this.mFragment);
        if (this.mFragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = this.mFragment.mSavedFragmentState;
        } else {
            fragmentState.mSavedFragmentState = saveBasicState();
            if (this.mFragment.mTargetWho != null) {
                if (fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString("android:target_state", this.mFragment.mTargetWho);
                if (this.mFragment.mTargetRequestCode != 0) {
                    fragmentState.mSavedFragmentState.putInt("android:target_req_state", this.mFragment.mTargetRequestCode);
                }
            }
        }
        return fragmentState;
    }

    Fragment.SavedState saveInstanceState() {
        Bundle saveBasicState;
        if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
            return null;
        }
        return new Fragment.SavedState(saveBasicState);
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.mFragment.mView != null) {
            saveViewState();
        }
        if (this.mFragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.mFragment.mSavedViewState);
        }
        if (!this.mFragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    void saveViewState() {
        if (this.mFragment.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.mFragment.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.mFragment.mSavedViewState = sparseArray;
            }
        }
    }

    void destroy(FragmentHostCallback<?> fragmentHostCallback, FragmentManagerViewModel fragmentManagerViewModel) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.mFragment);
        }
        boolean z = true;
        boolean z2 = this.mFragment.mRemoving && !this.mFragment.isInBackStack();
        if (z2 || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z = fragmentManagerViewModel.isCleared();
            } else if (fragmentHostCallback.getContext() instanceof Activity) {
                z = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
            }
            if (z2 || z) {
                fragmentManagerViewModel.clearNonConfigState(this.mFragment);
            }
            this.mFragment.performDestroy();
            this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
            return;
        }
        this.mFragment.mState = 0;
    }

    void detach(FragmentManagerViewModel fragmentManagerViewModel) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.mFragment);
        }
        this.mFragment.performDetach();
        boolean z = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        this.mFragment.mState = -1;
        this.mFragment.mHost = null;
        this.mFragment.mParentFragment = null;
        this.mFragment.mFragmentManager = null;
        if (this.mFragment.mRemoving && !this.mFragment.isInBackStack()) {
            z = true;
        }
        if (z || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);
            }
            this.mFragment.initState();
        }
    }
}
