package com.tencent.mobileqq.pb;

import java.io.IOException;

public final class PBStringField extends PBPrimitiveField<String> {
    public static final PBStringField __repeatHelper__ = new PBStringField("", false);
    private String value = "";

    public PBStringField(String str, boolean z) {
        set(str, z);
    }

    public String get() {
        return this.value;
    }

    public void set(String str, boolean z) {
        this.value = str;
        setHasFlag(z);
    }

    public void set(String str) {
        set(str, true);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public int computeSize(int i) {
        if (has()) {
            return CodedOutputStreamMicro.computeStringSize(i, this.value);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeSizeDirectly(int i, String str) {
        return CodedOutputStreamMicro.computeStringSize(i, str);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeString(i, this.value);
        }
    }

    /* access modifiers changed from: protected */
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i, String str) throws IOException {
        codedOutputStreamMicro.writeString(i, str);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readString();
        setHasFlag(true);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pb.PBField
    public String readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return codedInputStreamMicro.readString();
    }

    @Override // com.tencent.mobileqq.pb.PBField
    public void clear(Object obj) {
        if (obj instanceof String) {
            this.value = (String) obj;
        } else {
            this.value = "";
        }
        setHasFlag(false);
    }

    @Override // com.tencent.mobileqq.pb.PBField
    protected void copyFrom(PBField<String> pBField) {
        PBStringField pBStringField = (PBStringField) pBField;
        set(pBStringField.value, pBStringField.has());
    }
}
