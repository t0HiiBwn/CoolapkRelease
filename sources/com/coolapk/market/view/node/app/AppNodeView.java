package com.coolapk.market.view.node.app;

import com.coolapk.market.network.Result;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J>\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J>\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u001a\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J6\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\u001a\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeView;", "", "onFavoriteAppComplete", "", "oldValue", "", "newValue", "result", "Lcom/coolapk/market/network/Result;", "", "error", "", "onFollowAppComplete", "", "", "onRatingComplete", "onUnratingComplete", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeContract.kt */
public interface AppNodeView {
    void onFavoriteAppComplete(boolean z, boolean z2, Result<Integer> result, Throwable th);

    void onFollowAppComplete(boolean z, boolean z2, Result<Map<String, String>> result, Throwable th);

    void onRatingComplete(int i, int i2, Result<Map<String, String>> result, Throwable th);

    void onUnratingComplete(int i, Result<Map<String, String>> result, Throwable th);
}
