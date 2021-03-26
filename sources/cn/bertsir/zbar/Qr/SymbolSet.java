package cn.bertsir.zbar.Qr;

import java.util.AbstractCollection;
import java.util.Iterator;

public class SymbolSet extends AbstractCollection<Symbol> {
    private long peer;

    private native void destroy(long j);

    private native long firstSymbol(long j);

    private static native void init();

    @Override // java.util.AbstractCollection, java.util.Collection
    public native int size();

    static {
        System.loadLibrary("zbar");
        init();
    }

    SymbolSet(long j) {
        this.peer = j;
    }

    @Override // java.lang.Object
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Symbol> iterator() {
        long firstSymbol = firstSymbol(this.peer);
        if (firstSymbol == 0) {
            return new SymbolIterator(null);
        }
        return new SymbolIterator(new Symbol(firstSymbol));
    }
}
