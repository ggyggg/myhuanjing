package cn.xja.myhuanjing.controllers;

import cn.xja.myhuanjing.bean.Maps;
import cn.xja.myhuanjing.bean.Path;
import cn.xja.myhuanjing.services.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/maps")
@CrossOrigin
public class MapsController {

    @Autowired
    MapService mapService;

    // mpath数据
    private String mpath = "";


    @GetMapping("/getAllMapsPolygon")
    public Map<String,Object> getAllMapsPolygon(){
        Map<String,Object> map = new HashMap<>();
        List<Maps> mapsList = mapService.getAllMapsPolygon();
        if (mapsList != null) {
            map.put("message", "200");
            map.put("data", mapsList);
            return map;
        }
        map.put("message", "202");
        map.put("data", new Object());
        return map;
    }

    // 点击“结束编辑”时执行，保存地图路径mpath数据
    @PostMapping("/uploadMapsPath")
    public Map<String,Object> uploadMapsPath(@RequestBody List<Path> pathList){
        StringBuffer stringBuffer = new StringBuffer("");
        Map<String,Object> map = new HashMap<>();
        if (pathList != null){
            for (Path path : pathList) {
                stringBuffer.append("["+path.getLng()+","+path.getLat()+"]-");
                System.out.println(path);
            }
            mpath = stringBuffer.toString();
            map.put("message", "200");
            map.put("data", stringBuffer.toString());
            return map;
        }
        map.put("message", "202");
        map.put("data", new Object());
        return map;
    }

    // 获得地图路径mpath
    @GetMapping("/getMapsPath")
    public Map<String,Object> getMapsPath(){
        Map<String,Object> map = new HashMap<>();

        if (mpath != null){
            map.put("message", "200");
            map.put("data", mpath);
            return map;
        }
        map.put("message", "202");
        map.put("data", new Object());
        return map;
    }

    //插入一块区域
    @PostMapping("/insertMapsPolygon")
    public Map<String,Object> insertMapsPolygon(@RequestBody Maps maps){
        Map<String,Object> map = new HashMap<>();
        int i = mapService.insertMapsPolygon(maps);
        if (i > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }
}

