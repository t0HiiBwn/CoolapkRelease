package com.bytedance.tea.crash.g;

import android.os.Build;
import android.os.Debug;

/* compiled from: DebugMemInfoCompat */
public class b {
    static final a a;

    /* compiled from: DebugMemInfoCompat */
    private static class a {
        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private a() {
        }
    }

    /* renamed from: com.bytedance.tea.crash.g.b$b  reason: collision with other inner class name */
    /* compiled from: DebugMemInfoCompat */
    private static class C0069b extends a {
        private C0069b() {
            super();
        }

        @Override // com.bytedance.tea.crash.g.b.a
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.bytedance.tea.crash.g.b.a
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.bytedance.tea.crash.g.b.a
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new C0069b();
        } else {
            a = new a();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return a.c(memoryInfo);
    }
}
