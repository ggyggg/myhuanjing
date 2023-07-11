package cn.xja.myhuanjing.bean;



import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Maps implements Serializable{
    private int mid;
    private String mpolygonName;
    private String mpath;
    private double  mstrokeOpacity;
    private String mstrokeColor;
    private int mborderWeight;
    private String mfillColor;
    private double mfillOpacity;
    private List<Double[]> mmapsList = new ArrayList<>();
    private String mtitle;

}
