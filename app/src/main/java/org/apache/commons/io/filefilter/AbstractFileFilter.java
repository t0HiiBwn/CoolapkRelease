package org.apache.commons.io.filefilter;

import java.io.File;

public abstract class AbstractFileFilter implements IOFileFilter {
    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return accept(file.getParentFile(), file.getName());
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return accept(new File(file, str));
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName();
    }
}
