package cn.xja.myhuanjing.services.impl;

import cn.xja.myhuanjing.bean.Suggest;
import cn.xja.myhuanjing.mappers.SuggestMapper;
import cn.xja.myhuanjing.services.SuggestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestServiceImpl implements SuggestService {
    @Autowired(required = false)
    SuggestMapper suggestMapper;

    @Override
    public PageInfo<Suggest> getAllSuggest(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
         List<Suggest> allSuggest=suggestMapper.getAllSuggest();
        return PageInfo.of(allSuggest);
    }

    @Override
    public int insertSuggest(Suggest suggest) {
        return suggestMapper.insertSuggest(suggest);
    }

    @Override
    public Suggest getSuggestBysid(int sid) {
        return suggestMapper.getSuggestByZid(sid);
    }

    @Override
    public int deleteSuggestById(int sid) {
        return suggestMapper.deleteSuggestById(sid);
    }

    @Override
    public int updateSuggestById(Suggest suggest) {
        return suggestMapper.updateSuggestById(suggest);
    }

    @Override
    public List<Suggest> getSuggestByDescFour() {
        return suggestMapper.getSuggestByDescFour();
    }
}
