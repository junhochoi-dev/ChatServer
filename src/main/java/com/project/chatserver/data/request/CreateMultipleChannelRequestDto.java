package com.project.chatserver.data.request;

import com.project.chatserver.domain.type.AccessType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMultipleChannelRequestDto {
	Long memberId;
	String name;
	AccessType accessType;
}
