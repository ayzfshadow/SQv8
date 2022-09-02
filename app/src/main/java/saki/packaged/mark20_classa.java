package saki.packaged;

import com.saki.authort.AuthorAccunt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import saki.toolkit.Code;
import saki.qq.global.mark12_classc;

public class mark20_classa {
    public static long[] a;

    public static boolean a(long j) {
        try {
            InputStream openStream = new URL(String.valueOf(new String(Code.a(mark12_classc.a, new byte[16]))) + "b.txt").openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = openStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            }
            JSONArray jSONArray = new JSONArray(new String(byteArrayOutputStream.toByteArray()));
            a = new long[jSONArray.length()];
            boolean z = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                a[i] = jSONArray.optLong(i, -1);
                if (a[i] == j) {
                    z = true;
                }
            }
            return z;
        } catch (IOException | JSONException e) {
            return false;
        }
    }

    public static AuthorAccunt b(long j) {
        try {
            return (AuthorAccunt) new ObjectInputStream(new URL(String.valueOf(new String(Code.a(mark12_classc.b, new byte[16]))) + j).openConnection().getInputStream()).readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
