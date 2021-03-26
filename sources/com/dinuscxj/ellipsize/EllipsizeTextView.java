package com.dinuscxj.ellipsize;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EllipsizeTextView extends TextView {
    private static final String DEFAULT_ELLIPSIZE_TEXT = "...";
    private int mEllipsizeIndex;
    private CharSequence mEllipsizeText;
    private boolean mEnableUpdateOriginText;
    private boolean mIsExactlyMode;
    private int mMaxLines;
    private CharSequence mOriginText;

    public EllipsizeTextView(Context context) {
        this(context, null);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnableUpdateOriginText = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EllipsizeTextView);
        this.mEllipsizeIndex = obtainStyledAttributes.getInt(R.styleable.EllipsizeTextView_ellipsize_index, 0);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.EllipsizeTextView_ellipsize_text);
        this.mEllipsizeText = text;
        if (text == null) {
            this.mEllipsizeText = "...";
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (this.mMaxLines != i) {
            super.setMaxLines(i);
            this.mMaxLines = i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        setText(this.mOriginText);
        super.onMeasure(i, i2);
        try {
            this.mIsExactlyMode = View.MeasureSpec.getMode(i) == 1073741824;
            Layout layout = getLayout();
            if (layout == null) {
                return;
            }
            if (isExceedMaxLine(layout) || isOutOfBounds(layout)) {
                adjustEllipsizeEndText(layout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.mEnableUpdateOriginText) {
            this.mOriginText = charSequence;
        }
        super.setText(charSequence, bufferType);
        if (this.mIsExactlyMode) {
            requestLayout();
        }
    }

    private boolean isExceedMaxLine(Layout layout) {
        int lineCount = layout.getLineCount();
        int i = this.mMaxLines;
        return lineCount > i && i > 0;
    }

    private boolean isOutOfBounds(Layout layout) {
        return layout.getHeight() > (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private void adjustEllipsizeEndText(Layout layout) {
        CharSequence charSequence = this.mOriginText;
        CharSequence subSequence = charSequence.subSequence(charSequence.length() - this.mEllipsizeIndex, charSequence.length());
        int width = (layout.getWidth() - getPaddingLeft()) - getPaddingRight();
        int max = Math.max(1, computeMaxLineCount(layout)) - 1;
        int lineEnd = layout.getLineEnd(max);
        this.mEnableUpdateOriginText = false;
        int lineWidth = ((int) layout.getLineWidth(max)) + ((int) (Layout.getDesiredWidth(this.mEllipsizeText, getPaint()) + Layout.getDesiredWidth(subSequence, getPaint()))) + 1;
        if (lineWidth > width) {
            setText(charSequence.subSequence(0, lineEnd - computeRemovedEllipsizeEndCharacterCount(lineWidth - width, charSequence.subSequence(0, lineEnd))));
            append(this.mEllipsizeText);
            append(subSequence);
        } else {
            setText(charSequence.subSequence(0, lineEnd));
            append(this.mEllipsizeText);
            append(subSequence);
        }
        this.mEnableUpdateOriginText = true;
    }

    private int computeMaxLineCount(Layout layout) {
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i = 0; i < layout.getLineCount(); i++) {
            if (measuredHeight < layout.getLineBottom(i)) {
                return i;
            }
        }
        return layout.getLineCount();
    }

    private int computeRemovedEllipsizeEndCharacterCount(int i, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        List<Range<Integer>> computeCharacterStyleRanges = computeCharacterStyleRanges(charSequence);
        String charSequence2 = charSequence.toString();
        charSequence.length();
        int codePointCount = charSequence2.codePointCount(0, charSequence.length());
        int i2 = 0;
        while (codePointCount > 0 && i > i2) {
            codePointCount--;
            int offsetByCodePoints = charSequence2.offsetByCodePoints(0, codePointCount);
            Range<Integer> computeCharacterStyleRange = computeCharacterStyleRange(computeCharacterStyleRanges, offsetByCodePoints);
            if (computeCharacterStyleRange != null) {
                offsetByCodePoints = computeCharacterStyleRange.getLower().intValue();
                codePointCount = charSequence2.codePointCount(0, offsetByCodePoints);
            }
            i2 = (int) Layout.getDesiredWidth(charSequence.subSequence(offsetByCodePoints, charSequence.length()), getPaint());
        }
        return charSequence.length() - charSequence2.offsetByCodePoints(0, codePointCount);
    }

    private Range<Integer> computeCharacterStyleRange(List<Range<Integer>> list, int i) {
        if (list != null && !list.isEmpty()) {
            for (Range<Integer> range : list) {
                if (range.contains(Integer.valueOf(i))) {
                    return range;
                }
            }
        }
        return null;
    }

    private List<Range<Integer>> computeCharacterStyleRanges(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) valueOf.getSpans(0, valueOf.length(), CharacterStyle.class);
        if (characterStyleArr == null || characterStyleArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (CharacterStyle characterStyle : characterStyleArr) {
            arrayList.add(new Range(Integer.valueOf(valueOf.getSpanStart(characterStyle)), Integer.valueOf(valueOf.getSpanEnd(characterStyle))));
        }
        return arrayList;
    }

    public void setEllipsizeText(CharSequence charSequence, int i) {
        this.mEllipsizeText = charSequence;
        this.mEllipsizeIndex = i;
    }

    public static final class Range<T extends Comparable<? super T>> {
        private final T mLower;
        private final T mUpper;

        public Range(T t, T t2) {
            this.mLower = t;
            this.mUpper = t2;
            if (t.compareTo(t2) > 0) {
                throw new IllegalArgumentException("lower must be less than or equal to upper");
            }
        }

        public T getLower() {
            return this.mLower;
        }

        public T getUpper() {
            return this.mUpper;
        }

        public boolean contains(T t) {
            boolean z = t.compareTo(this.mLower) >= 0;
            boolean z2 = t.compareTo(this.mUpper) < 0;
            if (!z || !z2) {
                return false;
            }
            return true;
        }
    }
}
