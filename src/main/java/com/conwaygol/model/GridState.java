
package com.conwaygol.model;

public class GridState {
    private int num;
    private String view;

    public GridState() {
    }

    public GridState(int num, String view) {
        this.num = num;
        this.view = view;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }


}
