package view;

import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * 
 * @author Dylan
 */
public class OverviewPane extends GridPane {

	/* Fields */
	private TextArea txtStudentDetails, txtSelectedModules, txtReservedModules;
	private Button btnSave;

	/* Constructors */
	/**
	 * 
	 */
	public OverviewPane() {
		// Styling
		this.getStyleClass().add("overview-pane");

		// Sets the column constraints
		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHgrow(Priority.ALWAYS);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS);

		// Sets the row constraints for this class
		RowConstraints row = new RowConstraints();
		row.setVgrow(Priority.ALWAYS);

		this.getColumnConstraints().addAll(column0, column1);
		this.getRowConstraints().addAll(row, row, row);

		// Initialise TextArea's and save button
		txtStudentDetails = new TextArea();
		txtStudentDetails.setPrefSize(300, 100);
		txtStudentDetails.setPromptText("Student Details will appear here...");
		txtStudentDetails.setEditable(false); // studentDetails.setWrapText(true);

		txtSelectedModules = new TextArea();
		txtSelectedModules.setPrefSize(300, 200);
		txtSelectedModules.setPromptText("Selected Modules will appear here...");
		txtSelectedModules.setEditable(false);

		txtReservedModules = new TextArea();
		txtReservedModules.setPrefSize(300, 200);
		txtReservedModules.setPromptText("Reserved Modules will appear here...");
		txtReservedModules.setEditable(false);

		btnSave = new Button("Save Overview");

		HBox hbox = new HBox(btnSave);
		hbox.setAlignment(Pos.CENTER);

		// Adding controls to the container
		this.add(txtStudentDetails, 0, 0, 2, 1); // Expand text area over two columns
		this.add(txtSelectedModules, 0, 1);
		this.add(txtReservedModules, 1, 1);
		this.add(hbox, 0, 2, 2, 1); // Expand HBox area over two columns
	}

	/* Methods */
	/**
	 * Returns the student detail TextArea object.
	 * 
	 * @return Student details TextArea.
	 */
	public TextArea getStudentDetails() {
		return txtStudentDetails;
	}

	/**
	 * Returns the selected modules TextArea object.
	 * 
	 * @return Selected modules TextArea.
	 */
	public TextArea getSelectedModules() {
		return txtSelectedModules;
	}

	/**
	 * Returns the reserved modules TextArea object.
	 * 
	 * @return Reserved modules TextArea.
	 */
	public TextArea getReservedModules() {
		return txtReservedModules;
	}

	/**
	 * Returns the student detail's TextArea value.
	 * 
	 * @return Student details TextArea value.
	 */
	public String getStudentDetailsText() {
		return txtStudentDetails.getText();
	}

	/**
	 * Returns the selected modules TextArea value.
	 * 
	 * @return Selected modules TextArea value.
	 */
	public String getSelectedModulesText() {
		return txtSelectedModules.getText();
	}

	/**
	 * Returns the reserved modules TextArea value.
	 * 
	 * @return Reserved modules TextArea value.
	 */
	public String getReservedModulesText() {
		return txtReservedModules.getText();
	}

	/**
	 * Returns a BooleanBinding value, dependent if any or all TextArea's are empty
	 * at any given time.
	 * 
	 * @return A BooleanBinding value.
	 */
	public BooleanBinding isFormEmpty() {
		return txtStudentDetails.textProperty().isEmpty()
				.or(txtSelectedModules.textProperty().isEmpty().or(txtReservedModules.textProperty().isEmpty()));
	}

	// These methods allow handlers to be externally attached to this view
	public void addSaveHandler(EventHandler<ActionEvent> handler) {
		btnSave.setOnAction(handler);
	}

	public void addBtnCreateBind(BooleanBinding property) {
		btnSave.disableProperty().bind(property);
	}
}
