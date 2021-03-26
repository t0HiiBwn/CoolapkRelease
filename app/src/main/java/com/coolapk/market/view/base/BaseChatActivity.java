package com.coolapk.market.view.base;

import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.BaseChattingBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.OnKeyBoardEventAdapter;
import com.coolapk.market.widget.emotion.EmotionPanel;

public abstract class BaseChatActivity extends FakeStatusBarActivity implements View.OnClickListener {
    private BaseChattingBinding mBinding;
    private boolean mShouldShowEmotionBoardAfterKeyBoardClosed;
    private Toolbar mToolbar;
    private ViewMode mViewMode;

    public abstract void postReply(String str);

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseChattingBinding baseChattingBinding = (BaseChattingBinding) DataBindingUtil.setContentView(this, 2131558473);
        this.mBinding = baseChattingBinding;
        Toolbar toolbar = baseChattingBinding.toolbar;
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.mToolbar.setTitle(getTitle());
        this.mToolbar.setNavigationIcon(2131231156);
        ViewExtendsKt.setTintColor(this.mToolbar);
        this.mBinding.setClick(this);
        ViewMode viewMode = new ViewMode();
        this.mViewMode = viewMode;
        this.mBinding.setViewModel(viewMode);
        this.mBinding.emotionPanel.setupWithEditText(this.mBinding.editText);
        this.mBinding.contentView.addOnLayoutChangeListener(new OnKeyBoardEventAdapter() {
            /* class com.coolapk.market.view.base.BaseChatActivity.AnonymousClass1 */

            @Override // com.coolapk.market.widget.KeyBoardListener
            public void onKeyBoardShow(int i) {
                BaseChatActivity.this.onKeyBoardShow(i);
            }

            @Override // com.coolapk.market.widget.KeyBoardListener
            public void onKeyBoardHide() {
                BaseChatActivity.this.onKeyBoardHide();
            }
        });
        this.mBinding.editText.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        this.mBinding.editText.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new Runnable() {
            /* class com.coolapk.market.view.base.$$Lambda$BaseChatActivity$EA0k8o6nng88xjXF76exQNkdGo */

            @Override // java.lang.Runnable
            public final void run() {
                BaseChatActivity.this.lambda$onCreate$0$BaseChatActivity();
            }
        }));
        this.mBinding.editText.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        ViewUtil.doubleClickListener(this.mToolbar, new ViewUtil.OnDoubleClickListener() {
            /* class com.coolapk.market.view.base.BaseChatActivity.AnonymousClass2 */

            @Override // com.coolapk.market.util.ViewUtil.OnDoubleClickListener
            public boolean onDoubleClick(View view) {
                Fragment findFragmentById = BaseChatActivity.this.getSupportFragmentManager().findFragmentById(2131363592);
                if (!(findFragmentById instanceof ScrollableFragment) || !findFragmentById.isVisible()) {
                    return false;
                }
                ((ScrollableFragment) findFragmentById).scrollToTop(true);
                return true;
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$BaseChatActivity() {
        ActionManager.startPickUserActivity(this, 8655);
    }

    public void onKeyBoardShow(int i) {
        EmotionPanel emotionPanel = this.mBinding.emotionPanel;
        if (emotionPanel.getLayoutParams().height != i) {
            emotionPanel.getLayoutParams().height = i;
            emotionPanel.requestLayout();
        }
        this.mViewMode.setKeyBoardShow(true);
        if (emotionPanel.isShown()) {
            emotionPanel.setVisibility(8);
        }
    }

    public void onKeyBoardHide() {
        EmotionPanel emotionPanel = this.mBinding.emotionPanel;
        this.mViewMode.setKeyBoardShow(false);
        if (this.mShouldShowEmotionBoardAfterKeyBoardClosed && !emotionPanel.isShown()) {
            this.mBinding.emotionPanel.setVisibility(0);
            this.mShouldShowEmotionBoardAfterKeyBoardClosed = false;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131362441:
                if (!this.mViewMode.isKeyBoardShow() && this.mBinding.emotionPanel.isShown()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBinding.toolbarContentFragment.getLayoutParams();
                    layoutParams.weight = 0.0f;
                    layoutParams.height = this.mBinding.toolbarContentFragment.getMeasuredHeight();
                    this.mBinding.toolbarContentFragment.requestLayout();
                    this.mBinding.emotionPanel.setVisibility(8);
                    AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
                        /* class com.coolapk.market.view.base.BaseChatActivity.AnonymousClass5 */

                        @Override // java.lang.Runnable
                        public void run() {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BaseChatActivity.this.mBinding.toolbarContentFragment.getLayoutParams();
                            layoutParams.weight = 1.0f;
                            layoutParams.height = 0;
                            BaseChatActivity.this.mBinding.toolbarContentFragment.requestLayout();
                        }
                    }, 200);
                    return;
                }
                return;
            case 2131362918:
                ActionManager.startPickUserActivity(this, 8655);
                return;
            case 2131362923:
                if (this.mViewMode.isKeyBoardShow()) {
                    UiUtils.closeKeyboard(this.mBinding.editText);
                    this.mShouldShowEmotionBoardAfterKeyBoardClosed = true;
                    AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
                        /* class com.coolapk.market.view.base.BaseChatActivity.AnonymousClass3 */

                        @Override // java.lang.Runnable
                        public void run() {
                            if (BaseChatActivity.this.mShouldShowEmotionBoardAfterKeyBoardClosed && !BaseChatActivity.this.mBinding.emotionPanel.isShown()) {
                                BaseChatActivity.this.mBinding.emotionPanel.setVisibility(0);
                                BaseChatActivity.this.mShouldShowEmotionBoardAfterKeyBoardClosed = false;
                            }
                        }
                    }, 200);
                    return;
                } else if (this.mBinding.emotionPanel.isShown()) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBinding.toolbarContentFragment.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.height = this.mBinding.toolbarContentFragment.getMeasuredHeight();
                    this.mBinding.toolbarContentFragment.requestLayout();
                    this.mBinding.emotionPanel.setVisibility(8);
                    UiUtils.openKeyboard(this.mBinding.editText);
                    AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
                        /* class com.coolapk.market.view.base.BaseChatActivity.AnonymousClass4 */

                        @Override // java.lang.Runnable
                        public void run() {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BaseChatActivity.this.mBinding.toolbarContentFragment.getLayoutParams();
                            layoutParams.weight = 1.0f;
                            layoutParams.height = 0;
                            BaseChatActivity.this.mBinding.toolbarContentFragment.requestLayout();
                        }
                    }, 200);
                    return;
                } else {
                    setEmotionPanelVisibleWithAnim(!this.mBinding.emotionPanel.isShown());
                    return;
                }
            case 2131362926:
                postReply(this.mBinding.editText.getText().toString());
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!setEmotionPanelVisibleWithAnim(false)) {
            super.onBackPressed();
        }
    }

    public boolean isPosting() {
        return this.mViewMode.isPosting();
    }

    public void setPosting(boolean z) {
        this.mViewMode.setPosting(z);
    }

    public EditText getEditText() {
        return this.mBinding.editText;
    }

    public boolean setEmotionPanelVisibleWithAnim(boolean z) {
        int i = 0;
        if (z == this.mBinding.emotionPanel.isShown()) {
            return false;
        }
        TransitionManager.beginDelayedTransition((ViewGroup) this.mBinding.emotionPanel.getParent(), new Slide());
        EmotionPanel emotionPanel = this.mBinding.emotionPanel;
        if (!z) {
            i = 8;
        }
        emotionPanel.setVisibility(i);
        return true;
    }

    public class ViewMode extends BaseObservable {
        private boolean keyBoardShow;
        private boolean posting;

        public ViewMode() {
        }

        @Bindable
        public boolean isPosting() {
            return this.posting;
        }

        public void setPosting(boolean z) {
            this.posting = z;
            notifyPropertyChanged(225);
            BaseChatActivity.this.mBinding.executePendingBindings();
        }

        @Bindable
        public boolean isKeyBoardShow() {
            return this.keyBoardShow;
        }

        public void setKeyBoardShow(boolean z) {
            this.keyBoardShow = z;
            BaseChatActivity.this.mBinding.emotionPanel.post(new Runnable() {
                /* class com.coolapk.market.view.base.BaseChatActivity.ViewMode.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (BaseChatActivity.this.mBinding.emotionPanel.isShown()) {
                        BaseChatActivity.this.mBinding.menuEmotion.setImageResource(2131231386);
                    } else {
                        BaseChatActivity.this.mBinding.menuEmotion.setImageResource(2131231278);
                    }
                }
            });
        }
    }
}
