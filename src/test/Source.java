package test;

import converter.Convertible;

@Convertible(target = Target.class)
@Convertible(target = Target2.class)
@Convertible(target = Target3.class)
public class Source {
    private Integer integer;
    private int int1;
    // 转换为不同对象时，目标属性名称不同
    @Convertible(when = Target2.class, field = "aLong2")
    @Convertible(when = Target3.class, field = "aLong2")
    private Long aLong;
    private String string;
    private AObject aObject;
    private Boolean aBoolean;
    // 不同的类型,需要注意的是,ASource中也需要使用注解进行处理
    @Convertible(target = ATarget.class)
    private ASource aSource;
    // 不同的属性名
    @Convertible(field = "otherName")
    private Float aFloat2otherName;
    // 不同的类型 & 不同的属性名
    @Convertible(target = ATarget.class, field = "aTarget")
    private ASource aSource2target;
    private Integer aNull;
    private Integer noGetter;
    private int aInt;
    private double aDouble;

    public Source(Integer integer, int int1, Long aLong, String string, AObject aObject, Boolean aBoolean, ASource aSource,
                  Float aFloat2otherName, ASource aSource2target, Integer aNull, Integer noGetter, int aInt, double aDouble) {
        this.integer = integer;
        this.int1 = int1;
        this.aLong = aLong;
        this.string = string;
        this.aObject = aObject;
        this.aBoolean = aBoolean;
        this.aSource = aSource;
        this.aFloat2otherName = aFloat2otherName;
        this.aSource2target = aSource2target;
        this.aNull = aNull;
        this.noGetter = noGetter;
        this.aInt = aInt;
        this.aDouble = aDouble;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
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

    public ASource getaSource() {
        return aSource;
    }

    public void setaSource(ASource aSource) {
        this.aSource = aSource;
    }

    public Float getaFloat2otherName() {
        return aFloat2otherName;
    }

    public void setaFloat2otherName(Float aFloat2otherName) {
        this.aFloat2otherName = aFloat2otherName;
    }

    public ASource getaSource2target() {
        return aSource2target;
    }

    public void setaSource2target(ASource aSource2target) {
        this.aSource2target = aSource2target;
    }

    public Integer getaNull() {
        return aNull;
    }

    public void setaNull(Integer aNull) {
        this.aNull = aNull;
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
        return "Source{" +
                "integer=" + integer +
                ", int1=" + int1 +
                ", aLong=" + aLong +
                ", string='" + string + '\'' +
                ", aObject=" + aObject +
                ", aBoolean=" + aBoolean +
                ", aSource=" + aSource +
                ", aFloat2otherName=" + aFloat2otherName +
                ", aSource2target=" + aSource2target +
                ", aNull=" + aNull +
                ", noGetter=" + noGetter +
                ", aInt=" + aInt +
                ", aDouble=" + aDouble +
                '}';
    }
}
