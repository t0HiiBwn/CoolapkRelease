package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: JvmOkio.kt */
final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final Sink sink(File file) {
        return sink$default(file, false, 1, null);
    }

    public static final Sink sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Source source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Sink sink(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static final Source source(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    private static final Logger getLogger$Okio__JvmOkioKt() {
        return logger;
    }

    public static final Sink sink(File file, boolean z) {
        Intrinsics.checkNotNullParameter(file, "$this$sink");
        return Okio.sink(new FileOutputStream(file, z));
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    public static final Sink appendingSink(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final Source source(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$source");
        return Okio.source(new FileInputStream(file));
    }

    public static final Sink sink(Path path, OpenOption... openOptionArr) {
        Intrinsics.checkNotNullParameter(path, "$this$sink");
        Intrinsics.checkNotNullParameter(openOptionArr, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "Files.newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }

    public static final Source source(Path path, OpenOption... openOptionArr) {
        Intrinsics.checkNotNullParameter(path, "$this$source");
        Intrinsics.checkNotNullParameter(openOptionArr, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newInputStream, "Files.newInputStream(this, *options)");
        return Okio.source(newInputStream);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        Intrinsics.checkNotNullParameter(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt.contains$default(message, "getsockname failed", false, 2, null) : false;
    }
}
