package com.worksplit.service.interfaces;

import com.worksplit.tables.Tasks;
import java.util.List;
public interface TaskService {
	
	public  List<Tasks> createTask(List<Tasks> task);
	public List<Tasks> getTask(String column , String value);
	public List<Tasks> getAllTasks();

}
