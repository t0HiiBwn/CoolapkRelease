package com.xiaomi.push;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

final class bn implements FilenameFilter {
    bn() {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return !TextUtils.isEmpty(str) && !str.toLowerCase().endsWith(".lock");
    }
}
