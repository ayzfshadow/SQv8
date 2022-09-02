package saki.packaged;

class mark20_classd implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ mark20_classb b;
    private final /* synthetic */ String c;

    mark20_classd(int i, mark20_classb mark20_classb, String str) {
        this.a = i;
        this.b = mark20_classb;
        this.c = str;
    }

    public void run() {
        if (this.a == 0) {
            this.b.a(mark20_classc.b(this.c, true));
        } else {
            this.b.a(mark20_classc.a(this.c, true));
        }
    }
}
