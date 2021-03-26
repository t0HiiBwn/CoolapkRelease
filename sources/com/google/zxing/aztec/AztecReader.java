package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[LOOP:0: B:29:0x005c->B:30:0x005e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        FormatException formatException;
        NotFoundException e;
        List<byte[]> byteSegments;
        String eCLevel;
        ResultPointCallback resultPointCallback;
        ResultPoint[] resultPointArr2;
        FormatException e2;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        DecoderResult decoderResult = null;
        try {
            AztecDetectorResult detect = detector.detect(false);
            resultPointArr2 = detect.getPoints();
            try {
                resultPointArr = resultPointArr2;
                formatException = null;
                decoderResult = new Decoder().decode(detect);
                e = null;
            } catch (NotFoundException e3) {
                e = e3;
                resultPointArr = resultPointArr2;
                formatException = null;
                if (decoderResult == null) {
                }
                while (r11 < r0) {
                }
                Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                }
                return result;
            } catch (FormatException e4) {
                e2 = e4;
                resultPointArr = resultPointArr2;
                formatException = e2;
                e = null;
                if (decoderResult == null) {
                }
                while (r11 < r0) {
                }
                Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                }
                return result;
            }
        } catch (NotFoundException e5) {
            e = e5;
            resultPointArr2 = null;
            resultPointArr = resultPointArr2;
            formatException = null;
            if (decoderResult == null) {
            }
            while (r11 < r0) {
            }
            Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
            }
            return result;
        } catch (FormatException e6) {
            e2 = e6;
            resultPointArr2 = null;
            resultPointArr = resultPointArr2;
            formatException = e2;
            e = null;
            if (decoderResult == null) {
            }
            while (r11 < r0) {
            }
            Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
            }
            return result;
        }
        if (decoderResult == null) {
            try {
                AztecDetectorResult detect2 = detector.detect(true);
                resultPointArr = detect2.getPoints();
                decoderResult = new Decoder().decode(detect2);
            } catch (FormatException | NotFoundException e7) {
                if (e != null) {
                    throw e;
                } else if (formatException != null) {
                    throw formatException;
                } else {
                    throw e7;
                }
            }
        }
        if (!(map == null || (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) == null)) {
            for (ResultPoint resultPoint : resultPointArr) {
                resultPointCallback.foundPossibleResultPoint(resultPoint);
            }
        }
        Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
        byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }
}
