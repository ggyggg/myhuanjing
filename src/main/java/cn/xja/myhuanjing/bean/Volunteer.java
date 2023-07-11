package cn.xja.myhuanjing.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Volunteer implements Serializable{
    private Integer id;
    private String vname ;
    private String vcontext;
    private String  vimgs;
    private Date vtime;

}
