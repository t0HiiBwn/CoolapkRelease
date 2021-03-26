package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

final class z implements FileFilter {
    z() {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
