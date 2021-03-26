package mtopsdk.common.util;

/* compiled from: LocalConfig */
public class c {
    private static c g;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    @Deprecated
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;

    public static c a() {
        if (g == null) {
            synchronized (c.class) {
                if (g == null) {
                    g = new c();
                }
            }
        }
        return g;
    }
}
