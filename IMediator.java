package practice;

import java.util.ArrayList;

interface IMediator {
    void SendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected IMediator _mediator;

    public Colleague(IMediator mediator) {
        _mediator = mediator;
    }

    public abstract void ReceiveMessage(String message);
}

class ChatMediator implements IMediator {
    private ArrayList<Colleague> _colleagues;

    public ChatMediator() {
        _colleagues = new ArrayList<>();
    }

    public void RegisterColleague(Colleague colleague) {
        _colleagues.add(colleague);
    }

    public void SendMessage(String message, Colleague sender) {
        for (Colleague colleague : _colleagues) {
            if (colleague != sender) {
                colleague.ReceiveMessage(message);
            }
        }
    }
}
class User extends Colleague {
    private String _name;

    public User(IMediator mediator, String name) {
        super(mediator); // Call the superclass constructor
        _name = name;
    }

    public void Send(String message) {
        System.out.println(_name + " отправляет сообщение: " + message); // Corrected string interpolation
        _mediator.SendMessage(message, this);
    }

    public void ReceiveMessage(String message) {
        System.out.println(_name + " получил сообщение: " + message); // Corrected string interpolation
    }
}

class Main2 {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();
        User user1 = new User(chatMediator, "Assiya");
        User user2 = new User(chatMediator, "Aisha");

        chatMediator.RegisterColleague(user1);
        chatMediator.RegisterColleague(user2);

        user1.Send("Привет всем!");
        user2.Send("Привет, Assiya!");
    }
}
