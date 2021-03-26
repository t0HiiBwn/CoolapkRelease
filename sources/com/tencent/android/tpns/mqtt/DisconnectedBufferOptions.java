package com.tencent.android.tpns.mqtt;

public class DisconnectedBufferOptions {
    public static final boolean DELETE_OLDEST_MESSAGES_DEFAULT = false;
    public static final boolean DISCONNECTED_BUFFER_ENABLED_DEFAULT = false;
    public static final int DISCONNECTED_BUFFER_SIZE_DEFAULT = 5000;
    public static final boolean PERSIST_DISCONNECTED_BUFFER_DEFAULT = false;
    private boolean bufferEnabled = false;
    private int bufferSize = 5000;
    private boolean deleteOldestMessages = false;
    private boolean persistBuffer = false;

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(int i) {
        if (i >= 1) {
            this.bufferSize = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isBufferEnabled() {
        return this.bufferEnabled;
    }

    public void setBufferEnabled(boolean z) {
        this.bufferEnabled = z;
    }

    public boolean isPersistBuffer() {
        return this.persistBuffer;
    }

    public void setPersistBuffer(boolean z) {
        this.persistBuffer = z;
    }

    public boolean isDeleteOldestMessages() {
        return this.deleteOldestMessages;
    }

    public void setDeleteOldestMessages(boolean z) {
        this.deleteOldestMessages = z;
    }
}
