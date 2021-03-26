package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    private static final int NONE = -1;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    int currentSize = 0;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private final Cache mCache;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    public final void put(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i = this.mHead;
        if (i == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[this.mHead] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int i2 = this.mLast + 1;
                this.mLast = i2;
                int[] iArr = this.mArrayIndices;
                if (i2 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i3 = 0;
        int i4 = -1;
        while (i != -1 && i3 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                this.mArrayValues[i] = f;
                return;
            }
            if (this.mArrayIndices[i] < solverVariable.id) {
                i4 = i;
            }
            i = this.mArrayNextIndices[i];
            i3++;
        }
        int i5 = this.mLast;
        int i6 = i5 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i5] != -1) {
                i5 = iArr2.length;
            }
        } else {
            i5 = i6;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i5 >= iArr3.length && this.currentSize < iArr3.length) {
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i7 >= iArr4.length) {
                    break;
                } else if (iArr4[i7] == -1) {
                    i5 = i7;
                    break;
                } else {
                    i7++;
                }
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i5 >= iArr5.length) {
            i5 = iArr5.length;
            int i8 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i8;
            this.mDidFillOnce = false;
            this.mLast = i5 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i8);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i5] = solverVariable.id;
        this.mArrayValues[i5] = f;
        if (i4 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i5] = iArr6[i4];
            iArr6[i4] = i5;
        } else {
            this.mArrayNextIndices[i5] = this.mHead;
            this.mHead = i5;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i9 = this.currentSize + 1;
        this.currentSize = i9;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i9 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    final void add(SolverVariable solverVariable, float f, boolean z) {
        if (f != 0.0f) {
            int i = this.mHead;
            if (i == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[this.mHead] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (!this.mDidFillOnce) {
                    int i2 = this.mLast + 1;
                    this.mLast = i2;
                    int[] iArr = this.mArrayIndices;
                    if (i2 >= iArr.length) {
                        this.mDidFillOnce = true;
                        this.mLast = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i3 = 0;
            int i4 = -1;
            while (i != -1 && i3 < this.currentSize) {
                if (this.mArrayIndices[i] == solverVariable.id) {
                    float[] fArr = this.mArrayValues;
                    fArr[i] = fArr[i] + f;
                    if (fArr[i] == 0.0f) {
                        if (i == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i4] = iArr2[i];
                        }
                        if (z) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i;
                        }
                        solverVariable.usageInRowCount--;
                        this.currentSize--;
                        return;
                    }
                    return;
                }
                if (this.mArrayIndices[i] < solverVariable.id) {
                    i4 = i;
                }
                i = this.mArrayNextIndices[i];
                i3++;
            }
            int i5 = this.mLast;
            int i6 = i5 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i5] != -1) {
                    i5 = iArr3.length;
                }
            } else {
                i5 = i6;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i5 >= iArr4.length && this.currentSize < iArr4.length) {
                int i7 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i7 >= iArr5.length) {
                        break;
                    } else if (iArr5[i7] == -1) {
                        i5 = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i5 >= iArr6.length) {
                i5 = iArr6.length;
                int i8 = this.ROW_SIZE * 2;
                this.ROW_SIZE = i8;
                this.mDidFillOnce = false;
                this.mLast = i5 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i8);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i5] = solverVariable.id;
            this.mArrayValues[i5] = f;
            if (i4 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i5] = iArr7[i4];
                iArr7[i4] = i5;
            } else {
                this.mArrayNextIndices[i5] = this.mHead;
                this.mHead = i5;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i9 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i9 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        int i = this.mHead;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                if (i == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i;
                }
                return this.mArrayValues[i];
            }
            i2++;
            i3 = i;
            i = this.mArrayNextIndices[i];
        }
        return 0.0f;
    }

    public final void clear() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    final boolean containsKey(SolverVariable solverVariable) {
        int i = this.mHead;
        if (i == -1) {
            return false;
        }
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return true;
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return false;
    }

    boolean hasAtLeastOnePositiveVariable() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] > 0.0f) {
                return true;
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return false;
    }

    void invert() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] * -1.0f;
            i = this.mArrayNextIndices[i];
            i2++;
        }
    }

    void divideByAmount(float f) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] / f;
            i = this.mArrayNextIndices[i];
            i2++;
        }
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094 A[SYNTHETIC] */
    SolverVariable chooseSubject(LinearSystem linearSystem) {
        boolean isNew;
        boolean isNew2;
        int i = this.mHead;
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        while (i != -1 && i2 < this.currentSize) {
            float f3 = this.mArrayValues[i];
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (f3 < 0.0f) {
                if (f3 > -0.001f) {
                    this.mArrayValues[i] = 0.0f;
                    solverVariable3.removeFromRow(this.mRow);
                }
                if (f3 != 0.0f) {
                    if (solverVariable3.mType == SolverVariable.Type.UNRESTRICTED) {
                        if (solverVariable2 == null) {
                            isNew2 = isNew(solverVariable3, linearSystem);
                        } else if (f > f3) {
                            isNew2 = isNew(solverVariable3, linearSystem);
                        } else if (!z && isNew(solverVariable3, linearSystem)) {
                            f = f3;
                            solverVariable2 = solverVariable3;
                            z = true;
                        }
                        z = isNew2;
                        f = f3;
                        solverVariable2 = solverVariable3;
                    } else if (solverVariable2 == null && f3 < 0.0f) {
                        if (solverVariable == null) {
                            isNew = isNew(solverVariable3, linearSystem);
                        } else if (f2 > f3) {
                            isNew = isNew(solverVariable3, linearSystem);
                        } else if (!z2 && isNew(solverVariable3, linearSystem)) {
                            f2 = f3;
                            solverVariable = solverVariable3;
                            z2 = true;
                        }
                        z2 = isNew;
                        f2 = f3;
                        solverVariable = solverVariable3;
                    }
                }
                i = this.mArrayNextIndices[i];
                i2++;
            } else {
                if (f3 < 0.001f) {
                    this.mArrayValues[i] = 0.0f;
                    solverVariable3.removeFromRow(this.mRow);
                }
                if (f3 != 0.0f) {
                }
                i = this.mArrayNextIndices[i];
                i2++;
            }
            f3 = 0.0f;
            if (f3 != 0.0f) {
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable2 != null ? solverVariable2 : solverVariable;
    }

    final void updateFromRow(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        int i = this.mHead;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.currentSize) {
                if (this.mArrayIndices[i] == arrayRow2.variable.id) {
                    float f = this.mArrayValues[i];
                    remove(arrayRow2.variable, z);
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                    int i3 = arrayLinkedVariables.mHead;
                    int i4 = 0;
                    while (i3 != -1 && i4 < arrayLinkedVariables.currentSize) {
                        add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i3]], arrayLinkedVariables.mArrayValues[i3] * f, z);
                        i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                        i4++;
                    }
                    arrayRow.constantValue += arrayRow2.constantValue * f;
                    if (z) {
                        arrayRow2.variable.removeFromRow(arrayRow);
                    }
                    i = this.mHead;
                } else {
                    i = this.mArrayNextIndices[i];
                    i2++;
                }
            }
            return;
        }
    }

    void updateFromSystem(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i = this.mHead;
        while (true) {
            int i2 = 0;
            while (i != -1 && i2 < this.currentSize) {
                SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable.definitionId != -1) {
                    float f = this.mArrayValues[i];
                    remove(solverVariable, true);
                    ArrayRow arrayRow2 = arrayRowArr[solverVariable.definitionId];
                    if (!arrayRow2.isSimpleDefinition) {
                        ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                        int i3 = arrayLinkedVariables.mHead;
                        int i4 = 0;
                        while (i3 != -1 && i4 < arrayLinkedVariables.currentSize) {
                            add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i3]], arrayLinkedVariables.mArrayValues[i3] * f, true);
                            i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                            i4++;
                        }
                    }
                    arrayRow.constantValue += arrayRow2.constantValue * f;
                    arrayRow2.variable.removeFromRow(arrayRow);
                    i = this.mHead;
                } else {
                    i = this.mArrayNextIndices[i];
                    i2++;
                }
            }
            return;
        }
    }

    SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i = this.mHead;
        int i2 = 0;
        SolverVariable solverVariable2 = null;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable2;
    }

    SolverVariable getPivotCandidate(boolean[] zArr, SolverVariable solverVariable) {
        int i = this.mHead;
        int i2 = 0;
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if ((zArr == null || !zArr[solverVariable3.id]) && solverVariable3 != solverVariable && (solverVariable3.mType == SolverVariable.Type.SLACK || solverVariable3.mType == SolverVariable.Type.ERROR)) {
                    float f2 = this.mArrayValues[i];
                    if (f2 < f) {
                        solverVariable2 = solverVariable3;
                        f = f2;
                    }
                }
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable2;
    }

    final SolverVariable getVariable(int i) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (i3 == i) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return null;
    }

    final float getVariableValue(int i) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (i3 == i) {
                return this.mArrayValues[i2];
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return 0.0f;
    }

    public final float get(SolverVariable solverVariable) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return this.mArrayValues[i];
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return 0.0f;
    }

    int sizeInBytes() {
        return (this.mArrayIndices.length * 4 * 3) + 0 + 36;
    }

    public void display() {
        int i = this.currentSize;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i2) + " ");
            }
        }
        System.out.println(" }");
    }

    public String toString() {
        int i = this.mHead;
        String str = "";
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            str = ((str + " -> ") + this.mArrayValues[i] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return str;
    }
}
