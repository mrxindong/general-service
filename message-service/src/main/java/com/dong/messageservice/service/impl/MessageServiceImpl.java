package com.dong.messageservice.service.impl;

import com.dong.messageservice.model.Message;
import com.dong.messageservice.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public boolean sendTranMessage(Message message) {
        return false;
    }
}
