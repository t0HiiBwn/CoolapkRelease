package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrFileFilter extends AbstractFileFilter implements ConditionalFileFilter, Serializable {
    private static final long serialVersionUID = 5767770777065432721L;
    private final List<IOFileFilter> fileFilters;

    public OrFileFilter() {
        this.fileFilters = new ArrayList();
    }

    public OrFileFilter(List<IOFileFilter> list) {
        if (list == null) {
            this.fileFilters = new ArrayList();
        } else {
            this.fileFilters = new ArrayList(list);
        }
    }

    public OrFileFilter(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        if (iOFileFilter == null || iOFileFilter2 == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        this.fileFilters = new ArrayList(2);
        addFileFilter(iOFileFilter);
        addFileFilter(iOFileFilter2);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public void addFileFilter(IOFileFilter iOFileFilter) {
        this.fileFilters.add(iOFileFilter);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public boolean removeFileFilter(IOFileFilter iOFileFilter) {
        return this.fileFilters.remove(iOFileFilter);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public void setFileFilters(List<IOFileFilter> list) {
        this.fileFilters.clear();
        this.fileFilters.addAll(list);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        for (IOFileFilter iOFileFilter : this.fileFilters) {
            if (iOFileFilter.accept(file)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        for (IOFileFilter iOFileFilter : this.fileFilters) {
            if (iOFileFilter.accept(file, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, java.lang.Object
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.fileFilters != null) {
            for (int i = 0; i < this.fileFilters.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                IOFileFilter iOFileFilter = this.fileFilters.get(i);
                if (iOFileFilter == null) {
                    str = "null";
                } else {
                    str = iOFileFilter.toString();
                }
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
