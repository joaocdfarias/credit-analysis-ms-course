package com.joaocdfarias.creditanalysis.service.strategy.impl;

import org.springframework.stereotype.Component;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculateScore;

@Component
public class PaymentDeadlineInTenYearsImpl implements CalculateScore {

  @Override
  public int calculate(Proposal proposal) {
    if (proposal.getPaymentDeadline() < 120) {
      return 80;
    }

    return 0;
  }

}
