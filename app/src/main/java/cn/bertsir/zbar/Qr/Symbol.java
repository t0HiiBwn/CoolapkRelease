package cn.bertsir.zbar.Qr;

public class Symbol {
    public static final int CODABAR = 38;
    public static final int CODE128 = 128;
    public static final int CODE39 = 39;
    public static final int CODE93 = 93;
    public static final int DATABAR = 34;
    public static final int DATABAR_EXP = 35;
    public static final int EAN13 = 13;
    public static final int EAN8 = 8;
    public static final int I25 = 25;
    public static final int ISBN10 = 10;
    public static final int ISBN13 = 14;
    public static final int NONE = 0;
    public static final int PARTIAL = 1;
    public static final int PDF417 = 57;
    public static final int QRCODE = 64;
    public static final int UPCA = 12;
    public static final int UPCE = 9;
    public static int cropHeight;
    public static int cropWidth;
    public static int cropX;
    public static int cropY;
    public static boolean doubleEngine;
    public static boolean is_auto_zoom;
    public static boolean is_only_scan_center;
    public static boolean looperScan;
    public static int looperWaitTime;
    public static int scanFormat;
    public static int scanType;
    public static int screenHeight;
    public static int screenWidth;
    private long peer;
    private int type;

    private native void destroy(long j);

    private native long getComponents(long j);

    private native int getLocationSize(long j);

    private native int getLocationX(long j, int i);

    private native int getLocationY(long j, int i);

    private native int getType(long j);

    private static native void init();

    public native int getConfigMask();

    public native int getCount();

    public native String getData();

    public native byte[] getDataBytes();

    public native int getModifierMask();

    public native int getOrientation();

    public native int getQuality();

    native long next();

    static {
        System.loadLibrary("zbar");
        init();
    }

    Symbol(long j) {
        this.peer = j;
    }

    protected void finalize() {
        destroy();
    }

    public synchronized void destroy() {
        long j = this.peer;
        if (j != 0) {
            destroy(j);
            this.peer = 0;
        }
    }

    public int getType() {
        if (this.type == 0) {
            this.type = getType(this.peer);
        }
        return this.type;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0039: APUT  (r1v1 int[]), (0 ??[int, short, byte, char]), (r5v1 int) */
    public int[] getBounds() {
        int locationSize = getLocationSize(this.peer);
        if (locationSize <= 0) {
            return null;
        }
        int[] iArr = new int[4];
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < locationSize; i5++) {
            int locationX = getLocationX(this.peer, i5);
            if (i3 > locationX) {
                i3 = locationX;
            }
            if (i < locationX) {
                i = locationX;
            }
            int locationY = getLocationY(this.peer, i5);
            if (i4 > locationY) {
                i4 = locationY;
            }
            if (i2 < locationY) {
                i2 = locationY;
            }
        }
        iArr[0] = i3;
        iArr[1] = i4;
        iArr[2] = i - i3;
        iArr[3] = i2 - i4;
        return iArr;
    }

    public int[] getLocationPoint(int i) {
        return new int[]{getLocationX(this.peer, i), getLocationY(this.peer, i)};
    }

    public SymbolSet getComponents() {
        return new SymbolSet(getComponents(this.peer));
    }
}
