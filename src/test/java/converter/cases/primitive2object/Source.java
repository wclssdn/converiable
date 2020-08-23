package converter.cases.primitive2object;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {
    int int1;
    short short1;
    long long1;
    char character1;
    float float1;
    double double1;
    byte byte1;
    boolean boolean1;

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public short getShort1() {
        return short1;
    }

    public void setShort1(short short1) {
        this.short1 = short1;
    }

    public long getLong1() {
        return long1;
    }

    public void setLong1(long long1) {
        this.long1 = long1;
    }

    public char getCharacter1() {
        return character1;
    }

    public void setCharacter1(char character1) {
        this.character1 = character1;
    }

    public float getFloat1() {
        return float1;
    }

    public void setFloat1(float float1) {
        this.float1 = float1;
    }

    public double getDouble1() {
        return double1;
    }

    public void setDouble1(double double1) {
        this.double1 = double1;
    }

    public byte getByte1() {
        return byte1;
    }

    public void setByte1(byte byte1) {
        this.byte1 = byte1;
    }

    public boolean isBoolean1() {
        return boolean1;
    }

    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
    }
}