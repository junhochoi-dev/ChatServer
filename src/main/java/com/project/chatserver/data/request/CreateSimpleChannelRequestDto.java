package com.project.chatserver.data.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSimpleChannelRequestDto {
	Long senderId;
	Long receiverId;
}
