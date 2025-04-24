package ejercicio4;

import java.time.Duration;
import java.time.LocalDate;
	
public class StateInProgress implements State {

	@Override
	public void start(ToDoItem context) {
	}

	@Override
	public void tooglePause(ToDoItem context) {
		context.setState(new StatePaused());
	}

	@Override
	public void finish(ToDoItem context) {
		context.setFinishDate(LocalDate.now());
		context.setState(new StateFinished());
	}

	@Override
	public Duration workedTime(ToDoItem context) {
		return Duration.between(context.getStartDate(), LocalDate.now());
	}

	@Override
	public void addCommet(ToDoItem context, String comment) {
		context.addCommentToList(comment);
	}

}
