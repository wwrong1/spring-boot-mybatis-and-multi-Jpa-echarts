package com.wwr.echarts.model;

/**
 * @author wwr
 * @Description  图数据实体类
 * @date 2019/7/17
 */
public class Chart {
    private int id;
    private String org;
    private String sql_str;
    private String title;
    private String type;
    private String bar_name;

    //要求存入数据库中的X轴的参数之间有且只有一个空格分隔开
    private String x_axis;

    private String remake;

    public Chart() {
    }

    public Chart(String org, String sql_str, String title, String type, String x_axis, String barname, String remake) {
        this.org = org;
        this.sql_str = sql_str;
        this.title = title;
        this.type = type;
        this.bar_name = barname;
        this.x_axis = x_axis;
        this.remake = remake;
    }

    public Chart(String org, String sql_str, String title, String type, String x_axis, String remake) {
        this.org = org;
        this.sql_str = sql_str;
        this.title = title;
        this.type = type;
        this.x_axis = x_axis;
        this.remake = remake;
    }

    public String getBar_name() {
        return bar_name;
    }

    public void setBar_name(String bar_name) {
        this.bar_name = bar_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getSql_str() {
        return sql_str;
    }

    public void setSql_str(String sql_str) {
        this.sql_str = sql_str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getX_axis() {
        return x_axis;
    }

    public void setX_axis(String x_axis) {
        this.x_axis = x_axis;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    @Override
    public String toString() {
        String str = "id:"+this.id+", org:"+this.org+", title:"+this.title+", type:"+this.type+
                ", x_axis:"+this.x_axis +", bar_name:"+this.bar_name +", sql_str:"+this.sql_str +", remake:"+this.remake+"\n";
        return str;
    }
}
