package mtopsdk.network.domain;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public abstract class RequestBody {
    public long contentLength() {
        return -1;
    }

    public abstract String contentType();

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static RequestBody create(final String str, final byte[] bArr) throws Exception {
        Objects.requireNonNull(bArr, "content == null");
        return new RequestBody() {
            /* class mtopsdk.network.domain.RequestBody.AnonymousClass1 */

            @Override // mtopsdk.network.domain.RequestBody
            public final String contentType() {
                return str;
            }

            @Override // mtopsdk.network.domain.RequestBody
            public final long contentLength() {
                return (long) bArr.length;
            }

            @Override // mtopsdk.network.domain.RequestBody
            public final void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write(bArr);
            }
        };
    }
}
