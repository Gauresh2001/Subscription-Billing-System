package com.billing.service.impl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.billing.dto.PaymentDTO;
import com.billing.entity.Payment;
import com.billing.entity.Subscription;
import com.billing.repository.PaymentRepository;
import com.billing.repository.SubscriptionRepository;
import com.billing.service.PaymentService;

@Service
public class PaymentServiceImpl
        implements PaymentService {

    private PaymentRepository
            paymentRepository;

    private SubscriptionRepository
            subscriptionRepository;

    public PaymentServiceImpl(
            PaymentRepository paymentRepository,
            SubscriptionRepository subscriptionRepository) {

        this.paymentRepository =
                paymentRepository;

        this.subscriptionRepository =
                subscriptionRepository;
    }

    @Override
    public PaymentDTO createPayment(
            PaymentDTO paymentDTO) {

        Subscription subscription =
                subscriptionRepository.findById(
                        paymentDTO.getSubscriptionId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Subscription Not Found"));

        Payment payment =
                Payment.builder()
                .amount(paymentDTO.getAmount())
                .paymentMethod(
                        paymentDTO.getPaymentMethod())
                .paymentStatus(
                        paymentDTO.getPaymentStatus())
                .paymentDate(
                        LocalDateTime.now())
                .subscription(subscription)
                .build();

        Payment savedPayment =
                paymentRepository.save(payment);

        return mapToDTO(savedPayment);
    }

    @Override
    public PaymentDTO getPaymentById(
            Long id) {

        Payment payment =
                paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Payment Not Found"));

        return mapToDTO(payment);
    }

    @Override
    public List<PaymentDTO>
    getAllPayments() {

        return paymentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO updatePayment(
            Long id,
            PaymentDTO paymentDTO) {

        Payment payment =
                paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Payment Not Found"));

        Subscription subscription =
                subscriptionRepository.findById(
                        paymentDTO.getSubscriptionId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Subscription Not Found"));

        payment.setAmount(
                paymentDTO.getAmount());

        payment.setPaymentMethod(
                paymentDTO.getPaymentMethod());

        payment.setPaymentStatus(
                paymentDTO.getPaymentStatus());

        payment.setSubscription(
                subscription);

        Payment updatedPayment =
                paymentRepository.save(payment);

        return mapToDTO(updatedPayment);
    }

    @Override
    public void deletePayment(
            Long id) {

        Payment payment =
                paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Payment Not Found"));

        paymentRepository.delete(payment);
    }

    private PaymentDTO mapToDTO(
            Payment payment) {

        return PaymentDTO.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentMethod(
                        payment.getPaymentMethod())
                .paymentStatus(
                        payment.getPaymentStatus())
                .paymentDate(
                        payment.getPaymentDate())
                .subscriptionId(
                        payment.getSubscription()
                        .getId())
                .build();
    }
}
