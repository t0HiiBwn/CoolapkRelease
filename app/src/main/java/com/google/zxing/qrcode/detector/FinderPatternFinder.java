package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback2) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback2;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003c: APUT  (r2v2 int[]), (0 ??[int, short, byte, char]), (0 int) */
    final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean z3 = false;
        while (i2 < height && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.image.get(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 4) {
                    if (!foundPatternCross(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (handlePossibleCenter(iArr, i2, i3, z2)) {
                        if (this.hasSkipped) {
                            z3 = haveMultiplyConfirmedCenters();
                        } else {
                            int findRowSkip = findRowSkip();
                            if (findRowSkip > iArr[2]) {
                                i2 += (findRowSkip - iArr[2]) - 2;
                                i3 = width - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i = 2;
                        i4 = 0;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i4 = 3;
                } else {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width, z2)) {
                i = iArr[0];
                if (this.hasSkipped) {
                    z3 = haveMultiplyConfirmedCenters();
                }
            }
            i2 += i;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    private int[] getCrossCheckStateCount() {
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean crossCheckDiagonal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i10 = 0;
        while (i >= i10 && i2 >= i10 && this.image.get(i2 - i10, i - i10)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i10++;
        }
        if (i >= i10 && i2 >= i10) {
            while (i >= i10 && i2 >= i10 && !this.image.get(i2 - i10, i - i10) && crossCheckStateCount2[1] <= i3) {
                crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
                i10++;
            }
            if (i >= i10 && i2 >= i10 && crossCheckStateCount2[1] <= i3) {
                while (i >= i10 && i2 >= i10 && this.image.get(i2 - i10, i - i10) && crossCheckStateCount2[0] <= i3) {
                    crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
                    i10++;
                }
                if (crossCheckStateCount2[0] > i3) {
                    return false;
                }
                int height = this.image.getHeight();
                int width = this.image.getWidth();
                int i11 = 1;
                while (true) {
                    i5 = i + i11;
                    if (i5 >= height || (i9 = i2 + i11) >= width || !this.image.get(i9, i5)) {
                        break;
                    }
                    crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                    i11++;
                }
                if (i5 < height && i2 + i11 < width) {
                    while (true) {
                        i6 = i + i11;
                        if (i6 >= height || (i8 = i2 + i11) >= width || this.image.get(i8, i6) || crossCheckStateCount2[3] >= i3) {
                            break;
                        }
                        crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
                        i11++;
                    }
                    if (i6 < height && i2 + i11 < width && crossCheckStateCount2[3] < i3) {
                        while (true) {
                            int i12 = i + i11;
                            if (i12 >= height || (i7 = i2 + i11) >= width || !this.image.get(i7, i12) || crossCheckStateCount2[4] >= i3) {
                                break;
                            }
                            crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
                            i11++;
                        }
                        if (crossCheckStateCount2[4] < i3 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + crossCheckStateCount2[4]) - i4) < i4 * 2 && foundPatternCross(crossCheckStateCount2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount2[1] <= i3) {
            crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
            i5--;
        }
        if (i5 >= 0 && crossCheckStateCount2[1] <= i3) {
            while (i5 >= 0 && bitMatrix.get(i2, i5) && crossCheckStateCount2[0] <= i3) {
                crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
                i5--;
            }
            if (crossCheckStateCount2[0] > i3) {
                return Float.NaN;
            }
            int i6 = i + 1;
            while (i6 < height && bitMatrix.get(i2, i6)) {
                crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                i6++;
            }
            if (i6 == height) {
                return Float.NaN;
            }
            while (i6 < height && !bitMatrix.get(i2, i6) && crossCheckStateCount2[3] < i3) {
                crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
                i6++;
            }
            if (i6 != height && crossCheckStateCount2[3] < i3) {
                while (i6 < height && bitMatrix.get(i2, i6) && crossCheckStateCount2[4] < i3) {
                    crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
                    i6++;
                }
                if (crossCheckStateCount2[4] < i3 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + crossCheckStateCount2[4]) - i4) * 5 < i4 * 2 && foundPatternCross(crossCheckStateCount2)) {
                    return centerFromEnd(crossCheckStateCount2, i6);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount2[1] <= i3) {
            crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
            i5--;
        }
        if (i5 >= 0 && crossCheckStateCount2[1] <= i3) {
            while (i5 >= 0 && bitMatrix.get(i5, i2) && crossCheckStateCount2[0] <= i3) {
                crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
                i5--;
            }
            if (crossCheckStateCount2[0] > i3) {
                return Float.NaN;
            }
            int i6 = i + 1;
            while (i6 < width && bitMatrix.get(i6, i2)) {
                crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                i6++;
            }
            if (i6 == width) {
                return Float.NaN;
            }
            while (i6 < width && !bitMatrix.get(i6, i2) && crossCheckStateCount2[3] < i3) {
                crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
                i6++;
            }
            if (i6 != width && crossCheckStateCount2[3] < i3) {
                while (i6 < width && bitMatrix.get(i6, i2) && crossCheckStateCount2[4] < i3) {
                    crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
                    i6++;
                }
                if (crossCheckStateCount2[4] < i3 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + crossCheckStateCount2[4]) - i4) * 5 < i4 && foundPatternCross(crossCheckStateCount2)) {
                    return centerFromEnd(crossCheckStateCount2, i6);
                }
            }
        }
        return Float.NaN;
    }

    protected final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int centerFromEnd = (int) centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, centerFromEnd, iArr[2], i3);
        if (!Float.isNaN(crossCheckVertical)) {
            int i4 = (int) crossCheckVertical;
            float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i4, iArr[2], i3);
            if (!Float.isNaN(crossCheckHorizontal) && (!z || crossCheckDiagonal(i4, (int) crossCheckHorizontal, iArr[2], i3))) {
                float f = ((float) i3) / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i5);
                    if (finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(i5, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback2 = this.resultPointCallback;
                    if (resultPointCallback2 != null) {
                        resultPointCallback2.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern == null) {
                    finderPattern = finderPattern2;
                } else {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                f2 += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            f += Math.abs(finderPattern2.getEstimatedModuleSize() - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size >= 3) {
            float f = 0.0f;
            if (size > 3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (FinderPattern finderPattern : this.possibleCenters) {
                    float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
                    f2 += estimatedModuleSize;
                    f3 += estimatedModuleSize * estimatedModuleSize;
                }
                float f4 = (float) size;
                float f5 = f2 / f4;
                float sqrt = (float) Math.sqrt((double) ((f3 / f4) - (f5 * f5)));
                Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f5));
                float max = Math.max(0.2f * f5, sqrt);
                int i = 0;
                while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                    if (Math.abs(this.possibleCenters.get(i).getEstimatedModuleSize() - f5) > max) {
                        this.possibleCenters.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (this.possibleCenters.size() > 3) {
                for (FinderPattern finderPattern2 : this.possibleCenters) {
                    f += finderPattern2.getEstimatedModuleSize();
                }
                Collections.sort(this.possibleCenters, new CenterComparator(f / ((float) this.possibleCenters.size())));
                List<FinderPattern> list = this.possibleCenters;
                list.subList(3, list.size()).clear();
            }
            return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }
}
