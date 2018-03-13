package caf.war.wm_opencaf_showcase.controls.caf_h.progress;

import java.io.Serializable;

import com.webmethods.event.impl.OpenAjaxEvent;

/**
 * Server-Side progress monitor handler that fires OpenAjax
 * events to notify the browser client of progress.
 */
public class OpenAjaxProgressMonitor implements IProgressMonitor {
	String progressTopic = null;
	int totalWork = 0;
	int unitsWorked = 0;

	public OpenAjaxProgressMonitor(String progressTopic) {
		super();
		this.progressTopic = progressTopic;
	}
	
	public void beginTask(String msg, int totalWork) {
		this.totalWork = totalWork;
		this.unitsWorked = 0;
		
		OpenAjaxEvent ev = new OpenAjaxEvent(progressTopic, 
				new EventBody(msg == null ? "" : msg, "0"));
		ev.raise();
	}

	public void done(String msg) {
		OpenAjaxEvent ev = new OpenAjaxEvent(progressTopic, 
				new EventBody(msg == null ? "" : msg, "100", true));
		ev.raise();
	}

	public void cancel(String msg) {
		long percentComplete = 0;
		if (totalWork != 0) {
			percentComplete = Math.round(((((double)unitsWorked) / (double)totalWork) * 100.0));
		}
		OpenAjaxEvent ev = new OpenAjaxEvent(progressTopic, 
				new EventBody(msg == null ? "" : msg, String.valueOf(percentComplete), true));
		ev.raise();
	}

	
	public void error(String msg) {
		long percentComplete = 0;
		if (totalWork != 0) {
			percentComplete = Math.round(((((double)unitsWorked) / (double)totalWork) * 100.0));
		}
		OpenAjaxEvent ev = new OpenAjaxEvent(progressTopic, 
				new EventBody(msg == null ? "" : msg, String.valueOf(percentComplete)));
		ev.raise();
	}

	public void setTaskMsg(String msg) {
		long percentComplete = 0;
		if (totalWork != 0) {
			percentComplete = Math.round(((((double)unitsWorked) / (double)totalWork) * 100.0));
		}
		OpenAjaxEvent ev = new OpenAjaxEvent(progressTopic, 
				new EventBody(msg == null ? "" : msg, String.valueOf(percentComplete)));
		ev.raise();
	}

	public void worked(int work) {
		unitsWorked += work;
	}
	
	
	@SuppressWarnings("serial")
	public static class EventBody implements Serializable {
		String msg;
		String completionPercentage;
		boolean done = false;
		
		public EventBody(String msg, String completionPercentage, boolean done) {
			super();
			this.msg = msg;
			this.completionPercentage = completionPercentage;
			this.done = done;
		}
		public EventBody(String msg, String completionPercentage) {
			super();
			this.msg = msg;
			this.completionPercentage = completionPercentage;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getCompletionPercentage() {
			return completionPercentage;
		}
		public void setCompletionPercentage(String completionPercentage) {
			this.completionPercentage = completionPercentage;
		}
		public boolean isDone() {
			return done;
		}
		public void setDone(boolean done) {
			this.done = done;
		}
	}
	
}
