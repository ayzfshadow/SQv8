package com.saki.packagea;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.net.ProtocolException;
import java.io.IOException;

public class mark3_classb {
    private mark3_classa a = new mark3_classa();
    private String b = "UTF-8";
    private int c = 0;

    public byte[] a(String str, String str2, int i, int i2, String... strArr) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.addRequestProperty("Cookie", this.a.toString());
        httpURLConnection.addRequestProperty("Accept-Charset", this.b);
        httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        for (String str3 : strArr) {
            if (str3.contains(":")) {
                int indexOf = str3.indexOf(":");
                httpURLConnection.addRequestProperty(str3.substring(0, indexOf), str3.substring(indexOf + 1, str3.length()));
            }
        }
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i2);
        httpURLConnection.connect();
        PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
        printWriter.print(str2);
        printWriter.flush();
        this.c = httpURLConnection.getResponseCode();
        if (httpURLConnection.getHeaderFields().get("Set-Cookie") != null) {
            for (String a2 : (List<String>) httpURLConnection.getHeaderFields().get("Set-Cookie")) {
                this.a.a(a2);
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = httpURLConnection.getInputStream();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(read);
        }
        if (printWriter != null) {
            printWriter.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        httpURLConnection.disconnect();
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] a(String str, boolean z, int i, int i2, String... strArr) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.addRequestProperty("Cookie", this.a.toString());
        httpURLConnection.addRequestProperty("Accept-Charset", this.b);
        httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        httpURLConnection.setInstanceFollowRedirects(z);
        for (String str2 : strArr) {
            if (str2.contains(":")) {
                int indexOf = str2.indexOf(":");
                httpURLConnection.addRequestProperty(str2.substring(0, indexOf), str2.substring(indexOf + 1, str2.length()));
            }
        }
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i2);
        httpURLConnection.connect();
        this.c = httpURLConnection.getResponseCode();
        if (httpURLConnection.getHeaderFields().get("Set-Cookie") != null) {
            for (String a2 : (List<String>) httpURLConnection.getHeaderFields().get("Set-Cookie")) {
                this.a.a(a2);
            }
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(read);
        }
        if (inputStream != null) {
            inputStream.close();
        }
        httpURLConnection.disconnect();
        return byteArrayOutputStream.toByteArray();
    }
    
    
    public byte[] a(String g ){
        try
        {
            return a(g, true, 5000, 15000, new String[0]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
