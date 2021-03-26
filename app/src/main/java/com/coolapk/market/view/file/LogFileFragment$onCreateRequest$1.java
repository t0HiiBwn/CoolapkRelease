package com.coolapk.market.view.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "kotlin.jvm.PlatformType", "it", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LogFileFragment.kt */
final class LogFileFragment$onCreateRequest$1<T, R> implements Func1<File, List<? extends File>> {
    final /* synthetic */ File $dir;

    LogFileFragment$onCreateRequest$1(File file) {
        this.$dir = file;
    }

    public final List<File> call(File file) {
        File[] listFiles = this.$dir.listFiles(LogFileFragment$onCreateRequest$1$logFiles$1.INSTANCE);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        return CollectionsKt.listOf((Object[]) ((File[]) Arrays.copyOf(listFiles, listFiles.length)));
    }
}
