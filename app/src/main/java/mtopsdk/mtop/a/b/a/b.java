package mtopsdk.mtop.a.b.a;

import mtopsdk.mtop.domain.EnvModeEnum;

/* compiled from: AbstractNetworkConverter */
final /* synthetic */ class b {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[EnvModeEnum.values().length];
        a = iArr;
        try {
            iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[EnvModeEnum.PREPARE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[EnvModeEnum.TEST.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
