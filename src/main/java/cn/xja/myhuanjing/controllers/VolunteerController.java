package cn.xja.myhuanjing.controllers;


import cn.xja.myhuanjing.bean.Volunteer;
import cn.xja.myhuanjing.services.VolunteerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/volunteer")
@CrossOrigin
public class VolunteerController {
    @Autowired
    VolunteerService volunteerService;
    @RequestMapping("/getAll")
    public Map<String,Object> getAll(int pageNum, int size) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Volunteer> allvolunteer = volunteerService.getAllVolunteer(pageNum,size);
        if (allvolunteer != null) {
            map.put("message", "200");
            map.put("data", allvolunteer);
            return map;
        }
        map.put("message", "202");
        map.put("data", new Object());
        return map;
    }


    //插入志愿者信息
    @PostMapping("/insertVolunteer")
    public Map<String,Object> insertZhuanTi(@RequestBody Volunteer volunteer){
        Map<String,Object> map = new HashMap<>();
        int i = volunteerService.insertVolunteer(volunteer);
        if (i > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据志愿者id查询该志愿者信息
    @GetMapping("/getVolunteerByid")
    public Map<String,Object> getVolunteerByXid(int id){
        Map<String,Object> map = new HashMap<>();
        Volunteer volunteer = volunteerService.getVolunteerByZid(id);
        if (volunteer !=  null){
            map.put("message","200");
            map.put("data",volunteer);
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据志愿者id删除志愿者信息
    @PostMapping("/deleteVolunteerById")
    public Map<String,Object> deleteZhuanTiById(@RequestBody Volunteer volunteer){
        Map<String,Object> map = new HashMap<>();
        int  i = volunteerService.deleteVolunteerById(volunteer.getId());
        if (i  > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据志愿者id修改志愿者信息
    @PostMapping("/updateVolunteerById")
    public Map<String,Object> updateZhuanTiById(@RequestBody Volunteer volunteer){
        Map<String,Object> map = new HashMap<>();
        int  i = volunteerService.updateVolunteerById(volunteer);
        if (i  > 0){
            map.put("message","200");
            map.put("data","update success");
            return map;
        }
        map.put("message","202");
        map.put("data","no update");
        return map;
    }

    //查询最后四个志愿者信息显示
    @GetMapping("/getVolunteerByDescFour")
    public Map<String,Object> getZhuanTiByDescFour(){
        Map<String,Object> map = new HashMap<>();
        List<Volunteer> zhuanTiByDescFour = volunteerService.getVolunteerByDescFour();
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
