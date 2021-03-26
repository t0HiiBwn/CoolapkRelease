package com.kepler.sdk;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.kepler.sdk.b;
import java.lang.reflect.Constructor;
import java.util.HashMap;

final class d extends LayoutInflater implements b.a {
    static final Class<?>[] a = {Context.class, AttributeSet.class};
    private static final String[] b = {"android.widget.", "android.webkit."};
    private HashMap<String, Boolean> c;
    private final Object[] d;
    private final HashMap<String, Constructor<? extends View>> e;

    protected d(Context context) {
        this(context, new b(context));
    }

    private d(Context context, b bVar) {
        super(bVar, context);
        this.d = new Object[2];
        this.e = new HashMap<>();
        bVar.a(this);
    }

    protected d(d dVar, Context context) {
        super(dVar, context);
        this.d = new Object[2];
        this.e = new HashMap<>();
    }

    @Override // android.view.LayoutInflater
    public void setFilter(LayoutInflater.Filter filter) {
        super.setFilter(filter);
        if (filter != null) {
            this.c = new HashMap<>();
        }
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return new d(this, context);
    }

    @Override // android.view.LayoutInflater
    protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        for (String str2 : b) {
            try {
                View createView = createView(str, str2, attributeSet);
                if (createView != null) {
                    return createView;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c A[SYNTHETIC, Splitter:B:8:0x002c] */
    @Override // com.kepler.sdk.b.a
    public View a(View view, String str, Context context, AttributeSet attributeSet) throws ClassNotFoundException {
        View view2;
        if (-1 != str.indexOf(46)) {
            try {
                view2 = b(str, attributeSet);
            } catch (Throwable unused) {
                Log.d("PluginLayoutInflater", "fail to create view internal for " + str + " with ");
            }
            if (view2 == null) {
                return view2;
            }
            try {
                return a(str, attributeSet);
            } catch (Throwable unused2) {
                return view2;
            }
        }
        view2 = null;
        if (view2 == null) {
        }
    }

    private View a(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        if (-1 == str.indexOf(46)) {
            return onCreateView(str, attributeSet);
        }
        return createView(str, null, attributeSet);
    }

    private View b(String str, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        String str2;
        View view;
        synchronized (this.d) {
            boolean z = false;
            this.d[0] = getContext();
            Constructor<? extends View> constructor = this.e.get(str);
            Class cls = null;
            try {
                LayoutInflater.Filter filter = getFilter();
                if (constructor == null) {
                    Class<? extends U> asSubclass = getClass().getClassLoader().loadClass(str).asSubclass(View.class);
                    if (!(filter == null || asSubclass == null || filter.onLoadClass(asSubclass))) {
                        c(str, attributeSet);
                    }
                    constructor = asSubclass.getConstructor(a);
                    this.e.put(str, constructor);
                } else if (filter != null) {
                    Boolean bool = this.c.get(str);
                    if (bool == null) {
                        Class<? extends U> asSubclass2 = getClass().getClassLoader().loadClass(str).asSubclass(View.class);
                        if (asSubclass2 != null && filter.onLoadClass(asSubclass2)) {
                            z = true;
                        }
                        this.c.put(str, Boolean.valueOf(z));
                        if (!z) {
                            c(str, attributeSet);
                        }
                    } else if (bool.equals(Boolean.FALSE)) {
                        c(str, attributeSet);
                    }
                }
                Object[] objArr = this.d;
                objArr[1] = attributeSet;
                view = (View) constructor.newInstance(objArr);
                if (Build.VERSION.SDK_INT >= 16 && (view instanceof ViewStub)) {
                    ((ViewStub) view).setLayoutInflater(this);
                }
            } catch (NoSuchMethodException e2) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e2);
                throw inflateException;
            } catch (ClassCastException e3) {
                InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Class is not a View " + str);
                inflateException2.initCause(e3);
                throw inflateException2;
            } catch (ClassNotFoundException e4) {
                throw e4;
            } catch (Exception e5) {
                StringBuilder sb = new StringBuilder();
                sb.append(attributeSet.getPositionDescription());
                sb.append(": Error inflating class ");
                if (0 == 0) {
                    str2 = "<unknown>";
                } else {
                    str2 = cls.getName();
                }
                sb.append(str2);
                InflateException inflateException3 = new InflateException(sb.toString());
                inflateException3.initCause(e5);
                throw inflateException3;
            }
        }
        return view;
    }

    private void c(String str, AttributeSet attributeSet) {
        throw new InflateException(attributeSet.getPositionDescription() + ": Class not allowed to be inflated " + str);
    }
}
