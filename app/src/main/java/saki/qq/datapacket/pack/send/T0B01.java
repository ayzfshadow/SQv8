package saki.qq.datapacket.pack.send;

import saki.qq.global.ProtocolInfo;

public abstract class T0B01 extends SendPack {
    public T0B01(String str) {
        super(str);
        setCmdType((byte) 11);
    }

    /* access modifiers changed from: protected */
    public byte[] encryptKey() {
        return ProtocolInfo.g;
    }

    /* access modifiers changed from: protected */
    public void packToken4c(byte[] bArr) {
    }
}
