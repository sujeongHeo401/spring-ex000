package net.sjgang.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// ; 없어야 한다.
	@Select("select sysdate from dual")
	String getTime();

}
