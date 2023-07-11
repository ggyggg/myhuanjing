package cn.xja.myhuanjing.mappers;

import cn.xja.myhuanjing.bean.BaoGuang;

import java.util.List;

public interface BaoGuangMapper {
    // 所有曝光台信息
    public List<BaoGuang> getAllBaoGuang();

    //插入曝光台信息
    public int insertBaoGuang(BaoGuang baoGuang);

    //根据曝光台id查询该曝光台信息
    public BaoGuang getBaoGuangByBid(int bid);

    //根据曝光台id删除曝光台信息
    public int deleteBaoGuangById(int bid);

    //根据曝光台id修改曝光台信息
    public int updateBaoGuangById(BaoGuang baoGuang);

    //查询最后四个曝光台信息显示（查询最新的4个曝光台信息）
    public List<BaoGuang> getBaoGuangByDescFour();
}
