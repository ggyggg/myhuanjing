package cn.xja.myhuanjing.controllers;

import cn.xja.myhuanjing.bean.Suggest;
import cn.xja.myhuanjing.services.SuggestService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/suggestion")
@CrossOrigin
public class SuggestController {
    @Autowired
    SuggestService suggestService;

    /**
     * 分页显示专题
     * @param pageNum  第几页
     * @param size  每页记录数
     * @return
     */
    @RequestMapping("/getAll")
    public Map<String,Object> getAll(int pageNum, int size) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Suggest> allSuggest = suggestService.getAllSuggest(pageNum,size);
        if (allSuggest != null) {
            map.put("message", "200");
            map.put("data", allSuggest);
            return map;
        }
        map.put("message", "202");
        map.put("data", new Object());
        return map;
    }


    //插入建议
    @PostMapping("/insertSuggestion")
    public Map<String,Object> insertZhuanTi(@RequestBody Suggest suggest){
        Map<String,Object> map = new HashMap<>();
        int i = suggestService.insertSuggest(suggest);
        if (i > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据建议id查询该建议信息
    @GetMapping("/getSuggestionBySid")
    public Map<String,Object> getZhuanTiByXid(int sid){
        Map<String,Object> map = new HashMap<>();
        Suggest suggest = suggestService.getSuggestBysid(sid);
        if (suggest !=  null){
            map.put("message","200");
            map.put("data",suggest);
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据建议id删除建议
    @PostMapping("/deleteSuggestionById")
    public Map<String,Object> deleteZhuanTiById(@RequestBody Suggest suggest){
        Map<String,Object> map = new HashMap<>();
        int  i = suggestService.deleteSuggestById(suggest.getSid());
        if (i  > 0){
            map.put("message","200");
            map.put("data",new Object());
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }

    //根据建议id修改建议
    @PostMapping("/updateSuggestionById")
    public Map<String,Object> updateZhuanTiById(@RequestBody Suggest suggest){
        Map<String,Object> map = new HashMap<>();
        int  i = suggestService.updateSuggestById(suggest);
        if (i  > 0){
            map.put("message","200");
            map.put("data","update success");
            return map;
        }
        map.put("message","202");
        map.put("data","no update");
        return map;
    }

    //查询最后四个建议信息显示
    @GetMapping("/getSuggestionByDescFour")
    public Map<String,Object> getSuggestionByDescFour(){
        Map<String,Object> map = new HashMap<>();
        List<Suggest> suggestionByDescFour = suggestService.getSuggestByDescFour();
        if (suggestionByDescFour != null){
            map.put("message","200");
            map.put("data",suggestionByDescFour);
            return map;
        }
        map.put("message","202");
        map.put("data",new Object());
        return map;
    }
}
