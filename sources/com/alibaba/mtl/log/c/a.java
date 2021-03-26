package com.alibaba.mtl.log.c;

import java.util.List;

/* compiled from: ILogStore */
public interface a {
    /* renamed from: a */
    int mo15a(List<com.alibaba.mtl.log.model.a> list);

    List<com.alibaba.mtl.log.model.a> a(String str, int i);

    /* renamed from: a  reason: collision with other method in class */
    boolean m14a(List<com.alibaba.mtl.log.model.a> list);

    void c(String str, String str2);

    void clear();

    void e(int i);

    int g();
}
