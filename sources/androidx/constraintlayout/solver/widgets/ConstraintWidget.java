package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintWidgetGroup mBelongingGroup;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    boolean mOptimizerMeasured;
    ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    int[] mResolvedMatchConstraintDefault;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;
    protected int mX;
    protected int mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void resolve() {
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        ResolutionDimension resolutionDimension = this.mResolutionWidth;
        if (resolutionDimension != null) {
            resolutionDimension.reset();
        }
        ResolutionDimension resolutionDimension2 = this.mResolutionHeight;
        if (resolutionDimension2 != null) {
            resolutionDimension2.reset();
        }
        this.mBelongingGroup = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public boolean isFullyResolved() {
        if (this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1) {
            return true;
        }
        return false;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        ConstraintWidget constraintWidget;
        return (this instanceof ConstraintWidgetContainer) && ((constraintWidget = this.mParent) == null || !(constraintWidget instanceof ConstraintWidgetContainer));
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        if (constraintWidget instanceof WidgetContainer) {
            return (WidgetContainer) constraintWidget;
        }
        return null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    int getInternalDrawX() {
        return this.mDrawX;
    }

    int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else {
            i = this.mMatchConstraintMinWidth;
            if (i > 0) {
                this.mWidth = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else {
            i = this.mMatchConstraintMinHeight;
            if (i > 0) {
                this.mHeight = i;
            } else {
                i = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= i) ? i : i3;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
        } else if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        }
    }

    public void updateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = (this.mWidth + i) - i;
        this.mDrawHeight = (this.mHeight + i2) - i2;
    }

    public void forceUpdateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = (this.mWidth + i) - i;
        this.mDrawHeight = (this.mHeight + i2) - i2;
    }

    public void setDrawOrigin(int i, int i2) {
        int i3 = i - this.mOffsetX;
        this.mDrawX = i3;
        int i4 = i2 - this.mOffsetY;
        this.mDrawY = i4;
        this.mX = i3;
        this.mY = i4;
    }

    public void setDrawX(int i) {
        int i2 = i - this.mOffsetX;
        this.mDrawX = i2;
        this.mX = i2;
    }

    public void setDrawY(int i) {
        int i2 = i - this.mOffsetY;
        this.mDrawY = i2;
        this.mY = i2;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f < 1.0f && i == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    public void setDimensionRatio(String str) {
        float f;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i = 1;
            }
            i2 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i2);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
                if (f > 0.0f) {
                    this.mDimensionRatio = f;
                    this.mDimensionRatioSide = i;
                    return;
                }
                return;
            }
        } else {
            String substring3 = str.substring(i2, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f = i == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        if (f > 0.0f) {
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        f = 0.0f;
        if (f > 0.0f) {
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i7 < (i6 = this.mWidth)) {
            i7 = i6;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i8 < (i5 = this.mHeight)) {
            i8 = i5;
        }
        this.mWidth = i7;
        this.mHeight = i8;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            this.mHeight = i9;
        }
        int i10 = this.mMinWidth;
        if (i7 < i10) {
            this.mWidth = i10;
        }
        this.mOptimizerMeasured = true;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
        this.mOptimizerMeasured = true;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength, int i2) {
        boolean z;
        int i3 = 0;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0, strength, i2);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0, strength, i2);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0, strength, i2);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0, strength, i2);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, i2);
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, i2);
                } else if (z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, i2);
                }
            } else if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0, strength, i2);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0, strength, i2);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i2);
            } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0, strength, i2);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0, strength, i2);
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i2);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0, i2);
            anchor7.connect(anchor6, 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0, i2);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0, i2);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0, i2);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0, i2);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0, i2);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0, i2);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i2);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0, i2);
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                } else {
                    if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                        if (anchor13 != null) {
                            anchor13.reset();
                        }
                        ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor14.getTarget() != anchor10) {
                            anchor14.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                        if (anchor15.isConnected()) {
                            opposite.reset();
                            anchor15.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor16.getTarget() != anchor10) {
                            anchor16.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                        if (anchor17.isConnected()) {
                            opposite2.reset();
                            anchor17.reset();
                        }
                    }
                    i3 = i;
                }
                anchor9.connect(anchor10, i3, strength, i2);
                anchor10.getOwner().connectedTo(anchor9.getOwner());
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (!(this instanceof ConstraintWidgetContainer)) {
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getWidth() > getMinWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
            if (getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
                return;
            }
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = this.mAnchors.get(i2);
                if (i == constraintAnchor.getConnectionCreator()) {
                    if (constraintAnchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            if (constraintAnchor != constraintAnchorArr[i2]) {
                int i3 = i2 + 1;
                if (constraintAnchorArr[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0252 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        boolean z5;
        int i3;
        int i4;
        SolverVariable solverVariable;
        boolean z6;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        boolean z7;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        boolean z8;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget;
        int i5;
        boolean z9;
        boolean z10;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget2 = this.mParent;
        if (constraintWidget2 != null) {
            z4 = constraintWidget2 != null && constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget3 = this.mParent;
            boolean z11 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                z9 = true;
            } else {
                z9 = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                z10 = true;
            } else {
                z10 = isInVerticalChain();
            }
            if (z4 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (z11 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z3 = z11;
            z2 = z9;
            z = z10;
        } else {
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        int i6 = this.mWidth;
        int i7 = this.mMinWidth;
        if (i6 < i7) {
            i6 = i7;
        }
        int i8 = this.mHeight;
        int i9 = this.mMinHeight;
        if (i8 < i9) {
            i8 = i9;
        }
        boolean z12 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z13 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i10 = this.mMatchConstraintDefaultWidth;
        int i11 = this.mMatchConstraintDefaultHeight;
        if (f <= 0.0f || this.mVisibility == 8) {
            solverVariable = createObjectVariable5;
            i2 = i10;
            i4 = i6;
            i3 = i8;
            i = i11;
            z5 = false;
        } else {
            solverVariable = createObjectVariable5;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i10 == 0) {
                i10 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i11 == 0) {
                i11 = 3;
            }
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i10 == 3 && i11 == 3) {
                setupDimensionRatio(z4, z3, z12, z13);
            } else if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i10 == 3) {
                this.mResolvedDimensionRatioSide = 0;
                DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[1];
                DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
                i4 = (int) (this.mResolvedDimensionRatio * ((float) this.mHeight));
                if (dimensionBehaviour != dimensionBehaviour2) {
                    i3 = i8;
                    i = i11;
                    z5 = false;
                    i2 = 4;
                } else {
                    i2 = i10;
                    i3 = i8;
                    i = i11;
                    z5 = true;
                }
            } else if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i11 == 3) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
                DimensionBehaviour dimensionBehaviour3 = this.mListDimensionBehaviors[0];
                DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
                i3 = (int) (this.mResolvedDimensionRatio * ((float) this.mWidth));
                i2 = i10;
                i4 = i6;
                if (dimensionBehaviour3 != dimensionBehaviour4) {
                    z5 = false;
                    i = 4;
                }
                i = i11;
                z5 = true;
            }
            i2 = i10;
            i4 = i6;
            i3 = i8;
            i = i11;
            z5 = true;
        }
        int[] iArr = this.mResolvedMatchConstraintDefault;
        iArr[0] = i2;
        iArr[1] = i;
        if (z5) {
            int i12 = this.mResolvedDimensionRatioSide;
            if (i12 == 0 || i12 == -1) {
                z6 = true;
                boolean z14 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                boolean z15 = !this.mCenter.isConnected();
                if (this.mHorizontalResolution == 2) {
                    ConstraintWidget constraintWidget4 = this.mParent;
                    SolverVariable createObjectVariable6 = constraintWidget4 != null ? linearSystem.createObjectVariable(constraintWidget4.mRight) : null;
                    ConstraintWidget constraintWidget5 = this.mParent;
                    z7 = z3;
                    solverVariable3 = solverVariable;
                    solverVariable5 = createObjectVariable4;
                    solverVariable2 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    applyConstraints(linearSystem, z4, constraintWidget5 != null ? linearSystem.createObjectVariable(constraintWidget5.mLeft) : null, createObjectVariable6, this.mListDimensionBehaviors[0], z14, this.mLeft, this.mRight, this.mX, i4, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z2, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z15);
                } else {
                    solverVariable2 = createObjectVariable3;
                    solverVariable4 = createObjectVariable2;
                    z7 = z3;
                    solverVariable3 = solverVariable;
                    solverVariable5 = createObjectVariable4;
                }
                if (this.mVerticalResolution == 2) {
                    boolean z16 = this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                    boolean z17 = z5 && ((i5 = this.mResolvedDimensionRatioSide) == 1 || i5 == -1);
                    if (this.mBaselineDistance <= 0) {
                        linearSystem2 = linearSystem;
                    } else if (this.mBaseline.getResolutionNode().state == 1) {
                        linearSystem2 = linearSystem;
                        this.mBaseline.getResolutionNode().addResolvedValue(linearSystem2);
                    } else {
                        linearSystem2 = linearSystem;
                        solverVariable6 = solverVariable2;
                        linearSystem2.addEquality(solverVariable3, solverVariable6, getBaselineDistance(), 6);
                        if (this.mBaseline.mTarget != null) {
                            linearSystem2.addEquality(solverVariable3, linearSystem2.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                            z8 = false;
                            ConstraintWidget constraintWidget6 = this.mParent;
                            SolverVariable createObjectVariable7 = constraintWidget6 != null ? linearSystem2.createObjectVariable(constraintWidget6.mBottom) : null;
                            ConstraintWidget constraintWidget7 = this.mParent;
                            applyConstraints(linearSystem, z7, constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z16, this.mTop, this.mBottom, this.mY, i3, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z17, z, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                            if (z5) {
                                constraintWidget = this;
                                if (constraintWidget.mResolvedDimensionRatioSide == 1) {
                                    linearSystem.addRatio(solverVariable5, solverVariable6, solverVariable4, createObjectVariable, constraintWidget.mResolvedDimensionRatio, 6);
                                } else {
                                    linearSystem.addRatio(solverVariable4, createObjectVariable, solverVariable5, solverVariable6, constraintWidget.mResolvedDimensionRatio, 6);
                                }
                            } else {
                                constraintWidget = this;
                            }
                            if (constraintWidget.mCenter.isConnected()) {
                                linearSystem.addCenterPoint(constraintWidget, constraintWidget.mCenter.getTarget().getOwner(), (float) Math.toRadians((double) (constraintWidget.mCircleConstraintAngle + 90.0f)), constraintWidget.mCenter.getMargin());
                                return;
                            }
                            return;
                        }
                        z8 = z15;
                        ConstraintWidget constraintWidget6 = this.mParent;
                        if (constraintWidget6 != null) {
                        }
                        ConstraintWidget constraintWidget7 = this.mParent;
                        applyConstraints(linearSystem, z7, constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z16, this.mTop, this.mBottom, this.mY, i3, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z17, z, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                        if (z5) {
                        }
                        if (constraintWidget.mCenter.isConnected()) {
                        }
                    }
                    solverVariable6 = solverVariable2;
                    z8 = z15;
                    ConstraintWidget constraintWidget6 = this.mParent;
                    if (constraintWidget6 != null) {
                    }
                    ConstraintWidget constraintWidget7 = this.mParent;
                    applyConstraints(linearSystem, z7, constraintWidget7 != null ? linearSystem2.createObjectVariable(constraintWidget7.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z16, this.mTop, this.mBottom, this.mY, i3, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z17, z, i, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z8);
                    if (z5) {
                    }
                    if (constraintWidget.mCenter.isConnected()) {
                    }
                } else {
                    return;
                }
            }
        }
        z6 = false;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
        }
        boolean z15 = !this.mCenter.isConnected();
        if (this.mHorizontalResolution == 2) {
        }
        if (this.mVerticalResolution == 2) {
        }
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ca A[ADDED_TO_REGION] */
    private void applyConstraints(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        int i8;
        boolean z6;
        int i9;
        int i10;
        int i11;
        SolverVariable solverVariable3;
        boolean z7;
        int i12;
        int i13;
        SolverVariable solverVariable4;
        int i14;
        SolverVariable solverVariable5;
        int i15;
        int i16;
        boolean z8;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        boolean z9;
        boolean z10;
        SolverVariable solverVariable8;
        boolean z11;
        int i17;
        int i18;
        SolverVariable solverVariable9;
        boolean z12;
        int i19;
        int i20;
        boolean z13;
        boolean z14;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (linearSystem.graphOptimizer && constraintAnchor.getResolutionNode().state == 1 && constraintAnchor2.getResolutionNode().state == 1) {
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().resolvedWidgets++;
            }
            constraintAnchor.getResolutionNode().addResolvedValue(linearSystem);
            constraintAnchor2.getResolutionNode().addResolvedValue(linearSystem);
            if (!z4 && z) {
                linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 6);
                return;
            }
            return;
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        if (isConnected2) {
            i8 = (isConnected ? 1 : 0) + 1;
        } else {
            i8 = isConnected ? 1 : 0;
        }
        if (isConnected3) {
            i8++;
        }
        int i21 = z3 ? 3 : i5;
        int i22 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        boolean z15 = (i22 == 1 || i22 == 2 || i22 == 3 || i22 != 4 || i21 == 4) ? false : true;
        if (this.mVisibility == 8) {
            i9 = 0;
            z6 = false;
        } else {
            z6 = z15;
            i9 = i2;
        }
        if (z5) {
            if (!isConnected && !isConnected2 && !isConnected3) {
                linearSystem.addEquality(createObjectVariable, i);
            } else if (isConnected && !isConnected2) {
                i10 = 6;
                linearSystem.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 6);
                if (z6) {
                    if (z2) {
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
                        if (i3 > 0) {
                            linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i3, 6);
                        }
                        if (i4 < Integer.MAX_VALUE) {
                            linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i4, 6);
                        }
                    } else {
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, i9, i10);
                    }
                    i12 = i6;
                    i11 = i21;
                    i14 = i8;
                    solverVariable4 = createObjectVariable4;
                    solverVariable3 = createObjectVariable3;
                    z7 = z6;
                    i13 = i7;
                } else {
                    i12 = i6;
                    int i23 = i7;
                    if (i12 == -2) {
                        i12 = i9;
                    }
                    if (i23 == -2) {
                        i23 = i9;
                    }
                    if (i12 > 0) {
                        linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, i12, 6);
                        i9 = Math.max(i9, i12);
                    }
                    if (i23 > 0) {
                        linearSystem.addLowerThan(createObjectVariable2, createObjectVariable, i23, 6);
                        i9 = Math.min(i9, i23);
                    }
                    if (i21 != 1) {
                        z14 = z6;
                        if (i21 == 2) {
                            if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                                solverVariable10 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                solverVariable11 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                            } else {
                                solverVariable10 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                solverVariable11 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                            }
                            solverVariable3 = createObjectVariable3;
                            i20 = i9;
                            i11 = i21;
                            i14 = i8;
                            i13 = i23;
                            solverVariable4 = createObjectVariable4;
                            linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable2, createObjectVariable, solverVariable11, solverVariable10, f2));
                            z13 = false;
                            if (z13) {
                            }
                            z7 = z13;
                        }
                    } else if (z) {
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, i9, 6);
                        i11 = i21;
                        i14 = i8;
                        solverVariable4 = createObjectVariable4;
                        solverVariable3 = createObjectVariable3;
                        z14 = z6;
                        i20 = i9;
                        i13 = i23;
                        z13 = z14;
                        if (z13 || i14 == 2 || z3) {
                            z7 = z13;
                        } else {
                            int max = Math.max(i12, i20);
                            if (i13 > 0) {
                                max = Math.min(i13, max);
                            }
                            linearSystem.addEquality(createObjectVariable2, createObjectVariable, max, 6);
                            z7 = false;
                        }
                    } else if (z4) {
                        z14 = z6;
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, i9, 4);
                    } else {
                        z14 = z6;
                        linearSystem.addEquality(createObjectVariable2, createObjectVariable, i9, 1);
                    }
                    i11 = i21;
                    i14 = i8;
                    i13 = i23;
                    solverVariable4 = createObjectVariable4;
                    solverVariable3 = createObjectVariable3;
                    i20 = i9;
                    z13 = z14;
                    if (z13) {
                    }
                    z7 = z13;
                }
                if (!z5 && !z4) {
                    if (isConnected || isConnected2 || isConnected3) {
                        if (!isConnected || isConnected2) {
                            if (!isConnected && isConnected2) {
                                linearSystem.addEquality(createObjectVariable2, solverVariable4, -constraintAnchor2.getMargin(), 6);
                                if (z) {
                                    linearSystem.addGreaterThan(createObjectVariable, solverVariable, 0, 5);
                                }
                            } else if (isConnected && isConnected2) {
                                if (z7) {
                                    solverVariable6 = solverVariable4;
                                    if (z && i3 == 0) {
                                        linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 6);
                                    }
                                    if (i11 == 0) {
                                        if (i13 > 0 || i12 > 0) {
                                            i19 = 4;
                                            z12 = true;
                                        } else {
                                            i19 = 6;
                                            z12 = false;
                                        }
                                        solverVariable7 = solverVariable3;
                                        linearSystem.addEquality(createObjectVariable, solverVariable7, constraintAnchor.getMargin(), i19);
                                        linearSystem.addEquality(createObjectVariable2, solverVariable6, -constraintAnchor2.getMargin(), i19);
                                        z9 = i13 > 0 || i12 > 0;
                                        z8 = z12;
                                        i16 = 5;
                                    } else {
                                        solverVariable7 = solverVariable3;
                                        if (i11 == 1) {
                                            z9 = true;
                                            z8 = true;
                                            i16 = 6;
                                        } else if (i11 == 3) {
                                            int i24 = (z3 || this.mResolvedDimensionRatioSide == -1 || i13 > 0) ? 4 : 6;
                                            linearSystem.addEquality(createObjectVariable, solverVariable7, constraintAnchor.getMargin(), i24);
                                            linearSystem.addEquality(createObjectVariable2, solverVariable6, -constraintAnchor2.getMargin(), i24);
                                            z9 = true;
                                            z8 = true;
                                            i16 = 5;
                                            if (z9) {
                                                solverVariable8 = solverVariable6;
                                                solverVariable9 = solverVariable7;
                                                solverVariable5 = createObjectVariable2;
                                                linearSystem.addCentering(createObjectVariable, solverVariable7, constraintAnchor.getMargin(), f, solverVariable6, createObjectVariable2, constraintAnchor2.getMargin(), i16);
                                                boolean z16 = constraintAnchor.mTarget.mOwner instanceof Barrier;
                                                boolean z17 = constraintAnchor2.mTarget.mOwner instanceof Barrier;
                                                if (z16 && !z17) {
                                                    z11 = z;
                                                    i18 = 6;
                                                    i17 = 5;
                                                    z10 = true;
                                                    if (z8) {
                                                    }
                                                    linearSystem.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i17);
                                                    linearSystem.addLowerThan(solverVariable5, solverVariable8, -constraintAnchor2.getMargin(), i18);
                                                    i15 = 0;
                                                    if (z) {
                                                    }
                                                    if (!z) {
                                                    }
                                                } else if (!z16 && z17) {
                                                    z10 = z;
                                                    i18 = 5;
                                                    i17 = 6;
                                                    z11 = true;
                                                    if (z8) {
                                                        i18 = 6;
                                                        i17 = 6;
                                                    }
                                                    if ((!z7 && z11) || z8) {
                                                        linearSystem.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i17);
                                                    }
                                                    if ((!z7 && z10) || z8) {
                                                        linearSystem.addLowerThan(solverVariable5, solverVariable8, -constraintAnchor2.getMargin(), i18);
                                                    }
                                                    i15 = 0;
                                                    if (z) {
                                                        linearSystem.addGreaterThan(createObjectVariable, solverVariable, 0, 6);
                                                    }
                                                    if (!z) {
                                                        linearSystem.addGreaterThan(solverVariable2, solverVariable5, i15, 6);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                solverVariable9 = solverVariable7;
                                                solverVariable8 = solverVariable6;
                                                solverVariable5 = createObjectVariable2;
                                            }
                                            z11 = z;
                                            z10 = z11;
                                            i18 = 5;
                                            i17 = 5;
                                            if (z8) {
                                            }
                                            linearSystem.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i17);
                                            linearSystem.addLowerThan(solverVariable5, solverVariable8, -constraintAnchor2.getMargin(), i18);
                                            i15 = 0;
                                            if (z) {
                                            }
                                            if (!z) {
                                            }
                                        } else {
                                            z9 = false;
                                        }
                                    }
                                    if (z9) {
                                    }
                                    z11 = z;
                                    z10 = z11;
                                    i18 = 5;
                                    i17 = 5;
                                    if (z8) {
                                    }
                                    linearSystem.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i17);
                                    linearSystem.addLowerThan(solverVariable5, solverVariable8, -constraintAnchor2.getMargin(), i18);
                                    i15 = 0;
                                    if (z) {
                                    }
                                    if (!z) {
                                    }
                                } else {
                                    solverVariable6 = solverVariable4;
                                    solverVariable7 = solverVariable3;
                                    z9 = true;
                                }
                                z8 = false;
                                i16 = 5;
                                if (z9) {
                                }
                                z11 = z;
                                z10 = z11;
                                i18 = 5;
                                i17 = 5;
                                if (z8) {
                                }
                                linearSystem.addGreaterThan(createObjectVariable, solverVariable9, constraintAnchor.getMargin(), i17);
                                linearSystem.addLowerThan(solverVariable5, solverVariable8, -constraintAnchor2.getMargin(), i18);
                                i15 = 0;
                                if (z) {
                                }
                                if (!z) {
                                }
                            }
                        } else if (z) {
                            linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 5);
                        }
                    } else if (z) {
                        linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 5);
                    }
                    solverVariable5 = createObjectVariable2;
                    i15 = 0;
                    if (!z) {
                    }
                } else if (i14 < 2 && z) {
                    linearSystem.addGreaterThan(createObjectVariable, solverVariable, 0, 6);
                    linearSystem.addGreaterThan(solverVariable2, createObjectVariable2, 0, 6);
                    return;
                }
            }
        }
        i10 = 6;
        if (z6) {
        }
        if (!z5) {
        }
        if (i14 < 2) {
        }
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }
}
