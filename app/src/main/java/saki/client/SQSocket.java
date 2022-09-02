package saki.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public abstract class SQSocket  {
    private InputStream a;
    private OutputStream b;
    private Socket c;
    private String d;
    private int e;

    public SQSocket(String str, int i) {
        this.d = str;
        this.e = i;
    }

    public void a(IOException iOException) {
        c();
        iOException.printStackTrace();
    }

    public void a(byte[] bArr) throws IOException {
        this.b.write(bArr);
        this.b.flush();
    }

    public abstract byte[] a(InputStream inputStream) throws IOException;

    /* access modifiers changed from: protected */
    public byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new SocketException();
            }
            i2 += read;
        }
        return bArr;
    }

    public abstract void unpack(byte[] bArr);

    public boolean b() {
        try {
            this.c = new Socket(this.d, this.e);
            this.a = this.c.getInputStream();
            new mark8_classo(this, this.a).start();
            this.b = this.c.getOutputStream();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void c() {
        try {
            if (this.a != null) {
                this.a.close();
            }
            if (this.b != null) {
                this.b.close();
            }
            if (this.c != null) {
                this.c.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
