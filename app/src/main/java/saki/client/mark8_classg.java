package saki.client;

import java.io.InputStream;
import saki.toolkit.HexToolKit;
import saki.qq.global.ImgStore;
import saki.qq.datapacket.pack.send.PicUp_DataUp;
import java.io.IOException;

public class mark8_classg extends SQSocket {
    ImgStore a;
  
    mark8_classa c;
    mark8_classh d;

    public mark8_classg(mark8_classa mark8_classa, ImgStore mark12_classe, mark8_classh mark8_classh) {
        super("htdata.qq.com", 8080);
        this.a = mark12_classe;
        
        this.c = mark8_classa;
        this.d = mark8_classh;
        b();
    }

    public void a(byte[] bArr) throws IOException {
        super.a(new PicUp_DataUp(this.a.a, bArr).a());
    }

    public byte[] a(InputStream inputStream) throws IOException {
        int read;
        do {
            read = inputStream.read();
            if (read == -1) {
                return null;
            }
        } while (read != 40);
        int b2 = HexToolKit.b(a(inputStream, 4));
        HexToolKit.b(a(inputStream, 4));
        return a(inputStream, b2);
    }

    public void unpack(byte[] bArr) {
        this.d.a(this.a);
        c();
    }
}
