package com.coolapk.market.view.feedv8.draft;

import android.app.Application;
import com.coolapk.market.AppHolder;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: RoughDraftHelper.kt */
final class RoughDraftHelper$oldSavePath$2 extends Lambda implements Function0<File> {
    public static final RoughDraftHelper$oldSavePath$2 INSTANCE = new RoughDraftHelper$oldSavePath$2();

    RoughDraftHelper$oldSavePath$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final File invoke() {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        File file = new File(application.getCacheDir(), RoughDraftHelper.Companion.getTAG());
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, RoughDraftHelper.Companion.getTAG() + ".bin");
    }
}
