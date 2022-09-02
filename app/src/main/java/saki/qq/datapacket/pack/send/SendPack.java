package saki.qq.datapacket.pack.send;
//     .dicq.   qq.   datapacket.pack.send 

import android.util.Log;
import saki.toolkit.HexToolKit;
import saki.toolkit.Code;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.ByteWriter;

public abstract class SendPack {
    private byte cmdType = (byte)10;
    private byte type = (byte)1;
    private byte[] token44;
    private int seq = -1;
    private long uin;
    ByteWriter pack = new ByteWriter();
    protected String command;
    protected byte[] msgCookie;
    private long appsub;
    private boolean dub;
    private byte[] token4c;
    private String imei;
    private byte[] token14;
    private String version;
    private byte[] key;
    private byte[] publicKey;
    private byte[] cmd;
    private int seqid;

    public SendPack(String var1) {
        this.uin = mark12_classc.c;
        this.appsub = -1L;
        this.dub = true;
        this.msgCookie = new byte[]{113, 8, 62, -19};
        this.seqid = -1;
        this.command = var1;
    }

    private void packCMD(byte var1, byte var2) {
        this.pack.writeByte(0);
        this.pack.writeByte(0);
        this.pack.writeByte(0);
        this.pack.writeByte(var1);
        this.pack.writeByte(var2);
    }

    private void packAppSub(long var1, boolean var3) {
        if (var1 != -1L) {
            this.pack.writeInt(var1);
            if (var3) {
                this.pack.writeInt(var1);
            } else {
                this.pack.writeInt(-1L);
            }

            ByteWriter var4 = this.pack;
            byte[] var5 = new byte[4];
            var5[0] = (byte)1;
            var4.writeBytes(var5);
            this.pack.writeInt(0);
            this.pack.writeInt(0);
        }

    }

    private void packITV(String var1, byte[] var2, String var3) {
        if (var1 != null && var3 != null) {
            this.packImei(var1);
            this.packToken14(var2);
            this.packVersion(var3);
        }

    }

    private void packToken44(byte[] var1, int var2) {
        if (var1 != null) {
            this.pack.writeInt(var1.length + 4);
            this.pack.writeBytes(var1);
        } else if (var2 != -1) {
            this.pack.writeInt(var2);
        } else {
            this.pack.writeInt(4);
        }

    }

    private void encodeContent(byte[] var1, byte[] var2) {
        Log.d("enckey",HexToolKit.bytesToHexString(var2));
        var1 = Code.QQTEAencrypt(var1, var2);
        this.pack.writeBytes(var1);
        this.pack.rewriteSelfIntLength( 4);
    }

    private void packUin(String var1) {
        this.pack.writeByte(0);
        if (var1 == null) {
            this.pack.writeByte(0);
            this.pack.writeInt(1328);
        } else {
            this.pack.writeInt(var1.length() + 4);
            this.pack.writeString(var1);
        }

    }

    private void packRequestionId(int var1) {
        if (var1 != -1) {
            this.pack.writeInt(var1);
        }

    }

    private void packCommand(String var1) {
        this.pack.writeInt(var1.length() + 4);
        this.pack.writeString(var1);
    }

    private void packImei(String var1) {
        if (var1 != null) {
            this.pack.writeInt(var1.length() + 4);
            this.pack.writeString(var1);
        }

    }

    private void packVersion(String var1) {
        if (var1 != null) {
            this.pack.writeShort(var1.length() + 2);
            this.pack.writeString(var1);
        }

    }

    private void packMsgCookie(byte[] var1) {
        if (var1 != null) {
            this.pack.writeInt(var1.length + 4);
            this.pack.writeBytes(var1);
        } else {
            this.pack.writeInt(4);
        }

    }

    private void packToken14(byte[] var1) {
        if (var1 != null) {
            this.pack.writeInt(var1.length + 4);
            this.pack.writeBytes(var1);
        } else {
            this.pack.writeInt(4);
        }

    }

