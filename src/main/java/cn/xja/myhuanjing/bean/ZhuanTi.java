package cn.xja.myhuanjing.bean;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ZhuanTi implements Serializable{
    private int zid;
    private String ztitle;
    private String zauthor;
    private String zcontext;
    private String zimgs; //专题图标
    private Date zdate;

}
