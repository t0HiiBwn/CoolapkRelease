package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.a.a;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private static final Builder builder = new a(new String[0], null);
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;

    public static class Builder {
        private String[] a;
        private final ArrayList<HashMap<String, Object>> b;
        private final String c;
        private final HashMap<Object, Integer> d;

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.a = strArr;
            this.b = new ArrayList<>();
            this.c = str;
            this.d = new HashMap<>();
        }

        Builder(String[] strArr, String str, a aVar) {
            this(strArr, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
        public Builder setDataForContentValuesHashMap(HashMap<String, Object> hashMap) {
            int i;
            Object obj;
            Preconditions.checkNotNull(hashMap, "contentValuesHashMap cannot be null");
            String str = this.c;
            boolean z = false;
            if (!(str == null || (obj = hashMap.get(str)) == null)) {
                Integer num = this.d.get(obj);
                if (num != null) {
                    i = num.intValue();
                    z = true;
                    if (!z) {
                        this.b.remove(i);
                        this.b.add(i, hashMap);
                    } else {
                        this.b.add(hashMap);
                    }
                    return this;
                }
                this.d.put(obj, Integer.valueOf(this.b.size()));
            }
            i = 0;
            if (!z) {
            }
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }

        public DataHolder build(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle, -1);
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i2;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(strArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private DataHolder(a aVar, int i, Bundle bundle) {
        this(aVar.getColumnNames(), getCursorWindows(aVar), i, bundle);
    }

    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new a(cursor), i, bundle);
    }

    private DataHolder(Builder builder2, int i, Bundle bundle) {
        this(builder2.a, getCursorWindows(builder2, -1), i, (Bundle) null);
    }

    private DataHolder(Builder builder2, int i, Bundle bundle, int i2) {
        this(builder2.a, getCursorWindows(builder2, -1), i, bundle);
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.columns;
            if (i2 >= strArr.length) {
                break;
            }
            this.columnsBundle.putInt(strArr[i2], i2);
            i2++;
        }
        this.perCursorCounts = new int[this.cursorWindows.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.cursorWindows;
            if (i < cursorWindowArr.length) {
                this.perCursorCounts[i] = i3;
                i3 = cursorWindowArr[i].getStartPosition() + this.cursorWindows[i].getNumRows();
                i++;
            } else {
                this.dataCount = i3;
                return;
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    private static CursorWindow[] getCursorWindows(a aVar) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int count = aVar.getCount();
            CursorWindow window = aVar.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                aVar.a(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(aVar, i, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            HMSLog.e("DataHolder", "fail to getCursorWindows: " + th.getMessage());
            return new CursorWindow[0];
        } finally {
            aVar.close();
        }
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(a aVar, int i, int i2) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i < i2 && aVar.moveToPosition(i)) {
            CursorWindow window = aVar.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i);
                aVar.fillWindow(i, window);
            } else {
                window.acquireReference();
                aVar.a(null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static CursorWindow[] getCursorWindows(Builder builder2, int i) {
        if (builder2.a.length == 0) {
            return new CursorWindow[0];
        }
        if (i < 0 || i >= builder2.b.size()) {
            i = builder2.b.size();
        }
        ArrayList<CursorWindow> iterCursorWindow = iterCursorWindow(builder2, i, builder2.b.subList(0, i));
        return (CursorWindow[]) iterCursorWindow.toArray(new CursorWindow[iterCursorWindow.size()]);
    }

    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder2, int i, List list) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow = new CursorWindow((String) null);
        cursorWindow.setNumColumns(builder2.a.length);
        arrayList.add(cursorWindow);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            try {
                if (!cursorWindow.allocRow()) {
                    HMSLog.d("DataHolder", "Failed to allocate a row");
                    cursorWindow = new CursorWindow((String) null);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(builder2.a.length);
                    if (!cursorWindow.allocRow()) {
                        HMSLog.e("DataHolder", "Failed to retry to allocate a row");
                        return arrayList;
                    }
                    arrayList.add(cursorWindow);
                }
                HashMap hashMap = (HashMap) list.get(i2);
                boolean z = true;
                int i3 = 0;
                while (i3 < builder2.a.length && (z = putValue(cursorWindow, hashMap.get(builder2.a[i3]), i2, i3))) {
                    i3++;
                }
                if (!z) {
                    HMSLog.d("DataHolder", "fail to put data for row " + i2);
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow2 = new CursorWindow((String) null);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(builder2.a.length);
                    arrayList.add(cursorWindow2);
                    break;
                }
                i2++;
            } catch (RuntimeException e) {
                Iterator<CursorWindow> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next().close();
                }
                throw e;
            }
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i, int i2) throws IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i, i2);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i, i2);
        } else if (obj instanceof Integer) {
            return cursorWindow.putLong((long) ((Integer) obj).intValue(), i, i2);
        } else {
            if (obj instanceof Long) {
                return cursorWindow.putLong(((Long) obj).longValue(), i, i2);
            }
            if (obj instanceof Float) {
                return cursorWindow.putDouble((double) ((Float) obj).floatValue(), i, i2);
            }
            if (obj instanceof Double) {
                return cursorWindow.putDouble(((Double) obj).doubleValue(), i, i2);
            }
            if (obj instanceof String) {
                return cursorWindow.putString((String) obj, i, i2);
            }
            if (obj instanceof byte[]) {
                return cursorWindow.putBlob((byte[]) obj, i, i2);
            }
            throw new IllegalArgumentException("unsupported type for column: " + obj);
        }
    }

    private void checkAvailable(String str, int i) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle == null || !bundle.containsKey(str)) {
            str2 = "cannot find column: " + str;
        } else if (isClosed()) {
            str2 = "buffer has been closed";
        } else if (i < 0 || i >= this.dataCount) {
            str2 = "row is out of index:" + i;
        } else {
            str2 = "";
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final Object getValue(String str, int i, int i2, String str2) {
        str2.hashCode();
        boolean z = true;
        char c = 65535;
        switch (str2.hashCode()) {
            case -1092271849:
                if (str2.equals("type_float")) {
                    c = 0;
                    break;
                }
                break;
            case -870070237:
                if (str2.equals("type_boolean")) {
                    c = 1;
                    break;
                }
                break;
            case -675993238:
                if (str2.equals("type_int")) {
                    c = 2;
                    break;
                }
                break;
            case 445002870:
                if (str2.equals("type_double")) {
                    c = 3;
                    break;
                }
                break;
            case 519136353:
                if (str2.equals("type_long")) {
                    c = 4;
                    break;
                }
                break;
            case 878975158:
                if (str2.equals("type_string")) {
                    c = 5;
                    break;
                }
                break;
            case 1300508295:
                if (str2.equals("type_byte_array")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                checkAvailable(str, i);
                return Float.valueOf(this.cursorWindows[i2].getFloat(i, this.columnsBundle.getInt(str)));
            case 1:
                checkAvailable(str, i);
                if (this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)) != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                checkAvailable(str, i);
                return Integer.valueOf(this.cursorWindows[i2].getInt(i, this.columnsBundle.getInt(str)));
            case 3:
                checkAvailable(str, i);
                return Double.valueOf(this.cursorWindows[i2].getDouble(i, this.columnsBundle.getInt(str)));
            case 4:
                checkAvailable(str, i);
                return Long.valueOf(this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)));
            case 5:
                checkAvailable(str, i);
                return this.cursorWindows[i2].getString(i, this.columnsBundle.getInt(str));
            case 6:
                checkAvailable(str, i);
                return this.cursorWindows[i2].getBlob(i, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i);
        this.cursorWindows[i2].copyStringToBuffer(i, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    public final boolean hasNull(String str, int i, int i2) {
        checkAvailable(str, i);
        return this.cursorWindows[i2].getType(i, this.columnsBundle.getInt(str)) == 0;
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final int getWindowIndex(int i) {
        int[] iArr;
        int i2 = 0;
        Preconditions.checkArgument(i >= 0 || i < this.dataCount, "rowIndex is out of index:" + i);
        while (true) {
            iArr = this.perCursorCounts;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == iArr.length ? i2 - 1 : i2;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!this.mClosed) {
            for (CursorWindow cursorWindow : this.cursorWindows) {
                cursorWindow.close();
            }
            this.mClosed = true;
        }
    }

    @Override // java.lang.Object
    protected final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    public static DataHolder empty(int i) {
        return new DataHolder(builder, i, (Bundle) null);
    }
}
