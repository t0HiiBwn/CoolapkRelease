package com.bytedance.tea.crash.upload;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

/* compiled from: MultipartUtility */
public class e {
    private final String a;
    private HttpURLConnection b;
    private String c;
    private boolean d;
    private DataOutputStream e;
    private GZIPOutputStream f;

    e(String str, String str2, boolean z) throws IOException {
        this.c = str2;
        this.d = z;
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.a = str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.b.setDoOutput(true);
        this.b.setDoInput(true);
        this.b.setRequestMethod("POST");
        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str3);
        if (z) {
            this.b.setRequestProperty("Content-Encoding", "gzip");
            this.f = new GZIPOutputStream(this.b.getOutputStream());
            return;
        }
        this.e = new DataOutputStream(this.b.getOutputStream());
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.a);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"");
        sb.append("\r\n");
        sb.append("Content-Type: text/plain; charset=");
        sb.append(this.c);
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        try {
            if (this.d) {
                this.f.write(sb.toString().getBytes());
            } else {
                this.e.write(sb.toString().getBytes());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, File file) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(this.a);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        sb.append("\r\n");
        sb.append("Content-Transfer-Encoding: binary");
        sb.append("\r\n");
        sb.append("\r\n");
        if (this.d) {
            this.f.write(sb.toString().getBytes());
        } else {
            this.e.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            } else if (this.d) {
                this.f.write(bArr, 0, read);
            } else {
                this.e.write(bArr, 0, read);
            }
        }
        fileInputStream.close();
        if (this.d) {
            this.f.write("\r\n".getBytes());
            return;
        }
        this.e.write(sb.toString().getBytes());
        this.e.flush();
    }

    public String a() throws IOException {
        ArrayList<String> arrayList = new ArrayList();
        byte[] bytes = ("\r\n--" + this.a + "--\r\n").getBytes();
        if (this.d) {
            this.f.write(bytes);
            this.f.finish();
            this.f.close();
        } else {
            this.e.write(bytes);
            this.e.flush();
            this.e.close();
        }
        int responseCode = this.b.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            this.b.disconnect();
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                sb.append(str);
            }
            return sb.toString();
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }
}
