package cn.xja.myhuanjing.services;

import cn.xja.myhuanjing.bean.Suggest;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface SuggestService {

    public PageInfo<Suggest> getAllSuggest(int pageNum, int size);
    //插入建议
    public int insertSuggest(Suggest suggest);
    //根据建议id查询该建议信息
    public Suggest getSuggestBysid(int sid);
    //根据建议id删除建议
    public int deleteSuggestById(int sid);
    //根据建议id修改建议
    public int updateSuggestById(Suggest suggest);
    //查询最后四个建议显示
    public List<Suggest> getSuggestByDescFour();

}
