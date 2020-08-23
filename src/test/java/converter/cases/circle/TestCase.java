package converter.cases.circle;

import converter.Converter;
import converter.NoConvertibleAnnotationException;
import converter.NoConvertibleTargetException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCase {

    @Test
    public void testSameTypes() {
        Source source = new Source();
        Source source1 = new Source();
        source.setSource1(source1);

        Target target = new Target();
        try {
            Converter.convert(source, target);
            assertEquals(source1, target.getSource1());
        } catch (NoConvertibleAnnotationException | NoConvertibleTargetException e) {
            fail(e.getMessage());
        }
    }
}
