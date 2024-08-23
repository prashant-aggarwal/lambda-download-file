package com.pc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pc.lambda.model.FileDetails;
import com.pc.lambda.model.LambdaDemoIO;

public class Handler implements RequestHandler<LambdaDemoIO, LambdaDemoIO> {

	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public LambdaDemoIO handleRequest(LambdaDemoIO event, Context context) {
		
		LambdaLogger logger = context.getLogger();
		logger.log("event => " + gson.toJson(event) + "\n");
		logger.log("context => " + gson.toJson(context) + "\n");
		
		LambdaDemoIO response = new LambdaDemoIO();
		response.setFirstName(event.getFirstName());
		response.setLastName(event.getLastName());
		response.setFuncStates(event.getFuncStates());
		response.getFuncStates().setFileDownloaded(true);
		
		FileDetails[] fileDetails = new FileDetails[100];
		for (int i = 0; i < fileDetails.length; i++) {
			fileDetails[i] = new FileDetails();
			fileDetails[i].setRecordId(i+1);
			fileDetails[i].setCol1("Data for col1: " + i);
			fileDetails[i].setCol2("Data for col2: " + i);
			fileDetails[i].setCol3("Data for col3: " + i);
			fileDetails[i].setCol4("Data for col4: " + i);
			fileDetails[i].setCol5("Data for col5: " + i);
			fileDetails[i].setCol6("Data for col6: " + i);
			fileDetails[i].setCol7("Data for col7: " + i);
			fileDetails[i].setCol8("Data for col8: " + i);
			fileDetails[i].setCol9("Data for col9: " + i);
			fileDetails[i].setCol10("Data for col0: " + i);
			fileDetails[i].setCol11("Data for col11: " + i);
			fileDetails[i].setCol12("Data for col12: " + i);
			fileDetails[i].setCol13("Data for col13: " + i);
			fileDetails[i].setCol14("Data for col14: " + i);
			fileDetails[i].setCol15("Data for col15: " + i);
			fileDetails[i].setCol16("Data for col16: " + i);
			fileDetails[i].setCol17("Data for col17: " + i);
			fileDetails[i].setCol18("Data for col18: " + i);
			fileDetails[i].setCol19("Data for col19: " + i);
			fileDetails[i].setCol20("Data for col20: " + i);
		}
		logger.log("Populated fileDetails: " + fileDetails.length + "\n");
		response.setFileDetails(fileDetails);
		
		logger.log("Populated response object.\n");
		
		return response;
	}
}
