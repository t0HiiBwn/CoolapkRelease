package com.coolapk.market.view.message;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Message;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.CoolMarketURLSpan;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.coolapk.market.widget.view.ShapedImageView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/message/MessageContentBindHelp;", "", "()V", "messageClickAction", "", "view", "Landroid/view/View;", "message", "Lcom/coolapk/market/model/Message;", "activity", "Landroid/app/Activity;", "picView", "Lcom/coolapk/market/widget/view/ShapedImageView;", "messagePicSizeBind", "", "context", "Landroid/content/Context;", "messagePic", "messageTextBind", "textView", "Landroid/widget/TextView;", "isUser", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageContentBindHelp.kt */
public final class MessageContentBindHelp {
    public static final MessageContentBindHelp INSTANCE = new MessageContentBindHelp();

    private MessageContentBindHelp() {
    }

    public final void messageTextBind(TextView textView, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setAutoLinkMask(0);
        CharSequence text = textView.getText();
        if (text instanceof SpannableString) {
            SpannableString spannableString = (SpannableString) text;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, text.length(), URLSpan.class);
            for (URLSpan uRLSpan : uRLSpanArr) {
                int spanStart = spannableString.getSpanStart(uRLSpan);
                int spanEnd = spannableString.getSpanEnd(uRLSpan);
                int spanFlags = spannableString.getSpanFlags(uRLSpan);
                spannableString.removeSpan(uRLSpan);
                Intrinsics.checkNotNullExpressionValue(uRLSpan, "span");
                String url = uRLSpan.getURL();
                int colorAccent = AppHolder.getAppTheme().getColorAccent();
                if (!z) {
                    colorAccent = -1;
                }
                spannableString.setSpan(new CoolMarketURLSpan(url, colorAccent, true), spanStart, spanEnd, spanFlags);
            }
            textView.setText(text);
        }
    }

    public final String messagePicSizeBind(Context context, ShapedImageView shapedImageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shapedImageView, "picView");
        String str2 = "s";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        ViewGroup.LayoutParams layoutParams = shapedImageView.getLayoutParams();
        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(str);
        if (size == null) {
            return str2;
        }
        int dp2px = DisplayUtils.dp2px(context, 160.0f);
        if (size.getHeight() > size.getWidth()) {
            int dp2px2 = DisplayUtils.dp2px(context, 60.0f);
            if (size.getHeight() / size.getWidth() >= 4) {
                layoutParams.height = dp2px;
                float height = ((float) dp2px) / ((float) size.getHeight());
                if (((float) size.getWidth()) * height > ((float) dp2px2)) {
                    layoutParams.width = (int) (((float) size.getWidth()) * height);
                } else {
                    layoutParams.width = dp2px2;
                }
                shapedImageView.setScaleType(ImageView.ScaleType.MATRIX);
                shapedImageView.setAlignType(ShapedImageView.AlignType.TOP);
            } else if (size.getHeight() > dp2px2 || size.getWidth() > dp2px2) {
                layoutParams.height = dp2px;
                layoutParams.width = (int) (((float) size.getWidth()) * (((float) dp2px) / ((float) size.getHeight())));
                shapedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                layoutParams.height = dp2px2;
                layoutParams.width = size.getWidth() * ((int) (((float) dp2px2) / ((float) size.getHeight())));
            }
        } else {
            int dp2px3 = DisplayUtils.dp2px(context, 40.0f);
            if (size.getWidth() / size.getHeight() >= 4) {
                layoutParams.width = dp2px;
                float width = ((float) dp2px) / ((float) size.getWidth());
                if (((float) size.getHeight()) * width > ((float) dp2px3)) {
                    layoutParams.height = (int) (((float) size.getHeight()) * width);
                } else {
                    layoutParams.height = dp2px3;
                }
                shapedImageView.setScaleType(ImageView.ScaleType.MATRIX);
                shapedImageView.setAlignType(ShapedImageView.AlignType.LEFT);
                str2 = "m";
            } else if (size.getHeight() > dp2px3 || size.getWidth() > dp2px3) {
                layoutParams.width = dp2px;
                layoutParams.height = (int) (((float) size.getHeight()) * (((float) dp2px) / ((float) size.getWidth())));
                shapedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                layoutParams.height = dp2px3;
                layoutParams.width = size.getWidth() * ((int) (((float) dp2px3) / ((float) size.getHeight())));
            }
        }
        shapedImageView.setLayoutParams(layoutParams);
        shapedImageView.requestLayout();
        shapedImageView.setMaxHeight(dp2px);
        shapedImageView.setMaxWidth(dp2px);
        return (size.getWidth() <= 360 || size.getHeight() <= 360) ? "n" : str2;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, com.coolapk.market.model.Entity] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void messageClickAction(View view, Message message, Activity activity, ShapedImageView shapedImageView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shapedImageView, "picView");
        int id = view.getId();
        if (id != 2131362200) {
            if (id != 2131363102) {
                if (id == 2131363877) {
                    ActionManager.startUserSpaceActivity(view, message.getFromUid(), message.getFromUserAvatar());
                }
            } else if (activity instanceof ChattingActivity) {
                Fragment findFragmentById = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager().findFragmentById(2131363592);
                Objects.requireNonNull(findFragmentById, "null cannot be cast to non-null type com.coolapk.market.view.message.ChatListFragment");
                ChatListFragment chatListFragment = (ChatListFragment) findFragmentById;
                ChattingActivity chattingActivity = (ChattingActivity) activity;
                if (chattingActivity.getMessageList().size() > 0) {
                    chattingActivity.getMessageList().clear();
                }
                for (int size = chatListFragment.getDataList().size() - 1; size >= 0; size--) {
                    ?? r1 = (Entity) chatListFragment.getDataList().get(size);
                    if ((r1 instanceof Message) && ((Message) r1).isShowPic() && !chattingActivity.getMessageList().contains(r1)) {
                        chattingActivity.getMessageList().add(r1);
                    }
                }
                String[] strArr = new String[chattingActivity.getMessageList().size()];
                Rect[] rectArr = new Rect[chattingActivity.getMessageList().size()];
                int i = 0;
                for (T t : chattingActivity.getMessageList()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    T t2 = t;
                    strArr[i] = t2.getMessagePic();
                    String messageImageUrl = DataManager.getInstance().getMessageImageUrl(t2.getId(), "n");
                    String messageImageUrl2 = DataManager.getInstance().getMessageImageUrl(t2.getId(), "s");
                    if (!chattingActivity.getPicMidList().contains(messageImageUrl2)) {
                        List<String> picMidList = chattingActivity.getPicMidList();
                        Intrinsics.checkNotNullExpressionValue(messageImageUrl2, "picMid");
                        picMidList.add(i, messageImageUrl2);
                    }
                    if (!chattingActivity.getPicSourceList().contains(messageImageUrl)) {
                        List<String> picSourceList = chattingActivity.getPicSourceList();
                        Intrinsics.checkNotNullExpressionValue(messageImageUrl, "picSource");
                        picSourceList.add(i, messageImageUrl);
                    }
                    rectArr[i] = ViewExtendsKt.getGlobalRect(shapedImageView);
                    i = i2;
                }
                int indexOf = chattingActivity.getPicSourceList().indexOf(DataManager.getInstance().getMessageImageUrl(message.getId(), "n"));
                Object[] array = chattingActivity.getPicSourceList().toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                String[] strArr2 = (String[]) array;
                Object[] array2 = chattingActivity.getPicMidList().toArray(new String[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                ActionManager.startPhotoViewActivityInMessage(shapedImageView, strArr, rectArr, indexOf, strArr2, (String[]) array2);
            }
        } else if (activity instanceof ChattingActivity) {
            ChattingActivity chattingActivity2 = (ChattingActivity) activity;
            if (chattingActivity2.getViewMode().isKeyBoardShow()) {
                UiUtils.closeKeyboard(chattingActivity2.getEditText());
            }
            EmotionPanel emotionPanel = chattingActivity2.getBinding().emotionPanel;
            Intrinsics.checkNotNullExpressionValue(emotionPanel, "activity.binding.emotionPanel");
            if (emotionPanel.isShown()) {
                EmotionPanel emotionPanel2 = chattingActivity2.getBinding().emotionPanel;
                Intrinsics.checkNotNullExpressionValue(emotionPanel2, "activity.binding.emotionPanel");
                chattingActivity2.setEmotionPanelVisibleWithAnim(!emotionPanel2.isShown());
                chattingActivity2.getBinding().menuEmotion.setImageResource(2131231278);
            }
        }
    }
}
