package mtopsdk.mtop.domain;

import java.util.List;
import java.util.Map;

/* compiled from: MockResponse */
public final class a {
    public String a;
    public int b;
    public Map<String, List<String>> c;
    public byte[] d;

    public final String toString() {
        return "MockResponse{api='" + this.a + "', statusCode=" + this.b + ", headers=" + this.c + ", byteData=" + new String(this.d) + '}';
    }
}