    public void setCmdType(byte var1) {
        this.cmdType = (byte)var1;
    }

    public void setType(int var1) {
        this.type = (byte)((byte)var1);
    }

    public void setUin(long var1) {
        this.uin = var1;
    }

    public void packContent(long var1, byte[] var3, byte[] var4, byte[] var5, byte[] var6) {
        if (var3 != null && var4 != null && var5 != null) {
            ByteWriter var7 = new ByteWriter();
            var7.writeBytes(new byte[]{31, 65});
            var7.writeBytes(var3);
            var3 = new byte[]{0, (byte)1};
            var7.writeBytes(var3);
            var7.writeInt(var1);
            var3 = new byte[17];
            var3[0] = (byte)3;
            var3[1] = (byte)7;//改成7就是不需要二次协商 135就是需要二次协商
            var3[6] = (byte)2;
            var3[15] = (byte)1;
            var3[16] = (byte)1;
            var7.writeBytes(var3);
            var7.writeBytes(var4);
            var7.writeBytes(new byte[]{1, 2});
            var7.writeShort(var5.length);
            var7.writeBytes(var5);
            var7.writeBytes(var6);
            var7.rewriteSelfShortLength(4);
            var7.rewriteBytes(new byte[]{2});
            var7.rewriteSelfIntLength( 5);
            var7.writeByte(3);
            this.pack.writeBytes(var7.getDataAndDestroy());
        } else {
            this.pack.writeInt(var6.length + 4);
            this.pack.writeBytes(var6);
        }

    }

    public void setImei(String var1) {
        this.imei = var1;
    }

    public void setToken44(byte[] var1) {
        this.token44 = var1;
    }

    protected abstract byte[] getContent();

    protected void packInfo() {
        this.packRequestionId(this.seqid);
        this.packAppSub(this.appsub, this.dub);
        this.packToken4c(this.token4c);
        this.packCommand(this.command);
        this.packMsgCookie(this.msgCookie);
        this.packITV(this.imei, this.token14, this.version);
        this.pack.writeInt(4);
        this.pack.rewriteSelfIntLength( 4);
        this.packContent();
    }

    public void setSeq(int var1) {
        this.seq = var1;
    }

    public void setAppsub(long var1) {
        this.appsub = var1;
    }

    public void setVersion(String var1) {
        this.version = var1;
    }

    public void setToken4c(byte[] var1) {
        this.token4c = var1;
    }

    public void setRequestId(int var1) {
        this.seqid = var1;
    }

    public void setKey(byte[] var1) {
        this.key = var1;
    }

    public byte[] toByteArray() {
        if (this.pack.isEmpty()) {
            this.packInfo();
            this.packHead();
        }
        return this.pack.getDataAndDestroy();
    }

    public void setPublicKey(byte[] var1) {
        this.publicKey = var1;
    }

    protected abstract byte[] encryptKey();

    public int getSeq() {
        return this.seq;
    }

    public void setCmd(byte[] var1) {
        this.cmd = var1;
    }

    public long getUin() {
        return this.uin;
    }

    protected void packToken4c(byte[] var1) {
        if (var1 != null) {
            this.pack.writeInt(var1.length + 4);
            this.pack.writeBytes(var1);
        } else {
            this.pack.writeInt(4);
        }

    }

    protected void packHead() {
        byte[] var2 = this.pack.getDataAndDestroy();
        this.pack.recreate();
        this.packCMD(this.cmdType, this.type);
        this.packToken44(this.token44, this.seq);
        String var1;
        if (this.uin == -1L) {
            var1 = null;
        } else {
            var1 = String.valueOf(this.uin);
        }

        this.packUin(var1);
        this.encodeContent(var2, this.encryptKey());
    }

    protected void packContent() {
        this.packContent(this.uin, this.cmd, this.key, this.publicKey, this.getContent());
    }
}


