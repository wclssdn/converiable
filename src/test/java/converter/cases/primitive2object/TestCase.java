package converter.cases.primitive2object;

import converter.Converter;
import converter.NoConvertibleAnnotationException;
import converter.NoConvertibleTargetException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCase {

    @Test
    public void testSameProperties() {
        Source source = new Source();
        source.setBoolean1(true);
        source.setByte1(new Byte("68"));
        source.setCharacter1('b');
        source.setDouble1(1.23);
        source.setFloat1(2.34F);
        source.setInt1(123);
        source.setLong1(234L);
        source.setShort1((short) 2);

        Target target = new Target();
        try {
            Converter.convert(source, target);
            assertEquals(source.isBoolean1(), target.getBoolean1());
            assertEquals(source.getByte1(), target.getByte1());
            assertEquals(source.getCharacter1(), target.getCharacter1());
            assertEquals(source.getDouble1(), target.getDouble1());
            assertEquals(source.getFloat1(), target.getFloat1());
            assertEquals(source.getInt1(), target.getInt1());
            assertEquals(source.getLong1(), target.getLong1());
            assertEquals(source.getShort1(), target.getShort1());
        } catch (NoConvertibleAnnotationException | NoConvertibleTargetException e) {
            fail(e.getMessage());
        }
    }
}
