package cn.xja.myhuanjing.bean;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class News  implements Serializable{
    private int xid;
    private String xtitle;
    private String xauthor;
    private String xcontext;
    private String ximgs;
    private Date xdate;

}
