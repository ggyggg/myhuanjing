package cn.xja.myhuanjing.services.impl;

import cn.xja.myhuanjing.bean.BaoGuang;
import cn.xja.myhuanjing.mappers.BaoGuangMapper;
import cn.xja.myhuanjing.services.BaoGuangService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BaoGuangServiceImpl implements BaoGuangService {
    @Autowired(required = false)
    BaoGuangMapper baoGuangMapper;
    @Override
    public PageInfo<BaoGuang> getAllBaoGuang(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
        List<BaoGuang> allBaoGuang = baoGuangMapper.getAllBaoGuang();
        return  PageInfo.of(allBaoGuang);
    }

    @Override
    public int insertBaoGuang(BaoGuang baoGuang) {
        return baoGuangMapper.insertBaoGuang(baoGuang);
    }

    @Override
    public BaoGuang getBaoGuangByBid(int bid) {
        return baoGuangMapper.getBaoGuangByBid(bid);
    }

    @Override
    public int deleteBaoGuangById(int bid) {
        return baoGuangMapper.deleteBaoGuangById(bid);
    }

    @Override
    public int updateBaoGuangById(BaoGuang baoGuang) {
        return baoGuangMapper.updateBaoGuangById(baoGuang);
    }

    @Override
    public List<BaoGuang> getBaoGuangByDescFour() {
        return baoGuangMapper.getBaoGuangByDescFour();
    }
}
