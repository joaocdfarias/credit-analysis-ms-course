package com.joaocdfarias.creditanalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.exceptions.StrategyException;
import com.joaocdfarias.creditanalysis.service.strategy.CalculateScore;

@Service
public class CreditAnalysisService {

  @Autowired
  private List<CalculateScore> calculateScoreList;

  @Autowired
  private NotifyRabbitMqService notifyRabbitMqService;

  @Value("${rabbitmq.finishedproposal.exchange}")
  private String finishedProposalExchange;

  public void analyse(Proposal proposal) {
    try {
      int score = calculateScoreList.stream().mapToInt(impl -> impl.calculate(proposal)).sum();
      proposal.setApproved(score > 350);
    } catch (StrategyException exception) {
      proposal.setApproved(false);
      proposal.setObservation(exception.getMessage());
    }

    notifyRabbitMqService.notify(finishedProposalExchange, proposal);
  }
}
