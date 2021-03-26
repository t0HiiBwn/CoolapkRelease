package com.coolapk.market.view.message;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.BaseNewChattingBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.emotion.EmotionPanel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u00017B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u0006\u0010)\u001a\u00020\u001cJ\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001eJ\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001cH\u0014J\u0012\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u000102H&J\u000e\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\rJ\u000e\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\rR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u00060\u0017R\u00020\u00002\n\u0010\u0016\u001a\u00060\u0017R\u00020\u0000@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00068"}, d2 = {"Lcom/coolapk/market/view/message/NewBaseChatActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/BaseNewChattingBinding;", "getBinding", "()Lcom/coolapk/market/databinding/BaseNewChattingBinding;", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "posting", "", "isPosting", "()Z", "setPosting", "(Z)V", "mBinding", "mShouldShowEmotionBoardAfterKeyBoardClosed", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "<set-?>", "Lcom/coolapk/market/view/message/NewBaseChatActivity$ViewMode;", "viewMode", "getViewMode", "()Lcom/coolapk/market/view/message/NewBaseChatActivity$ViewMode;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyBoardHide", "onKeyBoardShow", "height", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSetStatusBarColor", "postReply", "text", "", "setEditing", "editing", "setEmotionPanelVisibleWithAnim", "show", "ViewMode", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NewBaseChatActivity.kt */
public abstract class NewBaseChatActivity extends FakeStatusBarActivity implements View.OnClickListener {
    private BaseNewChattingBinding mBinding;
    private boolean mShouldShowEmotionBoardAfterKeyBoardClosed;
    private Toolbar mToolbar;
    private ViewMode viewMode;

    public abstract void postReply(String str);

