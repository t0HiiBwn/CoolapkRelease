package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: DownloadChunk */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* class com.ss.android.socialbase.downloader.model.b.AnonymousClass1 */

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    private static final String a = "b";
    private int b;
    private long c;
    private AtomicLong d;
    private long e;
    private long f;
    private int g;
    private AtomicInteger h;
    private long i;
    private List<b> j;
    private b k;

    /* renamed from: l  reason: collision with root package name */
    private int f1419l;
    private boolean m;
    private AtomicBoolean n;
    private com.ss.android.socialbase.downloader.h.b o;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private b(a aVar) {
        if (aVar != null) {
            this.b = aVar.a;
            this.c = aVar.b;
            this.d = new AtomicLong(aVar.c);
            this.e = aVar.d;
            this.f = aVar.e;
            this.g = aVar.f;
            this.i = aVar.g;
            this.h = new AtomicInteger(-1);
            a(aVar.h);
            this.n = new AtomicBoolean(false);
        }
    }

    public b(Cursor cursor) {
        if (cursor != null) {
            this.b = cursor.getInt(cursor.getColumnIndex("_id"));
            this.g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
            this.c = cursor.getLong(cursor.getColumnIndex("startOffset"));
            int columnIndex = cursor.getColumnIndex("curOffset");
            if (columnIndex != -1) {
                this.d = new AtomicLong(cursor.getLong(columnIndex));
            } else {
                this.d = new AtomicLong(0);
            }
            this.e = cursor.getLong(cursor.getColumnIndex("endOffset"));
            int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
            if (columnIndex2 != -1) {
                this.h = new AtomicInteger(cursor.getInt(columnIndex2));
            } else {
                this.h = new AtomicInteger(-1);
            }
            int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
            if (columnIndex3 != -1) {
                this.f = cursor.getLong(columnIndex3);
            }
            this.n = new AtomicBoolean(false);
        }
    }

    protected b(Parcel parcel) {
        this.b = parcel.readInt();
        this.c = parcel.readLong();
        this.d = new AtomicLong(parcel.readLong());
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readInt();
        this.h = new AtomicInteger(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        AtomicLong atomicLong = this.d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g);
        int i3 = -1;
        AtomicInteger atomicInteger = this.h;
        if (atomicInteger != null) {
            i3 = atomicInteger.get();
        }
        parcel.writeInt(i3);
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.b));
        contentValues.put("chunkIndex", Integer.valueOf(this.g));
        contentValues.put("startOffset", Long.valueOf(this.c));
        contentValues.put("curOffset", Long.valueOf(n()));
        contentValues.put("endOffset", Long.valueOf(this.e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f));
        contentValues.put("hostChunkIndex", Integer.valueOf(b()));
        return contentValues;
    }

    public void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            this.f1419l = 0;
            sQLiteStatement.clearBindings();
            int i2 = this.f1419l + 1;
            this.f1419l = i2;
            sQLiteStatement.bindLong(i2, (long) this.b);
            int i3 = this.f1419l + 1;
            this.f1419l = i3;
            sQLiteStatement.bindLong(i3, (long) this.g);
            int i4 = this.f1419l + 1;
            this.f1419l = i4;
            sQLiteStatement.bindLong(i4, this.c);
            int i5 = this.f1419l + 1;
            this.f1419l = i5;
            sQLiteStatement.bindLong(i5, n());
            int i6 = this.f1419l + 1;
            this.f1419l = i6;
            sQLiteStatement.bindLong(i6, this.e);
            int i7 = this.f1419l + 1;
            this.f1419l = i7;
            sQLiteStatement.bindLong(i7, this.f);
            int i8 = this.f1419l + 1;
            this.f1419l = i8;
            sQLiteStatement.bindLong(i8, (long) b());
        }
    }

    public int b() {
        AtomicInteger atomicInteger = this.h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public void a(int i2) {
        AtomicInteger atomicInteger = this.h;
        if (atomicInteger == null) {
            this.h = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public boolean c() {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public void a(com.ss.android.socialbase.downloader.h.b bVar) {
        this.o = bVar;
        r();
    }

    public void a(boolean z) {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            this.n = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.o = null;
    }

    public void a(b bVar) {
        this.k = bVar;
        if (bVar != null) {
            a(bVar.s());
        }
    }

    public boolean d() {
        return b() == -1;
    }

    public b e() {
        b bVar = !d() ? this.k : this;
        if (bVar == null || !bVar.f()) {
            return null;
        }
        return bVar.g().get(0);
    }

    public boolean f() {
        List<b> list = this.j;
        return list != null && list.size() > 0;
    }

    public void a(List<b> list) {
        this.j = list;
    }

    public List<b> g() {
        return this.j;
    }

    public boolean h() {
        b bVar = this.k;
        if (bVar == null) {
            return true;
        }
        if (!bVar.f()) {
            return false;
        }
        for (int i2 = 0; i2 < this.k.g().size(); i2++) {
            b bVar2 = this.k.g().get(i2);
            if (bVar2 != null) {
                int indexOf = this.k.g().indexOf(this);
                if (indexOf > i2 && !bVar2.i()) {
                    return false;
                }
                if (indexOf == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public boolean i() {
        long j2 = this.c;
        if (d()) {
            long j3 = this.i;
            if (j3 > this.c) {
                j2 = j3;
            }
        }
        return n() - j2 >= this.f;
    }

    public long j() {
        b bVar = this.k;
        if (!(bVar == null || bVar.g() == null)) {
            int indexOf = this.k.g().indexOf(this);
            boolean z = false;
            for (int i2 = 0; i2 < this.k.g().size(); i2++) {
                b bVar2 = this.k.g().get(i2);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.n();
                    }
                    if (indexOf == i2) {
                        z = true;
                    }
                }
            }
        }
        return -1;
    }

    public void b(int i2) {
        this.b = i2;
    }

    public void c(int i2) {
        this.g = i2;
    }

    public void a(long j2) {
        this.f = j2;
    }

    public int k() {
        return this.b;
    }

    public long l() {
        return this.c;
    }

    public long m() {
        AtomicLong atomicLong = this.d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0;
    }

    public long n() {
        if (!d() || !f()) {
            return m();
        }
        long j2 = 0;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            b bVar = this.j.get(i2);
            if (bVar != null) {
                if (!bVar.i()) {
                    return bVar.m();
                }
                if (j2 < bVar.m()) {
                    j2 = bVar.m();
                }
            }
        }
        return j2;
    }

    public void b(long j2) {
        AtomicLong atomicLong = this.d;
        if (atomicLong != null) {
            atomicLong.set(j2);
        } else {
            this.d = new AtomicLong(j2);
        }
    }

    public long o() {
        long n2 = n() - this.c;
        if (f()) {
            n2 = 0;
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                b bVar = this.j.get(i2);
                if (bVar != null) {
                    n2 += bVar.n() - bVar.l();
                }
            }
        }
        return n2;
    }

    public long p() {
        return this.e;
    }

    public long q() {
        return this.f;
    }

    public void r() {
        this.i = n();
    }

    public long c(boolean z) {
        long n2 = n();
        long j2 = this.f;
        long j3 = this.i;
        long j4 = j2 - (n2 - j3);
        if (!z && n2 == j3) {
            j4 = j2 - (n2 - this.c);
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadChunk", "contentLength:" + this.f + " curOffset:" + n() + " oldOffset:" + this.i + " retainLen:" + j4);
        if (j4 < 0) {
            return 0;
        }
        return j4;
    }

    public List<b> a(int i2, long j2) {
        b bVar;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        b bVar2 = this;
        int i3 = i2;
        if (!d() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m2 = m();
        long c2 = bVar2.c(true);
        long j8 = c2 / ((long) i3);
        com.ss.android.socialbase.downloader.c.a.b(a, "retainLen:" + c2 + " divideChunkForReuse chunkSize:" + j8 + " current host downloadChunk index:" + bVar2.g);
        int i4 = 0;
        while (i4 < i3) {
            if (i4 == 0) {
                j5 = l();
                j7 = (m2 + j8) - 1;
            } else {
                int i5 = i3 - 1;
                if (i4 == i5) {
                    long p = p();
                    j6 = p > m2 ? (p - m2) + 1 : c2 - (((long) i5) * j8);
                    j4 = p;
                    j5 = m2;
                    b a2 = new a(bVar2.b).a((-i4) - 1).a(j5).b(m2).e(m2).c(j4).d(j6).a(bVar2).a();
                    com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + j5 + " curOffset:" + m2 + " endOffset:" + j4 + " contentLen:" + j6);
                    arrayList.add(a2);
                    m2 += j8;
                    i4++;
                    bVar2 = this;
                    i3 = i2;
                    c2 = c2;
                } else {
                    j7 = (m2 + j8) - 1;
                    j5 = m2;
                }
            }
            j6 = j8;
            j4 = j7;
            b a2 = new a(bVar2.b).a((-i4) - 1).a(j5).b(m2).e(m2).c(j4).d(j6).a(bVar2).a();
            com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i4 + " startOffset:" + j5 + " curOffset:" + m2 + " endOffset:" + j4 + " contentLen:" + j6);
            arrayList.add(a2);
            m2 += j8;
            i4++;
            bVar2 = this;
            i3 = i2;
            c2 = c2;
        }
        long j9 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = arrayList.get(size);
            if (bVar3 != null) {
                j9 += bVar3.q();
            }
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "reuseChunkContentLen:" + j9);
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (p() == 0) {
                j3 = j2 - l();
            } else {
                j3 = (p() - l()) + 1;
            }
            bVar4.a(j3 - j9);
            bVar = this;
            bVar4.c(bVar.g);
            com.ss.android.socialbase.downloader.h.b bVar5 = bVar.o;
            if (bVar5 != null) {
                bVar5.a(bVar4.p(), q() - j9);
            }
        } else {
            bVar = this;
        }
        bVar.a(arrayList);
        return arrayList;
    }

    public int s() {
        return this.g;
    }

    /* compiled from: DownloadChunk */
    public static class a {
        private int a;
        private long b;
        private long c;
        private long d;
        private long e;
        private int f;
        private long g;
        private b h;

        public a(int i) {
            this.a = i;
        }

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a b(long j) {
            this.c = j;
            return this;
        }

        public a c(long j) {
            this.d = j;
            return this;
        }

        public a d(long j) {
            this.e = j;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a a(b bVar) {
            this.h = bVar;
            return this;
        }

        public a e(long j) {
            this.g = j;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
