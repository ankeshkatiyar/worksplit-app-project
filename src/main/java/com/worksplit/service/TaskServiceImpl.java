package com.worksplit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.worksplit.dao.interfaces.TasksDAO;
import com.worksplit.exceptions.NoTasksException;
import com.worksplit.service.interfaces.TaskService;
import com.worksplit.tables.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class TaskServiceImpl implements TaskService {
	static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	private TasksDAO taskDAO;
	
	@Override
	public List<Tasks> createTask(List<Tasks> task) {
		List<Tasks> listTasks;
		StringBuilder stringBuilder = new StringBuilder();
		if(task!=null && !task.isEmpty()) {			
			listTasks =  taskDAO.createTask(task);
			for(Tasks indTask : task) {
				stringBuilder.append(indTask.getTaskName() + " ,");
			}
			log.info("Tasks created with Id's "+ stringBuilder);
			return listTasks;

			
		}
		throw new NoTasksException();
	}

	@Override
	public List<Tasks> getTask(String column, String value) {
		
		List<Tasks> listTasks = taskDAO.getTasks(column, value);
	
		if( listTasks!= null && !listTasks.isEmpty()) {
			return listTasks;
		}else {
			throw new NoTasksException();
		}
	}

	@Override
	public List<Tasks> getAllTasks() {	
		return taskDAO.getAllTasks();
	}

}
