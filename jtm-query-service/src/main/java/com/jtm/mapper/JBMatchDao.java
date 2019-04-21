package com.jtm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface JBMatchDao {
    @Select("select matchname from jbmatch where matchid = #{id}")
    String findNameById(@Param("id")String id);
}
