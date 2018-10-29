package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbUseryy;
import com.jpms.zl.pojo.TbUseryyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUseryyMapper {
    int countByExample(TbUseryyExample example);

    int deleteByExample(TbUseryyExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbUseryy record);

    int insertSelective(TbUseryy record);

    List<TbUseryy> selectByExample(TbUseryyExample example);

    TbUseryy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUseryy record, @Param("example") TbUseryyExample example);

    int updateByExample(@Param("record") TbUseryy record, @Param("example") TbUseryyExample example);

    int updateByPrimaryKeySelective(TbUseryy record);

    int updateByPrimaryKey(TbUseryy record);
}