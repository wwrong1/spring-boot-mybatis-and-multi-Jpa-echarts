package com.wwr.echarts.mapper;

import com.wwr.echarts.model.ChartOption;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ChartOptionMapper {
    @Select("SELECT * FROM chart_option")
    List<ChartOption> getAll();

    @Select("SELECT * FROM chart_option WHERE type = #{type}")
    ChartOption getOne(String type);

    @Insert("INSERT INTO chart_option (type,c_option) VALUES(#{type},#{option})")
    void insert(ChartOption chartOption);

    @Update("UPDATE chart_option SET type=#{type},option=#{option} WHERE id =#{id}")
    void update(ChartOption chartOption);

    @Delete("DELETE FROM chart_option WHERE id =#{id}")
    void delete(int id);
}
