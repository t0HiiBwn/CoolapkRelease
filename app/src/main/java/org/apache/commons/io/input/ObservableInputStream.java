package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ObservableInputStream extends ProxyInputStream {
    private final List<Observer> observers = new ArrayList();

    public static abstract class Observer {
        void closed() throws IOException {
        }

        void data(int i) throws IOException {
        }

        void data(byte[] bArr, int i, int i2) throws IOException {
        }

        void finished() throws IOException {
        }

        void error(IOException iOException) throws IOException {
            throw iOException;
        }
    }

    public ObservableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    public void removeAllObservers() {
        this.observers.clear();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        IOException e;
        int i;
        try {
            i = super.read();
            e = null;
        } catch (IOException e2) {
            e = e2;
            i = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i == -1) {
            noteFinished();
        } else {
            noteDataByte(i);
        }
        return i;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        IOException e;
        int i;
        try {
            i = super.read(bArr);
            e = null;
        } catch (IOException e2) {
            e = e2;
            i = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i == -1) {
            noteFinished();
        } else if (i > 0) {
            noteDataBytes(bArr, 0, i);
        }
        return i;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        IOException e;
        try {
            i3 = super.read(bArr, i, i2);
            e = null;
        } catch (IOException e2) {
            e = e2;
            i3 = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i3 == -1) {
            noteFinished();
        } else if (i3 > 0) {
            noteDataBytes(bArr, i, i3);
        }
        return i3;
    }

    protected void noteDataBytes(byte[] bArr, int i, int i2) throws IOException {
        for (Observer observer : getObservers()) {
            observer.data(bArr, i, i2);
        }
    }

    protected void noteFinished() throws IOException {
        for (Observer observer : getObservers()) {
            observer.finished();
        }
    }

    protected void noteDataByte(int i) throws IOException {
        for (Observer observer : getObservers()) {
            observer.data(i);
        }
    }

    protected void noteError(IOException iOException) throws IOException {
        for (Observer observer : getObservers()) {
            observer.error(iOException);
        }
    }

    protected void noteClosed() throws IOException {
        for (Observer observer : getObservers()) {
            observer.closed();
        }
    }

    protected List<Observer> getObservers() {
        return this.observers;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        IOException e;
        try {
            super.close();
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        if (e == null) {
            noteClosed();
        } else {
            noteError(e);
        }
    }

    public void consume() throws IOException {
        do {
        } while (read(new byte[8192]) != -1);
    }
}
