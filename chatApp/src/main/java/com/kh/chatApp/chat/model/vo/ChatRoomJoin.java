package com.kh.chatApp.chat.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomJoin {
	
	private int userNo;
	private int chatRoomNo;
	private int userStatus;
}
