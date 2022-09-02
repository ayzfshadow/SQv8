package saki.packaged;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.TimeZone;

public class mark20_classj {
    public static long a() {
        long j;
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
            URLConnection openConnection = new URL("https://www.baidu.com/").openConnection();
            openConnection.connect();
            j = openConnection.getDate();
        } catch (IOException e) {
            e.printStackTrace();
            j = 0;
        }
        return j == 0 ? System.currentTimeMillis() : j;
    }
}
