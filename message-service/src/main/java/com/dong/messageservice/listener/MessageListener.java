package com.dong.messageservice.listener;

import com.dong.messageservice.message.TransactionLocal;
import com.dong.messageservice.model.Message;
import com.dong.messageservice.model.TransactionProducer;
import com.dong.messageservice.service.MessageService;
import com.dong.messageservice.service.TransactionService;
import com.dong.messageservice.util.SpringContextHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class MessageListener implements ServletContextListener {

    @Autowired
    TransactionService transactionService;

    @Autowired
    MessageService messageService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        while (true) {
            List<TransactionProducer> transactionProducerList = transactionService.getTimeoutMsg();
            if (null != transactionProducerList && transactionProducerList.size() > 0) {
                for (TransactionProducer transactionProducer : transactionProducerList) {
                    Message message = new Message();
                    BeanUtils.copyProperties(transactionProducer,message);
                    TransactionLocal transactionLocal = SpringContextHolder.getBean(TransactionLocal.class);
                    transactionLocal.checkLocalTransaction(message);

                    boolean isSend = messageService.sendTranMessage(message);
                    if(isSend){
                        transactionService.sendDone(transactionProducer);
                    }
                }
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
