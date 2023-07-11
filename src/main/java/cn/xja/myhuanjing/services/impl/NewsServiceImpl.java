package cn.xja.myhuanjing.services.impl;

import cn.xja.myhuanjing.bean.News;
import cn.xja.myhuanjing.mappers.NewsMapper;
import cn.xja.myhuanjing.services.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired(required = false)
    NewsMapper newsMapper;
    @Override
    public PageInfo<News> getAllNews(int pageNum,int size) {
        PageHelper.startPage(pageNum,size);
        List<News> allNews = newsMapper.getAllNews();
        return  PageInfo.of(allNews);
    }

    @Override
    public int insertNews(News news) {
        return newsMapper.insertNews(news);
    }

    @Override
    public News getNewsByXid(int xid) {
        return newsMapper.getNewsByXid(xid);
    }

    @Override
    public int deleteNewsById(int xid) {
        return newsMapper.deleteNewsById(xid);
    }

    @Override
    public int updateNewsById(News news) {
        return newsMapper.updateNewsById(news);
    }
}
