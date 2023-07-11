package cn.xja.myhuanjing.mappers;

import cn.xja.myhuanjing.bean.Suggest;

import java.util.List;

public interface SuggestMapper {
    // 所有建议
    public List<Suggest> getAllSuggest();

    //插入建议
    public int insertSuggest(Suggest suggest);

    //根据建议id查询该建议信息
    public Suggest getSuggestByZid(int zid);

    //根据建议id删除建议
    public int deleteSuggestById(int zid);

    //根据建议id修改建议
    public int updateSuggestById(Suggest suggest);

    //查询最后四个建议显示（查询最新的4个建议）
    public List<Suggest> getSuggestByDescFour();



}
