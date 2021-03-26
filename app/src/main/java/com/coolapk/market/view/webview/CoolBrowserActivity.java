package com.coolapk.market.view.webview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Selection;
import android.text.TextUtils;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.CoolBrowserBinding;
import com.coolapk.market.databinding.ItemWebviewPageBinding;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StatusBarUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UrlUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.webview.CoolBrowserData;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.decoration.ItemDecorations;

@Deprecated
public class CoolBrowserActivity extends BaseActivity implements View.OnClickListener, CoolBrowserCommunicator {
    protected View contentStatusView;
    protected View decorStatusView;
    private PageAdapter mAdapter;
    CoolBrowserBinding mBinding;
    private CoolBrowserData mBrowserData;
    private Drawable mInitDrawable;
    private boolean mIsBottomViewShow;
    private boolean mIsFocusMode;
    private ValueAnimator mRefreshAnimator;

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CoolBrowserBinding coolBrowserBinding = (CoolBrowserBinding) DataBindingUtil.setContentView(getActivity(), 2131558486);
        this.mBinding = coolBrowserBinding;
        coolBrowserBinding.setClick(this);
        setupStatusBar();
        this.mBrowserData = new CoolBrowserData(getActivity());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        CoolBrowserData coolBrowserData = this.mBrowserData;
        CoolBrowserData.PageData createNewPage = coolBrowserData.createNewPage(coolBrowserData.getHomePage());
        CoolBrowserFragment orCreateFragment = createNewPage.getOrCreateFragment(supportFragmentManager);
        this.mBinding.linkTextView.setText(this.mBrowserData.getHomePage());
        supportFragmentManager.beginTransaction().add(2131363592, orCreateFragment).commit();
        this.mBrowserData.setCurrentPageData(createNewPage);
        getSupportFragmentManager().executePendingTransactions();
        this.mInitDrawable = this.mBinding.linkContentView.getBackground();
        this.mBinding.actionPage.setImageBitmap(ShapeUtils.createRoundedNumberBitmap(1));
        this.mBinding.editText.setOnKeyListener(new View.OnKeyListener() {
            /* class com.coolapk.market.view.webview.CoolBrowserActivity.AnonymousClass1 */

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 66) {
                    return false;
                }
                CoolBrowserActivity.this.hideFocus();
                CoolBrowserActivity coolBrowserActivity = CoolBrowserActivity.this;
                coolBrowserActivity.searchText(coolBrowserActivity.mBinding.editText.getText().toString());
                return true;
            }
        });
        this.mBinding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.coolapk.market.view.webview.CoolBrowserActivity.AnonymousClass2 */

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 2 && i != 6 && i != 5 && i != 4 && i != 3 && keyEvent.getAction() != 66) {
                    return false;
                }
                CoolBrowserActivity.this.hideFocus();
                CoolBrowserActivity coolBrowserActivity = CoolBrowserActivity.this;
                coolBrowserActivity.searchText(coolBrowserActivity.mBinding.editText.getText().toString());
                return true;
            }
        });
        this.mBinding.actionSearchEngine.setImageDrawable(this.mBrowserData.getSearchEngine().getDrawable(getActivity()));
        this.mAdapter = new PageAdapter();
        this.mBinding.pageListView.setAdapter(this.mAdapter);
        this.mBinding.pageListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mBinding.pageListView.addItemDecoration(ItemDecorations.horizontal(getActivity()).type(0, 2131231052).create());
        this.mBrowserData.setPageCountChangeListener(new CoolBrowserData.PageCountChangeListener() {
            /* class com.coolapk.market.view.webview.CoolBrowserActivity.AnonymousClass3 */

            @Override // com.coolapk.market.view.webview.CoolBrowserData.PageCountChangeListener
            public void onPageCountChanged(int i) {
                CoolBrowserActivity.this.mBinding.actionPage.setImageBitmap(ShapeUtils.createRoundedNumberBitmap(i));
            }
        });
    }

    /* access modifiers changed from: private */
    public void searchText(String str) {
        if (!TextUtils.isEmpty(str)) {
            String smartUrlFilter = UrlUtils.smartUrlFilter(str.trim(), true, this.mBrowserData.getSearchEngine().getUrl());
            CoolBrowserFragment currentFragment = getCurrentFragment();
            if (currentFragment != null) {
                currentFragment.getWebView().loadUrl(smartUrlFilter);
            }
        }
    }

    private void requestFocus() {
        CoolBrowserFragment currentFragment;
        this.mIsFocusMode = true;
        if (this.mBinding.editText.getText().length() == 0 && (currentFragment = getCurrentFragment()) != null) {
            this.mBinding.editText.setText(currentFragment.getWebView().getUrl());
        }
        Selection.selectAll(this.mBinding.editText.getText());
        this.mBinding.actionRefresh.setVisibility(8);
        this.mBinding.actionContainer.setVisibility(8);
        this.mBinding.editText.setVisibility(0);
        this.mBinding.linkTextView.setVisibility(8);
        this.mBinding.actionClear.setVisibility(0);
        this.mBinding.actionQrcode.setVisibility(0);
        this.mBinding.editText.requestFocus();
        this.mBinding.actionSearchEngine.setImageTintList(ColorStateList.valueOf(ResourceUtils.getColorInt(getActivity(), 2131099891)));
        this.mBinding.linkContentView.setBackground(new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor()));
        this.mBinding.appBar.setBackground(new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor()));
        this.contentStatusView.setBackground(new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor()));
        if (!AppHolder.getAppTheme().isDarkTheme()) {
            ThemeUtils.setDarkStatusIconBar(getActivity(), true, 0);
        }
        this.mBinding.maskView.setVisibility(0);
        UiUtils.openKeyboard(this.mBinding.editText);
    }

    /* access modifiers changed from: private */
    public void hideFocus() {
        this.mIsFocusMode = false;
        this.mBinding.actionRefresh.setVisibility(0);
        this.mBinding.actionClear.setVisibility(8);
        this.mBinding.actionQrcode.setVisibility(8);
        this.mBinding.editText.setVisibility(8);
        this.mBinding.linkTextView.setVisibility(0);
        TransitionManager.beginDelayedTransition(this.mBinding.appBar);
        this.mBinding.actionContainer.setVisibility(0);
        this.mBinding.editText.clearFocus();
        this.mBinding.actionSearchEngine.setImageTintList(ColorStateList.valueOf(-1));
        this.mBinding.linkContentView.setBackground(this.mInitDrawable);
        this.mBinding.appBar.setBackground(new ColorDrawable(AppHolder.getAppTheme().getColorPrimary()));
        this.contentStatusView.setBackground(new ColorDrawable(AppHolder.getAppTheme().getColorPrimary()));
        if (!AppHolder.getAppTheme().isDarkTheme()) {
            ThemeUtils.setDarkStatusIconBar(getActivity(), false, 0);
        }
        this.mBinding.maskView.setVisibility(8);
        UiUtils.closeKeyboard(this.mBinding.editText);
    }

    protected void setupStatusBar() {
        if (this.contentStatusView == null) {
            this.contentStatusView = StatusBarUtils.getFakeContentStatusBarView(getActivity());
            this.decorStatusView = StatusBarUtils.getFakeDecorStatusBarView(getActivity());
        }
        AppHolder.getAppTheme();
        this.contentStatusView.setBackgroundColor(ThemeUtils.getStatusBarColor());
        int i = 0;
        this.decorStatusView.setBackgroundColor(0);
        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("transparent_status_bar");
        View view = this.decorStatusView;
        if (booleanPref) {
            i = 8;
        }
        view.setVisibility(i);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSlideChange(float f) {
        super.onSlideChange(f);
        this.decorStatusView.setAlpha(f);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
        changeBaseTheme();
        this.mBinding.appBar.setBackgroundColor(appTheme.getColorPrimary());
        setupStatusBar();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsFocusMode) {
            hideFocus();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onSettingEvent(SettingEvent settingEvent) {
        super.onSettingEvent(settingEvent);
        String str = settingEvent.key;
        str.hashCode();
        if (str.equals("transparent_status_bar")) {
            setupStatusBar();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131361863:
                CoolBrowserFragment currentFragment = getCurrentFragment();
                if (currentFragment != null) {
                    currentFragment.getWebView().goBack();
                    return;
                }
                return;
            case 2131361882:
                this.mBinding.editText.getText().clear();
                return;
            case 2131361910:
                CoolBrowserFragment currentFragment2 = getCurrentFragment();
                if (currentFragment2 != null) {
                    currentFragment2.getWebView().goForward();
                    return;
                }
                return;
            case 2131361941:
                if (this.mIsBottomViewShow) {
                    hidePageList(true);
                    return;
                } else {
                    showPageList();
                    return;
                }
            case 2131361947:
                ActionManager.startQrcodeActivity(getActivity());
                return;
            case 2131361956:
                CoolBrowserFragment currentFragment3 = getCurrentFragment();
                if (currentFragment3 != null && currentFragment3.getWebView() != null) {
                    currentFragment3.getWebView().reload();
                    this.mBinding.actionRefresh.clearAnimation();
                    ValueAnimator valueAnimator = this.mRefreshAnimator;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        this.mRefreshAnimator.cancel();
                    }
                    ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
                    this.mRefreshAnimator = ofInt;
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.coolapk.market.view.webview.CoolBrowserActivity.AnonymousClass4 */

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            CoolBrowserActivity.this.mBinding.actionRefresh.setRotation((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    this.mRefreshAnimator.setInterpolator(new LinearInterpolator());
                    this.mRefreshAnimator.setRepeatCount(-1);
                    this.mRefreshAnimator.setDuration(500L);
                    this.mRefreshAnimator.start();
                    return;
                }
                return;
            case 2131362136:
                hidePageList(true);
                return;
            case 2131362171:
                addPage();
                return;
            case 2131362172:
                removeAllPage();
                return;
            case 2131362173:
                CoolBrowserFragment currentFragment4 = getCurrentFragment();
                if (currentFragment4 != null && currentFragment4.getWebView() != null) {
                    currentFragment4.getWebView().loadUrl(this.mBrowserData.getHomePage());
                    return;
                }
                return;
            case 2131362862:
                if (this.mIsBottomViewShow) {
                    hidePageList(false);
                }
                if (!this.mIsFocusMode) {
                    requestFocus();
                    return;
                }
                return;
            case 2131362908:
                if (this.mIsFocusMode) {
                    hideFocus();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void addPage() {
        CoolBrowserData coolBrowserData = this.mBrowserData;
        CoolBrowserData.PageData createNewPage = coolBrowserData.createNewPage(coolBrowserData.getHomePage());
        this.mAdapter.notifyItemInserted(this.mBrowserData.getPageCount() - 1);
        CoolBrowserFragment orCreateFragment = createNewPage.getOrCreateFragment(getSupportFragmentManager());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        CoolBrowserFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            beginTransaction.hide(currentFragment);
        }
        beginTransaction.add(2131363592, orCreateFragment).commit();
        this.mBrowserData.setCurrentPageData(createNewPage);
    }

    private void removeAllPage() {
        int pageCount = this.mBrowserData.getPageCount();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.mBrowserData.removeAllPage(beginTransaction);
        beginTransaction.commit();
        this.mAdapter.notifyItemRangeRemoved(0, pageCount);
        addPage();
    }

    /* access modifiers changed from: private */
    public void removePageAt(int i) {
        CoolBrowserData.PageData pageAt = this.mBrowserData.getPageAt(i);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.mBrowserData.removePage(beginTransaction, i);
        beginTransaction.commit();
        this.mAdapter.notifyItemRemoved(i);
        if (this.mBrowserData.getPageCount() <= 0) {
            addPage();
        } else if (pageAt.equals(this.mBrowserData.getCurrentPageData())) {
            if (i > 0) {
                i--;
            }
            getSupportFragmentManager().beginTransaction().show(this.mBrowserData.getPageAt(i).getOrCreateFragment(getSupportFragmentManager())).commit();
        }
    }

    /* access modifiers changed from: private */
    public void presentPage(int i) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        CoolBrowserFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            beginTransaction.hide(currentFragment);
        }
        CoolBrowserData.PageData pageAt = this.mBrowserData.getPageAt(i);
        CoolBrowserFragment orCreateFragment = pageAt.getOrCreateFragment(getSupportFragmentManager());
        if (orCreateFragment.isAdded()) {
            beginTransaction.show(orCreateFragment);
        } else {
            beginTransaction.add(2131363592, orCreateFragment);
        }
        beginTransaction.commit();
        this.mBrowserData.setCurrentPageData(pageAt);
        hidePageList(true);
    }

    private CoolBrowserFragment getCurrentFragment() {
        return this.mBrowserData.getCurrentPageData().getOrCreateFragment(getSupportFragmentManager());
    }

    private void showPageList() {
        if (!this.mIsBottomViewShow) {
            this.mIsBottomViewShow = true;
            this.mBinding.bottomMaskView.setVisibility(0);
            this.mBinding.bottomView.setTranslationY(0.0f);
            TransitionManager.beginDelayedTransition(this.mBinding.bottomMaskView, new Slide());
            this.mBinding.bottomView.setVisibility(0);
        }
    }

    private void hidePageList(boolean z) {
        if (this.mIsBottomViewShow) {
            this.mIsBottomViewShow = false;
            if (z) {
                this.mBinding.bottomView.animate().translationY((float) this.mBinding.bottomView.getHeight()).setListener(new AnimatorListenerAdapter() {
                    /* class com.coolapk.market.view.webview.CoolBrowserActivity.AnonymousClass5 */

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        CoolBrowserActivity.this.mBinding.bottomMaskView.setVisibility(8);
                        CoolBrowserActivity.this.mBinding.bottomView.setVisibility(8);
                    }
                }).start();
                return;
            }
            this.mBinding.bottomMaskView.setVisibility(8);
            this.mBinding.bottomView.setVisibility(8);
        }
    }

    @Override // com.coolapk.market.view.webview.CoolBrowserCommunicator
    public void onTitleReceived(String str, CoolBrowserData.PageData pageData) {
        if (pageData.equals(this.mBrowserData.getCurrentPageData())) {
            this.mBinding.linkTextView.setText(str);
        }
        int indexOfPageData = this.mBrowserData.indexOfPageData(pageData);
        if (indexOfPageData >= 0) {
            this.mAdapter.notifyItemChanged(indexOfPageData);
        }
    }

    @Override // com.coolapk.market.view.webview.CoolBrowserCommunicator
    public void onUrlLoad(String str, CoolBrowserData.PageData pageData) {
        if (pageData.equals(this.mBrowserData.getCurrentPageData())) {
            this.mBinding.editText.setText(str);
            this.mBinding.editText.setSelection(str.length());
        }
    }

    @Override // com.coolapk.market.view.webview.CoolBrowserCommunicator
    public void onReceivedIcon(Bitmap bitmap, CoolBrowserData.PageData pageData) {
        int indexOfPageData = this.mBrowserData.indexOfPageData(pageData);
        if (indexOfPageData >= 0) {
            this.mAdapter.notifyItemChanged(indexOfPageData);
        }
    }

    @Override // com.coolapk.market.view.webview.CoolBrowserCommunicator
    public void onPageLoadFinished(CoolBrowserData.PageData pageData) {
        ValueAnimator valueAnimator = this.mRefreshAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mRefreshAnimator.cancel();
        }
        if (this.mBinding.actionRefresh.getRotation() != 0.0f) {
            ValueAnimator ofInt = ValueAnimator.ofInt((int) this.mBinding.actionRefresh.getRotation(), 360);
            this.mRefreshAnimator = ofInt;
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.coolapk.market.view.webview.CoolBrowserActivity.AnonymousClass6 */

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CoolBrowserActivity.this.mBinding.actionRefresh.setRotation((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.mRefreshAnimator.setInterpolator(new LinearInterpolator());
            this.mRefreshAnimator.setDuration(500 / (1 - (((long) this.mBinding.actionRefresh.getRotation()) / 500)));
            this.mRefreshAnimator.start();
        }
    }

    private class PageViewHolder extends BindingViewHolder {
        public PageViewHolder(View view) {
            super(view);
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            CoolBrowserData.PageData pageData = (CoolBrowserData.PageData) obj;
            ItemWebviewPageBinding itemWebviewPageBinding = (ItemWebviewPageBinding) getBinding();
            itemWebviewPageBinding.iconView.setImageDrawable(pageData.getIcon(CoolBrowserActivity.this.getActivity()));
            itemWebviewPageBinding.titleView.setText(pageData.getTitle());
            itemWebviewPageBinding.closeView.setOnClickListener(new View.OnClickListener() {
                /* class com.coolapk.market.view.webview.CoolBrowserActivity.PageViewHolder.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!UiUtils.isInvalidPosition(PageViewHolder.this.getAdapterPosition())) {
                        CoolBrowserActivity.this.removePageAt(PageViewHolder.this.getAdapterPosition());
                    }
                }
            });
            itemWebviewPageBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                /* class com.coolapk.market.view.webview.CoolBrowserActivity.PageViewHolder.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!UiUtils.isInvalidPosition(PageViewHolder.this.getAdapterPosition())) {
                        CoolBrowserActivity.this.presentPage(PageViewHolder.this.getAdapterPosition());
                    }
                }
            });
        }
    }

    private class PageAdapter extends RecyclerView.Adapter {
        private PageAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new PageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2131558991, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((PageViewHolder) viewHolder).bindTo(CoolBrowserActivity.this.mBrowserData.getPageAt(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CoolBrowserActivity.this.mBrowserData.getPageCount();
        }
    }
}
