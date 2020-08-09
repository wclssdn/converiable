package test;

import converter.Convertible;

@Convertible(targets = Target.class)
public class Source {
    private Integer integer;
    // 如果源getter比较特殊，可以指定。目标setter比较特殊，也可以指定
    @Convertible(getter = "getaLong", setter = "setaLong")
    private Long aLong;
    private String string;
    private AObject aObject;
    private Boolean aBoolean;
    // 不同的类型,需要注意的是,ASource中也需要使用注解进行处理
    @Convertible(targets = ATarget.class)
    private ASource aSource;
    // 不同的属性名
    @Convertible(field = "otherName")
    private Float aFloat2otherName;
    // 不同的类型 & 不同的属性名
    @Convertible(targets = ATarget.class, field = "aTarget")
    private ASource aSource2target;
    private Integer aNull;
    private Integer noGetter;
    private int aInt;
    private double aDouble;

    public Source(Integer integer, Long aLong, String string, AObject aObject, Boolean aBoolean, ASource aSource,
                  Float aFloat2otherName, ASource aSource2target, Integer aNull, Integer noGetter, int aInt, double aDouble) {
        this.integer = integer;
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
