package saki.packaged;

import android.os.Environment;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import saki.qq.global.mark12_classc;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classj;

public class mark20_classh {
    public static final String a = (Environment.getExternalStorageDirectory() + "/SQ/login.spk");

    public static boolean a() {
        File file = new File(a);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeLong(mark12_classc.c);
            dataOutputStream.writeUTF(mark12_classc.d);
            dataOutputStream.write(ProtocolInfo.g);
            dataOutputStream.writeInt(mark12_classj.c.length);
            dataOutputStream.write(mark12_classj.c);
            dataOutputStream.writeInt(mark12_classj.a.length);
            dataOutputStream.write(mark12_classj.a);
            dataOutputStream.writeInt(mark12_classj.b.length);
            dataOutputStream.write(mark12_classj.b);
            dataOutputStream.writeInt(mark12_classc.g.length);
            dataOutputStream.write(mark12_classc.g);
            dataOutputStream.flush();
            dataOutputStream.close();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean b() {
        File file = new File(a);
        if (!file.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            mark12_classc.c = dataInputStream.readLong();
            mark12_classc.d = dataInputStream.readUTF();
            ProtocolInfo.g = new byte[16];
            dataInputStream.readFully(ProtocolInfo.g);
            mark12_classj.c = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(mark12_classj.c);
            mark12_classj.a = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(mark12_classj.a);
            mark12_classj.b = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(mark12_classj.b);
            mark12_classc.g = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(mark12_classc.g);
            dataInputStream.close();
            file.delete();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
