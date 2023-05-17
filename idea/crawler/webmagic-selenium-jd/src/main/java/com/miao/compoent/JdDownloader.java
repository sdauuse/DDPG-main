package com.miao.compoent;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.selector.PlainText;

@SuppressWarnings("all")
public class JdDownloader implements Downloader {

    @Value("${indexUrl}")
    private String indexUrl;

    private RemoteWebDriver driver;

    // 利用构造 初始化chromedriver
    public JdDownloader() {
        // 加载chromedriver 是使用chorme的必要条件
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\75164\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        // 添加chrome的配置信息
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置为无头模式
        //chromeOptions.addArguments("--headless");
        // 设置打开的窗口大小 非必要属性
        chromeOptions.addArguments("--window-size=1920,1080");

        // 使用配置信息 创建driver对象
        driver = new ChromeDriver(chromeOptions);
    }

    @Override
    public Page download(Request request, Task task) {


        //1.列表页的处理
        if ("list".equals(request.getExtra("level"))) {
            try {
                driver.get(indexUrl);
                driver.findElementById("key").sendKeys("手机");

                Thread.sleep(1000);

                driver.findElementByXPath("//*[@id=\"search\"]/div/div[2]/button").click();

                Thread.sleep(1000);
                // 页面滚动到下方
                Integer start = 0;
                Integer end = 500;
                //6000为最大值
                while (true) {
                    if (end == 6000) {
                        break;
                    }
                    String scriptStr = "window.scrollTo(" + start + "," + end + ")";
                    driver.executeScript(scriptStr);
                    Thread.sleep(500);
                    start += 500;
                    end += 500;
                }

                String pageSource = driver.getPageSource();

                return createPage(pageSource, driver.getCurrentUrl());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //2.分页的下载
        if ("page".equals(request.getExtra("level"))) {
            try {
                driver.get(indexUrl);
                driver.findElementById("key").sendKeys("手机");

                Thread.sleep(1000);

                driver.findElementByXPath("//*[@id=\"search\"]/div/div[2]/button").click();

                Thread.sleep(1000);


                driver.findElementByXPath("//*[@id=\"J_topPage\"]/a[2]").click();
                Thread.sleep(1000);

                String pageSource = driver.getPageSource();

                return createPage(pageSource, driver.getCurrentUrl());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //3.详情页
        if ("detail".equals(request.getExtra("level"))) {
            driver.get(request.getUrl());

            String pageSource = driver.getPageSource();

            return  createPage(pageSource, driver.getCurrentUrl());
        }

        return null;
    }

    private Page createPage(String pageSource, String currentUrl) {
        Page page = new Page();
        //设置网页源码+url
        page.setRawText(pageSource);
        page.setUrl(new PlainText(currentUrl));

        //设置request对象
        Request request = new Request(currentUrl);

        page.setRequest(request);

        return page;
    }

    /**
     * 设置线程的方法
     *
     * @param i
     */
    @Override
    public void setThread(int i) {

    }
}
