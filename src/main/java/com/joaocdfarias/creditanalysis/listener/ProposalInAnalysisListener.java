package com.joaocdfarias.creditanalysis.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.joaocdfarias.creditanalysis.domain.Proposal;

@Configuration
public class ProposalInAnalysisListener {

  @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
  public void proposalInAnalysis(Proposal proposal) {
  }
}
