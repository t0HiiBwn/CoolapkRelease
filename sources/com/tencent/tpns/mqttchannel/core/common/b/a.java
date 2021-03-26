package com.tencent.tpns.mqttchannel.core.common.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: ProGuard */
public interface a extends IInterface {
    void handleCallback(int i, String str);

    /* renamed from: com.tencent.tpns.mqttchannel.core.common.b.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    public static abstract class AbstractBinderC0162a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0162a() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0163a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                handleCallback(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                return true;
            }
        }

        /* renamed from: com.tencent.tpns.mqttchannel.core.common.b.a$a$a  reason: collision with other inner class name */
        /* compiled from: ProGuard */
        private static class C0163a implements a {
            private IBinder a;

            C0163a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.a
            public void handleCallback(int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
