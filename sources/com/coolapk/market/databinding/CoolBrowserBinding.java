package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

public abstract class CoolBrowserBinding extends ViewDataBinding {
    public final ImageButton actionBackward;
    public final ImageButton actionClear;
    public final LinearLayout actionContainer;
    public final ImageButton actionForward;
    public final ImageButton actionMore;
    public final ImageButton actionPage;
    public final ImageButton actionQrcode;
    public final ImageButton actionRefresh;
    public final ImageButton actionSearchEngine;
    public final AppBarLayout appBar;
    public final FrameLayout bottomMaskView;
    public final LinearLayout bottomView;
    public final ImageButton buttonAdd;
    public final ImageButton buttonClearAll;
    public final ImageButton buttonHome;
    public final EditText editText;
    public final RelativeLayout linkContentView;
    public final TextView linkTextView;
    @Bindable
    protected View.OnClickListener mClick;
    public final CoordinatorLayout mainContent;
    public final View maskView;
    public final RecyclerView pageListView;
    public final FrameLayout toolbarContentFragment;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected CoolBrowserBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, LinearLayout linearLayout, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, AppBarLayout appBarLayout, FrameLayout frameLayout, LinearLayout linearLayout2, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, EditText editText2, RelativeLayout relativeLayout, TextView textView, CoordinatorLayout coordinatorLayout, View view2, RecyclerView recyclerView, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.actionBackward = imageButton;
        this.actionClear = imageButton2;
        this.actionContainer = linearLayout;
        this.actionForward = imageButton3;
        this.actionMore = imageButton4;
        this.actionPage = imageButton5;
        this.actionQrcode = imageButton6;
        this.actionRefresh = imageButton7;
        this.actionSearchEngine = imageButton8;
        this.appBar = appBarLayout;
        this.bottomMaskView = frameLayout;
        this.bottomView = linearLayout2;
        this.buttonAdd = imageButton9;
        this.buttonClearAll = imageButton10;
        this.buttonHome = imageButton11;
        this.editText = editText2;
        this.linkContentView = relativeLayout;
        this.linkTextView = textView;
        this.mainContent = coordinatorLayout;
        this.maskView = view2;
        this.pageListView = recyclerView;
        this.toolbarContentFragment = frameLayout2;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static CoolBrowserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolBrowserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CoolBrowserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558486, viewGroup, z, obj);
    }

    public static CoolBrowserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolBrowserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CoolBrowserBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558486, null, false, obj);
    }

    public static CoolBrowserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CoolBrowserBinding bind(View view, Object obj) {
        return (CoolBrowserBinding) bind(obj, view, 2131558486);
    }
}
