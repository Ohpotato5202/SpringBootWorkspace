package com.kh.chatApp.chat.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/* 
 * Stomp 
 *  - publish 발행 / subscribe 구독패턴 
 *  - 특정 url을 "구독"하고있는 클라이언트에게 메세지를 "발행"해줌
 * */

@EnableWebSocketMessageBroker
@Configuration
public class StompConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry
			.addEndpoint("/stompServer")
			.setAllowedOrigins("http://localhost:3000")
			.withSockJS();
	}

	//메세지브로커 설정
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		//브로커 활성화
		// '/chat' 들어오는 메세지를 중계 
		registry
			.enableSimpleBroker("/chat");
		
		//
		registry.setApplicationDestinationPrefixes("/chat");
	}

	
	
	
	
	
	
	
}
