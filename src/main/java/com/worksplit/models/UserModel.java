package com.worksplit.models;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.worksplit.tables.User;
import com.worksplit.utils.StatusCodes;


@Component
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserModel extends User  {
	
	private static final long serialVersionUID = 1L;

	private StatusCodes statuscodes;
	
	private boolean hasErrors ;


	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public StatusCodes getStatuscodes() {
		return statuscodes;
	}

	public void setStatuscodes(StatusCodes statuscodes) {
		this.statuscodes = statuscodes;
	}

}
