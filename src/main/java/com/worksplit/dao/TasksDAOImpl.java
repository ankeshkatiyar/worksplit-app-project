package com.worksplit.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worksplit.dao.interfaces.DatabasePlugger;
import com.worksplit.dao.interfaces.TasksDAO;
import com.worksplit.tables.Tasks;

@Repository
public class TasksDAOImpl implements TasksDAO{
	public static final String TABLE_NAME = "Tasks";
	
	@Autowired
	DatabasePlugger plugger;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Tasks> createTask(List<Tasks> tasks) {
			return (List<Tasks>) plugger.saveOrUpdateMultipleValues(tasks);
			
	}

	@Override
	public List<Tasks> getTasks(String column, String value) {	
		
		return plugger.getValues(TABLE_NAME, column, value)  ;
		
	}

	@Override
	public List<Tasks> getAllTasks() {
		return plugger.getAllValues(TABLE_NAME);
	}

}
