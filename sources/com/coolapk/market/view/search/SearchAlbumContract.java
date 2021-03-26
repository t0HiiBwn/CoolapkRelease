package com.coolapk.market.view.search;

import com.coolapk.market.view.main.AlbumListContract;

public interface SearchAlbumContract {

    public static abstract class Presenter extends AlbumListContract.Presenter {
        public abstract String getKeyword();

        public Presenter(AlbumListContract.View view) {
            super(view);
        }
    }
}
