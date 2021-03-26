package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.a.a;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: RecordDAO */
public final class l {
    public static int a(Context context, String str) {
        b.b("[db] start", new Object[0]);
        if (context != null) {
            return com.tencent.beacon.core.a.a.b.b(context, str, new int[]{1, 2, 3, 4});
        }
        b.d("[db] context is null.", new Object[0]);
        return -1;
    }

    public static Long[] a(Context context, String str, List<RDBean> list) {
        int i;
        int i2;
        int i3 = 0;
        b.b("[db] start", new Object[0]);
        if (context == null || list == null) {
            b.d("[db] have null args!", new Object[0]);
            return null;
        }
        int size = list.size();
        if (size == 0) {
            b.d("[db] insert list size(0) return.", new Object[0]);
            return null;
        }
        Long[] lArr = new Long[size];
        ArrayList<a> arrayList = new ArrayList();
        for (int i4 = 0; i4 < size; i4++) {
            RDBean rDBean = list.get(i4);
            if (rDBean == null) {
                b.c("[db] bean is null!", new Object[0]);
            } else {
                if (rDBean.getTP().equals("UA")) {
                    i2 = 1;
                    i = 3;
                } else {
                    if (rDBean.getTP().equals("IP")) {
                        i2 = 2;
                    } else if (rDBean.getTP().equals("DN")) {
                        i2 = 3;
                    } else if (rDBean.getTP().equals("HO")) {
                        i2 = 4;
                    } else {
                        b.c("[db] bean's type is error!", new Object[0]);
                    }
                    i = 0;
                }
                try {
                    arrayList.add(new a(i2, i, rDBean.getTM(), h.a(rDBean)));
                } catch (Throwable th) {
                    b.a(th);
                }
            }
        }
        if (!com.tencent.beacon.core.a.a.b.a(context, str, arrayList)) {
            return null;
        }
        for (a aVar : arrayList) {
            if (i3 < size) {
                lArr[i3] = Long.valueOf(aVar.a);
            }
            i3++;
        }
        return lArr;
    }

    public static List<RDBean> a(Context context, String str, int i) {
        b.b("[db] start", new Object[0]);
        ArrayList arrayList = null;
        if (context == null) {
            b.d("[db] have null args!", new Object[0]);
            return null;
        }
        List<a> a = com.tencent.beacon.core.a.a.b.a(context, str, new int[]{1, 2, 3, 4}, i);
        if (a != null && a.size() > 0) {
            arrayList = new ArrayList();
            Iterator<a> it2 = a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                try {
                    Object a2 = h.a(next.e);
                    if (a2 != null && RDBean.class.isInstance(a2)) {
                        RDBean rDBean = (RDBean) RDBean.class.cast(a2);
                        rDBean.setCid(next.a);
                        arrayList.add(rDBean);
                        it2.remove();
                    }
                } catch (Throwable th) {
                    b.a(th);
                    b.d("[db] query have error!", new Object[0]);
                }
            }
            if (a.size() > 0) {
                b.c("[db] there are error data ,should be remove " + a.size(), new Object[0]);
                Long[] lArr = new Long[a.size()];
                for (int i2 = 0; i2 < a.size(); i2++) {
                    lArr[i2] = Long.valueOf(a.get(i2).a);
                }
                com.tencent.beacon.core.a.a.b.a(context, str, lArr);
            }
            b.b("[db] end", new Object[0]);
        }
        return arrayList;
    }

    public static int a(Context context, String str, Long[] lArr) {
        b.b("[db] start", new Object[0]);
        if (context == null) {
            b.d("[db] have null args!", new Object[0]);
            return -1;
        }
        b.b("[db] end", new Object[0]);
        return com.tencent.beacon.core.a.a.b.a(context, str, lArr);
    }
}
