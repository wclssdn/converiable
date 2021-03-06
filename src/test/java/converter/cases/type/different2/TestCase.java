package converter.cases.type.different2;

import converter.Converter;
import converter.NoConvertibleAnnotationException;
import converter.NoConvertibleTargetException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCase {

    @Test
    public void testDifferentTypes2() {
        Source source = new Source();
        converter.cases.name.different.Source source1 = new converter.cases.name.different.Source();
        source1.setBoolean1(true);
        source1.setByte1(new Byte("68"));
        source1.setCharacter1('b');
        source1.setDouble1(1.23);
        source1.setFloat1(2.34F);
        source1.setInt1(123);
        source1.setLong1(234L);
        source1.setShort1((short) 2);
        source.setSource1(source1);

        Target target = new Target();
        try {
            Converter.convert(source, target);
            assertEquals(source.source1.getBoolean1(), target.source1.getBoolean2());
            assertEquals(source.source1.getByte1(), target.source1.getByte2());
            assertEquals(source.source1.getCharacter1(), target.source1.getCharacter2());
            assertEquals(source.source1.getDouble1(), target.source1.getDouble2());
            assertEquals(source.source1.getFloat1(), target.source1.getFloat2());
            assertEquals(source.source1.getInt1(), target.source1.getInt2());
            assertEquals(source.source1.getLong1(), target.source1.getLong2());
            assertEquals(source.source1.getShort1(), target.source1.getShort2());
        } catch (NoConvertibleAnnotationException | NoConvertibleTargetException e) {
            fail(e.getMessage());
        }
    }
}
