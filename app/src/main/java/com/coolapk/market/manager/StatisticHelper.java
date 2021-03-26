package com.coolapk.market.manager;

import android.app.Application;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Goods;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.feedv8.ArticleImage;
import com.coolapk.market.view.feedv8.ArticleModel;
import com.coolapk.market.view.feedv8.ArticleNative;
import com.coolapk.market.view.feedv8.ArticleText;
import com.coolapk.market.view.main.PageName;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 V2\u00020\u0001:\u0002VWB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J?\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00042*\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00170\u0016\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\u0010\u0018J&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0004J8\u0010\u001d\u001a\u00020\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020 J\u000e\u0010/\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u00103\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u00104\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\n2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010>\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004J\u000e\u0010D\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010E\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010H\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0004J\u001e\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020N2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010O\u001a\u00020\n2\u0006\u0010M\u001a\u00020N2\b\u0010B\u001a\u0004\u0018\u00010\u0004J2\u0010P\u001a\u00020\n2\u0006\u0010M\u001a\u00020N2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00042\b\b\u0002\u0010S\u001a\u00020TH\u0002J\f\u0010U\u001a\u0004\u0018\u00010\u0004*\u00020\u0006¨\u0006X"}, d2 = {"Lcom/coolapk/market/manager/StatisticHelper;", "", "()V", "generateMessage", "", "entity", "Lcom/coolapk/market/model/Entity;", "parentEntity", "extraMessage", "recordAnswerAction", "", "action", "recordBannerDisplayEvent", "target", "recordBottomNavigationBarChange", "pageName", "Lcom/coolapk/market/view/main/PageName;", "recordBottomNavigationBarRefresh", "recordCoolPicAction", "recordCustomKVEvent", "event", "pairs", "", "Lkotlin/Pair;", "(Ljava/lang/String;[Lkotlin/Pair;)V", "map", "", "recordDataListTabEvent", "title", "recordEntityEvent", "page", "positionInDataList", "", "recordEvent", "category", "key", "recordFeedClickAction", "recordFeedEntranceClickEvent", "from", "recordGoodsRelatedAction", "recordHomeTabEvent", "recordLoginClickEvent", "recordLoginStatusEvent", "isLogin", "", "recordMainTabEvent", "titleRes", "recordNodeClickAction", "recordOpenSwitchFollowEvent", "name", "recordOutsideFeedShareEvent", "recordPhoneBarAction", "recordPhoneBarPostEvent", "recordPhoneBarTabShowEvent", "recordPlusClickEvent", "recordPostFeedEvent", "feed", "Lcom/coolapk/market/model/Feed;", "recordPostReplyEvent", "type", "recordQuestionAction", "recordSaveDraftEvent", "recordSceneRelatedClickAction", "recordSecondHandChannelEvent", "recordSettingEvent", "recordShareFeedEvent", "feedType", "entrance", "recordShareFeedToEvent", "recordSwitchFollowEvent", "recordThemeEvent", "recordTopicAction", "recordTopicViewClick", "recordTopicViewDisplay", "recordVideoClickAction", "recordViewClickEvent", "traceCardExposedIfNeed", "viewRoot", "Landroid/view/View;", "traceFeedStayInList", "traceViewExposedEvent", "actionKey", "value", "exposedTimeMill", "", "uniqueIdForStat", "Companion", "Constants", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: StatisticHelper.kt */
public final class StatisticHelper {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_ANSWER_ACTION = "answer_action";
    public static final String EVENT_BANNER_DISPLAY = "banner_display";
    public static final String EVENT_BOTTOM_NAVIGATION = "bottom_navigate_show";
    public static final String EVENT_CARD_CLICK = "card_click2";
    public static final String EVENT_CARD_EXPOSE = "card_expose";
    public static final String EVENT_COOLPIC_ACTION = "coolpic_action";
    public static final String EVENT_DATA_LIST_TAB_SHOW = "data_list_tab_show";
    public static final String EVENT_FEED_CLICK = "feed_click";
    public static final String EVENT_FEED_ENTRANCE_CLICK = "feed_entrance_click";
    public static final String EVENT_FEED_SHOW = "feed_show";
    public static final String EVENT_GOODS_RELATED = "goods_events";
    public static final String EVENT_LOGIN_CLICK = "login_click";
    public static final String EVENT_LOGIN_STATUS = "login_status";
    public static final String EVENT_NODE_CLICK = "node_click";
    public static final String EVENT_OPEN_SWITCH_FOLLOW = "open_switch_follow";
    public static final String EVENT_OTHER = "others";
    public static final String EVENT_OUTSIDE_FEED_SHARE = "outside_feed_share";
    public static final String EVENT_PHONE_BAR_ACTION = "phone_bar_action";
    public static final String EVENT_PHONE_BAR_POST = "phone_bar_post";
    public static final String EVENT_PHONE_BAR_TAB = "phone_bar_tab";
    public static final String EVENT_PLUS_CLICK = "plus_click";
    public static final String EVENT_POST_FEED = "post_feed";
    public static final String EVENT_POST_REPLY = "post_reply";
    public static final String EVENT_QUESTION_ACTION = "question_action";
    public static final String EVENT_SAVE_DRAFT = "save_draft";
    public static final String EVENT_SCENE_RELATED_CLICK = "scene_related_click";
    public static final String EVENT_SECOND_HAND = "ershou_channel_action";
    public static final String EVENT_SETTING_EVENT = "setting_event";
    public static final String EVENT_SHARE_FEED = "share_feed";
    public static final String EVENT_SHARE_FEED_TO = "share_feed_to";
    public static final String EVENT_SWITCH_FOLLOW_TO = "switch_follow_to";
    public static final String EVENT_TAB_SHOW = "tab_show";
    public static final String EVENT_THEME = "theme";
    public static final String EVENT_TOPIC_ACTION = "topic_action";
    public static final String EVENT_TOPIC_CLICK = "topic_view_click";
    public static final String EVENT_TOPIC_DISPLAY = "topic_view_display";
    public static final String EVENT_VIDEO_CLICK = "video_click";
    public static final String EVENT_VIEW_CLICK = "view_click";
    public static final String KEY_BOTTOM_NAVIGATION_PAGE = "page";
    public static final String KEY_CARD_CLICK_TARGET = "target";
    public static final String KEY_DATA_LIST_TAB_SHOW_PAGE = "data_list_tab_page";
    public static final String KEY_FEED_ENTRANCE_CLICK_NAME = "name";
    public static final String KEY_FEED_SHOW_TYPE = "type";
    public static final String KEY_LOGIN_CLICK_FROM = "from";
    public static final String KEY_LOGIN_STATUS_STATUS = "status";
    public static final String KEY_OPEN_SWITCH_FOLLOW_ACTION = "action";
    public static final String KEY_OTHER_TARGET = "target";
    public static final String KEY_OUTSIDE_FEED_SHARE_TO = "target";
    public static final String KEY_PLUS_CLICK_ACTION = "action";
    public static final String KEY_POST_FEED_FEED_TYPE = "feed_type";
    public static final String KEY_POST_FEED_WORD_COUNT = "word_count";
    public static final String KEY_POST_REPLY_REPLY_TYPE = "reply_type";
    public static final String KEY_POST_TYPE = "post_type";
    public static final String KEY_SAVE_DRAFT_NAME = "name";
    public static final String KEY_SECOND_HAND_ACTION = "action";
    public static final String KEY_SETTING_EVENT_RESULT = "result";
    public static final String KEY_SHARE_FEED_ENTRANCE_TYPE = "entrance_type";
    public static final String KEY_SHARE_FEED_FEED_TYPE = "feed_type";
    public static final String KEY_SHARE_FEED_TO_TARGET = "target";
    public static final String KEY_SWITCH_FOLLOW_TO_NAME = "name";
    public static final String KEY_TAB_SHOW_PAGE = "tab_page";
    public static final String KEY_THEME_NAME = "name";
    public static final String KEY_VIEW_CLICK_NAME = "name";
    private static final StatisticHelper instance = new StatisticHelper();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PageName.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PageName.HOME.ordinal()] = 1;
            iArr[PageName.CENTER.ordinal()] = 2;
            iArr[PageName.DISCOVERY.ordinal()] = 3;
            iArr[PageName.APP_AND_GAME.ordinal()] = 4;
            iArr[PageName.MOBILE_BAR.ordinal()] = 5;
        }
    }

    public static final StatisticHelper getInstance() {
        return instance;
    }

    private StatisticHelper() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u00020D8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010\u0002\u001a\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/coolapk/market/manager/StatisticHelper$Companion;", "", "()V", "EVENT_ANSWER_ACTION", "", "EVENT_BANNER_DISPLAY", "EVENT_BOTTOM_NAVIGATION", "EVENT_CARD_CLICK", "EVENT_CARD_EXPOSE", "EVENT_COOLPIC_ACTION", "EVENT_DATA_LIST_TAB_SHOW", "EVENT_FEED_CLICK", "EVENT_FEED_ENTRANCE_CLICK", "EVENT_FEED_SHOW", "EVENT_GOODS_RELATED", "EVENT_LOGIN_CLICK", "EVENT_LOGIN_STATUS", "EVENT_NODE_CLICK", "EVENT_OPEN_SWITCH_FOLLOW", "EVENT_OTHER", "EVENT_OUTSIDE_FEED_SHARE", "EVENT_PHONE_BAR_ACTION", "EVENT_PHONE_BAR_POST", "EVENT_PHONE_BAR_TAB", "EVENT_PLUS_CLICK", "EVENT_POST_FEED", "EVENT_POST_REPLY", "EVENT_QUESTION_ACTION", "EVENT_SAVE_DRAFT", "EVENT_SCENE_RELATED_CLICK", "EVENT_SECOND_HAND", "EVENT_SETTING_EVENT", "EVENT_SHARE_FEED", "EVENT_SHARE_FEED_TO", "EVENT_SWITCH_FOLLOW_TO", "EVENT_TAB_SHOW", "EVENT_THEME", "EVENT_TOPIC_ACTION", "EVENT_TOPIC_CLICK", "EVENT_TOPIC_DISPLAY", "EVENT_VIDEO_CLICK", "EVENT_VIEW_CLICK", "KEY_BOTTOM_NAVIGATION_PAGE", "KEY_CARD_CLICK_TARGET", "KEY_DATA_LIST_TAB_SHOW_PAGE", "KEY_FEED_ENTRANCE_CLICK_NAME", "KEY_FEED_SHOW_TYPE", "KEY_LOGIN_CLICK_FROM", "KEY_LOGIN_STATUS_STATUS", "KEY_OPEN_SWITCH_FOLLOW_ACTION", "KEY_OTHER_TARGET", "KEY_OUTSIDE_FEED_SHARE_TO", "KEY_PLUS_CLICK_ACTION", "KEY_POST_FEED_FEED_TYPE", "KEY_POST_FEED_WORD_COUNT", "KEY_POST_REPLY_REPLY_TYPE", "KEY_POST_TYPE", "KEY_SAVE_DRAFT_NAME", "KEY_SECOND_HAND_ACTION", "KEY_SETTING_EVENT_RESULT", "KEY_SHARE_FEED_ENTRANCE_TYPE", "KEY_SHARE_FEED_FEED_TYPE", "KEY_SHARE_FEED_TO_TARGET", "KEY_SWITCH_FOLLOW_TO_NAME", "KEY_TAB_SHOW_PAGE", "KEY_THEME_NAME", "KEY_VIEW_CLICK_NAME", "instance", "Lcom/coolapk/market/manager/StatisticHelper;", "getInstance$annotations", "getInstance", "()Lcom/coolapk/market/manager/StatisticHelper;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: StatisticHelper.kt */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatisticHelper getInstance() {
            return StatisticHelper.instance;
        }
    }

    public final void recordCustomKVEvent(String str, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        recordCustomKVEvent(str, MapsKt.toMap(pairArr));
    }

    private final void recordCustomKVEvent(String str, Map<String, ? extends Object> map) {
        AppHolder.getThirdStatUtils().recordCustomKVEvent(str, map);
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isAdmin() && AppHolder.getAppSetting().getBooleanPref("statistic_toast")) {
            Application application = AppHolder.getApplication();
            Toast.show$default(application, str + ' ' + map, 0, false, 12, null);
        }
        LogUtils.d("recordCustomEvent " + str + ' ' + map, new Object[0]);
    }

    public final void recordEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str2, "key");
        recordCustomKVEvent("others", TuplesKt.to("target", str + '_' + str2));
    }

    public final void recordSettingEvent(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "key");
        String str3 = null;
        AppSetting appSetting = AppHolder.getAppSetting();
        switch (str.hashCode()) {
            case -2099757294:
                if (str.equals("last_weekly_no_ad_splash_time")) {
                    if (DataManager.getInstance().getPreferencesLong(str, 0) > 0) {
                        str3 = "7天免广告启用";
                        break;
                    }
                }
                break;
            case -2099296341:
                if (str.equals("APP_MAIN_MODE_KEY")) {
                    str2 = Intrinsics.areEqual(DataManager.getInstance().getPreferencesString(str, "SOCIAL"), "SOCIAL") ? "首页" : "应用游戏";
                    str3 = str2;
                    break;
                }
                break;
            case -1887959918:
                if (str.equals("push_service_enabled")) {
                    str2 = appSetting.getBooleanPref(str) ? "接受推送" : "不接受推送";
                    str3 = str2;
                    break;
                }
                break;
            case -1822585659:
                if (str.equals("auto_switch_night_mode")) {
                    str2 = appSetting.getBooleanPref(str) ? "自动切换夜间" : "不自动切换夜间";
                    str3 = str2;
                    break;
                }
                break;
            case -1453740702:
                if (str.equals("check_beta_version_enabled")) {
                    str2 = appSetting.getBooleanPref(str) ? "检测beta更新" : "不检测beta更新";
                    str3 = str2;
                    break;
                }
                break;
            case -1442637777:
                if (str.equals("use_internal_webview")) {
                    str2 = appSetting.getBooleanPref(str) ? "使用内置浏览器" : "不使用内置浏览器";
                    str3 = str2;
                    break;
                }
                break;
            case -1141626970:
                if (str.equals("use_channel_center_beta")) {
                    str2 = appSetting.getBooleanPref(str) ? "使用微发现" : "正常发现频道";
                    str3 = str2;
                    break;
                }
                break;
            case -1134679708:
                if (str.equals("app_header_search_background_transparent")) {
                    str2 = appSetting.getBooleanPref(str) ? "搜索背景透明" : "搜索背景不透明";
                    str3 = str2;
                    break;
                }
                break;
            case -969993349:
                if (str.equals("auto_hide_bottom_navigation")) {
                    str2 = appSetting.getBooleanPref(str) ? "自动隐藏底栏" : "不自动隐藏底栏";
                    str3 = str2;
                    break;
                }
                break;
            case 266738532:
                if (str.equals("set_night_mode_to_pure_black")) {
                    str2 = appSetting.getBooleanPref(str) ? "A屏黑作为夜间模式" : "夜间黑作为夜间模式";
                    str3 = str2;
                    break;
                }
                break;
            case 919093747:
                if (str.equals("show_fast_return_view")) {
                    str2 = appSetting.getBooleanPref(str) ? "显示快速返回" : "隐藏快速返回";
                    str3 = str2;
                    break;
                }
                break;
        }
        if (str3 != null) {
            recordCustomKVEvent("setting_event", TuplesKt.to("result", str3));
        }
    }

    public final void recordHomeTabEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        recordCustomKVEvent("tab_show", TuplesKt.to("tab_page", str));
    }

    public final void recordDataListTabEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        recordCustomKVEvent("data_list_tab_show", TuplesKt.to("data_list_tab_page", str));
    }

    public final void recordOutsideFeedShareEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        recordCustomKVEvent("outside_feed_share", TuplesKt.to("target", str));
    }

    public final void recordMainTabEvent(int i) {
        String str;
        switch (i) {
            case 2131887220:
                str = "应用集";
                break;
            case 2131887228:
                str = "应用";
                break;
            case 2131887236:
                str = "精选";
                break;
            case 2131887262:
                str = "游戏";
                break;
            case 2131887294:
                str = "排行";
                break;
            default:
                str = "";
                break;
        }
        if (str.length() > 0) {
            recordCustomKVEvent("tab_show", TuplesKt.to("tab_page", str));
        }
    }

    public final void recordBottomNavigationBarChange(PageName pageName) {
        String str;
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        int i = WhenMappings.$EnumSwitchMapping$0[pageName.ordinal()];
        if (i == 1) {
            str = "首页";
        } else if (i == 2) {
            str = "我";
        } else if (i == 3) {
            str = "发现";
        } else if (i == 4) {
            str = "应用游戏";
        } else if (i == 5) {
            str = "数码吧";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (str.length() > 0) {
            recordCustomKVEvent("bottom_navigate_show", TuplesKt.to("page", str));
        }
    }

    public final void recordBottomNavigationBarRefresh() {
        recordCustomKVEvent("bottom_navigate_show", TuplesKt.to("page", "刷新"));
    }

    public final void recordLoginClickEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "from");
        recordCustomKVEvent("login_click", TuplesKt.to("from", str));
    }

    public final void recordLoginStatusEvent(boolean z) {
        recordCustomKVEvent("login_status", TuplesKt.to("status", z ? "log_in" : "login_out"));
    }

    public final void recordShareFeedEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "feedType");
        Intrinsics.checkNotNullParameter(str2, "entrance");
        recordCustomKVEvent("share_feed", TuplesKt.to("feed_type", str), TuplesKt.to("entrance_type", str2));
    }

    public final void recordViewClickEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        recordCustomKVEvent("view_click", TuplesKt.to("name", str));
    }

    public final void recordPostFeedEvent(Feed feed) {
        String str;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (feed.getIsHtmlArticle() != 1 || !Intrinsics.areEqual(feed.getFeedType(), "rating")) {
            str = feed.getFeedTypeName();
            if (str == null) {
                str = feed.getFeedType();
            }
        } else {
            str = "图文点评";
        }
        try {
            if (feed.getIsHtmlArticle() == 1) {
                ArticleModel.Companion companion = ArticleModel.Companion;
                String messageRawOutput = feed.getMessageRawOutput();
                if (messageRawOutput == null) {
                    messageRawOutput = "";
                }
                List<ArticleModel> fromJson = companion.fromJson(messageRawOutput);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fromJson, 10));
                for (T t : fromJson) {
                    if (t instanceof ArticleText) {
                        i2 = t.getText().length();
                    } else if (t instanceof ArticleImage) {
                        i2 = t.getText().length();
                    } else {
                        i2 = t instanceof ArticleNative ? t.getText().length() : 0;
                    }
                    arrayList.add(Integer.valueOf(i2));
                }
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    Object next = it2.next();
                    while (it2.hasNext()) {
                        next = Integer.valueOf(((Number) next).intValue() + ((Number) it2.next()).intValue());
                    }
                    i = ((Number) next).intValue();
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            } else {
                String message = feed.getMessage();
                Intrinsics.checkNotNullExpressionValue(message, "feed.message");
                i = message.length();
            }
            recordCustomKVEvent("post_feed", TuplesKt.to("feed_type", str), TuplesKt.to("word_count", Integer.valueOf(i)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void recordPostReplyEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        recordCustomKVEvent("post_reply", TuplesKt.to("reply_type", str));
    }

    public final void recordSecondHandChannelEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("ershou_channel_action", TuplesKt.to("action", str));
    }

    public final void recordPhoneBarPostEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("phone_bar_post", TuplesKt.to("post_type", str));
    }

    public final void recordPhoneBarTabShowEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("phone_bar_tab", TuplesKt.to("tab_page", str));
    }

    public final void recordSaveDraftEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "from");
        recordCustomKVEvent("save_draft", TuplesKt.to("name", str));
    }

    public final void recordPlusClickEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "from");
        recordCustomKVEvent("plus_click", TuplesKt.to("action", str));
    }

    public final void recordFeedEntranceClickEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "from");
        recordCustomKVEvent("feed_entrance_click", TuplesKt.to("name", str));
    }

    public final void recordThemeEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        recordCustomKVEvent("theme", TuplesKt.to("name", str));
    }

    public final void recordSwitchFollowEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        recordCustomKVEvent("switch_follow_to", TuplesKt.to("name", str));
    }

    public final void recordOpenSwitchFollowEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        recordCustomKVEvent("open_switch_follow", TuplesKt.to("action", str));
    }

    public final void recordShareFeedToEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        recordCustomKVEvent("share_feed_to", TuplesKt.to("target", str));
    }

    public final void recordQuestionAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("question_action", TuplesKt.to("action", str));
    }

    public final void recordAnswerAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("answer_action", TuplesKt.to("action", str));
    }

    public final void recordPhoneBarAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("phone_bar_action", TuplesKt.to("action", str));
    }

    public final void recordVideoClickAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("video_click", TuplesKt.to("action", str));
    }

    public final void recordFeedClickAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("feed_click", TuplesKt.to("feed_type", str));
    }

    public final void recordNodeClickAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("node_click", TuplesKt.to("action", str));
    }

    public final void recordTopicAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("topic_action", TuplesKt.to("action", str));
    }

    public final void recordSceneRelatedClickAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("scene_related_click", TuplesKt.to("action", str));
    }

    public final void recordBannerDisplayEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        recordCustomKVEvent("banner_display", TuplesKt.to("target", str));
    }

    public final void recordTopicViewClick(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        recordCustomKVEvent("topic_view_click", TuplesKt.to("target", str));
    }

    public final void recordTopicViewDisplay(String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        recordCustomKVEvent("topic_view_display", TuplesKt.to("target", str));
    }

    public final void recordGoodsRelatedAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("goods_events", TuplesKt.to("action", str));
    }

    public final void recordCoolPicAction(String str) {
        Intrinsics.checkNotNullParameter(str, "action");
        recordCustomKVEvent("coolpic_action", TuplesKt.to("action", str));
    }

    public static /* synthetic */ void recordEntityEvent$default(StatisticHelper statisticHelper, String str, Entity entity, int i, Entity entity2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "OTHER";
        }
        if ((i2 & 8) != 0) {
            entity2 = null;
        }
        if ((i2 & 16) != 0) {
            str2 = "";
        }
        statisticHelper.recordEntityEvent(str, entity, i, entity2, str2);
    }

    public final void recordEntityEvent(String str, Entity entity, int i, Entity entity2, String str2) {
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(str2, "extraMessage");
        String stringExtraDataOrNull = EntityExtendsKt.getStringExtraDataOrNull(entity, "cardStatName");
        if (stringExtraDataOrNull == null) {
            stringExtraDataOrNull = entity2 != null ? EntityExtendsKt.getStringExtraDataOrNull(entity2, "cardStatName") : null;
        }
        String str5 = "card_click2";
        if (stringExtraDataOrNull != null) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) stringExtraDataOrNull, "/", 0, false, 6, (Object) null);
            if (indexOf$default > 0) {
                StringBuilder sb = new StringBuilder();
                String substring = stringExtraDataOrNull.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append("_");
                sb.append(str5);
                str5 = sb.toString();
                stringExtraDataOrNull = stringExtraDataOrNull.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(stringExtraDataOrNull, "(this as java.lang.String).substring(startIndex)");
            }
            recordCustomKVEvent(str5, TuplesKt.to("target", stringExtraDataOrNull));
        } else if (i < 10 || entity2 != null || !(!Intrinsics.areEqual(entity.getEntityType(), "card"))) {
            String str6 = str != null ? str : "OTHER";
            if (entity2 != null) {
                str3 = EntityExtendsKt.uniqueType(entity2) + '.' + EntityExtendsKt.uniqueType(entity);
            } else {
                str3 = EntityExtendsKt.uniqueType(entity);
            }
            if (entity2 != null) {
                str4 = uniqueIdForStat(entity2) + '.' + uniqueIdForStat(entity);
            } else {
                str4 = uniqueIdForStat(entity);
            }
            recordCustomKVEvent(str5, TuplesKt.to("target", str6 + '_' + str3 + '_' + str4 + '_' + generateMessage(entity, entity2, str2)));
        }
    }

    static /* synthetic */ void traceViewExposedEvent$default(StatisticHelper statisticHelper, View view, String str, String str2, String str3, long j, int i, Object obj) {
        if ((i & 16) != 0) {
            j = 500;
        }
        statisticHelper.traceViewExposedEvent(view, str, str2, str3, j);
    }

    /* access modifiers changed from: private */
    public final void traceViewExposedEvent(View view, String str, String str2, String str3, long j) {
        Object tag = view.getTag(2131363431);
        if (tag instanceof Runnable) {
            view.removeCallbacks((Runnable) tag);
            view.setTag(2131363431, null);
        }
        if (view.isAttachedToWindow()) {
            Runnable statisticHelper$traceViewExposedEvent$recordFeedRunnable$1 = new StatisticHelper$traceViewExposedEvent$recordFeedRunnable$1(this, str, str2, str3, view, 2131363431);
            view.postDelayed(statisticHelper$traceViewExposedEvent$recordFeedRunnable$1, j);
            view.setTag(2131363431, statisticHelper$traceViewExposedEvent$recordFeedRunnable$1);
            if (!ViewCompat.isAttachedToWindow(view)) {
                view.removeCallbacks(statisticHelper$traceViewExposedEvent$recordFeedRunnable$1);
                view.setTag(2131363431, null);
                return;
            }
            view.addOnAttachStateChangeListener(new StatisticHelper$traceViewExposedEvent$$inlined$doOnDetach$1(view, view, statisticHelper$traceViewExposedEvent$recordFeedRunnable$1, 2131363431));
        } else if (ViewCompat.isAttachedToWindow(view)) {
            traceViewExposedEvent(view, str, str2, str3, j);
        } else {
            view.addOnAttachStateChangeListener(new StatisticHelper$traceViewExposedEvent$$inlined$doOnAttach$1(view, this, view, str, str2, str3, j));
        }
    }

    public final void traceFeedStayInList(View view, String str) {
        Intrinsics.checkNotNullParameter(view, "viewRoot");
        if (str == null) {
            str = "其他";
        }
        traceViewExposedEvent$default(this, view, "feed_show", "type", str, 0, 16, null);
    }

    public final void traceCardExposedIfNeed(View view, Entity entity, String str) {
        Intrinsics.checkNotNullParameter(view, "viewRoot");
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(str, "pageName");
        String stringExtraDataOrNull = EntityExtendsKt.getStringExtraDataOrNull(entity, "cardStatName");
        if (stringExtraDataOrNull != null) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) stringExtraDataOrNull, "/", 0, false, 6, (Object) null);
            String str2 = "card_expose";
            if (indexOf$default > 0) {
                StringBuilder sb = new StringBuilder();
                String substring = stringExtraDataOrNull.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append("_");
                sb.append(str2);
                str2 = sb.toString();
                stringExtraDataOrNull = stringExtraDataOrNull.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(stringExtraDataOrNull, "(this as java.lang.String).substring(startIndex)");
            }
            traceViewExposedEvent$default(this, view, str2, "target", stringExtraDataOrNull, 0, 16, null);
        } else if (!(!Intrinsics.areEqual(entity.getEntityType(), "card"))) {
            String uniqueType = EntityExtendsKt.uniqueType(entity);
            String uniqueIdForStat = uniqueIdForStat(entity);
            String generateMessage$default = generateMessage$default(this, entity, null, null, 4, null);
            traceViewExposedEvent$default(this, view, "card_expose", "target", str + '_' + uniqueType + '_' + uniqueIdForStat + '_' + generateMessage$default, 0, 16, null);
        }
    }

    static /* synthetic */ String generateMessage$default(StatisticHelper statisticHelper, Entity entity, Entity entity2, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            entity2 = null;
        }
        if ((i & 4) != 0) {
            str = "";
        }
        return statisticHelper.generateMessage(entity, entity2, str);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r9.equals("appForum") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r9.equals("albumExpandCard") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r9.equals("feed_reply") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r9.equals("topic") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r9.equals("album") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r9.equals("user") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        if (r9.equals("feed") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
        if (r9.equals("dyh") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        if (r9.equals("apk") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009b, code lost:
        if (r9.equals("discovery") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d3, code lost:
        if (r9.equals("contacts") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00dc, code lost:
        if (r9.equals("article") != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e5, code lost:
        if (r9.equals("imageSquare") != false) goto L_0x0106;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ff  */
    private final String generateMessage(Entity entity, Entity entity2, String str) {
        String title;
        StringBuilder sb = new StringBuilder();
        String str2 = null;
        boolean z = true;
        if (entity2 != null) {
            String title2 = entity2.getTitle();
            String limitLength = title2 != null ? KotlinExtendKt.limitLength(title2, 10) : null;
            String str3 = limitLength;
            if (!(str3 == null || str3.length() == 0)) {
                sb.append(limitLength);
            }
        }
        String uniqueType = EntityExtendsKt.uniqueType(entity);
        switch (uniqueType.hashCode()) {
            case -2122301864:
                break;
            case -732377866:
                break;
            case -567451565:
                break;
            case -235559235:
                if (uniqueType.equals("pear_goods")) {
                    if (sb.length() > 0) {
                        sb.append("_");
                    }
                    Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.Goods");
                    String goodsTitle = ((Goods) entity).getGoodsTitle();
                    if (goodsTitle != null) {
                        str2 = KotlinExtendKt.limitLength(goodsTitle, 10);
                    }
                    sb.append(str2);
                    break;
                }
                if (sb.length() <= 0) {
                    sb.append("_");
                }
                title = entity.getTitle();
                if (title != null) {
                    str2 = KotlinExtendKt.limitLength(title, 10);
                }
                sb.append(str2);
                break;
            case -121207376:
                break;
            case 96796:
                break;
            case 99955:
                break;
            case 3138974:
                break;
            case 3599307:
                break;
            case 92896879:
                break;
            case 110546223:
                break;
            case 580594953:
                break;
            case 610487449:
                break;
            case 1144606592:
                break;
            default:
                if (sb.length() <= 0) {
                }
                title = entity.getTitle();
                if (title != null) {
                }
                sb.append(str2);
                break;
        }
        if (str.length() <= 0) {
            z = false;
        }
        if (z) {
            sb.append("_");
            sb.append(str);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    public final String uniqueIdForStat(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "$this$uniqueIdForStat");
        String entityId = entity.getEntityId();
        return entityId != null ? entityId : entity.getId();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/manager/StatisticHelper$Constants;", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: StatisticHelper.kt */
    public interface Constants {
        public static final String CATEGORY_CIRCLE_TOP_NAVI = "V9圈子头部";
        public static final String CATEGORY_ENTITY_CARD = "V9页面Card";
        public static final String CATEGORY_FEED_ENTRANCE_NAVI = "V9动态入口";
        public static final String CATEGORY_HOME_NAVI = "V9首页导航页";
        public static final String CATEGORY_MAIN_ACTIVITY = "V9主界面";
        public static final String CATEGORY_SEARCH = "V9新搜索界面";
        public static final String CATEGORY_SEARCH_ACTIVITY = "V9搜索界面";
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String KEY_BOTTOM_NEW_FEED_BUTTON = "动态入口";
        public static final String KEY_CATEGORY_SEARCH_PREFIX = "搜索分类";
        public static final String KEY_SWITCH = "换一换";
        public static final String KEY_TOP_APP_MANAGER_BUTTON = "应用管理";
        public static final String KEY_TOP_NOTIFICATION_BUTTON = "通知";
        public static final String KEY_TOP_SEARCH_BAR = "搜索条";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/manager/StatisticHelper$Constants$Companion;", "", "()V", "CATEGORY_CIRCLE_TOP_NAVI", "", "CATEGORY_ENTITY_CARD", "CATEGORY_FEED_ENTRANCE_NAVI", "CATEGORY_HOME_NAVI", "CATEGORY_MAIN_ACTIVITY", "CATEGORY_SEARCH", "CATEGORY_SEARCH_ACTIVITY", "KEY_BOTTOM_NEW_FEED_BUTTON", "KEY_CATEGORY_SEARCH_PREFIX", "KEY_SWITCH", "KEY_TOP_APP_MANAGER_BUTTON", "KEY_TOP_NOTIFICATION_BUTTON", "KEY_TOP_SEARCH_BAR", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: StatisticHelper.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String CATEGORY_CIRCLE_TOP_NAVI = "V9圈子头部";
            public static final String CATEGORY_ENTITY_CARD = "V9页面Card";
            public static final String CATEGORY_FEED_ENTRANCE_NAVI = "V9动态入口";
            public static final String CATEGORY_HOME_NAVI = "V9首页导航页";
            public static final String CATEGORY_MAIN_ACTIVITY = "V9主界面";
            public static final String CATEGORY_SEARCH = "V9新搜索界面";
            public static final String CATEGORY_SEARCH_ACTIVITY = "V9搜索界面";
            public static final String KEY_BOTTOM_NEW_FEED_BUTTON = "动态入口";
            public static final String KEY_CATEGORY_SEARCH_PREFIX = "搜索分类";
            public static final String KEY_SWITCH = "换一换";
            public static final String KEY_TOP_APP_MANAGER_BUTTON = "应用管理";
            public static final String KEY_TOP_NOTIFICATION_BUTTON = "通知";
            public static final String KEY_TOP_SEARCH_BAR = "搜索条";

            private Companion() {
            }
        }
    }
}
