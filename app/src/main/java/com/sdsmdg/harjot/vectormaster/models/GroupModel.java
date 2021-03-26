package com.sdsmdg.harjot.vectormaster.models;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.sdsmdg.harjot.vectormaster.utilities.Utils;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupModel {
    private ArrayList<ClipPathModel> clipPathModels = new ArrayList<>();
    private Matrix finalTransformMatrix;
    private ArrayList<GroupModel> groupModels = new ArrayList<>();
    private String name;
    private Matrix originalTransformMatrix;
    private GroupModel parent;
    private ArrayList<PathModel> pathModels = new ArrayList<>();
    private float pivotX = 0.0f;
    private float pivotY = 0.0f;
    private float rotation = 0.0f;
    private Matrix scaleMatrix;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float translateX = 0.0f;
    private float translateY = 0.0f;

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
        Matrix matrix2 = new Matrix(this.originalTransformMatrix);
        this.finalTransformMatrix = matrix2;
        matrix2.postConcat(matrix);
        Iterator<GroupModel> it2 = this.groupModels.iterator();
        while (it2.hasNext()) {
            it2.next().scaleAllPaths(matrix);
        }
        Iterator<PathModel> it3 = this.pathModels.iterator();
        while (it3.hasNext()) {
            it3.next().transform(this.finalTransformMatrix);
        }
        Iterator<ClipPathModel> it4 = this.clipPathModels.iterator();
        while (it4.hasNext()) {
            it4.next().transform(this.finalTransformMatrix);
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

    public void buildTransformMatrix() {
        Matrix matrix = new Matrix();
        this.originalTransformMatrix = matrix;
        matrix.postScale(this.scaleX, this.scaleY, this.pivotX, this.pivotY);
        this.originalTransformMatrix.postRotate(this.rotation, this.pivotX, this.pivotY);
        this.originalTransformMatrix.postTranslate(this.translateX, this.translateY);
        GroupModel groupModel = this.parent;
        if (groupModel != null) {
            this.originalTransformMatrix.postConcat(groupModel.getOriginalTransformMatrix());
        }
        Iterator<GroupModel> it2 = this.groupModels.iterator();
        while (it2.hasNext()) {
            it2.next().buildTransformMatrix();
        }
    }

    public void updateAndScalePaths() {
        if (this.scaleMatrix != null) {
            buildTransformMatrix();
            scaleAllPaths(this.scaleMatrix);
        }
    }

    public GroupModel getGroupModelByName(String str) {
        Iterator<GroupModel> it2 = this.groupModels.iterator();
        GroupModel groupModel = null;
        while (it2.hasNext()) {
            GroupModel next = it2.next();
            if (!Utils.isEqual(next.getName(), str)) {
                groupModel = next.getGroupModelByName(str);
                if (groupModel != null) {
                    break;
                }
            } else {
                return next;
            }
        }
        return groupModel;
    }

    public PathModel getPathModelByName(String str) {
        Iterator<PathModel> it2 = this.pathModels.iterator();
        while (it2.hasNext()) {
            PathModel next = it2.next();
            if (Utils.isEqual(next.getName(), str)) {
                return next;
            }
        }
        Iterator<GroupModel> it3 = this.groupModels.iterator();
        PathModel pathModel = null;
        while (it3.hasNext() && ((pathModel = it3.next().getPathModelByName(str)) == null || !Utils.isEqual(pathModel.getName(), str))) {
        }
        return pathModel;
    }

    public ClipPathModel getClipPathModelByName(String str) {
        Iterator<ClipPathModel> it2 = getClipPathModels().iterator();
        while (it2.hasNext()) {
            ClipPathModel next = it2.next();
            if (Utils.isEqual(next.getName(), str)) {
                return next;
            }
        }
        Iterator<GroupModel> it3 = getGroupModels().iterator();
        ClipPathModel clipPathModel = null;
        while (it3.hasNext() && ((clipPathModel = it3.next().getClipPathModelByName(str)) == null || !Utils.isEqual(clipPathModel.getName(), str))) {
        }
        return clipPathModel;
    }

    public Matrix getOriginalTransformMatrix() {
        return this.originalTransformMatrix;
    }

    public GroupModel getParent() {
        return this.parent;
    }

    public void setParent(GroupModel groupModel) {
        this.parent = groupModel;
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

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setRotation(float f) {
        this.rotation = f;
        updateAndScalePaths();
    }

    public float getPivotX() {
        return this.pivotX;
    }

    public void setPivotX(float f) {
        this.pivotX = f;
    }

    public float getPivotY() {
        return this.pivotY;
    }

    public void setPivotY(float f) {
        this.pivotY = f;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f) {
        this.scaleX = f;
        updateAndScalePaths();
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f) {
        this.scaleY = f;
        updateAndScalePaths();
    }

    public float getTranslateX() {
        return this.translateX;
    }

    public void setTranslateX(float f) {
        this.translateX = f;
        updateAndScalePaths();
    }

    public float getTranslateY() {
        return this.translateY;
    }

    public void setTranslateY(float f) {
        this.translateY = f;
        updateAndScalePaths();
    }
}