    public static final /* synthetic */ BaseNewChattingBinding access$getMBinding$p(NewBaseChatActivity newBaseChatActivity) {
        BaseNewChattingBinding baseNewChattingBinding = newBaseChatActivity.mBinding;
        if (baseNewChattingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return baseNewChattingBinding;
    }

    public static final /* synthetic */ ViewMode access$getViewMode$p(NewBaseChatActivity newBaseChatActivity) {
        ViewMode viewMode2 = newBaseChatActivity.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        return viewMode2;
    }

    public final ViewMode getViewMode() {
        ViewMode viewMode2 = this.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        return viewMode2;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131558475);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…layout.base_new_chatting)");
        BaseNewChattingBinding baseNewChattingBinding = (BaseNewChattingBinding) contentView;
        this.mBinding = baseNewChattingBinding;
        if (baseNewChattingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        Toolbar toolbar = baseNewChattingBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "mBinding.toolbar");
        this.mToolbar = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolbar");
        }
        setSupportActionBar(toolbar);
        Toolbar toolbar2 = this.mToolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolbar");
        }
        toolbar2.setTitle(getTitle());
        Toolbar toolbar3 = this.mToolbar;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolbar");
        }
        toolbar3.setNavigationIcon(2131231166);
        Toolbar toolbar4 = this.mToolbar;
        if (toolbar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolbar");
        }
        ViewExtendsKt.setTintColor(toolbar4);
        BaseNewChattingBinding baseNewChattingBinding2 = this.mBinding;
        if (baseNewChattingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        baseNewChattingBinding2.setClick(this);
        this.viewMode = new ViewMode();
        BaseNewChattingBinding baseNewChattingBinding3 = this.mBinding;
        if (baseNewChattingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        ViewMode viewMode2 = this.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        baseNewChattingBinding3.setViewModel(viewMode2);
        BaseNewChattingBinding baseNewChattingBinding4 = this.mBinding;
        if (baseNewChattingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EmotionPanel emotionPanel = baseNewChattingBinding4.emotionPanel;
        BaseNewChattingBinding baseNewChattingBinding5 = this.mBinding;
        if (baseNewChattingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        emotionPanel.setupWithEditText(baseNewChattingBinding5.editText);
        BaseNewChattingBinding baseNewChattingBinding6 = this.mBinding;
        if (baseNewChattingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        baseNewChattingBinding6.contentView.addOnLayoutChangeListener(new NewBaseChatActivity$onCreate$1(this));
        BaseNewChattingBinding baseNewChattingBinding7 = this.mBinding;
        if (baseNewChattingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        baseNewChattingBinding7.editText.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        BaseNewChattingBinding baseNewChattingBinding8 = this.mBinding;
        if (baseNewChattingBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        baseNewChattingBinding8.editText.addTextChangedListener(new NewBaseChatActivity$onCreate$2(this));
        BaseNewChattingBinding baseNewChattingBinding9 = this.mBinding;
        if (baseNewChattingBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        baseNewChattingBinding9.editText.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new NewBaseChatActivity$onCreate$3(this)));
        BaseNewChattingBinding baseNewChattingBinding10 = this.mBinding;
        if (baseNewChattingBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        baseNewChattingBinding10.editText.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        Toolbar toolbar5 = this.mToolbar;
        if (toolbar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolbar");
        }
        ViewUtil.doubleClickListener(toolbar5, new NewBaseChatActivity$onCreate$4(this));
    }

    public final void onKeyBoardShow(int i) {
        BaseNewChattingBinding baseNewChattingBinding = this.mBinding;
        if (baseNewChattingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EmotionPanel emotionPanel = baseNewChattingBinding.emotionPanel;
        Intrinsics.checkNotNullExpressionValue(emotionPanel, "mBinding.emotionPanel");
        if (emotionPanel.getLayoutParams().height != i) {
            emotionPanel.getLayoutParams().height = i;
            emotionPanel.requestLayout();
        }
        ViewMode viewMode2 = this.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        viewMode2.setKeyBoardShow(true);
        if (emotionPanel.isShown()) {
            emotionPanel.setVisibility(8);
        }
    }

    public final void onKeyBoardHide() {
        BaseNewChattingBinding baseNewChattingBinding = this.mBinding;
        if (baseNewChattingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EmotionPanel emotionPanel = baseNewChattingBinding.emotionPanel;
        Intrinsics.checkNotNullExpressionValue(emotionPanel, "mBinding.emotionPanel");
        ViewMode viewMode2 = this.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        viewMode2.setKeyBoardShow(false);
        if (this.mShouldShowEmotionBoardAfterKeyBoardClosed && !emotionPanel.isShown()) {
            BaseNewChattingBinding baseNewChattingBinding2 = this.mBinding;
            if (baseNewChattingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            }
            EmotionPanel emotionPanel2 = baseNewChattingBinding2.emotionPanel;
            Intrinsics.checkNotNullExpressionValue(emotionPanel2, "mBinding.emotionPanel");
            emotionPanel2.setVisibility(0);
            this.mShouldShowEmotionBoardAfterKeyBoardClosed = false;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131362670) {
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
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131362448:
                ViewMode viewMode2 = this.viewMode;
                if (viewMode2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewMode");
                }
                Intrinsics.checkNotNull(viewMode2);
                if (!viewMode2.isKeyBoardShow()) {
                    BaseNewChattingBinding baseNewChattingBinding = this.mBinding;
                    if (baseNewChattingBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    }
                    EmotionPanel emotionPanel = baseNewChattingBinding.emotionPanel;
                    Intrinsics.checkNotNullExpressionValue(emotionPanel, "mBinding.emotionPanel");
                    if (emotionPanel.isShown()) {
                        BaseNewChattingBinding baseNewChattingBinding2 = this.mBinding;
                        if (baseNewChattingBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        }
                        FrameLayout frameLayout = baseNewChattingBinding2.toolbarContentFragment;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.toolbarContentFragment");
                        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.weight = 0.0f;
                        BaseNewChattingBinding baseNewChattingBinding3 = this.mBinding;
                        if (baseNewChattingBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        }
                        FrameLayout frameLayout2 = baseNewChattingBinding3.toolbarContentFragment;
                        Intrinsics.checkNotNullExpressionValue(frameLayout2, "mBinding.toolbarContentFragment");
                        layoutParams2.height = frameLayout2.getMeasuredHeight();
                        BaseNewChattingBinding baseNewChattingBinding4 = this.mBinding;
                        if (baseNewChattingBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        }
                        baseNewChattingBinding4.toolbarContentFragment.requestLayout();
                        BaseNewChattingBinding baseNewChattingBinding5 = this.mBinding;
                        if (baseNewChattingBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        }
                        EmotionPanel emotionPanel2 = baseNewChattingBinding5.emotionPanel;
                        Intrinsics.checkNotNullExpressionValue(emotionPanel2, "mBinding.emotionPanel");
                        emotionPanel2.setVisibility(8);
                        AppHolder.getMainThreadHandler().postDelayed(new NewBaseChatActivity$onClick$3(this), 200);
                        return;
                    }
                    return;
                }
                return;
            case 2131362712:
                ActionManager.startPhotoPickerActivity(this, true);
                return;
            case 2131362930:
                ActionManager.startPickUserActivity(this, 8655);
                return;
            case 2131362935:
                ViewMode viewMode3 = this.viewMode;
                if (viewMode3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewMode");
                }
                Intrinsics.checkNotNull(viewMode3);
                if (viewMode3.isKeyBoardShow()) {
                    BaseNewChattingBinding baseNewChattingBinding6 = this.mBinding;
                    if (baseNewChattingBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    }
                    UiUtils.closeKeyboard(baseNewChattingBinding6.editText);
                    this.mShouldShowEmotionBoardAfterKeyBoardClosed = true;
                    AppHolder.getMainThreadHandler().postDelayed(new NewBaseChatActivity$onClick$1(this), 200);
                    return;
                }
                BaseNewChattingBinding baseNewChattingBinding7 = this.mBinding;
                if (baseNewChattingBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                }
                EmotionPanel emotionPanel3 = baseNewChattingBinding7.emotionPanel;
                Intrinsics.checkNotNullExpressionValue(emotionPanel3, "mBinding.emotionPanel");
                if (emotionPanel3.isShown()) {
                    BaseNewChattingBinding baseNewChattingBinding8 = this.mBinding;
                    if (baseNewChattingBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    }
                    FrameLayout frameLayout3 = baseNewChattingBinding8.toolbarContentFragment;
                    Intrinsics.checkNotNullExpressionValue(frameLayout3, "mBinding.toolbarContentFragment");
                    ViewGroup.LayoutParams layoutParams3 = frameLayout3.getLayoutParams();
                    Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                    layoutParams4.weight = 0.0f;
                    BaseNewChattingBinding baseNewChattingBinding9 = this.mBinding;
                    if (baseNewChattingBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    }
                    FrameLayout frameLayout4 = baseNewChattingBinding9.toolbarContentFragment;
                    Intrinsics.checkNotNullExpressionValue(frameLayout4, "mBinding.toolbarContentFragment");
                    layoutParams4.height = frameLayout4.getMeasuredHeight();
                    BaseNewChattingBinding baseNewChattingBinding10 = this.mBinding;
                    if (baseNewChattingBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    }
                    baseNewChattingBinding10.toolbarContentFragment.requestLayout();
                    BaseNewChattingBinding baseNewChattingBinding11 = this.mBinding;
                    if (baseNewChattingBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    }
                    EmotionPanel emotionPanel4 = baseNewChattingBinding11.emotionPanel;
                    Intrinsics.checkNotNullExpressionValue(emotionPanel4, "mBinding.emotionPanel");
                    emotionPanel4.setVisibility(8);
                    BaseNewChattingBinding baseNewChattingBinding12 = this.mBinding;
                    if (baseNewChattingBinding12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    }
                    UiUtils.openKeyboard(baseNewChattingBinding12.editText);
                    AppHolder.getMainThreadHandler().postDelayed(new NewBaseChatActivity$onClick$2(this, layoutParams4), 200);
                    return;
                }
                BaseNewChattingBinding baseNewChattingBinding13 = this.mBinding;
                if (baseNewChattingBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                }
                EmotionPanel emotionPanel5 = baseNewChattingBinding13.emotionPanel;
                Intrinsics.checkNotNullExpressionValue(emotionPanel5, "mBinding.emotionPanel");
                setEmotionPanelVisibleWithAnim(!emotionPanel5.isShown());
                ViewMode viewMode4 = this.viewMode;
                if (viewMode4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewMode");
                }
                Intrinsics.checkNotNull(viewMode4);
                viewMode4.setKeyBoardShow(false);
                return;
            case 2131362938:
                BaseNewChattingBinding baseNewChattingBinding14 = this.mBinding;
                if (baseNewChattingBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                }
                EditText editText = baseNewChattingBinding14.editText;
                Intrinsics.checkNotNullExpressionValue(editText, "mBinding.editText");
                postReply(editText.getText().toString());
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 8655) {
            BaseNewChattingBinding baseNewChattingBinding = this.mBinding;
            if (baseNewChattingBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            }
            CommentHelper.processAtUserResult(intent, baseNewChattingBinding.editText);
        }
        BaseNewChattingBinding baseNewChattingBinding2 = this.mBinding;
        if (baseNewChattingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        baseNewChattingBinding2.editText.clearFocus();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!setEmotionPanelVisibleWithAnim(false)) {
            super.onBackPressed();
        }
    }

    public final boolean isPosting() {
        ViewMode viewMode2 = this.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        Intrinsics.checkNotNull(viewMode2);
        return viewMode2.isPosting();
    }

    public final void setPosting(boolean z) {
        ViewMode viewMode2 = this.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        Intrinsics.checkNotNull(viewMode2);
        viewMode2.setPosting(z);
    }

    public final void setEditing(boolean z) {
        ViewMode viewMode2 = this.viewMode;
        if (viewMode2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewMode");
        }
        viewMode2.setEditing(z);
    }

    public final EditText getEditText() {
        BaseNewChattingBinding baseNewChattingBinding = this.mBinding;
        if (baseNewChattingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EditText editText = baseNewChattingBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "mBinding.editText");
        return editText;
    }

    public final BaseNewChattingBinding getBinding() {
        BaseNewChattingBinding baseNewChattingBinding = this.mBinding;
        if (baseNewChattingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return baseNewChattingBinding;
    }

    public final boolean setEmotionPanelVisibleWithAnim(boolean z) {
        BaseNewChattingBinding baseNewChattingBinding = this.mBinding;
        if (baseNewChattingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EmotionPanel emotionPanel = baseNewChattingBinding.emotionPanel;
        Intrinsics.checkNotNullExpressionValue(emotionPanel, "mBinding.emotionPanel");
        int i = 0;
        if (z == emotionPanel.isShown()) {
            return false;
        }
        BaseNewChattingBinding baseNewChattingBinding2 = this.mBinding;
        if (baseNewChattingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EmotionPanel emotionPanel2 = baseNewChattingBinding2.emotionPanel;
        Intrinsics.checkNotNullExpressionValue(emotionPanel2, "mBinding.emotionPanel");
        ViewParent parent = emotionPanel2.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        TransitionManager.beginDelayedTransition((ViewGroup) parent, new Slide());
        BaseNewChattingBinding baseNewChattingBinding3 = this.mBinding;
        if (baseNewChattingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EmotionPanel emotionPanel3 = baseNewChattingBinding3.emotionPanel;
        Intrinsics.checkNotNullExpressionValue(emotionPanel3, "mBinding.emotionPanel");
        if (!z) {
            i = 8;
        }
        emotionPanel3.setVisibility(i);
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048G@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/message/NewBaseChatActivity$ViewMode;", "Landroidx/databinding/BaseObservable;", "(Lcom/coolapk/market/view/message/NewBaseChatActivity;)V", "editing", "", "show", "isKeyBoardShow", "()Z", "setKeyBoardShow", "(Z)V", "isShowImapick", "isShowPostView", "posting", "isEditing", "isPosting", "setEditing", "", "setPosting", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NewBaseChatActivity.kt */
    public final class ViewMode extends BaseObservable {
        private boolean editing;
        private boolean isKeyBoardShow;
        private boolean posting;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ViewMode() {
        }

        @Bindable
        public final boolean isKeyBoardShow() {
            return this.isKeyBoardShow;
        }

        public final void setKeyBoardShow(boolean z) {
            this.isKeyBoardShow = z;
            NewBaseChatActivity.access$getMBinding$p(NewBaseChatActivity.this).emotionPanel.post(new NewBaseChatActivity$ViewMode$isKeyBoardShow$1(this));
        }

        @Bindable
        public final boolean isPosting() {
            return this.posting;
        }

        @Bindable
        public final boolean isEditing() {
            return this.editing;
        }

        public final void setEditing(boolean z) {
            this.editing = z;
            notifyPropertyChanged(256);
            notifyPropertyChanged(252);
            notifyPropertyChanged(89);
        }

        @Bindable
        public final boolean isShowPostView() {
            return !this.posting && this.editing;
        }

        @Bindable
        public final boolean isShowImapick() {
            return !this.editing && !this.posting;
        }

        public final void setPosting(boolean z) {
            this.posting = z;
            notifyPropertyChanged(256);
            notifyPropertyChanged(252);
            notifyPropertyChanged(226);
            NewBaseChatActivity.access$getMBinding$p(NewBaseChatActivity.this).executePendingBindings();
        }
    }
}
