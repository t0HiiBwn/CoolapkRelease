package com.bun.miitmdid.interfaces;

public interface IdSupplier {
    String getAAID();

    String getOAID();

    String getVAID();

    boolean isSupported();
}
