package com.alibaba.baichuan.android.trade.b;

import android.content.Context;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ResourceUtils;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a {
    private static Map<Integer, C0010a> a = new HashMap();
    private static ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final C0010a c;
    private static final C0010a d;
    private static volatile C0010a e;
    private static volatile C0010a f;
    private static final Object g = new Object();

    /* renamed from: com.alibaba.baichuan.android.trade.b.a$a  reason: collision with other inner class name */
    public static class C0010a implements Cloneable {
        public int a;
        public String b;
        public String c;
        public String d;

        public static C0010a a(int i, Object... objArr) {
            return a.a(i, objArr);
        }

        @Override // java.lang.Object
        public Object clone() {
            return super.clone();
        }
    }

    static {
        C0010a aVar = new C0010a();
        c = aVar;
        aVar.a = 1;
        aVar.c = "未在消息文件中找到 id 为 {0} 的消息";
        aVar.d = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        aVar.b = "E";
        C0010a aVar2 = new C0010a();
        d = aVar2;
        aVar2.a = 2;
        aVar2.c = "检索消息时发生如下错误 {0}";
        aVar2.d = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        aVar2.b = "E";
    }

    private static C0010a a(int i) {
        if (e == null) {
            synchronized (g) {
                if (e == null) {
                    e = b(1);
                    if (e == null) {
                        e = c;
                    }
                }
            }
        }
        try {
            C0010a aVar = (C0010a) e.clone();
            aVar.c = MessageFormat.format(aVar.c, String.valueOf(i));
            return aVar;
        } catch (CloneNotSupportedException unused) {
            return e;
        }
    }

    public static C0010a a(int i, Object... objArr) {
        try {
            b.readLock().lock();
            C0010a aVar = a.get(Integer.valueOf(i));
            if (aVar == null) {
                b.readLock().unlock();
                b.writeLock().lock();
                try {
                    aVar = b(i);
                    if (aVar != null) {
                        a.put(Integer.valueOf(i), aVar);
                    }
                    b.readLock().lock();
                } finally {
                    b.writeLock().unlock();
                }
            }
            if (aVar == null) {
                try {
                    return a(i);
                } finally {
                    b.readLock().unlock();
                }
            } else if (objArr.length == 0) {
                b.readLock().unlock();
                return aVar;
            } else {
                C0010a aVar2 = (C0010a) aVar.clone();
                aVar2.c = MessageFormat.format(aVar2.c, objArr);
                b.readLock().unlock();
                return aVar2;
            }
        } catch (Exception e2) {
            AlibcLogger.e("AlibcMessageUtils", e2.toString());
            return a(e2.getMessage());
        }
    }

    private static C0010a a(String str) {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    f = b(2);
                    if (f == null) {
                        f = d;
                    }
                }
            }
        }
        try {
            C0010a aVar = (C0010a) f.clone();
            aVar.c = MessageFormat.format(aVar.c, str);
            return aVar;
        } catch (CloneNotSupportedException unused) {
            return f;
        }
    }

    private static C0010a b(int i) {
        try {
            Context context = AlibcContext.context;
            int identifier = ResourceUtils.getIdentifier(context, "string", "alisdk_message_" + i + "_message");
            if (identifier == 0) {
                return null;
            }
            C0010a aVar = new C0010a();
            aVar.a = i;
            aVar.c = AlibcContext.context.getResources().getString(identifier);
            Context context2 = AlibcContext.context;
            int identifier2 = ResourceUtils.getIdentifier(context2, "string", "alisdk_message_" + i + "_action");
            aVar.d = identifier2 != 0 ? AlibcContext.context.getResources().getString(identifier2) : "";
            Context context3 = AlibcContext.context;
            int identifier3 = ResourceUtils.getIdentifier(context3, "string", "alisdk_message_" + i + "_type");
            aVar.b = identifier3 != 0 ? AlibcContext.context.getResources().getString(identifier3) : "I";
            return aVar;
        } catch (Exception e2) {
            AlibcLogger.e("kernel", "Fail to get message of the code " + i + ", the error message is " + e2.getMessage());
            return null;
        }
    }
}
