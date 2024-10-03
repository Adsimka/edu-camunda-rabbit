package com.workflow.mapper;

import com.workflow.domain.User;
import com.workflow.dto.CreateUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserMapper extends BaseMapper<CreateUserDto, User> {
}
