package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

public final class PoiResult {
    private int a;
    private ArrayList<PoiItem> b = new ArrayList<>();
    private PoiSearch.Query c;
    private PoiSearch.SearchBound d;
    private List<String> e;
    private List<SuggestionCity> f;
    private int g;

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i, int i2, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i, i2, arrayList);
    }

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i, int i2, ArrayList<PoiItem> arrayList) {
        this.c = query;
        this.d = searchBound;
        this.e = list;
        this.f = list2;
        this.g = i;
        this.a = ((i2 + i) - 1) / i;
        this.b = arrayList;
    }

    public final int getPageCount() {
        return this.a;
    }

    public final PoiSearch.Query getQuery() {
        return this.c;
    }

    public final PoiSearch.SearchBound getBound() {
        return this.d;
    }

    public final ArrayList<PoiItem> getPois() {
        return this.b;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.e;
    }

    public final List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f;
    }
}
