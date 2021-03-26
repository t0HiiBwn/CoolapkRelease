package com.ss.android.a.a.c;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: DownloadAlertDialogInfo */
public class c {
    public Context a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public b h;
    public View i;
    public int j;

    /* compiled from: DownloadAlertDialogInfo */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private c(a aVar) {
        this.f = true;
        this.a = aVar.c;
        this.b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.h = aVar.j;
        this.i = aVar.a;
        this.j = aVar.b;
    }

    /* compiled from: DownloadAlertDialogInfo */
    public static final class a {
        public View a;
        public int b;
        private Context c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private b j;

        public a(Context context) {
            this.c = context;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.g = str;
            return this;
        }

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(b bVar) {
            this.j = bVar;
            return this;
        }

        public a a(int i2) {
            this.b = i2;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
