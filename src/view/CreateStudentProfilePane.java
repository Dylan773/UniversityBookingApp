package view;

import java.time.LocalDate;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Course;
import model.Name;

/**
 * This pane is responsible for the initial student profile creation.
 * 
 * The CreateStudentProfilePane allows the user to input data necessary to
 * create a profile. Once the user has input the required data, the data is
 * saved to the StudentProfile model.
 * 
 * The user is unable to create a profile, unless all data fields have been
 * populated.
 * 
 * @author Dylan Brand, P2523268
 */
public class CreateStudentProfilePane extends GridPane {

	/* Fields */
	private ComboBox<Course> cboCourses;
	private DatePicker inputDate;
	private TextField txtFirstName, txtSurname, txtPnumber, txtEmail;
	private Button btnCreateProfile;

	/* Constructor(s) */
	/**
	 * Default Constructor.
	 * 
	 * Creates a new instance of CreateStudentProfilePane. This constructor defines
	 * the layout and arrangement of nodes and controls for the GUI.
	 */
	public CreateStudentProfilePane() {
		// Styling
		this.getStyleClass().add("create-student-profile-pane");

		// Sets the column constraint for the first column
		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.RIGHT);

		this.getColumnConstraints().add(column0);

		// create labels
		Label lblTitle = new Label("Select course: ");
		Label lblPnumber = new Label("Input P number: ");
		Label lblFirstName = new Label("Input first name: ");
		Label lblSurname = new Label("Input surname: ");
		Label lblEmail = new Label("Input email: ");
		Label lblDate = new Label("Input date: ");

		// initialise combobox
		cboCourses = new ComboBox<Course>(); // this is populated via method towards end of class

		// setup text fields
		txtFirstName = new TextField();
		txtSurname = new TextField();
		txtPnumber = new TextField();
		txtEmail = new TextField();

		inputDate = new DatePicker();

		// initialise create profile button
		btnCreateProfile = new Button("Create Profile");

		// add controls and labels to container
		this.add(lblTitle, 0, 0);
		this.add(cboCourses, 1, 0);

		this.add(lblPnumber, 0, 1);
		this.add(txtPnumber, 1, 1);

		this.add(lblFirstName, 0, 2);
		this.add(txtFirstName, 1, 2);

		this.add(lblSurname, 0, 3);
		this.add(txtSurname, 1, 3);

		this.add(lblEmail, 0, 4);
		this.add(txtEmail, 1, 4);

		this.add(lblDate, 0, 5);
		this.add(inputDate, 1, 5);

		this.add(new HBox(), 0, 6);
		this.add(btnCreateProfile, 1, 6);
	}

	/* Methods */

	// method to allow the controller to add courses to the combobox
	public void addCoursesToComboBox(Course[] courses) {
		cboCourses.getItems().addAll(courses);
		cboCourses.getSelectionModel().select(0); // select first course by default
	}

	// methods to retrieve the form selection/input
	public Course getSelectedCourse() {
		return cboCourses.getSelectionModel().getSelectedItem();
	}

	/**
	 * Set's the cboCourses (combo box) value (CompSci/SoftEng).
	 * 
	 * @param course The Course argument to set the combo box's value.
	 */
	public void setSelectedCourse(Course course) {
		cboCourses.setValue(course);
	}

	/**
	 * Returns the txtPnumber's TextField value.
	 * 
	 * @return The txtPnumber's TextField value.
	 */
	public String getStudentPnumber() {
		return txtPnumber.getText();
	}

	/**
	 * Set's the txtPnumber's TextField value.
	 * 
	 * @param name The String argument to set the value of the txtPnumber TextField.
	 */
	public void setStudentPnumber(String pNumber) {
		txtPnumber.setText(pNumber);
	}

	/**
	 * Creates a new Name object, combining the txtFirstName and txtSurname's values
	 * to create a full name, "txtFirstName + txtSurname".
	 * 
	 * @return A new Name object.
	 */
	public Name getStudentName() {
		return new Name(txtFirstName.getText(), txtSurname.getText());
	}

	/**
	 * Set's the txtFirstName's TextField value.
	 * 
	 * @param name The String argument to set the value of the txtFirstName
	 *             TextField.
	 */
	public void setStudentFirstName(String name) {
		txtFirstName.setText(name);
	}

	/**
	 * Sets the txtSurname's TextField value.
	 * 
	 * @param name The String argument to set the value of the txtSurname TextField.
	 */
	public void setStudentSurname(String name) {
		txtSurname.setText(name);
	}

	/**
	 * Returns the txtEmail's TextField value.
	 * 
	 * @return The txtEmail's TextField value.
	 */
	public String getStudentEmail() {
		return txtEmail.getText();
	}

	/**
	 * Sets the txtEmail's TextField value.
	 * 
	 * @param name The String argument to set the value of the txtEmail TextField.
	 */
	public void setStudentEmail(String email) {
		txtEmail.setText(email);
	}

	/**
	 * Returns the inputDate's LocalDate value.
	 * 
	 * @return The inputDate's LocalDate value.
	 */
	public LocalDate getStudentDate() {
		return inputDate.getValue();
	}

	/**
	 * Sets the student's profile creation date
	 * 
	 * @param date The LocalDate argument to set the profile creation date.
	 */
	public void setStudentDate(LocalDate date) {
		inputDate.setValue(date);
	}

	/**
	 * Method that returns a BooleanBinding based upon either control being empty.
	 * 
	 * @return BooleanBinding.
	 */
	public BooleanBinding isFormEmpty() {
		return txtFirstName.textProperty().isEmpty().or(txtSurname.textProperty().isEmpty().or(txtPnumber.textProperty()
				.isEmpty().or(txtEmail.textProperty().isEmpty().or(inputDate.valueProperty().isNull()))));
	}

	/* Event Handlers */

	// Create student profile button event handler
	public void addCreateStudentProfileHandler(EventHandler<ActionEvent> handler) {
		btnCreateProfile.setOnAction(handler);
	}

	/**
	 * Method that binds BooleanBinding's to the disable property of the "Create"
	 * button. This button will be disabled when the binding attached registers
	 * true.
	 * 
	 * @param property The T/F property for this bind.
	 */
	public void addBtnCreateBind(BooleanBinding property) {
		btnCreateProfile.disableProperty().bind(property);
	}

}
