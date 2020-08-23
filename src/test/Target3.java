package test;

public class Target3 {

    private int integer;
    private Integer int1;
    private long aLong2;
    private String string;
    private AObject aObject;
    private boolean aBoolean;
    private ATarget aSource;
    private float otherName;
    private ATarget aTarget;
    private Integer aNull;
    private Integer noGetter;
    private int aInt;
    private double aDouble;

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public long getaLong2() {
        return aLong2;
    }

    public void setaLong2(long aLong2) {
        this.aLong2 = aLong2;
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

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public ATarget getaSource() {
        return aSource;
    }

    public void setaSource(ATarget aSource) {
        this.aSource = aSource;
    }

    public float getOtherName() {
        return otherName;
    }

    public void setOtherName(float otherName) {
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
        return "Target3{" +
                "integer=" + integer +
                ", int1=" + int1 +
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
