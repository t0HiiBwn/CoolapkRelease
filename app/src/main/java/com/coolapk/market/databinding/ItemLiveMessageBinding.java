package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.hanks.htextview.rainbow.RainbowTextView;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class ItemLiveMessageBinding extends ViewDataBinding {
    public final RoundedImageView avatarView;
    public final TableLayout headerLayout;
    public final LinearLayout itemView;
    public final LinearLayout messageLayout;
    public final TextView messageView;
    public final TextView nameView;
    public final Space nineImageSpaceView;
    public final RainbowTextView rainbowMessageView;
    public final TextView sourceTextView;
    public final LinearLayout sourceView;
    public final TextView timeView;

    protected ItemLiveMessageBinding(Object obj, View view, int i, RoundedImageView roundedImageView, TableLayout tableLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, Space space, RainbowTextView rainbowTextView, TextView textView3, LinearLayout linearLayout3, TextView textView4) {
        super(obj, view, i);
        this.avatarView = roundedImageView;
        this.headerLayout = tableLayout;
        this.itemView = linearLayout;
        this.messageLayout = linearLayout2;
        this.messageView = textView;
        this.nameView = textView2;
        this.nineImageSpaceView = space;
        this.rainbowMessageView = rainbowTextView;
        this.sourceTextView = textView3;
        this.sourceView = linearLayout3;
        this.timeView = textView4;
    }

    public static ItemLiveMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLiveMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558808, viewGroup, z, obj);
    }

    public static ItemLiveMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveMessageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLiveMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131558808, null, false, obj);
    }

    public static ItemLiveMessageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemLiveMessageBinding bind(View view, Object obj) {
        return (ItemLiveMessageBinding) bind(obj, view, 2131558808);
    }
}
