package rootming.tjzhic.Data;

import java.util.LinkedList;

/**
 * Created by rootm on 2017/3/12.
 */
public class Page<T> {
    private int page;
    private LinkedList<T> state;

    public Page() {

    }

    public Page(int page, LinkedList<T> state) {
        this.page = page;
        this.state = state;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public LinkedList<T> getState() {
        return state;
    }

    public void setState(LinkedList<T> state) {
        this.state = state;
    }
}