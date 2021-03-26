package com.coolapk.market.widget.emotion;

import java.util.List;
import java.util.regex.Pattern;

public class EmotionAlbum {
    private List<BaseEmotion> mEmotionList;
    private String mName;
    private Pattern mPattern;
    private boolean mReplacedWithImg;

    public EmotionAlbum(Pattern pattern, boolean z, List<BaseEmotion> list, String str) {
        this.mEmotionList = list;
        this.mPattern = pattern;
        this.mName = str;
        this.mReplacedWithImg = z;
    }

    public boolean canReplacedWithImage() {
        return this.mReplacedWithImg;
    }

    public List<BaseEmotion> getEmotionList() {
        return this.mEmotionList;
    }

    public String getName() {
        return this.mName;
    }

    public Pattern getPattern() {
        return this.mPattern;
    }
}
