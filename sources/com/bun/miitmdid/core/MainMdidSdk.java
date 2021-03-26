package com.bun.miitmdid.core;

import android.content.Context;
import com.bun.miitmdid.content.ProviderList;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.netease.nis.sdkwrapper.Utils;

public class MainMdidSdk implements IIdentifierListener {
    private static final String TAG = "MDID SDK ";
    private IIdentifierListener toDeveloperListener;

    /* renamed from: com.bun.miitmdid.core.MainMdidSdk$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;

        static {
            ProviderList.DEVICE_PROVIDER.values();
            int[] iArr = new int[16];
            $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER = iArr;
            try {
                ProviderList.DEVICE_PROVIDER device_provider = ProviderList.DEVICE_PROVIDER.XIAOMI;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider2 = ProviderList.DEVICE_PROVIDER.BLACKSHARK;
                iArr2[13] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider3 = ProviderList.DEVICE_PROVIDER.VIVO;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider4 = ProviderList.DEVICE_PROVIDER.HUA_WEI;
                iArr4[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider5 = ProviderList.DEVICE_PROVIDER.OPPO;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider6 = ProviderList.DEVICE_PROVIDER.ONEPLUS;
                iArr6[12] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider7 = ProviderList.DEVICE_PROVIDER.MOTO;
                iArr7[5] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider8 = ProviderList.DEVICE_PROVIDER.LENOVO;
                iArr8[6] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                int[] iArr9 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider9 = ProviderList.DEVICE_PROVIDER.ASUS;
                iArr9[7] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                int[] iArr10 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider10 = ProviderList.DEVICE_PROVIDER.SAMSUNG;
                iArr10[8] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                int[] iArr11 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider11 = ProviderList.DEVICE_PROVIDER.MEIZU;
                iArr11[9] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                int[] iArr12 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider12 = ProviderList.DEVICE_PROVIDER.NUBIA;
                iArr12[10] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                int[] iArr13 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider13 = ProviderList.DEVICE_PROVIDER.ZTE;
                iArr13[11] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                int[] iArr14 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider14 = ProviderList.DEVICE_PROVIDER.FREEMEOS;
                iArr14[14] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                int[] iArr15 = $SwitchMap$com$bun$miitmdid$content$ProviderList$DEVICE_PROVIDER;
                ProviderList.DEVICE_PROVIDER device_provider15 = ProviderList.DEVICE_PROVIDER.SSUIOS;
                iArr15[15] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public MainMdidSdk() {
    }

    public MainMdidSdk(boolean z) {
    }

    private int _InnerFailed(int i, IdSupplier idSupplier) {
        return ((Integer) Utils.rL(new Object[]{this, Integer.valueOf(i), idSupplier, 24, 1606976968496L})).intValue();
    }

    public int OnInit(Context context, IIdentifierListener iIdentifierListener) {
        return ((Integer) Utils.rL(new Object[]{this, context, iIdentifierListener, 25, 1606976968497L})).intValue();
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void OnSupport(boolean z, IdSupplier idSupplier) {
        Utils.rL(new Object[]{this, Boolean.valueOf(z), idSupplier, 26, 1606976968498L});
    }
}
