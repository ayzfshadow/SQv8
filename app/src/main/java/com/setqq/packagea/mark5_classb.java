package com.setqq.packagea;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import android.content.pm.PackageManager.NameNotFoundException;

public class mark5_classb {
    final byte[] a = {-42, -67, 113, -100, -86, -79, 24, -66, 84, 59, 36, 105, 19, -32, -93, 102};
    private Context b;

    public mark5_classb(Context context) {
        this.b = context;
    }

    public boolean a() {
        try {
            byte[] b2 = b();
            for (int i = 0; i < b2.length; i++) {
                if (i >= this.a.length || b2[i] != this.a[i]) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public void b(byte[] bArr) {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
            x509Certificate.getPublicKey().toString();
            x509Certificate.getSerialNumber().toString();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    public byte[] b() throws PackageManager.NameNotFoundException {
        Signature signature = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures[0];
        byte[] a2 = a(signature.toByteArray());
        b(signature.toByteArray());
        return a2;
    }
}
