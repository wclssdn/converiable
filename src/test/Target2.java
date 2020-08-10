package test;

public class Target2 {

    private Integer integer;
    private Long aLong2;
    private String string;
    private AObject aObject;
    private Boolean aBoolean;
    private ATarget aSource;
    private Float otherName;
    private ATarget aTarget;
    private Integer aNull;
    private Integer noGetter;
    private int aInt;
    private double aDouble;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getaLong2() {
        return aLong2;
    }

    public void setaLong2(Long aLong) {
        this.aLong2 = aLong;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public AObject getaObject() {
        return aObject;
    }

    public void setaObject(AObject aObject) {
        this.aObject = aObject;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public ATarget getaSource() {
        return aSource;
    }

    public void setaSource(ATarget aSource) {
        this.aSource = aSource;
    }

    public Float getOtherName() {
        return otherName;
    }

    public void setOtherName(Float otherName) {
        this.otherName = otherName;
    }

    public ATarget getaTarget() {
        return aTarget;
    }

    public void setaTarget(ATarget aTarget) {
        this.aTarget = aTarget;
    }

    public Integer getaNull() {
        return aNull;
    }

    public void setaNull(Integer aNull) {
        this.aNull = aNull;
    }

    public Integer getNoGetter() {
        return noGetter;
    }

    public void setNoGetter(Integer noGetter) {
        this.noGetter = noGetter;
    }

    public int getaInt() {
        return aInt;
    }

    public void setaInt(int aInt) {
        this.aInt = aInt;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    @Override
    public String toString() {
        return "Target2{" +
                "integer=" + integer +
                ", aLong2=" + aLong2 +
                ", string='" + string + '\'' +
                ", aObject=" + aObject +
                ", aBoolean=" + aBoolean +
                ", aSource=" + aSource +
                ", otherName=" + otherName +
                ", aTarget=" + aTarget +
                ", aNull=" + aNull +
                ", noGetter=" + noGetter +
                ", aInt=" + aInt +
                ", aDouble=" + aDouble +
                '}';
    }
}
