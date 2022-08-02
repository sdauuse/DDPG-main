package com.miao.stream;

import sun.security.util.AuthResources_it;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
        //test06();


        //测试stream中的skip，跳过流中的前n个元素，返回剩下的元素
        //例如：
        //打印除了年龄最小的作家外的其他作家，要求不能有重复元素，并且按照年龄升序排序。
        //test07();

        //测试flatMap, map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。
        //test08();

        //打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
        //test09();

        //测试count  可以用来获取当前流中元素的个数。
        //例子：
        //打印这些作家的所出书籍的数目，注意删除重复元素。
        //test10();

        //max&min  可以用来或者流中的最值。
        //例子：
        //分别获取这些作家的所出书籍的最高分和最低分并打印。
        //test11();

        //测试collect  把当前流转换成一个集合。
        //例子：获取一个存放所有作者名字的List集合。
        //test12();

        //获取一个所有书名的Set集合。
        //test13();

        //获取一个Map集合，map的key为作者名，value为List<Book>
        //test14();

        //anyMatch
        //可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。
        //例子：判断是否有年龄在29以上的作家
        //test15();

        //allMatch 可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false。
        //例子：判断是否所有的作家都是成年人

        //noneMatch 可以判断流中的元素是否都不符合匹配条件。如果都不符合结果为true，否则结果为false
        //例子：判断作家是否都没有超过100岁的。


        //findAny 获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。
        //例子：	获取任意一个年龄大于18的作家，如果存在就输出他的名字
        //test16();

        //findFirst 获取流中的第一个元素。
        //例子：	获取一个年龄最小的作家，并输出他的姓名。
        //test17();

        //reduce归并 对流中的数据按照你指定的计算方式计算出一个结果。（缩减操作）
        //reduce的作用是把stream中的元素给组合起来，我们可以传入一个初始值，它会按照我们的计算方式依次拿流中的元素和初始化值进行计算，计算结果再和后面的元素计算。
        //reduce两个参数的重载形式内部的计算方式如下：
        //例子：使用reduce求所有作者年龄的和
        test18();

        //使用reduce求所有作者中年龄的最大值
        test19();
    }

    private static void test19() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Integer reduce = stream.distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);

        System.out.println(reduce);
    }

    private static void test18() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Integer reduce = stream.distinct()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);

        System.out.println(reduce);

    }

    private static void test17() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Optional<Author> first = stream.distinct()
                .sorted()
                .findFirst();

        first.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test16() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Optional<Author> any = stream.distinct()
                .filter(author -> author.getAge() > 18)
                .findAny();


        any.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test15() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        boolean b = stream.anyMatch(author -> author.getAge() > 29);

        System.out.println(b);
    }

    private static void test14() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Map<String, List<Book>> collect = stream.distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));

        System.out.println(collect);
    }

    private static void test13() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Set<Book> collect = stream.flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());

        System.out.println(collect);
    }

    private static void test12() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        List<String> nameCollect = stream.map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(nameCollect);
    }

    private static void test11() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Optional<Integer> max = stream.flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);
        System.out.println("max score " + max.get());
    }

    private static void test10() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        long count = stream.flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test09() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        stream.flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));
    }

    private static void test08() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        stream.flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        stream.distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName() + "\t" + author.getAge()));
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
                .map(age -> age + 10)
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
