package com.ta.utdid2.b.a;

import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

public class d {
    private static final Object b = new Object();
    private File a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f86a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<File, a> f87a = new HashMap<>();

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.a = new File(str);
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File a() {
        File file;
        synchronized (this.f86a) {
            file = this.a;
        }
        return file;
    }

    private File b(String str) {
        File a2 = a();
        return a(a2, str + ".xml");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057 A[SYNTHETIC, Splitter:B:33:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0079 A[SYNTHETIC, Splitter:B:52:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0086 A[SYNTHETIC, Splitter:B:64:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0093  */
    public b a(String str, int i) {
        a aVar;
        Throwable th;
        HashMap hashMap;
        FileInputStream fileInputStream;
        Throwable th2;
        File b2 = b(str);
        synchronized (b) {
            aVar = this.f87a.get(b2);
            if (aVar != null && !aVar.d()) {
                return aVar;
            }
        }
        File a2 = a(b2);
        if (a2.exists()) {
            b2.delete();
            a2.renameTo(b2);
        }
        HashMap hashMap2 = null;
        hashMap2 = null;
        hashMap2 = null;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        hashMap2 = null;
        if (b2.exists() && b2.canRead()) {
            try {
                FileInputStream fileInputStream4 = new FileInputStream(b2);
                try {
                    hashMap2 = e.a(fileInputStream4);
                    fileInputStream4.close();
                    try {
                        fileInputStream4.close();
                    } catch (Throwable unused) {
                    }
                } catch (XmlPullParserException unused2) {
                    fileInputStream3 = fileInputStream4;
                    hashMap = hashMap2;
                    try {
                        fileInputStream = new FileInputStream(b2);
                        try {
                            fileInputStream.read(new byte[fileInputStream.available()]);
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused3) {
                            }
                        } catch (Exception unused4) {
                            fileInputStream3 = fileInputStream;
                            if (fileInputStream3 != null) {
                                try {
                                    fileInputStream3.close();
                                } catch (Throwable unused5) {
                                }
                            }
                            fileInputStream = fileInputStream3;
                            if (fileInputStream != null) {
                            }
                            hashMap2 = hashMap;
                            synchronized (b) {
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            fileInputStream3 = fileInputStream;
                            if (fileInputStream3 != null) {
                                try {
                                    fileInputStream3.close();
                                } catch (Throwable unused6) {
                                }
                            }
                            try {
                                throw th2;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    } catch (Exception unused7) {
                        if (fileInputStream3 != null) {
                        }
                        fileInputStream = fileInputStream3;
                        if (fileInputStream != null) {
                        }
                        hashMap2 = hashMap;
                        synchronized (b) {
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        if (fileInputStream3 != null) {
                        }
                        throw th2;
                    }
                    if (fileInputStream != null) {
                    }
                    hashMap2 = hashMap;
                    synchronized (b) {
                    }
                } catch (Exception unused8) {
                    fileInputStream2 = fileInputStream4;
                    hashMap = hashMap2;
                    if (fileInputStream2 != null) {
                    }
                    hashMap2 = hashMap;
                    synchronized (b) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream3 = fileInputStream4;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (Throwable unused9) {
                        }
                    }
                    throw th;
                }
            } catch (XmlPullParserException unused10) {
                hashMap = null;
                fileInputStream = new FileInputStream(b2);
                fileInputStream.read(new byte[fileInputStream.available()]);
                fileInputStream.close();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                hashMap2 = hashMap;
                synchronized (b) {
                }
            } catch (Exception unused11) {
                hashMap = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable unused12) {
                    }
                }
                hashMap2 = hashMap;
                synchronized (b) {
                }
            }
        }
        synchronized (b) {
            if (aVar != null) {
                aVar.a(hashMap2);
            } else {
                aVar = this.f87a.get(b2);
                if (aVar == null) {
                    aVar = new a(b2, i, hashMap2);
                    this.f87a.put(b2, aVar);
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    private static final class a implements b {
        private static final Object c = new Object();
        private Map a;

        /* renamed from: a  reason: collision with other field name */
        private WeakHashMap<b.AbstractC0127b, Object> f88a;
        private final File b;

        /* renamed from: c  reason: collision with other field name */
        private final int f89c;

        /* renamed from: c  reason: collision with other field name */
        private final File f90c;
        private boolean j = false;

        a(File file, int i, Map map) {
            this.b = file;
            this.f90c = d.a(file);
            this.f89c = i;
            this.a = map == null ? new HashMap() : map;
            this.f88a = new WeakHashMap<>();
        }

        @Override // com.ta.utdid2.b.a.b
        public boolean b() {
            return this.b != null && new File(this.b.getAbsolutePath()).exists();
        }

        public void a(boolean z) {
            synchronized (this) {
                this.j = z;
            }
        }

        public boolean d() {
            boolean z;
            synchronized (this) {
                z = this.j;
            }
            return z;
        }

        public void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.a = map;
                }
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.a);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.b.a.b
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        @Override // com.ta.utdid2.b.a.b
        public long getLong(String str, long j2) {
            synchronized (this) {
                Long l = (Long) this.a.get(str);
                if (l != null) {
                    j2 = l.longValue();
                }
            }
            return j2;
        }

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        public final class C0128a implements b.a {
            private final Map<String, Object> b = new HashMap();
            private boolean k = false;

            public C0128a() {
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.b.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, int i) {
                synchronized (this) {
                    this.b.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, long j) {
                synchronized (this) {
                    this.b.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, float f) {
                synchronized (this) {
                    this.b.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, boolean z) {
                synchronized (this) {
                    this.b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.b.put(str, this);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.k = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.AbstractC0127b> hashSet;
                boolean e;
                synchronized (d.b) {
                    z = a.this.f88a.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f88a.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.k) {
                            a.this.a.clear();
                            this.k = false;
                        }
                        for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.a.remove(key);
                            } else {
                                a.this.a.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.b.clear();
                    }
                    e = a.this.e();
                    if (e) {
                        a.this.a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.AbstractC0127b bVar : hashSet) {
                            if (bVar != null) {
                                bVar.a(a.this, str);
                            }
                        }
                    }
                }
                return e;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public b.a a() {
            return new C0128a();
        }

        private FileOutputStream a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }

        /* access modifiers changed from: private */
        public boolean e() {
            if (this.b.exists()) {
                if (this.f90c.exists()) {
                    this.b.delete();
                } else if (!this.b.renameTo(this.f90c)) {
                    return false;
                }
            }
            try {
                FileOutputStream a2 = a(this.b);
                if (a2 == null) {
                    return false;
                }
                e.a(this.a, a2);
                a2.close();
                this.f90c.delete();
                return true;
            } catch (Exception unused) {
                if (this.b.exists()) {
                    this.b.delete();
                }
                return false;
            }
        }
    }
}
