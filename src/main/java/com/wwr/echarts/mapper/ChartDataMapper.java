package com.wwr.echarts.mapper;

import com.wwr.echarts.model.ChartData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChartDataMapper {

    @Select("select * from chart_data")
    List<ChartData> getAll();

}
