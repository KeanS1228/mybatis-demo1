package org.shitj.mapper;

import org.apache.ibatis.annotations.Select;

//@Mapper
public interface TestMapper {

    @Select("select 'test'")
    String selectById();

}
