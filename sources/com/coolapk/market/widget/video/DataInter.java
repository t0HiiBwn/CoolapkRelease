package com.coolapk.market.widget.video;

import com.kk.taurus.playerbase.assist.InterEvent;
import com.kk.taurus.playerbase.assist.InterKey;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter;", "", "Action", "Event", "Key", "PrivateEvent", "ReceiverKey", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DataInter.kt */
public interface DataInter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$Event;", "Lcom/kk/taurus/playerbase/assist/InterEvent;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataInter.kt */
    public interface Event extends InterEvent {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int EVENT_ACTION_COLLECT = -123;
        public static final int EVENT_CODE_ERROR_SHOW = -111;
        public static final int EVENT_CODE_INVALID_DATA = -118;
        public static final int EVENT_CODE_REQUEST_BACK = -100;
        public static final int EVENT_CODE_REQUEST_CLOSE = -101;
        public static final int EVENT_CODE_REQUEST_NEXT = -106;
        public static final int EVENT_CODE_REQUEST_SHARE = -107;
        public static final int EVENT_CODE_REQUEST_TOGGLE_SCREEN = -104;
        public static final int EVENT_CODE_URL_REQUEST_FAIL = -119;
        public static final int EVENT_PAUSE_BY_USER = -120;
        public static final int EVENT_REQUEST_PIP_MODE = -124;
        public static final int EVENT_RESUME_BY_USER = -121;
        public static final int EVENT_VIEW_SOURCE_URL = -122;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$Event$Companion;", "", "()V", "EVENT_ACTION_COLLECT", "", "EVENT_CODE_ERROR_SHOW", "EVENT_CODE_INVALID_DATA", "EVENT_CODE_REQUEST_BACK", "EVENT_CODE_REQUEST_CLOSE", "EVENT_CODE_REQUEST_NEXT", "EVENT_CODE_REQUEST_SHARE", "EVENT_CODE_REQUEST_TOGGLE_SCREEN", "EVENT_CODE_URL_REQUEST_FAIL", "EVENT_PAUSE_BY_USER", "EVENT_REQUEST_PIP_MODE", "EVENT_RESUME_BY_USER", "EVENT_VIEW_SOURCE_URL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: DataInter.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int EVENT_ACTION_COLLECT = -123;
            public static final int EVENT_CODE_ERROR_SHOW = -111;
            public static final int EVENT_CODE_INVALID_DATA = -118;
            public static final int EVENT_CODE_REQUEST_BACK = -100;
            public static final int EVENT_CODE_REQUEST_CLOSE = -101;
            public static final int EVENT_CODE_REQUEST_NEXT = -106;
            public static final int EVENT_CODE_REQUEST_SHARE = -107;
            public static final int EVENT_CODE_REQUEST_TOGGLE_SCREEN = -104;
            public static final int EVENT_CODE_URL_REQUEST_FAIL = -119;
            public static final int EVENT_PAUSE_BY_USER = -120;
            public static final int EVENT_REQUEST_PIP_MODE = -124;
            public static final int EVENT_RESUME_BY_USER = -121;
            public static final int EVENT_VIEW_SOURCE_URL = -122;

            private Companion() {
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$Key;", "Lcom/kk/taurus/playerbase/assist/InterKey;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataInter.kt */
    public interface Key extends InterKey {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String KEY_APPLY_WINDOWS_INSETS = "apply_windows_insets";
        public static final String KEY_CAN_REDIRECT_SOURCE = "can_redirect_source";
        public static final String KEY_COMPLETE_SHOW = "complete_show";
        public static final String KEY_CONTROLLER_SCREEN_SWITCH_ENABLE = "screen_switch_enable";
        public static final String KEY_CONTROLLER_TOP_ENABLE = "controller_top_enable";
        public static final String KEY_DATA_SOURCE = "data_source";
        public static final String KEY_ERROR_SHOW = "error_show";
        public static final String KEY_HIDE_FRAME_CONTENT = "hide_frame_content";
        public static final String KEY_IGNORE_FOLLOWING_NETWORK = "ignore_following_network_event";
        public static final String KEY_IS_COLLECTED = "isCollected";
        public static final String KEY_IS_HAS_NEXT = "is_has_next";
        public static final String KEY_IS_LANDSCAPE = "isLandscape";
        public static final String KEY_IS_LIVE = "isLive";
        public static final String KEY_IS_USER_SHARED_FEED = "share_view_visible";
        public static final String KEY_LAST_ERROR_EXTRA = "last_error_extra";
        public static final String KEY_LAST_ERROR_STATE = "last_error_state";
        public static final String KEY_LOADING_SHOW = "loading_show";
        public static final String KEY_NEED_MUTE = "need_mute";
        public static final String KEY_NETWORK_RESOURCE = "network_resource";
        public static final String KEY_REST_WHEN_MOBILE_NETWORK = "reset_when_mobile_network";
        public static final String KEY_TIMER_UPDATE_ENABLE = "timer_update_enable";
        public static final String KEY_USER_CLICK_STARTED = "user_click_started";
        public static final String KEY_VIDEO_SOURCE_URL = "view_source_url";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$Key$Companion;", "", "()V", "KEY_APPLY_WINDOWS_INSETS", "", "KEY_CAN_REDIRECT_SOURCE", "KEY_COMPLETE_SHOW", "KEY_CONTROLLER_SCREEN_SWITCH_ENABLE", "KEY_CONTROLLER_TOP_ENABLE", "KEY_DATA_SOURCE", "KEY_ERROR_SHOW", "KEY_HIDE_FRAME_CONTENT", "KEY_IGNORE_FOLLOWING_NETWORK", "KEY_IS_COLLECTED", "KEY_IS_HAS_NEXT", "KEY_IS_LANDSCAPE", "KEY_IS_LIVE", "KEY_IS_USER_SHARED_FEED", "KEY_LAST_ERROR_EXTRA", "KEY_LAST_ERROR_STATE", "KEY_LOADING_SHOW", "KEY_NEED_MUTE", "KEY_NETWORK_RESOURCE", "KEY_REST_WHEN_MOBILE_NETWORK", "KEY_TIMER_UPDATE_ENABLE", "KEY_USER_CLICK_STARTED", "KEY_VIDEO_SOURCE_URL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: DataInter.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String KEY_APPLY_WINDOWS_INSETS = "apply_windows_insets";
            public static final String KEY_CAN_REDIRECT_SOURCE = "can_redirect_source";
            public static final String KEY_COMPLETE_SHOW = "complete_show";
            public static final String KEY_CONTROLLER_SCREEN_SWITCH_ENABLE = "screen_switch_enable";
            public static final String KEY_CONTROLLER_TOP_ENABLE = "controller_top_enable";
            public static final String KEY_DATA_SOURCE = "data_source";
            public static final String KEY_ERROR_SHOW = "error_show";
            public static final String KEY_HIDE_FRAME_CONTENT = "hide_frame_content";
            public static final String KEY_IGNORE_FOLLOWING_NETWORK = "ignore_following_network_event";
            public static final String KEY_IS_COLLECTED = "isCollected";
            public static final String KEY_IS_HAS_NEXT = "is_has_next";
            public static final String KEY_IS_LANDSCAPE = "isLandscape";
            public static final String KEY_IS_LIVE = "isLive";
            public static final String KEY_IS_USER_SHARED_FEED = "share_view_visible";
            public static final String KEY_LAST_ERROR_EXTRA = "last_error_extra";
            public static final String KEY_LAST_ERROR_STATE = "last_error_state";
            public static final String KEY_LOADING_SHOW = "loading_show";
            public static final String KEY_NEED_MUTE = "need_mute";
            public static final String KEY_NETWORK_RESOURCE = "network_resource";
            public static final String KEY_REST_WHEN_MOBILE_NETWORK = "reset_when_mobile_network";
            public static final String KEY_TIMER_UPDATE_ENABLE = "timer_update_enable";
            public static final String KEY_USER_CLICK_STARTED = "user_click_started";
            public static final String KEY_VIDEO_SOURCE_URL = "view_source_url";

            private Companion() {
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$ReceiverKey;", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataInter.kt */
    public interface ReceiverKey {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String KEY_COMPLETE_COVER = "complete_cover";
        public static final String KEY_CONTROLLER_COVER = "controller_cover";
        public static final String KEY_ERROR_COVER = "error_cover";
        public static final String KEY_FLOATING_COVER = "floating_cover";
        public static final String KEY_GESTURE_COVER = "gesture_cover";
        public static final String KEY_LOADING_COVER = "loading_cover";
        public static final String KEY_PROXY_COVER = "proxy_cover";
        public static final String KEY_SIMPLE_CONTROLLER_COVER = "simeple_controller_cover";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$ReceiverKey$Companion;", "", "()V", "KEY_COMPLETE_COVER", "", "KEY_CONTROLLER_COVER", "KEY_ERROR_COVER", "KEY_FLOATING_COVER", "KEY_GESTURE_COVER", "KEY_LOADING_COVER", "KEY_PROXY_COVER", "KEY_SIMPLE_CONTROLLER_COVER", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: DataInter.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String KEY_COMPLETE_COVER = "complete_cover";
            public static final String KEY_CONTROLLER_COVER = "controller_cover";
            public static final String KEY_ERROR_COVER = "error_cover";
            public static final String KEY_FLOATING_COVER = "floating_cover";
            public static final String KEY_GESTURE_COVER = "gesture_cover";
            public static final String KEY_LOADING_COVER = "loading_cover";
            public static final String KEY_PROXY_COVER = "proxy_cover";
            public static final String KEY_SIMPLE_CONTROLLER_COVER = "simeple_controller_cover";

            private Companion() {
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$PrivateEvent;", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataInter.kt */
    public interface PrivateEvent {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int EVENT_CODE_UPDATE_SEEK = -201;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$PrivateEvent$Companion;", "", "()V", "EVENT_CODE_UPDATE_SEEK", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: DataInter.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int EVENT_CODE_UPDATE_SEEK = -201;

            private Companion() {
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$Action;", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DataInter.kt */
    public interface Action {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String EVENT_SHOW_PAUSE_COVER = "show_pause_cover";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/widget/video/DataInter$Action$Companion;", "", "()V", "EVENT_SHOW_PAUSE_COVER", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: DataInter.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String EVENT_SHOW_PAUSE_COVER = "show_pause_cover";

            private Companion() {
            }
        }
    }
}
