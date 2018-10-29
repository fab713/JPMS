package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbUsergys;
import com.jpms.zl.pojo.TbUsergysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUsergysMapper {
    int countByExample(TbUsergysExample example);

    int deleteByExample(TbUsergysExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbUsergys record);

    int insertSelective(TbUsergys record);

    List<TbUsergys> selectByExampleWithBLOBs(TbUsergysExample example);

    List<TbUsergys> selectByExample(TbUsergysExample example);

    TbUsergys selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUsergys record, @Param("example") TbUsergysExample example);

    int updateByExampleWithBLOBs(@Param("record") TbUsergys record, @Param("example") TbUsergysExample example);

    int updateByExample(@Param("record") TbUsergys record, @Param("example") TbUsergysExample example);

    int updateByPrimaryKeySelective(TbUsergys record);

    int updateByPrimaryKeyWithBLOBs(TbUsergys record);

    int updateByPrimaryKey(TbUsergys record);
}