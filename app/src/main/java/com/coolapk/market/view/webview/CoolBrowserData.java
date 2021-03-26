package com.coolapk.market.view.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.List;

public class CoolBrowserData {
    private static int sAutoIncrease;
    private Context mContext;
    private PageData mCurrentPageData;
    private PageCountChangeListener mPageCountChangeListener;
    private List<PageData> mPageDataList;
    private SharedPreferences mPreferences;
    private SearchEngine mSearchEngine;

    public interface PageCountChangeListener {
        void onPageCountChanged(int i);
    }

    public String getHomePage() {
        return "about:blank";
    }

    public CoolBrowserData(Context context) {
        this.mContext = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("CoolBrowserData", 0);
        this.mPreferences = sharedPreferences;
        int i = sharedPreferences.getInt("SEARCH_ENGINE_INDEX", -1);
        if (i < 0) {
            this.mSearchEngine = SearchEngine.BAIDU_SEARCH;
        } else {
            this.mSearchEngine = getSearchEngineList().get(i);
        }
        this.mPageDataList = new ArrayList();
    }

    public SearchEngine getSearchEngine() {
        return this.mSearchEngine;
    }

    public void changeSearchEngine(SearchEngine searchEngine) {
        this.mSearchEngine = searchEngine;
        this.mPreferences.edit().putInt("SEARCH_ENGINE_INDEX", getSearchEngineList().indexOf(searchEngine)).apply();
    }

    public PageData createNewPage(String str) {
        sAutoIncrease++;
        PageData pageData = new PageData(str, "CoolBrowserData" + sAutoIncrease);
        this.mPageDataList.add(pageData);
        PageCountChangeListener pageCountChangeListener = this.mPageCountChangeListener;
        if (pageCountChangeListener != null) {
            pageCountChangeListener.onPageCountChanged(getPageCount());
        }
        return pageData;
    }

    public void setPageCountChangeListener(PageCountChangeListener pageCountChangeListener) {
        this.mPageCountChangeListener = pageCountChangeListener;
    }

    public PageData getCurrentPageData() {
        return this.mCurrentPageData;
    }

    public int indexOfPageData(PageData pageData) {
        return this.mPageDataList.indexOf(pageData);
    }

    public void setCurrentPageData(PageData pageData) {
        if (this.mPageDataList.contains(pageData)) {
            this.mCurrentPageData = pageData;
            return;
        }
        throw new RuntimeException("pageData doesn't in page list");
    }

    public PageData getPageAt(int i) {
        return this.mPageDataList.get(i);
    }

    public int getPageCount() {
        return this.mPageDataList.size();
    }

    public void removePage(FragmentTransaction fragmentTransaction, int i) {
        this.mPageDataList.get(i).release(fragmentTransaction);
        this.mPageDataList.remove(i);
        PageCountChangeListener pageCountChangeListener = this.mPageCountChangeListener;
        if (pageCountChangeListener != null) {
            pageCountChangeListener.onPageCountChanged(getPageCount());
        }
    }

    public void removeAllPage(FragmentTransaction fragmentTransaction) {
        for (PageData pageData : this.mPageDataList) {
            pageData.release(fragmentTransaction);
        }
        this.mPageDataList.clear();
        PageCountChangeListener pageCountChangeListener = this.mPageCountChangeListener;
        if (pageCountChangeListener != null) {
            pageCountChangeListener.onPageCountChanged(getPageCount());
        }
    }

    public static List<SearchEngine> getSearchEngineList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SearchEngine.BAIDU_SEARCH);
        arrayList.add(SearchEngine.SOUGOU_SEARCH);
        arrayList.add(SearchEngine.GOOGLE_SEARCH);
        return arrayList;
    }

    public static class SearchEngine {
        public static final SearchEngine BAIDU_SEARCH = new SearchEngine("百度搜索", "http://www.baidu.com/#ie=UTF-8&wd=%s");
        public static final SearchEngine GOOGLE_SEARCH = new SearchEngine("谷歌搜索", "https://www.google.com/#q=%s");
        public static final SearchEngine SOUGOU_SEARCH = new SearchEngine("搜狗搜索", "https://www.sogou.com/web?ie=UTF-8&query=%s");
        private String name;
        private int resId;
        private String url;

        SearchEngine(String str, String str2) {
            this.name = str;
            this.url = str2;
        }

        SearchEngine(String str, String str2, int i) {
            this.name = str;
            this.url = str2;
            this.resId = i;
        }

        public Drawable getDrawable(Context context) {
            int i = this.resId;
            if (i > 0) {
                return context.getDrawable(i);
            }
            return context.getDrawable(2131231588);
        }

        public String getName() {
            return this.name;
        }

        public String getUrl() {
            return this.url;
        }
    }

    static class PageData {
        private CoolBrowserFragment fragment;
        private String tag;
        private String url;

        private PageData(String str, String str2) {
            this.url = str;
            this.tag = str2;
        }

        public String getUrl() {
            CoolBrowserFragment coolBrowserFragment = this.fragment;
            if (coolBrowserFragment == null || coolBrowserFragment.getWebView() == null) {
                return this.url;
            }
            return this.fragment.getWebView().getUrl();
        }

        public String getTitle() {
            CoolBrowserFragment coolBrowserFragment = this.fragment;
            if (coolBrowserFragment == null || coolBrowserFragment.getWebView() == null) {
                return this.url;
            }
            return this.fragment.getWebView().getTitle();
        }

        public Drawable getIcon(Context context) {
            Bitmap icon;
            CoolBrowserFragment coolBrowserFragment = this.fragment;
            if (coolBrowserFragment == null || (icon = coolBrowserFragment.getIcon()) == null) {
                return context.getDrawable(2131231350);
            }
            return new BitmapDrawable(context.getResources(), icon);
        }

        public CoolBrowserFragment getOrCreateFragment(FragmentManager fragmentManager) {
            if (this.fragment == null) {
                CoolBrowserFragment coolBrowserFragment = (CoolBrowserFragment) fragmentManager.findFragmentByTag(this.tag);
                this.fragment = coolBrowserFragment;
                if (coolBrowserFragment == null) {
                    this.fragment = CoolBrowserFragment.newInstance(this.url);
                }
                this.fragment.setPageData(this);
            }
            return this.fragment;
        }

        void release(FragmentTransaction fragmentTransaction) {
            CoolBrowserFragment coolBrowserFragment = this.fragment;
            if (coolBrowserFragment != null) {
                fragmentTransaction.remove(coolBrowserFragment);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            String str = this.tag;
            String str2 = ((PageData) obj).tag;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.tag;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
    }
}
