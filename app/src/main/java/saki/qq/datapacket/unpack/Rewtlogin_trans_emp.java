package saki.qq.datapacket.unpack;

public class Rewtlogin_trans_emp extends Rewtlogin_login {
    public Rewtlogin_trans_emp(byte[] bArr) {
        super(bArr);
    }

    public int a() {
        return this.c.readShort();
    }

    public void b() {
    }
}
