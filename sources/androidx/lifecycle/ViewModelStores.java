package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ViewModelStores {
    private ViewModelStores() {
    }

    @Deprecated
    public static ViewModelStore of(FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }

    @Deprecated
    public static ViewModelStore of(Fragment fragment) {
        return fragment.getViewModelStore();
    }
}
