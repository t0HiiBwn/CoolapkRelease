package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.view.KeyBoardLayout;

public abstract class ShareFeedV8Binding extends ViewDataBinding {
    public final LinearLayout actionDiscovery;
    public final LinearLayout bottomAreaView;
    public final ImageView closeView;
    public final EditText editText;
    public final KeyBoardLayout keyBoardInteractLayout;
    public final TextView locationName;
    @Bindable
    protected View.OnClickListener mClick;
    public final ImageView mapMarkerView;
    public final ImageView menuCloseKeyboard;
    public final View spaceView;
    public final TextView submitView;
    public final LinearLayout toolbarLayout;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ShareFeedV8Binding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, EditText editText2, KeyBoardLayout keyBoardLayout, TextView textView, ImageView imageView2, ImageView imageView3, View view2, TextView textView2, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.actionDiscovery = linearLayout;
        this.bottomAreaView = linearLayout2;
        this.closeView = imageView;
        this.editText = editText2;
        this.keyBoardInteractLayout = keyBoardLayout;
        this.locationName = textView;
        this.mapMarkerView = imageView2;
        this.menuCloseKeyboard = imageView3;
        this.spaceView = view2;
        this.submitView = textView2;
        this.toolbarLayout = linearLayout3;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ShareFeedV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareFeedV8Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ShareFeedV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559145, viewGroup, z, obj);
    }

    public static ShareFeedV8Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareFeedV8Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ShareFeedV8Binding) ViewDataBinding.inflateInternal(layoutInflater, 2131559145, null, false, obj);
    }

    public static ShareFeedV8Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ShareFeedV8Binding bind(View view, Object obj) {
        return (ShareFeedV8Binding) bind(obj, view, 2131559145);
    }
}
