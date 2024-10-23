package com.joaocdfarias.creditanalysis.service.strategy.impl;

import java.util.Random;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculatePoint;

public class BadCreditImpl implements CalculatePoint {

  private Random random = new Random();

  @Override
  public int calculate(Proposal proposal) {
    if (hasBadCredit()) {
      throw new RuntimeException("Bad credit");
    }

    return 100;
  }

  private boolean hasBadCredit() {
    return random.nextBoolean();
  }

}