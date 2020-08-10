# 对象转换工具

## 快速使用

源类：`Source` 和目标类：`Target`属性几乎无异，但是也存在一定不同。需要转换的时候，可以使用`@Convertible`注解实现。

```java
// 支持写多个注解
@Convertible(target = Target.class)
@Convertible(target = Target2.class)
public class Source {
    private Integer integer;
    // 转换为不同对象时，目标属性名称不同
    @Convertible(when = Target2.class, field = "aLong2")
    private Long aLong;
    private String string;
    private AObject aObject;
    private Boolean aBoolean;
    // 不同的类型,需要注意的是,ASource中也需要使用注解进行处理
    @Convertible(target = ATarget.class)
    private ASource aSource;
    // 不同的属性名
    @Convertible(field = "otherName")
    private Float aFloat2otherName;
    // 不同的类型 & 不同的属性名
    @Convertible(target = ATarget.class, field = "aTarget")
    private ASource aSource2target;
    private Integer aNull;
    private Integer noGetter;
    private int aInt;
    private double aDouble;
}
```

目标类：

```java
public class Target2 {
    private Integer integer;
    private Long aLong2;
    private String string;
    private AObject aObject;
    private Boolean aBoolean;
    private ATarget aSource;
    private Float otherName;
    private ATarget aTarget;
    private Integer aNull;
    private Integer noGetter;
    private int aInt;
    private double aDouble;
}
```

属性`aSource`源类：

```java
@Convertible(target = ATarget.class)
public class ASource {
    @Convertible(field = "vv")
    private Integer v;
}
```

属性`aSource`目标类：

```java
public class ATarget {
    private Integer vv;
}
```

使用方式：

```java
public class test {
    public static void main(String[] args) {
        Source source = new Source(1, 2L, "c", new AObject(100), true,
                new ASource(666), 123.456f, new ASource(9), null,
                222, 333, 444);
        Target target = new Target();
        try {
            Converter.convert(source, target);
        } catch (NoConvertibleAnnotationException | NoConvertibleTargetException e) {
            e.printStackTrace();
        }
        System.out.printf("source: %s\n", source.toString());
        System.out.printf("target: %s\n", target.toString());
    }
}
```

结果：

```text
source: Source{integer=1, aLong=2, string='c', aObject=AObject{x=100}, aBoolean=true, aSource=ASource{v=666}, aFloat2otherName=123.456, aSource2target=ASource{v=9}, aNull=null, noGetter=222, aInt=333, aDouble=444.0}
target: Target2{integer=1, aLong2=2, string='c', aObject=AObject{x=100}, aBoolean=true, aSource=null, otherName=null, aTarget=null, aNull=null, noGetter=null, aInt=333, aDouble=444.0}
```

# 应用场景

- DO、DTO、VO、PO等互转的场景



# TODO 

- [x] 优化写法，支持用多个注解实现多组转换规则
- [ ] 基本类型和包装类型自动转换
- [ ] 补充单元测试