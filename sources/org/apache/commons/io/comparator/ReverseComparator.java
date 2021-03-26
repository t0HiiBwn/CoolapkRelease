package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

class ReverseComparator extends AbstractFileComparator implements Serializable {
    private static final long serialVersionUID = -4808255005272229056L;
    private final Comparator<File> delegate;

    public ReverseComparator(Comparator<File> comparator) {
        if (comparator != null) {
            this.delegate = comparator;
            return;
        }
        throw new IllegalArgumentException("Delegate comparator is missing");
    }

    public int compare(File file, File file2) {
        return this.delegate.compare(file2, file);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator, java.lang.Object
    public String toString() {
        return super.toString() + "[" + this.delegate.toString() + "]";
    }
}
