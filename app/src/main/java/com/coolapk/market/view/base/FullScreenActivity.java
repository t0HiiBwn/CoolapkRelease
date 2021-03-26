package com.coolapk.market.view.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/base/FullScreenActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "recordResumeEvent", "requestCreateFragment", "Builder", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FullScreenActivity.kt */
public final class FullScreenActivity extends BaseActivity {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_ARGS = "ARGS";
    private static final String KEY_CLASS_NAME = "CLASS_NAME";
    private static final String KEY_TITLE = "TITLE";

    @JvmStatic
    public static final Builder builder(Context context) {
        return Companion.builder(context);
    }

    @JvmStatic
    public static final Builder builder(Fragment fragment) {
        return Companion.builder(fragment);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setInitSlidrDisable();
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setId(2131362316);
        frameLayout.setBackgroundColor(-16777216);
        setContentView(frameLayout);
        requestCreateFragment();
    }

    private final void requestCreateFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131362316);
        if (findFragmentById == null) {
            findFragmentById = onCreateFragment();
        }
        if (findFragmentById != null && !findFragmentById.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(2131362316, findFragmentById).commit();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    private final Fragment onCreateFragment() {
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

    public final Fragment getFragment() {
        return getSupportFragmentManager().findFragmentById(2131362316);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0013J\u001e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014J#\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0017J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0018J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0019J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001aJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ \u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000b2\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u0014J\u0016\u0010\u001c\u001a\u00020\u00002\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u001eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\rJ\u0014\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/base/FullScreenActivity$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "args", "Landroid/os/Bundle;", "className", "", "requestCode", "", "title", "addArgs", "key", "value", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Ljava/util/ArrayList;", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/coolapk/market/view/base/FullScreenActivity$Builder;", "", "", "", "", "addParcelableArrayList", "fragmentClass", "clazz", "Ljava/lang/Class;", "fragmentName", "setArgs", "setRequestCode", "code", "start", "", "options", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FullScreenActivity.kt */
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
                Intent putExtra = new Intent(this.context, FullScreenActivity.class).putExtra(FullScreenActivity.Companion.getKEY_TITLE(), this.title).putExtra(FullScreenActivity.Companion.getKEY_CLASS_NAME(), this.className).putExtra(FullScreenActivity.Companion.getKEY_ARGS(), this.args);
                Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, FullScre…nActivity.KEY_ARGS, args)");
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/base/FullScreenActivity$Companion;", "", "()V", "KEY_ARGS", "", "getKEY_ARGS", "()Ljava/lang/String;", "KEY_CLASS_NAME", "getKEY_CLASS_NAME", "KEY_TITLE", "getKEY_TITLE", "builder", "Lcom/coolapk/market/view/base/FullScreenActivity$Builder;", "context", "Landroid/content/Context;", "Landroidx/fragment/app/Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FullScreenActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getKEY_CLASS_NAME() {
            return FullScreenActivity.KEY_CLASS_NAME;
        }

        public final String getKEY_ARGS() {
            return FullScreenActivity.KEY_ARGS;
        }

        public final String getKEY_TITLE() {
            return FullScreenActivity.KEY_TITLE;
        }

        @JvmStatic
        public final Builder builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context);
        }

        @JvmStatic
        public final Builder builder(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "context");
            return new Builder(fragment);
        }
    }
}
