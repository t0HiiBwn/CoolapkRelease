package com.tencent.android.tpns.mqtt.persist;

import java.io.File;
import java.io.FilenameFilter;

public class PersistanceFileNameFilter implements FilenameFilter {
    private final String fileExtension;

    public PersistanceFileNameFilter(String str) {
        this.fileExtension = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(this.fileExtension);
    }
}
