package org.example.command;

import java.util.ArrayList;
import java.util.List;

public class FlowBuilder {
    private final List<Command> flows = new ArrayList<>();

    public void addFlow(Command flow){
        flows.add(flow);
    }

    public void processFlows(){
        flows.forEach(command -> command.execute());
    }
}
