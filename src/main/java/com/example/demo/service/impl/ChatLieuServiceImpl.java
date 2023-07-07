package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.ChatLieuRepository;
import com.example.demo.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    private final ChatLieuRepository chatLieuRepository;

    @Autowired
    public ChatLieuServiceImpl(ChatLieuRepository chatLieuRepository) {
        this.chatLieuRepository = chatLieuRepository;
    }

    @Override
    public List<ChatLieu> getAllChatLieu() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu getChatLieuById(Integer id) {
        return chatLieuRepository.findById(id).orElse(null);
    }

    @Override
    public void saveChatLieu(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }

    @Override
    public void deleteChatLieu(Integer id) {
        chatLieuRepository.deleteById(id);
    }
}
