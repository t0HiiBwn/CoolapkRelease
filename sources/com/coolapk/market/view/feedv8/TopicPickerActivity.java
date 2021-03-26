package com.coolapk.market.view.feedv8;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.TopicPickerBinding;
import com.coolapk.market.extend.StringExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ThemeUtilsCompat;
import com.coolapk.market.util.UiUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickerActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/TopicPickerBinding;", "subscription", "Lrx/Subscription;", "inputKeyword", "", "keyword", "", "isNavigationBarTranslucent", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupAutoInputKeyword", "setupUi", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicPickerActivity.kt */
public final class TopicPickerActivity extends FakeStatusBarActivity implements TranslucentActivity {
    public static final String ACTION_TYPE_LIST = "ACTION_TYPE_LIST";
    public static final String ACTION_TYPE_RETURN = "ACTION_TYPE_RETURN";
    public static final String ACTION_TYPE_WRITE = "ACTION_TYPE_WRITE";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ACTION_TYPE = "KEY_ACTION_TYPE";
    public static final String KEY_TOPIC_MODEL = "KEY_TOPIC_MODEL";
    public static final String KEY_TOPIC_TITLE = "KEY_TOPIC_TITLE";
    private TopicPickerBinding binding;
    private Subscription subscription;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ TopicPickerBinding access$getBinding$p(TopicPickerActivity topicPickerActivity) {
        TopicPickerBinding topicPickerBinding = topicPickerActivity.binding;
        if (topicPickerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return topicPickerBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickerActivity$Companion;", "", "()V", "ACTION_TYPE_LIST", "", "ACTION_TYPE_RETURN", "ACTION_TYPE_WRITE", "KEY_ACTION_TYPE", "KEY_TOPIC_MODEL", "KEY_TOPIC_TITLE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicPickerActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131559213);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…y, R.layout.topic_picker)");
        this.binding = (TopicPickerBinding) contentView;
        setupUi();
        setupAutoInputKeyword();
    }

    private final void setupUi() {
        int i;
        TopicPickerBinding topicPickerBinding = this.binding;
        if (topicPickerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = topicPickerBinding.searchHeader.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.searchHeader.loadingView");
        ViewExtendsKt.gone(progressBar);
        TopicPickerBinding topicPickerBinding2 = this.binding;
        if (topicPickerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = topicPickerBinding2.searchHeader.clearButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchHeader.clearButton");
        ViewExtendsKt.gone(imageView);
        TopicPickerBinding topicPickerBinding3 = this.binding;
        if (topicPickerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = topicPickerBinding3.searchHeader.searchButton;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.searchHeader.searchButton");
        ViewExtendsKt.gone(frameLayout);
        TopicPickerBinding topicPickerBinding4 = this.binding;
        if (topicPickerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AutoCompleteTextView autoCompleteTextView = topicPickerBinding4.searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
        autoCompleteTextView.setImeOptions(6);
        TopicPickerBinding topicPickerBinding5 = this.binding;
        if (topicPickerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AutoCompleteTextView autoCompleteTextView2 = topicPickerBinding5.searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView2, "binding.searchHeader.searchText");
        autoCompleteTextView2.setHint("搜索话题");
        TopicPickerBinding topicPickerBinding6 = this.binding;
        if (topicPickerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicPickerBinding6.searchHeader.searchText.setOnEditorActionListener(new TopicPickerActivity$setupUi$1(this));
        TopicPickerBinding topicPickerBinding7 = this.binding;
        if (topicPickerBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicPickerBinding7.searchHeader.navigationButton.setOnClickListener(new TopicPickerActivity$setupUi$2(this));
        TopicPickerBinding topicPickerBinding8 = this.binding;
        if (topicPickerBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicPickerBinding8.searchHeader.searchButton.setOnClickListener(new TopicPickerActivity$setupUi$3(this));
        TopicPickerBinding topicPickerBinding9 = this.binding;
        if (topicPickerBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicPickerBinding9.searchHeader.qrOrClearButton.setOnClickListener(new TopicPickerActivity$setupUi$4(this));
        TopicPickerBinding topicPickerBinding10 = this.binding;
        if (topicPickerBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = topicPickerBinding10.searchHeader.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchHeader.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorPrimary());
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (appSetting.isAppHeaderSearchBackgroundTransparent()) {
            i = AppHolder.getAppTheme().getColorPrimary();
        } else {
            i = ShapeUtils.createSearchBoxColor();
        }
        TopicPickerBinding topicPickerBinding11 = this.binding;
        if (topicPickerBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = topicPickerBinding11.searchHeader.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.searchHeader.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout2.getBackground(), new int[]{1}, i);
        int pickThemeColor = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#FFFFFF"));
        int pickThemeColor2 = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#525252"), StringExtendsKt.colorInt("#C1C1C1"), StringExtendsKt.colorInt("#7FFFFFFF"));
        TopicPickerBinding topicPickerBinding12 = this.binding;
        if (topicPickerBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicPickerBinding12.searchHeader.searchText.setTextColor(pickThemeColor);
        TopicPickerBinding topicPickerBinding13 = this.binding;
        if (topicPickerBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicPickerBinding13.searchHeader.searchText.setHintTextColor(pickThemeColor2);
        TopicPickerBinding topicPickerBinding14 = this.binding;
        if (topicPickerBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = topicPickerBinding14.searchHeader.navigationIcon;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.searchHeader.navigationIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView2.getDrawable()).mutate(), pickThemeColor);
        TopicPickerBinding topicPickerBinding15 = this.binding;
        if (topicPickerBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView3 = topicPickerBinding15.searchHeader.qrView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.searchHeader.qrView");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView3.getDrawable()).mutate(), pickThemeColor);
        TopicPickerBinding topicPickerBinding16 = this.binding;
        if (topicPickerBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView4 = topicPickerBinding16.searchHeader.clearButton;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.searchHeader.clearButton");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView4.getDrawable()).mutate(), pickThemeColor);
        TopicPickerBinding topicPickerBinding17 = this.binding;
        if (topicPickerBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView5 = topicPickerBinding17.searchHeader.searchIcon;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.searchHeader.searchIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView5.getDrawable()).mutate(), pickThemeColor);
        TopicPickerBinding topicPickerBinding18 = this.binding;
        if (topicPickerBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicPickerBinding18.getRoot().postDelayed(new TopicPickerActivity$setupUi$5(this), 100);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.findFragmentById(2131362312) == null) {
            supportFragmentManager.beginTransaction().add(2131362312, TopicPickFragment.Companion.newInstance(getIntent().getStringExtra("KEY_ACTION_TYPE"))).commit();
            supportFragmentManager.executePendingTransactions();
        }
    }

    private final void setupAutoInputKeyword() {
        this.subscription = Observable.create(new TopicPickerActivity$setupAutoInputKeyword$1(this), Emitter.BackpressureMode.LATEST).throttleWithTimeout(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new TopicPickerActivity$setupAutoInputKeyword$2(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    /* access modifiers changed from: private */
    public final void inputKeyword(String str) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131362312);
        if (findFragmentById != null && (findFragmentById instanceof TopicPickFragment)) {
            TopicPickFragment topicPickFragment = (TopicPickFragment) findFragmentById;
            if (topicPickFragment.isVisible() && topicPickFragment.isAdded()) {
                topicPickFragment.searchKeyword(str);
            }
        }
    }
}
