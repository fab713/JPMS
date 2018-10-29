package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbSysoperation;
import com.jpms.zl.pojo.TbSysoperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysoperationMapper {
    int countByExample(TbSysoperationExample example);

    int deleteByExample(TbSysoperationExample example);

    int deleteByPrimaryKey(String operateid);

    int insert(TbSysoperation record);

    int insertSelective(TbSysoperation record);

    List<TbSysoperation> selectByExample(TbSysoperationExample example);

    TbSysoperation selectByPrimaryKey(String operateid);

    int updateByExampleSelective(@Param("record") TbSysoperation record, @Param("example") TbSysoperationExample example);

    int updateByExample(@Param("record") TbSysoperation record, @Param("example") TbSysoperationExample example);

    int updateByPrimaryKeySelective(TbSysoperation record);

    int updateByPrimaryKey(TbSysoperation record);
}