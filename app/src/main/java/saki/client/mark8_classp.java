package saki.client;

public class mark8_classp extends Thread {
    private mark8_classq a;
    private long b;

    public mark8_classp(long j, mark8_classq mark8_classq) {
        this.b = j;
        this.a = mark8_classq;
    }

    public void run() {
        try {
            sleep(this.b);
            this.a.e();
        } catch (InterruptedException e) {
        }
    }
}
