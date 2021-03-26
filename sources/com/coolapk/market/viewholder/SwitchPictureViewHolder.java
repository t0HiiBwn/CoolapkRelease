package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckedTextView;
import com.coolapk.market.databinding.ItemPictureSwitchBinding;
import com.coolapk.market.event.SwitchType;
import com.coolapk.market.util.ViewUtil;

public class SwitchPictureViewHolder extends BindingViewHolder {
    public static final String HOT = "hot";
    public static final int LAYOUT_ID = 2131558864;
    public static final String NEWEST = "newest";
    public static final String RECOMMEND = "recommend";
    public static final String SPLASH = "splash";
    public static final String TwoK = "2k";
    private ItemPictureSwitchBinding binding;
    private int checkIndex = 0;
    private String picTag;
    private String picType;

    public SwitchPictureViewHolder(View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        ItemPictureSwitchBinding itemPictureSwitchBinding = (ItemPictureSwitchBinding) getBinding();
        this.binding = itemPictureSwitchBinding;
        ViewUtil.clickListener(itemPictureSwitchBinding.click1, this);
        ViewUtil.clickListener(this.binding.click2, this);
        ViewUtil.clickListener(this.binding.click4, this);
        ViewUtil.clickListener(this.binding.click5, this);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        char c;
        SwitchType switchType = (SwitchType) obj;
        this.picType = switchType.getType();
        String currentTag = switchType.getCurrentTag();
        this.picTag = currentTag;
        if (TextUtils.isEmpty(currentTag)) {
            this.picTag = "null";
        }
        String str = this.picTag;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 957436:
                if (str.equals("生活")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1035173:
                if (str.equals("美女")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1061877:
                if (str.equals("艺术")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1071380:
                if (str.equals("萌宠")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1162456:
                if (str.equals("运动")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1238881:
                if (str.equals("风景")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3392903:
                if (str.equals("null")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 20194766:
                if (str.equals("二次元")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 23547034:
                if (str.equals("小清新")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.checkIndex = 8;
                break;
            case 1:
                this.checkIndex = 5;
                break;
            case 2:
                this.checkIndex = 9;
                break;
            case 3:
                this.checkIndex = 12;
                break;
            case 4:
                this.checkIndex = 11;
                break;
            case 5:
                this.checkIndex = 6;
                break;
            case 6:
                String str2 = this.picType;
                str2.hashCode();
                switch (str2.hashCode()) {
                    case -1048839194:
                        if (str2.equals("newest")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -895866265:
                        if (str2.equals("splash")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1657:
                        if (str2.equals("2k")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 103501:
                        if (str2.equals("hot")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 989204668:
                        if (str2.equals("recommend")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        this.checkIndex = 3;
                        break;
                    case 1:
                        this.checkIndex = 2;
                        break;
                    case 2:
                        this.checkIndex = 4;
                        break;
                    case 3:
                        this.checkIndex = 1;
                        break;
                    case 4:
                        this.checkIndex = 0;
                        break;
                }
            case 7:
                this.checkIndex = 7;
                break;
            case '\b':
                this.checkIndex = 10;
                break;
        }
        updataChekState();
    }

    private void updataChekState() {
        boolean z = false;
        this.binding.textView1.setChecked(this.checkIndex == 0);
        this.binding.textView2.setChecked(this.checkIndex == 1);
        this.binding.textView4.setChecked(this.checkIndex == 3);
        CheckedTextView checkedTextView = this.binding.textView5;
        if (this.checkIndex == 4) {
            z = true;
        }
        checkedTextView.setChecked(z);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        this.binding.textView1.setChecked(view == this.binding.click1);
        this.binding.textView2.setChecked(view == this.binding.click2);
        this.binding.textView4.setChecked(view == this.binding.click4);
        CheckedTextView checkedTextView = this.binding.textView5;
        if (view != this.binding.click5) {
            z = false;
        }
        checkedTextView.setChecked(z);
        super.onClick(view);
    }
}
