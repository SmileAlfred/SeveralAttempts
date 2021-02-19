package com.company.networktest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 访问网络，
 */
public class AccessNetwork {
    /**
     * 访问到 HTML 的键值对文件
     */
    @Test
    public void test01() {
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=406");
            InputStream is = url.openStream();
            String cont = "";
            byte[] bytes = new byte[1024000];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                cont = new String(bytes, 0, len, "GBK");
                System.out.println(cont);
            }
        } catch (Exception e) {
            System.out.println("test01 访问网络报错：" + e.getMessage());
        }
    }

    @Test
    public void getAllUrls() {

        Document doc;
        try {
            int cnt = 0;
            String url = "https://www.bilibili.com/video/BV1Kb411W75N?p=406";
            doc = Jsoup.connect(url).get();
            //Elements rows = doc.select("div ul li");
            Elements rows = doc.select("script");
            System.out.println("rows = " + rows);

            if (rows.size() > 0) {
                for (Element row : rows) {
                    String link = row.select("a").attr("href");
                    String title = row.select("a").text();
                    System.out.println((++cnt) + ":\t" + title + "\t" + link);// 获取文件链接地址
                }
            }
        } catch (IOException e) {
            System.out.println("getAllUrls 报错：" + e.getMessage());
        }


    }

    @Test
    public void getVideoFromPage() {
        try {
            document = Jsoup.connect(url)
                    // .timeout(5000)
                    .get();
        } catch (IOException e) {
            System.out.println("超时：" + e.getMessage());
        }

        Elements elements = document.select("div.stui-vodlist__box.stui-vodlist__bg");
        //System.out.println(elements);

        String regEx = "[^0-9]";
        if (!elements.isEmpty()) {
            for (Element tittle : elements) {
                Element first = tittle.select("a[href]").first();

                if (first != null) {
                    title = first.attr("title");
                    img = first.attr("data-original");

                    titleUrl = first.attr("href");
                    System.out.println("标题：" + title);
                    System.out.println("图片:" + img);
                    System.out.println("具体地址：" + url + titleUrl);

                    Pattern p = Pattern.compile(regEx);
                    Matcher m = p.matcher(titleUrl + "");
                    System.out.println("id:======>" + m.replaceAll("").trim() + "\n");
                } else {
                    System.out.println("first == null");
                }
            }
        }
    }

    private final String url = "http://lab.liumingye.cn/";
    private static String title;
    private static String titleUrl;
    private static String name;
    private static String img;
    Document document = null;
}
