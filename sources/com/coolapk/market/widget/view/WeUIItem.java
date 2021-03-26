package com.coolapk.market.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.R;
import com.coolapk.market.databinding.ItemWeuiBinding;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ViewUtil;
import rx.functions.Action1;

public class WeUIItem extends LinearLayout implements View.OnClickListener {
    private String actionText;
    private ItemWeuiBinding binding;
    private boolean canEdit;
    private String contentText;
    private String editType;
    private String endImg;
    private String hint;
    private Action1<String> listener;
    private String title;

    public WeUIItem(Context context) {
        super(context);
    }

    public WeUIItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public WeUIItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.WeUIItem);
        this.canEdit = obtainAttributes.getBoolean(1, false);
        boolean z = obtainAttributes.getBoolean(3, false);
        boolean z2 = obtainAttributes.getBoolean(4, false);
        int resourceId = obtainAttributes.getResourceId(7, 0);
        int resourceId2 = obtainAttributes.getResourceId(6, 0);
        String string = obtainAttributes.getString(9);
        int i = 8;
        String string2 = obtainAttributes.getString(8);
        String string3 = obtainAttributes.getString(5);
        String string4 = obtainAttributes.getString(0);
        String string5 = obtainAttributes.getString(2);
        obtainAttributes.recycle();
        ItemWeuiBinding itemWeuiBinding = (ItemWeuiBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558992, this, true);
        this.binding = itemWeuiBinding;
        itemWeuiBinding.startImg.setImageResource(resourceId);
        this.binding.endImg.setImageResource(resourceId2);
        this.binding.editText.setVisibility(this.canEdit ? 0 : 8);
        this.binding.textView.setVisibility(this.canEdit ? 8 : 0);
        this.binding.endImg.setVisibility((z || resourceId2 != 0) ? 0 : 8);
        ImageView imageView = this.binding.startImg;
        if (z2 || resourceId != 0) {
            i = 0;
        }
        imageView.setVisibility(i);
        TextView textView = this.binding.textView;
        if (TextUtils.isEmpty(string2)) {
            string2 = "";
        }
        textView.setText(string2);
        TextView textView2 = this.binding.titleText;
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        textView2.setText(string);
        EditText editText = this.binding.editText;
        if (TextUtils.isEmpty(string3)) {
            string3 = "";
        }
        editText.setHint(string3);
        if (!TextUtils.isEmpty(getActionText())) {
            this.binding.actionTextView.setText(string4);
            this.binding.actionTextView.setTextColor(AppHolder.getAppTheme().getColorAccent());
            this.binding.actionTextView.setVisibility(0);
            ViewUtil.clickListener(this.binding.actionTextView, this);
        }
        if (z) {
            ViewUtil.clickListener(this.binding.endImg, this);
        }
        setEditType(string5);
    }

    public void setEditType(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.editType = str;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1309787586:
                    if (str.equals("PHONE_CODE")) {
                        c = 0;
                        break;
                    }
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c = 1;
                        break;
                    }
                    break;
                case 76105038:
                    if (str.equals("PHONE")) {
                        c = 2;
                        break;
                    }
                    break;
                case 116920585:
                    if (str.equals("IMG_CODE")) {
                        c = 3;
                        break;
                    }
                    break;
                case 516913366:
                    if (str.equals("USERNAME")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1675813750:
                    if (str.equals("COUNTRY")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1832835280:
                    if (str.equals("EMAIL_CODE")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setActionText(getContext().getString(2131886979));
                    setTitle(getContext().getString(2131886988));
                    setHint(getContext().getString(2131886843));
                    TextView textView = this.binding.titleText;
                    textView.getLayoutParams().width = DisplayUtils.dp2px(getContext(), 81.0f);
                    textView.requestLayout();
                    return;
                case 1:
                    setTitle(getContext().getString(2131887019));
                    setHint(getContext().getString(2131886838));
                    return;
                case 2:
                    setTitle("+86");
                    setHint(getContext().getString(2131886841));
                    this.binding.editText.setInputType(2);
                    TextView textView2 = this.binding.titleText;
                    textView2.getLayoutParams().width = DisplayUtils.dp2px(getContext(), 81.0f);
                    textView2.requestLayout();
                    textView2.setGravity(5);
                    textView2.setPadding(0, DisplayUtils.dp2px(getContext(), 12.0f), DisplayUtils.dp2px(getContext(), 4.0f), DisplayUtils.dp2px(getContext(), 12.0f));
                    return;
                case 3:
                    setTitle(getContext().getString(2131886857));
                    setHint(getContext().getString(2131886840));
                    TextView textView3 = this.binding.titleText;
                    textView3.getLayoutParams().width = DisplayUtils.dp2px(getContext(), 81.0f);
                    textView3.requestLayout();
                    return;
                case 4:
                    setTitle(getContext().getString(2131887028));
                    setHint(getContext().getString(2131886844));
                    return;
                case 5:
                    setTitle(getContext().getString(2131886688));
                    TextView textView4 = this.binding.titleText;
                    ((LinearLayout.LayoutParams) textView4.getLayoutParams()).width = DisplayUtils.dp2px(getContext(), 81.0f);
                    textView4.requestLayout();
                    textView4.setGravity(5);
                    textView4.setPadding(0, DisplayUtils.dp2px(getContext(), 12.0f), DisplayUtils.dp2px(getContext(), 4.0f), DisplayUtils.dp2px(getContext(), 12.0f));
                    setActionText("中国 China");
                    return;
                case 6:
                    setTitle(getContext().getString(2131887020));
                    setHint(getContext().getString(2131886839));
                    setActionText(getContext().getString(2131886979));
                    return;
                default:
                    return;
            }
        }
    }

    public void setActionText(String str) {
        this.actionText = str;
        if (!TextUtils.isEmpty(getActionText())) {
            this.binding.actionTextView.setText(str);
            this.binding.actionTextView.setTextColor(AppHolder.getAppTheme().getColorAccent());
            this.binding.actionTextView.setVisibility(0);
            ViewUtil.clickListener(this.binding.actionTextView, this);
        }
    }

    public String getActionText() {
        return this.actionText;
    }

    public void setHint(String str) {
        this.hint = str;
        EditText editText = this.binding.editText;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        editText.setHint(str);
    }

    public void setTitle(String str) {
        this.title = str;
        TextView textView = this.binding.titleText;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        textView.setText(str);
    }

    public void setEndImg(String str) {
        this.endImg = str;
        this.binding.setImg(str);
    }

    public void setContent(String str) {
        this.contentText = str;
        this.binding.textView.setText(!TextUtils.isEmpty(str) ? str : "");
        this.binding.textView.setVisibility(!TextUtils.isEmpty(str) ? 0 : 8);
    }

    public void setListener(Action1<String> action1) {
        this.listener = action1;
    }

    public String getText() {
        return this.canEdit ? this.binding.editText.getText().toString() : this.binding.textView.getText().toString();
    }

    public View getViewById(int i) {
        switch (i) {
            case 2131361977:
                return this.binding.actionTextView;
            case 2131362441:
                return this.binding.editText;
            case 2131362459:
                return this.binding.endImg;
            case 2131363420:
                return this.binding.startImg;
            case 2131363581:
                return this.binding.titleText;
            default:
                return null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Action1<String> action1;
        int id = view.getId();
        if (id == 2131361977) {
            Action1<String> action12 = this.listener;
            if (action12 != null) {
                action12.call(getText());
            }
        } else if (id == 2131362459 && (action1 = this.listener) != null) {
            action1.call(getText());
        }
    }
}
