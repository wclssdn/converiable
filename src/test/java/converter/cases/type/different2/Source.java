package converter.cases.type.different2;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {

    @Convertible(target = converter.cases.name.different.Target.class)
    converter.cases.name.different.Source source1;

    public converter.cases.name.different.Source getSource1() {
        return source1;
    }

    public void setSource1(converter.cases.name.different.Source source1) {
        this.source1 = source1;
    }
}