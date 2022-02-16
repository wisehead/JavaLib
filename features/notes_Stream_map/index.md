
# stream的map用法 - 品书读茶 - 博客园

[![复制代码](assets/1645002851-48304ba5e6f9fe08f3fa1abda7d326ab.gif)](javascript: "复制代码")

```plain
List<String> list = new ArrayList<>();
list.add("1");
list.add("2");
list.add("3");
list.add("4");
// 对所有元素进行操作
List<String> collect = list.stream().map(item -> item + "1").collect(Collectors.toList());
System.out.println(collect);
```

```plain
打印结果：
[11, 21, 31, 41]
```

[![复制代码](assets/1645002851-48304ba5e6f9fe08f3fa1abda7d326ab.gif)](javascript: "复制代码")