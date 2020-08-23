package converter.cases.circle;

import converter.Convertible;

@Convertible(target = Target.class)
public class Source {

    Source source1;

    public Source getSource1() {
        return source1;
    }

    public void setSource1(Source source1) {
        this.source1 = source1;
    }
}