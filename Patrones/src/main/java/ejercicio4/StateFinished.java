package ejercicio4;

import java.time.Duration;

public class StateFinished implements State{

	@Override
	public void start(ToDoItem context) {
	}

	@Override
	public void tooglePause(ToDoItem context) {
		throw new RuntimeException("Si esta finalizada no se puede pausar.");
	}

	@Override
	public void finish(ToDoItem context) {
	}

	@Override
	public Duration workedTime(ToDoItem context) {
		return Duration.between(context.getStartDate(), context.getFinishDate());
	}

	@Override
	public void addCommet(ToDoItem context, String comment) {
		
	}

}
