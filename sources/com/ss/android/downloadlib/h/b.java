package com.ss.android.downloadlib.h;

import android.os.AsyncTask;

/* compiled from: AsyncTaskUtils */
public class b {
    static final a a = new C0098b();

    /* compiled from: AsyncTaskUtils */
    private static class a {
        private a() {
        }

        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.h.b$b  reason: collision with other inner class name */
    /* compiled from: AsyncTaskUtils */
    private static class C0098b extends a {
        private C0098b() {
            super();
        }

        @Override // com.ss.android.downloadlib.h.b.a
        public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        a.a(asyncTask, tArr);
    }
}
