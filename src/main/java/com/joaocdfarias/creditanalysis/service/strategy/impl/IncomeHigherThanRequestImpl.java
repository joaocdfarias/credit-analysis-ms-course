package com.joaocdfarias.creditanalysis.service.strategy.impl;

import org.springframework.stereotype.Component;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculateScore;

@Component
public class IncomeHigherThanRequestImpl implements CalculateScore {

  @Override
  public int calculate(Proposal proposal) {
    if(isIncomeHigherThanRequested(proposal)) {
      return 100;
    }

    return 0;
  }

  private boolean isIncomeHigherThanRequested(Proposal proposal) {
    Double income = proposal.getUser().getIncome();
    return income > proposal.getRequestedAmount();
  }

}
