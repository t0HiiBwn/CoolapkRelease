package com.sdsmdg.harjot.vectormaster.models;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.sdsmdg.harjot.vectormaster.utilities.legacyparser.PathParser;

public class ClipPathModel {
    private Paint clipPaint;
    private String name;
    private Path originalPath;
    private Path path = new Path();
    private String pathData;

    public ClipPathModel() {
        Paint paint = new Paint();
        this.clipPaint = paint;
        paint.setAntiAlias(true);
        this.clipPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public void buildPath(boolean z) {
        if (z) {
            this.originalPath = PathParser.createPathFromPathData(this.pathData);
        } else {
            this.originalPath = com.sdsmdg.harjot.vectormaster.utilities.parser.PathParser.doPath(this.pathData);
        }
        this.path = new Path(this.originalPath);
    }

    public void transform(Matrix matrix) {
        Path path2 = new Path(this.originalPath);
        this.path = path2;
        path2.transform(matrix);
    }

    public Paint getClipPaint() {
        return this.clipPaint;
    }

    public void setClipPaint(Paint paint) {
        this.clipPaint = paint;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPathData() {
        return this.pathData;
    }

    public void setPathData(String str) {
        this.pathData = str;
    }

    public Path getPath() {
        return this.path;
    }

    public void setPath(Path path2) {
        this.path = path2;
    }

    public Path getScaledAndOffsetPath(float f, float f2, float f3, float f4) {
        Path path2 = new Path(this.path);
        path2.offset(f, f2);
        path2.transform(getScaleMatrix(path2, f3, f4));
        return path2;
    }

    public Matrix getScaleMatrix(Path path2, float f, float f2) {
        Matrix matrix = new Matrix();
        RectF rectF = new RectF();
        path2.computeBounds(rectF, true);
        matrix.setScale(f, f2, rectF.left, rectF.top);
        return matrix;
    }
}
