package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class JsoupTest01 {

    @Test
    public void testUrl() throws Exception {
        //解析url地址,第一个参数是访问的URL，第二个参数是访问时候的超时时间 单位为毫秒
        Document doc = Jsoup.parse(new URL("https://www.itcast.cn/"), 1000);

        //使用标签选择器，获取第一个title标签中的内容
        String title = doc.getElementsByTag("title").first().text();

        System.out.println(title);
    }

    @Test
    public void testString() throws Exception {
        //使用工具类读取文件，获取字符串
        String s = FileUtils.readFileToString(new File("D:\\itcast.html"), "utf-8");
        //解析字符串
        Document doc = Jsoup.parse(s);

        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);

    }


    //Jsoup可以直接解析文件
    @Test
    public void testFile() throws Exception {
        Document doc = Jsoup.parse(new File("D:\\itcast.html"), "utf8");
        String title = doc.getElementsByTag("title").first().text();

        Elements title1 = doc.getElementsByTag("a");

        for (Element element : title1) {
            System.out.println(element.text());
        }

        System.out.println(title);
    }

    @Test
    public void testDom() throws Exception {
        // 解析文件件, 获取Document对象
        Document doc = Jsoup.parse(new File("D:\\itcast.html"), "utf8");
        // 1.根据id查询元素getElementById
        Element city_bj = doc.getElementById("city_bj");
        // 2.根据标签获取元素getElementsByTag
        Element span = doc.getElementsByTag("span").first();
        // 3.根据class获取元素getElementsByClass
        Element class_a_class_b = doc.getElementsByClass("class_a class_b").first();
        // 4.根据属性获取元素getElementsByAttribute
        Element abc = doc.getElementsByAttribute("abc").first();
        // 5.根据属性与属性值筛选
        Element elementsByAttributeValue = doc.getElementsByAttributeValue("class", "s_name").first();
        // 打印元素内容
        System.out.println(city_bj.text());

        System.out.println(span.text());

        System.out.println(class_a_class_b.text());

        System.out.println(abc.text());

        System.out.println(elementsByAttributeValue.text());
    }

    @Test
    public void testData() throws Exception {

        Document doc = Jsoup.parse(new File("D:\\itcast.html"), "utf8");

        Element element = doc.getElementById("test");

        System.out.println(element.id());
        System.out.println(element.className());
    }

    @Test
    public void testSelector() throws Exception {
        // 解析html文件, 获取Document对象
        Document doc = Jsoup.parse(new File("D:\\itcast.html"), "utf8");

        //通过标签查找元素
        Element span = doc.select("span").first();

        //通过id查找
        Element id = doc.select("#city_bj").first();

        //通过class名称查找元素
        Element class_a = doc.select(".class_a").first();

        //el.class: 元素+class，比如： li.class_a
        //Element element = doc.select("li.class_a").first();

        //el[attr]: 元素+属性名，比如： span[abc]
        //Element element = doc.select("span[abc]").first();
        Element s_name = doc.select("[abc=123]").first();

        //任意组合: 比如：span[abc].s_name
        //Element element = doc.select("span[abc].s_name").first();

        //ancestor child: 查找某个元素下子元素，比如：.city_con li 查找"city_con"下的所有li
        //Elements elements = doc.select(".city_con li");

        //parent > child: 查找某个父元素下的直接子元素，比如：
        // .city_con > ul > li 查找city_con第一级（直接子元素）的ul，再找所有ul下的第一级li
        //Elements elements = doc.select(".city_con > ul > li");

        //parent > *: 查找某个父元素下所有直接子元素
        Elements elements = doc.select(".city_con > ul > *");

        // 打印元素内容

        System.out.println(span.text());
        System.out.println(id.text());
        System.out.println(class_a.text());
        System.out.println(s_name.text());
    }

    @Test
    public void testSelector2() throws Exception {
        // 解析html文件, 获取Document对象
        Document doc = Jsoup.parse(new File("D:\\itcast.html"), "utf8");

        Element city = doc.select("h3#city_bj").first();

        Element span = doc.select("span[abc]").first();


        Elements citySpans = doc.select(".city_con span");


        System.out.println(city.text());
        System.out.println(span.text());

        for (Element citySpan : citySpans) {
            System.out.println(citySpan.text());
        }
    }
}
