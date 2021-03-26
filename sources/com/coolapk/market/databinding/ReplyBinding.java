package com.coolapk.market.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.view.feed.ReplyActivity;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import com.coolapk.market.widget.view.KeyBoardLayout;

public abstract class ReplyBinding extends ViewDataBinding {
    public final FeedWarningBinding alertView;
    public final LinearLayout bottomView;
    public final CheckBox checkBox;
    public final TextView checkBoxText;
    public final LinearLayout contentView;
    public final EditText editText;
    public final EmotionPanel emotionPanel;
    public final LinearLayout fakeKeyboardView;
    public final ImageView iconView;
    public final KeyBoardLayout keyBoardInteractLayout;
    @Bindable
    protected View.OnClickListener mClick;
    @Bindable
    protected ReplyActivity.ReplyUiConfig mUiConfig;
    public final FrameLayout maskView;
    public final ImageView menuAddPhoto;
    public final ImageView menuAtItem;
    public final ImageView menuCloseKeyboard;
    public final ImageView menuEmotion;
    public final ImageView menuShareApp;
    public final ImageView menuTopicItem;
    public final RecyclerView photoListView;
    public final TextView postButton;
    public final TextView sourceTextView;
    public final LinearLayout sourceView;
    public final CoolEllipsizeTextView textView;

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setUiConfig(ReplyActivity.ReplyUiConfig replyUiConfig);

    protected ReplyBinding(Object obj, View view, int i, FeedWarningBinding feedWarningBinding, LinearLayout linearLayout, CheckBox checkBox2, TextView textView2, LinearLayout linearLayout2, EditText editText2, EmotionPanel emotionPanel2, LinearLayout linearLayout3, ImageView imageView, KeyBoardLayout keyBoardLayout, FrameLayout frameLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, RecyclerView recyclerView, TextView textView3, TextView textView4, LinearLayout linearLayout4, CoolEllipsizeTextView coolEllipsizeTextView) {
        super(obj, view, i);
        this.alertView = feedWarningBinding;
        this.bottomView = linearLayout;
        this.checkBox = checkBox2;
        this.checkBoxText = textView2;
        this.contentView = linearLayout2;
        this.editText = editText2;
        this.emotionPanel = emotionPanel2;
        this.fakeKeyboardView = linearLayout3;
        this.iconView = imageView;
        this.keyBoardInteractLayout = keyBoardLayout;
        this.maskView = frameLayout;
        this.menuAddPhoto = imageView2;
        this.menuAtItem = imageView3;
        this.menuCloseKeyboard = imageView4;
        this.menuEmotion = imageView5;
        this.menuShareApp = imageView6;
        this.menuTopicItem = imageView7;
        this.photoListView = recyclerView;
        this.postButton = textView3;
        this.sourceTextView = textView4;
        this.sourceView = linearLayout4;
        this.textView = coolEllipsizeTextView;
    }

    public ReplyActivity.ReplyUiConfig getUiConfig() {
        return this.mUiConfig;
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public static ReplyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReplyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ReplyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559123, viewGroup, z, obj);
    }

    public static ReplyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReplyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ReplyBinding) ViewDataBinding.inflateInternal(layoutInflater, 2131559123, null, false, obj);
    }

    public static ReplyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ReplyBinding bind(View view, Object obj) {
        return (ReplyBinding) bind(obj, view, 2131559123);
    }
}
