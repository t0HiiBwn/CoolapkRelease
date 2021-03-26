package com.sdsmdg.harjot.vectormaster;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.sdsmdg.harjot.vectormaster.models.ClipPathModel;
import com.sdsmdg.harjot.vectormaster.models.GroupModel;
import com.sdsmdg.harjot.vectormaster.models.PathModel;
import com.sdsmdg.harjot.vectormaster.models.VectorModel;
import com.sdsmdg.harjot.vectormaster.utilities.Utils;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorMasterDrawable extends Drawable {
    String TAG = "VECTOR_MASTER";
    private Context context;
    private int height = -1;
    private int left = 0;
    private float offsetX = 0.0f;
    private float offsetY = 0.0f;
    private int resID = -1;
    private Resources resources;
    private Matrix scaleMatrix;
    private float scaleRatio;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float strokeRatio;
    private int tempSaveCount;
    private int top = 0;
    private boolean useLegacyParser = true;
    private VectorModel vectorModel;
    private int width = -1;
    private XmlPullParser xpp;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public VectorMasterDrawable(Context context2, int i) {
        this.context = context2;
        this.resID = i;
        init();
    }

    public VectorMasterDrawable(Context context2, int i, float f, float f2) {
        this.context = context2;
        this.resID = i;
        this.offsetX = f;
        this.offsetY = f2;
        init();
    }

    public VectorMasterDrawable(Context context2, int i, float f, float f2, float f3, float f4) {
        this.context = context2;
        this.resID = i;
        this.offsetX = f;
        this.offsetY = f2;
        this.scaleX = f3;
        this.scaleY = f4;
        init();
    }

    private void init() {
        this.resources = this.context.getResources();
        buildVectorModel();
    }

    private void buildVectorModel() {
        int i = this.resID;
        if (i == -1) {
            this.vectorModel = null;
            return;
        }
        this.xpp = this.resources.getXml(i);
        PathModel pathModel = new PathModel();
        this.vectorModel = new VectorModel();
        new GroupModel();
        ClipPathModel clipPathModel = new ClipPathModel();
        Stack stack = new Stack();
        try {
            int eventType = this.xpp.getEventType();
            while (eventType != 1) {
                String name = this.xpp.getName();
                if (eventType == 2) {
                    float f = 1.0f;
                    float f2 = 0.0f;
                    if (name.equals("vector")) {
                        int attrPosition = getAttrPosition(this.xpp, "viewportWidth");
                        this.vectorModel.setViewportWidth(attrPosition != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition)) : 0.0f);
                        int attrPosition2 = getAttrPosition(this.xpp, "viewportHeight");
                        this.vectorModel.setViewportHeight(attrPosition2 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition2)) : 0.0f);
                        int attrPosition3 = getAttrPosition(this.xpp, "alpha");
                        VectorModel vectorModel2 = this.vectorModel;
                        if (attrPosition3 != -1) {
                            f = Float.parseFloat(this.xpp.getAttributeValue(attrPosition3));
                        }
                        vectorModel2.setAlpha(f);
                        int attrPosition4 = getAttrPosition(this.xpp, "name");
                        this.vectorModel.setName(attrPosition4 != -1 ? this.xpp.getAttributeValue(attrPosition4) : null);
                        int attrPosition5 = getAttrPosition(this.xpp, "width");
                        this.vectorModel.setWidth(attrPosition5 != -1 ? Utils.getFloatFromDimensionString(this.xpp.getAttributeValue(attrPosition5)) : 0.0f);
                        int attrPosition6 = getAttrPosition(this.xpp, "height");
                        VectorModel vectorModel3 = this.vectorModel;
                        if (attrPosition6 != -1) {
                            f2 = Utils.getFloatFromDimensionString(this.xpp.getAttributeValue(attrPosition6));
                        }
                        vectorModel3.setHeight(f2);
                    } else if (name.equals("path")) {
                        pathModel = new PathModel();
                        int attrPosition7 = getAttrPosition(this.xpp, "name");
                        pathModel.setName(attrPosition7 != -1 ? this.xpp.getAttributeValue(attrPosition7) : null);
                        int attrPosition8 = getAttrPosition(this.xpp, "fillAlpha");
                        pathModel.setFillAlpha(attrPosition8 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition8)) : 1.0f);
                        int attrPosition9 = getAttrPosition(this.xpp, "fillColor");
                        int i2 = 0;
                        pathModel.setFillColor(attrPosition9 != -1 ? Utils.getColorFromString(this.xpp.getAttributeValue(attrPosition9)) : 0);
                        int attrPosition10 = getAttrPosition(this.xpp, "fillType");
                        pathModel.setFillType(attrPosition10 != -1 ? Utils.getFillTypeFromString(this.xpp.getAttributeValue(attrPosition10)) : DefaultValues.PATH_FILL_TYPE);
                        int attrPosition11 = getAttrPosition(this.xpp, "pathData");
                        pathModel.setPathData(attrPosition11 != -1 ? this.xpp.getAttributeValue(attrPosition11) : null);
                        int attrPosition12 = getAttrPosition(this.xpp, "strokeAlpha");
                        pathModel.setStrokeAlpha(attrPosition12 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition12)) : 1.0f);
                        int attrPosition13 = getAttrPosition(this.xpp, "strokeColor");
                        if (attrPosition13 != -1) {
                            i2 = Utils.getColorFromString(this.xpp.getAttributeValue(attrPosition13));
                        }
                        pathModel.setStrokeColor(i2);
                        int attrPosition14 = getAttrPosition(this.xpp, "strokeLineCap");
                        pathModel.setStrokeLineCap(attrPosition14 != -1 ? Utils.getLineCapFromString(this.xpp.getAttributeValue(attrPosition14)) : DefaultValues.PATH_STROKE_LINE_CAP);
                        int attrPosition15 = getAttrPosition(this.xpp, "strokeLineJoin");
                        pathModel.setStrokeLineJoin(attrPosition15 != -1 ? Utils.getLineJoinFromString(this.xpp.getAttributeValue(attrPosition15)) : DefaultValues.PATH_STROKE_LINE_JOIN);
                        int attrPosition16 = getAttrPosition(this.xpp, "strokeMiterLimit");
                        pathModel.setStrokeMiterLimit(attrPosition16 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition16)) : 4.0f);
                        int attrPosition17 = getAttrPosition(this.xpp, "strokeWidth");
                        pathModel.setStrokeWidth(attrPosition17 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition17)) : 0.0f);
                        int attrPosition18 = getAttrPosition(this.xpp, "trimPathEnd");
                        if (attrPosition18 != -1) {
                            f = Float.parseFloat(this.xpp.getAttributeValue(attrPosition18));
                        }
                        pathModel.setTrimPathEnd(f);
                        int attrPosition19 = getAttrPosition(this.xpp, "trimPathOffset");
                        pathModel.setTrimPathOffset(attrPosition19 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition19)) : 0.0f);
                        int attrPosition20 = getAttrPosition(this.xpp, "trimPathStart");
                        if (attrPosition20 != -1) {
                            f2 = Float.parseFloat(this.xpp.getAttributeValue(attrPosition20));
                        }
                        pathModel.setTrimPathStart(f2);
                        pathModel.buildPath(this.useLegacyParser);
                    } else if (name.equals("group")) {
                        GroupModel groupModel = new GroupModel();
                        int attrPosition21 = getAttrPosition(this.xpp, "name");
                        groupModel.setName(attrPosition21 != -1 ? this.xpp.getAttributeValue(attrPosition21) : null);
                        int attrPosition22 = getAttrPosition(this.xpp, "pivotX");
                        groupModel.setPivotX(attrPosition22 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition22)) : 0.0f);
                        int attrPosition23 = getAttrPosition(this.xpp, "pivotY");
                        groupModel.setPivotY(attrPosition23 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition23)) : 0.0f);
                        int attrPosition24 = getAttrPosition(this.xpp, "rotation");
                        groupModel.setRotation(attrPosition24 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition24)) : 0.0f);
                        int attrPosition25 = getAttrPosition(this.xpp, "scaleX");
                        groupModel.setScaleX(attrPosition25 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition25)) : 1.0f);
                        int attrPosition26 = getAttrPosition(this.xpp, "scaleY");
                        if (attrPosition26 != -1) {
                            f = Float.parseFloat(this.xpp.getAttributeValue(attrPosition26));
                        }
                        groupModel.setScaleY(f);
                        int attrPosition27 = getAttrPosition(this.xpp, "translateX");
                        groupModel.setTranslateX(attrPosition27 != -1 ? Float.parseFloat(this.xpp.getAttributeValue(attrPosition27)) : 0.0f);
                        int attrPosition28 = getAttrPosition(this.xpp, "translateY");
                        if (attrPosition28 != -1) {
                            f2 = Float.parseFloat(this.xpp.getAttributeValue(attrPosition28));
                        }
                        groupModel.setTranslateY(f2);
                        stack.push(groupModel);
                    } else if (name.equals("clip-path")) {
                        clipPathModel = new ClipPathModel();
                        int attrPosition29 = getAttrPosition(this.xpp, "name");
                        clipPathModel.setName(attrPosition29 != -1 ? this.xpp.getAttributeValue(attrPosition29) : null);
                        int attrPosition30 = getAttrPosition(this.xpp, "pathData");
                        clipPathModel.setPathData(attrPosition30 != -1 ? this.xpp.getAttributeValue(attrPosition30) : null);
                        clipPathModel.buildPath(this.useLegacyParser);
                    }
                } else if (eventType == 3) {
                    if (name.equals("path")) {
                        if (stack.size() == 0) {
                            this.vectorModel.addPathModel(pathModel);
                        } else {
                            ((GroupModel) stack.peek()).addPathModel(pathModel);
                        }
                        this.vectorModel.getFullpath().addPath(pathModel.getPath());
                    } else if (name.equals("clip-path")) {
                        if (stack.size() == 0) {
                            this.vectorModel.addClipPathModel(clipPathModel);
                        } else {
                            ((GroupModel) stack.peek()).addClipPathModel(clipPathModel);
                        }
                    } else if (name.equals("group")) {
                        GroupModel groupModel2 = (GroupModel) stack.pop();
                        if (stack.size() == 0) {
                            groupModel2.setParent(null);
                            this.vectorModel.addGroupModel(groupModel2);
                        } else {
                            groupModel2.setParent((GroupModel) stack.peek());
                            ((GroupModel) stack.peek()).addGroupModel(groupModel2);
                        }
                    } else if (name.equals("vector")) {
                        this.vectorModel.buildTransformMatrices();
                    }
                }
                eventType = this.xpp.next();
            }
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    private int getAttrPosition(XmlPullParser xmlPullParser, String str) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public int getResID() {
        return this.resID;
    }

    public void setResID(int i) {
        this.resID = i;
        buildVectorModel();
        this.scaleMatrix = null;
    }

    public boolean isUseLegacyParser() {
        return this.useLegacyParser;
    }

    public void setUseLegacyParser(boolean z) {
        this.useLegacyParser = z;
        buildVectorModel();
        this.scaleMatrix = null;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.width() != 0 && rect.height() != 0) {
            this.left = rect.left;
            this.top = rect.top;
            this.width = rect.width();
            this.height = rect.height();
            buildScaleMatrix();
            scaleAllPaths();
            scaleAllStrokes();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        VectorModel vectorModel2 = this.vectorModel;
        if (vectorModel2 != null) {
            if (this.scaleMatrix == null) {
                setBounds(0, 0, Utils.dpToPx((int) vectorModel2.getWidth()), Utils.dpToPx((int) this.vectorModel.getHeight()));
            }
            setAlpha(Utils.getAlphaFromFloat(this.vectorModel.getAlpha()));
            if (this.left == 0 && this.top == 0) {
                this.vectorModel.drawPaths(canvas, this.offsetX, this.offsetY, this.scaleX, this.scaleY);
                return;
            }
            this.tempSaveCount = canvas.save();
            canvas.translate((float) this.left, (float) this.top);
            this.vectorModel.drawPaths(canvas, this.offsetX, this.offsetY, this.scaleX, this.scaleY);
            canvas.restoreToCount(this.tempSaveCount);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.vectorModel.setAlpha(Utils.getAlphaFromInt(i));
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Utils.dpToPx((int) this.vectorModel.getWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Utils.dpToPx((int) this.vectorModel.getHeight());
    }

    private void buildScaleMatrix() {
        Matrix matrix = new Matrix();
        this.scaleMatrix = matrix;
        matrix.postTranslate(((float) (this.width / 2)) - (this.vectorModel.getViewportWidth() / 2.0f), ((float) (this.height / 2)) - (this.vectorModel.getViewportHeight() / 2.0f));
        float min = Math.min(((float) this.width) / this.vectorModel.getViewportWidth(), ((float) this.height) / this.vectorModel.getViewportHeight());
        this.scaleRatio = min;
        this.scaleMatrix.postScale(min, min, (float) (this.width / 2), (float) (this.height / 2));
    }

    private void scaleAllPaths() {
        this.vectorModel.scaleAllPaths(this.scaleMatrix);
    }

    private void scaleAllStrokes() {
        float min = Math.min(((float) this.width) / this.vectorModel.getWidth(), ((float) this.height) / this.vectorModel.getHeight());
        this.strokeRatio = min;
        this.vectorModel.scaleAllStrokeWidth(min);
    }

    public Path getFullPath() {
        VectorModel vectorModel2 = this.vectorModel;
        if (vectorModel2 != null) {
            return vectorModel2.getFullpath();
        }
        return null;
    }

    public GroupModel getGroupModelByName(String str) {
        Iterator<GroupModel> it2 = this.vectorModel.getGroupModels().iterator();
        while (it2.hasNext()) {
            GroupModel next = it2.next();
            if (Utils.isEqual(next.getName(), str)) {
                return next;
            }
            GroupModel groupModelByName = next.getGroupModelByName(str);
            if (groupModelByName != null) {
                return groupModelByName;
            }
        }
        return null;
    }

    public PathModel getPathModelByName(String str) {
        Iterator<PathModel> it2 = this.vectorModel.getPathModels().iterator();
        while (it2.hasNext()) {
            PathModel next = it2.next();
            if (Utils.isEqual(next.getName(), str)) {
                return next;
            }
        }
        Iterator<GroupModel> it3 = this.vectorModel.getGroupModels().iterator();
        PathModel pathModel = null;
        while (it3.hasNext() && ((pathModel = it3.next().getPathModelByName(str)) == null || !Utils.isEqual(pathModel.getName(), str))) {
        }
        return pathModel;
    }

    public ClipPathModel getClipPathModelByName(String str) {
        Iterator<ClipPathModel> it2 = this.vectorModel.getClipPathModels().iterator();
        while (it2.hasNext()) {
            ClipPathModel next = it2.next();
            if (Utils.isEqual(next.getName(), str)) {
                return next;
            }
        }
        Iterator<GroupModel> it3 = this.vectorModel.getGroupModels().iterator();
        ClipPathModel clipPathModel = null;
        while (it3.hasNext() && ((clipPathModel = it3.next().getClipPathModelByName(str)) == null || !Utils.isEqual(clipPathModel.getName(), str))) {
        }
        return clipPathModel;
    }

    public void update() {
        invalidateSelf();
    }

    public float getScaleRatio() {
        return this.scaleRatio;
    }

    public float getStrokeRatio() {
        return this.strokeRatio;
    }

    public Matrix getScaleMatrix() {
        return this.scaleMatrix;
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public void setOffsetX(float f) {
        this.offsetX = f;
        invalidateSelf();
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public void setOffsetY(float f) {
        this.offsetY = f;
        invalidateSelf();
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f) {
        this.scaleX = f;
        invalidateSelf();
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f) {
        this.scaleY = f;
        invalidateSelf();
    }
}
