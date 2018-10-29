package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbSysrole;
import com.jpms.zl.pojo.TbSysroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysroleMapper {
    int countByExample(TbSysroleExample example);

    int deleteByExample(TbSysroleExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbSysrole record);

    int insertSelective(TbSysrole record);

    List<TbSysrole> selectByExample(TbSysroleExample example);

    TbSysrole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSysrole record, @Param("example") TbSysroleExample example);

    int updateByExample(@Param("record") TbSysrole record, @Param("example") TbSysroleExample example);

    int updateByPrimaryKeySelective(TbSysrole record);

    int updateByPrimaryKey(TbSysrole record);
}