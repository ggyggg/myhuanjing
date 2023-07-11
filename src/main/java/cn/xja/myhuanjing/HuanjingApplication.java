package cn.xja.myhuanjing;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.xja.myhuanjing.mappers")   // 扫描mapper接口所在的包
@SpringBootApplication    // springboot的应用程序
public class HuanjingApplication {
    public static void main(String[] args) {
        SpringApplication.run(HuanjingApplication.class,args);
    }
}
