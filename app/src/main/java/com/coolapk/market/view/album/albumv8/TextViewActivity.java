package com.coolapk.market.view.album.albumv8;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.TextViewBinding;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;

public class TextViewActivity extends BaseActivity implements TranslucentActivity {
    public static final String KEY_TEXT = "TEXT";
    public static final String KEY_TEXT_SIZE = "TEXT_SIZE";
    private TextViewBinding mBinding;
    private ContextBindingComponent mComponent;
    private String showText;
    private String sourceName;
    private int textSize;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.showText = getIntent().getStringExtra("TEXT");
        this.textSize = getIntent().getIntExtra("TEXT_SIZE", 0);
        this.sourceName = getIntent().getStringExtra("name");
        ContextBindingComponent contextBindingComponent = new ContextBindingComponent(getActivity());
        this.mComponent = contextBindingComponent;
        TextViewBinding textViewBinding = (TextViewBinding) DataBindingUtil.setContentView(this, 2131559188, contextBindingComponent);
        this.mBinding = textViewBinding;
        textViewBinding.textView.setText(this.showText);
        if (this.textSize != 0) {
            this.mBinding.textView.setTextSize(2, (float) this.textSize);
        }
        if (!TextUtils.isEmpty(this.sourceName)) {
            this.mBinding.textView.setGravity(8388611);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode() {
        ThemeUtils.setDarkStatusIconBar(getActivity(), !AppTheme.isDarkTheme(AppHolder.getAppTheme().getCurrentThemeId()));
    }
}
