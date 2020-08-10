package test;

import converter.Convertible;

@Convertible(target = ATarget.class)
public class ASource {
    @Convertible(field = "vv")
    private Integer v;

    public ASource(Integer v) {
        this.v = v;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "ASource{" +
                "v=" + v +
                '}';
    }
}
