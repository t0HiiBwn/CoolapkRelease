package com.bun.miitmdid.interfaces;

public interface InnerIdProvider extends IdSupplier {
    boolean isSync();

    void shutDown();

    void startAction(IIdentifierListener iIdentifierListener);
}
