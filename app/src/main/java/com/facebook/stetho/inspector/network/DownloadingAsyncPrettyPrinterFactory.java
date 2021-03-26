package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

public abstract class DownloadingAsyncPrettyPrinterFactory implements AsyncPrettyPrinterFactory {
    protected abstract void doPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException;

    @Nullable
    protected abstract MatchResult matchAndParseHeader(String str, String str2);

    @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinterFactory
    public AsyncPrettyPrinter getInstance(String str, String str2) {
        final MatchResult matchAndParseHeader = matchAndParseHeader(str, str2);
        if (matchAndParseHeader == null) {
            return null;
        }
        URL parseURL = parseURL(matchAndParseHeader.getSchemaUri());
        if (parseURL == null) {
            return getErrorAsyncPrettyPrinter(str, str2);
        }
        ExecutorService executorService = AsyncPrettyPrinterExecutorHolder.getExecutorService();
        if (executorService == null) {
            return null;
        }
        final Future submit = executorService.submit(new Request(parseURL));
        return new AsyncPrettyPrinter() {
            /* class com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
                com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.doErrorPrint(r4, r5, "Encountered spurious interrupt while downloading schema for pretty printing: " + r0.getMessage());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Removed duplicated region for block: B:4:0x000e A[Catch:{ ExecutionException -> 0x0010, InterruptedException -> 0x000e, InterruptedException -> 0x000e, ExecutionException -> 0x0037 }, ExcHandler: InterruptedException (r0v3 'e' java.lang.InterruptedException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:0:0x0000] */
            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                try {
                    DownloadingAsyncPrettyPrinterFactory.this.doPrint(printWriter, inputStream, (String) submit.get());
                } catch (ExecutionException e) {
                    if (IOException.class.isInstance(e.getCause())) {
                        DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "Cannot successfully download schema: " + e.getMessage());
                        return;
                    }
                    throw e;
                } catch (InterruptedException e2) {
                } catch (ExecutionException e3) {
                    throw ExceptionUtil.propagate(e3.getCause());
                }
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return matchAndParseHeader.getDisplayType();
            }
        };
    }

    @Nullable
    private static URL parseURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void doErrorPrint(PrintWriter printWriter, InputStream inputStream, String str) throws IOException {
        printWriter.print(str + "\n" + Util.readAsUTF8(inputStream));
    }

    private static AsyncPrettyPrinter getErrorAsyncPrettyPrinter(final String str, final String str2) {
        return new AsyncPrettyPrinter() {
            /* class com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.AnonymousClass2 */

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException {
                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, "[Failed to parse header: " + str + " : " + str2 + " ]");
            }

            @Override // com.facebook.stetho.inspector.network.AsyncPrettyPrinter
            public PrettyPrinterDisplayType getPrettifiedType() {
                return PrettyPrinterDisplayType.TEXT;
            }
        };
    }

    protected class MatchResult {
        private final PrettyPrinterDisplayType mDisplayType;
        private final String mSchemaUri;

        public MatchResult(String str, PrettyPrinterDisplayType prettyPrinterDisplayType) {
            this.mSchemaUri = str;
            this.mDisplayType = prettyPrinterDisplayType;
        }

        public String getSchemaUri() {
            return this.mSchemaUri;
        }

        public PrettyPrinterDisplayType getDisplayType() {
            return this.mDisplayType;
        }
    }

    private static class Request implements Callable<String> {
        private URL url;

        public Request(URL url2) {
            this.url = url2;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    return Util.readAsUTF8(inputStream);
                } finally {
                    inputStream.close();
                }
            } else {
                throw new IOException("Got status code: " + responseCode + " while downloading schema with url: " + this.url.toString());
            }
        }
    }
}
