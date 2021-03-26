package com.kk.taurus.playerbase.log;

import android.os.Bundle;

public class DebugLog {
    static final String EVENT_TAG_ERROR_EVENT = "frameEvent_error";
    static final String EVENT_TAG_PLAY_EVENT = "frameEvent_play";

    public static void onPlayEventLog(int i, Bundle bundle) {
        String str;
        if (PLog.LOG_OPEN) {
            if (i != 99020) {
                switch (i) {
                    case -99052:
                        str = "PLAYER_EVENT_ON_PROVIDER_DATA_ERROR";
                        break;
                    case -99051:
                        str = "PLAYER_EVENT_ON_PROVIDER_DATA_SUCCESS";
                        break;
                    case -99050:
                        str = "PLAYER_EVENT_ON_PROVIDER_DATA_START";
                        break;
                    default:
                        switch (i) {
                            case -99031:
                                str = "PLAYER_EVENT_ON_STATUS_CHANGE";
                                break;
                            case -99030:
                                str = "PLAYER_EVENT_ON_SUBTITLE_TIMED_OUT";
                                break;
                            case -99029:
                                str = "PLAYER_EVENT_ON_UNSUPPORTED_SUBTITLE";
                                break;
                            case -99028:
                                str = "PLAYER_EVENT_ON_TIMED_TEXT_ERROR";
                                break;
                            case -99027:
                                str = "PLAYER_EVENT_ON_METADATA_UPDATE";
                                break;
                            case -99026:
                                str = "PLAYER_EVENT_ON_NOT_SEEK_ABLE";
                                break;
                            case -99025:
                                str = "PLAYER_EVENT_ON_BAD_INTERLEAVING";
                                break;
                            case -99024:
                                str = "PLAYER_EVENT_ON_NETWORK_BANDWIDTH";
                                break;
                            case -99023:
                                str = "PLAYER_EVENT_ON_AUDIO_SEEK_RENDERING_START";
                                break;
                            case -99022:
                                str = "PLAYER_EVENT_ON_AUDIO_DECODER_START";
                                break;
                            case -99021:
                                str = "PLAYER_EVENT_ON_AUDIO_RENDER_START";
                                break;
                            default:
                                switch (i) {
                                    case -99019:
                                        str = "PLAYER_EVENT_ON_TIMER_UPDATE";
                                        break;
                                    case -99018:
                                        str = "PLAYER_EVENT_ON_PREPARED";
                                        break;
                                    case -99017:
                                        str = "PLAYER_EVENT_ON_VIDEO_SIZE_CHANGE";
                                        break;
                                    case -99016:
                                        str = "PLAYER_EVENT_ON_PLAY_COMPLETE";
                                        break;
                                    case -99015:
                                        str = "PLAYER_EVENT_ON_VIDEO_RENDER_START";
                                        break;
                                    case -99014:
                                        str = "PLAYER_EVENT_ON_SEEK_COMPLETE";
                                        break;
                                    case -99013:
                                        str = "PLAYER_EVENT_ON_SEEK_TO";
                                        break;
                                    case -99012:
                                        str = "PLAYER_EVENT_ON_BUFFERING_UPDATE";
                                        break;
                                    case -99011:
                                        str = "PLAYER_EVENT_ON_BUFFERING_END";
                                        break;
                                    case -99010:
                                        str = "PLAYER_EVENT_ON_BUFFERING_START";
                                        break;
                                    case -99009:
                                        str = "PLAYER_EVENT_ON_DESTROY";
                                        break;
                                    case -99008:
                                        str = "PLAYER_EVENT_ON_RESET";
                                        break;
                                    case -99007:
                                        str = "PLAYER_EVENT_ON_STOP";
                                        break;
                                    case -99006:
                                        str = "PLAYER_EVENT_ON_RESUME";
                                        break;
                                    case -99005:
                                        str = "PLAYER_EVENT_ON_PAUSE";
                                        break;
                                    case -99004:
                                        str = "PLAYER_EVENT_ON_START";
                                        break;
                                    case -99003:
                                        str = "PLAYER_EVENT_ON_SURFACE_UPDATE";
                                        break;
                                    case -99002:
                                        str = "PLAYER_EVENT_ON_SURFACE_HOLDER_UPDATE";
                                        break;
                                    case -99001:
                                        str = "PLAYER_EVENT_ON_DATA_SOURCE_SET";
                                        break;
                                    default:
                                        str = "UNKNOWN EVENT, maybe from provider, maybe from user custom code.";
                                        break;
                                }
                        }
                }
            } else {
                str = "PLAYER_EVENT_ON_VIDEO_ROTATION_CHANGED";
            }
            PLog.d("frameEvent_play", str);
        }
    }

    public static void onErrorEventLog(int i, Bundle bundle) {
        String str;
        if (PLog.LOG_OPEN) {
            if (i != -88000) {
                switch (i) {
                    case -88018:
                        str = "ERROR_EVENT_TIMED_OUT";
                        break;
                    case -88017:
                        str = "ERROR_EVENT_UNSUPPORTED";
                        break;
                    case -88016:
                        str = "ERROR_EVENT_MALFORMED";
                        break;
                    case -88015:
                        str = "ERROR_EVENT_IO";
                        break;
                    case -88014:
                        str = "ERROR_EVENT_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK";
                        break;
                    case -88013:
                        str = "ERROR_EVENT_SERVER_DIED";
                        break;
                    case -88012:
                        str = "ERROR_EVENT_UNKNOWN";
                        break;
                    case -88011:
                        str = "ERROR_EVENT_COMMON";
                        break;
                    default:
                        str = "unKnow code error, maybe user custom errorCode";
                        break;
                }
            } else {
                str = "ERROR_EVENT_DATA_PROVIDER_ERROR";
            }
            if (bundle != null) {
                str = str + "," + bundle.toString();
            }
            PLog.e("frameEvent_error", str);
        }
    }
}
