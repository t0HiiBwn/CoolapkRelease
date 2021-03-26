package com.coolapk.market.view.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import java.io.Serializable;
import java.util.ArrayList;

public class SimpleActivity extends AlphaToolbarActivity {
    public static final String KEY_ARGS = "ARGS";
    public static final String KEY_CLASS_NAME = "CLASS_NAME";
    public static final String KEY_TITLE = "TITLE";

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static Builder builder(Fragment fragment) {
        return new Builder(fragment);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        Fragment fragment;
        Exception e;
        String stringExtra = getIntent().getStringExtra("TITLE");
        String stringExtra2 = getIntent().getStringExtra("CLASS_NAME");
        Bundle bundleExtra = getIntent().getBundleExtra("ARGS");
        try {
            Class<?> loadClass = getClassLoader().loadClass(stringExtra2);
            if (Fragment.class.isAssignableFrom(loadClass)) {
                fragment = (Fragment) loadClass.newInstance();
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
            throw new InstantiationException("Trying to instantiate a class " + stringExtra2 + " that is not a Fragment");
        } catch (Exception e3) {
            fragment = null;
            e = e3;
            LogUtils.e(e, "Title: %s, class name: %s, args: %s", stringExtra, stringExtra2, bundleExtra);
            return fragment;
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("TITLE", getToolbar().getTitle().toString());
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("TITLE");
        if (bundle != null) {
            stringExtra = bundle.getString("TITLE");
        }
        if (stringExtra != null) {
            setToolbarTitle(stringExtra);
        }
        this.binding.mainContent.addOnInsetChangeListener(new DrawSystemBarFrameLayout.OnInsetChangeListener() {
            /* class com.coolapk.market.view.base.$$Lambda$SimpleActivity$_ZN9C4yakJayPRRhDKQwzXWkm4 */

            @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
            public final void onInsetChange(Rect rect) {
                SimpleActivity.this.lambda$onCreate$0$SimpleActivity(rect);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$SimpleActivity(Rect rect) {
        this.binding.contentView.setPadding(0, UiUtils.getActionBarSize(this) + rect.top, 0, 0);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void recordResumeEvent() {
        Fragment fragment = getFragment();
        if (fragment != null) {
            AppHolder.getThirdStatUtils().recordResumeEvent(this, fragment.getClass().getSimpleName());
        } else {
            super.recordResumeEvent();
        }
    }

    public static final class Builder {
        private Bundle args;
        private String className;
        private final Context context;
        private Fragment fragment;
        private int requestCode = -1;
        private String title;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder(Fragment fragment2) {
            this.fragment = fragment2;
            this.context = fragment2.getActivity();
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder fragmentClass(Class<? extends Fragment> cls) {
            fragmentName(cls.getName());
            return this;
        }

        public Builder fragmentName(String str) {
            this.className = str;
            return this;
        }

        public Builder setArgs(Bundle bundle) {
            checkArgs();
            this.args = bundle;
            return this;
        }

        public Builder setRequestCode(int i) {
            this.requestCode = i;
            return this;
        }

        public Builder addArgs(String str, String str2) {
            checkArgs();
            this.args.putString(str, str2);
            return this;
        }

        public Builder addArgs(String str, String[] strArr) {
            checkArgs();
            this.args.putStringArray(str, strArr);
            return this;
        }

        public Builder addArgs(String str, boolean z) {
            checkArgs();
            this.args.putBoolean(str, z);
            return this;
        }

        public Builder addArgs(String str, int i) {
            checkArgs();
            this.args.putInt(str, i);
            return this;
        }

        public Builder addArgs(String str, long j) {
            checkArgs();
            this.args.putLong(str, j);
            return this;
        }

        public Builder addArgs(String str, float f) {
            checkArgs();
            this.args.putFloat(str, f);
            return this;
        }

        public Builder addArgs(String str, double d) {
            checkArgs();
            this.args.putDouble(str, d);
            return this;
        }

        public Builder addArgs(String str, Parcelable parcelable) {
            checkArgs();
            this.args.putParcelable(str, parcelable);
            return this;
        }

        public Builder addArgs(String str, Serializable serializable) {
            checkArgs();
            this.args.putSerializable(str, serializable);
            return this;
        }

        public Builder addParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
            checkArgs();
            this.args.putParcelableArrayList(str, arrayList);
            return this;
        }

        public Builder addArgs(String str, ArrayList<String> arrayList) {
            checkArgs();
            this.args.putStringArrayList(str, arrayList);
            return this;
        }

        private void checkArgs() {
            if (this.args == null) {
                this.args = new Bundle();
            }
        }

        public void start() {
            start(null);
        }

        public void start(Bundle bundle) {
            int i;
            if (!TextUtils.isEmpty(this.className)) {
                Intent putExtra = new Intent(this.context, SimpleActivity.class).putExtra("TITLE", this.title).putExtra("CLASS_NAME", this.className).putExtra("ARGS", this.args);
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
}
