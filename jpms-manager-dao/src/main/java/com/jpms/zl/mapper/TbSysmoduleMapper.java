package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbSysmodule;
import com.jpms.zl.pojo.TbSysmoduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysmoduleMapper {
    int countByExample(TbSysmoduleExample example);

    int deleteByExample(TbSysmoduleExample example);

    int deleteByPrimaryKey(String moduleid);

    int insert(TbSysmodule record);

    int insertSelective(TbSysmodule record);

    List<TbSysmodule> selectByExample(TbSysmoduleExample example);

    TbSysmodule selectByPrimaryKey(String moduleid);

    int updateByExampleSelective(@Param("record") TbSysmodule record, @Param("example") TbSysmoduleExample example);

    int updateByExample(@Param("record") TbSysmodule record, @Param("example") TbSysmoduleExample example);

    int updateByPrimaryKeySelective(TbSysmodule record);

    int updateByPrimaryKey(TbSysmodule record);
}