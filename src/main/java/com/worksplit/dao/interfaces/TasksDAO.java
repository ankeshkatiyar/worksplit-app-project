package com.worksplit.dao.interfaces;

import com.worksplit.tables.Tasks;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TasksDAO {
	
	public List<Tasks> createTask(List<Tasks> task);
	public List<Tasks> getTasks(String column , String value);
	public List<Tasks> getAllTasks();
	

}
