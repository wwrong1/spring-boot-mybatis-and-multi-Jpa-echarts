package com.wwr.echarts.mapper;

import com.wwr.echarts.model.Chart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ChartMapper {

    @Select("SELECT * FROM chart")
    List<Chart> getAll();

    @Select("SELECT * FROM chart WHERE org = #{org}")
    List<Chart> getOrgAll(String org);

    @Select("SELECT * FROM chart WHERE id = #{id}")
    Chart getOne(int id);

    @Insert("INSERT INTO chart (org,sql_str,title,type,x_axis,bar_name,remake) VALUES(#{org},#{sql_str},#{title},#{type},#{x_axis},#{bar_name},#{remake})")
    void insert(Chart chart);

    @Update("UPDATE chart SET org=#{org},sql_str=#{sql},title=#{title},type=#{type},x_axis=#{x_axis},bar_name=#{bar_name},remake=#{remake} WHERE id =#{id}")
    void update(Chart chart);

    @Delete("DELETE FROM chart WHERE id =#{id}")
    void delete(int id);

    int insertAndGetId(Chart chart);

}
