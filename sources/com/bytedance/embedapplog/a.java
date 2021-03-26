package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {
    String a();

    boolean b();

    String c();

    String d();

    boolean e();

    void f();

    /* renamed from: com.bytedance.embedapplog.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0020a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0021a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String a = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean b = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(b ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String c = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String d = d();
                        parcel2.writeNoException();
                        parcel2.writeString(d);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean e = e();
                        parcel2.writeNoException();
                        parcel2.writeInt(e ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        f();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            }
        }

        /* renamed from: com.bytedance.embedapplog.a$a$a  reason: collision with other inner class name */
        static class C0021a implements a {
            private IBinder a;

            C0021a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.bytedance.embedapplog.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.a
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z = false;
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.a
            public String c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.a
            public String d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.a
            public boolean e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    boolean z = false;
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.a
            public void f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
