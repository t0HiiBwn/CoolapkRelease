package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.LinkedList;

public class LimitQueue<E> extends LinkedList<E> {
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public LimitQueue(int i) {
        this.deduplication = false;
        this.limit = i;
    }

    public LimitQueue(int i, boolean z) {
        this.deduplication = false;
        this.limit = i;
        this.deduplication = z;
    }

    public LimitQueue(Collection<? extends E> collection, boolean z) {
        this(collection.size(), z);
        addAll(collection);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.Queue, java.util.Deque
    public boolean add(E e) {
        if (this.deduplication) {
            super.remove(e);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.add(e);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() > this.limit) {
            return false;
        }
        if (this.deduplication) {
            super.removeAll(collection);
        }
        for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
            super.poll();
        }
        return super.addAll(collection);
    }

    public int getLimit() {
        return this.limit;
    }

    @Override // java.util.LinkedList, java.util.Queue, java.util.Deque
    public boolean offer(E e) {
        if (this.deduplication) {
            super.remove(e);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.offer(e);
    }

    @Override // java.util.LinkedList, java.util.Queue, java.util.Deque
    public E poll() {
        return (E) super.poll();
    }
}
