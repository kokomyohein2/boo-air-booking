package io.codeandpaan.booairbookingtx.service;

import io.codeandpaan.booairbookingtx.annotation.AccountTx;
import io.codeandpaan.booairbookingtx.annotation.OrderTx;
import org.springframework.stereotype.Service;

@Service
public class TransactionalService {
    String fullName;

    @OrderTx
    public void setSomething(String name) {
        fullName = name + "full";
    }

    @AccountTx
    public void doSomething() {
        fullName = fullName.repeat(5);
    }
}
