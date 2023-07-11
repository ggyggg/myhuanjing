package cn.xja.myhuanjing.bean;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Path implements Serializable {

    private double Q;

    private double R;
    private double lat;
    private double lng;

    public double getQ() {
        return Q;
    }
    @JSONField(name = "Q")
    public void setQ(double Q) {
        this.Q = Q;
    }

    public double getR() {
        return R;
    }
    @JSONField(name = "R")
    public void setR(double R) {
        this.R = R;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Path{" +
                "Q=" + Q +
                ", R=" + R +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
