package ejercicio4;

import java.time.Duration;

public interface State {
	public void start(ToDoItem context);
	public void tooglePause(ToDoItem context);
	public void finish(ToDoItem context);
	public Duration workedTime(ToDoItem context);
	public void addCommet(ToDoItem context, String comment);
}
