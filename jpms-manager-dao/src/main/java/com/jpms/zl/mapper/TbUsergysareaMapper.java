package com.jpms.zl.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jpms.zl.pojo.TbUsergysarea;
import com.jpms.zl.pojo.TbUsergysareaExample;



public interface TbUsergysareaMapper {
    int countByExample(TbUsergysareaExample example);

    int deleteByExample(TbUsergysareaExample example);

    int insert(TbUsergysarea record);

    int insertSelective(TbUsergysarea record);

    List<TbUsergysarea> selectByExample(TbUsergysareaExample example);

    int updateByExampleSelective(@Param("record") TbUsergysarea record, @Param("example") TbUsergysareaExample example);

    int updateByExample(@Param("record") TbUsergysarea record, @Param("example") TbUsergysareaExample example);
}