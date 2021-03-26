package XI.XI.XI;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface XI extends IInterface {

    /* renamed from: XI.XI.XI.XI$XI  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0004XI extends Binder implements XI {

        /* renamed from: XI  reason: collision with root package name */
        public static final /* synthetic */ int f182XI = 0;

        /* renamed from: XI.XI.XI.XI$XI$XI  reason: collision with other inner class name */
        public static class C0005XI implements XI {

            /* renamed from: XI  reason: collision with root package name */
            public IBinder f183XI;

            public C0005XI(IBinder iBinder) {
                this.f183XI = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f183XI;
            }

            @Override // XI.XI.XI.XI
            public String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    obtain.writeString(str);
                    this.f183XI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.XI.XI.XI
            public String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f183XI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.XI.XI.XI
            public String getVAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    this.f183XI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // XI.XI.XI.XI
            public boolean isSupported() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    boolean z = false;
                    this.f183XI.transact(1, obtain, obtain2, 0);
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
        }
    }

    String getAAID(String str);

    String getOAID();

    String getVAID();

    boolean isSupported();
}
