package com.amap.api.mapcore2d;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/* compiled from: TaskPool */
class bo<T> {
    protected LinkedList<T> a = new LinkedList<>();
    protected final Semaphore b = new Semaphore(0, false);
    protected boolean c = true;

    bo() {
    }

    public void a() {
        this.c = false;
        this.b.release(100);
    }

    public synchronized void a(List<T> list, boolean z) {
        LinkedList<T> linkedList = this.a;
        if (linkedList != null) {
            if (z) {
                try {
                    linkedList.clear();
                } catch (Throwable unused) {
                }
            }
            if (list != null) {
                this.a.addAll(list);
            }
            this.b.release();
        }
    }

    public void b() {
        LinkedList<T> linkedList = this.a;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    public ArrayList<T> a(int i, boolean z) {
        LinkedList<T> linkedList = this.a;
        ArrayList<T> arrayList = null;
        if (!(linkedList == null || linkedList.size() == 0)) {
            try {
                this.b.acquire();
            } catch (InterruptedException unused) {
            }
            try {
                if (this.c) {
                    arrayList = b(i, z);
                }
            } catch (Throwable unused2) {
            }
            this.b.release();
        }
        return arrayList;
    }

    protected synchronized ArrayList<T> b(int i, boolean z) {
        LinkedList<T> linkedList = this.a;
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        if (i > size) {
            i = size;
        }
        ArrayList<T> arrayList = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.a.get(0));
            this.a.removeFirst();
        }
        return arrayList;
    }
}
