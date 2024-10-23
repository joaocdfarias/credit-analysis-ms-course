package com.joaocdfarias.creditanalysis.service.strategy.impl;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculatePoint;

public class IncomeHigherThanRequestImpl implements CalculatePoint {

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
