package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbBasicinfo;
import com.jpms.zl.pojo.TbBasicinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBasicinfoMapper {
    int countByExample(TbBasicinfoExample example);

    int deleteByExample(TbBasicinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbBasicinfo record);

    int insertSelective(TbBasicinfo record);

    List<TbBasicinfo> selectByExample(TbBasicinfoExample example);

    TbBasicinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBasicinfo record, @Param("example") TbBasicinfoExample example);

    int updateByExample(@Param("record") TbBasicinfo record, @Param("example") TbBasicinfoExample example);

    int updateByPrimaryKeySelective(TbBasicinfo record);

    int updateByPrimaryKey(TbBasicinfo record);
}