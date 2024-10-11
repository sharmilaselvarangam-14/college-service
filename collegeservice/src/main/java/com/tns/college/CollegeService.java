package com.tns.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollegeService {
    @Autowired
    private CollegeRepository repo;
    
    public List<College> listAll() {
        return repo.findAll();
    }
    
    public void save(College placement) {
        repo.save(placement);
    }
    
    public College get(Integer placementId) {
        return repo.findById(placementId).orElse(null);
    }
    
    public void delete(Integer placementId) {
        repo.deleteById(placementId);
    }
}
