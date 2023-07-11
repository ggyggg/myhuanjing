package cn.xja.myhuanjing.services.impl;

import cn.xja.myhuanjing.bean.Maps;
import cn.xja.myhuanjing.mappers.MapsMapper;
import cn.xja.myhuanjing.services.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Autowired(required = false)
    MapsMapper mapsMapper;
    @Override
    public List<Maps> getAllMapsPolygon() {
        List<Maps> allMapsPolygon = mapsMapper.getAllMapsPolygon();
        for (Maps maps : allMapsPolygon) {
            String[] split = maps.getMpath().split("-");
            List<Double[]> mmapsList = maps.getMmapsList();
            for (String s : split) {
                mmapsList.add(new Double[]{Double.parseDouble(s.replace("[","").split(",")[0]),Double.parseDouble(s.replace("]","").split(",")[1])});
             }

        }
        return allMapsPolygon;
    }

    @Override
    public int insertMapsPolygon(Maps maps) {
        return mapsMapper.insertMapsPolygon(maps);
    }
}
