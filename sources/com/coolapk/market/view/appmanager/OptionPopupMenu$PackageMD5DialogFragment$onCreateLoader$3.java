package com.coolapk.market.view.appmanager;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import com.coolapk.market.view.appmanager.OptionPopupMenu;
import java.io.File;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/appmanager/OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$3", "Landroidx/loader/content/AsyncTaskLoader;", "", "loadInBackground", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OptionPopupMenu.kt */
public final class OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$3 extends AsyncTaskLoader<String> {
    final /* synthetic */ OptionPopupMenu.PackageMD5DialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OptionPopupMenu$PackageMD5DialogFragment$onCreateLoader$3(OptionPopupMenu.PackageMD5DialogFragment packageMD5DialogFragment, Context context) {
        super(context);
        this.this$0 = packageMD5DialogFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        throw r2;
     */
    @Override // androidx.loader.content.AsyncTaskLoader
    public String loadInBackground() {
        String string = this.this$0.getString(2131886633);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_can_not_find_file)");
        String str = this.this$0.filePath;
        if (str == null || !new File(this.this$0.filePath).exists()) {
            return string;
        }
        ZipFile zipFile = new ZipFile(str);
        Throwable th = null;
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Intrinsics.checkNotNullExpressionValue(entries, "zip.entries()");
        Iterator it2 = CollectionsKt.iterator(entries);
        String str2 = "不支持";
        while (it2.hasNext()) {
            ZipEntry zipEntry = (ZipEntry) it2.next();
            Intrinsics.checkNotNullExpressionValue(zipEntry, "e");
            String name = zipEntry.getName();
            Intrinsics.checkNotNullExpressionValue(name, "e.name");
            if (!StringsKt.startsWith$default(name, "lib/arm64-v8a/", false, 2, (Object) null)) {
                String name2 = zipEntry.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "e.name");
                if (!StringsKt.startsWith$default(name2, "lib/x86_64/", false, 2, (Object) null)) {
                }
            }
            str2 = "支持";
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(zipFile, th);
        return str2;
    }
}
