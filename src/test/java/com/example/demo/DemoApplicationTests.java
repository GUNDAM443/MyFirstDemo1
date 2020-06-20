package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
      /*  Date date=new Date();
        System.out.println(date);*/
       /* long time = System.currentTimeMillis();// 取得系统时间
        Date date = new Date( time );
        System.out.println(date);
        System.out.println(date.getTime());*/
        Date date = new Date() ;
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SS");
        String str = SDF.format(date);
        // format: 将Date型数据变为 String型数据
        System.out.println(str);
       /* String str = "2012-12-25 00:00:00:000" ;
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        Date date = null; //将SDF(String型)转为Date型
        try {
            date = SDF.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);*/
    }

}
