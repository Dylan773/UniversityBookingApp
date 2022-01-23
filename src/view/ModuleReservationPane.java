package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.ModuleListView;

/**
 * This pane is responsible for the selection of reserved modules for the student
 * profile.
 * 
 * Upon module selection (ModuleSelectionPane), the user is directed to this pane, with the relevant
 * ListView's populated with the unselected modules of the chosen course (CompSci/SoftEng).
 * 
 * @author Dylan Brand, P2523268
 */
public class ModuleReservationPane extends Accordion {

	/* Fields */
	private ModuleListView lvUnreservedT1, lvUnreservedT2, lvReservedT1, lvReservedT2;
	private Button btnAddT1, btnRemoveT1, btnAddT2, btnRemoveT2, btnConfirmT1, btnConfirmT2;
	private TextField tfCreditsT1, tfCreditsT2;
	private TitledPane t1, t2;

	/* Constructors */
	/**
	 * Default Constructor.
	 * 
	 * Creates a new instance of ModuleReservationPane. This constructor defines
	 * the layout and arrangement of nodes and controls for the GUI.
	 */
	public ModuleReservationPane() {
		// Styling
		this.getStyleClass().add("module-reservation-pane");
		// Creating the labels
		Label lblUnreservedT1Modules = new Label("Unreserved term 1 modules");
		Label lblUnreservedT2Modules = new Label("Unreserved term 2 modules");
		Label lblReservedT1Modules = new Label("Reserved term 1 modules");
		Label lblReservedT2Modules = new Label("Reserved term 2 modules");
		Label lblT1 = new Label("Please select 30 credits"); // Fix sizing
		Label lblT2 = new Label("Please select 30 credits"); // Fix sizing

		// Initialise ListView's, ModuleListView.java
		lvUnreservedT1 = new ModuleListView();
		lvUnreservedT1.setPrefHeight(250); // Overrides inherited height size
		
		lvUnreservedT2 = new ModuleListView();
		lvUnreservedT2.setPrefHeight(250); // Overrides inherited height size

		lvReservedT1 = new ModuleListView();
		lvReservedT1.setPrefHeight(250); // Overrides inherited height size
		
		lvReservedT2 = new ModuleListView();
		lvReservedT2.setPrefHeight(250); // Overrides inherited height size

		// Initialise Buttons
		btnAddT1 = new Button("Add");
		btnAddT1.setPrefSize(70, 20);

		btnRemoveT1 = new Button("Remove");
		btnRemoveT1.setPrefSize(70, 20);

		btnConfirmT1 = new Button("Confirm");
		btnConfirmT1.setPrefSize(70, 20);

		btnAddT2 = new Button("Add");
		btnAddT2.setPrefSize(70, 20);

		btnRemoveT2 = new Button("Remove");
		btnRemoveT2.setPrefSize(70, 20);

		btnConfirmT2 = new Button("Confirm");
		btnConfirmT2.setPrefSize(70, 20);

		// Initialise TextField's for credit count
		tfCreditsT1 = new TextField("0");
		tfCreditsT1.setPrefSize(35, 25);
		tfCreditsT1.setEditable(false);

		tfCreditsT2 = new TextField("0");
		tfCreditsT2.setPrefSize(35, 25);
		tfCreditsT2.setEditable(false);

		// Initialising the Button controls for the Term 1 selection, using a HBox.
		HBox controlsT1 = new HBox(15, btnAddT1, btnRemoveT1, btnConfirmT1);
		controlsT1.setPadding(new Insets(30));
		controlsT1.setAlignment(Pos.CENTER);
		
		// Initialising the Button controls for the Term 2 selection, using a HBox.
		HBox controlsT2 = new HBox(15, btnAddT2, btnRemoveT2, btnConfirmT2);
		controlsT2.setPadding(new Insets(30));
		controlsT2.setAlignment(Pos.CENTER);

		// Creating a HBox that displays the credit count for both term 1 and 2 modules
		HBox creditsT1 = new HBox(15, lblT1, tfCreditsT1);
		creditsT1.setPadding(new Insets(30));
		VBox.setVgrow(creditsT1, Priority.ALWAYS); // HERE
		
		HBox creditsT2 = new HBox(15, lblT2, tfCreditsT2);
		creditsT2.setPadding(new Insets(30));

		// Creates two VBox's to display Term 1's Labels, ListView's and controls
		VBox unselectedT1 = new VBox(lblUnreservedT1Modules, lvUnreservedT1, controlsT1);
		HBox.setHgrow(unselectedT1, Priority.ALWAYS); // Sets the H-growth of the T1 controls
		
		VBox selectedT1 = new VBox(lblReservedT1Modules, lvReservedT1, creditsT1);
		HBox.setHgrow(selectedT1, Priority.ALWAYS); // Sets the H-growth of the T1 controls
		//selectedT1.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		
		// Creating two VBox's to display Term 2's, Labels, ListView and controls
		VBox unselectedT2 = new VBox(lblUnreservedT2Modules, lvUnreservedT2, controlsT2); // No spacing
		HBox.setHgrow(unselectedT2, Priority.ALWAYS);
		
		VBox selectedT2 = new VBox(lblReservedT2Modules, lvReservedT2, creditsT2); // No spacing
		HBox.setHgrow(selectedT2, Priority.ALWAYS);
		
		// Creates a HBox "container" for both Term 1 and 2 Module Reservation. 
		//This container displays the unreserved and reserved VBox's alongside each other
		HBox containerT1 = new HBox(15, unselectedT1, selectedT1); // Spacing 15		
		HBox containerT2 = new HBox(15, unselectedT2, selectedT2); // Spacing 15
		
		// Creating TitledPanes to display on the Accordion
		t1 = new TitledPane("Term 1 Modules", containerT1);
		t1.setAlignment(Pos.CENTER);
		
		t2 = new TitledPane("Term 2 Modules", containerT2);
		t2.setAlignment(Pos.CENTER);

		this.getPanes().addAll(t1, t2); // Adding both TitledPane's to the Accordion
		this.setExpandedPane(t1);
	}

