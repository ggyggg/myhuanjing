package cn.xja.myhuanjing.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaoGuang implements Serializable {
  private Integer bid;
  private String  btitle;
  private String  bdepartment;
  private String  bcontext;
  private String  bimgs;
  private Date    bdate;
}
