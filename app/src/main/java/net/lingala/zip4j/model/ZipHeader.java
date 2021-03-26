package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public abstract class ZipHeader {
    private HeaderSignature signature;

    public HeaderSignature getSignature() {
        return this.signature;
    }

    public void setSignature(HeaderSignature headerSignature) {
        this.signature = headerSignature;
    }
}
