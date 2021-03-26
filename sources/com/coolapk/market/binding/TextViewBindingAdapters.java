package com.coolapk.market.binding;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.FeedTextUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UserUtils;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.AutoLinkTextView;
import com.coolapk.market.widget.FixArrowKeyMovementMethod;
import com.coolapk.market.widget.FixTouchLinkMovementMethod;
import com.coolapk.market.widget.emotion.EmotionUtils;
import java.util.List;

public class TextViewBindingAdapters {
    public static void setActionText(TextView textView, ServiceApp serviceApp) {
        UpgradeInfo upgradeInfo;
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
        String[] strArr = new String[4];
        strArr[0] = serviceApp.getDownloadUrlMd5(0);
        strArr[1] = serviceApp.getDownloadUrlMd5(2);
        if (!(mobileAppExistFast == null || (upgradeInfo = mobileAppExistFast.getUpgradeInfo()) == null)) {
            strArr[2] = upgradeInfo.getDownloadUrlMd5(0);
            strArr[3] = upgradeInfo.getDownloadUrlMd5(1);
        }
        textView.setText(StateUtils.getActionText(textView.getContext(), true, serviceApp.getPackageName(), serviceApp.getPackageName(), strArr));
    }

    public static void setTextViewLinkable(TextView textView, String str) {
        setTextViewLinkable(textView, str, null, null, null, null, null);
    }

