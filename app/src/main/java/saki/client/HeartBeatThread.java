package saki.client;

import saki.qq.datapacket.pack.send.StatSvc_SimpleGet;

class HeartBeatThread implements Runnable
{
    final /* synthetic */ mark8_classa a;

    HeartBeatThread(mark8_classa mark8_classa)
    {
        this.a = mark8_classa;
    }

    public void run()
    {

        this.a.b(new StatSvc_SimpleGet(this.a.c()));

        
    }
}
