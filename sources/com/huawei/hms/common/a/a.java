package com.huawei.hms.common.a;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

/* compiled from: HMSCursorWrapper */
public class a extends CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor a;

    public a(Cursor cursor) {
        super(cursor);
        if (cursor == null) {
            throw new IllegalArgumentException("cursor cannot be null");
        } else if (cursor instanceof CursorWrapper) {
            Cursor wrappedCursor = ((CursorWrapper) cursor).getWrappedCursor();
            if (wrappedCursor == null) {
                throw new IllegalArgumentException("getWrappedCursor cannot be null");
            } else if (wrappedCursor instanceof AbstractWindowedCursor) {
                this.a = (AbstractWindowedCursor) wrappedCursor;
            } else {
                throw new IllegalArgumentException("getWrappedCursor:" + wrappedCursor + " is not a subclass for CursorWrapper");
            }
        } else {
            throw new IllegalArgumentException("cursor:" + cursor + " is not a subclass for CursorWrapper");
        }
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.a.getWindow();
    }

    public void a(CursorWindow cursorWindow) {
        this.a.setWindow(cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.a.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return this.a.onMove(i, i2);
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.a;
    }
}
