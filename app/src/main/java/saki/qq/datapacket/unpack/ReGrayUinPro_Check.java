package saki.qq.datapacket.unpack;

import com.qq.taf.jce.JceInputStream;
import saki.toolkit.ByteReader;
import saki.qq.datapacket.pack.packagea.mark16_classd;

public class ReGrayUinPro_Check extends mark14_classap {
    public mark16_classd a = new mark16_classd();

    public ReGrayUinPro_Check(byte[] bArr) {
        super(bArr);
        ByteReader mark10_classd = new ByteReader(bArr);
        mark10_classd.readInt();
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            this.a.readFrom(new JceInputStream(mark10_classd.readRestBytesAndDestroy()));
        }
    }
}
