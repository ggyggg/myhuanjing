package cn.xja.myhuanjing.mappers;


import cn.xja.myhuanjing.bean.Maps;

import java.util.List;

/**
 * 区域mapper接口
 */
public interface MapsMapper {

    //查询所有的区域
    public List<Maps> getAllMapsPolygon();

    //插入一块区域
    public int insertMapsPolygon(Maps maps);

}
