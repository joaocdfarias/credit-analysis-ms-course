package com.joaocdfarias.creditanalysis.service.strategy.impl;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculateScore;

public class PaymentDeadlineInTenYearsImpl implements CalculateScore {

  @Override
  public int calculate(Proposal proposal) {
    if (proposal.getPaymentDeadline() < 120) {
      return 80;
    }

    return 0;
  }

}
