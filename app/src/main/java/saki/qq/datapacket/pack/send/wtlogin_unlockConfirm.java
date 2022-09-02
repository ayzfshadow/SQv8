package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.toolkit.Code;

public class wtlogin_unlockConfirm extends wtlogin_login
{

	
    public wtlogin_unlockConfirm(int i2) {
        super(i2);
        
    }

    private byte[] t0104() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes((byte)1,(byte) 4);
        mark15_classa.writeShort(i.length);
        mark15_classa.writeBytes(i);
        return mark15_classa.getDataAndDestroy();
    }

	public static byte[] t017c(String code)
	{
		ByteWriter builder = new ByteWriter();
        builder.writeBytesByShortLength(code.getBytes());
        builder.rewriteShort((short)builder.length()); //长度
        builder.rewriteBytes(new byte[]{0x01,0x7C});//头部
		return builder.getDataAndDestroy();
	}

	public static byte[] t401(byte[] guid,byte[] token0402,byte[] dpwd)
    {
        ByteWriter builder = new ByteWriter();
        ByteWriter builder2  = new ByteWriter();
        builder2.writeBytes(guid);
        builder2.writeBytes(dpwd);
        builder2.writeBytes(token0402);
        builder.writeBytes(Code.md5(builder2.getDataAndDestroy()));
        builder.rewriteShort((short)builder.length()); //长度
        builder.rewriteBytes(new byte[]{0x04,0x01});//头部
		return builder.getDataAndDestroy();
    }



    public byte[] a(long j2, int i2, long j3) {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeShort(20);
        mark15_classa.writeShort(4);
        mark15_classa.writeBytes(t0008());
        mark15_classa.writeBytes(t0104());
        mark15_classa.writeBytes(t0116());
		mark15_classa.writeBytes(t401(new byte[16],new byte[16],new byte[16]));
		
        return mark15_classa.getDataAndDestroy();
    }





	private byte[] t0198(int p0)
	{
		ByteWriter builder = new ByteWriter();
        builder.writeByte(p0);
        builder.rewriteShort((short)builder.length()); //长度
        builder.rewriteBytes(new byte[]{0x01,(byte)0x98});//头部
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
