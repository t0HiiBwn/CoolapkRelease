package com.coolapk.market.network;

import android.util.Pair;
import com.coolapk.market.model.ImageUploadOption;
import java.util.List;
import rx.Observable;

public interface IOSSClientWrap {
    Observable<Pair<String, String>> uploadImage(List<ImageUploadOption> list);
}
