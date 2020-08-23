package converter.cases.type.same;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {

    converter.cases.name.same.Source source1;

    public converter.cases.name.same.Source getSource1() {
        return source1;
    }

    public void setSource1(converter.cases.name.same.Source source1) {
        this.source1 = source1;
    }
}