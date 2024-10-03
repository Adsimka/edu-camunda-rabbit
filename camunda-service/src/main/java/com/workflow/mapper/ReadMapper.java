package com.workflow.mapper;

import com.workflow.domain.User;
import com.workflow.dto.ReadUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReadMapper extends BaseMapper<User, ReadUserDto> {
}
