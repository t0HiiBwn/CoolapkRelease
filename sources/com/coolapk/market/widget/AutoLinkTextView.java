package com.coolapk.market.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;

public class AutoLinkTextView extends AppCompatTextView {
    private String foldText;
    private Entity mEntity;
    private Integer maxWords;

    public AutoLinkTextView(Context context) {
        super(context);
        setAutoLinkMask(1);
    }

    public AutoLinkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setAutoLinkMask(1);
    }

    public AutoLinkTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setAutoLinkMask(1);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence != null) {
            charSequence = LinkTextUtils.setLineToHtmlBr(charSequence.toString());
        }
        super.setText(setMaxWordsText(charSequence), bufferType);
        setRawWebUrlSpan();
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i, int i2) {
        if (charSequence != null) {
            charSequence = LinkTextUtils.setLineToHtmlBr(charSequence.toString());
        }
        super.append(setMaxWordsText(charSequence), i, i2);
        setRawWebUrlSpan();
    }

    public void setMaxWords(Integer num) {
        this.maxWords = num;
    }

    public void setEntity(Entity entity) {
        this.mEntity = entity;
    }

    public void setFoldText(String str) {
        this.foldText = str;
    }

    public boolean canHandle(CharSequence charSequence) {
        Entity entity = this.mEntity;
        return (entity != null && EntityUtils.isDyhArticleType(entity.getEntityType())) || charSequence.length() > this.maxWords.intValue();
    }

    private CharSequence setMaxWordsText(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = charSequence;
        if (this.maxWords != null) {
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            spannableStringBuilder = charSequence;
            if (!isEmpty) {
                boolean canHandle = canHandle(charSequence);
                spannableStringBuilder = charSequence;
                if (canHandle) {
                    spannableStringBuilder = charSequence;
                    if (!TextUtils.isEmpty(this.foldText)) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence);
                        if (charSequence.length() > this.maxWords.intValue()) {
                            spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder2.subSequence(0, this.maxWords.intValue());
                        }
                        SpannableStringBuilder trimSpannable = LinkTextUtils.trimSpannable(spannableStringBuilder2);
                        String str = this.foldText;
                        SpannableStringBuilder append = trimSpannable.append((CharSequence) "…").append((CharSequence) str);
                        int length = append.length() - str.length();
                        int length2 = append.length();
                        Entity entity = this.mEntity;
                        if (entity == null || !EntityUtils.isDyhArticleType(entity.getEntityType())) {
                            append.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), length, length2, 33);
                            spannableStringBuilder = append;
                        } else {
                            append.setSpan(new ClickableSpan() {
                                /* class com.coolapk.market.widget.AutoLinkTextView.AnonymousClass1 */

                                @Override // android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    DyhArticle dyhArticle = (DyhArticle) AutoLinkTextView.this.mEntity;
                                    if (TextUtils.isEmpty(dyhArticle.getRawUrl()) || !UriUtils.isInAppUrl(dyhArticle.getRawUrl())) {
                                        ActionManager.startWebViewForDyhActivity(UiUtils.getActivityNullable(AutoLinkTextView.this.getContext()), dyhArticle);
                                    } else {
                                        ActionManagerCompat.startActivityByUrl(UiUtils.getActivityNullable(AutoLinkTextView.this.getContext()), dyhArticle.getRawUrl(), null, null);
                                    }
                                }

                                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                public void updateDrawState(TextPaint textPaint) {
                                    super.updateDrawState(textPaint);
                                    textPaint.setColor(AppHolder.getAppTheme().getColorAccent());
                                    textPaint.setUnderlineText(false);
                                }
                            }, length, length2, 33);
                            spannableStringBuilder = append;
                        }
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    private void setRawWebUrlSpan() {
        if (getText().length() != 0) {
            LinkTextUtils.setRawWebUrlSpan(getText(), AppHolder.getAppTheme().getColorAccent());
            setMovementMethod(FixTouchLinkMovementMethod.getInstance());
            setClickable(false);
            setFocusable(false);
            setLongClickable(false);
        }
    }
}
