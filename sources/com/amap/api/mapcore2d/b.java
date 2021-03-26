package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.mapcore2d.au;
import com.amap.api.mapcore2d.bb;
import com.amap.api.mapcore2d.bm;
import com.amap.api.mapcore2d.l;
import com.amap.api.mapcore2d.n;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.Projection;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlay;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polygon;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: AMapDelegateImpGLSurfaceView */
class b extends View implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, bb.b, bm.a, l.a, n.a, y {
    private static int aH = Color.rgb(222, 215, 214);
    private static Paint aI = null;
    private static Bitmap aJ = null;
    private d A;
    private AMap.OnMyLocationChangeListener B;
    private boolean C = true;
    private bc D;
    private cd E;
    private bk F;
    private LocationSource G;
    private p H;
    private a I = null;
    private boolean J = false;
    private boolean K = false;
    private AMap.OnCameraChangeListener L;
    private k M;
    private AMap.CancelableCallback N = null;
    private av O;
    private boolean P = false;
    private boolean Q = false;
    private View R;
    private AMap.OnInfoWindowClickListener S;
    private AMap.InfoWindowAdapter T;
    private ay U;
    private AMap.OnMarkerClickListener V;
    private Drawable W = null;
    private ah Z;
    az a;
    private float aA;
    private float aB;
    private int aC;
    private int aD;
    private long aE = 0;
    private int aF = 0;
    private int aG = 0;
    private int aK = 0;
    private boolean aL = false;
    private a aM = null;
    private boolean aa = false;
    private boolean ab = false;
    private boolean ac = false;
    private AMap.OnMarkerDragListener ad;
    private AMap.OnMapTouchListener ae;
    private AMap.OnMapLongClickListener af;
    private AMap.OnMapLoadedListener ag;
    private AMap.OnMapClickListener ah;
    private boolean ai = false;
    private AMap.OnMapScreenShotListener aj = null;
    private Timer ak = null;
    private Thread al = null;
    private TimerTask am = new TimerTask() {
        /* class com.amap.api.mapcore2d.b.AnonymousClass1 */

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.k.sendEmptyMessage(19);
            } catch (Throwable th) {
                cm.a(th, "AMapDelegateImpGLSurfaceView", "TimerTask run");
            }
        }
    };
    private Handler an = new Handler();
    private Handler ao = new Handler() {
        /* class com.amap.api.mapcore2d.b.AnonymousClass2 */
        String a = "onTouchHandler";

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (b.this.ae != null) {
                    b.this.ae.onTouch((MotionEvent) message.obj);
                }
            } catch (Throwable th) {
                cm.a(th, "AMapDelegateImpGLSurfaceView", this.a);
            }
        }
    };
    private Point ap;
    private GestureDetector aq;
    private bb.a ar;
    private ArrayList<GestureDetector.OnGestureListener> as = new ArrayList<>();
    private ArrayList<bb.b> at = new ArrayList<>();
    private Scroller au;
    private int av = 0;
    private int aw = 0;
    private Matrix ax = new Matrix();
    private float ay = 1.0f;
    private boolean az = false;
    public aq b;
    float[] c = new float[2];
    boolean d = false;
    as e = new as(this);
    ce f;
    public au g;
    protected al h;
    public bu i;
    public at j;
    final Handler k = new Handler() {
        /* class com.amap.api.mapcore2d.b.AnonymousClass3 */
        String a = "handleMessage";

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bitmap bitmap;
            Bitmap drawingCache;
            if (message != null && b.this.a != null && b.this.a.c != null) {
                try {
                    int i = message.what;
                    if (i == 2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Key验证失败：[");
                        if (message.obj != null) {
                            sb.append(message.obj);
                        } else {
                            sb.append(cr.b);
                        }
                        sb.append("]");
                        Log.w("amapsdk", sb.toString());
                    } else if (i != 13) {
                        if (i != 19) {
                            if (i != 10) {
                                if (i != 11) {
                                    switch (i) {
                                        case 15:
                                            b.this.D();
                                            return;
                                        case 16:
                                            try {
                                                Bitmap bitmap2 = (Bitmap) message.obj;
                                                if (!bitmap2.isRecycled()) {
                                                    bitmap = Bitmap.createBitmap(bitmap2);
                                                    if (bitmap != null) {
                                                        Canvas canvas = new Canvas(bitmap);
                                                        if (b.this.E != null) {
                                                            b.this.E.draw(canvas);
                                                        }
                                                        if (!(b.this.R == null || b.this.U == null || (drawingCache = b.this.R.getDrawingCache(true)) == null)) {
                                                            canvas.drawBitmap(drawingCache, (float) b.this.R.getLeft(), (float) b.this.R.getTop(), new Paint());
                                                        }
                                                        if (b.this.aj != null) {
                                                            b.this.aj.onMapScreenShot(bitmap);
                                                        }
                                                    } else if (b.this.aj != null) {
                                                        b.this.aj.onMapScreenShot(null);
                                                    }
                                                    b.this.destroyDrawingCache();
                                                    b.this.aj = null;
                                                    return;
                                                }
                                                return;
                                            } catch (Exception e) {
                                                cm.a(e, "AMapDelegateImpGLSurfaceView", this.a);
                                                bitmap = null;
                                            }
                                        case 17:
                                            CameraPosition C = b.this.C();
                                            if (b.this.L != null) {
                                                b.this.a(true, C);
                                            }
                                            if (q.h == null || q.h.trim().length() == 0) {
                                                if (C.zoom < 10.0f || cl.a(C.target.latitude, C.target.longitude)) {
                                                    b.this.E.setVisibility(0);
                                                } else {
                                                    b.this.E.setVisibility(8);
                                                }
                                            }
                                            if (b.this.N != null) {
                                                b.this.J = true;
                                                b.this.N.onFinish();
                                                b.this.J = false;
                                            }
                                            if (!b.this.K) {
                                                b.this.N = null;
                                                return;
                                            } else {
                                                b.this.K = false;
                                                return;
                                            }
                                        default:
                                            return;
                                    }
                                } else {
                                    if (b.this.ag != null) {
                                        b.this.ag.onMapLoaded();
                                    }
                                    b.this.w();
                                }
                            } else if (b.this.L != null) {
                                b.this.L.onCameraChange(new CameraPosition(b.this.E(), b.this.getZoomLevel(), 0.0f, 0.0f));
                            }
                        } else if (b.this.a != null && b.this.a.d != null) {
                            b.this.a.d.a();
                        }
                    } else if (b.this.M != null && b.this.M.g() && b.this.M.h() == 2) {
                        m a2 = m.a(new ae(b.this.M.b(), b.this.M.c()), b.this.M.d(), b.this.M.e(), b.this.M.f());
                        if (b.this.M.a()) {
                            a2.isChangeFinished = true;
                        }
                        b.this.e.a(a2);
                    }
                } catch (Throwable th) {
                    cm.a(th, "AMapDelegateImpGLSurfaceView", "handle_handleMessage");
                }
            }
        }
    };
    int l = 0;
    float m = -1.0f;
    private Context n;
    private boolean o = false;
    private boolean p = true;
    private Marker q;
    private ab r;
    private final int[] s = {10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
    private boolean t = true;
    private int u = 1;
    private CameraUpdate v;
    private long w;
    private AMap.CancelableCallback x;
    private ap y;
    private Location z;

    /* compiled from: AMapDelegateImpGLSurfaceView */
    private static abstract class a {
        public abstract void a(int i, int i2, int i3, int i4);
    }

    @Override // com.amap.api.mapcore2d.bb.b
    public boolean a(Matrix matrix) {
        return false;
    }

    @Override // com.amap.api.interfaces.IAMap
    public LatLngBounds getMapBounds() {
        return null;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public int q() {
        return 0;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setZOrderOnTop(boolean z2) throws RemoteException {
    }

    @Override // com.amap.api.mapcore2d.bm.a
    public void u() {
    }

    @Override // com.amap.api.interfaces.IAMap
    public Handler getMainHandler() {
        return this.k;
    }

    /* access modifiers changed from: private */
    public void w() {
        try {
            CameraUpdate cameraUpdate = this.v;
            if (cameraUpdate != null) {
                animateCameraWithDurationAndCallback(cameraUpdate, this.w, this.x);
                this.v = null;
                this.w = 0;
                this.x = null;
            }
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "handleUnHandleMessage");
        }
    }

    @Override // com.amap.api.mapcore2d.y
    public az a() {
        return this.a;
    }

    @Override // com.amap.api.interfaces.IAMap
    public int getMapWidth() {
        az azVar = this.a;
        if (azVar == null || azVar.c == null) {
            return 0;
        }
        return this.a.c.c();
    }

    @Override // com.amap.api.interfaces.IAMap
    public int getMapHeight() {
        az azVar = this.a;
        if (azVar == null || azVar.c == null) {
            return 0;
        }
        return this.a.c.d();
    }

    @Override // com.amap.api.interfaces.IAMap
    public View getView() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void showMyLocationOverlay(Location location) {
        if (location != null) {
            try {
                if (isMyLocationEnabled()) {
                    if (this.G != null) {
                        if (this.D == null) {
                            this.D = new bc(this, this.n);
                        }
                        if (!(this.D == null || location.getLongitude() == 0.0d || location.getLatitude() == 0.0d)) {
                            this.D.a(location);
                        }
                        AMap.OnMyLocationChangeListener onMyLocationChangeListener = this.B;
                        if (onMyLocationChangeListener != null) {
                            onMyLocationChangeListener.onMyLocationChange(location);
                        }
                        this.z = new Location(location);
                        return;
                    }
                }
                bc bcVar = this.D;
                if (bcVar != null) {
                    bcVar.a();
                }
                this.D = null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public boolean removeGLOverlay(String str) throws RemoteException {
        az azVar = this.a;
        if (azVar == null) {
            return false;
        }
        try {
            return azVar.f.b(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public boolean removeMarker(String str) {
        ab abVar;
        try {
            abVar = this.j.a(str);
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "removeMarker");
            abVar = null;
        }
        if (abVar != null) {
            return this.j.b(abVar);
        }
        return false;
    }

    public float a(float f2) {
        az azVar = this.a;
        if (azVar == null || azVar.c == null) {
            return f2;
        }
        if (f2 < ((float) this.a.c.b())) {
            f2 = (float) this.a.c.b();
        }
        return f2 > ((float) this.a.c.a()) ? (float) this.a.c.a() : f2;
    }

    @Override // com.amap.api.interfaces.IAMap
    public float getZoomLevel() {
        az azVar = this.a;
        if (azVar == null || azVar.c == null) {
            return 0.0f;
        }
        try {
            return this.a.c.e();
        } catch (Exception e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "getZoomLevel");
            return 0.0f;
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public CameraPosition getCameraPosition() throws RemoteException {
        LatLng E2 = E();
        if (E2 == null) {
            return null;
        }
        return CameraPosition.builder().target(E2).zoom(getZoomLevel()).build();
    }

    @Override // com.amap.api.interfaces.IAMap
    public float getMaxZoomLevel() {
        int i2;
        az azVar = this.a;
        if (azVar == null || azVar.c == null) {
            i2 = q.c;
        } else {
            i2 = this.a.c.a();
        }
        return (float) i2;
    }

    @Override // com.amap.api.interfaces.IAMap
    public float getMinZoomLevel() {
        int i2;
        az azVar = this.a;
        if (azVar == null || azVar.c == null) {
            i2 = q.d;
        } else {
            i2 = this.a.c.b();
        }
        return (float) i2;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            this.I.a(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            animateCameraWithCallback(cameraUpdate, null);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate != null) {
            try {
                animateCameraWithDurationAndCallback(cameraUpdate, 250, cancelableCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j2, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate != null) {
            MapCameraMessage cameraUpdateFactoryDelegate = cameraUpdate.getCameraUpdateFactoryDelegate();
            if (cameraUpdateFactoryDelegate.nowType != MapCameraMessage.Type.newLatLngBounds || cm.a(getWidth(), getHeight())) {
                aq aqVar = this.b;
                if (aqVar != null) {
                    if (cancelableCallback != null) {
                        try {
                            this.N = cancelableCallback;
                        } catch (Throwable th) {
                            cm.a(th, "AMapDelegateImpGLSurfaceView", "animateCameraWithDurationAndCallback");
                            return;
                        }
                    }
                    if (aqVar.f()) {
                        this.b.g();
                    }
                    if (cancelableCallback != null) {
                        this.N = cancelableCallback;
                    }
                    if (this.J) {
                        this.K = true;
                    }
                    if (cameraUpdateFactoryDelegate.nowType == MapCameraMessage.Type.scrollBy) {
                        r();
                        if (this.a != null && this.o) {
                            this.b.a((int) cameraUpdateFactoryDelegate.xPixel, (int) cameraUpdateFactoryDelegate.yPixel, (int) j2);
                            postInvalidate();
                        }
                    } else if (cameraUpdateFactoryDelegate.nowType == MapCameraMessage.Type.zoomIn) {
                        this.b.a((int) j2);
                    } else if (cameraUpdateFactoryDelegate.nowType == MapCameraMessage.Type.zoomOut) {
                        this.b.b((int) j2);
                    } else if (cameraUpdateFactoryDelegate.nowType == MapCameraMessage.Type.zoomTo) {
                        this.b.a(cameraUpdateFactoryDelegate.zoom, (int) j2);
                    } else if (cameraUpdateFactoryDelegate.nowType == MapCameraMessage.Type.zoomBy) {
                        float f2 = cameraUpdateFactoryDelegate.amount;
                        Point point = cameraUpdateFactoryDelegate.focus;
                        if (point == null) {
                            point = new Point(this.a.c.c() / 2, this.a.c.d() / 2);
                        }
                        a(f2, point, true, j2);
                    } else if (cameraUpdateFactoryDelegate.nowType == MapCameraMessage.Type.newCameraPosition) {
                        CameraPosition cameraPosition = cameraUpdateFactoryDelegate.cameraPosition;
                        this.b.c(cameraPosition.zoom);
                        this.b.a(new w((int) (cameraPosition.target.latitude * 1000000.0d), (int) (cameraPosition.target.longitude * 1000000.0d)), (int) j2);
                    } else if (cameraUpdateFactoryDelegate.nowType == MapCameraMessage.Type.changeCenter) {
                        CameraPosition cameraPosition2 = cameraUpdateFactoryDelegate.cameraPosition;
                        this.b.a(new w((int) (cameraPosition2.target.latitude * 1000000.0d), (int) (cameraPosition2.target.longitude * 1000000.0d)), (int) j2);
                    } else {
                        if (cameraUpdateFactoryDelegate.nowType != MapCameraMessage.Type.newLatLngBounds) {
                            if (cameraUpdateFactoryDelegate.nowType != MapCameraMessage.Type.newLatLngBoundsWithSize) {
                                cameraUpdateFactoryDelegate.isChangeFinished = true;
                                this.e.a((m) cameraUpdateFactoryDelegate);
                                return;
                            }
                        }
                        r();
                        a(cameraUpdateFactoryDelegate, true, j2);
                    }
                }
            } else {
                this.v = cameraUpdate;
                this.w = j2;
                this.x = cancelableCallback;
            }
        }
    }

    public void a(float f2, Point point, boolean z2, long j2) {
        if (this.b != null && this.a != null) {
            float zoomLevel = getZoomLevel();
            float b2 = cm.b(zoomLevel + f2);
            if (b2 - zoomLevel > 0.0f) {
                new ae();
                ae F2 = F();
                if (point != null && F2 != null) {
                    ae aeVar = new ae();
                    a(point.x, point.y, aeVar);
                    int i2 = F2.a - aeVar.a;
                    double d2 = (double) i2;
                    double d3 = (double) f2;
                    double d4 = (double) (F2.b - aeVar.b);
                    F2.a = aeVar.a + ((int) ((d2 / Math.pow(2.0d, d3)) - d2));
                    F2.b = aeVar.b + ((int) ((d4 / Math.pow(2.0d, d3)) - d4));
                    w b3 = this.a.h.b(new w((double) F2.b, (double) F2.a, false));
                    if (z2) {
                        this.b.a(b2, point.x, point.y, (int) j2);
                        return;
                    }
                    this.b.a(b3);
                    l.a().b();
                }
            }
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void stopAnimation() throws RemoteException {
        if (this.b != null) {
            if (!this.M.a()) {
                this.M.a(true);
                l.a().b();
                AMap.CancelableCallback cancelableCallback = this.N;
                if (cancelableCallback != null) {
                    cancelableCallback.onCancel();
                }
                this.N = null;
            }
            this.b.b(true);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        try {
            if (this.a == null) {
                return null;
            }
            ag a2 = a().f.a(polylineOptions);
            postInvalidate();
            if (a2 != null) {
                return new Polyline(a2);
            }
            return null;
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "addPolyline");
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        try {
            az azVar = this.a;
            if (azVar == null) {
                return null;
            }
            z a2 = azVar.f.a(circleOptions);
            postInvalidate();
            if (a2 != null) {
                return new Circle(a2);
            }
            return null;
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "addCircle");
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        try {
            az azVar = this.a;
            if (azVar == null) {
                return null;
            }
            aa a2 = azVar.f.a(groundOverlayOptions);
            postInvalidate();
            if (a2 != null) {
                return new GroundOverlay(a2);
            }
            return null;
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "addGroundOverlay");
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        try {
            az azVar = this.a;
            if (azVar != null) {
                if (azVar.f != null) {
                    af a2 = this.a.f.a(polygonOptions);
                    postInvalidate();
                    if (a2 != null) {
                        return new Polygon(a2);
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "addPolygon");
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        if (markerOptions == null) {
            return null;
        }
        try {
            ay ayVar = new ay(markerOptions, this.j);
            this.j.a(ayVar);
            postInvalidate();
            return new Marker(ayVar);
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "addMarker");
            return null;
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        if (this.a == null) {
            return null;
        }
        bt btVar = new bt(tileOverlayOptions, this.i, this.a.h, this.a, this.n);
        this.i.a(btVar);
        postInvalidate();
        return new TileOverlay(btVar);
    }

    @Override // com.amap.api.interfaces.IAMap
    public void clear() throws RemoteException {
        try {
            e();
            az azVar = this.a;
            if (azVar != null) {
                azVar.f.a();
                this.j.c();
                this.i.b();
                bc bcVar = this.D;
                if (bcVar != null) {
                    bcVar.a();
                }
                postInvalidate();
            }
        } catch (Exception e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "clear");
            Log.d("amapApi", "AMapDelegateImpGLSurfaceView clear erro" + e2.getMessage());
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "clear");
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public int getMapType() throws RemoteException {
        return this.u;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setMapType(int i2) throws RemoteException {
        if (i2 == 2) {
            this.u = 2;
            a(true);
            this.E.a(true);
        } else {
            this.u = 1;
            a(false);
            this.E.a(false);
        }
        postInvalidate();
    }

    @Override // com.amap.api.interfaces.IAMap
    public boolean isTrafficEnabled() throws RemoteException {
        return k();
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setTrafficEnabled(boolean z2) throws RemoteException {
        b(z2);
        postInvalidate();
    }

    @Override // com.amap.api.interfaces.IAMap
    public boolean isMyLocationEnabled() throws RemoteException {
        return this.C;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setMyLocationEnabled(boolean z2) throws RemoteException {
        try {
            LocationSource locationSource = this.G;
            if (locationSource == null) {
                this.y.a(false);
            } else if (z2) {
                locationSource.activate(this.A);
                this.y.a(true);
                if (this.D == null) {
                    this.D = new bc(this, this.n);
                }
            } else {
                bc bcVar = this.D;
                if (bcVar != null) {
                    bcVar.a();
                    this.D = null;
                }
                this.G.deactivate();
                this.y.a(false);
            }
            if (!z2) {
                this.h.setMyLocationButtonEnabled(z2);
            }
            this.C = z2;
        } catch (Throwable th) {
            Cdo.c(th, "AMapDelegateImpGLSurfaceView", "setMyLocationEnabled");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setMyLocationRotateAngle(float f2) throws RemoteException {
        bc bcVar = this.D;
        if (bcVar != null) {
            bcVar.a(f2);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (b() == null) {
            this.D = new bc(this, this.n);
        }
        if (this.D != null) {
            if (myLocationStyle.getInterval() < 1000) {
                myLocationStyle.interval(1000);
            }
            LocationSource locationSource = this.G;
            if (locationSource != null && (locationSource instanceof c)) {
                ((c) locationSource).a(myLocationStyle.getInterval());
                ((c) this.G).a(myLocationStyle.getMyLocationType());
            }
            this.D.a(myLocationStyle);
        }
    }

    public bc b() {
        return this.D;
    }

    @Override // com.amap.api.interfaces.IAMap
    public Location getMyLocation() throws RemoteException {
        d dVar;
        if (this.G == null || (dVar = this.A) == null) {
            return null;
        }
        return dVar.a;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setLocationSource(LocationSource locationSource) throws RemoteException {
        if (this.y != null) {
            LocationSource locationSource2 = this.G;
            if (locationSource2 != null && (locationSource2 instanceof c)) {
                locationSource2.deactivate();
            }
            this.G = locationSource;
            if (locationSource != null) {
                this.y.a(true);
            } else {
                this.y.a(false);
            }
        }
    }

    public al c() throws RemoteException {
        return this.h;
    }

    @Override // com.amap.api.mapcore2d.y
    public bh d() {
        az azVar = this.a;
        if (azVar == null) {
            return null;
        }
        return azVar.b;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        this.ah = onMapClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        this.ae = onMapTouchListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        this.af = onMapLongClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        this.V = onMarkerClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        this.ad = onMarkerDragListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        this.ag = onMapLoadedListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        this.S = onInfoWindowClickListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        this.T = infoWindowAdapter;
    }

    public void a(ab abVar) throws RemoteException {
        int i2;
        int i3;
        AMap.InfoWindowAdapter infoWindowAdapter;
        if (abVar != null) {
            if (abVar.getTitle() != null || abVar.getSnippet() != null) {
                e();
                Marker marker = new Marker(abVar);
                AMap.InfoWindowAdapter infoWindowAdapter2 = this.T;
                if (infoWindowAdapter2 != null) {
                    this.R = infoWindowAdapter2.getInfoWindow(marker);
                }
                try {
                    if (this.W == null) {
                        this.W = bd.a(this.n, "infowindow_bg2d.9.png");
                    }
                } catch (Exception e2) {
                    cm.a(e2, "AMapDelegateImpGLSurfaceView", "showInfoWindow");
                }
                if (this.R == null && (infoWindowAdapter = this.T) != null) {
                    this.R = infoWindowAdapter.getInfoContents(marker);
                }
                View view = this.R;
                if (view == null) {
                    LinearLayout linearLayout = new LinearLayout(this.n);
                    linearLayout.setBackgroundDrawable(this.W);
                    TextView textView = new TextView(this.n);
                    textView.setText(abVar.getTitle());
                    textView.setTextColor(-16777216);
                    TextView textView2 = new TextView(this.n);
                    textView2.setTextColor(-16777216);
                    textView2.setText(abVar.getSnippet());
                    linearLayout.setOrientation(1);
                    linearLayout.addView(textView);
                    linearLayout.addView(textView2);
                    this.R = linearLayout;
                } else if (view.getBackground() == null) {
                    this.R.setBackgroundDrawable(this.W);
                }
                ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
                this.R.setDrawingCacheEnabled(true);
                this.R.setDrawingCacheQuality(0);
                s b2 = abVar.b();
                if (layoutParams != null) {
                    int i4 = layoutParams.width;
                    i2 = layoutParams.height;
                    i3 = i4;
                } else {
                    i3 = -2;
                    i2 = -2;
                }
                au.a aVar = new au.a(i3, i2, abVar.getRealPosition(), (-((int) b2.a)) + (abVar.getWidth() / 2), (-((int) b2.b)) + 2, 81);
                this.U = (ay) abVar;
                au auVar = this.g;
                if (auVar != null) {
                    auVar.addView(this.R, aVar);
                }
            }
        }
    }

    public boolean b(ab abVar) {
        ay ayVar = this.U;
        if (ayVar == null || this.R == null || abVar == null) {
            return false;
        }
        return ayVar.getId().equals(abVar.getId());
    }

    public void e() {
        View view = this.R;
        if (view != null) {
            view.clearFocus();
            this.R.destroyDrawingCache();
            au auVar = this.g;
            if (auVar != null) {
                auVar.removeView(this.R);
            }
            Drawable background = this.R.getBackground();
            if (background != null) {
                background.setCallback(null);
            }
            this.R = null;
        }
        this.U = null;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void redrawInfoWindow() {
        View view = this.R;
        if (view != null && this.U != null) {
            au.a aVar = (au.a) view.getLayoutParams();
            if (aVar != null) {
                aVar.b = this.U.getRealPosition();
            }
            this.g.a();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        this.B = onMyLocationChangeListener;
    }

    @Override // com.amap.api.interfaces.IAMap
    public void showZoomControlsEnabled(boolean z2) {
        if (z2) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void showMyLocationButtonEnabled(boolean z2) {
        if (z2) {
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void showCompassEnabled(boolean z2) {
        if (z2) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void showScaleEnabled(boolean z2) {
        if (z2) {
            this.F.setVisibility(0);
            s();
            return;
        }
        this.F.a("");
        this.F.a(0);
        this.F.setVisibility(8);
    }

    @Override // com.amap.api.interfaces.IAMap
    public void destroy() {
        try {
            Timer timer = this.ak;
            if (timer != null) {
                timer.cancel();
                this.ak = null;
            }
            TimerTask timerTask = this.am;
            if (timerTask != null) {
                timerTask.cancel();
                this.am = null;
            }
            Handler handler = this.ao;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.k;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            Thread thread = this.al;
            if (thread != null) {
                thread.interrupt();
                this.al = null;
            }
            LocationSource locationSource = this.G;
            if (locationSource != null) {
                locationSource.deactivate();
                this.G = null;
            }
            n.a().b(this);
            bm.a().a(this);
            l.a().b(this);
            this.f.a();
            this.F.a();
            this.E.b();
            this.y.a();
            this.H.a();
            this.a.f.b();
            this.j.f();
            Drawable drawable = this.W;
            if (drawable != null) {
                drawable.setCallback(null);
            }
            this.g.removeAllViews();
            e();
            bu buVar = this.i;
            if (buVar != null) {
                buVar.f();
            }
            az azVar = this.a;
            if (azVar != null) {
                azVar.d.b();
                z();
            }
            this.G = null;
            this.ah = null;
            q.h = null;
            q.g = null;
            Cdo.b();
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "destroy");
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        this.aj = onMapScreenShotListener;
        this.aa = true;
    }

    @Override // com.amap.api.interfaces.IAMap
    public int getLogoPosition() {
        return this.E.a();
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setLogoPosition(int i2) {
        cd cdVar = this.E;
        if (cdVar != null) {
            cdVar.a(i2);
            this.E.postInvalidate();
            if (this.F.getVisibility() == 0) {
                this.F.postInvalidate();
            }
        }
    }

    @Override // com.amap.api.mapcore2d.y
    public void a(int i2, int i3) {
        cd cdVar = this.E;
        if (cdVar != null) {
            cdVar.a(i2, i3, getMapWidth(), getMapHeight());
            this.E.postInvalidate();
            if (this.F.getVisibility() == 0) {
                this.F.postInvalidate();
            }
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setZoomPosition(int i2) {
        ce ceVar = this.f;
        if (ceVar != null) {
            ceVar.a(i2);
            this.f.postInvalidate();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public float getScalePerPixel() {
        int width = getWidth();
        s sVar = new s();
        s sVar2 = new s();
        a(0, 0, sVar);
        a(width, 0, sVar2);
        return (float) (cm.a(new LatLng(sVar.b, sVar.a), new LatLng(sVar2.b, sVar2.a)) / ((double) width));
    }

    @Override // com.amap.api.interfaces.IAMap
    public void onResume() {
        az azVar = this.a;
        if (!(azVar == null || azVar.d == null)) {
            this.a.d.c();
        }
        bu buVar = this.i;
        if (buVar != null) {
            buVar.e();
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void onPause() {
        az azVar = this.a;
        if (!(azVar == null || azVar.d == null)) {
            this.a.d.d();
        }
        bu buVar = this.i;
        if (buVar != null) {
            buVar.d();
        }
    }

    private void x() {
        Method method;
        Method[] methods = View.class.getMethods();
        int length = methods.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                method = null;
                break;
            }
            method = methods[i2];
            if (method != null && method.getName().equals("setLayerType")) {
                break;
            }
            i2++;
        }
        if (method != null) {
            try {
                method.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(null)), null);
            } catch (Exception e2) {
                cm.a(e2, "AMapDelegateImpGLSurfaceView", "setLayerType");
            }
        }
    }

    Point f() {
        return this.E.d();
    }

    public b(Context context) {
        super(context);
        x();
        setClickable(true);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        q.b = cq.c(context);
        this.n = context;
        try {
            this.al = new g(this.n, this);
            this.Z = new bi(this);
            setBackgroundColor(Color.rgb(222, 215, 214));
            n.a().a(this);
            l.a().a(this);
            this.I = new a(this);
            this.A = new d(this);
            this.M = new k(context);
            this.i = new bu(this.n, this);
            this.a = new az(this.n, this, q.j);
            this.i.a(true);
            this.O = this.a.h;
            this.b = new aq(this.a);
            this.h = new ca(this);
            this.f = new ce(this.n, this.b, this);
            this.g = new au(this.n, this);
            this.y = new ap(this.n, this.e, this);
            this.E = new cd(this.n, this);
            this.F = new bk(this.n, this);
            this.H = new p(this.n, this.e, this);
            this.j = new at(this.n, attributeSet, this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            y();
            this.g.addView(this.i, layoutParams);
            this.g.addView(this.E, layoutParams);
            this.g.addView(this.F, layoutParams);
            this.g.addView(this.j, new au.a(layoutParams));
            this.g.addView(this.f, new au.a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 83));
            this.g.addView(this.y, new au.a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 83));
            try {
                if (!c().isMyLocationButtonEnabled()) {
                    this.y.setVisibility(8);
                }
            } catch (RemoteException e2) {
                cm.a(e2, "AMapDelegateImpGLSurfaceView", "initEnviornment");
            }
            this.H.setVisibility(8);
            this.g.addView(this.H, new au.a(-2, -2, new LatLng(0.0d, 0.0d), 0, 0, 51));
            this.D = new bc(this, this.n);
            this.f.setId(h.a);
            this.al.setName("AuthThread");
            this.al.start();
            if (this.ak == null) {
                Timer timer = new Timer();
                this.ak = timer;
                timer.schedule(this.am, 10000, 1000);
            }
            this.G = new c(this.n);
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "initEnviornment");
        }
    }

    public boolean g() {
        return this.p;
    }

    public w h() {
        az azVar = this.a;
        if (azVar == null || azVar.c == null) {
            return null;
        }
        return this.a.c.f();
    }

    public aq i() {
        return this.b;
    }

    private void y() {
        a(this.n);
        this.g.addView(this, 0, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(boolean z2) {
        if (j() != z2 && this.a != null) {
            if (!z2) {
                a().e.a(a().e.h, false);
                a().e.a(a().e.g, true);
                a().c.a(false, false);
            } else if (a().e.b(a().e.h) != null) {
                a().e.a(a().e.h, true);
                a().c.a(false, false);
            } else {
                an anVar = new an(this.O);
                anVar.q = new bv(this.a, anVar);
                anVar.j = new cb() {
                    /* class com.amap.api.mapcore2d.b.AnonymousClass4 */

                    @Override // com.amap.api.mapcore2d.cb
                    public String a(int i, int i2, int i3) {
                        return ax.a().e() + "/appmaptile?z=" + i3 + "&x=" + i + "&y=" + i2 + "&lang=zh_cn&size=1&scale=1&style=6";
                    }
                };
                anVar.b = a().e.h;
                anVar.e = true;
                anVar.a(true);
                anVar.f = true;
                anVar.c = q.c;
                anVar.d = q.d;
                a().e.a(anVar, this.n);
                a().e.a(a().e.h, true);
                a().c.a(false, false);
            }
        }
    }

    public boolean j() {
        an b2;
        az azVar = this.a;
        if (azVar == null || azVar.e == null || (b2 = a().e.b(a().e.h)) == null) {
            return false;
        }
        return b2.a();
    }

    public void b(boolean z2) {
        if (z2 != k() && this.a != null) {
            String str = a().e.i;
            if (!z2) {
                a().e.a(str, false);
                a().c.a(false, false);
            } else if (a().e.b(str) != null) {
                a().e.a(str, true);
                a().c.a(false, false);
            } else {
                an anVar = new an(this.O);
                anVar.q = new bv(this.a, anVar);
                anVar.g = true;
                anVar.i = 120000;
                anVar.j = new cb() {
                    /* class com.amap.api.mapcore2d.b.AnonymousClass5 */

                    @Override // com.amap.api.mapcore2d.cb
                    public String a(int i, int i2, int i3) {
                        return ax.a().c() + "/trafficengine/mapabc/traffictile?v=w2.61&zoom=" + (17 - i3) + "&x=" + i + "&y=" + i2;
                    }
                };
                anVar.b = str;
                anVar.e = false;
                anVar.a(true);
                anVar.f = false;
                anVar.c = 18;
                anVar.d = 9;
                a().e.a(anVar, getContext());
                a().e.a(str, true);
                a().c.a(false, false);
            }
        }
    }

    public boolean k() {
        an b2;
        if (a() == null || (b2 = a().e.b(a().e.i)) == null) {
            return false;
        }
        return b2.a();
    }

    private void z() {
        this.a.a();
        aq aqVar = this.b;
        if (aqVar != null) {
            aqVar.b(true);
            this.b.e();
        }
        this.b = null;
        this.a = null;
    }

    private void A() {
        if (this.P) {
            this.P = false;
        }
        if (this.ac) {
            this.ac = false;
            m a2 = m.a();
            a2.isChangeFinished = true;
            this.e.a(a2);
        }
        if (this.Q) {
            this.Q = false;
            m a3 = m.a();
            a3.isChangeFinished = true;
            this.e.a(a3);
        }
        this.ab = false;
        Marker marker = this.q;
        if (marker != null) {
            AMap.OnMarkerDragListener onMarkerDragListener = this.ad;
            if (onMarkerDragListener != null) {
                onMarkerDragListener.onMarkerDragEnd(marker);
            }
            this.q = null;
            this.r = null;
        }
    }

    private void a(MotionEvent motionEvent) {
        if (this.ab && this.r != null && this.q != null) {
            s sVar = new s();
            a((int) motionEvent.getX(), (int) (motionEvent.getY() - 60.0f), sVar);
            LatLng latLng = new LatLng(sVar.b, sVar.a);
            ab abVar = this.r;
            if (abVar != null && abVar.isDraggable()) {
                this.r.a(latLng);
                AMap.OnMarkerDragListener onMarkerDragListener = this.ad;
                if (onMarkerDragListener != null) {
                    onMarkerDragListener.onMarkerDrag(this.q);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.au.computeScrollOffset() || !this.au.isFinished()) {
            super.computeScroll();
            return;
        }
        int currX = this.au.getCurrX() - this.av;
        int currY = this.au.getCurrY() - this.aw;
        this.av = this.au.getCurrX();
        this.aw = this.au.getCurrY();
        w a2 = this.a.b.a(this.a.h.n.x + currX, this.a.h.n.y + currY);
        if (this.au.isFinished()) {
            l.a().b();
            if (this.L != null) {
                a(true, C());
            }
            this.a.c.a(false, false);
            return;
        }
        this.a.c.b(a2);
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        this.o = z2;
        super.setClickable(z2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        az azVar = this.a;
        if (azVar == null) {
            return true;
        }
        if (!this.o) {
            return false;
        }
        if (azVar.e.a(i2, keyEvent) || this.b.onKey(this, i2, keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        az azVar = this.a;
        if (azVar == null) {
            return true;
        }
        if (!this.o) {
            return false;
        }
        if (azVar.e.b(i2, keyEvent) || this.b.onKey(this, i2, keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!q.r || this.a == null) {
            return true;
        }
        if (!this.o) {
            return false;
        }
        if (this.ae != null) {
            this.ao.removeMessages(1);
            Message obtainMessage = this.ao.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = MotionEvent.obtain(motionEvent);
            obtainMessage.sendToTarget();
        }
        if (this.a.e.a(motionEvent)) {
            return true;
        }
        b(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a.h.a(new Point(i2 / 2, i3 / 2));
        this.a.c.a(i2, i3);
        if (!(this.b.a() == 0.0f || this.b.b() == 0.0f)) {
            aq aqVar = this.b;
            aqVar.a(aqVar.a(), this.b.b());
            this.b.a(0.0f);
            this.b.b(0.0f);
        }
        redrawInfoWindow();
        a aVar = this.aM;
        if (aVar != null) {
            aVar.a(i2, i3, i4, i5);
        }
    }

    private void a(Context context) {
        this.ap = null;
        this.aq = new GestureDetector(context, this);
        this.ar = bb.a(context, this);
        this.au = new Scroller(context);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        this.aC = displayMetrics.widthPixels;
        this.aD = displayMetrics.heightPixels;
        this.av = displayMetrics.widthPixels / 2;
        this.aw = displayMetrics.heightPixels / 2;
    }

    public bb l() {
        return this.ar;
    }

    public static int m() {
        return aH;
    }

    public static synchronized Paint n() {
        Paint paint;
        synchronized (b.class) {
            if (aI == null) {
                Paint paint2 = new Paint();
                aI = paint2;
                paint2.setColor(-7829368);
                aI.setAlpha(90);
                aI.setPathEffect(new DashPathEffect(new float[]{2.0f, 2.5f}, 1.0f));
            }
            paint = aI;
        }
        return paint;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            Paint n2 = n();
            canvas.drawColor(m());
            int width = getWidth();
            int height = getHeight();
            int i2 = width > height ? width : height;
            float left = (float) getLeft();
            float top = (float) getTop();
            for (int i3 = 0; i3 < i2; i3 += 256) {
                float f2 = (float) i3;
                canvas.drawLine(left, f2, left + ((float) getWidth()), f2, n2);
                canvas.drawLine(f2, top, f2, top + ((float) getHeight()), n2);
            }
            if (this.aa) {
                setDrawingCacheEnabled(true);
                buildDrawingCache();
                Bitmap drawingCache = getDrawingCache();
                Message obtainMessage = this.k.obtainMessage();
                obtainMessage.what = 16;
                obtainMessage.obj = drawingCache;
                this.k.sendMessage(obtainMessage);
                this.aa = false;
            }
            az azVar = this.a;
            if (!(azVar == null || azVar.c == null)) {
                this.a.c.a(getWidth(), getHeight());
            }
            az azVar2 = this.a;
            if (!(azVar2 == null || azVar2.e == null)) {
                this.a.e.a(canvas, this.ax, this.aA, this.aB);
            }
            if (!this.M.a()) {
                this.k.sendEmptyMessage(13);
            }
            if (!this.ai) {
                this.k.sendEmptyMessage(11);
                this.ai = true;
            }
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "onDraw");
        }
    }

    public void b(float f2) {
        this.ay = f2;
    }

    public float o() {
        return this.ay;
    }

    public void p() {
        this.aA = 0.0f;
        this.aB = 0.0f;
    }

    private void B() {
        Point point = this.ap;
        if (point != null) {
            int i2 = point.x - this.aF;
            int i3 = this.ap.y - this.aG;
            this.ap.x = this.aF;
            this.ap.y = this.aG;
            this.b.d(i2, i3);
        }
    }

    private void b(int i2, int i3) {
        if (this.ap != null) {
            this.aF = i2;
            this.aG = i3;
            B();
        }
    }

    private boolean b(MotionEvent motionEvent) {
        boolean z2 = false;
        try {
            z2 = this.ar.a(motionEvent, getWidth(), getHeight());
            if (!z2) {
                z2 = this.aq.onTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 1 && this.ac) {
                l.a().b();
            }
            if (motionEvent.getAction() == 2) {
                a(motionEvent);
            }
            if (motionEvent.getAction() == 1) {
                A();
            }
        } catch (Throwable th) {
            cm.a(th, "AMapDelegateImpGLSurfaceView", "handleTouch");
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public CameraPosition C() {
        w h2 = h();
        if (h2 == null) {
            return null;
        }
        return CameraPosition.fromLatLngZoom(new LatLng(((double) h2.b()) / 1000000.0d, ((double) h2.a()) / 1000000.0d), getZoomLevel());
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.ac = false;
        if (!this.aL && !this.M.a()) {
            this.M.a(true);
            AMap.CancelableCallback cancelableCallback = this.N;
            if (cancelableCallback != null) {
                cancelableCallback.onCancel();
            }
            this.N = null;
        }
        this.aL = false;
        this.aK = 0;
        Point point = this.ap;
        if (point == null) {
            this.ap = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        } else {
            point.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.ar.k && motionEvent.getEventTime() - this.ar.o >= 30) {
            postInvalidate();
            this.ac = false;
            try {
                if (!this.h.isScrollGesturesEnabled()) {
                    return true;
                }
            } catch (RemoteException e2) {
                cm.a(e2, "AMapDelegateImpGLSurfaceView", "onFling");
            }
            this.N = null;
            int i2 = this.aC;
            int i3 = this.aD;
            this.au.fling(this.av, this.aw, (((int) (-f2)) * 3) / 5, (((int) (-f3)) * 3) / 5, -i2, i2, -i3, i3);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        try {
            this.ac = false;
            if (this.af != null) {
                s sVar = new s();
                a((int) motionEvent.getX(), (int) motionEvent.getY(), sVar);
                this.af.onMapLongClick(new LatLng(sVar.b, sVar.a));
                this.P = true;
            }
            ab a2 = this.j.a(motionEvent);
            this.r = a2;
            if (a2 != null) {
                this.q = new Marker(a2);
                ab abVar = this.r;
                if (abVar != null && abVar.isDraggable()) {
                    this.r.a(a(this.r.getRealPosition()));
                    this.j.c(this.r);
                    AMap.OnMarkerDragListener onMarkerDragListener = this.ad;
                    if (onMarkerDragListener != null) {
                        onMarkerDragListener.onMarkerDragStart(this.q);
                    }
                    this.ab = true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private LatLng a(LatLng latLng) {
        ae aeVar = new ae();
        b(latLng.latitude, latLng.longitude, aeVar);
        aeVar.b -= 60;
        s sVar = new s();
        a(aeVar.a, aeVar.b, sVar);
        return new LatLng(sVar.b, sVar.a);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.ar.k && motionEvent2.getEventTime() - this.ar.o >= 30) {
            try {
                if (!this.h.isScrollGesturesEnabled()) {
                    this.ac = false;
                    return true;
                }
            } catch (RemoteException e2) {
                cm.a(e2, "AMapDelegateImpGLSurfaceView", "onScroll");
            }
            if (this.aK > 1) {
                this.ac = false;
                return true;
            }
            this.ac = true;
            b((int) motionEvent2.getX(), (int) motionEvent2.getY());
            postInvalidate();
            r();
        }
        return true;
    }

    @Override // com.amap.api.mapcore2d.bb.b
    public boolean a(float f2, float f3) {
        aq aqVar = this.b;
        if (aqVar != null) {
            aqVar.b(true);
        }
        if (this.az) {
            this.aA += f2;
            this.aB += f3;
        }
        postInvalidate();
        return this.az;
    }

    public boolean c(float f2) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "onScale");
        }
        b(f2);
        return false;
    }

    public boolean b(Matrix matrix) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "onScale");
        }
        this.ax.set(matrix);
        postInvalidate();
        return true;
    }

    @Override // com.amap.api.mapcore2d.bb.b
    public boolean a(float f2, PointF pointF) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "onScale");
        }
        az azVar = this.a;
        if (!(azVar == null || azVar.e == null)) {
            this.a.e.c = false;
        }
        r();
        a(f2, pointF, this.aA, this.aB);
        this.az = false;
        postInvalidateDelayed(8);
        this.a.a(true);
        return true;
    }

    @Override // com.amap.api.mapcore2d.bb.b
    public boolean b(float f2, PointF pointF) {
        this.az = false;
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "endScale");
        }
        l.a().b();
        return true;
    }

    @Override // com.amap.api.mapcore2d.bb.b
    public boolean a(PointF pointF) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "startScale");
        }
        try {
            if (!c().isZoomGesturesEnabled()) {
                return false;
            }
        } catch (RemoteException e3) {
            cm.a(e3, "AMapDelegateImpGLSurfaceView", "startScale");
        }
        az azVar = this.a;
        if (!(azVar == null || azVar.e == null)) {
            this.a.a(this.p);
            this.a.e.a(true);
            this.a.e.c = true;
        }
        this.az = true;
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return true;
            }
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "onDoubleTap");
        }
        if (this.t) {
            if (this.h.isZoomInByScreenCenter()) {
                this.b.c();
            } else {
                this.b.c((int) motionEvent.getX(), (int) motionEvent.getY());
            }
        }
        if (this.aK > 1) {
            return true;
        }
        this.aL = true;
        az azVar = this.a;
        if (!(azVar == null || azVar.c == null)) {
            this.f.a(this.a.c.e() + 1.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        az azVar;
        LatLng realPosition;
        if (this.b == null || (azVar = this.a) == null) {
            return false;
        }
        azVar.e.b(motionEvent);
        Iterator<GestureDetector.OnGestureListener> it2 = this.as.iterator();
        while (it2.hasNext()) {
            it2.next().onSingleTapUp(motionEvent);
        }
        this.ac = false;
        if (this.P) {
            this.P = false;
            return true;
        }
        try {
            if (this.R != null) {
                if (this.j.a(new Rect(this.R.getLeft(), this.R.getTop(), this.R.getRight(), this.R.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY()) && this.S != null) {
                    ab e2 = this.j.e();
                    if (!e2.isVisible()) {
                        return true;
                    }
                    this.S.onInfoWindowClick(new Marker(e2));
                    return true;
                }
            }
            if (this.j.b(motionEvent)) {
                ab e3 = this.j.e();
                if (e3 != null) {
                    if (e3.isVisible()) {
                        Marker marker = new Marker(e3);
                        AMap.OnMarkerClickListener onMarkerClickListener = this.V;
                        if (onMarkerClickListener != null) {
                            if (onMarkerClickListener.onMarkerClick(marker) || this.j.b() <= 0) {
                                this.j.c(e3);
                                return true;
                            }
                            try {
                                if (!(this.j.e() == null || e3.isViewMode() || (realPosition = e3.getRealPosition()) == null)) {
                                    this.b.a(cm.a(realPosition));
                                    l.a().b();
                                }
                            } catch (Throwable th) {
                                cm.a(th, "AMapDelegateImpGLSurfaceView", "onSingleTapConfirmed");
                            }
                        }
                        a(e3);
                        this.j.c(e3);
                    }
                }
                return true;
            }
            if (this.ah != null) {
                s sVar = new s();
                a((int) motionEvent.getX(), (int) motionEvent.getY(), sVar);
                this.ah.onMapClick(new LatLng(sVar.b, sVar.a));
            }
            return true;
        } catch (Throwable th2) {
            cm.a(th2, "AMapDelegateImpGLSurfaceView", "onSingleTapConfirmed");
            return true;
        }
    }

    private void a(float f2, PointF pointF, float f3, float f4) {
        try {
            if (!this.h.isZoomGesturesEnabled()) {
                return;
            }
        } catch (RemoteException e2) {
            cm.a(e2, "AMapDelegateImpGLSurfaceView", "doScale");
        }
        az azVar = this.a;
        if (azVar != null && azVar.c != null) {
            this.aK = 2;
            int c2 = this.a.c.c() / 2;
            int d2 = this.a.c.d() / 2;
            float a2 = a((float) (((double) this.a.c.e()) + (Math.log((double) f2) / Math.log(2.0d))));
            if (a2 != this.a.c.e()) {
                float[] fArr = this.c;
                fArr[0] = fArr[1];
                fArr[1] = a2;
                if (fArr[0] != fArr[1]) {
                    w a3 = this.a.b.a(c2, d2);
                    this.a.c.a(a2);
                    this.a.c.a(a3);
                    D();
                }
            }
        }
    }

    protected PointF b(PointF pointF) {
        PointF pointF2 = new PointF();
        int width = getWidth();
        int height = getHeight();
        int i2 = width >> 1;
        float f2 = pointF.x - ((float) i2);
        int i3 = height >> 1;
        double d2 = (double) (pointF.y - ((float) i3));
        double d3 = (double) f2;
        double atan2 = Math.atan2(d2, d3);
        double sqrt = Math.sqrt(Math.pow(d3, 2.0d) + Math.pow(d2, 2.0d));
        double q2 = atan2 - ((((double) q()) * 3.141592653589793d) / 180.0d);
        pointF2.x = (float) ((Math.cos(q2) * sqrt) + ((double) i2));
        pointF2.y = (float) ((sqrt * Math.sin(q2)) + ((double) i3));
        return pointF2;
    }

    protected PointF c(PointF pointF) {
        PointF pointF2 = new PointF();
        int width = getWidth();
        int height = getHeight();
        int i2 = width >> 1;
        float f2 = pointF.x - ((float) i2);
        int i3 = height >> 1;
        double d2 = (double) (pointF.y - ((float) i3));
        double d3 = (double) f2;
        double atan2 = Math.atan2(d2, d3);
        double sqrt = Math.sqrt(Math.pow(d3, 2.0d) + Math.pow(d2, 2.0d));
        double q2 = atan2 + ((((double) q()) * 3.141592653589793d) / 180.0d);
        pointF2.x = (float) ((Math.cos(q2) * sqrt) + ((double) i2));
        pointF2.y = (float) ((sqrt * Math.sin(q2)) + ((double) i3));
        return pointF2;
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, CameraPosition cameraPosition) {
        if (this.L != null && this.M.a() && isEnabled()) {
            if (cameraPosition == null) {
                try {
                    cameraPosition = getCameraPosition();
                } catch (RemoteException e2) {
                    cm.a(e2, "AMapDelegateImpGLSurfaceView", "cameraChangeFinish");
                }
            }
            try {
                this.L.onCameraChangeFinish(cameraPosition);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        this.L = onCameraChangeListener;
    }

    protected void r() {
        this.k.sendEmptyMessage(10);
    }

    @Override // com.amap.api.interfaces.IAMap
    public AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        return this.L;
    }

    void s() {
        this.k.sendEmptyMessage(15);
    }

    /* access modifiers changed from: private */
    public void D() {
        if (this.F != null) {
            if (this.m == -1.0f) {
                int width = getWidth();
                int height = getHeight();
                int i2 = this.n.getResources().getDisplayMetrics().densityDpi;
                int i3 = 50;
                if (i2 > 120) {
                    if (i2 <= 160) {
                        if (Math.max(width, height) <= 480) {
                            i3 = 120;
                        }
                    } else if (i2 <= 240) {
                        i3 = Math.min(width, height) >= 1000 ? 60 : 70;
                    } else if (i2 > 320 && i2 > 480) {
                        i3 = 40;
                    }
                    this.m = ((float) i3) / 100.0f;
                }
                i3 = 100;
                this.m = ((float) i3) / 100.0f;
            }
            LatLng E2 = E();
            if (E2 != null) {
                float zoomLevel = getZoomLevel();
                float f2 = this.m;
                double cos = (double) ((float) ((((Math.cos((E2.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) zoomLevel) * 256.0d)));
                int[] iArr = this.s;
                int i4 = (int) zoomLevel;
                String a2 = cm.a(iArr[i4]);
                this.F.a((int) (((double) iArr[i4]) / (cos * ((double) f2))));
                this.F.a(a2);
                this.F.postInvalidate();
            }
        }
    }

    @Override // com.amap.api.mapcore2d.y
    public void a(int i2, int i3, s sVar) {
        PointF pointF = new PointF((float) i2, (float) i3);
        av avVar = this.O;
        w a2 = avVar.a(pointF, avVar.l, this.O.n, this.O.k, this.O.o);
        if (sVar != null) {
            double a3 = r.a((long) a2.b());
            double a4 = r.a((long) a2.a());
            sVar.b = a3;
            sVar.a = a4;
        }
    }

    private void a(int i2, int i3, ae aeVar) {
        getZoomLevel();
        PointF pointF = new PointF((float) i2, (float) i3);
        av avVar = this.O;
        w a2 = avVar.a(pointF, avVar.l, this.O.n, this.O.k, this.O.o);
        if (aeVar != null) {
            aeVar.a = (int) a2.e();
            aeVar.b = (int) a2.f();
        }
    }

    @Override // com.amap.api.mapcore2d.y
    public void a(double d2, double d3, s sVar) {
        getZoomLevel();
        w wVar = new w((int) r.a(d2), (int) r.a(d3));
        av avVar = this.O;
        PointF b2 = avVar.b(wVar, avVar.l, this.O.n, this.O.k);
        if (sVar != null) {
            sVar.a = (double) b2.x;
            sVar.b = (double) b2.y;
        }
    }

    @Override // com.amap.api.mapcore2d.y
    public void a(double d2, double d3, ae aeVar) {
        av avVar = this.O;
        if (avVar != null) {
            w b2 = avVar.b(new w((int) (d2 * 1000000.0d), (int) (d3 * 1000000.0d)));
            aeVar.a = b2.a();
            aeVar.b = b2.b();
        }
    }

    @Override // com.amap.api.mapcore2d.y
    public void b(int i2, int i3, s sVar) {
        if (sVar != null) {
            sVar.a = r.a((long) i2);
            sVar.b = r.a((long) i3);
        }
    }

    @Override // com.amap.api.mapcore2d.y
    public void b(double d2, double d3, ae aeVar) {
        if (this.O != null) {
            getZoomLevel();
            w wVar = new w((int) r.a(d2), (int) r.a(d3));
            av avVar = this.O;
            PointF b2 = avVar.b(wVar, avVar.l, this.O.n, this.O.k);
            if (aeVar != null) {
                aeVar.a = (int) b2.x;
                aeVar.b = (int) b2.y;
            }
        }
    }

    /* access modifiers changed from: private */
    public LatLng E() {
        w h2 = h();
        if (h2 == null) {
            return null;
        }
        return new LatLng(r.a((long) h2.b()), r.a((long) h2.a()));
    }

    private ae F() {
        w h2 = h();
        if (h2 == null) {
            return null;
        }
        ae aeVar = new ae();
        aeVar.a = (int) h2.e();
        aeVar.b = (int) h2.f();
        return aeVar;
    }

    @Override // com.amap.api.mapcore2d.n.a
    public void t() {
        AMap.CancelableCallback cancelableCallback = this.N;
        if (cancelableCallback != null) {
            cancelableCallback.onCancel();
            this.N = null;
        }
    }

    @Override // com.amap.api.mapcore2d.l.a
    public void v() {
        this.k.sendEmptyMessage(17);
    }

    @Override // com.amap.api.interfaces.IAMap
    public void AMapInvalidate() {
        postInvalidate();
        this.g.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IAMap
    public List<Marker> getMapScreenMarkers() {
        if (!cm.a(getWidth(), getHeight())) {
            return new ArrayList();
        }
        return this.j.g();
    }

    protected void a(MapCameraMessage mapCameraMessage, boolean z2, long j2) {
        float f2;
        int i2;
        int i3;
        if (this.b != null) {
            try {
                LatLngBounds latLngBounds = mapCameraMessage.bounds;
                if (latLngBounds != null && latLngBounds.northeast != null) {
                    if (latLngBounds.southwest != null) {
                        if (mapCameraMessage.width == 0) {
                            mapCameraMessage.width = this.a.c.c();
                        }
                        if (mapCameraMessage.height == 0) {
                            mapCameraMessage.height = this.a.c.d();
                        }
                        float f3 = (float) ((latLngBounds.northeast.latitude * 1000000.0d) - (latLngBounds.southwest.latitude * 1000000.0d));
                        float f4 = (float) ((latLngBounds.northeast.longitude * 1000000.0d) - (latLngBounds.southwest.longitude * 1000000.0d));
                        float f5 = f3 == 0.0f ? 1.0f : f3;
                        float f6 = f4 == 0.0f ? 1.0f : f4;
                        Pair<Float, Boolean> a2 = this.b.a(f5, f6, mapCameraMessage.width, mapCameraMessage.height, mapCameraMessage.paddingLeft + mapCameraMessage.paddingRight, mapCameraMessage.paddingTop + mapCameraMessage.paddingBottom);
                        if (a2 != null) {
                            f2 = ((Float) a2.first).floatValue();
                            ((Boolean) a2.second).booleanValue();
                            ae aeVar = new ae();
                            b(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, aeVar);
                            ae aeVar2 = new ae();
                            b(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, aeVar2);
                            int abs = Math.abs(aeVar.a - aeVar2.a);
                            int abs2 = Math.abs(aeVar2.b - aeVar.b);
                            if (abs2 == 0) {
                                abs2 = 1;
                            }
                            if (abs == 0) {
                                abs = 1;
                            }
                            int a3 = (int) a(getZoomLevel(), f2, (double) abs);
                            int a4 = (int) a(getZoomLevel(), f2, (double) abs2);
                            i2 = (int) ((latLngBounds.southwest.latitude * 1000000.0d) + ((double) ((((float) ((mapCameraMessage.paddingTop - mapCameraMessage.paddingBottom) + a4)) * f5) / ((float) (a4 * 2)))));
                            i3 = (int) ((latLngBounds.southwest.longitude * 1000000.0d) + ((double) ((((float) ((mapCameraMessage.paddingRight - mapCameraMessage.paddingLeft) + a3)) * f6) / ((float) (a3 * 2)))));
                        } else {
                            i2 = (int) (((latLngBounds.northeast.latitude * 1000000.0d) + (latLngBounds.southwest.latitude * 1000000.0d)) / 2.0d);
                            i3 = (int) (((latLngBounds.northeast.longitude * 1000000.0d) + (latLngBounds.southwest.longitude * 1000000.0d)) / 2.0d);
                            f2 = -1.0f;
                        }
                        w wVar = new w(i2, i3);
                        if (z2) {
                            this.b.a(wVar, (int) j2);
                        } else {
                            this.b.a(wVar);
                        }
                        if (f2 != -1.0f) {
                            this.b.c(f2);
                        }
                    }
                }
            } catch (Exception e2) {
                cm.a(e2, "AMapDelegateImpGLSurfaceView", "newLatLngBoundsWithSize");
            }
        }
    }

    private static float a(float f2, float f3, double d2) {
        return (float) (d2 / Math.pow(2.0d, (double) (f2 - f3)));
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setMapLanguage(String str) throws RemoteException {
        az azVar = this.a;
        if (azVar != null && azVar.e != null && !j()) {
            this.a.e.a(str);
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public void removecache() {
        removecache(null);
    }

    @Override // com.amap.api.interfaces.IAMap
    public void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) {
        if (this.an != null) {
            try {
                RunnableC0017b bVar = new RunnableC0017b(this.n, onCacheRemoveListener);
                this.an.removeCallbacks(bVar);
                this.an.post(bVar);
            } catch (Throwable th) {
                Cdo.c(th, "AMapDelegateImpGLSurfaceView", "removecache");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore2d.b$b  reason: collision with other inner class name */
    /* compiled from: AMapDelegateImpGLSurfaceView */
    private class RunnableC0017b implements Runnable {
        private Context b;
        private AMap.OnCacheRemoveListener c;

        public RunnableC0017b(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cm.a(new File(cm.b(this.b)));
                try {
                    AMap.OnCacheRemoveListener onCacheRemoveListener = this.c;
                    if (onCacheRemoveListener != null) {
                        onCacheRemoveListener.onRemoveCacheFinish(true);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                try {
                    AMap.OnCacheRemoveListener onCacheRemoveListener2 = this.c;
                    if (onCacheRemoveListener2 != null) {
                        onCacheRemoveListener2.onRemoveCacheFinish(true);
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                throw th2;
            }
        }
    }

    @Override // com.amap.api.interfaces.IAMap
    public Text addText(TextOptions textOptions) throws RemoteException {
        bp bpVar = new bp(this, textOptions, this.j);
        this.j.a(bpVar);
        postInvalidate();
        return new Text(bpVar);
    }

    @Override // com.amap.api.interfaces.IAMap
    public UiSettings getAMapUiSettings() throws RemoteException {
        return new UiSettings(this.h);
    }

    @Override // com.amap.api.interfaces.IAMap
    public Projection getAMapProjection() throws RemoteException {
        return new Projection(this.Z);
    }

    @Override // com.amap.api.interfaces.IAMap
    public void setMyLocationType(int i2) {
        bc bcVar = this.D;
        if (bcVar != null) {
            bcVar.a(i2);
        }
    }
}
