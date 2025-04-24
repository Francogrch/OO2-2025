package ejercicio4;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Duration;

public class ToDoItem{
	private String name;
	private List<String> comments;
	private State state;
	private LocalDate startDate, finishDate;
	
	public ToDoItem(String name) {
		this.name= name;
		state = new StatePending();
		comments = new ArrayList<String>();
	}
	
	public void start() {
		state.start(this);
	}
	public void tooglePause() {
		state.tooglePause(this);
	}
	public void finish() {
		state.finish(this);
	}
	public Duration workedTime() {
		return state.workedTime(this);
	}
	public void addComment(String comment) {
		state.addCommet(this, comment);
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public boolean addCommentToList(String comment) {
		return comments.add(comment);
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}
	
	
}