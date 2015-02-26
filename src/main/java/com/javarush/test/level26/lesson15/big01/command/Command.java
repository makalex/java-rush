package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by MakarytskyiO on 23.02.2015.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
