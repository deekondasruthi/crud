package curd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curd.dto.RequestDto;
import curd.dto.ResponseModel;
import curd.entity.CurdEntity;
import curd.repository.CurdRepository;



@Service
public class CurdService {
	
	
	@Autowired
	private CurdRepository repository;

	public ResponseModel create(RequestDto dto) {
		ResponseModel response=new ResponseModel();
	
			 CurdEntity model=new CurdEntity();
			 model.setName(dto.getName());
			 model.setAge(dto.getAge());
			 model.setBloodGroup(dto.getBloodGroup());
			 repository.save(model);
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		
		return response;
	}

	public ResponseModel getAll() {
		
		ResponseModel response=new ResponseModel();
		List<CurdEntity>model=repository.findAll();
		if (!model.isEmpty()) {
			
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		} else {
			 response.setFlag(2);
			 response.setResponseMessage("Data Not Found");

		}
		return response;
	}

	public ResponseModel update(int id, RequestDto dto) {
		ResponseModel response=new ResponseModel();
		Optional<CurdEntity>optModel=repository.findById(id);
		if (optModel.isPresent()) {
			CurdEntity model=optModel.get();
			model.setName(dto.getName());
			model.setAge(dto.getAge());
			model.setBloodGroup(dto.getBloodGroup());
			repository.save(model);
			
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		} else {
			
			 response.setFlag(2);
			 response.setResponseMessage("Data Not Found");

		}
		return response;
	}

	public ResponseModel delete(int id) {
		ResponseModel response=new ResponseModel();
	repository.deleteById(id);
	response.setFlag(1);
	response.setResponseMessage("Succss");
		return response;
	}

	public ResponseModel getById(int id) {
		ResponseModel response=new ResponseModel();
		Optional<CurdEntity>optModel=repository.findById(id);
		if (optModel.isPresent()) {
			CurdEntity model=optModel.get();
			
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		} else {
			
			 response.setFlag(2);
			 response.setResponseMessage("Data Not Found");

		}
		return response;
	}

}
