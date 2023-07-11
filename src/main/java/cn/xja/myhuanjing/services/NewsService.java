package cn.xja.myhuanjing.services;

import cn.xja.myhuanjing.bean.News;
import com.github.pagehelper.PageInfo;

public interface NewsService {

    public PageInfo<News> getAllNews(int pageNum, int size);

    //插入新闻
    public int insertNews(News news);

    //根据新闻id查询该新闻信息
    public News getNewsByXid(int xid);

    //根据新闻id删除新闻
    public int deleteNewsById(int xid);

    //根据新闻id修改新闻
    public int updateNewsById(News news);
}
