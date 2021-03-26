package com.sdsmdg.harjot.vectormaster.models;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.sdsmdg.harjot.vectormaster.DefaultValues;
import com.sdsmdg.harjot.vectormaster.utilities.Utils;
import com.sdsmdg.harjot.vectormaster.utilities.legacyparser.PathParser;

public class PathModel {
    private float fillAlpha = 1.0f;
    private int fillColor = 0;
    private Path.FillType fillType = DefaultValues.PATH_FILL_TYPE;
    private boolean isFillAndStroke = false;
    private String name;
    private Path originalPath;
    private Path path;
    private String pathData;
    private Paint pathPaint;
    private Matrix scaleMatrix;
    private float strokeAlpha = 1.0f;
    private int strokeColor = 0;
    private Paint.Cap strokeLineCap = DefaultValues.PATH_STROKE_LINE_CAP;
    private Paint.Join strokeLineJoin = DefaultValues.PATH_STROKE_LINE_JOIN;
    private float strokeMiterLimit = 4.0f;
    private float strokeRatio = 1.0f;
    private float strokeWidth = 0.0f;
    private float trimPathEnd = 1.0f;
    private float trimPathOffset = 0.0f;
    private float trimPathStart = 0.0f;
    private Path trimmedPath;

    public PathModel() {
        Paint paint = new Paint();
        this.pathPaint = paint;
        paint.setAntiAlias(true);
        updatePaint();
    }

    public void buildPath(boolean z) {
        if (z) {
            this.originalPath = PathParser.createPathFromPathData(this.pathData);
        } else {
            this.originalPath = com.sdsmdg.harjot.vectormaster.utilities.parser.PathParser.doPath(this.pathData);
        }
        Path path2 = this.originalPath;
        if (path2 != null) {
            path2.setFillType(this.fillType);
        }
        this.path = new Path(this.originalPath);
    }

    public void updatePaint() {
        this.pathPaint.setStrokeWidth(this.strokeWidth * this.strokeRatio);
        int i = this.fillColor;
        if (i != 0 && this.strokeColor != 0) {
            this.isFillAndStroke = true;
        } else if (i != 0) {
            this.pathPaint.setColor(i);
            this.pathPaint.setAlpha(Utils.getAlphaFromFloat(this.fillAlpha));
            this.pathPaint.setStyle(Paint.Style.FILL);
            this.isFillAndStroke = false;
        } else {
            int i2 = this.strokeColor;
            if (i2 != 0) {
                this.pathPaint.setColor(i2);
                this.pathPaint.setAlpha(Utils.getAlphaFromFloat(this.strokeAlpha));
                this.pathPaint.setStyle(Paint.Style.STROKE);
                this.isFillAndStroke = false;
            } else {
                this.pathPaint.setColor(0);
            }
        }
        this.pathPaint.setStrokeCap(this.strokeLineCap);
        this.pathPaint.setStrokeJoin(this.strokeLineJoin);
        this.pathPaint.setStrokeMiter(this.strokeMiterLimit);
    }

    public void makeStrokePaint() {
        this.pathPaint.setColor(this.strokeColor);
        this.pathPaint.setAlpha(Utils.getAlphaFromFloat(this.strokeAlpha));
        this.pathPaint.setStyle(Paint.Style.STROKE);
    }

    public void makeFillPaint() {
        this.pathPaint.setColor(this.fillColor);
        this.pathPaint.setAlpha(Utils.getAlphaFromFloat(this.fillAlpha));
        this.pathPaint.setStyle(Paint.Style.FILL);
    }

    public void transform(Matrix matrix) {
        this.scaleMatrix = matrix;
        trimPath();
    }

    public void trimPath() {
        if (this.scaleMatrix == null) {
            return;
        }
        if (this.trimPathStart == 0.0f && this.trimPathEnd == 1.0f && this.trimPathOffset == 0.0f) {
            Path path2 = new Path(this.originalPath);
            this.path = path2;
            path2.transform(this.scaleMatrix);
            return;
        }
        PathMeasure pathMeasure = new PathMeasure(this.originalPath, false);
        float length = pathMeasure.getLength();
        Path path3 = new Path();
        this.trimmedPath = path3;
        float f = this.trimPathStart;
        float f2 = this.trimPathOffset;
        pathMeasure.getSegment((f + f2) * length, (this.trimPathEnd + f2) * length, path3, true);
        Path path4 = new Path(this.trimmedPath);
        this.path = path4;
        path4.transform(this.scaleMatrix);
    }

    public Path getTrimmedPath() {
        return this.trimmedPath;
    }

    public void setTrimmedPath(Path path2) {
        this.trimmedPath = path2;
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

    public Paint getPathPaint() {
        return this.pathPaint;
    }

    public void setPathPaint(Paint paint) {
        this.pathPaint = paint;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public float getFillAlpha() {
        return this.fillAlpha;
    }

    public void setFillAlpha(float f) {
        this.fillAlpha = f;
        updatePaint();
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        updatePaint();
    }

    public Path.FillType getFillType() {
        return this.fillType;
    }

    public void setFillType(Path.FillType fillType2) {
        this.fillType = fillType2;
        Path path2 = this.originalPath;
        if (path2 != null) {
            path2.setFillType(fillType2);
        }
    }

    public String getPathData() {
        return this.pathData;
    }

    public void setPathData(String str) {
        this.pathData = str;
    }

    public float getTrimPathStart() {
        return this.trimPathStart;
    }

    public void setTrimPathStart(float f) {
        this.trimPathStart = f;
        trimPath();
    }

    public float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public void setTrimPathEnd(float f) {
        this.trimPathEnd = f;
        trimPath();
    }

    public float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public void setTrimPathOffset(float f) {
        this.trimPathOffset = f;
        trimPath();
    }

    public float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    public void setStrokeAlpha(float f) {
        this.strokeAlpha = f;
        updatePaint();
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        updatePaint();
    }

    public Paint.Cap getStrokeLineCap() {
        return this.strokeLineCap;
    }

    public void setStrokeLineCap(Paint.Cap cap) {
        this.strokeLineCap = cap;
        updatePaint();
    }

    public Paint.Join getStrokeLineJoin() {
        return this.strokeLineJoin;
    }

    public void setStrokeLineJoin(Paint.Join join) {
        this.strokeLineJoin = join;
        updatePaint();
    }

    public float getStrokeMiterLimit() {
        return this.strokeMiterLimit;
    }

    public void setStrokeMiterLimit(float f) {
        this.strokeMiterLimit = f;
        updatePaint();
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        updatePaint();
    }

    public float getStrokeRatio() {
        return this.strokeRatio;
    }

    public void setStrokeRatio(float f) {
        this.strokeRatio = f;
        updatePaint();
    }

    public boolean isFillAndStroke() {
        return this.isFillAndStroke;
    }
}
