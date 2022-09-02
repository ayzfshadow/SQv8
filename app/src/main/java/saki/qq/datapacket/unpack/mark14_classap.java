package saki.qq.datapacket.unpack;

import saki.qq.datapacket.Info;
import saki.packaged.mark20_classk;

public abstract class mark14_classap {
    protected byte[] k;
    public Info l;

    public mark14_classap(byte[] bArr) {
        this.k = bArr;
    }

    public mark14_classap a(Info mark13_classa) {
        this.l = mark13_classa;
        return this;
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) {
        if (bArr.length < 2) {
            return bArr;
        }
        if (bArr[0] == 120 && bArr[1] == -38) {
            return mark20_classk.b(bArr);
        }
        if (bArr[0] != 1 || bArr[1] != 120) {
            return bArr;
        }
        byte[] bArr2 = new byte[(bArr.length - 1)];
        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
        return mark20_classk.b(bArr2);
    }
}
