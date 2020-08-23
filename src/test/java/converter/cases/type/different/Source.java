package converter.cases.type.different;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {

    @Convertible(target = converter.cases.name.same.Target.class)
    converter.cases.name.same.Source source1;

    public converter.cases.name.same.Source getSource1() {
        return source1;
    }

    public void setSource1(converter.cases.name.same.Source source1) {
        this.source1 = source1;
    }
}