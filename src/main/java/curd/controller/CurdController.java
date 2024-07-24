package curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curd.dto.RequestDto;
import curd.dto.ResponseModel;
import curd.service.CurdService;


@RestController
@RequestMapping("curds")
public class CurdController {
	
	

	@Autowired 
	private CurdService curdService;
	
	
	@PostMapping("/add")
	public ResponseModel create(@RequestBody RequestDto dto) {
		return curdService.create(dto);

	}
	@GetMapping("/getall")
	public ResponseModel getAll() {
		return curdService.getAll();

	}
	
	@PutMapping("/update/{id}")
	public ResponseModel update(@PathVariable("id")int id,@RequestBody RequestDto dto) {
		return curdService.update(id,dto);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseModel delete(@PathVariable("id")int id) {
		return curdService.delete(id);

	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseModel getById(@PathVariable("id") int id) {
		return curdService.getById(id);

	}

}
