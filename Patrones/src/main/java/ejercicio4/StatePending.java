package ejercicio4;

import java.time.Duration;
import java.time.LocalDate;

public class StatePending implements State{

	@Override
	public void start(ToDoItem context) {
		context.setStartDate(LocalDate.now());
		context.setState(new StateInProgress());
	}

	@Override
	public void tooglePause(ToDoItem context) {
		throw new RuntimeException("Si esta pendiente no se puede pausar.");
	}

	@Override
	public void finish(ToDoItem context) {
	}

	@Override
	public Duration workedTime(ToDoItem context) {
		throw new RuntimeException("Nunca se inicio.");
	}

	@Override
	public void addCommet(ToDoItem context, String comment) {
			context.addCommentToList(comment);
	}

}
