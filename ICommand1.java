package practice;

interface ICommand1 {
    void execute();
    void undo();
}
class Lampa1{
    public void turnOn() {
        System.out.println("lampa on");
    }

    public void turnOff() {
        System.out.println("lampa off");
    }
}
class Tv1{
    public void turnOn() {
        System.out.println("tv on");
    }

    public void turnOff() {
        System.out.println("tv off");
    }
}

class LampaOnCommand implements ICommand1 {
    private Lampa1 lampa1;

    public LampaOnCommand(Lampa1 lampa1) {
        this.lampa1 = lampa1;
    }

    public void execute() {
        lampa1.turnOn();
    }

    public void undo() {
        lampa1.turnOff();
    }
}

class LampaOffComand implements ICommand1 {
    private Lampa1 light;

    public LampaOffComand(Lampa1 light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
class TVOnCommand implements ICommand1 {
    private Tv1 tv;

    public TVOnCommand(Tv1 tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void undo() {
        tv.turnOff();
    }
}

class TVOffCommand implements ICommand1 {
    private Tv1 tv;

    public TVOffCommand(Tv1 tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }

    @Override
    public void undo() {
        tv.turnOn();
    }
}
class RemoteControl1{
    private ICommand1 _oncommand;
    private ICommand1 _offcommand;
    void SetCommands(ICommand1 oncommand, ICommand1 offcommand){
        _oncommand = oncommand;
        _offcommand = offcommand;
    }
    void PressOnButton(){
        _oncommand.execute();
    }
    void PressOffButton(){
        _offcommand.execute();
    }
    void PressUndoButton(){
        _oncommand.undo();
    }
}

class MacroCommand implements ICommand1 {
    private ICommand1[] commands;

    public MacroCommand(ICommand1[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (ICommand1 command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (ICommand1 command : commands) {
            command.undo();
        }
    }
}
class Main12 {
    public static void main(String[] args) {
        Lampa1 lampa = new Lampa1();
        Tv1 tv = new Tv1();
        ICommand1 lon1 = new LampaOnCommand(lampa);
        ICommand1 loff1 = new LampaOffComand(lampa);

        ICommand1 ton = new TVOnCommand(tv);
        ICommand1 toff = new TVOffCommand(tv);

        RemoteControl1 remoteControl = new RemoteControl1();

        remoteControl.SetCommands(lon1, loff1);
        System.out.println("lampa remote");
        remoteControl.PressOnButton();
        remoteControl.PressOffButton();
        remoteControl.PressUndoButton();

        remoteControl.SetCommands(ton, toff);
        System.out.println("tv remote");
        remoteControl.PressOnButton();
        remoteControl.PressOffButton();
        remoteControl.PressUndoButton();
    }
}