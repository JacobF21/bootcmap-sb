package com.demo.demo_defillama.service;

import java.util.List;
import com.demo.demo_defillama.model.DataPoint;

public interface DefiLlamaService {
  List<DataPoint> getEthTvl();
}
