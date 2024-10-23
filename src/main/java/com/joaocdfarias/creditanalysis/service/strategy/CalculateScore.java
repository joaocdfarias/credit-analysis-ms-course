package com.joaocdfarias.creditanalysis.service.strategy;

import com.joaocdfarias.creditanalysis.domain.Proposal;

public interface CalculateScore {

  int calculate(Proposal proposal);
}
