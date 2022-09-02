package saki.qq.datapacket;

import saki.toolkit.ByteReader;
import saki.log.DebugLogger;

public class Info {
    public int seq;
    public String cmd;
    String version;
    byte[] mark;
    byte[] token4c;

    public Info(ByteReader reader) {
        int u = reader.readerIndex();

        reader.readerIndex(u);
        int bodystart = (int) reader.readInt();
        seq = (int) reader.readInt();//序列号
        if (reader.readUnsignedInt() == 0)
        {
            reader.readBytes(4);
        }
        else
        {
            long y =  (int) reader.readUnsignedInt();
            //Log.d("yyyyyyy",y+"");
            reader.readBytes((int)y - 4);//可能是有额外的东西
        }
        cmd = reader.readString((int)reader.readInt() - 4);//包体命令
        reader.readerIndex(bodystart);
    }
    

    public String toString() {
        return "SEQ:" + this.seq + "\r\nCMD:" + this.cmd + "\r\nVER:" + this.version;
    }
}
