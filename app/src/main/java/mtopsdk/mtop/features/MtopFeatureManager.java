package mtopsdk.mtop.features;

import java.util.Set;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;

public final class MtopFeatureManager {
    public static long getMtopFeatureValue(int i) {
        if (i <= 0) {
            return 0;
        }
        return (long) (1 << (i - 1));
    }

    public enum MtopFeatureEnum {
        SUPPORT_RELATIVE_URL(1),
        UNIT_INFO_FEATURE(2),
        DISABLE_WHITEBOX_SIGN(3),
        SUPPORT_UTDID_UNIT(4),
        DISABLE_X_COMMAND(5),
        SUPPORT_OPEN_ACCOUNT(6);
        
        long feature;

        public final long getFeature() {
            return this.feature;
        }

        private MtopFeatureEnum(long j) {
            this.feature = j;
        }
    }

    public static long getMtopTotalFeatures(Mtop mtop) {
        if (mtop == null) {
            mtop = Mtop.instance(null);
        }
        long j = 0;
        try {
            for (Integer num : mtop.getMtopConfig().mtopFeatures) {
                j |= getMtopFeatureValue(num.intValue());
            }
        } catch (Exception e) {
            TBSdkLog.w("mtopsdk.MtopFeatureManager", mtop.getInstanceId() + " [getMtopTotalFeatures] get mtop total features error.---" + e.toString());
        }
        return j;
    }

    /* renamed from: mtopsdk.mtop.features.MtopFeatureManager$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MtopFeatureEnum.values().length];
            a = iArr;
            try {
                iArr[MtopFeatureEnum.SUPPORT_RELATIVE_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MtopFeatureEnum.UNIT_INFO_FEATURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MtopFeatureEnum.DISABLE_WHITEBOX_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MtopFeatureEnum.SUPPORT_UTDID_UNIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MtopFeatureEnum.DISABLE_X_COMMAND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[MtopFeatureEnum.SUPPORT_OPEN_ACCOUNT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static int getMtopFeatureByFeatureEnum(MtopFeatureEnum mtopFeatureEnum) {
        if (mtopFeatureEnum == null) {
            return 0;
        }
        switch (AnonymousClass1.a[mtopFeatureEnum.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                return 0;
        }
    }

    public static void setMtopFeatureFlag(Mtop mtop, int i, boolean z) {
        if (mtop == null) {
            mtop = Mtop.instance(null);
        }
        Set<Integer> set = mtop.getMtopConfig().mtopFeatures;
        if (z) {
            set.add(Integer.valueOf(i));
        } else {
            set.remove(Integer.valueOf(i));
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.MtopFeatureManager", mtop.getInstanceId() + " [setMtopFeatureFlag] set feature=" + i + " , openFlag=" + z);
        }
    }
}
