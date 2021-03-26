package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bp;
import java.io.Serializable;

/* compiled from: TBase */
public interface bi<T extends bi<?, ?>, F extends bp> extends Serializable {
    void clear();

    bi<T, F> deepCopy();

    F fieldForId(int i);

    void read(ch chVar) throws bo;

    void write(ch chVar) throws bo;
}
