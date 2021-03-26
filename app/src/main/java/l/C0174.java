package l;

/* renamed from: l.ۦ۟ۖ  reason: contains not printable characters */
public class C0174 implements Cloneable {

    /* renamed from: ۨۥۤ  reason: not valid java name and contains not printable characters */
    private byte[] f1142;

    /* renamed from: ۠ۘۙ  reason: not valid java name and contains not printable characters */
    public static C0174 m2171(int i, byte[] bArr) {
        int i2 = 0;
        while (bArr.length - i2 >= 4) {
            int r2 = C0172.m2167(bArr, i2);
            int r4 = C0172.m2167(bArr, i2 + 2);
            int i3 = i2 + 4;
            if (r4 < 0 || r4 > bArr.length - i3) {
                break;
            } else if (r2 != i) {
                i2 = i3 + r4;
            } else {
                byte[] bArr2 = new byte[r4];
                System.arraycopy(bArr, i3, bArr2, 0, r4);
                C0174 r7 = new C0174();
                r7.m2173(bArr2);
                return r7;
            }
        }
        return null;
    }

    /* renamed from: ۖۘۢ  reason: not valid java name and contains not printable characters */
    public int m2172(int i) {
        return C0172.m2163(this.f1142, i);
    }

    /* renamed from: ۙۚۧ  reason: not valid java name and contains not printable characters */
    public void m2173(byte[] bArr) {
        this.f1142 = bArr;
    }

    /* renamed from: ۜ۟۟  reason: not valid java name and contains not printable characters */
    public byte[] m2174() {
        return this.f1142;
    }

    /* renamed from: ۠ۘۦ  reason: not valid java name and contains not printable characters */
    public int m2175(int i) {
        return C0172.m2168(this.f1142, i);
    }

    /* renamed from: ۬ۜۤ  reason: not valid java name and contains not printable characters */
    public C0174 clone() {
        return (C0174) super.clone();
    }
}
