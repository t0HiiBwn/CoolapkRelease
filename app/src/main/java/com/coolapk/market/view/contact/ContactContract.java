package com.coolapk.market.view.contact;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.User;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.util.List;

public interface ContactContract {

    public interface View extends AsyncListContract.View<Result<List<Entity>>> {
        String findFirstItem();

        String findLastItem();
    }

    public static abstract class Presenter extends AsyncListPresenter<Result<List<Entity>>> {
        public Presenter(View view) {
            super(view);
        }
    }

    public static abstract class FriendPresenter extends Presenter {
        public abstract String getUid();

        public FriendPresenter(View view) {
            super(view);
        }
    }

    public static abstract class FansPresenter extends Presenter {
        public abstract void followUser(String str);

        public abstract String getUid();

        public abstract void unfollowUser(String str);

        public FansPresenter(View view) {
            super(view);
        }
    }

    public static abstract class PickPresenter extends Presenter {
        public abstract void clearUserEntities();

        public abstract void saveUserEntities(List<User> list);

        public PickPresenter(View view) {
            super(view);
        }
    }
}
