package test;

public class AObject {
    private Integer x;

    public AObject(Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "AObject{" +
                "x=" + x +
                '}';
    }
}
