package com.worksplit.utils;

import com.worksplit.Constants;
import com.worksplit.exceptions.IllegalParametersException;
import com.worksplit.exceptions.MandatoryFieldMissingException;
import com.worksplit.tables.GroupConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RequestValidator {

    public static final Logger log = LoggerFactory.getLogger(RequestValidator.class);


    public static void performGroupConfigMandatoryFieldValidation(List<GroupConfig> groups) throws MandatoryFieldMissingException{
        if(groups != null && !groups.isEmpty()){
            List<String> mandatoryFields= Constants.MANDATORY_FIELD_LIST_GROUPS;
            if(!groups.containsAll(mandatoryFields)){
                throw new MandatoryFieldMissingException("Some Mandatory Fields are missing");
            }

        }

    }
    public static boolean performGroupConfigValuesValidation(List<GroupConfig> groups) throws  MandatoryFieldMissingException {
        if (groups != null && !groups.isEmpty()) {
            for (GroupConfig group : groups) {
                if(group.getGroupName() == null || group.getGroupName().trim().isEmpty()){
                    throw new MandatoryFieldMissingException("Group name is empty");
                }

                if(group.getGroupDescription() == null || group.getGroupDescription().trim().isEmpty()){
                    throw new MandatoryFieldMissingException("Group Description is empty");
                }

                if(group.getGroupType() == null || group.getGroupType().trim().isEmpty()){
                    throw new MandatoryFieldMissingException("Group Type is empty");
                }
                else{
                    if(!Constants.GROUP_TYPES.contains(group.getGroupType())){
                        throw new IllegalParametersException("Group Type is not correct");
                    }
                }

                if(group.getCreatedBy() == null) {
                    throw new MandatoryFieldMissingException("Created by is empty");
                }


                if(group.getLastUpdatedBy() == null){
                    throw new MandatoryFieldMissingException("Last updated by is empty");
                }


            }
        }
        return true;
    }

}


