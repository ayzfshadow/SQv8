package saki.packaged;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class mark20_classf {
    public static byte[] a(String str) {
        try {
            InputStream openStream = new URL(str).openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = openStream.read();
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    openStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
