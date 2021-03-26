package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0000¢\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000¢\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "isValid", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: RealWebSocket.kt */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random2, long j, WebSocketExtensions webSocketExtensions, long j2) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(request, "originalRequest");
        Intrinsics.checkNotNullParameter(webSocketListener, "listener");
        Intrinsics.checkNotNullParameter(random2, "random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random2;
        this.pingIntervalMillis = j;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j2;
        this.taskQueue = taskRunner.newQueue();
        if (Intrinsics.areEqual("GET", request.method())) {
            ByteString.Companion companion = ByteString.Companion;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            Unit unit = Unit.INSTANCE;
            this.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, null).base64();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + request.method()).toString());
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call2 = this.call;
        Intrinsics.checkNotNull(call2);
        call2.cancel();
    }

    public final void connect(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        Intrinsics.checkNotNull(realCall);
        realCall.enqueue(new RealWebSocket$connect$1(this, build2));
    }

    /* access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits == null) {
            return true;
        }
        int intValue = webSocketExtensions.serverMaxWindowBits.intValue();
        if (8 > intValue || 15 < intValue) {
            return false;
        }
        return true;
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 101) {
            String header$default = Response.header$default(response, "Connection", null, 2, null);
            if (StringsKt.equals("Upgrade", header$default, true)) {
                String header$default2 = Response.header$default(response, "Upgrade", null, 2, null);
                if (StringsKt.equals("websocket", header$default2, true)) {
                    String header$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
                    ByteString.Companion companion = ByteString.Companion;
                    String base64 = companion.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (!Intrinsics.areEqual(base64, header$default3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                    } else if (exchange == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
    }

    public final void initReaderAndWriter(String str, Streams streams2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(streams2, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            this.name = str;
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.getClient(), streams2.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams2.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask();
            if (this.pingIntervalMillis != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                String str2 = str + " ping";
                this.taskQueue.schedule(new RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1(str2, str2, nanos, this, str, streams2, webSocketExtensions), nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams2.getClient(), streams2.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams2.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    public final void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(j, timeUnit);
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "text");
        this.listener.onMessage(this, str);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        this.listener.onMessage(this, byteString);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "payload");
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                this.receivedPingCount++;
            }
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        boolean z = true;
        if (i != -1) {
            Streams streams2 = null;
            WebSocketReader webSocketReader = null;
            WebSocketWriter webSocketWriter = null;
            synchronized (this) {
                if (this.receivedCloseCode != -1) {
                    z = false;
                }
                if (z) {
                    this.receivedCloseCode = i;
                    this.receivedCloseReason = str;
                    if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                        streams2 = this.streams;
                        this.streams = null;
                        webSocketReader = this.reader;
                        this.reader = null;
                        webSocketWriter = this.writer;
                        this.writer = null;
                        this.taskQueue.shutdown();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("already closed".toString());
                }
            }
            try {
                this.listener.onClosing(this, i, str);
                if (streams2 != null) {
                    this.listener.onClosed(this, i, str);
                }
            } finally {
                if (streams2 != null) {
                    Util.closeQuietly(streams2);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return send(ByteString.Companion.encodeUtf8(str), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return send(byteString, 2);
    }

    private final synchronized boolean send(ByteString byteString, int i) {
        if (!this.failed) {
            if (!this.enqueuedClose) {
                if (this.queueSize + ((long) byteString.size()) > 16777216) {
                    close(1001, null);
                    return false;
                }
                this.queueSize += (long) byteString.size();
                this.messageAndCloseQueue.add(new Message(i, byteString));
                runWriter();
                return true;
            }
        }
        return false;
    }

    public final synchronized boolean pong(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "payload");
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return close(i, str, 60000);
    }

    public final synchronized boolean close(int i, String str, long j) {
        WebSocketProtocol.INSTANCE.validateCloseCode(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.Companion.encodeUtf8(str);
            if (!(((long) byteString.size()) <= 123)) {
                throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
            }
        }
        if (!this.failed) {
            if (!this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i, byteString, j));
                runWriter();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0200  */
    public final boolean writeOneFrame$okhttp() throws IOException {
        Ref.IntRef intRef;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        WebSocketWriter webSocketWriter;
        ByteString byteString;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Throwable th;
        T t;
        T t2;
        T t3;
        T t4;
        T t5;
        T t6;
        Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
        objectRef8.element = null;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
        objectRef9.element = (T) null;
        Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
        objectRef10.element = (T) null;
        Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
        objectRef11.element = (T) null;
        Ref.ObjectRef objectRef12 = new Ref.ObjectRef();
        objectRef12.element = (T) null;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter2 = this.writer;
            ByteString poll = this.pongQueue.poll();
            if (poll == null) {
                objectRef8.element = (T) this.messageAndCloseQueue.poll();
                if (objectRef8.element instanceof Close) {
                    intRef2.element = this.receivedCloseCode;
                    objectRef9.element = (T) this.receivedCloseReason;
                    if (intRef2.element != -1) {
                        objectRef10.element = (T) this.streams;
                        this.streams = null;
                        objectRef11.element = (T) this.reader;
                        this.reader = null;
                        objectRef12.element = (T) this.writer;
                        this.writer = null;
                        this.taskQueue.shutdown();
                    } else {
                        T t7 = objectRef8.element;
                        if (t7 != null) {
                            long cancelAfterCloseMillis = t7.getCancelAfterCloseMillis();
                            String str = this.name + " cancel";
                            byteString = poll;
                            webSocketWriter = webSocketWriter2;
                            objectRef4 = objectRef12;
                            objectRef3 = objectRef11;
                            objectRef2 = objectRef10;
                            objectRef = objectRef9;
                            intRef = intRef2;
                            this.taskQueue.schedule(new RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1(str, true, str, true, this, webSocketWriter2, poll, objectRef8, intRef2, objectRef9, objectRef10, objectRef3, objectRef4), TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                    }
                } else {
                    byteString = poll;
                    webSocketWriter = webSocketWriter2;
                    objectRef4 = objectRef12;
                    objectRef3 = objectRef11;
                    objectRef2 = objectRef10;
                    objectRef = objectRef9;
                    intRef = intRef2;
                    if (objectRef8.element == null) {
                        return false;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            byteString = poll;
            webSocketWriter = webSocketWriter2;
            objectRef4 = objectRef12;
            objectRef3 = objectRef11;
            objectRef2 = objectRef10;
            objectRef = objectRef9;
            intRef = intRef2;
            Unit unit = Unit.INSTANCE;
        }
        if (byteString != null) {
            try {
                Intrinsics.checkNotNull(webSocketWriter);
                webSocketWriter.writePong(byteString);
            } catch (Throwable th2) {
                th = th2;
                objectRef5 = objectRef4;
                objectRef6 = objectRef3;
                objectRef7 = objectRef2;
                t = objectRef7.element;
                if (t != null) {
                }
                t2 = objectRef6.element;
                if (t2 != null) {
                }
                t3 = objectRef5.element;
                if (t3 != null) {
                }
                throw th;
            }
        } else if (objectRef8.element instanceof Message) {
            T t8 = objectRef8.element;
            if (t8 != null) {
                T t9 = t8;
                Intrinsics.checkNotNull(webSocketWriter);
                webSocketWriter.writeMessageFrame(t9.getFormatOpcode(), t9.getData());
                synchronized (this) {
                    this.queueSize -= (long) t9.getData().size();
                    Unit unit2 = Unit.INSTANCE;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
            }
        } else if (objectRef8.element instanceof Close) {
            T t10 = objectRef8.element;
            if (t10 != null) {
                T t11 = t10;
                Intrinsics.checkNotNull(webSocketWriter);
                webSocketWriter.writeClose(t11.getCode(), t11.getReason());
                objectRef7 = objectRef2;
                try {
                    if (objectRef7.element != null) {
                        int i = intRef.element;
                        T t12 = objectRef.element;
                        Intrinsics.checkNotNull(t12);
                        this.listener.onClosed(this, i, t12);
                    }
                    t4 = objectRef7.element;
                    if (t4 != null) {
                        Util.closeQuietly((Closeable) t4);
                    }
                    t5 = objectRef3.element;
                    if (t5 != null) {
                        Util.closeQuietly((Closeable) t5);
                    }
                    t6 = objectRef4.element;
                    if (t6 != null) {
                        Util.closeQuietly((Closeable) t6);
                    }
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    objectRef5 = objectRef4;
                    objectRef6 = objectRef3;
                    t = objectRef7.element;
                    if (t != null) {
                        Util.closeQuietly((Closeable) t);
                    }
                    t2 = objectRef6.element;
                    if (t2 != null) {
                        Util.closeQuietly((Closeable) t2);
                    }
                    t3 = objectRef5.element;
                    if (t3 != null) {
                        Util.closeQuietly((Closeable) t3);
                    }
                    throw th;
                }
            } else {
                objectRef5 = objectRef4;
                objectRef6 = objectRef3;
                objectRef7 = objectRef2;
                try {
                    throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                } catch (Throwable th4) {
                    th = th4;
                    t = objectRef7.element;
                    if (t != null) {
                    }
                    t2 = objectRef6.element;
                    if (t2 != null) {
                    }
                    t3 = objectRef5.element;
                    if (t3 != null) {
                    }
                    throw th;
                }
            }
        } else {
            throw new AssertionError();
        }
        objectRef7 = objectRef2;
        t4 = objectRef7.element;
        if (t4 != null) {
        }
        t5 = objectRef3.element;
        if (t5 != null) {
        }
        t6 = objectRef4.element;
        if (t6 != null) {
        }
        return true;
    }

    public final void writePingFrame$okhttp() {
        WebSocketWriter webSocketWriter;
        int i;
        synchronized (this) {
            if (!this.failed) {
                webSocketWriter = this.writer;
                if (webSocketWriter != null) {
                    i = this.awaitingPong ? this.sentPingCount : -1;
                    this.sentPingCount++;
                    this.awaitingPong = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        if (i != -1) {
            failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
            return;
        }
        try {
            webSocketWriter.writePing(ByteString.EMPTY);
        } catch (IOException e) {
            failWebSocket(e, null);
        }
    }

    public final void failWebSocket(Exception exc, Response response) {
        Streams streams2;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics.checkNotNullParameter(exc, "e");
        synchronized (this) {
            if (!this.failed) {
                this.failed = true;
                streams2 = this.streams;
                this.streams = null;
                webSocketReader = this.reader;
                this.reader = null;
                webSocketWriter = this.writer;
                this.writer = null;
                this.taskQueue.shutdown();
                Unit unit = Unit.INSTANCE;
            } else {
                return;
            }
        }
        try {
            this.listener.onFailure(this, exc, response);
        } finally {
            if (streams2 != null) {
                Util.closeQuietly(streams2);
            }
            if (webSocketReader != null) {
                Util.closeQuietly(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.closeQuietly(webSocketWriter);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: RealWebSocket.kt */
    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i, ByteString byteString) {
            Intrinsics.checkNotNullParameter(byteString, "data");
            this.formatOpcode = i;
            this.data = byteString;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }

        public final ByteString getData() {
            return this.data;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: RealWebSocket.kt */
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: RealWebSocket.kt */
    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSource, "source");
            Intrinsics.checkNotNullParameter(bufferedSink, "sink");
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSource getSource() {
            return this.source;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: RealWebSocket.kt */
    private final class WriterTask extends Task {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                if (RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0;
                }
                return -1;
            } catch (IOException e) {
                RealWebSocket.this.failWebSocket(e, null);
                return -1;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: RealWebSocket.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0, 2, null);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }
}
