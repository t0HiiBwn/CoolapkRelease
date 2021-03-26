package com.amap.api.maps2d.model;

import com.amap.api.mapcore2d.ck;
import com.amap.api.mapcore2d.cm;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int a;
    private final int b;

    public abstract URL getTileUrl(int i, int i2, int i3);

    public UrlTileProvider(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.amap.api.maps2d.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        ck.a("UrlTileProvider", "url: " + tileUrl.toString(), 111);
        try {
            return new Tile(this.a, this.b, a(tileUrl.openStream()));
        } catch (IOException e) {
            cm.a(e, "UrlTileProvider", "getTile");
            return NO_TILE;
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    @Override // com.amap.api.maps2d.model.TileProvider
    public int getTileWidth() {
        return this.a;
    }

    @Override // com.amap.api.maps2d.model.TileProvider
    public int getTileHeight() {
        return this.b;
    }
}
