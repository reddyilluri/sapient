package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Vitals;
import com.pratian.AppointmentService.Exceptions.VitalsNotFoundException;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Repository.VitalsRepo;
import com.pratian.AppointmentService.Service.VitalsService;


@Service
public class VitalsServiceImpl implements VitalsService {
	
	
	@Autowired
	private VitalsRepo vitalsrepo;
	
	@Autowired
	IAppointmentRepo appointmentrepo;
	public VitalsServiceImpl()
	{
		
		
	}
	

	//get list of all vitals or view vitals
	
//	@Override
//	public List<Vitals> getVitals() {	
//		
//		//return list;
//		
//		return vitalsrepo.findAll();
//		
//		
//	}
	
	
	@Override
    public List<Vitals> getVitals() throws VitalsNotFoundException {  

        if(vitalsrepo.findAll() != null)
        {
            return vitalsrepo.findAll();
        }
        else
        {
            throw new VitalsNotFoundException("not found");
        }


    }
	
    //get one  vitals by vital id
	@Override
	public Vitals getVitalsById(long vitalsId) throws  VitalsNotFoundException {
		
		
		//return vitalsrepo.findByvitalId(vitalsId).orElseThrow(() -> new VitalsNotFoundException(vitalsId));
		if( vitalsrepo.existsById(vitalsId))
		{
		return	vitalsrepo.findByvitalId(vitalsId);
			
		}else 
		{
			throw new VitalsNotFoundException("Vitals of that id is  not found  ");
		}
		
	}
		

	
	//save vitals or add vitals by vital id
	@Override
	public Vitals saveVital(Vitals vital) throws  VitalsNotFoundException  {
		
		
		Vitals status;
		status= vitalsrepo.save(vital);
		
		if (status != null)
		{
		return vital;
		}
		else
		{
			throw new VitalsNotFoundException("Vitals not saved  ");
		}
	}

	
	//update vitals by id by vital id
		@Override
		public Vitals updateVital(long vitalsId,Vitals vital)  throws  VitalsNotFoundException  {
		
			if( vitalsrepo.existsById(vitalsId))
			{
				Vitals v = vitalsrepo.findById(vitalsId).get();
				v.setECG(vital.getECG());
				v.setDiabetes(vital.getDiabetes());
				v.setTemperature(vital.getTemperature());
				v.setRespiration_rate(vital.getRespiration_rate());
				return vitalsrepo.save(v);
				//return vital;
			}else
			{
				
				throw new VitalsNotFoundException("Vitals of that id is  not found  ");
			}
		}







	
	
	


}
