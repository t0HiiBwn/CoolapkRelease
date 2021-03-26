package com.coolapk.market.view.message;

import android.text.TextUtils;
import android.text.style.URLSpan;
import com.coolapk.market.model.Message;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.CopyActionItem;
import com.coolapk.market.view.message.ChattingItemDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingItemDialog.kt */
final class ChattingItemDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ ChattingItemDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChattingItemDialog$onActivityCreated$1(ChattingItemDialog chattingItemDialog) {
        super(1);
        this.this$0 = chattingItemDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Message message = this.this$0.message;
        if (message != null) {
            if (TextUtils.equals("messageListItem", message.getEntityTemplate())) {
                list.add(new ChattingItemDialog.ChatAddTopActionItem(this.this$0, message));
                list.add(new ChattingItemDialog.DeleteChatActionItem(this.this$0, message));
            } else {
                if (TextUtils.isEmpty(message.getMessagePic())) {
                    String message2 = message.getMessage();
                    String string = this.this$0.getString(2131886712);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_dialog_copy_content)");
                    Intrinsics.checkNotNullExpressionValue(message2, "content");
                    list.add(new CopyActionItem(string, LinkTextUtils.reconvert(message2)));
                }
                list.add(new ChattingItemDialog.DeleteActionItem(this.this$0, message));
            }
        }
        if (this.this$0.spans != null) {
            URLSpan[] uRLSpanArr = this.this$0.spans;
            Intrinsics.checkNotNull(uRLSpanArr);
            int length = uRLSpanArr.length;
            for (int i = 0; i < length; i++) {
                URLSpan[] uRLSpanArr2 = this.this$0.spans;
                Intrinsics.checkNotNull(uRLSpanArr2);
                String url = uRLSpanArr2[i].getURL();
                Intrinsics.checkNotNullExpressionValue(url, "url");
                if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
                    String string2 = this.this$0.getString(2131886714, url);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_dialog_copy_something, url)");
                    list.add(new CopyActionItem(string2, url));
                }
            }
        }
    }
}
