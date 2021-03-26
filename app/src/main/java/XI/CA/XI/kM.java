package XI.CA.XI;

import android.database.ContentObserver;

public class kM extends ContentObserver {
    public int K0;

    /* renamed from: XI  reason: collision with root package name */
    public String f1167XI;
    public K0 kM;

    public kM(K0 k0, int i, String str) {
        super(null);
        this.kM = k0;
        this.K0 = i;
        this.f1167XI = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        K0 k0 = this.kM;
        if (k0 != null) {
            k0.K0(this.K0, this.f1167XI);
        }
    }
}
