package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSuback;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

public class Token {
    private static final String CLASS_NAME = "Token";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "Token");
    private IMqttActionListener callback = null;
    private IMqttAsyncClient client = null;
    private volatile boolean completed = false;
    private MqttException exception = null;
    private String key;
    protected MqttMessage message = null;
    private int messageID = 0;
    private boolean notified = false;
    private boolean pendingComplete = false;
    private MqttWireMessage response = null;
    private Object responseLock = new Object();
    private boolean sent = false;
    private Object sentLock = new Object();
    private String[] topics = null;
    private Object userContext = null;

    public Token(String str) {
        log.setResourceName(str);
    }

    public int getMessageID() {
        return this.messageID;
    }

    public void setMessageID(int i) {
        this.messageID = i;
    }

    public boolean checkResult() throws MqttException {
        if (getException() == null) {
            return true;
        }
        throw getException();
    }

    public MqttException getException() {
        return this.exception;
    }

    public boolean isComplete() {
        return this.completed;
    }

    protected boolean isCompletePending() {
        return this.pendingComplete;
    }

    protected boolean isInUse() {
        return getClient() != null && !isComplete();
    }

    public void setActionCallback(IMqttActionListener iMqttActionListener) {
        this.callback = iMqttActionListener;
    }

    public IMqttActionListener getActionCallback() {
        return this.callback;
    }

    public void waitForCompletion() throws MqttException {
        waitForCompletion(-1);
    }

    public void waitForCompletion(long j) throws MqttException {
        log.fine("Token", "waitForCompletion", "407", new Object[]{getKey(), new Long(j), this});
        if (waitForResponse(j) != null || this.completed) {
            checkResult();
            return;
        }
        TBaseLogger.e("Token", "waitForCompletion timeout");
        MqttException mqttException = new MqttException(32000);
        this.exception = mqttException;
        throw mqttException;
    }

    protected MqttWireMessage waitForResponse() throws MqttException {
        return waitForResponse(-1);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0041: APUT  (r9v0 java.lang.Object[]), (4 ??[int, float, short, byte, char]), (r14v1 java.lang.String) */
    protected MqttWireMessage waitForResponse(long j) throws MqttException {
        synchronized (this.responseLock) {
            Logger logger = log;
            Object[] objArr = new Object[7];
            objArr[0] = getKey();
            objArr[1] = new Long(j);
            objArr[2] = new Boolean(this.sent);
            objArr[3] = new Boolean(this.completed);
            MqttException mqttException = this.exception;
            objArr[4] = mqttException == null ? "false" : "true";
            objArr[5] = this.response;
            objArr[6] = this;
            logger.fine("Token", "waitForResponse", "400", objArr, mqttException);
            while (!this.completed) {
                if (this.exception == null) {
                    try {
                        log.fine("Token", "waitForResponse", "408", new Object[]{getKey(), new Long(j)});
                        if (j <= 0) {
                            this.responseLock.wait();
                        } else {
                            this.responseLock.wait(j);
                        }
                    } catch (InterruptedException e) {
                        this.exception = new MqttException(e);
                    }
                }
                if (!this.completed) {
                    MqttException mqttException2 = this.exception;
                    if (mqttException2 != null) {
                        log.fine("Token", "waitForResponse", "401", null, mqttException2);
                        throw this.exception;
                    } else if (j > 0) {
                        break;
                    }
                }
            }
        }
        log.fine("Token", "waitForResponse", "402", new Object[]{getKey(), this.response});
        return this.response;
    }

    protected void markComplete(MqttWireMessage mqttWireMessage, MqttException mqttException) {
        log.fine("Token", "markComplete", "404", new Object[]{getKey(), mqttWireMessage, mqttException});
        synchronized (this.responseLock) {
            if (mqttWireMessage instanceof MqttAck) {
                this.message = null;
            }
            this.pendingComplete = true;
            this.response = mqttWireMessage;
            this.exception = mqttException;
        }
    }

    protected void notifyComplete() {
        log.fine("Token", "notifyComplete", "404", new Object[]{getKey(), this.response, this.exception});
        synchronized (this.responseLock) {
            if (this.exception != null || !this.pendingComplete) {
                this.pendingComplete = false;
            } else {
                this.completed = true;
                this.pendingComplete = false;
            }
            this.responseLock.notifyAll();
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void waitUntilSent() throws MqttException {
        boolean z;
        synchronized (this.sentLock) {
            synchronized (this.responseLock) {
                MqttException mqttException = this.exception;
                if (mqttException != null) {
                    throw mqttException;
                }
            }
            while (true) {
                z = this.sent;
                if (z) {
                    break;
                }
                try {
                    log.fine("Token", "waitUntilSent", "409", new Object[]{getKey()});
                    this.sentLock.wait();
                } catch (InterruptedException unused) {
                }
            }
            if (!z) {
                MqttException mqttException2 = this.exception;
                if (mqttException2 == null) {
                    throw ExceptionHelper.createMqttException(6);
                }
                throw mqttException2;
            }
        }
    }

    protected void notifySent() {
        log.fine("Token", "notifySent", "403", new Object[]{getKey()});
        synchronized (this.responseLock) {
            this.response = null;
            this.completed = false;
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    protected void setClient(IMqttAsyncClient iMqttAsyncClient) {
        this.client = iMqttAsyncClient;
    }

    public void reset() throws MqttException {
        if (!isInUse()) {
            log.fine("Token", "reset", "410", new Object[]{getKey()});
            this.client = null;
            this.completed = false;
            this.response = null;
            this.sent = false;
            this.exception = null;
            this.userContext = null;
            return;
        }
        throw new MqttException(32201);
    }

    public MqttMessage getMessage() {
        return this.message;
    }

    public MqttWireMessage getWireMessage() {
        return this.response;
    }

    public void setMessage(MqttMessage mqttMessage) {
        this.message = mqttMessage;
    }

    public String[] getTopics() {
        return this.topics;
    }

    public void setTopics(String[] strArr) {
        this.topics = strArr;
    }

    public Object getUserContext() {
        return this.userContext;
    }

    public void setUserContext(Object obj) {
        this.userContext = obj;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setException(MqttException mqttException) {
        synchronized (this.responseLock) {
            this.exception = mqttException;
        }
    }

    public boolean isNotified() {
        return this.notified;
    }

    public void setNotified(boolean z) {
        this.notified = z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(getKey());
        stringBuffer.append(" ,topics=");
        if (getTopics() != null) {
            for (int i = 0; i < getTopics().length; i++) {
                stringBuffer.append(getTopics()[i]);
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(" ,usercontext=");
        stringBuffer.append(getUserContext());
        stringBuffer.append(" ,isComplete=");
        stringBuffer.append(isComplete());
        stringBuffer.append(" ,isNotified=");
        stringBuffer.append(isNotified());
        stringBuffer.append(" ,exception=");
        stringBuffer.append(getException());
        stringBuffer.append(" ,actioncallback=");
        stringBuffer.append(getActionCallback());
        return stringBuffer.toString();
    }

    public int[] getGrantedQos() {
        int[] iArr = new int[0];
        MqttWireMessage mqttWireMessage = this.response;
        return mqttWireMessage instanceof MqttSuback ? ((MqttSuback) mqttWireMessage).getGrantedQos() : iArr;
    }

    public boolean getSessionPresent() {
        MqttWireMessage mqttWireMessage = this.response;
        if (mqttWireMessage instanceof MqttConnack) {
            return ((MqttConnack) mqttWireMessage).getSessionPresent();
        }
        return false;
    }

    public MqttWireMessage getResponse() {
        return this.response;
    }
}
