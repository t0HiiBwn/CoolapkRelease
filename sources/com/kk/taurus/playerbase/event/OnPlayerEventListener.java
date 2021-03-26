package com.kk.taurus.playerbase.event;

import android.os.Bundle;

public interface OnPlayerEventListener {
    public static final int PLAYER_EVENT_ON_AUDIO_DECODER_START = -99022;
    public static final int PLAYER_EVENT_ON_AUDIO_RENDER_START = -99021;
    public static final int PLAYER_EVENT_ON_AUDIO_SEEK_RENDERING_START = -99023;
    public static final int PLAYER_EVENT_ON_BAD_INTERLEAVING = -99025;
    public static final int PLAYER_EVENT_ON_BUFFERING_END = -99011;
    public static final int PLAYER_EVENT_ON_BUFFERING_START = -99010;
    @Deprecated
    public static final int PLAYER_EVENT_ON_BUFFERING_UPDATE = -99012;
    public static final int PLAYER_EVENT_ON_DATA_SOURCE_SET = -99001;
    public static final int PLAYER_EVENT_ON_DESTROY = -99009;
    public static final int PLAYER_EVENT_ON_METADATA_UPDATE = -99027;
    public static final int PLAYER_EVENT_ON_NETWORK_BANDWIDTH = -99024;
    public static final int PLAYER_EVENT_ON_NOT_SEEK_ABLE = -99026;
    public static final int PLAYER_EVENT_ON_PAUSE = -99005;
    public static final int PLAYER_EVENT_ON_PLAY_COMPLETE = -99016;
    public static final int PLAYER_EVENT_ON_PREPARED = -99018;
    public static final int PLAYER_EVENT_ON_PROVIDER_DATA_ERROR = -99052;
    public static final int PLAYER_EVENT_ON_PROVIDER_DATA_START = -99050;
    public static final int PLAYER_EVENT_ON_PROVIDER_DATA_SUCCESS = -99051;
    public static final int PLAYER_EVENT_ON_RESET = -99008;
    public static final int PLAYER_EVENT_ON_RESUME = -99006;
    public static final int PLAYER_EVENT_ON_SEEK_COMPLETE = -99014;
    public static final int PLAYER_EVENT_ON_SEEK_TO = -99013;
    public static final int PLAYER_EVENT_ON_START = -99004;
    public static final int PLAYER_EVENT_ON_STATUS_CHANGE = -99031;
    public static final int PLAYER_EVENT_ON_STOP = -99007;
    public static final int PLAYER_EVENT_ON_SUBTITLE_TIMED_OUT = -99030;
    public static final int PLAYER_EVENT_ON_SURFACE_HOLDER_UPDATE = -99002;
    public static final int PLAYER_EVENT_ON_SURFACE_UPDATE = -99003;
    public static final int PLAYER_EVENT_ON_TIMED_TEXT_ERROR = -99028;
    public static final int PLAYER_EVENT_ON_TIMER_UPDATE = -99019;
    public static final int PLAYER_EVENT_ON_UNSUPPORTED_SUBTITLE = -99029;
    public static final int PLAYER_EVENT_ON_VIDEO_RENDER_START = -99015;
    public static final int PLAYER_EVENT_ON_VIDEO_ROTATION_CHANGED = 99020;
    public static final int PLAYER_EVENT_ON_VIDEO_SIZE_CHANGE = -99017;

    void onPlayerEvent(int i, Bundle bundle);
}
