package com.tencent.tpns.mqttchannel.core.common.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tpns.mqttchannel.core.common.b.a;

/* compiled from: ProGuard */
public interface c extends IInterface {
    void a(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2);

    void a(a aVar);

    void b(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2);

    void b(a aVar);

    void c(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2);

    void c(a aVar);

    void d(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2);

    void d(a aVar);

    /* compiled from: ProGuard */
    public static abstract class a extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new C0165a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                com.tencent.tpns.mqttchannel.core.common.a.a aVar = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        a(a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        b(a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        c(a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        d(a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            aVar = com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(parcel);
                        }
                        a(aVar, a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            aVar = com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(parcel);
                        }
                        b(aVar, a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            aVar = com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(parcel);
                        }
                        c(aVar, a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        if (parcel.readInt() != 0) {
                            aVar = com.tencent.tpns.mqttchannel.core.common.a.a.CREATOR.createFromParcel(parcel);
                        }
                        d(aVar, a.AbstractBinderC0162a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                return true;
            }
        }

        /* renamed from: com.tencent.tpns.mqttchannel.core.common.b.c$a$a  reason: collision with other inner class name */
        /* compiled from: ProGuard */
        private static class C0165a implements c {
            private IBinder a;

            C0165a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void a(a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void b(a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void c(a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void d(a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void a(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar2 != null ? aVar2.asBinder() : null);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void b(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar2 != null ? aVar2.asBinder() : null);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void c(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar2 != null ? aVar2.asBinder() : null);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.b.c
            public void d(com.tencent.tpns.mqttchannel.core.common.a.a aVar, a aVar2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar2 != null ? aVar2.asBinder() : null);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
