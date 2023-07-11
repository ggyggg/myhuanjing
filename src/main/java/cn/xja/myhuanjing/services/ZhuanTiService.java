package cn.xja.myhuanjing.services;

import cn.xja.myhuanjing.bean.ZhuanTi;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ZhuanTiService {

    public PageInfo<ZhuanTi> getAllZhuanTi(int pageNum, int size);
    //插入新闻
    public int insertZhuanTi(ZhuanTi zhuanTi);
    //根据新闻id查询该新闻信息
    public ZhuanTi  getZhuanTiByZid(int zid);

    //根据新闻id删除新闻
    public int deleteZhuanTiById(int zid);

    //根据新闻id修改新闻
    public int updateZhuanTiById(ZhuanTi zhuanTi);
    //查询最后四个专题新闻显示
    public List<ZhuanTi> getZhuanTiByDescFour();
}
