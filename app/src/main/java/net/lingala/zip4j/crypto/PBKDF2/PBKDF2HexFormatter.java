package net.lingala.zip4j.crypto.PBKDF2;

class PBKDF2HexFormatter {
    PBKDF2HexFormatter() {
    }

    public boolean fromString(PBKDF2Parameters pBKDF2Parameters, String str) {
        if (pBKDF2Parameters == null || str == null) {
            return true;
        }
        String[] split = str.split(":");
        if (split.length != 3) {
            return true;
        }
        byte[] hex2bin = BinTools.hex2bin(split[0]);
        int parseInt = Integer.parseInt(split[1]);
        byte[] hex2bin2 = BinTools.hex2bin(split[2]);
        pBKDF2Parameters.setSalt(hex2bin);
        pBKDF2Parameters.setIterationCount(parseInt);
        pBKDF2Parameters.setDerivedKey(hex2bin2);
        return false;
    }

    public String toString(PBKDF2Parameters pBKDF2Parameters) {
        return BinTools.bin2hex(pBKDF2Parameters.getSalt()) + ":" + String.valueOf(pBKDF2Parameters.getIterationCount()) + ":" + BinTools.bin2hex(pBKDF2Parameters.getDerivedKey());
    }
}
