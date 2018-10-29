package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbDicttype;
import com.jpms.zl.pojo.TbDicttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDicttypeMapper {
    int countByExample(TbDicttypeExample example);

    int deleteByExample(TbDicttypeExample example);

    int insert(TbDicttype record);

    int insertSelective(TbDicttype record);

    List<TbDicttype> selectByExample(TbDicttypeExample example);

    int updateByExampleSelective(@Param("record") TbDicttype record, @Param("example") TbDicttypeExample example);

    int updateByExample(@Param("record") TbDicttype record, @Param("example") TbDicttypeExample example);
}