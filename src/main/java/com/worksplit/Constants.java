package com.worksplit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Constants {

    public final static String PATH_GROUPS = "/v1/groups";
    public final static String PATH_USERS = "/v1/users";
    public final static List<String> MANDATORY_FIELD_LIST_GROUPS = new ArrayList<String>(
            Arrays.asList(

                    "groupName", "groupDescription","groupType" , "createdOn","createdBy","lastUpdatedBy","lastUpdatedOn"
            )

    );

    public final static  List<String> GROUP_TYPES = new ArrayList<>(
            Arrays.asList(

                    "APARTMENT" , "HOUSE" , "TRIP" , "OFFICE" , "EVENT","OTHER"
            )

    );


}
