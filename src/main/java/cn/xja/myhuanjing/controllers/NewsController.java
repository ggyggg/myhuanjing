package cn.xja.myhuanjing.controllers;


import cn.xja.myhuanjing.bean.News;
import cn.xja.myhuanjing.services.NewsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


@RestController      // 控制器方法直接返回对象
@RequestMapping("/news")   // 请求地址
@CrossOrigin
public class NewsController {

    private String http="http://127.0.0.1:80/img/upload/";

    @Autowired
    NewsService newsService;

    // 查找新闻
    @RequestMapping("/getAll")
    public Map<String,Object> getAll(int pageNum, int size) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<News> allNews = newsService.getAllNews(pageNum,size);
        if (allNews != null) {  // 成功
            map.put("message", "200");
            map.put("data", allNews);
            return map;
        }
        map.put("message", "202");  // 失败
        map.put("data", "no getall");
        return map;   // 返回的map对象会自动转成json数据返回到客户端
    }

    // 上传图片
    @PostMapping("/uploadImg")
    public Map<String,Object> uploadImg(@RequestParam MultipartFile file) throws FileNotFoundException,IOException {
        // 上传文件名
        String originalFilename = file.getOriginalFilename();
        String imgName = UUID.randomUUID() + originalFilename;
        // 1. classpath目录   获取编译包的根路径
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println("path=============="+path);
        // 2. 上传文件的路径
        File upload = new File(path.getAbsolutePath(),"static/img/upload/");
        System.out.println("upload==================="+upload);
        // 3.上传文件
        File imgFile = new File(upload.getAbsolutePath()+"\\"+imgName);
        System.out.println("imgFile==================="+imgFile);
        // 4.判断文件夹是否存在不存在创建
        File parentFile = imgFile.getParentFile();
        if (!parentFile.exists()){
            parentFile.mkdirs();
        }
        //定义变量保存img上传后url
        String url;
        Map<String,Object> map = new HashMap<>();
        try {
            file.transferTo(imgFile);
            System.out.println("上传文件："+imgFile.getAbsolutePath());
            map.put("errno",0);
            List<Object> data = new ArrayList<>();
            Map<String,Object> data1 = new HashMap<>();
            data1.put("url",http+imgName);   // 上传图片的路径
            data1.put("alt",imgName);
            data1.put("href","");
            data.add(data1);
            map.put("data",data);
            System.out.println("map==============="+map);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("errno",1);
            map.put("message","上传失败");
            return map;
        }
    }

    //插入新闻
    @PostMapping("/insertNews")
    public Map<String,Object> insertNews(@RequestBody News news){
        Map<String,Object> map = new HashMap<>();
        int i = newsService.insertNews(news);
        if (i > 0){
            map.put("message","200");
            map.put("data","insert success");
            return map;
        }
        map.put("message","202");
        map.put("data","no insert");
        return map;
    }

    //根据新闻id查询该新闻信息
    @GetMapping("/getNewsByXid")
    public Map<String,Object> getNewsByXid(int xid){
        Map<String,Object> map = new HashMap<>();
        News news = newsService.getNewsByXid(xid);
        if (news !=  null){
            map.put("message","200");
            map.put("data",news);
            return map;
        }
        map.put("message","202");
        map.put("data","no get");
        return map;
    }

    //根据新闻id删除新闻
    @PostMapping("/deleteNewsById")
    public Map<String,Object> deleteNewsById(@RequestBody News news){
        Map<String,Object> map = new HashMap<>();
        // 返回删除行数
        int  i = newsService.deleteNewsById(news.getXid());
        if (i  > 0){   // 删除成功
            map.put("message","200");
            map.put("data","delete success");
            return map;
        }
        map.put("message","202");   // 删除失败
        map.put("data","no delete");
        return map;
    }

    //根据新闻id修改新闻
    @PostMapping("/updateNewsById")
    public Map<String,Object> updateNewsById(@RequestBody News news){
        Map<String,Object> map = new HashMap<>();
        int  i = newsService.updateNewsById(news);
        if (i  > 0){
            map.put("message","200");
            map.put("data","update success");
            return map;
        }
        map.put("message","202");
        map.put("data","no update");
        return map;
    }
}

