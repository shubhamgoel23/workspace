package com.spring.ssm.services;

import org.springframework.statemachine.StateMachine;

import com.spring.ssm.domain.Payment;
import com.spring.ssm.domain.PaymentEvent;
import com.spring.ssm.domain.PaymentState;

public interface PaymentService {
	
	Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);

}
