package com.save.before.component;

//import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.save.before.dto.RequiredDto;
import com.save.before.repo.StudentRepository;

//@Component
@Service
public class ScheduledTasks {

	@Autowired
	private StudentRepository studentRepository;

	static Logger logger = LogManager.getLogger(ScheduledTasks.class);

	// private static final SimpleDateFormat dateFormat = new
	// SimpleDateFormat("HH:mm::ss");
	// private int currentPage =0;

	// @Scheduled(cron = "5 * * * * 5")
	public RequiredDto printStudent(Integer currentPage, Integer pageSize) {

//		
//		if (currentPage * pageSize >= studentRepository.count()) {
//			throw new PageException("Wrong Page number");
//		}
//		
//		Integer totalPages = 1000/pageSize;
//		totalPages = 1000%pageSize!=0?totalPages++:totalPages;
//		RequiredDto answer = new RequiredDto();
//		answer.setPageNumber(currentPage);
//		answer.setPageSize(pageSize);
//		answer.setTotalPages(totalPages);
//		
//		List<Student> newStudents = new ArrayList<>();
//		//Pageable pageable = PageRequest.of(currentPage, pageSize);
//		Page<Student> studentPage = studentRepository.findAll(PageRequest.of(currentPage, pageSize));
//		for(Student student :studentPage) {
//			newStudents.add(student);
//		}
//		answer.setStudents(newStudents);
//		//return studentRepository.findAll(PageRequest.of(currentPage, pageSize));
//		//return studentPage;
//		
//		return answer;
//		
		return studentRepository.findAll(PageRequest.of(currentPage, pageSize));

	}

}
