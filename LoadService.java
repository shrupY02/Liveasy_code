package com.shruti_liveasy.shruti_liveasy.services;

import java.util.List;

import com.shruti_liveasy.shruti_liveasy.entities.Load;

public interface LoadService {

	public List<Load> getLoads();
	
	public Load getLoads(long shipperId);
	
	public Load addLoad(Load load);
	
	public Load updateLoad( Load load);
	
	public void deleteLoad(long parselong);
	
}
