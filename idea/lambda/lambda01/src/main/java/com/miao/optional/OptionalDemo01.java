package com.miao.optional;

import com.miao.stream.Author;
import com.miao.stream.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("all")
public class OptionalDemo01 {
    //我们在编写代码的时候出现最多的就是空指针异常。所以在很多情况下我们需要做各种非空的判断。
    //尤其是对象中的属性还是一个对象的情况下。这种判断会更多。
    //而过多的判断语句会让我们的代码显得臃肿不堪。
    //所以在JDK8中引入了Optional,养成使用Optional的习惯后你可以写出更优雅的代码来避免空指针异常。
    //并且在很多函数式编程相关的API中也都用到了Optional，如果不会使用Optional也会对函数式编程的学习造成影响。

    public static void main(String[] args) {

        /*Author nullAuthor = getNullAuthor();
        Optional<Author> nullAuthor1 = Optional.ofNullable(nullAuthor);
        nullAuthor1.ifPresent(author -> System.out.println(author.getName()));*/

        //获取Optional对象，并且打印Optional对象
        //test01();

        //如果我们期望安全的获取值。我们不推荐使用get方法，而是使用Optional提供的以下方法。
        //orElseGet 获取数据并且设置数据为空时的默认值。如果数据不为空就能获取到该数据。如果为空则根据你传入的参数来创建对象作为默认值返回。
        //test02();

        //orElseThrow
        //获取数据，如果数据不为空就能获取到该数据。如果为空则根据你传入的参数来创建异常抛出。
        test03();

        //过滤  我们可以使用filter方法对数据进行过滤。如果原本是有数据的，但是不符合判断，也会变成一个无数据的Optional对象。
        test04();
    }

    private static void test04() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.filter(author -> author.getAge() > 30)
                .ifPresent(author -> System.out.println(author.getAge()));
    }

    private static void test03() {
        Optional<Author> authorOptional = getAuthorOptional();


        try {
            Author author = authorOptional.orElseThrow(() -> new RuntimeException("author为空"));
            System.out.println(author.getName());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static void test02() {
        Optional<Author> authorOptional = getAuthorOptional();
        Author author = authorOptional.orElseGet(() -> new Author(2L, "ss", 15, "自我介绍", null));//如果authorOptional为空，则新建一个Author对象
        System.out.println(author);

    }

    private static void test01() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.ifPresent(author -> System.out.println(author));
    }


    private static Author getNullAuthor() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        author.setBooks(books1);

        return null;
    }

    private static Optional<Author> getAuthorOptional() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        author.setBooks(books1);

        return Optional.ofNullable(author);
    }
}
