package com.coolapk.market.widget.emotion;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Html;
import android.text.Spannable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.widget.TextDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class EmotionUtils {
    public static final EmotionParseCountIntercept COUNT_INTERCEPT = new EmotionParseCountIntercept() {
        /* class com.coolapk.market.widget.emotion.EmotionUtils.AnonymousClass1 */
        private int count = 0;

        @Override // com.coolapk.market.widget.emotion.EmotionUtils.EmotionParseCountIntercept
        public boolean shouldIntercept() {
            int i = this.count;
            this.count = i + 1;
            return i >= 100;
        }

        @Override // com.coolapk.market.widget.emotion.EmotionUtils.EmotionParseCountIntercept
        public void reset() {
            this.count = 0;
        }
    };
    public static final int DEFAULT_MAX_PARSE_COUNT = 100;
    public static Html.ImageGetter USER_INDICATE_GETTER = new Html.ImageGetter() {
        /* class com.coolapk.market.widget.emotion.EmotionUtils.AnonymousClass2 */
        private Map<String, WeakReference<LayerDrawable>> drawableMap = new HashMap();

        @Override // android.text.Html.ImageGetter
        public Drawable getDrawable(String str) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 25019449:
                    if (str.equals("[图片]")) {
                        c = 0;
                        break;
                    }
                    break;
                case 27632346:
                    if (str.equals("[折叠]")) {
                        c = 1;
                        break;
                    }
                    break;
                case 27711923:
                    if (str.equals("[手机]")) {
                        c = 2;
                        break;
                    }
                    break;
                case 29282755:
                    if (str.equals("[楼主]")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            LayerDrawable layerDrawable = null;
            switch (c) {
                case 0:
                    Application application = AppHolder.getApplication();
                    LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{ResourceUtils.getDrawable(application, 2131231476)});
                    layerDrawable2.setLayerInset(0, DisplayUtils.dp2px(application, 2.0f), DisplayUtils.dp2px(application, 1.0f), DisplayUtils.dp2px(application, 2.0f), DisplayUtils.dp2px(application, 0.0f));
                    layerDrawable2.setTint(AppHolder.getAppTheme().getColorAccent());
                    return layerDrawable2;
                case 1:
                    WeakReference<LayerDrawable> weakReference = this.drawableMap.get(str);
                    if (weakReference != null) {
                        layerDrawable = weakReference.get();
                    }
                    if (layerDrawable == null) {
                        Application application2 = AppHolder.getApplication();
                        layerDrawable = new LayerDrawable(new Drawable[]{ResourceUtils.getDrawable(application2, 2131231296)});
                        layerDrawable.setLayerInset(0, DisplayUtils.dp2px(application2, 2.0f), 0, DisplayUtils.dp2px(application2, 2.0f), 0);
                        this.drawableMap.put(str, new WeakReference<>(layerDrawable));
                    }
                    layerDrawable.setTint(Color.parseColor("#9E9E9E"));
                    return layerDrawable;
                case 2:
                    WeakReference<LayerDrawable> weakReference2 = this.drawableMap.get(str);
                    if (weakReference2 != null) {
                        layerDrawable = weakReference2.get();
                    }
                    if (layerDrawable == null) {
                        Application application3 = AppHolder.getApplication();
                        layerDrawable = new LayerDrawable(new Drawable[]{ResourceUtils.getDrawable(application3, 2131231182)});
                        layerDrawable.setLayerInset(0, DisplayUtils.dp2px(application3, 0.0f), DisplayUtils.dp2px(application3, 0.0f), DisplayUtils.dp2px(application3, 0.0f), DisplayUtils.dp2px(application3, 0.0f));
                        this.drawableMap.put(str, new WeakReference<>(layerDrawable));
                    }
                    layerDrawable.setTint(Color.parseColor("#9E9E9E"));
                    return layerDrawable;
                case 3:
                    Application application4 = AppHolder.getApplication();
                    LayerDrawable layerDrawable3 = new LayerDrawable(new Drawable[]{new TextDrawable("楼主")});
                    layerDrawable3.setLayerInset(0, DisplayUtils.dp2px(application4, 2.0f), DisplayUtils.dp2px(application4, 2.0f), DisplayUtils.dp2px(application4, 2.0f), DisplayUtils.dp2px(application4, 1.0f));
                    layerDrawable3.setTint(AppHolder.getAppTheme().getColorAccent());
                    return layerDrawable3;
                default:
                    return null;
            }
        }
    };
    private static Map<String, BaseEmotion> sEmotionMap;
    private static Map<String, BaseEmotion> sEmotionMapForPanel;
    private static List<EmotionAlbum> sGroupList;
    private static List<EmotionAlbum> sGroupListForPanel;

    public interface EmotionParseCountIntercept {
        void reset();

        boolean shouldIntercept();
    }

    public static List<EmotionAlbum> getEmotionListCopy() {
        if (sGroupList == null) {
            ArrayList arrayList = new ArrayList();
            sGroupList = arrayList;
            arrayList.add(Emotions.sCoolApkParser);
            sGroupList.add(Emotions.sEmojiParser);
            sGroupList.add(Emotions.sCoolBParser);
            createEmotionMap();
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(sGroupList);
        return arrayList2;
    }

    public static List<EmotionAlbum> getEmotionListCopyForPanel() {
        if (sGroupListForPanel == null) {
            ArrayList arrayList = new ArrayList();
            sGroupListForPanel = arrayList;
            arrayList.add(Emotions.sCoolApkParser);
            sGroupListForPanel.add(Emotions.sEmojiParser);
            sGroupListForPanel.add(Emotions.sCoolBParser);
            createEmotionMapForPanel();
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(sGroupListForPanel);
        return arrayList2;
    }

    public static Map<String, BaseEmotion> getEmotionMap() {
        return sEmotionMap;
    }

    public static Map<String, BaseEmotion> getEmotionMapForPanel() {
        return sEmotionMapForPanel;
    }

    private static void createEmotionMap() {
        if (sEmotionMap == null) {
            sEmotionMap = new HashMap();
        }
        if (!sEmotionMap.isEmpty()) {
            sEmotionMap.clear();
        }
        for (EmotionAlbum emotionAlbum : sGroupList) {
            for (BaseEmotion baseEmotion : emotionAlbum.getEmotionList()) {
                sEmotionMap.put(baseEmotion.getRealText(), baseEmotion);
            }
        }
    }

    private static void createEmotionMapForPanel() {
        if (sEmotionMapForPanel == null) {
            sEmotionMapForPanel = new HashMap();
        }
        if (!sEmotionMapForPanel.isEmpty()) {
            sEmotionMapForPanel.clear();
        }
        for (EmotionAlbum emotionAlbum : sGroupListForPanel) {
            for (BaseEmotion baseEmotion : emotionAlbum.getEmotionList()) {
                sEmotionMapForPanel.put(baseEmotion.getRealText(), baseEmotion);
            }
        }
    }

    public static void parserEmoticons(Spannable spannable, int i, int i2, EmotionParseCountIntercept emotionParseCountIntercept) {
        Application application = AppHolder.getApplication();
        if (emotionParseCountIntercept != null) {
            emotionParseCountIntercept.reset();
        }
        if (sGroupList == null) {
            getEmotionListCopy();
        }
        Matcher matcher = null;
        String obj = spannable.toString();
        for (EmotionAlbum emotionAlbum : sGroupList) {
            if (emotionAlbum.canReplacedWithImage()) {
                if (matcher == null) {
                    matcher = emotionAlbum.getPattern().matcher("");
                } else {
                    matcher.usePattern(emotionAlbum.getPattern());
                }
                matcher.reset(obj).region(i, i2);
                setEmoticonSpan(application, spannable, matcher, emotionParseCountIntercept);
            }
        }
    }

    public static int getEmotionCount(String str) {
        if (sGroupListForPanel == null) {
            getEmotionListCopyForPanel();
        }
        int i = 0;
        Matcher matcher = null;
        for (EmotionAlbum emotionAlbum : sGroupListForPanel) {
            if (emotionAlbum.canReplacedWithImage()) {
                if (matcher == null) {
                    matcher = emotionAlbum.getPattern().matcher("");
                } else {
                    matcher.usePattern(emotionAlbum.getPattern());
                }
                matcher.reset(str);
                while (matcher.find()) {
                    i++;
                }
            }
        }
        return i;
    }

    private static void setEmoticonSpan(Context context, Spannable spannable, Matcher matcher, EmotionParseCountIntercept emotionParseCountIntercept) {
        while (matcher.find()) {
            if (emotionParseCountIntercept == null || !emotionParseCountIntercept.shouldIntercept()) {
                String group2 = matcher.group();
                BaseEmotion baseEmotion = getEmotionMap().get(group2);
                if (baseEmotion != null) {
                    spannable.setSpan(new ImageSpanAlignCenter(baseEmotion.getDrawable(context), baseEmotion.getRealText(), baseEmotion.getTransitionY()), matcher.start(), matcher.start() + group2.length(), 33);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String emotionTypeToHtmlGroup(String str) {
        char c;
        switch (str.hashCode()) {
            case 2592:
                if (str.equals("QQ")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 67868:
                if (str.equals("DOG")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 64307737:
                if (str.equals("COOLB")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 66095142:
                if (str.equals("EMOJI")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 79818927:
                if (str.equals("TIEBA")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1670194707:
                if (str.equals("COOLAPK")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return "coolbi";
        }
        if (c == 1) {
            return "doge";
        }
        if (c == 2) {
            return "emoji";
        }
        if (c != 3) {
            return c != 4 ? "default" : "qq";
        }
        return "tieba";
    }

    public static int getCompatibleEmotionIndex(String str) {
        try {
            int lastIndexOf = str.lastIndexOf(".gif");
            int parseInt = Integer.parseInt(str.substring(str.lastIndexOf("/", lastIndexOf) + 1, lastIndexOf).trim());
            if (parseInt > 95) {
                return -1;
            }
            return parseInt;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
