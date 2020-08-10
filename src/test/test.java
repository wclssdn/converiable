package test;

import converter.Converter;
import converter.NoConvertibleAnnotationException;
import converter.NoConvertibleTargetException;

public class test {
    public static void main(String[] args) {
        Source source = new Source(1, 2L, "c", new AObject(100), true,
                new ASource(666), 123.456f, new ASource(9), null,
                222, 333, 444);
        Target2 target = new Target2();
        try {
            Converter.convert(source, target);
        } catch (NoConvertibleAnnotationException | NoConvertibleTargetException e) {
            e.printStackTrace();
        }
        System.out.printf("source: %s\n", source.toString());
        System.out.printf("target: %s\n", target.toString());
    }
}
