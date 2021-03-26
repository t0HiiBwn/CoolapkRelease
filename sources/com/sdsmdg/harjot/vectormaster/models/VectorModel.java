package com.sdsmdg.harjot.vectormaster.models;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import com.sdsmdg.harjot.vectormaster.enums.TintMode;
import java.util.ArrayList;
import java.util.Iterator;

public class VectorModel {
    private float alpha = 1.0f;
    private boolean autoMirrored = false;
    private ArrayList<ClipPathModel> clipPathModels = new ArrayList<>();
    private Path fullpath = new Path();
    private ArrayList<GroupModel> groupModels = new ArrayList<>();
    private float height;
    private String name;
    private ArrayList<PathModel> pathModels = new ArrayList<>();
    private Matrix scaleMatrix;
    private int tint = 0;
    private TintMode tintMode = TintMode.SCR_IN;
    private float viewportHeight;
    private float viewportWidth;
    private float width;

    public void drawPaths(Canvas canvas, float f, float f2, float f3, float f4) {
        Iterator<ClipPathModel> it2 = this.clipPathModels.iterator();
        while (it2.hasNext()) {
            canvas.clipPath(it2.next().getScaledAndOffsetPath(f, f2, f3, f4));
        }
        Iterator<GroupModel> it3 = this.groupModels.iterator();
        while (it3.hasNext()) {
            it3.next().drawPaths(canvas, f, f2, f3, f4);
        }
        Iterator<PathModel> it4 = this.pathModels.iterator();
        while (it4.hasNext()) {
            PathModel next = it4.next();
            if (next.isFillAndStroke()) {
                next.makeFillPaint();
                canvas.drawPath(next.getScaledAndOffsetPath(f, f2, f3, f4), next.getPathPaint());
                next.makeStrokePaint();
                canvas.drawPath(next.getScaledAndOffsetPath(f, f2, f3, f4), next.getPathPaint());
            } else {
                canvas.drawPath(next.getScaledAndOffsetPath(f, f2, f3, f4), next.getPathPaint());
            }
        }
    }

    public void drawPaths(Canvas canvas) {
        Iterator<ClipPathModel> it2 = this.clipPathModels.iterator();
        while (it2.hasNext()) {
            canvas.clipPath(it2.next().getPath());
        }
        Iterator<GroupModel> it3 = this.groupModels.iterator();
        while (it3.hasNext()) {
            it3.next().drawPaths(canvas);
        }
        Iterator<PathModel> it4 = this.pathModels.iterator();
        while (it4.hasNext()) {
            PathModel next = it4.next();
            if (next.isFillAndStroke()) {
                next.makeFillPaint();
                canvas.drawPath(next.getPath(), next.getPathPaint());
                next.makeStrokePaint();
                canvas.drawPath(next.getPath(), next.getPathPaint());
            } else {
                canvas.drawPath(next.getPath(), next.getPathPaint());
            }
        }
    }

    public void scaleAllPaths(Matrix matrix) {
        this.scaleMatrix = matrix;
        Iterator<GroupModel> it2 = this.groupModels.iterator();
        while (it2.hasNext()) {
            it2.next().scaleAllPaths(matrix);
        }
        Iterator<PathModel> it3 = this.pathModels.iterator();
        while (it3.hasNext()) {
            it3.next().transform(matrix);
        }
        Iterator<ClipPathModel> it4 = this.clipPathModels.iterator();
        while (it4.hasNext()) {
            it4.next().transform(matrix);
        }
    }

    public void scaleAllStrokeWidth(float f) {
        Iterator<GroupModel> it2 = this.groupModels.iterator();
        while (it2.hasNext()) {
            it2.next().scaleAllStrokeWidth(f);
        }
        Iterator<PathModel> it3 = this.pathModels.iterator();
        while (it3.hasNext()) {
            it3.next().setStrokeRatio(f);
        }
    }

    public void buildTransformMatrices() {
        Iterator<GroupModel> it2 = this.groupModels.iterator();
        while (it2.hasNext()) {
            it2.next().buildTransformMatrix();
        }
    }

    public void addGroupModel(GroupModel groupModel) {
        this.groupModels.add(groupModel);
    }

    public ArrayList<GroupModel> getGroupModels() {
        return this.groupModels;
    }

    public void addPathModel(PathModel pathModel) {
        this.pathModels.add(pathModel);
    }

    public ArrayList<PathModel> getPathModels() {
        return this.pathModels;
    }

    public void addClipPathModel(ClipPathModel clipPathModel) {
        this.clipPathModels.add(clipPathModel);
    }

    public ArrayList<ClipPathModel> getClipPathModels() {
        return this.clipPathModels;
    }

    public Path getFullpath() {
        return this.fullpath;
    }

    public void setFullpath(Path path) {
        this.fullpath = path;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    public boolean isAutoMirrored() {
        return this.autoMirrored;
    }

    public void setAutoMirrored(boolean z) {
        this.autoMirrored = z;
    }

    public int getTint() {
        return this.tint;
    }

    public void setTint(int i) {
        this.tint = i;
    }

    public TintMode getTintMode() {
        return this.tintMode;
    }

    public void setTintMode(TintMode tintMode2) {
        this.tintMode = tintMode2;
    }

    public float getViewportWidth() {
        return this.viewportWidth;
    }

    public void setViewportWidth(float f) {
        this.viewportWidth = f;
    }

    public float getViewportHeight() {
        return this.viewportHeight;
    }

    public void setViewportHeight(float f) {
        this.viewportHeight = f;
    }
}
