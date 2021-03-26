package com.tencent.mobileqq.pb;

import java.io.IOException;

public final class PBFloatField extends PBPrimitiveField<Float> {
    public static final PBFloatField __repeatHelper__ = new PBFloatField(0.0f, false);
    private float value = 0.0f;

    public PBFloatField(float f, boolean z) {
        set(f, z);
    }

    public float get() {
        return this.value;
    }

    public void set(float f, boolean z) {
        this.value = f;
        setHasFlag(z);
    }

    public void set(float f) {
        set(f, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i) {
        if (has()) {
            return CodedOutputStreamMicro.computeFloatSize(i, this.value);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeSizeDirectly(int i, Float f) {
        return CodedOutputStreamMicro.computeFloatSize(i, f.floatValue());
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeFloat(i, this.value);
        }
    }

    /* access modifiers changed from: protected */
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i, Float f) throws IOException {
        codedOutputStreamMicro.writeFloat(i, f.floatValue());
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readFloat();
        setHasFlag(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public Float readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Float.valueOf(codedInputStreamMicro.readFloat());
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        if (obj instanceof Float) {
            this.value = ((Float) obj).floatValue();
        } else {
            this.value = 0.0f;
        }
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    protected void copyFrom(PBField<Float> pBField) {
        PBFloatField pBFloatField = (PBFloatField) pBField;
        set(pBFloatField.value, pBFloatField.has());
    }
}
