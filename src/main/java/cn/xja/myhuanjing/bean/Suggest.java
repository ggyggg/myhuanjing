package cn.xja.myhuanjing.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Suggest implements Serializable {
   private Integer sid;
   private String stitle ;
   private Date stime ;
   private String scontext;


}
