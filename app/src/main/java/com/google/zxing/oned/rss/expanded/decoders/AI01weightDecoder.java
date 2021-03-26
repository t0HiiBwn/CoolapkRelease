package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder extends AI01decoder {
    protected abstract void addWeightCode(StringBuilder sb, int i);

    protected abstract int checkWeight(int i);

    AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    final void encodeCompressedWeight(StringBuilder sb, int i, int i2) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, i2);
        addWeightCode(sb, extractNumericValueFromBitArray);
        int checkWeight = checkWeight(extractNumericValueFromBitArray);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (checkWeight / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(checkWeight);
    }
}
