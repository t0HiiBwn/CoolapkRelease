package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class ItemNodeRatingSelectorBinding extends ViewDataBinding {
    public final CheckBox buyStatusCheck;
    public final CheckBox hasCommentCheckBox;
    public final LinearLayout itemView;
    @Bindable
    protected View.OnClickListener mClick;
    public final CheckBox noCommentCheckBox;
    public final CheckBox ownerCheck;
    public final TextView star1View;
    public final TextView star2View;
    public final TextView star3View;
    public final TextView star4View;
    public final TextView star5View;
    public final TextView starAllView;
    public final CheckBox versionCheckBox;

    public abstract void setClick(View.OnClickListener onClickListener);

    protected ItemNodeRatingSelectorBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, LinearLayout linearLayout, CheckBox checkBox3, CheckBox checkBox4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, CheckBox checkBox5) {
        super(obj, view, i);
        this.buyStatusCheck = checkBox;
        this.hasCommentCheckBox = checkBox2;
        this.itemView = linearLayout;
        this.noCommentCheckBox = checkBox3;
        this.ownerCheck = checkBox4;
        this.star1View = textView;
        this.star2View = textView2;
        this.star3View = textView3;
        this.star4View = textView4;
        this.star5View = textView5;
        this.starAllView = textView6;
        this.versionCheckBox = checkBox5;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ItemNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNodeRatingSelectorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558840, viewGroup, z, obj);
    }

    public static ItemNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeRatingSelectorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNodeRatingSelectorBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558840, null, false, obj);
    }

    public static ItemNodeRatingSelectorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemNodeRatingSelectorBinding bind(View view, Object obj) {
        return (ItemNodeRatingSelectorBinding) bind(obj, view, 2131558840);
    }
}
