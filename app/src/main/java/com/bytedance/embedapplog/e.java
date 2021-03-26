package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface e extends IInterface {
    boolean a();

    String b();

    String c();

    String d();

    String e();

    public static abstract class a extends Binder implements e {
        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C0026a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean a = a();
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String c = c();
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String d = d();
                parcel2.writeNoException();
                parcel2.writeString(d);
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String e = e();
                parcel2.writeNoException();
                parcel2.writeString(e);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                return true;
            }
        }

        /* renamed from: com.bytedance.embedapplog.e$a$a  reason: collision with other inner class name */
        static class C0026a implements e {
            private IBinder a;

            C0026a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.bytedance.embedapplog.e
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    boolean z = false;
                    this.a.transact(1, obtain, obtain2, 0);
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

            @Override // com.bytedance.embedapplog.e
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public String c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public String d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.e
            public String e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
