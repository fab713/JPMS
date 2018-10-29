package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbUserrole;
import com.jpms.zl.pojo.TbUserroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserroleMapper {
    int countByExample(TbUserroleExample example);

    int deleteByExample(TbUserroleExample example);

    int insert(TbUserrole record);

    int insertSelective(TbUserrole record);

    List<TbUserrole> selectByExample(TbUserroleExample example);

    int updateByExampleSelective(@Param("record") TbUserrole record, @Param("example") TbUserroleExample example);

    int updateByExample(@Param("record") TbUserrole record, @Param("example") TbUserroleExample example);
}