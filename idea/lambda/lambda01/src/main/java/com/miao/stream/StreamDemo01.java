package com.miao.stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class StreamDemo01 {

    public static void main(String[] args) {
        //list 转为stream
        //test01();


        //数组转为stream
        //test02();

        //map转为stream
        //test03();

        //用stream中的map对元素进行计算或者转换
        //test04();

        //测试stream中sorted方法,需要实现Comparable接口中的compareTo方法，该方法用于实现升序排序还是降序排序
        //test05();

        //测试stream中limit,可以设置流的最大长度,超出部分将被抛弃。
        test06();
    }

    private static void test06() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        stream.distinct()
                .limit(2)
                .sorted()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test05() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        stream.distinct()
                .sorted() //空参数会调用Author类中实现的compareTo方法
                .forEach(author -> System.out.println(author.getAge()));

       /* stream.distinct()
                .sorted(new Comparator<Author>() {
                    @Override
                    public int compare(Author o1, Author o2) {
                        return o1.getAge()-o2.getAge();
                    }
                }) //非空参数会在这里实现比较方法
                .forEach(author -> System.out.println(author.getAge()));*/
    }

    private static void test04() {

        System.out.println("this is test04");
        List<Author> authors = getAuthors();

        Stream<Author> stream = authors.stream();

//        stream.map(author -> author.getName())
//                .distinct()
//                .forEach(s -> System.out.println(s));

        stream.map(author -> author.getAge())
                .map(age ->  age + 10)
                .forEach(age -> System.out.println(age));

    }

    private static void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新", 15);
        map.put("黑子", 17);
        map.put("托儿索", 20);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries); //[托儿索=20, 蜡笔小新=15, 黑子=17]

        Stream<Map.Entry<String, Integer>> stream = entries.stream();

        stream.distinct()
                .filter(entry -> entry.getValue() > 16)
                .forEach(entry -> System.out.println(entry.getKey()));

    }

    private static void test02() {

        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(arr);

        stream.distinct()
                .filter(integer -> integer > 2)
                .forEach(integer -> System.out.println(integer));

    }

    public static void test01() {
        List<Author> authorList = getAuthors();
        //我们可以调用getAuthors方法获取到作家的集合。现在需要打印所有年龄小于18的作家的名字，并且要注意去重(用stream流的方式)。

        //把集合转换成stream流
        authorList.stream()
                .distinct()
                .filter((author) -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName())); //终止操作，有终止操作前面的代码才会生效
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);


        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
