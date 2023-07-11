package cn.xja.myhuanjing.mappers;

import cn.xja.myhuanjing.bean.News;

import java.util.List;

/**
 * 新闻mapper接口
 */
public interface NewsMapper {

    // 所有新闻
    public List<News> getAllNews();

    //插入新闻
    public int insertNews(News news);

    //根据新闻id查询该新闻信息
    public News getNewsByXid(int xid);

    //根据新闻id删除新闻
    public int deleteNewsById(int xid);

    //根据新闻id修改新闻
    public int updateNewsById(News news);
}
