package cn.bertsir.zbar.Qr;

public class ImageScanner {
    private long peer = create();

    private native long create();

    private native void destroy(long j);

    private native long getResults(long j);

    private static native void init();

    public native void enableCache(boolean z);

    public native void parseConfig(String str);

    public native int scanImage(Image image);

    public native void setConfig(int i, int i2, int i3) throws IllegalArgumentException;

    static {
        System.loadLibrary("zbar");
        init();
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

    public SymbolSet getResults() {
        return new SymbolSet(getResults(this.peer));
    }
}
