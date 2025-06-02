package com.springboot.web.security;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.springboot.web.security.Repository.TestRepo;
@SpringBootApplication
//@EnableScheduling
public class CrudoprojectApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(CrudoprojectApplication.class, args);
	}
	@Autowired
	private TestRepo testRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		TestEntity te = new TestEntity();
//	
//		te.setData("this si sothige datat need to save");
//
//		testRepo.save(te);
		   ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		   
	        // Get the thread IDs of all threads in the JVM
	        long[] threadIds = threadMXBean.getAllThreadIds();
	        
	        // Get the ThreadInfo for each thread
	        ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
	        
	        // Count the total number of threads
	        int totalThreads = threadInfos.length;

	        // Print the total number of threads
	        System.out.println("Total number of threads: " + totalThreads);
	        
	}	
}
