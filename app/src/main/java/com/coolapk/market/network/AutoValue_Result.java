package com.coolapk.market.network;

final class AutoValue_Result<T> extends Result<T> {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Result{}";
    }

    AutoValue_Result() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Result);
    }
}
