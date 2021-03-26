package com.google.android.material.datepicker;

abstract class OnSelectionChangedListener<S> {
    void onIncompleteSelectionChanged() {
    }

    abstract void onSelectionChanged(S s);

    OnSelectionChangedListener() {
    }
}
