package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.widget.RadioGroupPlus;
import com.meg7.widget.SvgImageView;

public abstract class PostButtonSettingBinding extends ViewDataBinding {
    public final ImageView airplaneBackgroundView;
    public final LinearLayout airplaneLayout;
    public final ImageView coolapkBackgroundView;
    public final LinearLayout coolapkLayout;
    public final SvgImageView customButtonImage;
    public final ImageView customButtonImagePlaceholder;
    public final LinearLayout customLayout;
    public final LinearLayout longClickAppManager;
    public final LinearLayout longClickEmpty;
    public final LinearLayout longClickNotification;
    public final LinearLayout longClickSearch;
    public final ImageView plusBackgroundView;
    public final LinearLayout plusLayout;
    public final RadioButton radioAirplane;
    public final RadioButton radioAppManager;
    public final RadioButton radioCoolapk;
    public final RadioButton radioCustom;
    public final RadioButton radioEmpty;
    public final RadioGroupPlus radioGroup;
    public final RadioGroupPlus radioGroupLongClick;
    public final RadioButton radioNotification;
    public final RadioButton radioPlus;
    public final RadioButton radioSearch;

    protected PostButtonSettingBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, LinearLayout linearLayout2, SvgImageView svgImageView, ImageView imageView3, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, ImageView imageView4, LinearLayout linearLayout8, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioGroupPlus radioGroupPlus, RadioGroupPlus radioGroupPlus2, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8) {
        super(obj, view, i);
        this.airplaneBackgroundView = imageView;
        this.airplaneLayout = linearLayout;
        this.coolapkBackgroundView = imageView2;
        this.coolapkLayout = linearLayout2;
        this.customButtonImage = svgImageView;
        this.customButtonImagePlaceholder = imageView3;
        this.customLayout = linearLayout3;
        this.longClickAppManager = linearLayout4;
        this.longClickEmpty = linearLayout5;
        this.longClickNotification = linearLayout6;
        this.longClickSearch = linearLayout7;
        this.plusBackgroundView = imageView4;
        this.plusLayout = linearLayout8;
        this.radioAirplane = radioButton;
        this.radioAppManager = radioButton2;
        this.radioCoolapk = radioButton3;
        this.radioCustom = radioButton4;
        this.radioEmpty = radioButton5;
        this.radioGroup = radioGroupPlus;
        this.radioGroupLongClick = radioGroupPlus2;
        this.radioNotification = radioButton6;
        this.radioPlus = radioButton7;
        this.radioSearch = radioButton8;
    }

    public static PostButtonSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostButtonSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PostButtonSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559089, viewGroup, z, obj);
    }

    public static PostButtonSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostButtonSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PostButtonSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559089, null, false, obj);
    }

    public static PostButtonSettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostButtonSettingBinding bind(View view, Object obj) {
        return (PostButtonSettingBinding) bind(obj, view, 2131559089);
    }
}
