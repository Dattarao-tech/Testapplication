package com.springboot.web.security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.security.Entity.FileProccessorScheduler;
import com.springboot.web.security.Entity.TestEntity;
import com.springboot.web.security.Repository.TestRepo;

@Service
public class DataBaseService {
	
	@Autowired
	private TestRepo testrepo;
	
	@Autowired
	private FileProccessorScheduler fileProccessorScheduler;
	
	public TestEntity CreateData(TestEntity testEntity) {
		fileProccessorScheduler.processFile();
		TestEntity test=testrepo.save(testEntity);
		return test;
	}
	public TestEntity findById(Long Id) {
		Optional<TestEntity> findById = testrepo.findById(Id);
		return findById.get();		
	}
	public void DeletData(Long Id) {
		testrepo.deleteById(Id);
	}
	public void UpdateData(Long Id) {
		 Optional<TestEntity> optionalEntity = testrepo.findById(Id);
	        if (optionalEntity.isPresent()) {
	            TestEntity entity = optionalEntity.get();
	            entity.setData(entity.getData());
	            testrepo.save(entity);
	}
	}
}
