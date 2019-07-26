package com.wwr.echarts.model;


/**
 * @author wwr
 * @Description  模拟的数据类
 * @date 2019/7/17
 */
public class ChartData {
    private int x;
    private int y;
    private long z;

    public ChartData() {
    }

    public ChartData(int x, int y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public long getZ() {
        return z;
    }

    public void setZ(long z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return this.y+",";
    }
}
