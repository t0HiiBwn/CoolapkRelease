package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    private static boolean optimizableMatchConstraint(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        char c = 1;
        if (constraintWidget.mDimensionRatio != 0.0f) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
            if (i != 0) {
                c = 0;
            }
            if (dimensionBehaviourArr[c] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (constraintWidget.mMatchConstraintDefaultWidth != 0 || constraintWidget.mMatchConstraintMinWidth != 0 || constraintWidget.mMatchConstraintMaxWidth != 0) {
                return false;
            }
        } else if (constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
            return false;
        }
        return true;
    }

    static void analyze(int i, ConstraintWidget constraintWidget) {
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget.mBottom.getResolutionNode();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 0);
        if (!(resolutionNode.type == 4 || resolutionNode3.type == 4)) {
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, (float) (-constraintWidget.getWidth()));
                        resolutionNode3.setOpposite(resolutionNode, (float) constraintWidget.getWidth());
                    }
                }
            } else if (z2) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget != null) {
                    if (constraintWidget.mLeft.mTarget != null || constraintWidget.mRight.mTarget == null) {
                        if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                            if (z) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, (float) (-width));
                                resolutionNode3.setOpposite(resolutionNode, (float) width);
                                constraintWidget.setWidth(width);
                            }
                        }
                    } else if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        boolean z3 = constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 1);
        if (resolutionNode2.type != 4 && resolutionNode4.type != 4) {
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || (z3 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaseline.mTarget != null) {
                        constraintWidget.mBaseline.getResolutionNode().setType(1);
                        resolutionNode2.dependsOn(1, constraintWidget.mBaseline.getResolutionNode(), -constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    if (z) {
                        resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                    } else {
                        resolutionNode2.setOpposite(resolutionNode4, (float) (-constraintWidget.getHeight()));
                        resolutionNode4.setOpposite(resolutionNode2, (float) constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                    }
                }
            } else if (z3) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget != null) {
                    if (constraintWidget.mTop.mTarget != null || constraintWidget.mBottom.mTarget == null) {
                        if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                            if (z) {
                                constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                resolutionNode2.setType(3);
                                resolutionNode4.setType(3);
                                resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                                resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                                return;
                            }
                            resolutionNode2.setType(2);
                            resolutionNode4.setType(2);
                            resolutionNode2.setOpposite(resolutionNode4, (float) (-height));
                            resolutionNode4.setOpposite(resolutionNode2, (float) height);
                            constraintWidget.setHeight(height);
                            if (constraintWidget.mBaselineDistance > 0) {
                                constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                            }
                        }
                    } else if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                    }
                } else if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, height);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r7.mHorizontalChainStyle == 2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r7.mVerticalChainStyle == 2) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0106  */
    static boolean applyChainOptimized(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        float f;
        int i3;
        int i4;
        float f2;
        ConstraintWidget constraintWidget;
        boolean z3;
        int i5;
        ConstraintWidget constraintWidget2 = chainHead.mFirst;
        ConstraintWidget constraintWidget3 = chainHead.mLast;
        ConstraintWidget constraintWidget4 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget6 = chainHead.mHead;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget7 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget8 = chainHead.mLastMatchConstraintWidget;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.mListDimensionBehaviors[i];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z2 = constraintWidget6.mHorizontalChainStyle == 0;
            z = constraintWidget6.mHorizontalChainStyle == 1;
        } else {
            z2 = constraintWidget6.mVerticalChainStyle == 0;
            z = constraintWidget6.mVerticalChainStyle == 1;
        }
        boolean z4 = true;
        ConstraintWidget constraintWidget9 = constraintWidget2;
        int i6 = 0;
        boolean z5 = false;
        int i7 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        while (!z5) {
            if (constraintWidget9.getVisibility() != 8) {
                i7++;
                if (i == 0) {
                    i5 = constraintWidget9.getWidth();
                } else {
                    i5 = constraintWidget9.getHeight();
                }
                f4 += (float) i5;
                if (constraintWidget9 != constraintWidget4) {
                    f4 += (float) constraintWidget9.mListAnchors[i2].getMargin();
                }
                if (constraintWidget9 != constraintWidget5) {
                    f4 += (float) constraintWidget9.mListAnchors[i2 + 1].getMargin();
                }
                f5 = f5 + ((float) constraintWidget9.mListAnchors[i2].getMargin()) + ((float) constraintWidget9.mListAnchors[i2 + 1].getMargin());
            }
            ConstraintAnchor constraintAnchor = constraintWidget9.mListAnchors[i2];
            if (constraintWidget9.getVisibility() != 8 && constraintWidget9.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i6++;
                if (i != 0) {
                    z3 = false;
                    if (constraintWidget9.mMatchConstraintDefaultHeight != 0) {
                        return false;
                    }
                    if (constraintWidget9.mMatchConstraintMinHeight == 0) {
                        if (constraintWidget9.mMatchConstraintMaxHeight != 0) {
                        }
                    }
                    return z3;
                } else if (constraintWidget9.mMatchConstraintDefaultWidth != 0) {
                    return false;
                } else {
                    z3 = false;
                    if (!(constraintWidget9.mMatchConstraintMinWidth == 0 && constraintWidget9.mMatchConstraintMaxWidth == 0)) {
                        return false;
                    }
                }
                if (constraintWidget9.mDimensionRatio != 0.0f) {
                    return z3;
                }
            }
            ConstraintAnchor constraintAnchor2 = constraintWidget9.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor2 != null) {
                ConstraintWidget constraintWidget10 = constraintAnchor2.mOwner;
                if (constraintWidget10.mListAnchors[i2].mTarget != null && constraintWidget10.mListAnchors[i2].mTarget.mOwner == constraintWidget9) {
                    constraintWidget = constraintWidget10;
                    if (constraintWidget == null) {
                        constraintWidget9 = constraintWidget;
                    } else {
                        z5 = true;
                    }
                }
            }
            constraintWidget = null;
            if (constraintWidget == null) {
            }
        }
        ResolutionAnchor resolutionNode = constraintWidget2.mListAnchors[i2].getResolutionNode();
        int i8 = i2 + 1;
        ResolutionAnchor resolutionNode2 = constraintWidget3.mListAnchors[i8].getResolutionNode();
        if (resolutionNode.target == null || resolutionNode2.target == null || resolutionNode.target.state != 1 || resolutionNode2.target.state != 1) {
            return false;
        }
        if (i6 > 0 && i6 != i7) {
            return false;
        }
        if (z4 || z2 || z) {
            f = constraintWidget4 != null ? (float) constraintWidget4.mListAnchors[i2].getMargin() : 0.0f;
            if (constraintWidget5 != null) {
                f += (float) constraintWidget5.mListAnchors[i8].getMargin();
            }
        } else {
            f = 0.0f;
        }
        float f6 = resolutionNode.target.resolvedOffset;
        float f7 = resolutionNode2.target.resolvedOffset;
        float f8 = (f6 < f7 ? f7 - f6 : f6 - f7) - f4;
        if (i6 <= 0 || i6 != i7) {
            if (f8 < 0.0f) {
                z4 = true;
                z2 = false;
                z = false;
            }
            if (z4) {
                ConstraintWidget constraintWidget11 = constraintWidget2;
                float biasPercent = f6 + ((f8 - f) * constraintWidget11.getBiasPercent(i));
                while (constraintWidget11 != null) {
                    if (LinearSystem.sMetrics != null) {
                        LinearSystem.sMetrics.nonresolvedWidgets--;
                        LinearSystem.sMetrics.resolvedWidgets++;
                        LinearSystem.sMetrics.chainConnectionResolved++;
                    }
                    constraintWidget11 = constraintWidget11.mNextChainWidget[i];
                    if (constraintWidget11 != null || constraintWidget11 == constraintWidget3) {
                        if (i == 0) {
                            i4 = constraintWidget11.getWidth();
                        } else {
                            i4 = constraintWidget11.getHeight();
                        }
                        float margin = biasPercent + ((float) constraintWidget11.mListAnchors[i2].getMargin());
                        constraintWidget11.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin);
                        float f9 = margin + ((float) i4);
                        constraintWidget11.mListAnchors[i8].getResolutionNode().resolve(resolutionNode.resolvedTarget, f9);
                        constraintWidget11.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                        constraintWidget11.mListAnchors[i8].getResolutionNode().addResolvedValue(linearSystem);
                        biasPercent = f9 + ((float) constraintWidget11.mListAnchors[i8].getMargin());
                    }
                }
                return true;
            }
            ConstraintWidget constraintWidget12 = constraintWidget2;
            if (!z2 && !z) {
                return true;
            }
            if (z2 || z) {
                f8 -= f;
            }
            float f10 = f8 / ((float) (i7 + 1));
            if (z) {
                f10 = f8 / (i7 > 1 ? (float) (i7 - 1) : 2.0f);
            }
            float f11 = constraintWidget12.getVisibility() != 8 ? f6 + f10 : f6;
            if (z && i7 > 1) {
                f11 = ((float) constraintWidget4.mListAnchors[i2].getMargin()) + f6;
            }
            if (z2 && constraintWidget4 != null) {
                f11 += (float) constraintWidget4.mListAnchors[i2].getMargin();
            }
            while (constraintWidget12 != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget13 = constraintWidget12.mNextChainWidget[i];
                if (constraintWidget13 != null || constraintWidget12 == constraintWidget3) {
                    if (i == 0) {
                        i3 = constraintWidget12.getWidth();
                    } else {
                        i3 = constraintWidget12.getHeight();
                    }
                    float f12 = (float) i3;
                    if (constraintWidget12 != constraintWidget4) {
                        f11 += (float) constraintWidget12.mListAnchors[i2].getMargin();
                    }
                    constraintWidget12.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, f11);
                    constraintWidget12.mListAnchors[i8].getResolutionNode().resolve(resolutionNode.resolvedTarget, f11 + f12);
                    constraintWidget12.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget12.mListAnchors[i8].getResolutionNode().addResolvedValue(linearSystem);
                    f11 += f12 + ((float) constraintWidget12.mListAnchors[i8].getMargin());
                    if (constraintWidget13 != null) {
                        if (constraintWidget13.getVisibility() != 8) {
                            f11 += f10;
                        }
                        constraintWidget12 = constraintWidget13;
                    }
                }
                constraintWidget12 = constraintWidget13;
            }
            return true;
        } else if (constraintWidget9.getParent() != null && constraintWidget9.getParent().mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            return false;
        } else {
            float f13 = (f8 + f4) - f5;
            ConstraintWidget constraintWidget14 = constraintWidget2;
            while (constraintWidget14 != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget15 = constraintWidget14.mNextChainWidget[i];
                if (constraintWidget15 != null || constraintWidget14 == constraintWidget3) {
                    float f14 = f13 / ((float) i6);
                    if (f3 > 0.0f) {
                        if (constraintWidget14.mWeight[i] == -1.0f) {
                            f2 = 0.0f;
                            if (constraintWidget14.getVisibility() == 8) {
                                f2 = 0.0f;
                            }
                            float margin2 = f6 + ((float) constraintWidget14.mListAnchors[i2].getMargin());
                            constraintWidget14.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin2);
                            float f15 = margin2 + f2;
                            constraintWidget14.mListAnchors[i8].getResolutionNode().resolve(resolutionNode.resolvedTarget, f15);
                            constraintWidget14.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                            constraintWidget14.mListAnchors[i8].getResolutionNode().addResolvedValue(linearSystem);
                            f6 = f15 + ((float) constraintWidget14.mListAnchors[i8].getMargin());
                        } else {
                            f14 = (constraintWidget14.mWeight[i] * f13) / f3;
                        }
                    }
                    f2 = f14;
                    if (constraintWidget14.getVisibility() == 8) {
                    }
                    float margin2 = f6 + ((float) constraintWidget14.mListAnchors[i2].getMargin());
                    constraintWidget14.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin2);
                    float f15 = margin2 + f2;
                    constraintWidget14.mListAnchors[i8].getResolutionNode().resolve(resolutionNode.resolvedTarget, f15);
                    constraintWidget14.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget14.mListAnchors[i8].getResolutionNode().addResolvedValue(linearSystem);
                    f6 = f15 + ((float) constraintWidget14.mListAnchors[i8].getMargin());
                }
                constraintWidget14 = constraintWidget15;
            }
            return true;
        }
    }

    static void setOptimizedWidget(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedTarget = constraintWidget.getParent().mLeft.getResolutionNode();
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset = (float) i2;
        constraintWidget.mListAnchors[i3].getResolutionNode().state = 1;
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedTarget = constraintWidget.mListAnchors[i3].getResolutionNode();
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset = (float) constraintWidget.getLength(i);
        constraintWidget.mListAnchors[i4].getResolutionNode().state = 1;
    }
}
