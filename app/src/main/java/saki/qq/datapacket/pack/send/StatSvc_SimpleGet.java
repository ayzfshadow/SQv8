package saki.qq.datapacket.pack.send;

public class StatSvc_SimpleGet extends T0B01 {
    public StatSvc_SimpleGet(int i) {
        super("StatSvc.SimpleGet");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        byte[] bArr = new byte[4];
        bArr[3] = 4;
        return bArr;
    }
}
