package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import model.ModuleListView;

/**
 * This pane is responsible for the initial module selections for the student
 * profile.
 * 
 * Upon profile creation, the user is directed to this pane, with the relevant
 * ListView's populated with the modules of the chosen course (CompSci/SoftEng).
 * 
 * @author Dylan Brand, P2523268
 */
public class ModuleSelectionPane extends GridPane {

	/* Fields */
	private Button btnAddT1, btnRemoveT1, btnAddT2, btnRemoveT2, btnReset, btnSubmit;
	private TextField tfT1CreditCount, tfT2CreditCount;
	private ModuleListView lvUnselectedT1, lvUnselectedT2, lvSelectedT1, lvSelectedT2, lvYearModules;

	/* Constructors */

	/**
	 * Default Constructor.
	 * 
	 * Creates a new instance of ModuleSelectionPane. This constructor defines
	 * the layout and arrangement of nodes, controls and constraints for the GUI.
	 */
	public ModuleSelectionPane() {
		// Styling - External CSS file
		this.getStyleClass().add("module-selection-pane");

		// Sets the column constraints for this class
		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHgrow(Priority.ALWAYS);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS);

		// Sets the row restraints for this class
		RowConstraints row = new RowConstraints();
		row.setVgrow(Priority.ALWAYS);
		
		RowConstraints rowBlank = new RowConstraints();

		this.getColumnConstraints().addAll(column0, column1);
		this.getRowConstraints().addAll(rowBlank, row, rowBlank, rowBlank, row, rowBlank, rowBlank, row);

		// Creates this class' Labels
		Label lblUnselectedT1Modules = new Label("Unselected term 1 modules");
		Label lblUnselectedT2Modules = new Label("Unselected term 2 modules");
		Label lblSelectedT1Modules = new Label("Selected term 1 modules");
		Label lblSelectedT2Modules = new Label("Selected term 2 modules");
		Label lblYearModules = new Label("Year long modules");
		Label lblT1 = new Label("Term 1");
		Label lblT2 = new Label("Term 2");
		Label lblT1Credits = new Label("Term 1 credits:");
		Label lblT2Credits = new Label("Term 2 credits:");

		// Initialise list view's
		lvUnselectedT1 = new ModuleListView();
		lvUnselectedT2 = new ModuleListView();
		lvSelectedT1 = new ModuleListView();
		lvSelectedT2 = new ModuleListView();
		lvYearModules = new ModuleListView();

		// Initialising the button controls, setting their ID and preferred size
		btnAddT1 = new Button("Add");
		btnAddT1.setPrefSize(70, 20);

		btnRemoveT1 = new Button("Remove");
		btnRemoveT1.setPrefSize(70, 20);

		btnAddT2 = new Button("Add");
		btnAddT2.setPrefSize(70, 20);

		btnRemoveT2 = new Button("Remove");
		btnRemoveT2.setPrefSize(70, 20);

		btnReset = new Button("Reset");
		btnReset.setPrefSize(70, 20);

		btnSubmit = new Button("Submit");
		btnSubmit.setPrefSize(70, 20);

		// Initialising Term 1 Credit Count
		tfT1CreditCount = new TextField("0"); // Default value
		tfT1CreditCount.setPrefSize(35, 25);
		tfT1CreditCount.setEditable(false);

		// Initialising Term 2 Credit Count
		tfT2CreditCount = new TextField("0"); // Default value
		tfT2CreditCount.setPrefSize(35, 25);
		tfT2CreditCount.setEditable(false);

		// Creates a HBox that displays the button controls for term 1 selection
		HBox hboxT1 = new HBox(10, lblT1, btnAddT1, btnRemoveT1);
		hboxT1.setAlignment(Pos.CENTER);
		hboxT1.setPadding(new Insets(20, 0, 20, 0));

		// Creates a HBox that displays the button controls for term 2 selection
		HBox hboxT2 = new HBox(10, lblT2, btnAddT2, btnRemoveT2);
		hboxT2.setAlignment(Pos.CENTER);
		hboxT2.setPadding(new Insets(20, 0, 20, 0)); // 20, 0, 20, 0

		// Creates two HBox's that display the module credit count for term 1 and 2
		HBox hboxT1Credits = new HBox(15, lblT1Credits, tfT1CreditCount);
		HBox hboxT2Credits = new HBox(15, lblT2Credits, tfT2CreditCount);

		// Creates a HBox that displays the pane's button controls, Submit and Reset
		HBox finalBtnHBox = new HBox(15, btnReset, btnSubmit);

