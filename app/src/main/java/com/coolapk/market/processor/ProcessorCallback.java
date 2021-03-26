package com.coolapk.market.processor;

import com.coolapk.market.processor.ApkFileProcessor;
import com.coolapk.market.processor.ExtendApkFileProcessor;
import com.coolapk.market.processor.ExtendApkFileProcessor2;
import com.coolapk.market.processor.PatchFileProcessor;

public abstract class ProcessorCallback implements ApkFileProcessor.Callback, PatchFileProcessor.Callback, ExtendApkFileProcessor.Callback, ExtendApkFileProcessor2.Callback {
}
