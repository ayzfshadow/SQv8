package saki.qq.global;

public class mark12_classd {
    byte[] a;

    public void a(byte[] bArr) {
        this.a = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = this.a;
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return sb.toString();
    }
}
