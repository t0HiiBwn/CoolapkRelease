package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(String str, String str2) throws IOException {
        this(new File(str), str2, false);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z) throws IOException {
        this(new File(str), str2, z);
    }

    public FileWriterWithEncoding(String str, Charset charset) throws IOException {
        this(new File(str), charset, false);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z) throws IOException {
        this(new File(str), charset, z);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) throws IOException {
        this(new File(str), charsetEncoder, false);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this(new File(str), charsetEncoder, z);
    }

    public FileWriterWithEncoding(File file, String str) throws IOException {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z) throws IOException {
        this.out = initWriter(file, str, z);
    }

    public FileWriterWithEncoding(File file, Charset charset) throws IOException {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z) throws IOException {
        this.out = initWriter(file, charset, z);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) throws IOException {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this.out = initWriter(file, charsetEncoder, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[SYNTHETIC, Splitter:B:18:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048  */
    private static Writer initWriter(File file, Object obj, boolean z) throws IOException {
        Exception e;
        Objects.requireNonNull(file, "File is missing");
        Objects.requireNonNull(obj, "Encoding is missing");
        FileOutputStream fileOutputStream = null;
        boolean exists = file.exists();
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                if (obj instanceof Charset) {
                    return new OutputStreamWriter(fileOutputStream2, (Charset) obj);
                }
                if (obj instanceof CharsetEncoder) {
                    return new OutputStreamWriter(fileOutputStream2, (CharsetEncoder) obj);
                }
                return new OutputStreamWriter(fileOutputStream2, (String) obj);
            } catch (IOException | RuntimeException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e.addSuppressed(e3);
                    }
                }
                if (!exists) {
                    FileUtils.deleteQuietly(file);
                }
                throw e;
            }
        } catch (IOException | RuntimeException e4) {
            e = e4;
            if (fileOutputStream != null) {
            }
            if (!exists) {
            }
            throw e;
        }
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.out.write(i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        this.out.write(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        this.out.write(str, i, i2);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
