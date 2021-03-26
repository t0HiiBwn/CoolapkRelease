package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* compiled from: SqlDownloadCache */
public class e extends c.a implements r {
    private static volatile SQLiteDatabase b;
    b a;
    private g c;
    private g d;
    private g e;
    private volatile boolean f;

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i, List<b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> c(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> d(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo g(int i) {
        return null;
    }

    public e() {
        this(false);
    }

    public e(boolean z) {
        this.a = null;
        if (z) {
            this.f = false;
            a();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    try {
                        b = a.a().getWritableDatabase();
                        this.c = new g(b, "downloader", com.ss.android.socialbase.downloader.constants.c.a, com.ss.android.socialbase.downloader.constants.c.b);
                        this.d = new g(b, "downloadChunk", com.ss.android.socialbase.downloader.constants.c.c, com.ss.android.socialbase.downloader.constants.c.d);
                        this.e = new g(b, "segments", com.ss.android.socialbase.downloader.constants.c.e, com.ss.android.socialbase.downloader.constants.c.f);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a() {
        a((SparseArray<DownloadInfo>) null, (SparseArray<List<b>>) null, (d) null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.r
    public void a(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<b>> sparseArray2, final d dVar) {
        try {
            AnonymousClass1 r0 = new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass1 */

                /* JADX WARNING: Code restructure failed: missing block: B:101:0x01b0, code lost:
                    if (r0 == null) goto L_0x01d5;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:109:0x01cb, code lost:
                    if (r0 != null) goto L_0x01cd;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:110:0x01cd, code lost:
                    r0.a();
                    r20.d.f = true;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:111:0x01d5, code lost:
                    r20.d.a(r0, r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:151:0x0275, code lost:
                    if (r0 == null) goto L_0x01d5;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:159:0x0291, code lost:
                    if (r0 == null) goto L_0x01d5;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:160:0x0295, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:200:0x0330, code lost:
                    if (r0 == null) goto L_0x0355;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:208:0x034b, code lost:
                    if (r0 == null) goto L_0x0355;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:209:0x034d, code lost:
                    r0.a();
                    r20.d.f = true;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:210:0x0355, code lost:
                    r20.d.a(r0, r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:211:0x035a, code lost:
                    throw r0;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x00de A[Catch:{ all -> 0x01dc, all -> 0x0296, all -> 0x026f }] */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x00ed A[Catch:{ all -> 0x01dc, all -> 0x0296, all -> 0x026f }] */
                @Override // java.lang.Runnable
                public void run() {
                    d dVar;
                    d dVar2;
                    boolean z;
                    e.this.g();
                    if (e.b != null) {
                        SparseArray<DownloadInfo> sparseArray = sparseArray;
                        if (sparseArray == null) {
                            sparseArray = new SparseArray<>();
                        }
                        SparseArray<List<b>> sparseArray2 = sparseArray2;
                        if (sparseArray2 == null) {
                            sparseArray2 = new SparseArray<>();
                        }
                        j B = com.ss.android.socialbase.downloader.downloader.b.B();
                        SparseArray sparseArray3 = new SparseArray();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int i = -3;
                        int i2 = 0;
                        try {
                            Cursor rawQuery = e.b.rawQuery("SELECT * FROM downloader", null);
                            while (rawQuery.moveToNext()) {
                                DownloadInfo downloadInfo = new DownloadInfo(rawQuery);
                                downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                                if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                    downloadInfo.setStatus(-5);
                                    if (a.c().b("status_not_update_to_db", true)) {
                                        sparseArray3.put(downloadInfo.getId(), downloadInfo);
                                    }
                                }
                                if (!TextUtils.isEmpty(downloadInfo.getSavePath())) {
                                    if (!TextUtils.isEmpty(downloadInfo.getName())) {
                                        if (downloadInfo.getStatus() != 1 || downloadInfo.getCurBytes() > 0) {
                                            if (!(downloadInfo.getStatus() == i || downloadInfo.getStatus() == 11 || downloadInfo.isFileDataValid())) {
                                                downloadInfo.reset();
                                            }
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        if (downloadInfo.getStatus() == 11) {
                                            downloadInfo.setStatus(-5);
                                        }
                                        if (com.ss.android.socialbase.downloader.i.e.a(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                            if (!com.ss.android.socialbase.downloader.i.a.a(33554432)) {
                                                downloadInfo.erase();
                                            }
                                        }
                                        if (!z) {
                                            arrayList.add(Integer.valueOf(downloadInfo.getId()));
                                            arrayList2.add(downloadInfo);
                                        } else {
                                            int id = downloadInfo.getId();
                                            int a2 = B != null ? B.a(downloadInfo.getUrl(), downloadInfo.getSavePath()) : 0;
                                            if (a2 != id) {
                                                downloadInfo.setId(a2);
                                                sparseArray3.put(id, downloadInfo);
                                            }
                                            if (sparseArray != null) {
                                                synchronized (sparseArray) {
                                                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                        i = -3;
                                    }
                                }
                                z = true;
                                if (!z) {
                                }
                                i = -3;
                            }
                            com.ss.android.socialbase.downloader.i.e.a(rawQuery);
                            e.this.a(arrayList2);
                            e.this.a(arrayList2, arrayList, sparseArray3, sparseArray, sparseArray2);
                            if (sparseArray != null) {
                                try {
                                    synchronized (sparseArray) {
                                        ArrayList<Integer> arrayList3 = new ArrayList();
                                        while (i2 < sparseArray.size()) {
                                            int keyAt = sparseArray.keyAt(i2);
                                            if (keyAt != 0) {
                                                DownloadInfo downloadInfo2 = sparseArray.get(keyAt);
                                                if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                    if (!(downloadInfo2 == null || downloadInfo2.isChunkBreakpointAvailable() || downloadInfo2.getStatus() == -3)) {
                                                        arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                        sparseArray2.remove(downloadInfo2.getId());
                                                    }
                                                } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                                    arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                    sparseArray2.remove(downloadInfo2.getId());
                                                }
                                            }
                                            i2++;
                                        }
                                        for (Integer num : arrayList3) {
                                            sparseArray.remove(num.intValue());
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (dVar != null) {
                                        dVar.a();
                                        e.this.f = true;
                                    }
                                    e.this.a(sparseArray, sparseArray2);
                                    throw th;
                                }
                            }
                            dVar2 = dVar;
                        } catch (Throwable th2) {
                            try {
                                th2.printStackTrace();
                                dVar2 = dVar;
                            } catch (Throwable th3) {
                                if (dVar != null) {
                                    dVar.a();
                                    e.this.f = true;
                                }
                                e.this.a(sparseArray, sparseArray2);
                                throw th3;
                            }
                        }
                    }
                }
            };
            ExecutorService r = com.ss.android.socialbase.downloader.downloader.b.r();
            if (r != null) {
                r.execute(r0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(List<DownloadInfo> list) {
        if (list != null) {
            try {
                for (DownloadInfo downloadInfo : list) {
                    if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                        com.ss.android.socialbase.downloader.i.e.b(downloadInfo);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void h() {
        b.beginTransaction();
    }

    /* access modifiers changed from: private */
    public void a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<b>> sparseArray3) {
        int size = sparseArray.size();
        if (size >= 0 && b != null) {
            synchronized (b) {
                try {
                    h();
                    if (!list.isEmpty()) {
                        if (a.c().a("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = String.valueOf(list.get(i));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[(list.size() - 1)]).replace("\u0000", "?,") + "?)";
                            b.delete("downloader", str, strArr);
                            b.delete("downloadChunk", str, strArr);
                        } else {
                            String join = TextUtils.join(", ", list2);
                            b.delete("downloader", "_id IN (?)", new String[]{join});
                            b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int keyAt = sparseArray.keyAt(i2);
                        DownloadInfo downloadInfo = sparseArray.get(keyAt);
                        b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                        b.insert("downloader", null, downloadInfo.toContentValues());
                        if (downloadInfo.getChunkCount() > 1) {
                            List<b> c2 = c(keyAt);
                            if (c2.size() > 0) {
                                b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                                for (b bVar : c2) {
                                    bVar.b(downloadInfo.getId());
                                    b.insert("downloadChunk", null, bVar.a());
                                }
                            }
                        }
                    }
                    if (!(sparseArray2 == null || sparseArray3 == null)) {
                        synchronized (sparseArray2) {
                            int size2 = sparseArray2.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                int id = sparseArray2.valueAt(i3).getId();
                                List<b> a2 = com.ss.android.socialbase.downloader.i.e.a(c(id));
                                if (a2 != null && a2.size() > 0) {
                                    sparseArray3.put(id, a2);
                                }
                            }
                        }
                    }
                    b.setTransactionSuccessful();
                } catch (Throwable th) {
                    i();
                    throw th;
                }
                i();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(int i) {
        try {
            return b(i) != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i) {
        Cursor cursor;
        Throwable th;
        g();
        if (b != null) {
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        DownloadInfo downloadInfo = new DownloadInfo(cursor);
                        com.ss.android.socialbase.downloader.i.e.a(cursor);
                        return downloadInfo;
                    }
                    com.ss.android.socialbase.downloader.i.e.a(cursor);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.e.a(cursor);
                        return null;
                    } catch (Throwable th3) {
                        com.ss.android.socialbase.downloader.i.e.a(cursor);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
                th.printStackTrace();
                com.ss.android.socialbase.downloader.i.e.a(cursor);
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> a(String str) {
        g();
        ArrayList arrayList = new ArrayList();
        if (b != null) {
            try {
                Cursor rawQuery = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (rawQuery.moveToNext()) {
                    arrayList.add(new DownloadInfo(rawQuery));
                }
                com.ss.android.socialbase.downloader.i.e.a(rawQuery);
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.e.a(null);
                throw th;
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<b> c(int i) {
        ArrayList arrayList = new ArrayList();
        g();
        if (b != null) {
            try {
                Cursor rawQuery = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i)});
                while (rawQuery.moveToNext()) {
                    arrayList.add(new b(rawQuery));
                }
                com.ss.android.socialbase.downloader.i.e.a(rawQuery);
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.e.a(null);
                throw th;
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void d(final int i) {
        g();
        if (b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, e.this.d.b());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    sQLiteStatement.bindLong(1, (long) i);
                    sQLiteStatement.execute();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final b bVar) {
        g();
        if (b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(bVar, e.this.d.a());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(b bVar) {
        a(bVar);
    }

    /* access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    downloadInfo.bindValue(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    bVar.a(sQLiteStatement);
                    sQLiteStatement.executeInsert();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final long j) {
        g();
        if (i != 0 && i2 >= 0 && j >= 0 && b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass6 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, j, e.this.d.c());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final int i3, final long j) {
        g();
        if (i != 0 && i2 >= 0 && i3 >= 0 && j >= 0 && b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass7 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, i3, j, e.this.d.c());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(final int i, final int i2, final int i3, final int i4) {
        g();
        if (i != 0 && i3 >= 0 && i4 != i2 && i4 >= 0 && b != null && this.d != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass8 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.a(i, i2, i3, i4, e.this.d.c());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        if (downloadInfo != null && sQLiteStatement != null) {
            try {
                synchronized (sQLiteStatement) {
                    downloadInfo.bindValue(sQLiteStatement);
                    sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, (long) downloadInfo.getId());
                    sQLiteStatement.execute();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, int i2) {
        g();
        if (b == null) {
            return null;
        }
        int i3 = 10;
        while (b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    private void c(final DownloadInfo downloadInfo) {
        g();
        if (b != null && this.c != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass9 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e eVar = e.this;
                        eVar.a(downloadInfo, eVar.c.a());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(final DownloadInfo downloadInfo) {
        g();
        if (downloadInfo == null || b == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
            /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass10 */

            @Override // java.lang.Runnable
            public void run() {
                e.this.d(downloadInfo);
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (!a(downloadInfo.getId())) {
                    c(downloadInfo);
                } else {
                    g gVar = this.c;
                    if (gVar != null) {
                        try {
                            b(downloadInfo, gVar.c());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        return;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return;
        }
        return;
    }

    private void i() {
        try {
            if (b != null && b.inTransaction()) {
                b.endTransaction();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e(int i) {
        g gVar;
        g();
        if (!(b == null || (gVar = this.c) == null)) {
            try {
                a(i, gVar.b());
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean f(final int i) {
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
            /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass11 */

            @Override // java.lang.Runnable
            public void run() {
                e.this.e(i);
                e.this.d(i);
                e.this.m(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b() {
        g();
        if (b != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    e.this.j();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public synchronized void j() {
        try {
            h();
            b.delete("downloader", null, null);
            b.delete("downloadChunk", null, null);
            b.setTransactionSuccessful();
        } catch (Throwable th) {
            i();
            throw th;
        }
        i();
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) -1);
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo h(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) -3);
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) -2);
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) -4);
        contentValues.put("curBytes", Long.valueOf(j));
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo i(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo j(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) -7);
        a(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean c() {
        return this.f;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(int i, List<b> list) {
        try {
            d(i);
            if (list != null) {
                for (b bVar : list) {
                    if (bVar != null) {
                        a(bVar);
                        if (bVar.f()) {
                            for (b bVar2 : bVar.g()) {
                                a(bVar2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: k */
    public ArrayList<i> n(int i) {
        Map<Long, i> l2 = l(i);
        if (l2 == null || l2.isEmpty()) {
            return null;
        }
        return new ArrayList<>(l2.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public Map<Long, i> l(int i) {
        Cursor cursor;
        Throwable th;
        g();
        if (b != null) {
            try {
                cursor = b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        int columnIndex = cursor.getColumnIndex("info");
                        String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                        HashMap hashMap = new HashMap();
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            i iVar = new i(jSONArray.getJSONObject(i2));
                            hashMap.put(Long.valueOf(iVar.c()), iVar);
                        }
                        com.ss.android.socialbase.downloader.i.e.a(cursor);
                        return hashMap;
                    }
                    com.ss.android.socialbase.downloader.i.e.a(cursor);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.e.a(cursor);
                        return null;
                    } catch (Throwable th3) {
                        com.ss.android.socialbase.downloader.i.e.a(cursor);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
                th.printStackTrace();
                com.ss.android.socialbase.downloader.i.e.a(cursor);
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(int i, Map<Long, i> map) {
        long currentTimeMillis = System.currentTimeMillis();
        g();
        if (b == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Long l2 : map.keySet()) {
                jSONArray.put(map.get(Long.valueOf(l2.longValue())).k());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Log.d("SqlDownloadCache", "json=" + jSONArray);
        SQLiteStatement d2 = this.e.d();
        synchronized (d2) {
            d2.clearBindings();
            d2.bindLong(1, (long) i);
            d2.bindString(2, jSONArray.toString());
            d2.execute();
        }
        com.ss.android.socialbase.downloader.c.a.b("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.i.e.c(currentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void m(int i) {
        g();
        if (b != null) {
            try {
                a(i, this.e.b());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(final int i, final ContentValues contentValues) {
        g();
        if (b != null) {
            com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() {
                /* class com.ss.android.socialbase.downloader.b.e.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    e.this.b(i, contentValues);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(int i, ContentValues contentValues) {
        int i2 = 10;
        while (b.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        try {
            b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(b bVar) {
        this.a = bVar;
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<b>> sparseArray2) {
        try {
            HashMap a2 = com.ss.android.socialbase.downloader.i.e.a(sparseArray);
            HashMap a3 = com.ss.android.socialbase.downloader.i.e.a(sparseArray2);
            b bVar = this.a;
            if (bVar != null) {
                bVar.a(a2, a3);
            }
        } catch (Throwable unused) {
        }
    }
}
