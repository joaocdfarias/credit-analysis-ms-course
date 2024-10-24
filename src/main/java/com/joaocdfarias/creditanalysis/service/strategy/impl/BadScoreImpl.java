package com.joaocdfarias.creditanalysis.service.strategy.impl;

import java.util.Random;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.joaocdfarias.creditanalysis.constants.MessageConstant;
import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.exceptions.StrategyException;
import com.joaocdfarias.creditanalysis.service.strategy.CalculateScore;

@Order(1)
@Component
public class BadScoreImpl implements CalculateScore {

  private Random random = new Random();

  @Override
  public int calculate(Proposal proposal) {
    if (hasBadCredit()) {
      throw new StrategyException(String.format(MessageConstant.BAD_SCORE, proposal.getUser().getName()));
    }

    return 100;
  }

  private boolean hasBadCredit() {
    return random.nextBoolean();
  }

}
