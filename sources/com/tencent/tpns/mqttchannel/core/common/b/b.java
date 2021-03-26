package com.tencent.tpns.mqttchannel.core.common.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: ProGuard */
public interface b extends IInterface {
    void a();

    void a(com.tencent.tpns.mqttchannel.core.common.a.a aVar);

    void a(boolean z);

    void b();

    /* compiled from: ProGuard */
    public static abstract class a extends Binder implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0164a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                b();
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a(parcel.readInt() != 0 ? com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                return true;
            }
        }

        /* renamed from: com.tencent.tpns.mqttchannel.core.common.b.b$a$a  reason: collision with other inner class name */
        /* compiled from: ProGuard */
        private static class C0164a implements b {
            private IBinder a;

            C0164a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.b
            public void a(boolean z) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.b
            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.b
            public void b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.b
            public void a(com.tencent.tpns.mqttchannel.core.common.a.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
