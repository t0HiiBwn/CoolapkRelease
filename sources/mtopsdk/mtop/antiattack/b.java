package mtopsdk.mtop.antiattack;

/* compiled from: ApiLockHelper */
final class b {
    public long a;
    public long b;
    private String c;

    public b(String str, long j, long j2) {
        this.c = str;
        this.a = j;
        this.b = j2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LockedEntity [key=");
        sb.append(this.c);
        sb.append(", lockStartTime=");
        sb.append(this.a);
        sb.append(", lockInterval=");
        sb.append(this.b);
        sb.append("]");
        return sb.toString();
    }
}
