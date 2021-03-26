package com.kk.taurus.playerbase.assist;

import android.os.Bundle;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.log.PLog;

public class OnAssistPlayEventHandler extends BaseEventAssistHandler<AssistPlay> {
    public void requestPause(AssistPlay assistPlay, Bundle bundle) {
        if (assistPlay.isInPlaybackState()) {
            assistPlay.pause();
            return;
        }
        assistPlay.stop();
        assistPlay.reset();
    }

    public void requestResume(AssistPlay assistPlay, Bundle bundle) {
        if (assistPlay.isInPlaybackState()) {
            assistPlay.resume();
        } else {
            assistPlay.rePlay(0);
        }
    }

    public void requestSeek(AssistPlay assistPlay, Bundle bundle) {
        assistPlay.seekTo(bundle != null ? bundle.getInt("int_data") : 0);
    }

    public void requestStop(AssistPlay assistPlay, Bundle bundle) {
        assistPlay.stop();
    }

    public void requestReset(AssistPlay assistPlay, Bundle bundle) {
        assistPlay.reset();
    }

    public void requestRetry(AssistPlay assistPlay, Bundle bundle) {
        assistPlay.rePlay(bundle != null ? bundle.getInt("int_data") : 0);
    }

    public void requestReplay(AssistPlay assistPlay, Bundle bundle) {
        assistPlay.rePlay(0);
    }

    public void requestPlayDataSource(AssistPlay assistPlay, Bundle bundle) {
        if (bundle != null) {
            DataSource dataSource = (DataSource) bundle.getSerializable("serializable_data");
            if (dataSource == null) {
                PLog.e("OnAssistPlayEventHandler", "requestPlayDataSource need legal data source");
                return;
            }
            assistPlay.stop();
            assistPlay.setDataSource(dataSource);
            assistPlay.play();
        }
    }
}
