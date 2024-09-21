package com.alibou.websocket.conference;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Signaling server to WebRTC video conferencing.
 */
@Component
@ServerEndpoint("/signal")
public class WebRtcSignalingEndpoint {

	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void whenOpening(Session session) throws IOException, EncodeException {
		System.out.println("Open!");
		// Add websocket session to a global set to use in OnMessage.
		sessions.add(session);
	}

	@OnMessage
	public void process(String data, Session session) throws IOException {
		System.out.println("Got signal - " + data);
		/*
		 * When signal is received, send it to other participants other than self. In
		 * real world, signal should be sent to only participant's who belong to
		 * particular video conference.
		 */
		for (Session sess : sessions) {
			if (!sess.equals(session)) {
				sess.getBasicRemote().sendText(data);
			}
		}
	}

	@OnClose
	public void whenClosing(Session session) {
		System.out.println("Close!");
		sessions.remove(session);
	}

}
