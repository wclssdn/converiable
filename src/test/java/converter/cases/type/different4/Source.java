package converter.cases.type.different4;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {

    @Convertible(target = converter.cases.primitive2object.Target.class)
    converter.cases.primitive2object.Source source1;

    public converter.cases.primitive2object.Source getSource1() {
        return source1;
    }

    public void setSource1(converter.cases.primitive2object.Source source1) {
        this.source1 = source1;
    }
}