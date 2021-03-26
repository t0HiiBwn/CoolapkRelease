package com.bytedance.sdk.openadsdk.component.reward;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.g;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import java.net.URLEncoder;
import org.json.JSONObject;

/* compiled from: PlayableVerityHelper */
public class d {
    private static String a = "{\n\t\t\"ad_id\": \"1639941324071955\",\n\t\t\"app\": {\n\t\t\t\"app_name\": \"凡人修仙\",\n\t\t\t\"app_size\": 117644467,\n\t\t\t\"appleid\": \"0\",\n\t\t\t\"comment_num\": 7676,\n\t\t\t\"download_url\": \"\",\n\t\t\t\"package_name\": \"com.xyjx.frxx_190\",\n\t\t\t\"score\": 4\n\t\t},\n\t\t\"appstore_jump_type\": 0,\n\t\t\"button_text\": \"点我试玩\",\n\t\t\"click_url\": [],\n\t\t\"creative_type\": 6,\n\t\t\"description\": \"开挂修仙，一日化神，二日飞升，三日半步仙帝！\",\n\t\t\"download_conf\": {\n\t\t\t\"auto_control\": \"0\",\n\t\t\t\"auto_open\": 1,\n\t\t\t\"download_mode\": 0,\n\t\t\t\"download_type\": 1,\n\t\t\t\"if_suspend_download\": 1,\n\t\t\t\"support_multiple\": 0\n\t\t},\n\t\t\"ext\": \"{\\\"uid\\\": 65999808247, \\\"package_name\\\": \\\"com.union_test.toutiao\\\", \\\"rit\\\": 901121375, \\\"orit\\\": 900000000, \\\"ad_type\\\": 1, \\\"height\\\": 1920, \\\"pack_time\\\": 1563973281.779855, \\\"pricing\\\": 9, \\\"device_type\\\": \\\"ONEPLUS A3010\\\", \\\"promotion_type\\\": 0, \\\"is_sdk\\\": true, \\\"app_name\\\": \\\"APP\\\\u6d4b\\\\u8bd5\\\\u5a92\\\\u4f53\\\", \\\"uuid\\\": \\\"862561035200672\\\", \\\"os_version\\\": \\\"8.0.0\\\", \\\"creative_id\\\": 1639941324071955, \\\"version_code\\\": \\\"2.3.0\\\", \\\"vid\\\": \\\"1024067,1016869,994044,994829,774109,657281,1001615,995476,1000478,1031346,945702,1025028,953637,987200,1034690,1025294,936646,1022401,1022406,774117,777874,1025520,762536\\\", \\\"uuid_md5\\\": \\\"83d508d01db531b4cf4843d2e41348ed\\\", \\\"width\\\": 1080, \\\"template_rate\\\": 0, \\\"src_type\\\": \\\"app\\\", \\\"img_gen_type\\\": 0, \\\"client_ip\\\": \\\"125.35.101.202\\\", \\\"ad_id\\\": 1639940885031987, \\\"convert_id\\\": 1639938850817027, \\\"img_md5\\\": \\\"\\\", \\\"ad_price\\\": \\\"XThCVgADKYpdOEJWAAMpijdExKKDLYCp1GNXWw\\\", \\\"app_id\\\": \\\"5001121\\\", \\\"source_type\\\": 1, \\\"mac\\\": \\\"C0:EE:FB:F1:D4:80\\\", \\\"imei\\\": \\\"862561035200672\\\", \\\"ug_creative_id\\\": \\\"\\\", \\\"device_id\\\": 38167681029, \\\"landing_type\\\": 3, \\\"language\\\": \\\"golang\\\", \\\"cid\\\": 1639941324071955, \\\"ut\\\": 12, \\\"interaction_type\\\": 4, \\\"open_udid\\\": \\\"\\\", \\\"pos\\\": 5, \\\"req_id\\\": \\\"0781feb2-bf4b-4ff8-be68-9149e288a420u6714\\\", \\\"is_dsp_ad\\\": false, \\\"ad_slot_type\\\": 8, \\\"os_type\\\": null, \\\"os\\\": \\\"android\\\", \\\"template_id\\\": 7000003}\",\n\t\t\"filter_words\": [{\n\t\t\t\"id\": \"4:2\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"看过了\"\n\t\t}, {\n\t\t\t\"id\": \"4:1\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"不感兴趣\"\n\t\t}, {\n\t\t\t\"id\": \"4:3\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"广告太多了\"\n\t\t}, {\n\t\t\t\"id\": \"6:0\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"举报垃圾内容\",\n\t\t\t\"options\": [{\n\t\t\t\t\"id\": \"6:1\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"低俗色情\"\n\t\t\t}, {\n\t\t\t\t\"id\": \"6:2\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"虚假欺诈\"\n\t\t\t}, {\n\t\t\t\t\"id\": \"6:3\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"标题夸张\"\n\t\t\t}, {\n\t\t\t\t\"id\": \"6:4\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"疑似抄袭\"\n\t\t\t}]\n\t\t}],\n\t\t\"icon\": {\n\t\t\t\"height\": 100,\n\t\t\t\"url\": \"http://p3-tt.byteimg.com/img/web.business.image/201907245d0d495a0568785742e0b940~100x100.image\",\n\t\t\t\"width\": 100\n\t\t},\n\t\t\"image\": [{\n\t\t\t\"height\": 1920,\n\t\t\t\"url\": \"http://sf3-ttcdn-tos.pstatp.com/obj/mosaic-legacy/2b96e0005c6b6019f8a5b\",\n\t\t\t\"width\": 1080\n\t\t}],\n\t\t\"image_mode\": 15,\n\t\t\"in_app\": true,\n\t\t\"interaction_type\": 4,\n\t\t\"intercept_flag\": 1,\n\t\t\"is_playable\": true,\n\t\t\"media_ext\": {\n\t\t\t\"price\": 6027\n\t\t},\n\t\t\"play_bar_show_time\": -1,\n\t\t\"play_bar_style\": 0,\n\t\t\"screenshot\": false,\n\t\t\"show_url\": [],\n\t\t\"target_url\": \"https://www.chengzijianzhan.com/tetris/page/1639938884171780/?ad_id=1639940885031987&_toutiao_params=%7B%22cid%22%3A1639941324071955%2C%22device_id%22%3A38167681029%2C%22log_extra%22%3A%22%7B%5C%22ad_price%5C%22%3A%5C%22XThCVgADKYpdOEJWAAMpijdExKKDLYCp1GNXWw%5C%22%2C%5C%22convert_id%5C%22%3A1639938850817027%2C%5C%22orit%5C%22%3A900000000%2C%5C%22req_id%5C%22%3A%5C%220781feb2-bf4b-4ff8-be68-9149e288a420u6714%5C%22%2C%5C%22rit%5C%22%3A901121375%7D%22%2C%22orit%22%3A900000000%2C%22req_id%22%3A%220781feb2-bf4b-4ff8-be68-9149e288a420u6714%22%2C%22rit%22%3A901121375%2C%22sign%22%3A%22D41D8CD98F00B204E9800998ECF8427E%22%2C%22uid%22%3A65999808247%2C%22ut%22%3A12%7D\",\n\t\t\"temp_extra_info\": \"{\\\"img_gen_type\\\":0,\\\"img_md5\\\":\\\"\\\",\\\"template_id\\\":7000003}\",\n\t\t\"template_id\": 0,\n\t\t\"title\": \"开挂修仙，一日化神，二日飞升，三日半步仙帝！\",\n\t\t\"union_special\": 1,\n\t\t\"video\": {\n\t\t\t\"cover_height\": 1280,\n\t\t\t\"cover_url\": \"http://sf3-ttcdn-tos.pstatp.com/img/mosaic-legacy/2b96e0005c6b6019f8a5b~noop.jpg\",\n\t\t\t\"cover_width\": 720,\n\t\t\t\"endcard\": \"https://sf1-ttcdn-tos.pstatp.com/obj/union-fe/playable/97699c8fb31e7836e828cffdd428bc80/index.html?toutiao_card_params=%7B%22name%22%3A%20%22%5Cu5168%5Cu6c11%5Cu6f02%5Cu79fb-3D%5Cu98d9%5Cu8f66%22%2C%20%22pkg_name%22%3A%20%22com.joyfort.merge.car%22%2C%20%22id%22%3A%201639299979328516%2C%20%22download_url%22%3A%20%22https%3A//itunes.apple.com/cn/app/%25E5%2585%25A8%25E6%25B0%2591%25E6%25BC%2582%25E7%25A7%25BB3d/id1453467684%3Fmt%3D8%22%2C%20%22external_url%22%3A%20%22%22%7D\",\n\t\t\t\"file_hash\": \"eb321fa50173a95c041b0389a565b006\",\n\t\t\t\"resolution\": \"720x1280\",\n\t\t\t\"size\": 3410585,\n\t\t\t\"video_duration\": 28.95,\n\t\t\t\"video_url\": \"http://sf1-ttcdn-tos.pstatp.com/obj/ttfe/adfe/union_endcard/union_test_tool.mp4\"\n\t\t}\n\t}";

