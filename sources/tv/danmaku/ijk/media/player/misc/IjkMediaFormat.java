package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class IjkMediaFormat implements IMediaFormat {
    public static final String CODEC_NAME_H264 = "h264";
    public static final String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
    public static final String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
    public static final String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
    public static final String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
    public static final String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
    public static final String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
    public static final String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
    public static final String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
    public static final String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
    private static final Map<String, Formatter> sFormatterMap = new HashMap();
    public final IjkMediaMeta.IjkStreamMeta mMediaFormat;

    public IjkMediaFormat(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        Map<String, Formatter> map = sFormatterMap;
        map.put("ijk-codec-long-name-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass1 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                return IjkMediaFormat.this.mMediaFormat.getString("codec_long_name");
            }
        });
        map.put("ijk-codec-name-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass2 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            public String doFormat(IjkMediaFormat ijkMediaFormat) {
                return IjkMediaFormat.this.mMediaFormat.getString("codec_name");
            }
        });
        map.put("ijk-bit-rate-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass3 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("bitrate");
                if (integer <= 0) {
                    return null;
                }
                if (integer < 1000) {
                    return String.format(Locale.US, "%d bit/s", Integer.valueOf(integer));
                }
                return String.format(Locale.US, "%d kb/s", Integer.valueOf(integer / 1000));
            }
        });
        map.put("ijk-profile-level-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass4 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                String str;
                switch (ijkMediaFormat.getInteger("codec_profile_id")) {
                    case 44:
                        str = "CAVLC 4:4:4";
                        break;
                    case 66:
                        str = "Baseline";
                        break;
                    case 77:
                        str = "Main";
                        break;
                    case 88:
                        str = "Extended";
                        break;
                    case 100:
                        str = "High";
                        break;
                    case 110:
                        str = "High 10";
                        break;
                    case 122:
                        str = "High 4:2:2";
                        break;
                    case 144:
                        str = "High 4:4:4";
                        break;
                    case 244:
                        str = "High 4:4:4 Predictive";
                        break;
                    case 578:
                        str = "Constrained Baseline";
                        break;
                    case 2158:
                        str = "High 10 Intra";
                        break;
                    case 2170:
                        str = "High 4:2:2 Intra";
                        break;
                    case 2292:
                        str = "High 4:4:4 Intra";
                        break;
                    default:
                        return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                String string = ijkMediaFormat.getString("codec_name");
                if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase("h264")) {
                    int integer = ijkMediaFormat.getInteger("codec_level");
                    if (integer < 10) {
                        return sb.toString();
                    }
                    sb.append(" Profile Level ");
                    sb.append((integer / 10) % 10);
                    int i = integer % 10;
                    if (i != 0) {
                        sb.append(".");
                        sb.append(i);
                    }
                }
                return sb.toString();
            }
        });
        map.put("ijk-pixel-format-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass5 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                return ijkMediaFormat.getString("codec_pixel_format");
            }
        });
        map.put("ijk-resolution-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass6 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("width");
                int integer2 = ijkMediaFormat.getInteger("height");
                int integer3 = ijkMediaFormat.getInteger("sar_num");
                int integer4 = ijkMediaFormat.getInteger("sar_den");
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                if (integer3 <= 0 || integer4 <= 0) {
                    return String.format(Locale.US, "%d x %d", Integer.valueOf(integer), Integer.valueOf(integer2));
                }
                return String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(integer3), Integer.valueOf(integer4));
            }
        });
        map.put("ijk-frame-rate-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass7 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("fps_num");
                int integer2 = ijkMediaFormat.getInteger("fps_den");
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return String.valueOf(((float) integer) / ((float) integer2));
            }
        });
        map.put("ijk-sample-rate-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass8 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("sample_rate");
                if (integer <= 0) {
                    return null;
                }
                return String.format(Locale.US, "%d Hz", Integer.valueOf(integer));
            }
        });
        map.put("ijk-channel-ui", new Formatter() {
            /* class tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass9 */

            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected String doFormat(IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("channel_layout");
                if (integer <= 0) {
                    return null;
                }
                long j = (long) integer;
                if (j == 4) {
                    return "mono";
                }
                if (j == 3) {
                    return "stereo";
                }
                return String.format(Locale.US, "%x", Integer.valueOf(integer));
            }
        });
        this.mMediaFormat = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public int getInteger(String str) {
        IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mMediaFormat;
        if (ijkStreamMeta == null) {
            return 0;
        }
        return ijkStreamMeta.getInt(str);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public String getString(String str) {
        if (this.mMediaFormat == null) {
            return null;
        }
        Map<String, Formatter> map = sFormatterMap;
        if (map.containsKey(str)) {
            return map.get(str).format(this);
        }
        return this.mMediaFormat.getString(str);
    }

    private static abstract class Formatter {
        protected abstract String doFormat(IjkMediaFormat ijkMediaFormat);

        protected String getDefaultString() {
            return "N/A";
        }

        private Formatter() {
        }

        public String format(IjkMediaFormat ijkMediaFormat) {
            String doFormat = doFormat(ijkMediaFormat);
            return TextUtils.isEmpty(doFormat) ? getDefaultString() : doFormat;
        }
    }
}
