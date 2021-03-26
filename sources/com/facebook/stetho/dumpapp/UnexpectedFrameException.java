package com.facebook.stetho.dumpapp;

class UnexpectedFrameException extends DumpappFramingException {
    public UnexpectedFrameException(byte b, byte b2) {
        super("Expected '" + ((int) b) + "', got: '" + ((int) b2) + "'");
    }
}
