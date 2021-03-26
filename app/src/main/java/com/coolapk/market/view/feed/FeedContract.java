package com.coolapk.market.view.feed;

import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import java.util.List;
import rx.Observable;

public interface FeedContract {

    public interface View {
        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter {
        public abstract Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i);

        public Presenter(View view) {
        }
    }
}
