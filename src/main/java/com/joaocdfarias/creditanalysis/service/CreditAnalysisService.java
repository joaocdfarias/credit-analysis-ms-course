package com.joaocdfarias.creditanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaocdfarias.creditanalysis.domain.Proposal;
import com.joaocdfarias.creditanalysis.service.strategy.CalculateScore;

@Service
public class CreditAnalysisService {

  private List<CalculateScore> calculateScoreList;

  public CreditAnalysisService(List<CalculateScore> calculateScoreList) {
    this.calculateScoreList = calculateScoreList;
  }

  public void analyse(Proposal proposal) {
    calculateScoreList.stream().mapToInt(impl -> impl.calculate(proposal));
  }
}
