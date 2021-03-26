package com.kk.taurus.playerbase.assist;

import android.os.Bundle;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.log.PLog;
import com.kk.taurus.playerbase.widget.BaseVideoView;

public class OnVideoViewEventHandler extends BaseEventAssistHandler<BaseVideoView> {
    public void requestPause(BaseVideoView baseVideoView, Bundle bundle) {
        if (isInPlaybackState(baseVideoView)) {
            baseVideoView.pause();
        } else {
            baseVideoView.stop();
        }
    }

    public void requestResume(BaseVideoView baseVideoView, Bundle bundle) {
        if (isInPlaybackState(baseVideoView)) {
            baseVideoView.resume();
        } else {
            baseVideoView.rePlay(0);
        }
    }

    public void requestSeek(BaseVideoView baseVideoView, Bundle bundle) {
        baseVideoView.seekTo(bundle != null ? bundle.getInt("int_data") : 0);
    }

    public void requestStop(BaseVideoView baseVideoView, Bundle bundle) {
        baseVideoView.stop();
    }

    public void requestReset(BaseVideoView baseVideoView, Bundle bundle) {
        baseVideoView.stop();
    }

    public void requestRetry(BaseVideoView baseVideoView, Bundle bundle) {
        baseVideoView.rePlay(bundle != null ? bundle.getInt("int_data") : 0);
    }

    public void requestReplay(BaseVideoView baseVideoView, Bundle bundle) {
        baseVideoView.rePlay(0);
    }

    public void requestPlayDataSource(BaseVideoView baseVideoView, Bundle bundle) {
        if (bundle != null) {
            DataSource dataSource = (DataSource) bundle.getSerializable("serializable_data");
            if (dataSource == null) {
                PLog.e("OnVideoViewEventHandler", "requestPlayDataSource need legal data source");
                return;
            }
            baseVideoView.stop();
            baseVideoView.setDataSource(dataSource);
            baseVideoView.start();
        }
    }

    private boolean isInPlaybackState(BaseVideoView baseVideoView) {
        int state = baseVideoView.getState();
        return (state == -2 || state == -1 || state == 0 || state == 1 || state == 5) ? false : true;
    }
}
