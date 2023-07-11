package cn.xja.myhuanjing.mappers;

import cn.xja.myhuanjing.bean.ZhuanTi;

import java.util.List;

/**
 * 专题mapper接口
 */
public interface ZhuanTiMapper {

    // 所有专题
    public List<ZhuanTi> getAllZhuanTi();

    //插入专题
    public int insertZhuanTi(ZhuanTi zhuanTi);

    //根据专题id查询该专题信息
    public ZhuanTi getZhuanTiByZid(int zid);

    //根据专题id删除专题
    public int deleteZhuanTiById(int zid);

    //根据新闻id修改新闻
    public int updateZhuanTiById(ZhuanTi zhuanTi);

    //查询最后四个专题新闻显示（查询最新的4个专题）
    public List<ZhuanTi> getZhuanTiByDescFour();
}
