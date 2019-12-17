package by.bsuir.committee.controller;

import java.util.HashMap;
import java.util.Map;

import by.bsuir.committee.controller.command.Command;
import by.bsuir.committee.controller.command.CommandName;
import by.bsuir.committee.controller.command.impl.*;;


final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider() {
		repository.put(CommandName.ADD, new Add());
		repository.put(CommandName.EDIT, new Edit());
		repository.put(CommandName.EXIT, new Exit());
		repository.put(CommandName.LOAD, new Load());
		repository.put(CommandName.REMOVE, new Remove());
		repository.put(CommandName.SAVE, new Save());
		repository.put(CommandName.SHOW, new Show());
		repository.put(CommandName.SORT, new Sort());
		repository.put(CommandName.HELP, new Help());
		repository.put(CommandName.CONNECT, new Connect());
		repository.put(CommandName.CREATETABLE, new CreateTable());
		repository.put(CommandName.INSERT, new InsertToDB());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	Command getCommand(String name){
		
		CommandName commandName =null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e){
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
	
}
