package com.example.demo.service;

import com.example.demo.entity.ChatLieu;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAllChatLieu();

    ChatLieu getChatLieuById(Integer id);

    void saveChatLieu(ChatLieu chatLieu);

    void deleteChatLieu(Integer id);
}
