package cn.xja.myhuanjing.services.impl;

import cn.xja.myhuanjing.bean.ZhuanTi;
import cn.xja.myhuanjing.mappers.ZhuanTiMapper;
import cn.xja.myhuanjing.services.ZhuanTiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ZhuanTiServiceImpl implements ZhuanTiService {
    @Autowired(required = false)
    ZhuanTiMapper zhuanTiMapper;

    @Override
    public PageInfo<ZhuanTi> getAllZhuanTi(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
        List<ZhuanTi> allZhuanTi = zhuanTiMapper.getAllZhuanTi();
        return  PageInfo.of(allZhuanTi);
    }

    @Override
    public int insertZhuanTi(ZhuanTi zhuanTi) {
        return zhuanTiMapper.insertZhuanTi(zhuanTi);
    }

    @Override
    public ZhuanTi getZhuanTiByZid(int zid) {
        return zhuanTiMapper.getZhuanTiByZid(zid);
    }

    @Override
    public int deleteZhuanTiById(int zid) {
        return zhuanTiMapper.deleteZhuanTiById(zid);
    }

    @Override
    public int updateZhuanTiById(ZhuanTi zhuanTi) {
        return zhuanTiMapper.updateZhuanTiById(zhuanTi);
    }

    @Override
    public List<ZhuanTi> getZhuanTiByDescFour() {
        return zhuanTiMapper.getZhuanTiByDescFour();
    }
}
