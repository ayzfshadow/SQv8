package saki.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import saki.qq.datapacket.QQUnPacket;
import saki.qq.datapacket.mark13_classc;
import saki.qq.global.ProtocolInfo;

public class ClientSocket extends MainSocket
{


    @Override
    public void unpack(ByteBuf bArr)
    {
        byte[] h = new byte[bArr.readableBytes()];
        bArr.readBytes(h);
        this.unpack(h);
    }

    /* access modifiers changed from: private */
    public mark8_classa a;

    public ClientSocket(mark8_classa mark8_classk)
    {
        super("msfwifi.3g.qq.com", 8080);
        this.a = mark8_classk;
    }



    @Override public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        super.channelActive(ctx);
        if (this.a.islogined)
        {
            send(new saki.qq.datapacket.pack.send.OidbSvc_0x59f(this.a.c()).toByteArray());
        }
    }



    public void unpack(final byte[] bArr)
    {

        Thread thread = new Thread(){
            public void run()
            {
                try
                {
                    ClientSocket.this.a.a(QQUnPacket.unPacket(bArr));
                }
                catch (mark13_classc e)
                {
                    e.printStackTrace();
                }
            }
        };
        if (ProtocolInfo.enablemultithread){
            thread.start();
        }else{
            thread.run();
        }


    }

    public boolean isconnected()
    {
        boolean b2 = super.isconneced();

        return b2;
    }


}
