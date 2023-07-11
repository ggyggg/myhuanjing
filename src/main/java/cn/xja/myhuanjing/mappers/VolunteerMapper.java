package cn.xja.myhuanjing.mappers;

import cn.xja.myhuanjing.bean.Volunteer;

import java.util.List;

public interface VolunteerMapper {

    // 所有志愿者
    public  List<Volunteer> getAllVolunteer();

    //插入志愿者
    public int insertVolunteer(Volunteer volunteer);

    //根据志愿者id查询该志愿者信息
    public Volunteer getVolunteerByZid(int id);

    //根据志愿者id删除志愿者
    public int deleteVolunteerById(int id);

    //根据志愿者id修改志愿者
    public int updateVolunteerById(Volunteer volunteer);

    //查询最后四个志愿者信息显示（查询最新的4个志愿者）
    public List<Volunteer> getVolunteerByDescFour();



}
