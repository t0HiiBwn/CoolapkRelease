package com.coolapk.market.view.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.ToolbarActivity;

public class WebViewActivity extends ToolbarActivity<WebViewFragment> {
    public static final String EXTRA_BUNDLE = "extra_bundle";
    public static final String EXTRA_CLASS_NAME = "extra_class_name";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_TITLE_VISABLE = "extra_title_visable";
    private ImageView mFakeCloseView;
    private TextView mFakeTitleView;
    private boolean showFakeTitleView = true;
    private Class webViewFragmentClass;

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("extra_class_name");
        if (TextUtils.isEmpty(stringExtra)) {
            this.webViewFragmentClass = WebViewFragment.class;
        } else {
            try {
                Class<?> loadClass = getClassLoader().loadClass(stringExtra);
                this.webViewFragmentClass = loadClass;
                if (!WebViewFragment.class.isAssignableFrom(loadClass)) {
                    throw new IllegalArgumentException("extra_class_name should extends WebViewFragment");
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        String stringExtra2 = getIntent().getStringExtra("extra_title");
        this.showFakeTitleView = getIntent().getBooleanExtra("extra_title_visable", true);
        super.onCreate(bundle);
        Toolbar toolbar = getToolbar();
        this.mFakeCloseView = new ImageView(getActivity());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(DisplayUtils.dp2px(getActivity(), 40.0f), -1);
        this.mFakeCloseView.setTranslationX((float) (-DisplayUtils.dp2px(getActivity(), 12.0f)));
        this.mFakeCloseView.setLayoutParams(marginLayoutParams);
        this.mFakeCloseView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mFakeCloseView.setImageResource(2131231200);
        this.mFakeCloseView.setBackground(ResourceUtils.getDrawable(getActivity(), ResourceUtils.resolveResId(getActivity(), 16843676)));
        this.mFakeCloseView.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.webview.WebViewActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewActivity.this.finish();
            }
        });
        this.mFakeCloseView.setVisibility(8);
        this.mFakeTitleView = new TextView(getActivity());
        this.mFakeCloseView.setPadding(DisplayUtils.dp2px(getActivity(), 4.0f), 0, 0, 0);
        this.mFakeTitleView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mFakeTitleView.setGravity(8388627);
        TextView toolbarTitleView = UiUtils.getToolbarTitleView(toolbar);
        this.mFakeTitleView.setText(toolbar.getTitle());
        this.mFakeTitleView.setTextColor(toolbarTitleView.getCurrentTextColor());
        this.mFakeTitleView.setTextSize(0, toolbarTitleView.getTextSize());
        this.mFakeTitleView.setSingleLine(true);
        this.mFakeTitleView.setEllipsize(TextUtils.TruncateAt.END);
        toolbar.addView(this.mFakeCloseView);
        toolbar.addView(this.mFakeTitleView);
        if (!TextUtils.isEmpty(stringExtra2)) {
            if (!this.showFakeTitleView) {
                stringExtra2 = "";
            }
            setTitle(stringExtra2);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.webview.WebViewActivity.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewActivity.this.onBackPressed();
            }
        });
    }

    public void setCloseButtonVisible(boolean z) {
        this.mFakeCloseView.setVisibility(z ? 0 : 8);
    }

    public void setTitleVisible() {
        this.mFakeTitleView.setVisibility(this.showFakeTitleView ? 0 : 8);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        TextView textView = this.mFakeTitleView;
        if (!this.showFakeTitleView) {
            charSequence = "";
        }
        textView.setText(charSequence);
    }

    @Override // com.coolapk.market.view.base.ToolbarActivity
    public WebViewFragment onCreateFragment() {
        try {
            WebViewFragment webViewFragment = (WebViewFragment) this.webViewFragmentClass.newInstance();
            webViewFragment.setArguments(getIntent().getBundleExtra("extra_bundle"));
            return webViewFragment;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (getContentFragment() == null) {
            return;
        }
        if (i == 32973 || i == 11101) {
            ((WebViewFragment) getContentFragment()).onActivityResult(i, i2, intent);
        }
    }
}
