package cn.xja.myhuanjing.services.impl;

import cn.xja.myhuanjing.bean.Volunteer;
import cn.xja.myhuanjing.mappers.VolunteerMapper;
import cn.xja.myhuanjing.services.VolunteerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired(required = false)
    VolunteerMapper volunteerMapper;
    @Override
    public PageInfo<Volunteer> getAllVolunteer(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
        List<Volunteer> allvolunteer = volunteerMapper.getAllVolunteer();
        return  PageInfo.of(allvolunteer);
    }

    @Override
    public int insertVolunteer(Volunteer volunteer) {
        return volunteerMapper.insertVolunteer(volunteer);
    }

    @Override
    public Volunteer getVolunteerByZid(int id) {
        return volunteerMapper.getVolunteerByZid(id);
    }

    @Override
    public int deleteVolunteerById(int id) {
        return volunteerMapper.deleteVolunteerById(id);
    }

    @Override
    public int updateVolunteerById(Volunteer volunteer) {
        return volunteerMapper.updateVolunteerById(volunteer);
    }

    @Override
    public List<Volunteer> getVolunteerByDescFour() {
        return volunteerMapper.getVolunteerByDescFour();
    }
}
