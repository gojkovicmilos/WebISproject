package lms.plugin.chat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.plugin.chat.model.ChatMessage;
import lms.plugin.chat.repository.ChatMessageRepository;


@Service
public class ChatMessageService {

	@Autowired
	ChatMessageRepository chatMessageRepository;

	public ChatMessageService() {}
	
	public List<lms.plugin.chat.model.ChatMessage> getAllChatMessage() {
		return chatMessageRepository.findAll();
	}

	public void addChatMessage(ChatMessage o) {
		chatMessageRepository.save(o);
	}

	public Optional<lms.plugin.chat.model.ChatMessage> getChatMessageId(Long id) {
		return chatMessageRepository.findById(id);
	}

	



}