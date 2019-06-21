package com.dong.messageservice.service;

import com.dong.messageservice.model.TransactionProducer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {
    /**
     * 获取已执行未发送的消息
     * @return
     */
    public List<TransactionProducer> getTimeoutMsg();

    public boolean sendDone(TransactionProducer transactionProducer);
}
