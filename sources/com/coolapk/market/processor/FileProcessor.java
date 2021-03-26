package com.coolapk.market.processor;

public interface FileProcessor {
    String getOutputFilePath();

    boolean process() throws Throwable;
}
