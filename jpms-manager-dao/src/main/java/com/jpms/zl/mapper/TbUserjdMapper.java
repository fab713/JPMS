package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbUserjd;
import com.jpms.zl.pojo.TbUserjdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserjdMapper {
    int countByExample(TbUserjdExample example);

    int deleteByExample(TbUserjdExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbUserjd record);

    int insertSelective(TbUserjd record);

    List<TbUserjd> selectByExample(TbUserjdExample example);

    TbUserjd selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUserjd record, @Param("example") TbUserjdExample example);

    int updateByExample(@Param("record") TbUserjd record, @Param("example") TbUserjdExample example);

    int updateByPrimaryKeySelective(TbUserjd record);

    int updateByPrimaryKey(TbUserjd record);
}