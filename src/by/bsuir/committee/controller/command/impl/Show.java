package by.bsuir.committee.controller.command.impl;

import by.bsuir.committee.controller.command.Command;
import by.bsuir.committee.entity.Committee;
import by.bsuir.committee.service.ServiceFactory;
import by.bsuir.committee.service.userService;
import static by.bsuir.committee.Constants.*;


public class Show implements Command{

	@Override
	public String execute(String request, Committee committee) {
		String faculty = null;
		String response = "";
		
		String[] data = new String[3];
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		userService userService = (userService) serviceFactory.getUserService();
		
		data = request.split(" ");

		if(data.length == 2) {
			faculty = data[1];
			if (!userService.show(faculty, committee))
				response = NO_FACULTY;
		}
		else {
			response  = INCORRECT_PARAMS;
		}

		return response;
	
	}

}