	/* Methods */
	/**
	 * Returns the term 1 unreserved ListView object.
	 * 
	 * @return Term 1 unreserved ListView.
	 */
	public ModuleListView getLvUnreservedT1() {
		return lvUnreservedT1;
	}

	/**
	 * Returns the term 1 reserved ListView object.
	 * 
	 * @return Term 1 reserved ListView.
	 */
	public ModuleListView getLvReservedT1() {
		return lvReservedT1;
	}

	/**
	 * Returns the term 2 unreserved ListView object.
	 * 
	 * @return Term 2 unreserved ListView.
	 */
	public ModuleListView getLvUnreservedT2() {
		return lvUnreservedT2;
	}

	/**
	 * Returns the term 2 reserved ListView object.
	 * 
	 * @return Term 2 reserved ListView.
	 */
	public ModuleListView getLvReservedT2() {
		return lvReservedT2;
	}

	/**
	 * Updates the existing value of the reserved term 1 credit count.
	 * 
	 * @param value The integer value to be incremented to the credit count.
	 */
	public void updateT1CreditCount(int value) {
		tfCreditsT1.setText("" + (Integer.parseInt(tfCreditsT1.getText()) + value));
	}

	/**
	 * Updates the existing value of the reserved term 2 credit count.
	 * 
	 * @param value The integer value to be incremented to the credit count.
	 */
	public void updateT2CreditCount(int value) {
		tfCreditsT2.setText("" + (Integer.parseInt(tfCreditsT2.getText()) + value));
	}

	/**
	 * Sets the value of the term 1 credit count.
	 * 
	 * @param value The integer value to set the term 1 credit count value.
	 */
	public void setT1CreditCount(int value) {
		tfCreditsT1.setText("" + value);
	}
	
	/**
	 * Returns the value of the term 1 credit count.
	 * 
	 * @return The term 1 credit count value.
	 */
	public int getT1CreditCount() {
		return Integer.parseInt(tfCreditsT1.getText());
	}

	/**
	 * Sets the value of the term 2 credit count.
	 * 
	 * @param value The integer value to set the term 2 credit count value.
	 */
	public void setT2CreditCount(int value) {
		tfCreditsT2.setText("" + value);
	}
	
	/**
	 * Returns the value of the term 2 credit count.
	 * 
	 * @return The term 2 credit count value.
	 */
	public int getT2CreditCount() {
		return Integer.parseInt(tfCreditsT2.getText());
	}

	/**
	 * Returns the term 1 TitledPane object.
	 * 
	 * @return Term 1 TitledPane.
	 */
	public TitledPane getT1() {
		return t1;
	}

	/**
	 * Returns the term 2 TitledPane object.
	 * 
	 * @return Term 2 TitledPane.
	 */
	public TitledPane getT2() {
		return t2;
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

	public void addConfrimHandlerT1(EventHandler<ActionEvent> handler) {
		btnConfirmT1.setOnAction(handler);
	}

	public void addConfirmHandlerT2(EventHandler<ActionEvent> handler) {
		btnConfirmT2.setOnAction(handler);
	}
}