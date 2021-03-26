package com.coolapk.market.view.base;

import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/base/CopyActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "title", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
public class CopyActionItem extends ActionItem {
    private final String content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopyActionItem(String str, String str2) {
        super(str, null, 2, null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.content = str2;
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.coolapk.market.view.base.ActionItem
    public void takeAction() {
        StringUtils.copyText(AppHolder.getCurrentActivity(), this.content);
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Toast.show(application, 2131887190);
    }
}
