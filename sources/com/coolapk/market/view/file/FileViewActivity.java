package com.coolapk.market.view.file;

import androidx.fragment.app.Fragment;
import com.coolapk.market.view.base.ToolbarActivity;

public class FileViewActivity extends ToolbarActivity {
    @Override // com.coolapk.market.view.base.ToolbarActivity
    public Fragment onCreateFragment() {
        FileViewFragment newInstance = FileViewFragment.newInstance(null);
        newInstance.setPresenter(new FilePresenter(newInstance));
        return newInstance;
    }
}
