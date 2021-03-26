package com.coolapk.market.binding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.FeedTarget;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.AlbumActionView;
import com.coolapk.market.widget.AlbumFeedActionView;
import com.coolapk.market.widget.ColorProgressDrawable;
import com.coolapk.market.widget.DyhActionView;
import com.coolapk.market.widget.FeedActionView2;
import com.coolapk.market.widget.FeedReplyActionView;
import com.coolapk.market.widget.ForegroundTextView;
import com.coolapk.market.widget.view.ImageLoadProgressBar;
import java.util.ArrayList;

public class ViewBindingAdapters {
    public static void setColorProgress(View view, int i, float f, int i2) {
        if (f == 0.0f) {
            f = 1.0f;
            i2 = 30;
        }
        ColorProgressDrawable colorProgressDrawable = new ColorProgressDrawable(i);
        colorProgressDrawable.setProgress(f, i2);
        view.setBackground(colorProgressDrawable);
    }

    public static void setOnLongClickListener(View view, View.OnLongClickListener onLongClickListener) {
        view.setOnLongClickListener(onLongClickListener);
    }

    public static void setFadeShow(final View view, final Integer num, Boolean bool, Integer num2) {
        if (num == null) {
            throw new IllegalArgumentException("Did you miss fadeVisibility attr?");
        } else if (view.getVisibility() != num.intValue()) {
            if (bool == null || bool.booleanValue()) {
                if (num2 == null) {
                    num2 = 500;
                }
                if (num.intValue() == 0) {
                    view.setVisibility(num.intValue());
                    view.setAlpha(0.0f);
                    ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f)).setDuration((long) num2.intValue()).start();
                    return;
                }
                ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f)).setDuration((long) num2.intValue());
                duration.addListener(new AnimatorListenerAdapter() {
                    /* class com.coolapk.market.binding.ViewBindingAdapters.AnonymousClass1 */

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        view.setVisibility(num.intValue());
                        view.setAlpha(1.0f);
                    }
                });
                duration.start();
                return;
            }
            view.setVisibility(num.intValue());
        }
    }

    public static void setBackgroundCircleColor(ImageView imageView, Integer num) {
        Drawable drawable = ResourceUtils.getDrawable(imageView.getContext(), 2131231885);
        drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        imageView.setBackground(drawable);
    }

    public static void updateAlbum(AlbumFeedActionView albumFeedActionView, Album album) {
        albumFeedActionView.updateFeed(album);
    }

    public static void updateFeed(FeedActionView2 feedActionView2, Feed feed) {
        feedActionView2.updateFeed(feed);
    }

    public static void setIsSimple(FeedActionView2 feedActionView2, boolean z) {
        feedActionView2.setIsSimple(z);
    }

    public static void updateFeed(ForegroundTextView foregroundTextView, Feed feed) {
        int status = feed.getStatus();
        if (status == -20 || status == -21 || status == -22) {
            foregroundTextView.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add("动态审核中");
            arrayList.add("@" + feed.getUserName());
            foregroundTextView.setTextList(arrayList);
            return;
        }
        foregroundTextView.setVisibility(8);
    }

    public static void updateDyhArticle(DyhActionView dyhActionView, DyhArticle dyhArticle) {
        dyhActionView.updateDyhArticle(dyhArticle);
    }

    public static void updateAlbum(AlbumActionView albumActionView, Album album) {
        albumActionView.updateAlbum(album);
    }

    public static void updateFeedReply(FeedReplyActionView feedReplyActionView, FeedReply feedReply) {
        feedReplyActionView.updateFeedReply(feedReply);
    }

    public static void setSize(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static void clickListener(View view, View.OnClickListener onClickListener, Boolean bool) {
        if (bool == null || !bool.booleanValue()) {
            ViewUtil.clickListener(view, onClickListener);
        } else {
            ViewUtil.directClickListener(view, onClickListener);
        }
    }

    public static void setImageLoadProgressBar(ImageLoadProgressBar imageLoadProgressBar, String str) {
        imageLoadProgressBar.setMonitorUrl(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    public static void clipView(View view, String str, Number number) {
        int i = 2;
        if (str != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 3423314:
                    if (str.equals("oval")) {
                        c = 0;
                        break;
                    }
                    break;
                case 552555053:
                    if (str.equals("capsule")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1121299823:
                    if (str.equals("rectangle")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 1;
                    break;
            }
            float f = 0.0f;
            if (number != null) {
                f = (float) ConvertUtils.dp2px(number.floatValue());
            }
            ViewExtendsKt.clipView(view, i, f);
        }
        i = 0;
        float f = 0.0f;
        if (number != null) {
        }
        ViewExtendsKt.clipView(view, i, f);
    }

    public static void warnContainer(View view, Boolean bool) {
        String optString = AppHolder.getAppSetting().getConfigJson().optString("writerWarning");
        if (!TextUtils.isEmpty(optString)) {
            if (view instanceof TextView) {
                ((TextView) view).setText(optString);
            }
            if (view instanceof LinearLayout) {
                view.setVisibility(0);
            }
        } else if (view instanceof LinearLayout) {
            view.setVisibility(8);
        }
    }

    public static void setUserLevelBackground(View view, Integer num) {
        int i;
        if (num == null) {
            view.setVisibility(8);
            return;
        }
        if (num.intValue() <= 0) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        if (num.intValue() >= 10) {
            i = 2131099902;
        } else if (num.intValue() == 9) {
            i = 2131099910;
        } else if (num.intValue() == 8) {
            i = 2131099909;
        } else if (num.intValue() == 7) {
            i = 2131099908;
        } else if (num.intValue() == 6) {
            i = 2131099907;
        } else if (num.intValue() == 5) {
            i = 2131099906;
        } else if (num.intValue() == 4) {
            i = 2131099905;
        } else if (num.intValue() == 3) {
            i = 2131099904;
        } else {
            i = num.intValue() == 2 ? 2131099903 : 2131099901;
        }
        view.setBackgroundTintList(ColorStateList.valueOf(ResourceUtils.getColorInt(view.getContext(), i)));
    }

    public static void setFeedTargetClick(final View view, final Feed feed) {
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.binding.ViewBindingAdapters.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FeedTarget targetRow;
                Feed feed = feed;
                if (feed != null && (targetRow = feed.getTargetRow()) != null) {
                    ActionManagerCompat.startActivityByUrl(view.getContext(), targetRow.getUrl(), targetRow.getTitle(), targetRow.getSubTitle());
                }
            }
        });
    }
}
