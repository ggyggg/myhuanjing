package cn.xja.myhuanjing.controllers;

import cn.xja.myhuanjing.bean.BaoGuang;
import cn.xja.myhuanjing.services.BaoGuangService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/baoguang")
@CrossOrigin
public class BaoGuangController {
    @Autowired
    BaoGuangService baoGuangService;

    @RequestMapping("/getAll")
    public Map<String,Object> getAll(int pageNum, int size) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<BaoGuang> allBaoGuang = baoGuangService.getAllBaoGuang(pageNum,size);
        if (allBaoGuang != null) {
            map.put("message", "200");
            map.put("data", allBaoGuang);
            return map;
        }
        map.put("message", "202");
        map.put("data", new Object());
        return map;
    }


    //插入信息
    @PostMapping("/insertBaoguang")
    public Map<String,Object> insertBaoguang(@RequestBody BaoGuang baoGuang){
        Map<String,Object> map = new HashMap<>();
        int i = baoGuangService.insertBaoGuang(baoGuang);
        if (i > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据曝光台id查询该曝光台信息
    @GetMapping("/getBaoguangByBid")
    public Map<String,Object> getBaoGuangByBid(int bid){
        Map<String,Object> map = new HashMap<>();
        System.out.println("========运行之前！"+bid);
        BaoGuang baoGuang = baoGuangService.getBaoGuangByBid(bid);
        System.out.println("========运行了！");
        if (baoGuang !=  null){
            map.put("message","200");
            map.put("data",baoGuang);
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据曝光台id删除曝光台信息
    @PostMapping("/deleteBaoguangById")
    public Map<String,Object> deleteBaoguangById(@RequestBody BaoGuang baoGuang){
        Map<String,Object> map = new HashMap<>();
        System.out.println("=========="+baoGuang);
        int  i = baoGuangService.deleteBaoGuangById(baoGuang.getBid());
        if (i  > 0){
            map.put("message","200");
            map.put("data","delete success");
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据曝光台id修改曝光台信息
    @PostMapping("/updateBaoguangById")
    public Map<String,Object> updateBaoguangById(@RequestBody BaoGuang baoGuang){
        Map<String,Object> map = new HashMap<>();
        int  i = baoGuangService.updateBaoGuangById(baoGuang);
        if (i  > 0){
            map.put("message","200");
            map.put("data","update success");
            return map;
        }
        map.put("message","202");
        map.put("data","no update");
        return map;
    }

    //查询最后四个曝光台信息显示
    @GetMapping("/getBaoGuangByDescEight")
    public Map<String,Object> getBaoguangByDescEight(){
        Map<String,Object> map = new HashMap<>();
        List<BaoGuang> BaoGuangByDescEight = baoGuangService.getBaoGuangByDescFour();
        if (BaoGuangByDescEight != null){
            map.put("message","200");
            map.put("data",BaoGuangByDescEight);
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }
}
