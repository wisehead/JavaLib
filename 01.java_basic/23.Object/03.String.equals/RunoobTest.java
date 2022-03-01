class RunoobTest {
    public static void main(String[] args) {
 
        // String 类使用 equals() 方法
        // 创建两个对象
        String obj1 = new String();
        String obj2 = new String();
 
        // 判断 obj1 与 obj2 是否相等
        // 初始化的两个对象都为 null，所以是相等，返回 true
        System.out.println(obj1.equals(obj2)); // true
 
        // 给对象赋值
        obj1 = "Runoob";
        obj2 = "Google";
 
        // 判断 obj1 与 obj2 是否相等
        // 两个值不同，内存地址也不同，所以不相等，返回 false
        System.out.println(obj1.equals(obj2)); // false
 
    }
}
