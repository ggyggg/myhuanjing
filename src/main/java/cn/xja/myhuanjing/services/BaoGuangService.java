package cn.xja.myhuanjing.services;

import cn.xja.myhuanjing.bean.BaoGuang;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaoGuangService {
    public PageInfo<BaoGuang> getAllBaoGuang(int pageNum, int size);
    //插入曝光台信息
    public int insertBaoGuang(BaoGuang baoGuang);
    //根据新闻id查询该曝光台信息
    public BaoGuang  getBaoGuangByBid(int bid);

    //根据新闻id删除曝光台信息
    public int deleteBaoGuangById(int bid);

    //根据新闻id修改曝光台信息
    public int updateBaoGuangById(BaoGuang baoGuang);
    //查询最后四个曝光台信息显示
    public List<BaoGuang> getBaoGuangByDescFour();
}
