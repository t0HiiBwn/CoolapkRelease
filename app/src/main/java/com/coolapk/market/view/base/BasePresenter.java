package com.coolapk.market.view.base;

import android.os.Bundle;

public interface BasePresenter {
    void onInitPresenterState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);
}
