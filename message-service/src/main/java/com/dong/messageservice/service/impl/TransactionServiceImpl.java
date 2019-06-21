package com.dong.messageservice.service.impl;

import com.dong.messageservice.model.TransactionProducer;
import com.dong.messageservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final String sql="select * from transaction_producer where msg_status =0 and create_time < DATE_ADD(now(),INTERVAL -5 MINUTE)";
    private static final String setDone = "UPDATE transaction_producer set msg_status =1 where id = ";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<TransactionProducer> getTimeoutMsg(){
        List<TransactionProducer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TransactionProducer.class));
        System.out.println(list.toString());
        return list;
    }

    @Override
    public boolean sendDone(TransactionProducer transactionProducer) {
        jdbcTemplate.execute(setDone+transactionProducer.getId());
        return false;
    }


}
