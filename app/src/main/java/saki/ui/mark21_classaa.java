package saki.ui;

class mark21_classaa implements Runnable {
    final /* synthetic */ GroupListView a;

    mark21_classaa(GroupListView mark21_classz) {
        this.a = mark21_classz;
    }

    public void run() {
        this.a.swipeRefreshLayout.setRefreshing(false);
    }
}
