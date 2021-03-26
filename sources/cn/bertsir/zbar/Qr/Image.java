package cn.bertsir.zbar.Qr;

public class Image {
    private Object data;
    private long peer;

    private native long convert(long j, String str);

    private native long create();

    private native void destroy(long j);

    private native long getSymbols(long j);

    private static native void init();

    public native int[] getCrop();

    public native byte[] getData();

    public native String getFormat();

    public native int getHeight();

    public native int getSequence();

    public native int[] getSize();

    public native int getWidth();

    public native void setCrop(int i, int i2, int i3, int i4);

    public native void setCrop(int[] iArr);

    public native void setData(byte[] bArr);

    public native void setData(int[] iArr);

    public native void setFormat(String str);

    public native void setSequence(int i);

    public native void setSize(int i, int i2);

    public native void setSize(int[] iArr);

    static {
        System.loadLibrary("zbar");
        init();
    }

    public Image() {
        this.peer = create();
    }

    public Image(int i, int i2) {
        this();
        setSize(i, i2);
    }

    public Image(int i, int i2, String str) {
        this();
        setSize(i, i2);
        setFormat(str);
    }

    public Image(String str) {
        this();
        setFormat(str);
    }

    Image(long j) {
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

    public Image convert(String str) {
        long convert = convert(this.peer, str);
        if (convert == 0) {
            return null;
        }
        return new Image(convert);
    }

    public SymbolSet getSymbols() {
        return new SymbolSet(getSymbols(this.peer));
    }
}
