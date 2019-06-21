package com.dong.messageservice.message;

import com.dong.messageservice.model.Message;
import com.dong.messageservice.model.TransactionState;

public abstract class TransactionExcute {

    private TransactionLocal transactionLocal;



    public TransactionLocal getTransactionLocal() {
        return transactionLocal;
    }

    public void setTransactionLocal(TransactionLocal transactionLocal) {
        this.transactionLocal = transactionLocal;
    }
}
