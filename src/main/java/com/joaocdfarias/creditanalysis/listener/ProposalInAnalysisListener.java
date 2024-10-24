package com.joaocdfarias.creditanalysis.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.CreditAnalysisService;

@Configuration
public class ProposalInAnalysisListener {

  private final CreditAnalysisService creditAnalysisService;

  public ProposalInAnalysisListener(CreditAnalysisService creditAnalysisService) {
    this.creditAnalysisService = creditAnalysisService;
  }

  @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
  public void proposalInAnalysis(Proposal proposal) {
    creditAnalysisService.analyse(proposal);
  }
}
