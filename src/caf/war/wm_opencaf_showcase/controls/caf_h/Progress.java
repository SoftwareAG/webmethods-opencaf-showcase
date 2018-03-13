package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import caf.war.wm_opencaf_showcase.controls.caf_h.progress.IProgressMonitor;
import caf.war.wm_opencaf_showcase.controls.caf_h.progress.OpenAjaxProgressMonitor;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="progressBean")
@SessionScoped
@ExpireWithPageFlow
public class Progress extends BaseFacesBean {
	
	/**
	 * Action handler to simulate a long running process that
	 * should provided progress updates to the client browser.
	 */
	public String startProgress() {
		//spin up a worker thread to do this job in the background.
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				//do a fake job with some delays between steps
				IProgressMonitor monitor = new OpenAjaxProgressMonitor("sample.progress2");
				monitor.beginTask("Doing Some Work", 5);
				
				for (int i=1; i < 5; i++) {
					Thread.sleep(2000);
					monitor.worked(1);
					monitor.setTaskMsg(String.format("Processing Step #%d", (i + 1)));
				}
				
				Thread.sleep(2000);
				monitor.done("Completed It.");

				return null;
			}
			
			
		});
		// dispose the executor after the submitted job
		// has completed.
		executor.shutdown();

		return null;
	}

}
