package com.joaocdfarias.creditanalysis.service.strategy.impl;

import java.util.Random;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculatePoint;

public class LoansInProgressImpl implements CalculatePoint {

  private Random random = new Random();

  @Override
  public int calculate(Proposal proposal) {

    if (hasLoansInProgress()) {
      return 0;
    }

    return 80;
  }

  private boolean hasLoansInProgress() {
    return random.nextBoolean();
  }

}
