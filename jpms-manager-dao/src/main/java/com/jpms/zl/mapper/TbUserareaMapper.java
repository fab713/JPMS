package com.jpms.zl.mapper;

import com.jpms.zl.pojo.TbUserarea;
import com.jpms.zl.pojo.TbUserareaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserareaMapper {
    int countByExample(TbUserareaExample example);

    int deleteByExample(TbUserareaExample example);

    int insert(TbUserarea record);

    int insertSelective(TbUserarea record);

    List<TbUserarea> selectByExample(TbUserareaExample example);

    int updateByExampleSelective(@Param("record") TbUserarea record, @Param("example") TbUserareaExample example);

    int updateByExample(@Param("record") TbUserarea record, @Param("example") TbUserareaExample example);
}