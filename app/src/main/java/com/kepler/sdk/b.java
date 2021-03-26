package com.kepler.sdk;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

final class b extends LayoutInflater {
    private a a;

    public interface a {
        View a(View view, String str, Context context, AttributeSet attributeSet) throws ClassNotFoundException;
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return null;
    }

    protected b(Context context) {
        this(context, null);
    }

    protected b(Context context, a aVar) {
        super(context);
        a(aVar);
        a();
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
    private void a() {
        boolean z;
        if (b()) {
            try {
                setFactory2(new LayoutInflater.Factory2() {
                    /* class com.kepler.sdk.b.AnonymousClass1 */

                    @Override // android.view.LayoutInflater.Factory
                    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
                        return null;
                    }

                    @Override // android.view.LayoutInflater.Factory2
                    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
                        return b.this.a(view, str, context, attributeSet);
                    }
                });
                z = true;
            } catch (Throwable unused) {
            }
            if (z) {
                setFactory(new LayoutInflater.Factory() {
                    /* class com.kepler.sdk.b.AnonymousClass2 */

                    @Override // android.view.LayoutInflater.Factory
                    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
                        return b.this.a(null, str, context, attributeSet);
                    }
                });
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    /* access modifiers changed from: private */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        try {
            return aVar.a(view, str, context, attributeSet);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 11;
    }
}
