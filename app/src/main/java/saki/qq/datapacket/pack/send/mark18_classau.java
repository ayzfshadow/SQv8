package saki.qq.datapacket.pack.send;

import saki.qq.global.ProtocolInfo;

public abstract class mark18_classau extends SendPack {
    public mark18_classau(String str) {
        super(str);
        setType(2);
    }

    /* access modifiers changed from: protected */
    public byte[] encryptKey() {
        return ProtocolInfo.a;
    }
}
