package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v63, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0488  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04f2  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04f6  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x050a  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0395 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x019a  */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        ConstraintWidget constraintWidget;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i3;
        ConstraintWidget constraintWidget3;
        int i4;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        ConstraintAnchor constraintAnchor5;
        float f;
        int size;
        int i5;
        ArrayList<ConstraintWidget> arrayList;
        int i6;
        boolean z3;
        boolean z4;
        int i7;
        ConstraintWidget constraintWidget6;
        boolean z5;
        int i8;
        ConstraintWidget constraintWidget7 = chainHead.mFirst;
        ConstraintWidget constraintWidget8 = chainHead.mLast;
        ConstraintWidget constraintWidget9 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget11 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget12 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget13 = chainHead.mLastMatchConstraintWidget;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z2 = constraintWidget11.mHorizontalChainStyle == 0;
            z = constraintWidget11.mHorizontalChainStyle == 1;
        } else {
            z2 = constraintWidget11.mVerticalChainStyle == 0;
            z = constraintWidget11.mVerticalChainStyle == 1;
        }
        boolean z7 = true;
        ConstraintWidget constraintWidget14 = constraintWidget7;
        boolean z8 = z;
        boolean z9 = z2;
        boolean z10 = false;
        while (true) {
            constraintWidget = null;
            if (z10) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget14.mListAnchors[i2];
            int i9 = (z6 || z7) ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            if (!(constraintAnchor6.mTarget == null || constraintWidget14 == constraintWidget7)) {
                margin += constraintAnchor6.mTarget.getMargin();
            }
            if (z7 && constraintWidget14 != constraintWidget7 && constraintWidget14 != constraintWidget9) {
                z3 = z10;
                z4 = z8;
                i7 = 6;
            } else if (!z9 || !z6) {
                z3 = z10;
                i7 = i9;
                z4 = z8;
            } else {
                z3 = z10;
                z4 = z8;
                i7 = 4;
            }
            if (constraintAnchor6.mTarget != null) {
                if (constraintWidget14 == constraintWidget9) {
                    z5 = z9;
                    constraintWidget6 = constraintWidget11;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, margin, 5);
                } else {
                    constraintWidget6 = constraintWidget11;
                    z5 = z9;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, margin, 6);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, margin, i7);
            } else {
                constraintWidget6 = constraintWidget11;
                z5 = z9;
            }
            if (z6) {
                if (constraintWidget14.getVisibility() == 8 || constraintWidget14.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i8 = 0;
                } else {
                    i8 = 0;
                    linearSystem.addGreaterThan(constraintWidget14.mListAnchors[i2 + 1].mSolverVariable, constraintWidget14.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget14.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i8, 6);
            }
            ConstraintAnchor constraintAnchor7 = constraintWidget14.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget15 = constraintAnchor7.mOwner;
                if (constraintWidget15.mListAnchors[i2].mTarget != null && constraintWidget15.mListAnchors[i2].mTarget.mOwner == constraintWidget14) {
                    constraintWidget = constraintWidget15;
                }
            }
            if (constraintWidget != null) {
                constraintWidget14 = constraintWidget;
                z10 = z3;
            } else {
                z10 = true;
            }
            z8 = z4;
            f2 = f2;
            z9 = z5;
            constraintWidget11 = constraintWidget6;
        }
        if (constraintWidget10 != null) {
            int i10 = i2 + 1;
            if (constraintWidget8.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget10.mListAnchors[i10];
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget8.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                if (z6) {
                    int i11 = i2 + 1;
                    linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i11].mSolverVariable, constraintWidget8.mListAnchors[i11].mSolverVariable, constraintWidget8.mListAnchors[i11].getMargin(), 6);
                }
                ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                    float f3 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f2 : (float) chainHead.mWidgetsMatchCount;
                    float f4 = 0.0f;
                    ConstraintWidget constraintWidget16 = null;
                    i5 = 0;
                    float f5 = 0.0f;
                    while (i5 < size) {
                        ConstraintWidget constraintWidget17 = arrayList2.get(i5);
                        float f6 = constraintWidget17.mWeight[i];
                        if (f6 < f4) {
                            if (chainHead.mHasComplexMatchWeights) {
                                linearSystem.addEquality(constraintWidget17.mListAnchors[i2 + 1].mSolverVariable, constraintWidget17.mListAnchors[i2].mSolverVariable, 0, 4);
                                arrayList = arrayList2;
                                i6 = size;
                                i5++;
                                size = i6;
                                arrayList2 = arrayList;
                                f4 = 0.0f;
                            } else {
                                f6 = 1.0f;
                                f4 = 0.0f;
                            }
                        }
                        if (f6 == f4) {
                            linearSystem.addEquality(constraintWidget17.mListAnchors[i2 + 1].mSolverVariable, constraintWidget17.mListAnchors[i2].mSolverVariable, 0, 6);
                            arrayList = arrayList2;
                            i6 = size;
                            i5++;
                            size = i6;
                            arrayList2 = arrayList;
                            f4 = 0.0f;
                        } else {
                            if (constraintWidget16 != null) {
                                SolverVariable solverVariable7 = constraintWidget16.mListAnchors[i2].mSolverVariable;
                                int i12 = i2 + 1;
                                SolverVariable solverVariable8 = constraintWidget16.mListAnchors[i12].mSolverVariable;
                                SolverVariable solverVariable9 = constraintWidget17.mListAnchors[i2].mSolverVariable;
                                arrayList = arrayList2;
                                SolverVariable solverVariable10 = constraintWidget17.mListAnchors[i12].mSolverVariable;
                                i6 = size;
                                ArrayRow createRow = linearSystem.createRow();
                                createRow.createRowEqualMatchDimensions(f5, f3, f6, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                                linearSystem.addConstraint(createRow);
                            } else {
                                arrayList = arrayList2;
                                i6 = size;
                            }
                            f5 = f6;
                            constraintWidget16 = constraintWidget17;
                            i5++;
                            size = i6;
                            arrayList2 = arrayList;
                            f4 = 0.0f;
                        }
                    }
                }
                if (constraintWidget9 == null && (constraintWidget9 == constraintWidget10 || z7)) {
                    ConstraintAnchor constraintAnchor9 = constraintWidget7.mListAnchors[i2];
                    int i13 = i2 + 1;
                    ConstraintAnchor constraintAnchor10 = constraintWidget8.mListAnchors[i13];
                    SolverVariable solverVariable11 = constraintWidget7.mListAnchors[i2].mTarget != null ? constraintWidget7.mListAnchors[i2].mTarget.mSolverVariable : null;
                    SolverVariable solverVariable12 = constraintWidget8.mListAnchors[i13].mTarget != null ? constraintWidget8.mListAnchors[i13].mTarget.mSolverVariable : null;
                    if (constraintWidget9 == constraintWidget10) {
                        constraintAnchor9 = constraintWidget9.mListAnchors[i2];
                        constraintAnchor10 = constraintWidget9.mListAnchors[i13];
                    }
                    if (!(solverVariable11 == null || solverVariable12 == null)) {
                        if (i == 0) {
                            f = constraintWidget11.mHorizontalBiasPercent;
                        } else {
                            f = constraintWidget11.mVerticalBiasPercent;
                        }
                        linearSystem.addCentering(constraintAnchor9.mSolverVariable, solverVariable11, constraintAnchor9.getMargin(), f, solverVariable12, constraintAnchor10.mSolverVariable, constraintAnchor10.getMargin(), 5);
                    }
                } else if (z9 || constraintWidget9 == null) {
                    int i14 = 8;
                    if (z8 && constraintWidget9 != null) {
                        boolean z11 = chainHead.mWidgetsMatchCount <= 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                        constraintWidget2 = constraintWidget9;
                        ConstraintWidget constraintWidget18 = constraintWidget2;
                        while (constraintWidget2 != null) {
                            ConstraintWidget constraintWidget19 = constraintWidget2.mNextChainWidget[i];
                            while (constraintWidget19 != null && constraintWidget19.getVisibility() == i14) {
                                constraintWidget19 = constraintWidget19.mNextChainWidget[i];
                            }
                            if (constraintWidget2 == constraintWidget9 || constraintWidget2 == constraintWidget10 || constraintWidget19 == null) {
                                constraintWidget3 = constraintWidget18;
                                i4 = 8;
                            } else {
                                ConstraintWidget constraintWidget20 = constraintWidget19 == constraintWidget10 ? null : constraintWidget19;
                                ConstraintAnchor constraintAnchor11 = constraintWidget2.mListAnchors[i2];
                                SolverVariable solverVariable13 = constraintAnchor11.mSolverVariable;
                                if (constraintAnchor11.mTarget != null) {
                                    SolverVariable solverVariable14 = constraintAnchor11.mTarget.mSolverVariable;
                                }
                                int i15 = i2 + 1;
                                SolverVariable solverVariable15 = constraintWidget18.mListAnchors[i15].mSolverVariable;
                                int margin2 = constraintAnchor11.getMargin();
                                int margin3 = constraintWidget2.mListAnchors[i15].getMargin();
                                if (constraintWidget20 != null) {
                                    constraintAnchor4 = constraintWidget20.mListAnchors[i2];
                                    solverVariable4 = constraintAnchor4.mSolverVariable;
                                    solverVariable3 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                                } else {
                                    constraintAnchor4 = constraintWidget2.mListAnchors[i15].mTarget;
                                    solverVariable4 = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                    solverVariable3 = constraintWidget2.mListAnchors[i15].mSolverVariable;
                                }
                                if (constraintAnchor4 != null) {
                                    margin3 += constraintAnchor4.getMargin();
                                }
                                if (constraintWidget18 != null) {
                                    margin2 += constraintWidget18.mListAnchors[i15].getMargin();
                                }
                                int i16 = z11 ? 6 : 4;
                                if (solverVariable13 == null || solverVariable15 == null || solverVariable4 == null || solverVariable3 == null) {
                                    constraintWidget4 = constraintWidget20;
                                    constraintWidget3 = constraintWidget18;
                                    i4 = 8;
                                } else {
                                    constraintWidget4 = constraintWidget20;
                                    constraintWidget3 = constraintWidget18;
                                    i4 = 8;
                                    linearSystem.addCentering(solverVariable13, solverVariable15, margin2, 0.5f, solverVariable4, solverVariable3, margin3, i16);
                                }
                                constraintWidget19 = constraintWidget4;
                            }
                            if (constraintWidget2.getVisibility() == i4) {
                                constraintWidget2 = constraintWidget3;
                            }
                            constraintWidget18 = constraintWidget2;
                            i14 = 8;
                            constraintWidget2 = constraintWidget19;
                        }
                        ConstraintAnchor constraintAnchor12 = constraintWidget9.mListAnchors[i2];
                        constraintAnchor = constraintWidget7.mListAnchors[i2].mTarget;
                        int i17 = i2 + 1;
                        constraintAnchor2 = constraintWidget10.mListAnchors[i17];
                        constraintAnchor3 = constraintWidget8.mListAnchors[i17].mTarget;
                        if (constraintAnchor != null) {
                            i3 = 5;
                        } else if (constraintWidget9 != constraintWidget10) {
                            i3 = 5;
                            linearSystem.addEquality(constraintAnchor12.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor12.getMargin(), 5);
                        } else {
                            i3 = 5;
                            if (constraintAnchor3 != null) {
                                linearSystem.addCentering(constraintAnchor12.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor12.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                            }
                        }
                        if (!(constraintAnchor3 == null || constraintWidget9 == constraintWidget10)) {
                            linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                        }
                    }
                } else {
                    boolean z12 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    ConstraintWidget constraintWidget21 = constraintWidget9;
                    ConstraintWidget constraintWidget22 = constraintWidget21;
                    while (constraintWidget21 != null) {
                        ConstraintWidget constraintWidget23 = constraintWidget21.mNextChainWidget[i];
                        while (true) {
                            if (constraintWidget23 != null) {
                                if (constraintWidget23.getVisibility() != 8) {
                                    break;
                                }
                                constraintWidget23 = constraintWidget23.mNextChainWidget[i];
                            } else {
                                break;
                            }
                        }
                        if (constraintWidget23 != null || constraintWidget21 == constraintWidget10) {
                            ConstraintAnchor constraintAnchor13 = constraintWidget21.mListAnchors[i2];
                            SolverVariable solverVariable16 = constraintAnchor13.mSolverVariable;
                            SolverVariable solverVariable17 = constraintAnchor13.mTarget != null ? constraintAnchor13.mTarget.mSolverVariable : null;
                            if (constraintWidget22 != constraintWidget21) {
                                solverVariable17 = constraintWidget22.mListAnchors[i2 + 1].mSolverVariable;
                            } else if (constraintWidget21 == constraintWidget9 && constraintWidget22 == constraintWidget21) {
                                solverVariable17 = constraintWidget7.mListAnchors[i2].mTarget != null ? constraintWidget7.mListAnchors[i2].mTarget.mSolverVariable : null;
                            }
                            int margin4 = constraintAnchor13.getMargin();
                            int i18 = i2 + 1;
                            int margin5 = constraintWidget21.mListAnchors[i18].getMargin();
                            if (constraintWidget23 != null) {
                                constraintAnchor5 = constraintWidget23.mListAnchors[i2];
                                SolverVariable solverVariable18 = constraintAnchor5.mSolverVariable;
                                solverVariable5 = constraintWidget21.mListAnchors[i18].mSolverVariable;
                                solverVariable6 = solverVariable18;
                            } else {
                                constraintAnchor5 = constraintWidget8.mListAnchors[i18].mTarget;
                                solverVariable6 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                solverVariable5 = constraintWidget21.mListAnchors[i18].mSolverVariable;
                            }
                            if (constraintAnchor5 != null) {
                                margin5 += constraintAnchor5.getMargin();
                            }
                            if (constraintWidget22 != null) {
                                margin4 += constraintWidget22.mListAnchors[i18].getMargin();
                            }
                            if (!(solverVariable16 == null || solverVariable17 == null || solverVariable6 == null || solverVariable5 == null)) {
                                if (constraintWidget21 == constraintWidget9) {
                                    margin4 = constraintWidget9.mListAnchors[i2].getMargin();
                                }
                                constraintWidget5 = constraintWidget23;
                                linearSystem.addCentering(solverVariable16, solverVariable17, margin4, 0.5f, solverVariable6, solverVariable5, constraintWidget21 == constraintWidget10 ? constraintWidget10.mListAnchors[i18].getMargin() : margin5, z12 ? 6 : 4);
                                if (constraintWidget21.getVisibility() == 8) {
                                    constraintWidget22 = constraintWidget21;
                                }
                                constraintWidget21 = constraintWidget5;
                            }
                        }
                        constraintWidget5 = constraintWidget23;
                        if (constraintWidget21.getVisibility() == 8) {
                        }
                        constraintWidget21 = constraintWidget5;
                    }
                }
                if ((!z9 || z8) && constraintWidget9 != null) {
                    ConstraintAnchor constraintAnchor14 = constraintWidget9.mListAnchors[i2];
                    int i19 = i2 + 1;
                    ConstraintAnchor constraintAnchor15 = constraintWidget10.mListAnchors[i19];
                    solverVariable = constraintAnchor14.mTarget == null ? constraintAnchor14.mTarget.mSolverVariable : null;
                    SolverVariable solverVariable19 = constraintAnchor15.mTarget == null ? constraintAnchor15.mTarget.mSolverVariable : null;
                    if (constraintWidget8 == constraintWidget10) {
                        ConstraintAnchor constraintAnchor16 = constraintWidget8.mListAnchors[i19];
                        if (constraintAnchor16.mTarget != null) {
                            constraintWidget = constraintAnchor16.mTarget.mSolverVariable;
                        }
                        solverVariable2 = constraintWidget;
                    } else {
                        solverVariable2 = solverVariable19;
                    }
                    if (constraintWidget9 == constraintWidget10) {
                        constraintAnchor14 = constraintWidget9.mListAnchors[i2];
                        constraintAnchor15 = constraintWidget9.mListAnchors[i19];
                    }
                    if (solverVariable != null && solverVariable2 != null) {
                        int margin6 = constraintAnchor14.getMargin();
                        if (constraintWidget10 != null) {
                            constraintWidget8 = constraintWidget10;
                        }
                        linearSystem.addCentering(constraintAnchor14.mSolverVariable, solverVariable, margin6, 0.5f, solverVariable2, constraintAnchor15.mSolverVariable, constraintWidget8.mListAnchors[i19].getMargin(), 5);
                        return;
                    }
                }
                return;
            }
        }
        if (z6) {
        }
        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (chainHead.mHasUndefinedWeights) {
        }
        float f4 = 0.0f;
        ConstraintWidget constraintWidget16 = null;
        i5 = 0;
        float f5 = 0.0f;
        while (i5 < size) {
        }
        if (constraintWidget9 == null) {
        }
        if (z9) {
        }
        int i14 = 8;
        if (chainHead.mWidgetsMatchCount <= 0) {
        }
        constraintWidget2 = constraintWidget9;
        ConstraintWidget constraintWidget18 = constraintWidget2;
        while (constraintWidget2 != null) {
        }
        ConstraintAnchor constraintAnchor12 = constraintWidget9.mListAnchors[i2];
        constraintAnchor = constraintWidget7.mListAnchors[i2].mTarget;
        int i17 = i2 + 1;
        constraintAnchor2 = constraintWidget10.mListAnchors[i17];
        constraintAnchor3 = constraintWidget8.mListAnchors[i17].mTarget;
        if (constraintAnchor != null) {
        }
        linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
        if (!z9) {
        }
        ConstraintAnchor constraintAnchor14 = constraintWidget9.mListAnchors[i2];
        int i19 = i2 + 1;
        ConstraintAnchor constraintAnchor15 = constraintWidget10.mListAnchors[i19];
        if (constraintAnchor14.mTarget == null) {
        }
        if (constraintAnchor15.mTarget == null) {
        }
        if (constraintWidget8 == constraintWidget10) {
        }
        if (constraintWidget9 == constraintWidget10) {
        }
        if (solverVariable != null) {
        }
    }
}
