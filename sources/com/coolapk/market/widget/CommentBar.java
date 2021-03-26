package com.coolapk.market.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.CommentBarBinding;
import com.coolapk.market.model.DyhArticle;

public class CommentBar extends FrameLayout {
    private CommentBarBinding binding;
    private CallBack callBack;
    private final int favResrouce = 2131231559;
    private final int favedResrouce = 2131231557;
    private boolean isFaved;
    private boolean isLiked;
    private final int likeResrouce = 2131231682;
    private final int likedResrouce = 2131231246;
    private DyhArticle mDyhArticle;
    private boolean posting;

    public interface CallBack {
        void onActionViewClick(View view);
    }

    public CommentBar(Context context) {
        super(context);
        initView();
    }

    public CommentBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        CommentBarBinding commentBarBinding = (CommentBarBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558485, this, true);
        this.binding = commentBarBinding;
        commentBarBinding.imageView.setColorFilter(AppHolder.getAppTheme().getTextColorTertiary(), PorterDuff.Mode.SRC_IN);
        setElevation();
    }

    public void setActionViewCallback(CallBack callBack2) {
        this.callBack = callBack2;
    }

    public void addOtherView(DyhArticle dyhArticle, int i, Integer num) {
        Drawable drawable;
        this.mDyhArticle = dyhArticle;
        View inflate = LayoutInflater.from(getContext()).inflate(2131558659, (ViewGroup) this, false);
        ImageView imageView = (ImageView) inflate.findViewById(2131362672);
        TextView textView = (TextView) inflate.findViewById(2131363533);
        String str = "";
        if (i == 0) {
            if (this.mDyhArticle.isLiked()) {
                drawable = ContextCompat.getDrawable(getContext(), 2131231246).mutate();
            } else {
                drawable = ContextCompat.getDrawable(getContext(), 2131231682).mutate();
            }
            this.isLiked = this.mDyhArticle.isLiked();
            if (this.mDyhArticle.getLikeNum() > 0) {
                str = String.valueOf(this.mDyhArticle.getLikeNum());
            }
            textView.setText(str);
        } else {
            if (this.mDyhArticle.isFavorite()) {
                drawable = ContextCompat.getDrawable(getContext(), 2131231557).mutate();
            } else {
                drawable = ContextCompat.getDrawable(getContext(), 2131231559).mutate();
            }
            this.isFaved = this.mDyhArticle.isFavorite();
            if (this.mDyhArticle.getFavNum() > 0) {
                str = String.valueOf(this.mDyhArticle.getFavNum());
            }
            textView.setText(str);
        }
        drawable.setTint(AppHolder.getAppTheme().getColorAccent());
        imageView.setImageDrawable(drawable);
        textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.widget.CommentBar.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommentBar.this.callBack != null) {
                    CommentBar.this.callBack.onActionViewClick(view);
                }
            }
        });
        inflate.setId(num.intValue());
        this.binding.actionContainer.addView(inflate);
    }

    public void setOnClickListeners(View.OnClickListener onClickListener) {
        this.binding.commentBox.setOnClickListener(onClickListener);
        this.binding.commentView.setOnClickListener(onClickListener);
        this.binding.shareView.setOnClickListener(onClickListener);
    }

    public void setReplyCount(int i) {
        this.binding.commentCount.setText(i > 0 ? String.valueOf(i) : "");
    }

    public void setVisiblityShareView(int i) {
        this.binding.shareView.setVisibility(i);
    }

    public void setReplyText(String str) {
        this.binding.commentCount.setText(str);
    }

    public void setCommentIconVisibility(int i) {
        this.binding.commentIcon.setVisibility(i);
    }

    public void setCommentIcon(int i) {
        this.binding.commentIcon.setImageResource(i);
    }

    public View getViewById(int i) {
        switch (i) {
            case 2131362286:
                return this.binding.commentCount;
            case 2131362287:
                return this.binding.commentIcon;
            case 2131362290:
                return this.binding.commentText;
            case 2131362291:
                return this.binding.commentView;
            case 2131363358:
                return this.binding.shareView;
            default:
                return null;
        }
    }

    public void setCommentBarText(String str) {
        this.binding.commentText.setText(str);
    }

    private void setElevation() {
        float f = getResources().getDisplayMetrics().density;
        setBackground(new RoundRectDrawableWithShadow(getContext(), -16777216, 0.0f, ((float) 3) * f, (((float) 4) * f) + 1.0f));
    }
}
