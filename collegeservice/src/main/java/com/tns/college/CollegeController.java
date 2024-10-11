package com.tns.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class CollegeController {
    @Autowired(required = true)
    private CollegeService service;
    
    @GetMapping("/collegeservice")
    public java.util.List<College> list() {
        return service.listAll();
    }
    
    @GetMapping("/collegeservice/{collegeId}")
    public ResponseEntity<College> get(@PathVariable Integer collegeId) {
        try {
            College college = service.get(collegeId);
            return new ResponseEntity<College>(college, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/registerCollege")
    public void add(@RequestBody College college) {
        service.save(college);
    }
    
    @PutMapping("/collegeservice/{collegeId}")
    public ResponseEntity<?> update(@RequestBody College college, @PathVariable Integer collegeId) {
        College existCollege = service.get(collegeId);
        if (existCollege != null) {
            college.setCollegeId(collegeId);
            service.save(college);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/collegeservice/{collegeId}")
    public void delete(@PathVariable Integer collegeId) {
        service.delete(collegeId);
    }
}
