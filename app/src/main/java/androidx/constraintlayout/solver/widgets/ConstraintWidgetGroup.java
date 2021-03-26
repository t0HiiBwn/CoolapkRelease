package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup {
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions = {-1, -1};
    int mGroupHeight = -1;
    int mGroupWidth = -1;
    public boolean mSkipSolver = false;
    List<ConstraintWidget> mStartHorizontalWidgets = new ArrayList();
    List<ConstraintWidget> mStartVerticalWidgets = new ArrayList();
    List<ConstraintWidget> mUnresolvedWidgets = new ArrayList();
    HashSet<ConstraintWidget> mWidgetsToSetHorizontal = new HashSet<>();
    HashSet<ConstraintWidget> mWidgetsToSetVertical = new HashSet<>();
    List<ConstraintWidget> mWidgetsToSolve = new ArrayList();

    ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.mConstrainedGroup = list;
    }

    ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }

    public List<ConstraintWidget> getStartWidgets(int i) {
        if (i == 0) {
            return this.mStartHorizontalWidgets;
        }
        if (i == 1) {
            return this.mStartVerticalWidgets;
        }
        return null;
    }

    Set<ConstraintWidget> getWidgetsToSet(int i) {
        if (i == 0) {
            return this.mWidgetsToSetHorizontal;
        }
        if (i == 1) {
            return this.mWidgetsToSetVertical;
        }
        return null;
    }

    void addWidgetsToSet(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            this.mWidgetsToSetHorizontal.add(constraintWidget);
        } else if (i == 1) {
            this.mWidgetsToSetVertical.add(constraintWidget);
        }
    }

    List<ConstraintWidget> getWidgetsToSolve() {
        if (!this.mWidgetsToSolve.isEmpty()) {
            return this.mWidgetsToSolve;
        }
        int size = this.mConstrainedGroup.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mConstrainedGroup.get(i);
            if (!constraintWidget.mOptimizerMeasurable) {
                getWidgetsToSolveTraversal((ArrayList) this.mWidgetsToSolve, constraintWidget);
            }
        }
        this.mUnresolvedWidgets.clear();
        this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
        this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
        return this.mWidgetsToSolve;
    }

    private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (!constraintWidget.mGroupsToSolver) {
            arrayList.add(constraintWidget);
            constraintWidget.mGroupsToSolver = true;
            if (!constraintWidget.isFullyResolved()) {
                if (constraintWidget instanceof Helper) {
                    Helper helper = (Helper) constraintWidget;
                    int i = helper.mWidgetsCount;
                    for (int i2 = 0; i2 < i; i2++) {
                        getWidgetsToSolveTraversal(arrayList, helper.mWidgets[i2]);
                    }
                }
                int length = constraintWidget.mListAnchors.length;
                for (int i3 = 0; i3 < length; i3++) {
                    ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i3].mTarget;
                    if (constraintAnchor != null) {
                        ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
                        if (!(constraintAnchor == null || constraintWidget2 == constraintWidget.getParent())) {
                            getWidgetsToSolveTraversal(arrayList, constraintWidget2);
                        }
                    }
                }
            }
        }
    }

    void updateUnresolvedWidgets() {
        int size = this.mUnresolvedWidgets.size();
        for (int i = 0; i < size; i++) {
            updateResolvedDimension(this.mUnresolvedWidgets.get(i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
    private void updateResolvedDimension(ConstraintWidget constraintWidget) {
        ConstraintAnchor constraintAnchor;
        int i;
        int i2;
        ConstraintAnchor constraintAnchor2;
        int i3;
        if (constraintWidget.mOptimizerMeasurable && !constraintWidget.isFullyResolved()) {
            boolean z = false;
            boolean z2 = constraintWidget.mRight.mTarget != null;
            if (z2) {
                constraintAnchor = constraintWidget.mRight.mTarget;
            } else {
                constraintAnchor = constraintWidget.mLeft.mTarget;
            }
            if (constraintAnchor != null) {
                if (!constraintAnchor.mOwner.mOptimizerMeasured) {
                    updateResolvedDimension(constraintAnchor.mOwner);
                }
                if (constraintAnchor.mType == ConstraintAnchor.Type.RIGHT) {
                    i = constraintAnchor.mOwner.mX + constraintAnchor.mOwner.getWidth();
                } else if (constraintAnchor.mType == ConstraintAnchor.Type.LEFT) {
                    i = constraintAnchor.mOwner.mX;
                }
                if (!z2) {
                    i2 = i - constraintWidget.mRight.getMargin();
                } else {
                    i2 = i + constraintWidget.mLeft.getMargin() + constraintWidget.getWidth();
                }
                constraintWidget.setHorizontalDimension(i2 - constraintWidget.getWidth(), i2);
                if (constraintWidget.mBaseline.mTarget == null) {
                    ConstraintAnchor constraintAnchor3 = constraintWidget.mBaseline.mTarget;
                    if (!constraintAnchor3.mOwner.mOptimizerMeasured) {
                        updateResolvedDimension(constraintAnchor3.mOwner);
                    }
                    int i4 = (constraintAnchor3.mOwner.mY + constraintAnchor3.mOwner.mBaselineDistance) - constraintWidget.mBaselineDistance;
                    constraintWidget.setVerticalDimension(i4, constraintWidget.mHeight + i4);
                    constraintWidget.mOptimizerMeasured = true;
                    return;
                }
                if (constraintWidget.mBottom.mTarget != null) {
                    z = true;
                }
                if (z) {
                    constraintAnchor2 = constraintWidget.mBottom.mTarget;
                } else {
                    constraintAnchor2 = constraintWidget.mTop.mTarget;
                }
                if (constraintAnchor2 != null) {
                    if (!constraintAnchor2.mOwner.mOptimizerMeasured) {
                        updateResolvedDimension(constraintAnchor2.mOwner);
                    }
                    if (constraintAnchor2.mType == ConstraintAnchor.Type.BOTTOM) {
                        i2 = constraintAnchor2.mOwner.mY + constraintAnchor2.mOwner.getHeight();
                    } else if (constraintAnchor2.mType == ConstraintAnchor.Type.TOP) {
                        i2 = constraintAnchor2.mOwner.mY;
                    }
                }
                if (z) {
                    i3 = i2 - constraintWidget.mBottom.getMargin();
                } else {
                    i3 = i2 + constraintWidget.mTop.getMargin() + constraintWidget.getHeight();
                }
                constraintWidget.setVerticalDimension(i3 - constraintWidget.getHeight(), i3);
                constraintWidget.mOptimizerMeasured = true;
                return;
            }
            i = 0;
            if (!z2) {
            }
            constraintWidget.setHorizontalDimension(i2 - constraintWidget.getWidth(), i2);
            if (constraintWidget.mBaseline.mTarget == null) {
            }
        }
    }
}
