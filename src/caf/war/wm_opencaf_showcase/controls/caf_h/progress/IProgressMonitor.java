package caf.war.wm_opencaf_showcase.controls.caf_h.progress;

/**
 * Interface for monitoring progress of a job.
 */
public interface IProgressMonitor {

	/**
	 * Notifies that a task is beginning.  
	 * 
	 * @param name the name (or description) of the main task
	 * @param totalWork the total number of work units into which
	 *  the main task is been subdivided. 
	 */
	public void beginTask(String msg, int totalWork);

	/**
	 * Notifies that the work is done; that is, either the main task is completed 
	 * or the user canceled it. 
	 * @param msg the (optional) task completed message
	 */
	public void done(String msg);

	/**
	 * Cancel the progress monitor
	 * @param msg the (optional) message of the why the task was canceled
	 */
	public void cancel(String msg);

	/**
	 * Notify the client of an error
	 * @param msg the error message
	 */
	public void error(String msg);
	
	/**
	 * Sets the task name to the given value. This method is used to 
	 * restore the task label after a nested operation was executed. 
	 * Normally there is no need for clients to call this method.
	 *
	 * @param msg the message of the main task
	 * @see #beginTask(java.lang.String, int)
	 */
	public void setTaskMsg(String msg);

	/**
	 * Notifies that a given number of work unit of the main task
	 * has been completed. Note that this amount represents an
	 * installment, as opposed to a cumulative amount of work done
	 * to date.
	 *
	 * @param work a non-negative number of work units just completed
	 */
	public void worked(int work);
}