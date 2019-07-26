package com.wwr.echarts.model;


/**
 * @author wwr
 * @Description  图的配置项实体类
 * @date 2019/7/17
 */
public class ChartOption {
    private int id;
    private String type;
    private String option;

    public ChartOption(int id, String type, String option) {
        this.id = id;
        this.type = type;
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return this.option;
    }
}
