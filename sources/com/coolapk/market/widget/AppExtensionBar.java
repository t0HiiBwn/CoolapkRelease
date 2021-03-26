package com.coolapk.market.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import com.blankj.utilcode.util.ToastUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.MenuCard;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import java.util.List;

public class AppExtensionBar extends LinearLayout {
    private Callback callback;
    private ServiceApp serviceApp;

    public interface Callback {
        void onCommentClick(View view);

        String onCreateMenuTitle(View view, MenuCard menuCard);

        void onMenuClick(View view, MenuCard menuCard);

        void onPostClick(View view);
    }

    public AppExtensionBar(Context context) {
        this(context, null);
    }

    public AppExtensionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void updateUIV2() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        ServiceApp serviceApp2 = this.serviceApp;
        if (!(serviceApp2 == null || serviceApp2.getMenuCards() == null)) {
            List<MenuCard> menuCards = this.serviceApp.getMenuCards();
            LayoutInflater from = LayoutInflater.from(getContext());
            View inflate = from.inflate(2131558460, (ViewGroup) this, false);
            ((ImageView) inflate.findViewById(2131362672)).setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
            addView(inflate, new LinearLayout.LayoutParams(-2, -2));
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.coolapk.market.widget.AppExtensionBar.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AppExtensionBar.this.callback != null) {
                        AppExtensionBar.this.callback.onPostClick(view);
                    }
                }
            });
            for (final MenuCard menuCard : menuCards) {
                final View inflate2 = from.inflate(2131558459, (ViewGroup) this, false);
                ((TextView) inflate2.findViewById(2131363582)).setText(getMenuTitle(inflate2, menuCard));
                addView(inflate2, new LinearLayout.LayoutParams(0, -2, 1.0f));
                int i = 8;
                inflate2.findViewById(2131362929).setVisibility(menuCard.hasChildItem() ? 0 : 8);
                TextView textView = (TextView) inflate2.findViewById(2131363437);
                if (menuCard.hasSubTitle()) {
                    i = 0;
                }
                textView.setVisibility(i);
                textView.setText(menuCard.getSubTitle());
                textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
                UiUtils.setDrawableStrokeColors(textView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
                inflate2.setOnClickListener(new View.OnClickListener() {
                    /* class com.coolapk.market.widget.AppExtensionBar.AnonymousClass2 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (menuCard.hasChildItem()) {
                            BasePopMenu basePopMenu = new BasePopMenu(AppExtensionBar.this.getContext(), inflate2);
                            for (MenuCard menuCard : menuCard.getEntities()) {
                                basePopMenu.getMenu().add(AppExtensionBar.this.getMenuTitle(inflate2, menuCard));
                            }
                            basePopMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                /* class com.coolapk.market.widget.AppExtensionBar.AnonymousClass2.AnonymousClass1 */

                                @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    for (MenuCard menuCard : menuCard.getEntities()) {
                                        if (TextUtils.equals(AppExtensionBar.this.getMenuTitle(inflate2, menuCard), menuItem.getTitle())) {
                                            AppExtensionBar.this.callback.onMenuClick(inflate2, menuCard);
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                            });
                            basePopMenu.show();
                        } else if (AppExtensionBar.this.callback != null) {
                            AppExtensionBar.this.callback.onMenuClick(view, menuCard);
                        }
                    }
                });
            }
            setShowDividers(2);
            setDividerDrawable(ResourceUtils.getDrawable(getContext(), 2131231059));
            setDividerPadding(DisplayUtils.dp2px(getContext(), 12.0f));
        }
    }

    public void updateUIV3() {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        ServiceApp serviceApp2 = this.serviceApp;
        if (!(serviceApp2 == null || serviceApp2.getMenuCards() == null)) {
            List<MenuCard> menuCards = this.serviceApp.getMenuCards();
            LayoutInflater from = LayoutInflater.from(getContext());
            View root = DataBindingUtil.inflate(from, 2131558458, this, false).getRoot();
            addView(root, new LinearLayout.LayoutParams(-1, -2));
            ((TextView) root.findViewById(2131362286)).setText(this.serviceApp.getCommentCount());
            root.findViewById(2131362284).setOnClickListener(new View.OnClickListener() {
                /* class com.coolapk.market.widget.AppExtensionBar.AnonymousClass3 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AppExtensionBar.this.serviceApp.getCommentStatus() == -1) {
                        ToastUtils.showShort("此应用禁止评论");
                    } else if (AppExtensionBar.this.callback != null) {
                        AppExtensionBar.this.callback.onPostClick(view);
                    }
                }
            });
            root.findViewById(2131362291).setOnClickListener(new View.OnClickListener() {
                /* class com.coolapk.market.widget.AppExtensionBar.AnonymousClass4 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AppExtensionBar.this.callback != null) {
                        AppExtensionBar.this.callback.onCommentClick(view);
                    }
                }
            });
            ViewGroup viewGroup = (ViewGroup) root.findViewById(2131362482);
            TextView textView = (TextView) root.findViewById(2131362290);
            if (this.serviceApp.getCommentStatus() != -1) {
                textView.setText(2131886161);
            } else {
                textView.setText("此应用禁止评论");
            }
            for (final MenuCard menuCard : menuCards) {
                final View inflate = from.inflate(2131558459, (ViewGroup) this, false);
                ((TextView) inflate.findViewById(2131363582)).setText(getMenuTitle(inflate, menuCard));
                viewGroup.addView(inflate, new LinearLayout.LayoutParams(-2, -1));
                ImageView imageView = (ImageView) inflate.findViewById(2131362929);
                int i = 8;
                imageView.setVisibility(menuCard.hasChildItem() ? 0 : 8);
                imageView.setImageResource(TextUtils.equals(menuCard.getTitle(), "开发者") ? 2131231149 : 2131231423);
                TextView textView2 = (TextView) inflate.findViewById(2131363437);
                if (menuCard.hasSubTitle()) {
                    i = 0;
                }
                textView2.setVisibility(i);
                textView2.setText(menuCard.getSubTitle());
                textView2.setTextColor(AppHolder.getAppTheme().getColorAccent());
                UiUtils.setDrawableStrokeColors(textView2.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
                inflate.setOnClickListener(new View.OnClickListener() {
                    /* class com.coolapk.market.widget.AppExtensionBar.AnonymousClass5 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (menuCard.hasChildItem()) {
                            BasePopMenu basePopMenu = new BasePopMenu(AppExtensionBar.this.getContext(), inflate);
                            for (MenuCard menuCard : menuCard.getEntities()) {
                                basePopMenu.getMenu().add(AppExtensionBar.this.getMenuTitle(inflate, menuCard));
                            }
                            basePopMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                /* class com.coolapk.market.widget.AppExtensionBar.AnonymousClass5.AnonymousClass1 */

                                @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    for (MenuCard menuCard : menuCard.getEntities()) {
                                        if (TextUtils.equals(AppExtensionBar.this.getMenuTitle(inflate, menuCard), menuItem.getTitle())) {
                                            AppExtensionBar.this.callback.onMenuClick(inflate, menuCard);
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                            });
                            basePopMenu.show();
                        } else if (AppExtensionBar.this.callback != null) {
                            AppExtensionBar.this.callback.onMenuClick(view, menuCard);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public String getMenuTitle(View view, MenuCard menuCard) {
        Callback callback2 = this.callback;
        String onCreateMenuTitle = callback2 != null ? callback2.onCreateMenuTitle(view, menuCard) : null;
        return onCreateMenuTitle == null ? menuCard.getTitle() : onCreateMenuTitle;
    }

    public void setServiceApp(ServiceApp serviceApp2) {
        this.serviceApp = serviceApp2;
        updateUIV3();
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }
}
