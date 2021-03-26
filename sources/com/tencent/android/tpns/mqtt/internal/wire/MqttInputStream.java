package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

public class MqttInputStream extends InputStream {
    private static final String CLASS_NAME = "MqttInputStream";
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "MqttInputStream");
    private ByteArrayOutputStream bais;
    private ClientState clientState = null;
    private DataInputStream in;
    private byte[] packet;
    private long packetLen;
    private long remLen;

    public MqttInputStream(ClientState clientState2, InputStream inputStream) {
        this.clientState = clientState2;
        this.in = new DataInputStream(inputStream);
        this.bais = new ByteArrayOutputStream();
        this.remLen = -1;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    public MqttWireMessage readMqttWireMessage() throws IOException, MqttException {
        TBaseLogger.d("MqttInputStream", "action - readMqttWireMessage");
        try {
            if (this.remLen < 0) {
                this.bais.reset();
                byte readByte = this.in.readByte();
                this.clientState.notifyReceivedBytes(1);
                byte b = (byte) ((readByte >>> 4) & 15);
                if (b < 1 || b > 14) {
                    throw ExceptionHelper.createMqttException(32108);
                }
                this.remLen = MqttWireMessage.readMBI(this.in).getValue();
                this.bais.write(readByte);
                this.bais.write(MqttWireMessage.encodeMBI(this.remLen));
                this.packet = new byte[((int) (((long) this.bais.size()) + this.remLen))];
                this.packetLen = 0;
            }
            if (this.remLen < 0) {
                return null;
            }
            readFully();
            this.remLen = -1;
            byte[] byteArray = this.bais.toByteArray();
            System.arraycopy(byteArray, 0, this.packet, 0, byteArray.length);
            MqttWireMessage createWireMessage = MqttWireMessage.createWireMessage(this.packet);
            log.fine("MqttInputStream", "readMqttWireMessage", "501", new Object[]{createWireMessage});
            return createWireMessage;
        } catch (SocketTimeoutException unused) {
            return null;
        }
    }

    private void readFully() throws IOException {
        int size = this.bais.size();
        long j = this.packetLen;
        int i = size + ((int) j);
        int i2 = (int) (this.remLen - j);
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    int read = this.in.read(this.packet, i + i3, i2 - i3);
                    this.clientState.notifyReceivedBytes(read);
                    if (read >= 0) {
                        i3 += read;
                    } else {
                        throw new EOFException();
                    }
                } catch (SocketTimeoutException e) {
                    this.packetLen += (long) i3;
                    throw e;
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
