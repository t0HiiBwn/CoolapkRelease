package com.coolapk.market.view.contact;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
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
import com.coolapk.market.databinding.UserPickBinding;
import com.coolapk.market.extend.StringExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.User;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.ThemeUtilsCompat;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.contact.ContactContract;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/contact/ContactPickActivityV9;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/view/contact/OnUserPickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/UserPickBinding;", "subscription", "Lrx/Subscription;", "findContentFragment", "Landroidx/fragment/app/Fragment;", "findPopupFragment", "Lcom/coolapk/market/view/contact/ContactPickActivityV9$PopLayoutBehavior;", "fixFabLayout", "", "getFab", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "inputKeyword", "keyword", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onUserPick", "user", "Lcom/coolapk/market/model/User;", "setupAutoInputKeyword", "setupHeader", "BridgeAdapter", "OnBackPressedBehavior", "PopLayoutBehavior", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ContactPickActivityV9.kt */
public final class ContactPickActivityV9 extends FakeStatusBarActivity implements OnUserPickListener {
    private UserPickBinding binding;
    private Subscription subscription;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/coolapk/market/view/contact/ContactPickActivityV9$OnBackPressedBehavior;", "", "onBackPressed", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ContactPickActivityV9.kt */
    public interface OnBackPressedBehavior {
        boolean onBackPressed();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/view/contact/ContactPickActivityV9$PopLayoutBehavior;", "Lcom/coolapk/market/view/contact/ContactPickActivityV9$OnBackPressedBehavior;", "Landroid/widget/Filterable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ContactPickActivityV9.kt */
    public interface PopLayoutBehavior extends OnBackPressedBehavior, Filterable {
    }

