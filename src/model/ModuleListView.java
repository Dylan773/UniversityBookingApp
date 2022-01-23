package model;

import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * This ModuleListView class defines a uniformed ListView design. This class can
 * be instantiated within other classes, inheriting all this of class's
 * properties, resulting in a uniformed layout.
 * 
 * A ModuleListView contains an ObservableList of type Module. This
 * ObservableList is the underlying data model that populates all implemented
 * ModuleListView's.
 * 
 * Each implemented ListView (in other classes) can independently add or remove modules from the ObservableList,
 * resulting in different displays.
 * 
 * E.g. listViewMSP = new ModuleListView();
 * E.g. listView2MSP = new ModuleListView();
 * 
 * @author Dylan Brand, P2523268
 */
public class ModuleListView extends ListView<Module> implements Serializable {

	/* Fields */
	private ObservableList<Module> modules = FXCollections.observableArrayList();

	/* Constructors */
	/**
	 * Default Constructor.
	 * 
	 * This constructor creates a new instance of ModuleListView.
	 * 
	 * Sets the underlying data module of this ListView to an ObservableList of Module's.
	 * Sets the default preferred size of the ListView, this can be overridden.
	 * Sets the selection mode to single selection only, this should not be overridden.
	 */
	public ModuleListView() {
		setItems(modules); 
		setPrefSize(350, 100);
		getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	/* Methods */
	/**
	 * Allows a Module to be added to the ObersvableList.
	 * 
	 * @param module The module to be added. 
	 */
	public void addModule(Module module) {
		this.modules.addAll(module);
	}

	/**
	 * Returns all modules currently stored within the ObservableList.
	 * 
	 * @return All modules.
	 */
	public ObservableList<Module> getModules() {
		return modules;
	}

}
