package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbSyslog;
import com.jpms.zl.pojo.TbSyslogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSyslogMapper {
    int countByExample(TbSyslogExample example);

    int deleteByExample(TbSyslogExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbSyslog record);

    int insertSelective(TbSyslog record);

    List<TbSyslog> selectByExample(TbSyslogExample example);

    TbSyslog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbSyslog record, @Param("example") TbSyslogExample example);

    int updateByExample(@Param("record") TbSyslog record, @Param("example") TbSyslogExample example);

    int updateByPrimaryKeySelective(TbSyslog record);

    int updateByPrimaryKey(TbSyslog record);
}