package cn.xja.myhuanjing.controllers;


import cn.xja.myhuanjing.bean.ZhuanTi;
import cn.xja.myhuanjing.services.ZhuanTiService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zhuanti")
@CrossOrigin
public class ZhuanTiController {
    //private String uploadPath="C:\\huanjingimgs\\";
    //private String http="http://127.0.0.1:8080/huanjing_war/huanjingimgs/";
    @Autowired
    ZhuanTiService zhuanTiService;

    /**
     * 分页显示专题
     * @param pageNum  第几页
     * @param size  每页记录数
     * @return
     */
    @RequestMapping("/getAll")
    public Map<String,Object> getAll(int pageNum, int size) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<ZhuanTi> allZhuanTi = zhuanTiService.getAllZhuanTi(pageNum,size);
        if (allZhuanTi != null) {
            map.put("message", "200");
            map.put("data", allZhuanTi);
            return map;
        }
        map.put("message", "202");
        map.put("data", new Object());
        return map;
    }


    //插入新闻
    @PostMapping("/insertZhuanTi")
    public Map<String,Object> insertZhuanTi(@RequestBody ZhuanTi ZhuanTi){
        Map<String,Object> map = new HashMap<>();
        int i = zhuanTiService.insertZhuanTi(ZhuanTi);
        if (i > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据新闻id查询该新闻信息
    @GetMapping("/getZhuanTiByZid")
    public Map<String,Object> getZhuanTiByXid(int zid){
        Map<String,Object> map = new HashMap<>();
        ZhuanTi ZhuanTi = zhuanTiService.getZhuanTiByZid(zid);
        if (ZhuanTi !=  null){
            map.put("message","200");
            map.put("data",ZhuanTi);
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据新闻id删除新闻
    @PostMapping("/deleteZhuanTiById")
    public Map<String,Object> deleteZhuanTiById(@RequestBody ZhuanTi ZhuanTi){
        Map<String,Object> map = new HashMap<>();
        int  i = zhuanTiService.deleteZhuanTiById(ZhuanTi.getZid());
        if (i  > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据新闻id修改专题
    @PostMapping("/updateZhuanTiById")
    public Map<String,Object> updateZhuanTiById(@RequestBody ZhuanTi ZhuanTi){
        Map<String,Object> map = new HashMap<>();
        int  i = zhuanTiService.updateZhuanTiById(ZhuanTi);
        if (i  > 0){
            map.put("message","200");
            map.put("data","update success");
            return map;
        }
        map.put("message","202");
        map.put("data","no update");
        return map;
    }

    //查询最后四个专题新闻显示
    @GetMapping("/getZhuanTiByDescFour")
    public Map<String,Object> getZhuanTiByDescFour(){
        Map<String,Object> map = new HashMap<>();
        List<ZhuanTi> zhuanTiByDescFour = zhuanTiService.getZhuanTiByDescFour();
        if (zhuanTiByDescFour != null){
            map.put("message","200");
            map.put("data",zhuanTiByDescFour);
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }
}

