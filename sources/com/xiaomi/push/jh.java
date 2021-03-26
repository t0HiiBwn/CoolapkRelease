package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

final class jh implements FileFilter {
    jh() {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
