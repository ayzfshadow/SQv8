package saki.toolkit;

public class mark10_classc {
    private static long a = 2654435769L;
    private long b;
    private long c;
    private long d;
    private long e;
    private int f = 32;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length % 8 != 0) {
            return new byte[0];
        }
        mark10_classc mark10_classc = new mark10_classc();
        if (!mark10_classc.a(bArr2)) {
            return new byte[0];
        }
        mark10_classc.a(16);
        return mark10_classc.b(bArr);
    }

    private byte[] b(byte[] bArr) {
        long c2 = HexToolKit.c(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]});
        long c3 = HexToolKit.c(new byte[]{bArr[4], bArr[5], bArr[6], bArr[7]});
        long j = this.f == 32 ? -957401312 : this.f == 16 ? -478700656 : a * ((long) this.f);
        for (int i = 0; i < this.f; i++) {
            c3 = HexToolKit.a(c3 - HexToolKit.a((HexToolKit.a(HexToolKit.a(c2 << 4) + this.d) ^ HexToolKit.a(c2 + j)) ^ HexToolKit.a((c2 >> 5) + this.e)));
            c2 = HexToolKit.a(c2 - HexToolKit.a((HexToolKit.a(HexToolKit.a(c3 << 4) + this.b) ^ HexToolKit.a(c3 + j)) ^ HexToolKit.a((c3 >> 5) + this.c)));
            j = HexToolKit.a(j - a);
        }
        byte[] a2 = HexToolKit.UsignedInt2Bytes(c2, 4);
        byte[] a3 = HexToolKit.UsignedInt2Bytes(c3, 4);
        return new byte[]{a2[0], a2[1], a2[2], a2[3], a3[0], a3[1], a3[2], a3[3]};
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        mark10_classc mark10_classc = new mark10_classc();
        if (!mark10_classc.a(bArr2)) {
            return new byte[0];
        }
        mark10_classc.a(16);
        return mark10_classc.c(bArr);
    }

    private byte[] c(byte[] bArr) {
        long c2 = HexToolKit.c(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]});
        long c3 = HexToolKit.c(new byte[]{bArr[4], bArr[5], bArr[6], bArr[7]});
        long j = 0;
        for (int i = 0; i < this.f; i++) {
            j = HexToolKit.a(j + a);
            c2 = HexToolKit.a(c2 + HexToolKit.a((HexToolKit.a(HexToolKit.a(c3 << 4) + this.b) ^ HexToolKit.a(c3 + j)) ^ HexToolKit.a((c3 >> 5) + this.c)));
            c3 = HexToolKit.a(c3 + HexToolKit.a((HexToolKit.a(HexToolKit.a(c2 << 4) + this.d) ^ HexToolKit.a(c2 + j)) ^ HexToolKit.a((c2 >> 5) + this.e)));
        }
        byte[] a2 = HexToolKit.UsignedInt2Bytes(c2, 4);
        byte[] a3 = HexToolKit.UsignedInt2Bytes(c3, 4);
        return new byte[]{a2[0], a2[1], a2[2], a2[3], a3[0], a3[1], a3[2], a3[3]};
    }

    public boolean a(int i) {
        switch (i) {
            case 16:
            case 32:
            case 64:
                this.f = i;
                return true;
            default:
                return false;
        }
    }

    public boolean a(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return false;
        }
        this.b = HexToolKit.c(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]});
        this.c = HexToolKit.c(new byte[]{bArr[4], bArr[5], bArr[6], bArr[7]});
        this.d = HexToolKit.c(new byte[]{bArr[8], bArr[9], bArr[10], bArr[11]});
        this.e = HexToolKit.c(new byte[]{bArr[12], bArr[13], bArr[14], bArr[15]});
        return true;
    }
}
