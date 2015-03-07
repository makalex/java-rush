package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;


public class CommandExecutor {

    private static Map<Operation, Command> commandMap;
    static {
        commandMap = new HashMap<>();
        commandMap.put(Operation.LOGIN, new LoginCommand());
        commandMap.put(Operation.INFO, new InfoCommand());
        commandMap.put(Operation.DEPOSIT, new DepositCommand());
        commandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        commandMap.put(Operation.EXIT, new ExitCommand());
    }

    public CommandExecutor() {}

    public static final void execute(Operation operation) throws InterruptOperationException{
        commandMap.get(operation).execute();
    }
}
