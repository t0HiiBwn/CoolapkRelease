package com.coolapk.market.widget;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: PostButtonView2.kt */
final class PostButtonView2$init$4 implements View.OnLongClickListener {
    final /* synthetic */ PostButtonView2 this$0;

    PostButtonView2$init$4(PostButtonView2 postButtonView2) {
        this.this$0 = postButtonView2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        String preferencesString = DataManager.getInstance().getPreferencesString("POST_BUTTON_SETTING_LONG_CLICK_KEY", "SEARCH");
        if (preferencesString == null) {
            return false;
        }
        int hashCode = preferencesString.hashCode();
        if (hashCode != -1853007448) {
            if (hashCode != -1382453013) {
                if (hashCode != 1670098767 || !preferencesString.equals("APP_MANAGER")) {
                    return false;
                }
                ActionManager.startAppManagerActivity(this.this$0.getContext());
            } else if (!preferencesString.equals("NOTIFICATION")) {
                return false;
            } else {
                ActionManager.startNotificationActivity(this.this$0.getContext(), 0);
            }
        } else if (!preferencesString.equals("SEARCH")) {
            return false;
        } else {
            ActionManager.startSearchActivity(this.this$0.getContext());
        }
        return true;
    }
}
