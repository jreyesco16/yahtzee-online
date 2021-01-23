package command;

import java.io.IOException;

import menu.Menu;

// Command pattern
public interface Command {
    Menu execute() throws IOException;
}
