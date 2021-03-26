package com.ss.android.a.a.c;

/* compiled from: AppInfo */
public class a {
    public String a;
    public String b = "";
    public String c;
    public String d;
    public String e;

    public a(C0079a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    /* renamed from: com.ss.android.a.a.c.a$a  reason: collision with other inner class name */
    /* compiled from: AppInfo */
    public static class C0079a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;

        public C0079a a(String str) {
            this.a = str;
            return this;
        }

        public C0079a b(String str) {
            this.b = str;
            return this;
        }

        public C0079a c(String str) {
            this.d = str;
            return this;
        }

        public C0079a d(String str) {
            this.e = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
