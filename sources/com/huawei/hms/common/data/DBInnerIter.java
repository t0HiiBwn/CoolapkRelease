package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

public class DBInnerIter<O> implements Iterator<O> {
    protected final DataBuffer<O> dataBuffer;
    protected int index = -1;

    public DBInnerIter(DataBuffer<O> dataBuffer2) {
        Preconditions.checkNotNull(dataBuffer2, "dataBuffer cannot be null");
        this.dataBuffer = dataBuffer2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index + 1 < this.dataBuffer.getCount();
    }

    @Override // java.util.Iterator
    public O next() {
        if (!hasNext()) {
            return null;
        }
        DataBuffer<O> dataBuffer2 = this.dataBuffer;
        int i = this.index + 1;
        this.index = i;
        return dataBuffer2.get(i);
    }
}
