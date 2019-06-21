package com.dong.messageservice.message;

import com.dong.messageservice.model.Message;
import com.dong.messageservice.model.TransactionState;

public interface TransactionLocal {

    public TransactionState executeLocalTransaction(Message msg);

    public TransactionState checkLocalTransaction(Message msg);

}
