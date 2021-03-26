package org.apache.commons.cli;

class OptionValidator {
    OptionValidator() {
    }

    static void validateOption(String str) throws IllegalArgumentException {
        if (str != null) {
            if (str.length() == 1) {
                char charAt = str.charAt(0);
                if (!isValidOpt(charAt)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal option value '");
                    stringBuffer.append(charAt);
                    stringBuffer.append("'");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                return;
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!isValidChar(charArray[i])) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("opt contains illegal character value '");
                    stringBuffer2.append(charArray[i]);
                    stringBuffer2.append("'");
                    throw new IllegalArgumentException(stringBuffer2.toString());
                }
            }
        }
    }

    private static boolean isValidOpt(char c) {
        return isValidChar(c) || c == ' ' || c == '?' || c == '@';
    }

    private static boolean isValidChar(char c) {
        return Character.isJavaIdentifierPart(c);
    }
}
