package converter.cases.type.different3;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {

    @Convertible(target = converter.cases.object2primitive.Target.class)
    converter.cases.object2primitive.Source source1;

    public converter.cases.object2primitive.Source getSource1() {
        return source1;
    }

    public void setSource1(converter.cases.object2primitive.Source source1) {
        this.source1 = source1;
    }
}