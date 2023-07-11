package cn.xja.myhuanjing.services;

import cn.xja.myhuanjing.bean.Volunteer;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VolunteerService {
    public PageInfo<Volunteer> getAllVolunteer(int pageNum, int size);
    //插入志愿者
    public int insertVolunteer(Volunteer volunteer);
    //根据志愿者id查询该志愿者信息
    public Volunteer getVolunteerByZid(int id);

    //根据志愿者id删除志愿者
    public int deleteVolunteerById(int id);

    //根据志愿者id修改志愿者
    public int updateVolunteerById(Volunteer volunteer);
    //查询最后四个志愿者信息显示
    public List<Volunteer> getVolunteerByDescFour();
}
