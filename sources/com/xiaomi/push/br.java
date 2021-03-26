package com.xiaomi.push;

import java.io.IOException;

public class br extends IOException {
    public br(String str) {
        super(str);
    }

    static br a() {
        return new br("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static br b() {
        return new br("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static br c() {
        return new br("CodedInputStream encountered a malformed varint.");
    }

    static br d() {
        return new br("Protocol message contained an invalid tag (zero).");
    }

    static br e() {
        return new br("Protocol message end-group tag did not match expected tag.");
    }

    static br f() {
        return new br("Protocol message tag had invalid wire type.");
    }

    static br g() {
        return new br("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static br h() {
        return new br("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
