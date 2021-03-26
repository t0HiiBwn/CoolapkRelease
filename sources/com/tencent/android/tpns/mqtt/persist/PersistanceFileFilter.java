package com.tencent.android.tpns.mqtt.persist;

import java.io.File;
import java.io.FileFilter;

public class PersistanceFileFilter implements FileFilter {
    private final String fileExtension;

    public PersistanceFileFilter(String str) {
        this.fileExtension = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(this.fileExtension);
    }
}
