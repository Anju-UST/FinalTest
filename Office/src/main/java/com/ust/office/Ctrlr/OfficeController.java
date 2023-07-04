package com.ust.office.Ctrlr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.office.Model.Student;

@RestController
@RequestMapping("/office")
public class OfficeController {
	@Autowired
	RestTemplate template;
	
	@PostMapping("/addstud")
	public Student addstud(@RequestBody Student s ){
		String url="http://localhost:7071/stud/create";
		ResponseEntity<Student> response= template.postForEntity(url, s, Student.class);
		return response.getBody();
	}
	
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable long id) {
		String url="http://localhost:7071/stud/get/{id}";
		return template.getForObject(url, Student.class,id);
	}
	
	@GetMapping("/ret/{id}")
	public Student retStudent(@PathVariable long id) {
		String url="http://localhost:7071/stud/get/{id}";
		ResponseEntity<Student> response =template.getForEntity(url, Student.class,id);
		return response.getBody();
	}
	
	@GetMapping("/getall")
	public List<Student> getall(){
		String url="http://localhost:7071/stud/getall";
		ResponseEntity<List> response=template.getForEntity(url, List.class);
		return response.getBody();
	}
	
	@GetMapping("/retall")
	public List<Student>retall(){
		String url="http://localhost:7071/stud/getall";
		List<Student> sjson=template.getForObject(url, List.class);
		return sjson;
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable Long id,@RequestBody Student s) {
		String url="http://localhost:7071/stud/update/{id}";
		template.put(url, s, id,Student.class);
		return s;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		String url="http://localhost:7071/stud/{id}";
		template.delete(url, id,Student.class);
		return ResponseEntity.ok("deleted");
				
	}
	
	
	
	

}
