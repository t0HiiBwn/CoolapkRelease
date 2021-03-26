package androidx.databinding.adapters;

import android.os.Build;
import android.widget.SearchView;

public class SearchViewBindingAdapter {

    public interface OnQueryTextChange {
        boolean onQueryTextChange(String str);
    }

    public interface OnQueryTextSubmit {
        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionClick {
        boolean onSuggestionClick(int i);
    }

    public interface OnSuggestionSelect {
        boolean onSuggestionSelect(int i);
    }

    public static void setOnQueryTextListener(SearchView searchView, final OnQueryTextSubmit onQueryTextSubmit, final OnQueryTextChange onQueryTextChange) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        if (onQueryTextSubmit == null && onQueryTextChange == null) {
            searchView.setOnQueryTextListener(null);
        } else {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                /* class androidx.databinding.adapters.SearchViewBindingAdapter.AnonymousClass1 */

                @Override // android.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(String str) {
                    OnQueryTextSubmit onQueryTextSubmit = onQueryTextSubmit;
                    if (onQueryTextSubmit != null) {
                        return onQueryTextSubmit.onQueryTextSubmit(str);
                    }
                    return false;
                }

                @Override // android.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(String str) {
                    OnQueryTextChange onQueryTextChange = onQueryTextChange;
                    if (onQueryTextChange != null) {
                        return onQueryTextChange.onQueryTextChange(str);
                    }
                    return false;
                }
            });
        }
    }

    public static void setOnSuggestListener(SearchView searchView, final OnSuggestionSelect onSuggestionSelect, final OnSuggestionClick onSuggestionClick) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        if (onSuggestionSelect == null && onSuggestionClick == null) {
            searchView.setOnSuggestionListener(null);
        } else {
            searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
                /* class androidx.databinding.adapters.SearchViewBindingAdapter.AnonymousClass2 */

                @Override // android.widget.SearchView.OnSuggestionListener
                public boolean onSuggestionSelect(int i) {
                    OnSuggestionSelect onSuggestionSelect = onSuggestionSelect;
                    if (onSuggestionSelect != null) {
                        return onSuggestionSelect.onSuggestionSelect(i);
                    }
                    return false;
                }

                @Override // android.widget.SearchView.OnSuggestionListener
                public boolean onSuggestionClick(int i) {
                    OnSuggestionClick onSuggestionClick = onSuggestionClick;
                    if (onSuggestionClick != null) {
                        return onSuggestionClick.onSuggestionClick(i);
                    }
                    return false;
                }
            });
        }
    }
}
