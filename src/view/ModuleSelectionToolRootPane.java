package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ModuleSelectionToolRootPane extends BorderPane {

	private CreateStudentProfilePane cspp;
	private ModuleSelectionPane msp;
	private ModuleReservationPane mrp;
	private OverviewPane op;
	private ModuleSelectionToolMenuBar mstmb;
	private TabPane tp;

	public ModuleSelectionToolRootPane() {
		// create tab pane and disable tabs from being closed
		tp = new TabPane();
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		// create panes
		cspp = new CreateStudentProfilePane();
		msp = new ModuleSelectionPane();
		mrp = new ModuleReservationPane();
		op = new OverviewPane();

		// create tabs with panes added
		Tab t1 = new Tab("Create Profile", cspp);
		Tab t2 = new Tab("Module Selection", msp);
		Tab t3 = new Tab("Module Reservation", mrp);
		Tab t4 = new Tab("Overview", op);

		// add tabs to tab pane
		tp.getTabs().addAll(t1, t2, t3, t4);
		
		// create menu bar
		mstmb = new ModuleSelectionToolMenuBar();

		// add menu bar and tab pane to this root pane
		this.setTop(mstmb);
		this.setCenter(tp);
	}

	// methods allowing sub-containers to be accessed by the controller.
	public CreateStudentProfilePane getCreateStudentProfilePane() {
		return cspp;
	}

	public ModuleSelectionToolMenuBar getModuleSelectionToolMenuBar() {
		return mstmb;
	}

	public ModuleSelectionPane getModuleSelectionPane() {
		return msp;
	}

	public ModuleReservationPane getModuleReservationPane() {
		return mrp;
	}

	public OverviewPane getOverviewPane() {
		return op;
	}

	// method to allow the controller to change tabs
	public void changeTab(int index) {
		tp.getSelectionModel().select(index);
	}
}
