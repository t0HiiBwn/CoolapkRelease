package com.tencent.android.tpns.mqtt;

import java.util.Objects;

public class MqttMessage {
    private boolean dup = false;
    private int messageId;
    private boolean mutable = true;
    private byte[] payload;
    private int qos = 1;
    private boolean retained = false;

    public static void validateQos(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException();
        }
    }

    public MqttMessage() {
        setPayload(new byte[0]);
    }

    public MqttMessage(byte[] bArr) {
        setPayload(bArr);
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public void clearPayload() {
        checkMutable();
        this.payload = new byte[0];
    }

    public void setPayload(byte[] bArr) {
        checkMutable();
        Objects.requireNonNull(bArr);
        this.payload = bArr;
    }

    public boolean isRetained() {
        return this.retained;
    }

    public void setRetained(boolean z) {
        checkMutable();
        this.retained = z;
    }

    public int getQos() {
        return this.qos;
    }

    public void setQos(int i) {
        checkMutable();
        validateQos(i);
        this.qos = i;
    }

    public String toString() {
        return new String(this.payload);
    }

    protected void setMutable(boolean z) {
        this.mutable = z;
    }

    protected void checkMutable() throws IllegalStateException {
        if (!this.mutable) {
            throw new IllegalStateException();
        }
    }

    protected void setDuplicate(boolean z) {
        this.dup = z;
    }

    public boolean isDuplicate() {
        return this.dup;
    }

    public void setId(int i) {
        this.messageId = i;
    }

    public int getId() {
        return this.messageId;
    }
}
