package cn.li.dto;

public class ResponseData {
    private int state;

    private  String info;

    private Object object;

    public ResponseData(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public ResponseData(int state, String info, Object object) {

        this.state = state;
        this.info = info;
        this.object = object;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
