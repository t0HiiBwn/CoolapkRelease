package com.coolapk.market.view.live;

import android.graphics.Color;
import android.text.TextUtils;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.util.LogUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0003\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/live/CommandHelper;", "", "()V", "commandEnable", "", "commandSet", "Ljava/util/HashMap;", "", "Lcom/coolapk/market/view/live/CommandHelper$Command;", "Lkotlin/collections/HashMap;", "getCommand", "key", "getCommandColorKey", "userName", "tryToAddCommand", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "ColorNameCommand", "Command", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CommandHelper.kt */
public final class CommandHelper {
    public static final String COMMAND_COLOR_NAME = "colorname";
    public static final Companion Companion = new Companion(null);
    private boolean commandEnable;
    private final HashMap<String, Command> commandSet = new HashMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/view/live/CommandHelper$Command;", "", "()V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CommandHelper.kt */
    public static class Command {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/CommandHelper$Companion;", "", "()V", "COMMAND_COLOR_NAME", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CommandHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean tryToAddCommand(LiveMessage liveMessage) {
        Integer valueOf;
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
        if (!this.commandEnable) {
            return false;
        }
        try {
            String message = liveMessage.getMessage();
            String str = null;
            ColorNameCommand colorNameCommand = null;
            if (!TextUtils.isEmpty(message)) {
                Intrinsics.checkNotNullExpressionValue(message, "text");
                if (StringsKt.startsWith$default(message, "/", false, 2, (Object) null)) {
                    String substring = message.substring(1, message.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    List split$default = StringsKt.split$default((CharSequence) substring, new String[]{" "}, false, 0, 6, (Object) null);
                    if (!split$default.isEmpty()) {
                        String str2 = (String) split$default.get(0);
                        if (str2 != null) {
                            String lowerCase = str2.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            if (lowerCase.hashCode() == 1981694062) {
                                if (lowerCase.equals("colorname")) {
                                    String str3 = null;
                                    String str4 = null;
                                    if (split$default.size() == 2) {
                                        str3 = liveMessage.getUserName();
                                        str4 = (String) split$default.get(1);
                                    } else if (split$default.size() == 3) {
                                        str3 = (String) split$default.get(1);
                                        str4 = (String) split$default.get(2);
                                    }
                                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                                        String str5 = null;
                                        Integer num = null;
                                        try {
                                            valueOf = Integer.valueOf(Color.parseColor(str4));
                                        } catch (Exception e) {
                                            LogUtils.e("颜色代码无法解析", e);
                                            str4 = str5;
                                        }
                                        if (!(str3 == null || str3.length() >= 15 || str4 == null || valueOf == null || valueOf.intValue() == -1)) {
                                            str = getCommandColorKey(str3);
                                            colorNameCommand = new ColorNameCommand(str3, str4, valueOf.intValue());
                                        }
                                    }
                                }
                            }
                            if (!(str == null || colorNameCommand == null)) {
                                this.commandSet.put(str, colorNameCommand);
                                EventBus.getDefault().post(new LiveCommandEvent(str, colorNameCommand));
                                return true;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public final String getCommandColorKey(String str) {
        Intrinsics.checkNotNullParameter(str, "userName");
        return "colorname" + str;
    }

    public final Command getCommand(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.commandSet.get(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/live/CommandHelper$ColorNameCommand;", "Lcom/coolapk/market/view/live/CommandHelper$Command;", "userName", "", "colorHex", "colorInt", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getColorHex", "()Ljava/lang/String;", "getColorInt", "()I", "getUserName", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CommandHelper.kt */
    public static final class ColorNameCommand extends Command {
        private final String colorHex;
        private final int colorInt;
        private final String userName;

        public ColorNameCommand(String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(str, "userName");
            Intrinsics.checkNotNullParameter(str2, "colorHex");
            this.userName = str;
            this.colorHex = str2;
            this.colorInt = i;
        }

        public final String getColorHex() {
            return this.colorHex;
        }

        public final int getColorInt() {
            return this.colorInt;
        }

        public final String getUserName() {
            return this.userName;
        }
    }
}
