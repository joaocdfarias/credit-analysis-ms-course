package com.joaocdfarias.creditanalysis.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.joaocdfarias.creditanalysis.domain.Proposal;

@Service
public class NotifyRabbitMqService {

  private RabbitTemplate rabbitTemplate;

  public NotifyRabbitMqService(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void notify(String exchange, Proposal proposal) {
    rabbitTemplate.convertAndSend(exchange, "", proposal);
  }

}
