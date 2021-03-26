package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Point;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.maps2d.model.LatLng;

/* compiled from: MapOverlayViewGroup */
class au extends ViewGroup {
    private y a;

    public au(Context context, y yVar) {
        super(context);
        this.a = yVar;
        setWillNotDraw(false);
    }

    /* compiled from: MapOverlayViewGroup */
    public static class a extends ViewGroup.LayoutParams {
        public int a;
        public LatLng b;
        public int c;
        public int d;
        public int e;

        public a(int i, int i2, LatLng latLng, int i3, int i4, int i5) {
            super(i, i2);
            this.a = 1;
            this.b = null;
            this.c = 0;
            this.d = 0;
            this.e = 51;
            this.a = 0;
            this.b = latLng;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
            this.b = null;
            this.c = 0;
            this.d = 0;
            this.e = 51;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a aVar = (a) childAt.getLayoutParams();
                        if (aVar.a == 0) {
                            b(childAt, aVar);
                        } else {
                            a(childAt, aVar);
                        }
                    } else {
                        a(childAt, new a(childAt.getLayoutParams()));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        onLayout(false, 0, 0, 0, 0);
    }

    private void a(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, aVar.width, aVar.height, iArr);
        a(view, iArr[0], iArr[1], aVar.c, aVar.d, aVar.e);
    }

    private void b(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, aVar.width, aVar.height, iArr);
        if (view instanceof ce) {
            a((ce) view, iArr, aVar.e);
        } else if (view instanceof ap) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], aVar.e);
        } else if (view instanceof p) {
            a(view, iArr[0], iArr[1], 0, 0, aVar.e);
        } else if (aVar.b != null) {
            Point point = null;
            try {
                point = this.a.d().a(new w((int) (aVar.b.latitude * 1000000.0d), (int) (aVar.b.longitude * 1000000.0d)), (Point) null);
            } catch (RemoteException e) {
                cm.a(e, "MapOverlayViewGroup", "layoutMap");
            }
            if (point != null) {
                point.x += aVar.c;
                point.y += aVar.d;
                a(view, iArr[0], iArr[1], point.x, point.y, aVar.e);
            }
        }
    }

    private void a(ce ceVar, int[] iArr, int i) {
        int b = ceVar.b();
        if (b == 1) {
            a(ceVar, iArr[0], iArr[1], getWidth() - iArr[0], (getHeight() + iArr[1]) / 2, i);
        } else if (b == 0) {
            a(ceVar, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), i);
        }
    }

    private void a(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 & 7;
        int i7 = i5 & 112;
        if (i6 == 5) {
            i3 -= i;
        } else if (i6 == 1) {
            i3 -= i / 2;
        }
        if (i7 == 80) {
            i4 -= i2;
        } else if (i7 == 16) {
            i4 -= i2 / 2;
        }
        view.layout(i3, i4, i + i3, i2 + i4);
    }
}