    public static final /* synthetic */ UserPickBinding access$getBinding$p(ContactPickActivityV9 contactPickActivityV9) {
        UserPickBinding userPickBinding = contactPickActivityV9.binding;
        if (userPickBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return userPickBinding;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559283);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…this, R.layout.user_pick)");
        this.binding = (UserPickBinding) contentView;
        setupHeader();
        fixFabLayout();
        setupAutoInputKeyword();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ContactPickFragment findFragmentById = supportFragmentManager.findFragmentById(2131363307);
        if (findFragmentById == null) {
            findFragmentById = ContactPickFragment.newInstance(getIntent().getIntExtra("EXTRA_MAX_COUNT", Integer.MAX_VALUE), getIntent().getStringExtra("EXTRA_ERROR_TEXT"));
            supportFragmentManager.beginTransaction().add(2131363307, findFragmentById).commit();
            supportFragmentManager.executePendingTransactions();
        }
        if (findFragmentById instanceof ContactPickFragment) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            ((ContactPickFragment) findFragmentById).setPresenter(new ContactPickPresenter((ContactContract.View) findFragmentById, loginSession.getUid()));
        }
        UserPickBinding userPickBinding = this.binding;
        if (userPickBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding.mainContent.postDelayed(new ContactPickActivityV9$onCreate$2(this), 100);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PopLayoutBehavior findPopupFragment = findPopupFragment();
        if (findPopupFragment != null ? findPopupFragment.onBackPressed() : false) {
            UserPickBinding userPickBinding = this.binding;
            if (userPickBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = userPickBinding.searchPopupLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchPopupLayout");
            ViewExtendsKt.gone(linearLayout);
            return;
        }
        super.onBackPressed();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    @Override // com.coolapk.market.view.contact.OnUserPickListener
    public void onUserPick(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        Fragment findContentFragment = findContentFragment();
        if (!(findContentFragment instanceof ContactPickFragment)) {
            findContentFragment = null;
        }
        ContactPickFragment contactPickFragment = (ContactPickFragment) findContentFragment;
        if (contactPickFragment != null) {
            contactPickFragment.putPickUser(user);
        }
    }

    private final void setupHeader() {
        int i;
        UserPickBinding userPickBinding = this.binding;
        if (userPickBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = userPickBinding.searchPopupLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.searchPopupLayout");
        ViewExtendsKt.gone(linearLayout);
        UserPickBinding userPickBinding2 = this.binding;
        if (userPickBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = userPickBinding2.searchHeader.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.searchHeader.loadingView");
        ViewExtendsKt.gone(progressBar);
        UserPickBinding userPickBinding3 = this.binding;
        if (userPickBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = userPickBinding3.searchHeader.clearButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.searchHeader.clearButton");
        ViewExtendsKt.gone(imageView);
        UserPickBinding userPickBinding4 = this.binding;
        if (userPickBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = userPickBinding4.searchHeader.searchButton;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.searchHeader.searchButton");
        ViewExtendsKt.gone(frameLayout);
        UserPickBinding userPickBinding5 = this.binding;
        if (userPickBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AutoCompleteTextView autoCompleteTextView = userPickBinding5.searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView, "binding.searchHeader.searchText");
        autoCompleteTextView.setImeOptions(6);
        UserPickBinding userPickBinding6 = this.binding;
        if (userPickBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AutoCompleteTextView autoCompleteTextView2 = userPickBinding6.searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView2, "binding.searchHeader.searchText");
        autoCompleteTextView2.setHint("搜索用户");
        UserPickBinding userPickBinding7 = this.binding;
        if (userPickBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding7.searchHeader.searchText.setOnEditorActionListener(new ContactPickActivityV9$setupHeader$1(this));
        UserPickBinding userPickBinding8 = this.binding;
        if (userPickBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding8.searchHeader.navigationButton.setOnClickListener(new ContactPickActivityV9$setupHeader$2(this));
        UserPickBinding userPickBinding9 = this.binding;
        if (userPickBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding9.searchHeader.searchButton.setOnClickListener(new ContactPickActivityV9$setupHeader$3(this));
        UserPickBinding userPickBinding10 = this.binding;
        if (userPickBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding10.searchHeader.qrOrClearButton.setOnClickListener(new ContactPickActivityV9$setupHeader$4(this));
        UserPickBinding userPickBinding11 = this.binding;
        if (userPickBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = userPickBinding11.searchHeader.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.searchHeader.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout2.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorPrimary());
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        if (appSetting.isAppHeaderSearchBackgroundTransparent()) {
            i = AppHolder.getAppTheme().getColorPrimary();
        } else {
            i = ShapeUtils.createSearchBoxColor();
        }
        UserPickBinding userPickBinding12 = this.binding;
        if (userPickBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout3 = userPickBinding12.searchHeader.searchBoxLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.searchHeader.searchBoxLayout");
        UiUtils.setDrawableSolidColors(linearLayout3.getBackground(), new int[]{1}, i);
        int pickThemeColor = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#757575"), StringExtendsKt.colorInt("#FFFFFF"));
        int pickThemeColor2 = ThemeUtilsCompat.INSTANCE.pickThemeColor(StringExtendsKt.colorInt("#525252"), StringExtendsKt.colorInt("#C1C1C1"), StringExtendsKt.colorInt("#7FFFFFFF"));
        UserPickBinding userPickBinding13 = this.binding;
        if (userPickBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding13.searchHeader.searchText.setTextColor(pickThemeColor);
        UserPickBinding userPickBinding14 = this.binding;
        if (userPickBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding14.searchHeader.searchText.setHintTextColor(pickThemeColor2);
        UserPickBinding userPickBinding15 = this.binding;
        if (userPickBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = userPickBinding15.searchHeader.navigationIcon;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.searchHeader.navigationIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView2.getDrawable()).mutate(), pickThemeColor);
        UserPickBinding userPickBinding16 = this.binding;
        if (userPickBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView3 = userPickBinding16.searchHeader.qrView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.searchHeader.qrView");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView3.getDrawable()).mutate(), pickThemeColor);
        UserPickBinding userPickBinding17 = this.binding;
        if (userPickBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView4 = userPickBinding17.searchHeader.clearButton;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.searchHeader.clearButton");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView4.getDrawable()).mutate(), pickThemeColor);
        UserPickBinding userPickBinding18 = this.binding;
        if (userPickBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView5 = userPickBinding18.searchHeader.searchIcon;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.searchHeader.searchIcon");
        DrawableCompat.setTint(DrawableCompat.wrap(imageView5.getDrawable()).mutate(), pickThemeColor);
        UserPickBinding userPickBinding19 = this.binding;
        if (userPickBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userPickBinding19.searchHeader.searchText.setAdapter(new BridgeAdapter());
        UserPickBinding userPickBinding20 = this.binding;
        if (userPickBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AutoCompleteTextView autoCompleteTextView3 = userPickBinding20.searchHeader.searchText;
        Intrinsics.checkNotNullExpressionValue(autoCompleteTextView3, "binding.searchHeader.searchText");
        autoCompleteTextView3.addTextChangedListener(new ContactPickActivityV9$setupHeader$$inlined$doAfterTextChanged$1(this));
    }

    private final void setupAutoInputKeyword() {
        this.subscription = Observable.create(new ContactPickActivityV9$setupAutoInputKeyword$1(this), Emitter.BackpressureMode.LATEST).throttleWithTimeout(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new ContactPickActivityV9$setupAutoInputKeyword$2(this));
    }

    private final Fragment findContentFragment() {
        return getSupportFragmentManager().findFragmentById(2131363307);
    }

    /* access modifiers changed from: private */
    public final PopLayoutBehavior findPopupFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131363314);
        if (!(findFragmentById instanceof PopLayoutBehavior)) {
            findFragmentById = null;
        }
        return (PopLayoutBehavior) findFragmentById;
    }

    /* access modifiers changed from: private */
    public final void inputKeyword(String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (TextUtils.isEmpty(str)) {
            PopLayoutBehavior findPopupFragment = findPopupFragment();
            if (findPopupFragment != null) {
                supportFragmentManager.beginTransaction().remove((Fragment) findPopupFragment).commit();
                return;
            }
            return;
        }
        UserPickFragment newInstance = UserPickFragment.Companion.newInstance(str);
        newInstance.setPresenter(new UserPresenter(newInstance));
        supportFragmentManager.beginTransaction().replace(2131363314, newInstance).commit();
    }

    public final FloatingActionButton getFab() {
        UserPickBinding userPickBinding = this.binding;
        if (userPickBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FloatingActionButton floatingActionButton = userPickBinding.fab.fab;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.fab.fab");
        return floatingActionButton;
    }

    private final void fixFabLayout() {
        if (ThemeUtils.isNavigationBarTranslucent(this)) {
            int navigationBarHeight = UiUtils.getNavigationBarHeight(getActivity());
            ViewGroup.LayoutParams layoutParams = getFab().getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin + navigationBarHeight);
            getFab().requestLayout();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/contact/ContactPickActivityV9$BridgeAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/widget/Filterable;", "(Lcom/coolapk/market/view/contact/ContactPickActivityV9;)V", "getCount", "", "getFilter", "Landroid/widget/Filter;", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ContactPickActivityV9.kt */
    private final class BridgeAdapter extends BaseAdapter implements Filterable {
        @Override // android.widget.Adapter
        public int getCount() {
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(view, "convertView");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return null;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public BridgeAdapter() {
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            PopLayoutBehavior findPopupFragment = ContactPickActivityV9.this.findPopupFragment();
            if (findPopupFragment != null) {
                return findPopupFragment.getFilter();
            }
            return null;
        }
    }
}
