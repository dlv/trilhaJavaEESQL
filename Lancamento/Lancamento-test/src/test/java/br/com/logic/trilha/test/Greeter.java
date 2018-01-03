package br.com.logic.trilha.test;

import java.io.PrintStream;

/**
 *
 * @see http://arquillian.org/guides/getting_started/
 * 
 * @author douglas
 */
public class Greeter {
    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
