package saki.qq.datapacket.unpack;

import android.util.Log;
import saki.qq.datapacket.pack.send.mark18_classbc;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classc;
import saki.qq.global.mark12_classj;
import saki.toolkit.ByteReader;
import saki.toolkit.Code;
import saki.toolkit.HexToolKit;
import saki.toolkit.TeaCryptor;
import saki.qq.datapacket.pack.send.wtlogin_login;

public class Rewtlogin_login extends mark14_classap {
    public int result = 0;
    public byte[] b;
    protected ByteReader c;
    public String d = "";
    private int e;
	
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Rewtlogin_login(byte[] bArr) {
        super(bArr);
        this.c = new ByteReader(bArr);
        b();
        this.e = a();
        for (int i = 0; i < this.e; i++) {
            a(this.c.readBytes(2), this.c.readBytes((int) this.c.readShort()));
        }
        this.c.destroy();
    }

    public int a() {
        this.c.readShort();
        this.c.readBytes(1);
        return this.c.readShort();
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, byte[] bArr2) {
	
        if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0114)) {
            ProtocolInfo.e = bArr2;
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t010A)) {
            mark12_classj.a = bArr2;
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0114)) {
            ByteReader mark10_classd = new ByteReader(bArr2);
            mark10_classd.readShort();
            mark10_classd.readInt();
            mark12_classj.b = mark10_classd.readBytes((int) mark10_classd.readShort());
            mark10_classd.destroy();
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0305)) {
            ProtocolInfo.g = bArr2;
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0119)) {
            ByteReader mark10_classd2 = new ByteReader(Code.a(bArr2, ProtocolInfo.f));
            short b2 = (short) mark10_classd2.readShort();
            for (int i = 0; i < b2; i++) {
                a(mark10_classd2.readBytes(2), mark10_classd2.readBytes((int) mark10_classd2.readShort()));
            }
            mark10_classd2.destroy();
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0192)) {
            this.b = bArr2;
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0108)) {
            mark12_classc.f.a(bArr2);
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0104)) {
            wtlogin_login.i = bArr2;
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0143)) {
            mark12_classj.c = bArr2;
        } else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0146)) {
            ByteReader mark10_classd4 = new ByteReader(bArr2);
            mark10_classd4.readInt();
            String str = new String(mark10_classd4.readBytes((int) mark10_classd4.readShort()));
            this.d = "[" + str + "]:" + new String(mark10_classd4.readBytes((int) mark10_classd4.readShort()));
            mark10_classd4.destroy();
        }else if (ByteReader.bytesEqulsBytes(bArr, mark14_classam.t0178)) {
			ByteReader br=new ByteReader(bArr2);
			ProtocolInfo.phone =br.readStringByShortLength()+" "+br.readStringByShortLength();
	    }
    }

    public void b() {
       // Log.d("gggggg",HexToolKit.bytesToHexString(this.c.readRestBytes()));
        this.c.readInt();
        this.c.readBytes(1);
        this.c.readShort();
        this.c.readBytes(2);
        this.c.readBytes(2);
        this.c.readShort();
        this.c.readBytes(4);
        this.c.readShort();
        this.result = this.c.readBytes(1)[0];
        byte[] f=this.c.readBytesAndDestroy(this.c.restByteCount() - 1);
		//Log.d("hhhhh",HexToolKit.bytesToHexString(f));
		
        TeaCryptor cry= new TeaCryptor();
        byte[] o =cry.decrypt(f, ProtocolInfo.sharekey);
//        this.c.update(o);
//        byte[] serverpubkey=this.c.readBytesByShortLength();
//        ByteWriter ttt = new ByteWriter();
//        ttt.writeBytes(ProtocolInfo.sharekey)
//            .writeBytes(serverpubkey);
//        String data = HexToolKit.bytesToHexString(cry.encrypt(ttt.getDataAndDestroy(),ProtocolInfo.crckey));
//        byte[] kkkk = new mark3_classb().a("http://69.85.84.59:9999/boobs/boobserver?cmd=getbigboobs&data="+data);
//        byte[] iiii = new TeaCryptor().decrypt(kkkk,ProtocolInfo.crckey);
//        o =cry.decrypt(this.c.readRestBytesAndDestroy(), iiii);
//        
        cry.destroy();
        this.c.update(o);
        
    }
}
