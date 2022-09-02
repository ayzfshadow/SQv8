package saki.ui.packagec;

class mark24_classb implements CharSequence {
    char[] a = {9312, 9313, 9314, 9315, 9316, 9317, 9318, 9319, 9320, 9321, 9322, 9323, 9324, 9325, 9326, 9327, 9328, 9329, 9330, 9331};
    final /* synthetic */ mark24_classa b;
    private CharSequence c;

    public mark24_classb(mark24_classa mark24_classa, CharSequence charSequence) {
        this.b = mark24_classa;
        this.c = charSequence;
    }

    public char charAt(int i) {
        return this.a[i % this.a.length];
    }

    public int length() {
        return this.c.length();
    }

    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }
}
