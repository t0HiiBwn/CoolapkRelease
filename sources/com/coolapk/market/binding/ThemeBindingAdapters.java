package com.coolapk.market.binding;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class ThemeBindingAdapters {
    public static void setEditTextTint(TextInputLayout textInputLayout, String str) {
    }

    public static void setTextColor(TextView textView, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            textView.setTextColor(themeColor);
        }
    }

    public static void setTabIndicatorColor(TabLayout tabLayout, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            tabLayout.setSelectedTabIndicatorColor(themeColor);
        }
    }

    public static void setEditTextTint(EditText editText, String str) {
        TintHelper.setTint(editText, getThemeColor(str), AppHolder.getAppTheme().isDarkTheme());
    }

    public static void setTabSelectedTextColor(TabLayout tabLayout, String str, String str2) {
        int themeColor = getThemeColor(str);
        int themeColor2 = getThemeColor(str2);
        if (themeColor != 0 && themeColor2 != 0) {
            tabLayout.setTabTextColors(themeColor, themeColor2);
        }
    }

    public static void setBackgroundColor(View view, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            view.setBackgroundColor(themeColor);
        }
    }

    public static void setTintColor(ImageView imageView, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            imageView.setColorFilter(themeColor);
        }
    }

    public static void setBackgroundTint(View view, String str) {
        Drawable background;
        int themeColor = getThemeColor(str);
        if (themeColor != 0 && (background = view.getBackground()) != null) {
            background.setColorFilter(themeColor, PorterDuff.Mode.SRC_IN);
            view.setBackground(background);
        }
    }

    public static void setIndeterminateTint(ProgressBar progressBar, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(themeColor));
        }
    }

    public static void setProgressTintList(ProgressBar progressBar, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(themeColor));
        }
    }

    public static void setTint(CheckBox checkBox, String str) {
        TintHelper.setTint(checkBox, getThemeColor(str), AppHolder.getAppTheme().isDarkTheme());
    }

    public static void setSecondaryProgressTint(ProgressBar progressBar, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(themeColor));
        }
    }

    public static void setTabLayoutIndicatorColor(TabLayout tabLayout, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            tabLayout.setSelectedTabIndicatorColor(themeColor);
        }
    }

    public static void setBackgroundTint(FloatingActionButton floatingActionButton, String str) {
        int themeColor = getThemeColor(str);
        if (themeColor != 0) {
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(themeColor));
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getThemeColor(String str) {
        char c;
        AppTheme appTheme = AppHolder.getAppTheme();
        str.hashCode();
        switch (str.hashCode()) {
            case -2102088395:
                if (str.equals("colorPrimaryDark")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1422808857:
                if (str.equals("currencyColorDivider")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1296639716:
                if (str.equals("contentBackgroundColor")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1283905636:
                if (str.equals("accent_red")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1182619523:
                if (str.equals("mainTextColor")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1102250018:
                if (str.equals("textColorSecondary")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1027680271:
                if (str.equals("contentBackgroundDividerColor")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -403207561:
                if (str.equals("colorControlActivated")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 112785:
                if (str.equals("red")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 113101865:
                if (str.equals("white")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 221609330:
                if (str.equals("textColorSecondaryInverse")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 450722317:
                if (str.equals("colorAccent")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 453652204:
                if (str.equals("textColorPrimary")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 544628700:
                if (str.equals("mainBackgroundColor")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 907911852:
                if (str.equals("red_second_hand")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 1171326120:
                if (str.equals("textColorTertiary")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1466294948:
                if (str.equals("textColorPrimaryInverse")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1950347551:
                if (str.equals("colorPrimary")) {
                    c = 17;
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
                return appTheme.getColorPrimaryDark();
            case 1:
                return appTheme.getCurrencyColorDivider();
            case 2:
                return appTheme.getContentBackgroundColor();
            case 3:
                return ResourceUtils.getColorInt(AppHolder.getApplication(), 2131099688);
            case 4:
                return appTheme.getMainTextColor();
            case 5:
                return appTheme.getTextColorSecondary();
            case 6:
                return appTheme.getContentBackgroundDividerColor();
            case 7:
                return appTheme.getColorControlActivated();
            case '\b':
                return -65536;
            case '\t':
                return -1;
            case '\n':
                return appTheme.getTextColorSecondaryInverse();
            case 11:
                return appTheme.getColorAccent();
            case '\f':
                return appTheme.getTextColorPrimary();
            case '\r':
                return appTheme.getMainBackgroundColor();
            case 14:
                return Color.parseColor("#F44336");
            case 15:
                return appTheme.getTextColorTertiary();
            case 16:
                return appTheme.getTextColorPrimaryInverse();
            case 17:
                return appTheme.getColorPrimary();
            default:
                return 0;
        }
    }
}