		// VBox container that displays the the credit count for term 1 and 2 vertically
		VBox creditsContainer = new VBox(10, hboxT1Credits, hboxT2Credits, finalBtnHBox);
		VBox.setVgrow(creditsContainer, Priority.ALWAYS);

		// Creates a GridPane
		GridPane grid = new GridPane();
		grid.add(creditsContainer, 0, 0);
		grid.setAlignment(Pos.CENTER);
		
		// Add controls and labels to the container
		this.add(lblUnselectedT1Modules, 0, 0);
		this.add(lvUnselectedT1, 0, 1);

		this.add(hboxT1, 0, 2);

		this.add(lblUnselectedT2Modules, 0, 3);
		this.add(lvUnselectedT2, 0, 4);

		this.add(hboxT2, 0, 5);

		this.add(lblSelectedT1Modules, 1, 0);
		this.add(lvSelectedT1, 1, 1);

		this.add(lblSelectedT2Modules, 1, 3);
		this.add(lvSelectedT2, 1, 4);

		this.add(lblYearModules, 1, 6);
		this.add(lvYearModules, 1, 7);

		this.add(grid, 0, 7);
	}

	/* Methods */

	/**
	 * Returns the term 1 unselected ListView object.
	 * 
	 * @return Term 1 unselected ListView.
	 */
	public ModuleListView getLvUnselectedT1() {
		return lvUnselectedT1;
	}

	/**
	 * Returns the term 1 selected ListView object.
	 * 
	 * @return Term 1 selected ListView.
	 */
	public ModuleListView getLvSelectedT1() {
		return lvSelectedT1;
	}
	
	/**
	 * Returns the term 2 unselected ListView object.
	 * 
	 * @return Term 2 unselected ListView.
	 */
	public ModuleListView getLvUnselectedT2() {
		return lvUnselectedT2;
	}

	/**
	 * Returns the term 2 selected ListView object.
	 * 
	 * @return Term 2 selected ListView.
	 */
	public ModuleListView getLvSelectedT2() {
		return lvSelectedT2;
	}

	/**
	 * Returns the year long ListView object.
	 * 
	 * @return Year long ListView.
	 */
	public ModuleListView getLvYearModules() {
		return lvYearModules;
	}

	/**
	 * Updates the existing value of the selected term 1 credit count.
	 * 
	 * @param value The integer value to be incremented to the credit count.
	 */
	public void updateT1CreditCount(int value) {
		tfT1CreditCount.setText("" + (Integer.parseInt(tfT1CreditCount.getText()) + value));
	}

	/**
	 * Updates the existing value of the selected term 2 credit count.
	 * 
	 * @param value The integer value to be incremented to the credit count.
	 */
	public void updateT2CreditCount(int value) {
		tfT2CreditCount.setText("" + (Integer.parseInt(tfT2CreditCount.getText()) + value));
	}

	/**
	 * Sets the value of the term 1 credit count.
	 * 
	 * @param value The integer value to set the term 1 credit count value.
	 */
	public void setT1CreditCount(int value) {
		tfT1CreditCount.setText("" + value);
	}

	/**
	 * Sets the value of the term 2 credit count.
	 * 
	 * @param value The integer value to set the term 2 credit count value.
	 */
	public void setT2CreditCount(int value) {
		tfT2CreditCount.setText("" + value);
	}

	/**
	 * Returns the value of the term 1 credit count.
	 * 
	 * @return The term 1 credit count value.
	 */
	public int getT1CreditCount() {
		return Integer.parseInt(tfT1CreditCount.getText());
	}

	/**
	 * Returns the value of the term 2 credit count.
	 * 
	 * @return The term 2 credit count value.
	 */
	public int getT2CreditCount() {
		return Integer.parseInt(tfT2CreditCount.getText());
	}

	// These methods allow handlers to be externally attached to this view
	public void addAddHandlerT1(EventHandler<ActionEvent> handler) {
		btnAddT1.setOnAction(handler);
	}

	public void addRemoveHandlerT1(EventHandler<ActionEvent> handler) {
		btnRemoveT1.setOnAction(handler);
	}

	public void addAddHandlerT2(EventHandler<ActionEvent> handler) {
		btnAddT2.setOnAction(handler);
	}

	public void addRemoveHandlerT2(EventHandler<ActionEvent> handler) {
		btnRemoveT2.setOnAction(handler);
	}

	public void addResetHandler(EventHandler<ActionEvent> handler) {
		btnReset.setOnAction(handler);
	}

	public void addSubmitHandler(EventHandler<ActionEvent> handler) {
		btnSubmit.setOnAction(handler);

	}
}
