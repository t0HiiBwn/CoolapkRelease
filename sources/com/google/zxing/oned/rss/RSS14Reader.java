package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSS14Reader extends AbstractRSSReader {
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, map));
        bitArray.reverse();
        for (Pair pair : this.possibleLeftPairs) {
            if (pair.getCount() > 1) {
                for (Pair pair2 : this.possibleRightPairs) {
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        if (pair != null) {
            boolean z = false;
            Iterator<Pair> it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Pair next = it2.next();
                if (next.getValue() == pair.getValue()) {
                    next.incrementCount();
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(pair);
            }
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String valueOf = String.valueOf((((long) pair.getValue()) * 4537077) + ((long) pair2.getValue()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int charAt = sb.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                charAt *= 3;
            }
            i += charAt;
        }
        int i3 = 10 - (i % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        sb.append(i3);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(String.valueOf(sb.toString()), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i, Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback;
        try {
            int[] findFinderPattern = findFinderPattern(bitArray, 0, z);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z, findFinderPattern);
            if (map == null) {
                resultPointCallback = null;
            } else {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            if (resultPointCallback != null) {
                float f = ((float) (findFinderPattern[0] + findFinderPattern[1])) / 2.0f;
                if (z) {
                    f = ((float) (bitArray.getSize() - 1)) - f;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f, (float) i));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i = 0;
            for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        int i3 = z ? 16 : 15;
        float sum = ((float) MathUtils.sum(dataCharacterCounters)) / ((float) i3);
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
            float f = ((float) dataCharacterCounters[i4]) / sum;
            int i5 = (int) (0.5f + f);
            if (i5 <= 0) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                oddCounts[i6] = i5;
                oddRoundingErrors[i6] = f - ((float) i5);
            } else {
                evenCounts[i6] = i5;
                evenRoundingErrors[i6] = f - ((float) i5);
            }
        }
        adjustOddEvenCounts(z, i3);
        int i7 = 0;
        int i8 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            i7 = (i7 * 9) + oddCounts[length2];
            i8 += oddCounts[length2];
        }
        int i9 = 0;
        int i10 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            i9 = (i9 * 9) + evenCounts[length3];
            i10 += evenCounts[length3];
        }
        int i11 = i7 + (i9 * 3);
        if (z) {
            if ((i8 & 1) != 0 || i8 > 12 || i8 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i12 = (12 - i8) / 2;
            int i13 = OUTSIDE_ODD_WIDEST[i12];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i13, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i12]) + RSSUtils.getRSSvalue(evenCounts, 9 - i13, true) + OUTSIDE_GSUM[i12], i11);
        } else if ((i10 & 1) != 0 || i10 > 10 || i10 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i14 = (10 - i10) / 2;
            int i15 = INSIDE_ODD_WIDEST[i14];
            return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i15, false) * INSIDE_ODD_TOTAL_SUBSET[i14]) + RSSUtils.getRSSvalue(oddCounts, i15, true) + INSIDE_GSUM[i14], i11);
        }
    }

    private int[] findFinderPattern(BitArray bitArray, int i, boolean z) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (z == z2) {
                break;
            }
            i++;
        }
        int i2 = i;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) ^ z2) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else if (isFinderPattern(decodeFinderCounters)) {
                    return new int[]{i2, i};
                } else {
                    i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                }
                decodeFinderCounters[i3] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        int i2;
        int i3;
        boolean z2 = bitArray.get(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && (bitArray.get(i4) ^ z2)) {
            i4--;
        }
        int i5 = i4 + 1;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = iArr[0] - i5;
        int parseFinderValue = parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i6 = iArr[1];
        if (z) {
            i2 = (bitArray.getSize() - 1) - i6;
            i3 = (bitArray.getSize() - 1) - i5;
        } else {
            i2 = i6;
            i3 = i5;
        }
        return new FinderPattern(parseFinderValue, new int[]{i5, iArr[1]}, i3, i2, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r1 < 4) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        if (r1 < 4) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    private void adjustOddEvenCounts(boolean z, int i) throws NotFoundException {
        boolean z2;
        boolean z3;
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        boolean z4 = false;
        boolean z5 = true;
        if (z) {
            if (sum > 12) {
                z3 = false;
                z2 = true;
            } else {
                z3 = sum < 4;
                z2 = false;
            }
            if (sum2 <= 12) {
            }
        } else {
            if (sum > 11) {
                z3 = false;
                z2 = true;
            } else {
                z3 = sum < 5;
                z2 = false;
            }
            if (sum2 <= 10) {
            }
        }
        boolean z6 = false;
        boolean z7 = true;
        int i2 = (sum + sum2) - i;
        boolean z8 = (sum & 1) == z;
        if ((sum2 & 1) == 1) {
            z4 = true;
        }
        if (i2 != 1) {
            if (i2 == -1) {
                if (z8) {
                    if (z4) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (z4) {
                    z5 = z3;
                    z6 = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (i2 != 0) {
                throw NotFoundException.getNotFoundInstance();
            } else if (z8) {
                if (z4) {
                    if (sum >= sum2) {
                        z5 = z3;
                        z6 = true;
                    }
                    z7 = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (!z4) {
                z5 = z3;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
            if (z5) {
            }
            if (z2) {
            }
            if (z6) {
            }
            if (z7) {
            }
        } else if (z8) {
            if (!z4) {
                z5 = z3;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (z4) {
            z5 = z3;
            z7 = true;
            if (z5) {
                if (!z2) {
                    increment(getOddCounts(), getOddRoundingErrors());
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z2) {
                decrement(getOddCounts(), getOddRoundingErrors());
            }
            if (z6) {
                if (!z7) {
                    increment(getEvenCounts(), getOddRoundingErrors());
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z7) {
                decrement(getEvenCounts(), getEvenRoundingErrors());
                return;
            }
            return;
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
        z2 = true;
        if (z5) {
        }
        if (z2) {
        }
        if (z6) {
        }
        if (z7) {
        }
    }
}
