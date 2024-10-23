package com.joaocdfarias.creditanalysis.service.strategy;

import com.joaocdfarias.creditanalysis.domain.Proposal;

public interface CalculatePoint {

  int calculate(Proposal proposal);
}
