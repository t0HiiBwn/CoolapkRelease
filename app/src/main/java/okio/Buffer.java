package okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import okio.internal.BufferKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 4, 0})
/* compiled from: Buffer.kt */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return buffer.copyTo(buffer2, j, j2);
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0, 0, 6, (Object) null);
    }

    public final Buffer copyTo(OutputStream outputStream, long j) throws IOException {
        return copyTo$default(this, outputStream, j, 0, 4, (Object) null);
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0, 2, null);
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new Buffer$outputStream$1(this);
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new Buffer$inputStream$1(this);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j, long j2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            j2 = buffer.size - j;
        }
        return buffer.copyTo(outputStream, j, j2);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            Intrinsics.checkNotNull(segment);
            if (j < ((long) (segment.limit - segment.pos))) {
                break;
            }
            j -= (long) (segment.limit - segment.pos);
            segment = segment.next;
        }
        while (j2 > 0) {
            Intrinsics.checkNotNull(segment);
            int i = (int) (((long) segment.pos) + j);
            int min = (int) Math.min((long) (segment.limit - i), j2);
            outputStream.write(segment.data, i, min);
            j2 -= (long) min;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    public final Buffer copyTo(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        return copyTo(buffer, j, this.size - j);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        Util.checkOffsetAndCount(this.size, 0, j);
        Segment segment = this.head;
        while (j > 0) {
            Intrinsics.checkNotNull(segment);
            int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j2 = (long) min;
            this.size -= j2;
            j -= j2;
            if (segment.pos == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    private final void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        while (true) {
            if (j > 0 || z) {
                Segment writableSegment$okio = writableSegment$okio(1);
                int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j, (long) (8192 - writableSegment$okio.limit)));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        this.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (!z) {
                        throw new EOFException();
                    }
                    return;
                }
                writableSegment$okio.limit += read;
                long j2 = (long) read;
                this.size += j2;
                j -= j2;
            } else {
                return;
            }
        }
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (this.size < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            if (((long) segment.pos) + j > ((long) segment.limit)) {
                return new String(readByteArray(j), charset);
            }
            int i2 = (int) j;
            String str = new String(segment.data, segment.pos, i2, charset);
            segment.pos += i2;
            this.size -= j;
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= (long) min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        Intrinsics.checkNotNullParameter(str, "string");
        return writeUtf8(str, 0, str.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
                } else if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
                    return writeUtf8(str, i, i2);
                } else {
                    String substring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                    byte[] bytes = substring.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    return write(bytes, 0, bytes.length);
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i -= min;
            writableSegment$okio.limit += min;
        }
        this.size += (long) remaining;
        return remaining;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i) {
        return writeShort((int) Util.reverseBytes((short) i));
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i) {
        return writeInt(Util.reverseBytes(i));
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytes(j));
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return indexOf(byteString, 0);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        return indexOfElement(byteString, 0);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private final ByteString digest(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            instance.update(segment.data, segment.pos, segment.limit - segment.pos);
            Segment segment2 = segment.next;
            Intrinsics.checkNotNull(segment2);
            while (segment2 != segment) {
                instance.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
            }
        }
        byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    public final ByteString hmacSha1(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return hmac("HmacSHA512", byteString);
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                instance.update(segment.data, segment.pos, segment.limit - segment.pos);
                Segment segment2 = segment.next;
                Intrinsics.checkNotNull(segment2);
                while (segment2 != segment) {
                    instance.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    Intrinsics.checkNotNull(segment2);
                }
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return snapshot().toString();
    }

    @Override // java.lang.Object
    public Buffer clone() {
        return copy();
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = new UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m2335deprecated_getByte(long j) {
        return getByte(j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m2336deprecated_size() {
        return this.size;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Buffer.kt */
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public final int next() {
            long j = this.offset;
            Buffer buffer2 = this.buffer;
            Intrinsics.checkNotNull(buffer2);
            if (j != buffer2.size()) {
                long j2 = this.offset;
                return seek(j2 == -1 ? 0 : j2 + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final int seek(long j) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (j < ((long) -1) || j > buffer2.size()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(buffer2.size())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                throw new ArrayIndexOutOfBoundsException(format);
            } else if (j == -1 || j == buffer2.size()) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            } else {
                long j2 = 0;
                long size = buffer2.size();
                Segment segment2 = buffer2.head;
                Segment segment3 = buffer2.head;
                Segment segment4 = this.segment;
                if (segment4 != null) {
                    long j3 = this.offset;
                    int i = this.start;
                    Intrinsics.checkNotNull(segment4);
                    long j4 = j3 - ((long) (i - segment4.pos));
                    if (j4 > j) {
                        segment3 = this.segment;
                        size = j4;
                    } else {
                        segment2 = this.segment;
                        j2 = j4;
                    }
                }
                if (size - j > j - j2) {
                    while (true) {
                        Intrinsics.checkNotNull(segment2);
                        if (j < ((long) (segment2.limit - segment2.pos)) + j2) {
                            break;
                        }
                        j2 += (long) (segment2.limit - segment2.pos);
                        segment2 = segment2.next;
                    }
                } else {
                    while (size > j) {
                        Intrinsics.checkNotNull(segment3);
                        segment3 = segment3.prev;
                        Intrinsics.checkNotNull(segment3);
                        size -= (long) (segment3.limit - segment3.pos);
                    }
                    j2 = size;
                    segment2 = segment3;
                }
                if (this.readWrite) {
                    Intrinsics.checkNotNull(segment2);
                    if (segment2.shared) {
                        Segment unsharedCopy = segment2.unsharedCopy();
                        if (buffer2.head == segment2) {
                            buffer2.head = unsharedCopy;
                        }
                        segment2 = segment2.push(unsharedCopy);
                        Segment segment5 = segment2.prev;
                        Intrinsics.checkNotNull(segment5);
                        segment5.pop();
                    }
                }
                this.segment = segment2;
                this.offset = j;
                Intrinsics.checkNotNull(segment2);
                this.data = segment2.data;
                this.start = segment2.pos + ((int) (j - j2));
                int i2 = segment2.limit;
                this.end = i2;
                return i2 - this.start;
            }
        }

        public final long resizeBuffer(long j) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.readWrite) {
                long size = buffer2.size();
                int i = 1;
                int i2 = (j > size ? 1 : (j == size ? 0 : -1));
                if (i2 <= 0) {
                    if (j >= 0) {
                        long j2 = size - j;
                        while (true) {
                            if (j2 <= 0) {
                                break;
                            }
                            Segment segment2 = buffer2.head;
                            Intrinsics.checkNotNull(segment2);
                            Segment segment3 = segment2.prev;
                            Intrinsics.checkNotNull(segment3);
                            long j3 = (long) (segment3.limit - segment3.pos);
                            if (j3 > j2) {
                                segment3.limit -= (int) j2;
                                break;
                            }
                            buffer2.head = segment3.pop();
                            SegmentPool.recycle(segment3);
                            j2 -= j3;
                        }
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                    }
                } else if (i2 > 0) {
                    long j4 = j - size;
                    boolean z = true;
                    while (j4 > 0) {
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i);
                        int min = (int) Math.min(j4, (long) (8192 - writableSegment$okio.limit));
                        writableSegment$okio.limit += min;
                        j4 -= (long) min;
                        if (z) {
                            this.segment = writableSegment$okio;
                            this.offset = size;
                            this.data = writableSegment$okio.data;
                            this.start = writableSegment$okio.limit - min;
                            this.end = writableSegment$okio.limit;
                            z = false;
                        }
                        i = 1;
                    }
                }
                buffer2.setSize$okio(j);
                return size;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final long expandBuffer(int i) {
            boolean z = true;
            if (i > 0) {
                if (i > 8192) {
                    z = false;
                }
                if (z) {
                    Buffer buffer2 = this.buffer;
                    if (buffer2 == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.readWrite) {
                        long size = buffer2.size();
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i);
                        int i2 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j = (long) i2;
                        buffer2.setSize$okio(size + j);
                        this.segment = writableSegment$okio;
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = 8192 - i2;
                        this.end = 8192;
                        return j;
                    } else {
                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }
                } else {
                    throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i).toString());
                }
            } else {
                throw new IllegalArgumentException(("minByteCount <= 0: " + i).toString());
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        Util.checkOffsetAndCount(size(), j, j2);
        if (j2 != 0) {
            buffer.setSize$okio(buffer.size() + j2);
            Segment segment = this.head;
            while (true) {
                Intrinsics.checkNotNull(segment);
                if (j < ((long) (segment.limit - segment.pos))) {
                    break;
                }
                j -= (long) (segment.limit - segment.pos);
                segment = segment.next;
            }
            while (j2 > 0) {
                Intrinsics.checkNotNull(segment);
                Segment sharedCopy = segment.sharedCopy();
                sharedCopy.pos += (int) j;
                sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j2), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy.prev;
                    buffer.head = sharedCopy.next;
                } else {
                    Intrinsics.checkNotNull(segment2);
                    Segment segment3 = segment2.prev;
                    Intrinsics.checkNotNull(segment3);
                    segment3.push(sharedCopy);
                }
                j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j = 0;
            }
        }
        return this;
    }

    public final long completeSegmentByteCount() {
        long size2 = size();
        if (size2 == 0) {
            return 0;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        if (segment2.limit < 8192 && segment2.owner) {
            size2 -= (long) (segment2.limit - segment2.pos);
        }
        return size2;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            setSize$okio(size() - 1);
            if (i3 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    public final byte getByte(long j) {
        Util.checkOffsetAndCount(size(), j, 1);
        Segment segment = this.head;
        if (segment == null) {
            Segment segment2 = null;
            Intrinsics.checkNotNull(segment2);
            return segment2.data[(int) ((((long) segment2.pos) + j) - -1)];
        } else if (size() - j < j) {
            long size2 = size();
            while (size2 > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j) - size2)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((((long) segment.pos) + j) - j2)];
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
        }
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            setSize$okio(size() - 2);
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) i5;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            setSize$okio(size() - 4);
            if (i8 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return i9;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
            int i6 = i5 + 1;
            long j2 = ((((long) bArr[i5]) & 255) << 32) | j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j3 = j2 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j4 = j3 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            setSize$okio(size() - 8);
            if (i10 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return j4;
        }
        throw new EOFException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r1 = new okio.Buffer().writeDecimalLong(r3).writeByte((int) r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (r6 != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        Segment segment;
        byte b;
        boolean z;
        long j = 0;
        if (size() != 0) {
            long j2 = -7;
            int i = 0;
            boolean z2 = false;
            boolean z3 = false;
            loop0:
            do {
                Segment segment2 = this.head;
                Intrinsics.checkNotNull(segment2);
                byte[] bArr = segment2.data;
                int i2 = segment2.pos;
                int i3 = segment2.limit;
                while (true) {
                    if (i2 >= i3) {
                        segment = segment2;
                        break;
                    }
                    b = bArr[i2];
                    byte b2 = (byte) 48;
                    if (b >= b2 && b <= ((byte) 57)) {
                        int i4 = b2 - b;
                        int i5 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                        if (i5 < 0) {
                            break loop0;
                        }
                        z = z3;
                        segment = segment2;
                        if (i5 == 0 && ((long) i4) < j2) {
                            break loop0;
                        }
                        j = (j * 10) + ((long) i4);
                    } else {
                        z = z3;
                        segment = segment2;
                        if (b != ((byte) 45) || i != 0) {
                            break;
                        }
                        j2--;
                        z2 = true;
                    }
                    i2++;
                    i++;
                    z3 = z;
                    segment2 = segment;
                }
                if (i != 0) {
                    z3 = true;
                    if (i2 == i3) {
                        this.head = segment.pop();
                        SegmentPool.recycle(segment);
                    } else {
                        segment.pos = i2;
                    }
                    if (z3) {
                        break;
                    }
                } else {
                    throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Util.toHexString(b));
                }
            } while (this.head != null);
            setSize$okio(size() - ((long) i));
            return z2 ? j : -j;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        byte b;
        int i;
        if (size() != 0) {
            int i2 = 0;
            long j = 0;
            boolean z = false;
            do {
                Segment segment = this.head;
                Intrinsics.checkNotNull(segment);
                byte[] bArr = segment.data;
                int i3 = segment.pos;
                int i4 = segment.limit;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    b = bArr[i3];
                    byte b2 = (byte) 48;
                    if (b < b2 || b > ((byte) 57)) {
                        byte b3 = (byte) 97;
                        if ((b < b3 || b > ((byte) 102)) && (b < (b3 = (byte) 65) || b > ((byte) 70))) {
                            break;
                        }
                        i = (b - b3) + 10;
                    } else {
                        i = b - b2;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i3++;
                        i2++;
                    } else {
                        Buffer writeByte = new Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b);
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                }
                if (i2 != 0) {
                    z = true;
                    if (i3 == i4) {
                        this.head = segment.pop();
                        SegmentPool.recycle(segment);
                    } else {
                        segment.pos = i3;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Util.toHexString(b));
                }
            } while (this.head != null);
            setSize$okio(size() - ((long) i2));
            return j;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (size() < j) {
            throw new EOFException();
        } else if (j < ((long) 4096)) {
            return new ByteString(readByteArray(j));
        } else {
            ByteString snapshot = snapshot((int) j);
            skip(j);
            return snapshot;
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (size() >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size2 = size();
        if (size2 > 0) {
            sink.write(this, size2);
        }
        return size2;
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long indexOf = indexOf(b, 0, j2);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(this, indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == ((byte) 13) && getByte(j2) == b) {
                return BufferKt.readUtf8Line(this, j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j).toString());
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (size() != 0) {
            byte b = getByte(0);
            if ((b & 128) == 0) {
                i3 = b & Byte.MAX_VALUE;
                i2 = 1;
                i = 0;
            } else if ((b & 224) == 192) {
                i3 = b & 31;
                i2 = 2;
                i = 128;
            } else if ((b & 240) == 224) {
                i3 = b & 15;
                i2 = 3;
                i = 2048;
            } else if ((b & 248) == 240) {
                i3 = b & 7;
                i2 = 4;
                i = 65536;
            } else {
                skip(1);
                return 65533;
            }
            long j = (long) i2;
            if (size() >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = (long) i4;
                    byte b2 = getByte(j2);
                    if ((b2 & 192) == 128) {
                        i3 = (i3 << 6) | (b2 & 63);
                    } else {
                        skip(j2);
                        return 65533;
                    }
                }
                skip(j);
                if (i3 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i3 && 57343 >= i3) || i3 < i) {
                    return 65533;
                }
                return i3;
            }
            throw new EOFException("size < " + i2 + ": " + size() + " (to read code point prefixed 0x" + Util.toHexString(b) + ')');
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        } else if (size() >= j) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "sink");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        ArraysKt.copyInto(segment.data, bArr, i, segment.pos, segment.pos + min);
        segment.pos += min;
        setSize$okio(size() - ((long) min));
        if (segment.pos != segment.limit) {
            return min;
        }
        this.head = segment.pop();
        SegmentPool.recycle(segment);
        return min;
    }

    public final void clear() {
        skip(size());
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                setSize$okio(size() - j2);
                j -= j2;
                segment.pos += min;
                if (segment.pos == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, i, i2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i, int i2) {
        int i3;
        char c;
        Intrinsics.checkNotNullParameter(str, "string");
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            Segment writableSegment$okio = writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i4 = writableSegment$okio.limit - i;
                            int min = Math.min(i2, 8192 - i4);
                            i3 = i + 1;
                            bArr[i + i4] = (byte) charAt;
                            while (i3 < min) {
                                char charAt2 = str.charAt(i3);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                bArr[i3 + i4] = (byte) charAt2;
                                i3++;
                            }
                            int i5 = (i4 + i3) - writableSegment$okio.limit;
                            writableSegment$okio.limit += i5;
                            setSize$okio(size() + ((long) i5));
                        } else {
                            if (charAt < 2048) {
                                Segment writableSegment$okio2 = writableSegment$okio(2);
                                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((charAt >> 6) | 192);
                                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio2.limit += 2;
                                setSize$okio(size() + 2);
                            } else if (charAt < 55296 || charAt > 57343) {
                                Segment writableSegment$okio3 = writableSegment$okio(3);
                                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((charAt >> '\f') | 224);
                                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) ((charAt & '?') | 128);
                                writableSegment$okio3.limit += 3;
                                setSize$okio(size() + 3);
                            } else {
                                i3 = i + 1;
                                if (i3 < i2) {
                                    c = str.charAt(i3);
                                } else {
                                    c = 0;
                                }
                                if (charAt > 56319 || 56320 > c || 57343 < c) {
                                    writeByte(63);
                                } else {
                                    int i6 = (((charAt & 1023) << 10) | (c & 1023)) + 65536;
                                    Segment writableSegment$okio4 = writableSegment$okio(4);
                                    writableSegment$okio4.data[writableSegment$okio4.limit] = (byte) ((i6 >> 18) | 240);
                                    writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte) (((i6 >> 12) & 63) | 128);
                                    writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte) (((i6 >> 6) & 63) | 128);
                                    writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte) ((i6 & 63) | 128);
                                    writableSegment$okio4.limit += 4;
                                    setSize$okio(size() + 4);
                                    i += 2;
                                }
                            }
                            i++;
                        }
                        i = i3;
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte) ((i >> 6) | 192);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit += 2;
            setSize$okio(size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            writeByte(63);
        } else if (i < 65536) {
            Segment writableSegment$okio2 = writableSegment$okio(3);
            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte) ((i >> 12) | 224);
            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit += 3;
            setSize$okio(size() + 3);
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = writableSegment$okio(4);
            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte) ((i >> 18) | 240);
            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte) (((i >> 12) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte) (((i >> 6) & 63) | 128);
            writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit += 4;
            setSize$okio(size() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i));
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "source");
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        setSize$okio(size() + j);
        return this;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(this, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(Source source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment$okio.limit = i3 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment writableSegment$okio = writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment$okio.limit = i5 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment writableSegment$okio = writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment$okio.limit = i8 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j != 0) {
            long j2 = (long) 10;
            i3--;
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i2;
        setSize$okio(size() + ((long) i2));
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (writableSegment$okio.limit + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        setSize$okio(size() + ((long) i));
        return this;
    }

    public final Segment writableSegment$okio(int i) {
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size(), 0, j);
            while (j > 0) {
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment2.limit;
                Segment segment3 = buffer.head;
                Intrinsics.checkNotNull(segment3);
                if (j < ((long) (i - segment3.pos))) {
                    Segment segment4 = this.head;
                    if (segment4 != null) {
                        Intrinsics.checkNotNull(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= ((long) 8192)) {
                            Segment segment5 = buffer.head;
                            Intrinsics.checkNotNull(segment5);
                            segment5.writeTo(segment, (int) j);
                            buffer.setSize$okio(buffer.size() - j);
                            setSize$okio(size() + j);
                            return;
                        }
                    }
                    Segment segment6 = buffer.head;
                    Intrinsics.checkNotNull(segment6);
                    buffer.head = segment6.split((int) j);
                }
                Segment segment7 = buffer.head;
                Intrinsics.checkNotNull(segment7);
                long j2 = (long) (segment7.limit - segment7.pos);
                buffer.head = segment7.pop();
                Segment segment8 = this.head;
                if (segment8 == null) {
                    this.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7.prev;
                } else {
                    Intrinsics.checkNotNull(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7).compact();
                }
                buffer.setSize$okio(buffer.size() - j2);
                setSize$okio(size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j > size()) {
                j = size();
            }
            buffer.write(this, j);
            return j;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        int i;
        long j3 = 0;
        if (0 <= j && j2 >= j) {
            if (j2 > size()) {
                j2 = size();
            }
            if (j == j2) {
                return -1;
            }
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            if (size() - j < j) {
                j3 = size();
                while (j3 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j3 -= (long) (segment.limit - segment.pos);
                }
                if (segment == null) {
                    return -1;
                }
                while (j3 < j2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                    i = (int) ((((long) segment.pos) + j) - j3);
                    while (i < min) {
                        if (bArr[i] != b) {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
                return -1;
            }
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j3;
                if (j4 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j4;
            }
            if (segment == null) {
                return -1;
            }
            while (j3 < j2) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                i = (int) ((((long) segment.pos) + j) - j3);
                while (i < min2) {
                    if (bArr2[i] != b) {
                        i++;
                    }
                }
                j3 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j3;
            }
            return -1;
            return ((long) (i - segment.pos)) + j3;
        }
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j + " toIndex=" + j2).toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        long j2 = j;
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (byteString.size() > 0) {
            long j3 = 0;
            if (j2 >= 0) {
                Segment segment = this.head;
                if (segment != null) {
                    if (size() - j2 < j2) {
                        long size2 = size();
                        while (size2 > j2) {
                            segment = segment.prev;
                            Intrinsics.checkNotNull(segment);
                            size2 -= (long) (segment.limit - segment.pos);
                        }
                        if (segment != null) {
                            byte[] internalArray$okio = byteString.internalArray$okio();
                            byte b = internalArray$okio[0];
                            int size3 = byteString.size();
                            long size4 = (size() - ((long) size3)) + 1;
                            while (size2 < size4) {
                                byte[] bArr = segment.data;
                                int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size4) - size2);
                                for (int i = (int) ((((long) segment.pos) + j2) - size2); i < min; i++) {
                                    if (bArr[i] == b && BufferKt.rangeEquals(segment, i + 1, internalArray$okio, 1, size3)) {
                                        return ((long) (i - segment.pos)) + size2;
                                    }
                                }
                                size2 += (long) (segment.limit - segment.pos);
                                segment = segment.next;
                                Intrinsics.checkNotNull(segment);
                                j2 = size2;
                            }
                        }
                    } else {
                        while (true) {
                            long j4 = ((long) (segment.limit - segment.pos)) + j3;
                            if (j4 > j2) {
                                break;
                            }
                            segment = segment.next;
                            Intrinsics.checkNotNull(segment);
                            j3 = j4;
                        }
                        if (segment != null) {
                            byte[] internalArray$okio2 = byteString.internalArray$okio();
                            byte b2 = internalArray$okio2[0];
                            int size5 = byteString.size();
                            for (long size6 = (size() - ((long) size5)) + 1; j3 < size6; size6 = size6) {
                                byte[] bArr2 = segment.data;
                                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size6) - j3);
                                for (int i2 = (int) ((((long) segment.pos) + j2) - j3); i2 < min2; i2++) {
                                    if (bArr2[i2] == b2) {
                                        if (BufferKt.rangeEquals(segment, i2 + 1, internalArray$okio2, 1, size5)) {
                                            return ((long) (i2 - segment.pos)) + j3;
                                        }
                                    }
                                }
                                j3 += (long) (segment.limit - segment.pos);
                                segment = segment.next;
                                Intrinsics.checkNotNull(segment);
                                j2 = j3;
                            }
                        }
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j2 = 0;
        if (j >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            if (size() - j < j) {
                j2 = size();
                while (j2 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j2 -= (long) (segment.limit - segment.pos);
                }
                if (segment == null) {
                    return -1;
                }
                if (byteString.size() == 2) {
                    byte b = byteString.getByte(0);
                    byte b2 = byteString.getByte(1);
                    while (j2 < size()) {
                        byte[] bArr = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i3 = segment.limit;
                        while (i < i3) {
                            byte b3 = bArr[i];
                            if (!(b3 == b || b3 == b2)) {
                                i++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                    return -1;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                while (j2 < size()) {
                    byte[] bArr2 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j2);
                    int i4 = segment.limit;
                    while (i < i4) {
                        byte b4 = bArr2[i];
                        for (byte b5 : internalArray$okio) {
                            if (b4 == b5) {
                                i2 = segment.pos;
                                return ((long) (i - i2)) + j2;
                            }
                        }
                        i++;
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
                return -1;
            }
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
            if (segment == null) {
                return -1;
            }
            if (byteString.size() == 2) {
                byte b6 = byteString.getByte(0);
                byte b7 = byteString.getByte(1);
                while (j2 < size()) {
                    byte[] bArr3 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j2);
                    int i5 = segment.limit;
                    while (i < i5) {
                        byte b8 = bArr3[i];
                        if (!(b8 == b6 || b8 == b7)) {
                            i++;
                        }
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
                return -1;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            while (j2 < size()) {
                byte[] bArr4 = segment.data;
                i = (int) ((((long) segment.pos) + j) - j2);
                int i6 = segment.limit;
                while (i < i6) {
                    byte b9 = bArr4[i];
                    for (byte b10 : internalArray$okio2) {
                        if (b9 == b10) {
                            i2 = segment.pos;
                            return ((long) (i - i2)) + j2;
                        }
                    }
                    i++;
                }
                j2 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j2;
            }
            return -1;
            i2 = segment.pos;
            return ((long) (i - i2)) + j2;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || size() - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() != 0) {
                Segment segment = this.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = buffer.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment.pos;
                int i2 = segment2.pos;
                long j = 0;
                while (j < size()) {
                    long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
                    long j2 = 0;
                    while (j2 < min) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (segment.data[i] != segment2.data[i2]) {
                            return false;
                        }
                        j2++;
                        i = i3;
                        i2 = i4;
                    }
                    if (i == segment.limit) {
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        i = segment.pos;
                    }
                    if (i2 == segment2.limit) {
                        segment2 = segment2.next;
                        Intrinsics.checkNotNull(segment2);
                        i2 = segment2.pos;
                    }
                    j += min;
                }
            }
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != this.head);
        return i;
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy.prev;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = sharedCopy.prev;
                Intrinsics.checkNotNull(segment3);
                Intrinsics.checkNotNull(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    public final ByteString snapshot() {
        if (size() <= ((long) Integer.MAX_VALUE)) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(size(), 0, (long) i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(segment);
            if (segment.limit != segment.pos) {
                i3 += segment.limit - segment.pos;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        Segment segment2 = this.head;
        int i5 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i5] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i5] = Math.min(i2, i);
            iArr[bArr.length + i5] = segment2.pos;
            segment2.shared = true;
            i5++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }
}
