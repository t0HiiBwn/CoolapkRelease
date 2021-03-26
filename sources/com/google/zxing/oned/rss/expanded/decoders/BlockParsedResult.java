package com.google.zxing.oned.rss.expanded.decoders;

final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    BlockParsedResult(boolean z) {
        this(null, z);
    }

    BlockParsedResult(DecodedInformation decodedInformation2, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation2;
    }

    DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    boolean isFinished() {
        return this.finished;
    }
}
