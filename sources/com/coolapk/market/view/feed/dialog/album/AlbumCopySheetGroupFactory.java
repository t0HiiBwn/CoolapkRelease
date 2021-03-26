package com.coolapk.market.view.feed.dialog.album;

import android.app.Activity;
import android.app.Application;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.feed.dialog.CopyTextAction;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/album/AlbumCopySheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/Album;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/Album;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "getData", "()Lcom/coolapk/market/model/Album;", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/feed/dialog/CopyTextAction;", "title", "", "resource", "", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "wrapAsSheetGroup", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumCopySheetGroupFactory.kt */
public final class AlbumCopySheetGroupFactory implements SheetCallback {
    private final Activity activity;
    private final Album data;
    private final List<SheetDataItem> dataList = new ArrayList();

    public AlbumCopySheetGroupFactory(Album album, Activity activity2) {
        Intrinsics.checkNotNullParameter(album, "data");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.data = album;
        this.activity = activity2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Album getData() {
        return this.data;
    }

    public final SheetGroup create() {
        if (!this.dataList.isEmpty()) {
            return wrapAsSheetGroup();
        }
        insertItem(new CopyTextAction(null, false, new AlbumCopySheetGroupFactory$create$1(this), 3, null), "复制全部内容", 2131231243);
        CopyTextAction copyTextAction = new CopyTextAction(null, true, new AlbumCopySheetGroupFactory$create$2(this), 1, null);
        String string = this.activity.getString(2131886775);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.str_dialog_copy_free)");
        insertItem(copyTextAction, string, 2131231336);
        insertItem(new CopyTextAction('@' + this.data.getUserName() + ' ', false, null, 6, null), "复制用户名", 2131231247);
        return wrapAsSheetGroup();
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        String str;
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof CopyTextAction)) {
            return SheetResult.Companion.getNothing();
        }
        CopyTextAction copyTextAction = (CopyTextAction) sheetAction;
        Function0<String> textBuilder = copyTextAction.getTextBuilder();
        if (textBuilder == null || (str = textBuilder.invoke()) == null) {
            str = copyTextAction.getText();
        }
        if (copyTextAction.isCopyFree()) {
            ActionManager.startTextViewActivity(this.activity, str);
        } else {
            StringUtils.copyText(this.activity, str);
            Application application = AppHolder.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
            Toast.show(application, 2131887252);
        }
        return SheetResult.Companion.getClose();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.SecondPage, this.dataList);
    }

    private final void insertItem(CopyTextAction copyTextAction, String str, int i) {
        this.dataList.add(new SheetDataItem(copyTextAction, str, SheetDataItem.Companion.create36dpIconApplyer(i, (int) 4279734087L), this, null, 2, false, false, 208, null));
    }
}
