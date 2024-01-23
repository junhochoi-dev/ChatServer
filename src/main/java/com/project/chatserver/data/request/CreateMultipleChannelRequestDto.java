package com.project.chatserver.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMultipleChannelRequestDto {
	Long memberId;
	String name;
}
