package com.joaocdfarias.creditanalysis.service.strategy.impl;

import java.util.Random;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculateScore;

public class ScoreImpl implements CalculateScore {

  private Random random = new Random();

  @Override
  public int calculate(Proposal proposal) {
    int score = score();

    if (score <= 200) {
      throw new RuntimeException("Low score");
    } else if (score <= 400) {
      return 150;
    } else if (score <= 600) {
      return 180;
    } else {
      return 220;
    }

  }

  private int score() {
    return random.nextInt(0, 1000);
  }
}