    public static void a(String str, int i, String str2, String str3, String str4) {
        try {
            l a2 = c.a(new JSONObject(a));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", "1641194171089955");
            jSONObject.put("pkg_name", str3);
            jSONObject.put("download_url", str2);
            jSONObject.put("external_url", "");
            jSONObject.put("name", "消灭病毒");
            String str5 = str + "?is_test_tool=1&toutiao_card_params=" + URLEncoder.encode(jSONObject.toString());
            if (a2 != null) {
                if (a2.R() != null) {
                    a2.R().d(str5);
                }
                if (a2.ah() != null) {
                    if (!TextUtils.isEmpty(str2)) {
                        a2.ah().b(str2);
                        a2.ah().c("测试下载的app");
                    } else {
                        a2.ah().b((String) null);
                        a2.ah().c("");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        a2.ah().d(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        if (a2.ai() != null) {
                            a2.ai().a(str4);
                        } else {
                            g gVar = new g();
                            gVar.a(str4);
                            a2.a(gVar);
                        }
                    }
                }
                if (a2.U() != null) {
                    a2.U().a("http://sf1-ttcdn-tos.pstatp.com/obj/ttfe/adfe/union_endcard/Lark20190725-175511.png");
                }
                if (i == 1) {
                    a2.p(15);
                } else {
                    a2.p(5);
                }
            }
            i iVar = new i(p.a(), a2, new AdSlot.Builder().setOrientation(i).build());
            iVar.a(true);
            iVar.showFullScreenVideoAd(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
