package com.hanks.htextview.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CharacterUtils {
    public static List<CharacterDiffResult> diff(CharSequence charSequence, CharSequence charSequence2) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            int i2 = 0;
            while (true) {
                if (i2 >= charSequence2.length()) {
                    break;
                }
                if (!hashSet.contains(Integer.valueOf(i2)) && charAt == charSequence2.charAt(i2)) {
                    hashSet.add(Integer.valueOf(i2));
                    CharacterDiffResult characterDiffResult = new CharacterDiffResult();
                    characterDiffResult.c = charAt;
                    characterDiffResult.fromIndex = i;
                    characterDiffResult.moveIndex = i2;
                    arrayList.add(characterDiffResult);
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    public static int needMove(int i, List<CharacterDiffResult> list) {
        for (CharacterDiffResult characterDiffResult : list) {
            if (characterDiffResult.fromIndex == i) {
                return characterDiffResult.moveIndex;
            }
        }
        return -1;
    }

    public static boolean stayHere(int i, List<CharacterDiffResult> list) {
        for (CharacterDiffResult characterDiffResult : list) {
            if (characterDiffResult.moveIndex == i) {
                return true;
            }
        }
        return false;
    }

    public static float getOffset(int i, int i2, float f, float f2, float f3, List<Float> list, List<Float> list2) {
        for (int i3 = 0; i3 < i2; i3++) {
            f2 += list.get(i3).floatValue();
        }
        for (int i4 = 0; i4 < i; i4++) {
            f3 += list2.get(i4).floatValue();
        }
        return f3 + ((f2 - f3) * f);
    }
}
