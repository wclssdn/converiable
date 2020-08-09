# 对象转换工具

## 快速使用

源类：`Source` 和目标类：`Target`属性几乎无异，但是也存在一定不同。需要转换的时候，可以使用`@Convertible`注解实现。

```java
@Convertible(targets = Target.class)
public class Source {
    private Integer integer;
    // 如果源getter比较特殊，可以指定。目标setter比较特殊，也可以指定
    @Convertible(getter = "getaLong", setter = "setaLong")
    private Long aLong;
    private String string;
    private AObject aObject;
    private Boolean aBoolean;
    // 不同的类型,需要注意的是,ASource中也需要使用注解进行处理
    @Convertible(targets = ATarget.class)
    private ASource aSource;
    // 不同的属性名
    @Convertible(field = "otherName")
    private Float aFloat2otherName;
    // 不同的类型 & 不同的属性名
    @Convertible(targets = ATarget.class, field = "aTarget")
    private ASource aSource2target;
    private Integer aNull;
    private Integer noGetter;
    private int aInt;
    private double aDouble;
}
```

属性目标类：

```java
@Convertible(targets = ATarget.class)
public class ASource {
    @Convertible(field = "vv")
    private Integer v;
}
```

目标类：

```java
public class Target {
    private Integer integer;
    private Long aLong;
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


# 应用场景

- DO、DTO、VO、PO等互转的场景



# TODO 

- [] 优化写法，支持用多个注解实现多组转换规则
- [] 补充单元测试