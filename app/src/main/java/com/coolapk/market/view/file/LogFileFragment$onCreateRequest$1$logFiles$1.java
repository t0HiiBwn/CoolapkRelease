package com.coolapk.market.view.file;

import com.coolapk.market.util.CoolFileUtils;
import java.io.File;
import java.io.FileFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "child", "Ljava/io/File;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 2})
/* compiled from: LogFileFragment.kt */
final class LogFileFragment$onCreateRequest$1$logFiles$1 implements FileFilter {
    public static final LogFileFragment$onCreateRequest$1$logFiles$1 INSTANCE = new LogFileFragment$onCreateRequest$1$logFiles$1();

    LogFileFragment$onCreateRequest$1$logFiles$1() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        Intrinsics.checkNotNullExpressionValue(file, "child");
        return Intrinsics.areEqual(CoolFileUtils.getFileExtension(file.getName()), "txt");
    }
}
