package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbSysrolemodule;
import com.jpms.zl.pojo.TbSysrolemoduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysrolemoduleMapper {
    int countByExample(TbSysrolemoduleExample example);

    int deleteByExample(TbSysrolemoduleExample example);

    int insert(TbSysrolemodule record);

    int insertSelective(TbSysrolemodule record);

    List<TbSysrolemodule> selectByExample(TbSysrolemoduleExample example);

    int updateByExampleSelective(@Param("record") TbSysrolemodule record, @Param("example") TbSysrolemoduleExample example);

    int updateByExample(@Param("record") TbSysrolemodule record, @Param("example") TbSysrolemoduleExample example);
}