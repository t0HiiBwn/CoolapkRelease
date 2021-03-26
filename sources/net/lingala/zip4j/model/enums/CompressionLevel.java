package net.lingala.zip4j.model.enums;

public enum CompressionLevel {
    FASTEST(1),
    FAST(3),
    NORMAL(5),
    MAXIMUM(7),
    ULTRA(9);
    
    private int level;

    private CompressionLevel(int i) {
        this.level = i;
    }

    public int getLevel() {
        return this.level;
    }
}
