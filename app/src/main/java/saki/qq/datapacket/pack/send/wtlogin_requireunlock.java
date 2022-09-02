package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;

public class wtlogin_requireunlock extends wtlogin_login
 {
    public wtlogin_requireunlock(int i2) {
        super(i2);
        //this.k = str;
    }

    private byte[] t0104() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes((byte)1,(byte) 4);
        mark15_classa.writeShort(i.length);
        mark15_classa.writeBytes(i);
        return mark15_classa.getDataAndDestroy();
    }


    public byte[] a(long j2, int i2, long j3) {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeShort(8);
        mark15_classa.writeShort(6);
        mark15_classa.writeBytes(t0008());
        mark15_classa.writeBytes(t0104());
        mark15_classa.writeBytes(t0116());
		mark15_classa.writeBytes(t0174(new byte[0]));
		mark15_classa.writeBytes(t017a(9));
		mark15_classa.writeBytes(t0197(0));
        return mark15_classa.getDataAndDestroy();
    }

	private byte[] t017a(int p0)
	{
		ByteWriter builder = new ByteWriter();
        builder.writeInt(p0);
        builder.rewriteShort((short)builder.length()); //长度
        builder.rewriteBytes(new byte[]{0x01,0x7a});//头部
        return builder.getDataAndDestroy();
	}

	private byte[] t0197(int p0)
	{
		ByteWriter builder = new ByteWriter();
        builder.writeByte(p0);
        builder.rewriteShort((short)builder.length()); //长度
        builder.rewriteBytes(new byte[]{0x01,(byte)0x97});//头部
        return builder.getDataAndDestroy();
	}

	private byte[] t0174(byte[] p0)
	{
		ByteWriter builder = new ByteWriter();
        builder.writeBytes(p0);
        builder.rewriteShort((short)builder.length()); //长度
        builder.rewriteBytes(new byte[]{0x01,0x74});//头部
        return builder.getDataAndDestroy();
	}
}
