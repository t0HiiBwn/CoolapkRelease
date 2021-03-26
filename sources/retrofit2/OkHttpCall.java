package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Timeout;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;
    @Nullable
    private Throwable creationFailure;
    private boolean executed;
    @Nullable
    private Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, T> responseConverter;

    OkHttpCall(RequestFactory requestFactory2, Object[] objArr, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory2;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    @Override // retrofit2.Call, java.lang.Object
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    @Override // retrofit2.Call
    public synchronized Request request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return getRawCall().request();
    }

    @Override // retrofit2.Call
    public synchronized Timeout timeout() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create call.", e);
        }
        return getRawCall().timeout();
    }

    private Call getRawCall() throws IOException {
        Call call = this.rawCall;
        if (call != null) {
            return call;
        }
        Throwable th = this.creationFailure;
        if (th == null) {
            try {
                Call createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall;
            } catch (IOException | Error | RuntimeException e) {
                Utils.throwIfFatal(e);
                this.creationFailure = e;
                throw e;
            }
        } else if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw ((Error) th);
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                call = this.rawCall;
                th = this.creationFailure;
                if (call == null && th == null) {
                    try {
                        Call createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        call = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new Callback() {
            /* class retrofit2.OkHttpCall.AnonymousClass1 */

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(response));
                    } catch (Throwable th) {
                        Utils.throwIfFatal(th);
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    callFailure(th2);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callFailure(iOException);
            }

            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    th2.printStackTrace();
                }
            }
        });
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        Call rawCall2;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                rawCall2 = getRawCall();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            rawCall2.cancel();
        }
        return parseResponse(rawCall2.execute());
    }

    private Call createRawCall() throws IOException {
        Call newCall = this.callFactory.newCall(this.requestFactory.create(this.args));
        Objects.requireNonNull(newCall, "Call.Factory returned null.");
        return newCall;
    }

    Response<T> parseResponse(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new NoContentResponseBody(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return Response.error(Utils.buffer(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return Response.success((Object) null, build);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(body);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), build);
            } catch (RuntimeException e) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e;
            }
        }
    }

    @Override // retrofit2.Call
    public void cancel() {
        Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            Call call = this.rawCall;
            if (call == null || !call.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        @Nullable
        private final MediaType contentType;

        NoContentResponseBody(@Nullable MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        private final BufferedSource delegateSource;
        @Nullable
        IOException thrownException;

        ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
            this.delegateSource = Okio.buffer(new ForwardingSource(responseBody.source()) {
                /* class retrofit2.OkHttpCall.ExceptionCatchingResponseBody.AnonymousClass1 */

                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    try {
                        return super.read(buffer, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.delegateSource;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}
