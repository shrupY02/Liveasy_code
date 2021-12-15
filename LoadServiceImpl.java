package com.shruti_liveasy.shruti_liveasy.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shruti_liveasy.shruti_liveasy.dao.LoadDao;
import com.shruti_liveasy.shruti_liveasy.entities.Load;

@Service
public class LoadServiceImpl implements LoadService {

	@Autowired
	private LoadDao loadDao;
//	List<Load> list1 ;
	
	public LoadServiceImpl() {
	//	list1=new ArrayList<>();
		//list1.add(new Load("Delhi","Jaipur","chemicals",1,100,184,"13/10"));
		//list1.add(new Load("Satna","Vadodara","Acid",2,250,200,"20/02"));
	}
	
	@Override
	public List<Load> getLoads() {
		
		return loadDao.findAll();
	}

	@Override
	public Load getLoads(long shipperId) {
		//Load l=null;
		//for(Load load: list1 )
		//{
		//	if(load.getShipperId()== shipperId)
		//	{
		//		l=load;
		//		break;
		//	}
		//}
		return loadDao.getById(shipperId);
	}

	@Override
	public Load addLoad(Load load) {
		
		//list1.add(load);
		loadDao.save(load);
		return load;
	}

	@Override
	public Load updateLoad(Load load) {
		
		//list1.forEach(e ->{
		//	if(e.getShipperId() ==load.getShipperId()) {
		//		e.setLoadingPoint(load.getLoadingPoint());
		//		e.setUnloadingPoint(load.getUnloadingPoint());
		//		e.setProductType(load.getProductType());
		//		e.setNoOfTrucks(load.getNoOfTrucks());
		//		e.setWeight(load.getWeight());
		//	}
		//});
		loadDao.save(load);
		return load;
	}

	@Override
	public void deleteLoad(long parseLong) {
		
	//	list1=this.list1.stream().filter(e->e.getShipperId()!=parseLong).collect(Collectors.toList());
		
		Load entity=loadDao.getById(parseLong);
		loadDao.delete(entity);
		
	}



}
