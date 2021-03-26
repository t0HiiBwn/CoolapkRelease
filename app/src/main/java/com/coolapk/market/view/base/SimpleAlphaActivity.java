package com.coolapk.market.view.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleAlphaActivity.kt */
public final class SimpleAlphaActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_ARGS = "ARGS";
    private static final String KEY_CLASS_NAME = "CLASS_NAME";
    private static final String KEY_TITLE = "TITLE";

    public static final Builder builder(Context context) {
        return Companion.builder(context);
    }

    public static final Builder builder(Fragment fragment) {
        return Companion.builder(fragment);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        Fragment fragment;
        Exception e;
        Fragment fragment2 = null;
        String stringExtra = getIntent().getStringExtra(KEY_TITLE);
        String stringExtra2 = getIntent().getStringExtra(KEY_CLASS_NAME);
        Bundle bundleExtra = getIntent().getBundleExtra(KEY_ARGS);
        try {
            Class<?> loadClass = getClassLoader().loadClass(stringExtra2);
            if (Fragment.class.isAssignableFrom(loadClass)) {
                Object newInstance = loadClass.newInstance();
                if (newInstance != null) {
                    fragment = (Fragment) newInstance;
                    if (bundleExtra != null) {
                        try {
                            bundleExtra.setClassLoader(fragment.getClass().getClassLoader());
                            fragment.setArguments(bundleExtra);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    return fragment;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
            }
            throw new InstantiationException("Trying to instantiate a class " + stringExtra2 + " that is not a Fragment");
        } catch (Exception e3) {
            fragment = fragment2;
            e = e3;
            LogUtils.e(e, "Title: %s, class name: %s, args: %s", stringExtra, stringExtra2, bundleExtra);
            return fragment;
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        String str = KEY_TITLE;
        CharSequence title = getToolbar().getTitle();
        bundle.putString(str, title != null ? title.toString() : null);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = KEY_TITLE;
        String stringExtra = intent.getStringExtra(str);
        if (bundle != null) {
            stringExtra = bundle.getString(str);
        }
        if (stringExtra != null) {
            setToolbarTitle(stringExtra);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void recordResumeEvent() {
        Fragment fragment = getFragment();
        if (fragment != null) {
            String simpleName = fragment.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "fragment.javaClass.simpleName");
            AppHolder.getThirdStatUtils().recordResumeEvent(this, simpleName);
            return;
        }
        super.recordResumeEvent();
    }

    /* compiled from: SimpleAlphaActivity.kt */
    public static final class Builder {
        private Bundle args = new Bundle();
        private String className;
        private final Context context;
        private Fragment fragment;
        private int requestCode = -1;
        private String title;

        public final void start() {
            start$default(this, null, 1, null);
        }

        public Builder(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
        }

        public Builder(Fragment fragment2) {
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            this.fragment = fragment2;
            FragmentActivity requireActivity = fragment2.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            this.context = requireActivity;
        }

        public final Builder title(String str) {
            this.title = str;
            return this;
        }

        public final Builder fragmentClass(Class<? extends Fragment> cls) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
            fragmentName(name);
            return this;
        }

        public final Builder fragmentName(String str) {
            Intrinsics.checkNotNullParameter(str, "className");
            this.className = str;
            return this;
        }

        public final Builder setArgs(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "args");
            this.args = bundle;
            return this;
        }

        public final Builder setRequestCode(int i) {
            this.requestCode = i;
            return this;
        }

        public final Builder addArgs(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putString(str, str2);
            return this;
        }

        public final Builder addArgs(String str, String[] strArr) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putStringArray(str, strArr);
            return this;
        }

        public final Builder addArgs(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putBoolean(str, z);
            return this;
        }

        public final Builder addArgs(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putInt(str, i);
            return this;
        }

        public final Builder addArgs(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putLong(str, j);
            return this;
        }

        public final Builder addArgs(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putFloat(str, f);
            return this;
        }

        public final Builder addArgs(String str, double d) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putDouble(str, d);
            return this;
        }

        public final Builder addArgs(String str, Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putParcelable(str, parcelable);
            return this;
        }

        public final Builder addArgs(String str, Serializable serializable) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putSerializable(str, serializable);
            return this;
        }

        public final Builder addParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putParcelableArrayList(str, arrayList);
            return this;
        }

        public final Builder addArgs(String str, ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.args.putStringArrayList(str, arrayList);
            return this;
        }

        public static /* synthetic */ void start$default(Builder builder, Bundle bundle, int i, Object obj) {
            if ((i & 1) != 0) {
                bundle = null;
            }
            builder.start(bundle);
        }

        public final void start(Bundle bundle) {
            int i;
            String str = this.className;
            if (!(str == null || str.length() == 0)) {
                Intent putExtra = new Intent(this.context, SimpleAlphaActivity.class).putExtra(SimpleAlphaActivity.Companion.getKEY_TITLE(), this.title).putExtra(SimpleAlphaActivity.Companion.getKEY_CLASS_NAME(), this.className).putExtra(SimpleAlphaActivity.Companion.getKEY_ARGS(), this.args);
                Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, SimpleAl…aActivity.KEY_ARGS, args)");
                Fragment fragment2 = this.fragment;
                if (fragment2 == null || (i = this.requestCode) <= 0) {
                    Context context2 = this.context;
                    if (context2 instanceof Activity) {
                        ActivityCompat.startActivityForResult((Activity) context2, putExtra, this.requestCode, bundle);
                    } else {
                        context2.startActivity(putExtra);
                    }
                } else {
                    fragment2.startActivityForResult(putExtra, i);
                }
            } else {
                throw new RuntimeException("fragment class not set");
            }
        }
    }

    /* compiled from: SimpleAlphaActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getKEY_CLASS_NAME() {
            return SimpleAlphaActivity.KEY_CLASS_NAME;
        }

        public final String getKEY_ARGS() {
            return SimpleAlphaActivity.KEY_ARGS;
        }

        public final String getKEY_TITLE() {
            return SimpleAlphaActivity.KEY_TITLE;
        }

        public final Builder builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context);
        }

        public final Builder builder(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "context");
            return new Builder(fragment);
        }
    }
}
