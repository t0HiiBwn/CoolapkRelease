package com.coolapk.market.view.live;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nJ\b\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/live/FakeDanmakuData;", "", "()V", "entityId", "Ljava/util/concurrent/atomic/AtomicInteger;", "entitySize", "", "uid", "", "createData", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "createJson", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FakeDanmakuData.kt */
public final class FakeDanmakuData {
    private final AtomicInteger entityId = new AtomicInteger(743120);
    private final int entitySize = 10;
    private final String uid = "185832";

    public final Observable<Result<List<Entity>>> createData() {
        Observable<Result<List<Entity>>> fromCallable = Observable.fromCallable(new FakeDanmakuData$createData$1(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …, createJson())\n        }");
        return fromCallable;
    }

    /* access modifiers changed from: private */
    public final String createJson() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int i = this.entitySize;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int andIncrement = this.entityId.getAndIncrement();
            arrayList.add("{\"id\":" + andIncrement + ",\"live_id\":1099,\"uid\":" + this.uid + ",\"username\":\"小狗吃不了鱼\",\"message\":\"弹幕测试" + andIncrement + "\",\"message_source\":\"弹幕测试" + andIncrement + "\",\"pic\":\"\",\"replynum\":0,\"source_id\":0,\"ip\":\"113.89.239.187\",\"dateline\":" + currentTimeMillis + ",\"status\":1,\"block_status\":0,\"device_title\":\"三星Galaxy S20+\",\"device_name\":\"SAMSUNG SM-G9860\",\"device_rom\":\"\",\"device_build\":\"\",\"is_broadcast\":0,\"system_message_type\":0,\"entityId\":" + andIncrement + ",\"entityType\":\"liveMessage\",\"datelineFormat\":\"12:01\",\"extraData\":\"{\\\"id\\\":1099,\\\"visit_num\\\":7360,\\\"follow_num\\\":1,\\\"discuss_num\\\":710,\\\"discuss_num_format\\\":710,\\\"follow_num_format\\\":1,\\\"visit_num_format\\\":7360,\\\"entityId\\\":1099,\\\"entityType\\\":\\\"liveTopic\\\",\\\"url\\\":\\\"\\\\/live\\\\/1099\\\",\\\"show_tab\\\":\\\"intro\\\"}\",\"userAvatar\":\"http://avatar.coolapk.com/data/000/18/58/31_avatar_middle.jpg?1559284208\",\"userInfo\":{\"uid\":" + this.uid + ",\"username\":\"小狗吃不了鱼\",\"admintype\":3,\"groupid\":3,\"usergroupid\":104,\"level\":4,\"experience\":42012,\"status\":1,\"block_status\":0,\"usernamestatus\":0,\"avatarstatus\":1559284208,\"avatar_cover_status\":1561631714,\"regdate\":1339048316,\"logintime\":1597377660,\"verify_title\":\"酷安认证: 酷安员工\",\"verify_status\":1,\"user_type\":0,\"verify_show_type\":0,\"fetchType\":\"base\",\"entityType\":\"user\",\"entityId\":" + this.uid + ",\"displayUsername\":\"小狗吃不了鱼\",\"url\":\"/u/185831\",\"userAvatar\":\"http://avatar.coolapk.com/data/000/18/58/31_avatar_middle.jpg?1559284208\",\"userSmallAvatar\":\"http://avatar.coolapk.com/data/000/18/58/31_avatar_small.jpg?1559284208\",\"userBigAvatar\":\"http://avatar.coolapk.com/data/000/18/58/31_avatar_big.jpg?1559284208\",\"cover\":\"http://avatar.coolapk.com/cover/15/61/63/185831_1561631714.jpg\",\"verify_icon\":\"v_green\",\"verify_label\":\"\",\"isDeveloper\":0,\"next_level_experience\":64000,\"next_level_percentage\":\"65.64\",\"level_today_message\":\"\",\"level_detail_url\":\"/feed/18221454\"}}");
        }
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.reversed(arrayList), ", ", null, null, 0, null, null, 62, null);
        return "{\"data\":[" + joinToString$default + "]}";
    }
}
