package cn.xja.myhuanjing.services;

import cn.xja.myhuanjing.bean.Maps;

import java.util.List;

public interface MapService {

    //查询所有的区域
    public List<Maps> getAllMapsPolygon();

    //插入一块区域
    public int insertMapsPolygon(Maps maps);
}
