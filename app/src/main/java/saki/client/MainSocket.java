package saki.client;

import android.util.Log;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import saki.log.Logger;

@ChannelHandler.Sharable public abstract class MainSocket extends ChannelInboundHandlerAdapter
{
    public static ByteBufAllocator alloc = PooledByteBufAllocator.DEFAULT;
    
    private String d;
    private int e;
    protected Thread nettyclient = new Thread(new nettyclient());
    
    public ChannelHandlerContext ctx;
    
    public MainSocket(String str, int i)
    {
        this.d = str;
        this.e = i;
        this.nettyclient.start();
    }

    @Override public void exceptionCaught(io.netty.channel.ChannelHandlerContext ctx, java.lang.Throwable cause) throws java.lang.Exception
    {
        Log.d("chanel", "Exception");
        cause.printStackTrace();
	}
    
    
    @Override public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        Log.d("chanelactive", "");
        this.ctx = ctx;
    }

    @Override public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        Log.d("chanelinactive", "");

    }
    @Override public void channelRead(ChannelHandlerContext ctx, final Object buf)
    throws Exception
    {
        if (buf instanceof ByteBuf)
        {
            try
            {
                unpack((ByteBuf)buf);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    

    protected boolean isconneced()
    {
        return ctx.channel().isActive();
    }

    
    protected void send(byte[] data)
    {
        ByteBuf h  = alloc.directBuffer();
        h.writeBytes(data);
        this.ctx.writeAndFlush(h);
    }

    protected void stop()
    {
        this.ctx.close();
    }

    

    private class nettyclient implements Runnable
    {

        private Bootstrap bootstrap;

        private EventLoopGroup eventLoopGroup;


        @Override public void run()
        {
            this.eventLoopGroup = new NioEventLoopGroup();
            this.bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.group(eventLoopGroup);
            bootstrap.remoteAddress(d, e);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel)
                    throws Exception
                    { 
                        socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024 * 50, 0, 4, -4, 0))
                            .addLast(MainSocket.this);
                    }
                });
            connect();

        }
        
        private void connect()
        {
            try
            {
                ChannelFuture future = bootstrap.connect(d, e).sync();
                future.channel().closeFuture().sync();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    Logger.c("尝试重新连接");
                    Thread.currentThread().sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                connect();
            }


        }
        

    }
    
    
    public abstract void unpack(ByteBuf bArr);

    

    
}