    public static void setTextViewLinkable(TextView textView, String str, Integer num, String str2, Boolean bool, Html.ImageGetter imageGetter, String str3) {
        Integer stringToColor;
        if (str == null) {
            textView.setText((CharSequence) null);
            return;
        }
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        if (!(str2 == null || (stringToColor = ColorUtils.stringToColor(str2)) == null)) {
            colorAccent = stringToColor.intValue();
        }
        SpannableStringBuilder convert = LinkTextUtils.convert(str, colorAccent, imageGetter);
        if (num != null && convert.length() > num.intValue()) {
            SpannableStringBuilder trimSpannable = LinkTextUtils.trimSpannable((SpannableStringBuilder) convert.subSequence(0, num.intValue()));
            String string = textView.getContext().getString(2131886718);
            if (TextUtils.isEmpty(str3)) {
                str3 = string;
            }
            convert = trimSpannable.append((CharSequence) str3);
            convert.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), (convert.length() - str3.length()) + str3.indexOf("…") + 1, convert.length(), 33);
        }
        convert.append((CharSequence) " ");
        textView.setText(convert);
        if (bool == null || !bool.booleanValue()) {
            textView.setMovementMethod(FixTouchLinkMovementMethod.getInstance());
            textView.setClickable(false);
            textView.setFocusable(false);
            textView.setLongClickable(false);
            return;
        }
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(FixArrowKeyMovementMethod.getInstance());
    }

    public static void setAutoTextViewLinkable(AutoLinkTextView autoLinkTextView, String str, Integer num, String str2, Entity entity) {
        if (str == null) {
            autoLinkTextView.setText((CharSequence) null);
            return;
        }
        if (entity != null) {
            autoLinkTextView.setEntity(entity);
        }
        StringBuilder sb = new StringBuilder(str);
        if (num != null && !TextUtils.isEmpty(str2)) {
            autoLinkTextView.setMaxWords(num);
            autoLinkTextView.setFoldText(str2);
        }
        sb.append(" ");
        autoLinkTextView.setText(sb.toString());
    }

    public static void setTime(TextView textView, String str) {
        if (TextUtils.isEmpty(str) || "0".equals(str)) {
            textView.setText((CharSequence) null);
            textView.setVisibility(8);
            return;
        }
        textView.setText(DateUtils.getTimeDescription(AppHolder.getApplication(), str));
        textView.setVisibility(0);
    }

    public static void setTime(TextView textView, Long l) {
        if (l == null || l.longValue() == 0) {
            textView.setText((CharSequence) null);
            textView.setVisibility(8);
            return;
        }
        textView.setText(DateUtils.getTimeDescription(AppHolder.getApplication(), l));
        textView.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    public static void setDatelineByEntity(TextView textView, Entity entity) {
        DyhModel dyhModel;
        if (EntityUtils.isFeedType(entity.getEntityType())) {
            Feed feed = (Feed) entity;
            if (feed.getDyhModel() != null) {
                dyhModel = feed.getDyhModel();
                if (EntityExtendsKt.isDatelineVisible(entity)) {
                    textView.setVisibility(0);
                    textView.setText(DateUtils.getTimeDescription(AppHolder.getApplication(), EntityUtils.isDyhArticleType(entity.getEntityType()) ? ((DyhArticle) entity).getCreatDate() : entity.getDateline()));
                    if (dyhModel != null && dyhModel.getUserAction() != null && dyhModel.getUserAction().getFollow() == 0) {
                        textView.setVisibility(8);
                        return;
                    }
                    return;
                }
                textView.setVisibility(8);
                return;
            }
        } else if (EntityUtils.isDyhArticleType(entity.getEntityType())) {
            dyhModel = ((DyhArticle) entity).getDyhModel();
            if (EntityExtendsKt.isDatelineVisible(entity)) {
            }
        }
        dyhModel = null;
        if (EntityExtendsKt.isDatelineVisible(entity)) {
        }
    }

    public static void setDeviceTitle(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            setTextViewLinkable(textView, textView.getContext().getString(2131886839, String.format("<a class=\"feed-link-tag\" href=\"/t/%s?from=device_title\">%s</a>", str, str)));
        }
    }

    public static void setFeedFromType(TextView textView, String str) {
        if (TextUtils.isEmpty(str) || str.equals("好友圈")) {
            textView.setText((CharSequence) null);
        } else {
            textView.setText(String.format("来自%s", str));
        }
    }

    public static void setReplyText(TextView textView, FeedReply feedReply) {
        String replyUserNamePart = getReplyUserNamePart(feedReply, feedReply.hasOtherReplyUser());
        textView.setVisibility(0);
        SpannableStringBuilder convert = LinkTextUtils.convert(replyUserNamePart, AppHolder.getAppTheme().getColorAccent(), EmotionUtils.USER_INDICATE_GETTER);
        if (!TextUtils.isEmpty(feedReply.getPic())) {
            FeedTextUtils.appendPhotoLink(convert, ImageUrl.create(feedReply.getPic(), feedReply.getMiddleSizePic()));
        }
        convert.append((CharSequence) " ");
        textView.setText(convert);
        ViewExtendsKt.makeSpanClickable(textView);
    }

    public static void setSubReplyText(TextView textView, FeedReply feedReply, String str) {
        String replyUserNamePart = getReplyUserNamePart(feedReply, feedReply.hasOtherReplyUser() && !str.equals(feedReply.getReplyUid()));
        textView.setVisibility(0);
        SpannableStringBuilder convert = LinkTextUtils.convert(replyUserNamePart, AppHolder.getAppTheme().getColorAccent(), EmotionUtils.USER_INDICATE_GETTER);
        if (!TextUtils.isEmpty(feedReply.getPic())) {
            FeedTextUtils.appendPhotoLink(convert, ImageUrl.create(feedReply.getPic(), feedReply.getMiddleSizePic()));
        }
        convert.append((CharSequence) " ");
        textView.setText(convert);
        ViewExtendsKt.makeSpanClickable(textView);
    }

    private static String getReplyUserNamePart(FeedReply feedReply, boolean z) {
        Application application = AppHolder.getApplication();
        String userSpan = UserUtils.getUserSpan(feedReply.getUid(), feedReply.getUserName());
        if (feedReply.getIsFeedAuthor() > 0) {
            userSpan = userSpan + "<img src=\"[楼主]\"/>";
        }
        if (feedReply.getBlockStatus() == 1) {
            if (DataManager.getInstance().getLoginSession().isAdmin()) {
                userSpan = "<img src=\"[折叠]\"/>";
            } else {
                userSpan = "" + userSpan;
            }
        }
        if (z) {
            return String.format(application.getString(2131886854), userSpan, UserUtils.getUserSpan(feedReply.getReplyUid(), feedReply.getReplyUserName()), feedReply.getMessage());
        }
        return String.format("%s: %s", userSpan, feedReply.getMessage());
    }

    public static void setFeedReplyUserText(TextView textView, FeedReply feedReply, Boolean bool) {
        if (feedReply != null) {
            if (bool == null) {
                bool = true;
            }
            String userSpan = UserUtils.getUserSpan(feedReply.getUid(), feedReply.getUserName());
            if (feedReply.getIsFeedAuthor() > 0) {
                userSpan = userSpan + "<img src=\"[楼主]\"/>";
            }
            Application application = AppHolder.getApplication();
            if (feedReply.hasOtherReplyUser() && bool.booleanValue()) {
                userSpan = String.format(application.getString(2131886862), userSpan, UserUtils.getUserSpan(feedReply.getReplyUid(), feedReply.getReplyUserName()));
            }
            setTextViewLinkable(textView, userSpan, null, null, null, EmotionUtils.USER_INDICATE_GETTER, null);
        }
    }

    public static void replyListReplyTo(TextView textView, FeedReply feedReply) {
        String str;
        if (feedReply != null) {
            Application application = AppHolder.getApplication();
            if (feedReply.hasOtherReplyUser()) {
                str = application.getString(2131887187, UserUtils.getUserSpan(feedReply.getReplyUid(), feedReply.getReplyUserName()), feedReply.getMessage());
            } else {
                str = feedReply.getMessage();
            }
            setTextViewLinkable(textView, str, 90, null, null, EmotionUtils.USER_INDICATE_GETTER, null);
        }
    }

    public static void replyListReplyMe(TextView textView, FeedReply feedReply) {
        String str;
        if (feedReply != null) {
            Application application = AppHolder.getApplication();
            if (feedReply.hasOtherReplyUser()) {
                str = application.getString(2131887186, feedReply.getMessage());
            } else {
                str = feedReply.getMessage();
            }
            setTextViewLinkable(textView, str, null, null, null, EmotionUtils.USER_INDICATE_GETTER, null);
        }
    }

    public static void setDrawable(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, String str) {
        int themeColor = ThemeBindingAdapters.getThemeColor(str);
        if (themeColor != 0) {
            if (drawable != null) {
                drawable = drawable.mutate();
                drawable.setTint(themeColor);
            }
            if (drawable2 != null) {
                drawable2 = drawable2.mutate();
                drawable2.setTint(themeColor);
            }
            if (drawable3 != null) {
                drawable3 = drawable3.mutate();
                drawable3.setTint(themeColor);
            }
            if (drawable4 != null) {
                drawable4 = drawable4.mutate();
                drawable4.setTint(themeColor);
            }
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static void setFeedLikeText(TextView textView, Feed feed) {
        if (feed != null) {
            StringBuilder sb = new StringBuilder();
            List<String> recentLikeList = feed.getRecentLikeList();
            if (recentLikeList == null || recentLikeList.isEmpty()) {
                textView.setText((CharSequence) null);
                return;
            }
            for (int i = 0; i < recentLikeList.size() - 1; i++) {
                sb.append(UserUtils.getUserNameSpan(recentLikeList.get(i)));
                sb.append(", ");
            }
            sb.append(UserUtils.getUserNameSpan(recentLikeList.get(recentLikeList.size() - 1)));
            setTextViewLinkable(textView, sb.toString());
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x007e: APUT  (r1v1 float[]), (4 ??[int, float, short, byte, char]), (r5v0 float) */
    public static void setGifIndicatorVisibility(TextView textView, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        String notNull = StringUtils.notNull(str);
        boolean isGifPicture = ImageArgs.Companion.isGifPicture(notNull);
        boolean isLongPicture = ImageArgs.Companion.isLongPicture(notNull);
        if (isGifPicture && isLongPicture) {
            textView.setVisibility(0);
            textView.setText("GIF/长图");
        } else if (isGifPicture) {
            textView.setVisibility(0);
            textView.setText("GIF");
        } else if (isLongPicture) {
            textView.setVisibility(0);
            textView.setText("长图");
        } else {
            textView.setVisibility(8);
        }
        Drawable background = textView.getBackground();
        if (textView.getVisibility() == 0 && background == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            int dp2px = DisplayUtils.dp2px(textView.getContext(), 2.0f);
            int dp2px2 = DisplayUtils.dp2px(textView.getContext(), 8.0f);
            float[] fArr = new float[8];
            float f = (float) dp2px;
            fArr[0] = f;
            fArr[1] = f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = z ? (float) dp2px2 : f;
            if (z) {
                f = (float) dp2px2;
            }
            fArr[5] = f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            gradientDrawable.setCornerRadii(fArr);
            gradientDrawable.setAlpha(178);
            gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
            textView.setBackground(gradientDrawable);
        }
    }
}
