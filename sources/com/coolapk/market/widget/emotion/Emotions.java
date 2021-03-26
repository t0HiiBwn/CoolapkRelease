package com.coolapk.market.widget.emotion;

import com.coolapk.market.AppHolder;
import com.coolapk.market.util.DisplayUtils;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Emotions {
    public static EmotionAlbum sCoolApkParser;
    public static EmotionAlbum sCoolBParser;
    public static EmotionAlbum sEmojiParser;

    static {
        initCoolapkEmotions();
        initEmojiEmotions();
        initCoolBEmotions();
    }

    static class TiebaEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "TIEBA";
        }

        TiebaEmotion(Integer num, String str) {
            super(num, str);
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return "#(" + getText() + ")";
        }
    }

    static class QQEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "QQ";
        }

        QQEmotion(Integer num, String str) {
            super(num, str);
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return "[" + getText() + "]";
        }
    }

    static class CoolapkEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "COOLAPK";
        }

        CoolapkEmotion(Integer num, String str) {
            super(num, str);
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return "[" + getText() + "]";
        }
    }

    static class DogEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "DOG";
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public int getTransitionY() {
            return 1;
        }

        DogEmotion(Integer num, String str) {
            super(num, str);
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return "[" + getText() + "]";
        }
    }

    static class CoolBEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "COOLB";
        }

        CoolBEmotion(Integer num, String str) {
            super(num, str);
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return "[" + getText() + "]";
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public int getTransitionY() {
            return DisplayUtils.dp2px(null, -1.0f);
        }
    }

    static class EmojiEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "EMOJI";
        }

        EmojiEmotion(String str) {
            super(null, str);
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return getText();
        }
    }

    public static class EmptyEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "EMPTY";
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return null;
        }

        public EmptyEmotion() {
            super(null, null);
        }
    }

    public static class DrawableEmotion extends BaseEmotion {
        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getEntityType() {
            return "DRAWABLE";
        }

        @Override // com.coolapk.market.widget.emotion.BaseEmotion
        public String getRealText() {
            return null;
        }

        public DrawableEmotion(Integer num, String str) {
            super(num, str);
        }
    }

    private static void initEmojiEmotions() {
        Integer[] numArr = {128512, 128513, 128514, 128515, 128516, 128517, 128518, 128519, 128520, 128521, 128522, 128523, 128524, 128525, 128526, 128527, 128528, 128529, 128530, 128531, 128532, 128533, 128534, 128535, 128536, 128537, 128538, 128539, 128540, 128541, 128542, 128543, 128544, 128545, 128546, 128547, 128548, 128549, 128550, 128551, 128552, 128553, 128554, 128555, 128556, 128557, 128558, 128559, 128560, 128561, 128562, 128563, 128564, 128565, 128566, 128567, 128568, 128569, 128570, 128571, 128572, 128573, 128574, 128575, 128576, 128581, 128582, 128583, 128587, 128588, 128589, 128590, 128591, 128054, 128138, 128652, 128110, 127824, 127820};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 79; i++) {
            arrayList.add(new EmojiEmotion(newString(numArr[i].intValue())));
        }
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
            sb.append(((BaseEmotion) arrayList.get(i2)).getText());
            sb.append("|");
        }
        sb.append(((BaseEmotion) arrayList.get(arrayList.size() - 1)).getText());
        sEmojiParser = new EmotionAlbum(Pattern.compile(sb.toString()), false, arrayList, AppHolder.getApplication().getString(2131887313));
    }

    private static final String newString(int i) {
        if (Character.charCount(i) == 1) {
            return String.valueOf(i);
        }
        return new String(Character.toChars(i));
    }

    private static void initCoolapkEmotions() {
        Integer[] numArr = {2131230955, 2131230966, 2131230977, 2131230988, 2131230999, 2131231010, 2131231021, 2131231032, 2131231043, 2131230945, 2131230946, 2131230947, 2131230948, 2131230949, 2131230950, 2131230939, 2131230951, 2131230952, 2131230953, 2131230954, 2131230956, 2131230957, 2131230958, 2131230959, 2131230960, 2131230961, 2131230962, 2131230968, 2131230963, 2131230964, 2131230965, 2131230967, 2131230969, 2131230970, 2131230971, 2131230972, 2131230975, 2131230973, 2131230981, 2131230982, 2131230983, 2131230984, 2131230985, 2131230990, 2131230991, 2131230992, 2131230986, 2131230987, 2131231026, 2131231023, 2131230940, 2131231040, 2131231041, 2131231042, 2131230913, 2131230935, 2131230941, 2131230942, 2131230943, 2131230944, 2131230914, 2131230915, 2131230916, 2131230918, 2131230919, 2131230920, 2131230921, 2131230922, 2131230923, 2131230925, 2131231002, 2131231003, 2131231004, 2131231005, 2131231006, 2131231007, 2131230917, 2131230927, 2131230928, 2131230929, 2131230930, 2131230931, 2131230932, 2131230974, 2131230995, 2131230996, 2131230997, 2131231024, 2131230998, 2131231038, 2131230978, 2131230989, 2131230979, 2131230980, 2131230976, 2131230938, 2131230924, 2131230994, 2131230993, 2131231000, 2131230926, 2131231001, 2131231039, 2131231025, 2131230933, 2131230934, 2131230936, 2131230937};
        String[] stringArray = AppHolder.getApplication().getResources().getStringArray(2130903042);
        ArrayList arrayList = new ArrayList();
        if (108 == stringArray.length) {
            for (int i = 0; i < 108; i++) {
                arrayList.add(new CoolapkEmotion(numArr[i], stringArray[i]));
            }
        }
        StringBuilder sb = new StringBuilder("\\[(");
        for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
            sb.append(((BaseEmotion) arrayList.get(i2)).getText());
            sb.append("|");
        }
        sb.append(((BaseEmotion) arrayList.get(arrayList.size() - 1)).getText());
        sb.append(")\\]");
        sCoolApkParser = new EmotionAlbum(Pattern.compile(sb.toString()), true, arrayList, AppHolder.getApplication().getString(2131887314));
    }

    private static void initCoolBEmotions() {
        Integer[] numArr = {2131230875, 2131230883, 2131230890, 2131230877, 2131230884, 2131230891, 2131230878, 2131230886, 2131230893, 2131230880, 2131230888, 2131230894, 2131230881, 2131230887, 2131230882, 2131230889, 2131230876, 2131230885, 2131230892, 2131230879, 2131231008, 2131231009, 2131231011, 2131231012, 2131231013, 2131231027, 2131231028, 2131231029, 2131231030, 2131231031, 2131231033, 2131231034, 2131231035, 2131231036, 2131231037, 2131231014, 2131231015, 2131231016, 2131231017, 2131231018, 2131231019, 2131231020, 2131231022};
        String[] stringArray = AppHolder.getApplication().getResources().getStringArray(2130903043);
        ArrayList arrayList = new ArrayList();
        if (43 == stringArray.length) {
            for (int i = 0; i < 43; i++) {
                arrayList.add(new CoolBEmotion(numArr[i], stringArray[i]));
            }
        }
        StringBuilder sb = new StringBuilder("\\[(");
        for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
            sb.append(((BaseEmotion) arrayList.get(i2)).getText());
            sb.append("|");
        }
        sb.append(((BaseEmotion) arrayList.get(arrayList.size() - 1)).getText());
        sb.append(")\\]");
        sCoolBParser = new EmotionAlbum(Pattern.compile(sb.toString().replace("$", "\\$")), true, arrayList, AppHolder.getApplication().getString(2131887311));
    }
}
