package converter.cases.mixed;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {
    @Convertible(field = "int2")
    Integer int1;
    @Convertible(field = "short2")
    Short short1;
    @Convertible(field = "long2")
    Long long1;
    @Convertible(field = "character2")
    Character character1;
    @Convertible(field = "float2")
    Float float1;
    @Convertible(field = "double2")
    Double double1;
    @Convertible(field = "byte2")
    Byte byte1;
    @Convertible(field = "boolean2")
    Boolean boolean1;
    @Convertible(field = "string2")
    String string1;

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public Short getShort1() {
        return short1;
    }

    public void setShort1(Short short1) {
        this.short1 = short1;
    }

    public Long getLong1() {
        return long1;
    }

    public void setLong1(Long long1) {
        this.long1 = long1;
    }

    public Character getCharacter1() {
        return character1;
    }

    public void setCharacter1(Character character1) {
        this.character1 = character1;
    }

    public Float getFloat1() {
        return float1;
    }

    public void setFloat1(Float float1) {
        this.float1 = float1;
    }

    public Double getDouble1() {
        return double1;
    }

    public void setDouble1(Double double1) {
        this.double1 = double1;
    }

    public Byte getByte1() {
        return byte1;
    }

    public void setByte1(Byte byte1) {
        this.byte1 = byte1;
    }

    public Boolean getBoolean1() {
        return boolean1;
    }

    public void setBoolean1(Boolean boolean1) {
        this.boolean1 = boolean1;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string) {
        this.string1 = string;
    }

}