package application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import application.database.SingleFactoryDataSource;
import application.entities.Caractere;
import application.entities.Etat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			new SingleFactoryDataSource();
			EntityManager em = SingleFactoryDataSource.getEntityManager();

			// the characters
			// Begin...
			Query query = em.createQuery("select distinct(unCaractere) from Caractere unCaractere");
			// fetchAll
			List<Caractere> carlist = (List<Caractere>) query.getResultList();

			// the states
			Long characterID = 1L;

			Query querystates = em.createNativeQuery("SELECT e.* " + "FROM Etat e " + "WHERE (e.caractere_id = ?1)",
					Etat.class);
			querystates.setParameter(1, characterID);
			// fetchAll
			List<Etat> etatslist = (List<Etat>) querystates.getResultList();

			/// GUI

			BorderPane root = new BorderPane();
			VBox cardLayout = new VBox(20);
			cardLayout.setSpacing(5);
			cardLayout.setPadding(new Insets(10, 0, 0, 10));

			// CHARACTER and STATES
			// Character 1

			VBox vbox1 = new VBox(); // box for character 1 and its states
			vbox1.setSpacing(5);
			vbox1.setPadding(new Insets(10, 10, 10, 10));

			Label char1 = new Label("Phyllotaxie des feuilles");
			CheckBox chka1 = new CheckBox("absent"); // absent -> a
			CheckBox chku1 = new CheckBox("inconnu"); // unknown -> u
			CheckBox chki1 = new CheckBox("inapplicable"); // inapplicable -> i
			FlowPane cflwp1 = new FlowPane();
			cflwp1.setOrientation(Orientation.HORIZONTAL);
			cflwp1.setHgap(5);
			cflwp1.setVgap(10);
			cflwp1.getChildren().addAll(char1, chka1, chku1, chki1);
//			vbox1.getChildren().addAll(cflwp1, sflwp1, sflwp_i);
			vbox1.getChildren().add(cflwp1);

			// State 1 of character 1
			Label state1 = new Label("opposées");
			RadioButton rdbp1 = new RadioButton("présent"); // present -> p
			rdbp1.setUserData(-1);
			RadioButton rdba1 = new RadioButton("absent"); // absent -> a
			rdba1.setUserData(-2);
			RadioButton rdbu1 = new RadioButton("inconnu"); // unknown -> u
			rdbu1.setUserData(-3);
			RadioButton rdbi1 = new RadioButton("inapplicable"); // inapplicable -> i
			rdbi1.setUserData(-4);

			ToggleGroup rtg1 = new ToggleGroup();
			rdbp1.setToggleGroup(rtg1);
			rdba1.setToggleGroup(rtg1);
			rdbu1.setToggleGroup(rtg1);
			rdbi1.setToggleGroup(rtg1);
			FlowPane sflwp1 = new FlowPane();
			sflwp1.setOrientation(Orientation.HORIZONTAL);
			sflwp1.setHgap(5);
			sflwp1.setVgap(10);
			sflwp1.getChildren().addAll(state1, rdbp1, rdba1, rdbu1, rdbi1);
			vbox1.getChildren().add(sflwp1); // attention ICI

			// State 2 of character 1
			Label state2 = new Label("décussées");
			RadioButton rdbp2 = new RadioButton("présent"); // present -> p
			rdbp2.setUserData(-1);
			RadioButton rdba2 = new RadioButton("absent"); // absent -> a
			rdba2.setUserData(-2);
			RadioButton rdbu2 = new RadioButton("inconnu"); // unknown -> u
			rdbu2.setUserData(-3);
			RadioButton rdbi2 = new RadioButton("inapplicable"); // inapplicable -> i
			rdbi2.setUserData(-4);

			ToggleGroup rtg2 = new ToggleGroup();
			rdbp2.setToggleGroup(rtg2);
			rdba2.setToggleGroup(rtg2);
			rdbu2.setToggleGroup(rtg2);
			rdbi2.setToggleGroup(rtg2);
			FlowPane sflwp2 = new FlowPane();
			sflwp2.setOrientation(Orientation.HORIZONTAL);
			sflwp2.setHgap(5);
			sflwp2.setVgap(10);
			sflwp2.getChildren().addAll(state2, rdbp2, rdba2, rdbu2, rdbi2);
			vbox1.getChildren().add(sflwp2); // attention ICI

			cardLayout.getChildren().add(vbox1);
			chka1.setOnAction(e -> {
				if (chka1.isSelected()) {
					chku1.setDisable(true);
					chki1.setDisable(true);
					// togglegroup activated so only one choice is possible
//					rdb1.setSelected(true);
//					rdb2.setSelected(true);
					rdba1.setSelected(true);
					rdba2.setSelected(true);
//					rdba_i.setSelected(true);
				} else {
					chku1.setDisable(false);
					chki1.setDisable(false);
					rdba1.setSelected(false);
					rdba2.setSelected(false);
				}
			});

			chku1.setOnAction(e -> {
				if (chku1.isSelected()) {
					chka1.setDisable(true);
					chki1.setDisable(true);
					// togglegroup activated so only one choice is possible
//					rdb1.setSelected(true);
//					rdb2.setSelected(true);
					rdbu1.setSelected(true);
					rdbu2.setSelected(true);
//					rdba_i.setSelected(true);
				} else {
					chka1.setDisable(false);
					chki1.setDisable(false);
					rdbu1.setSelected(false);
					rdbu2.setSelected(false);
				}
			});

			chki1.setOnAction(e -> {
				if (chki1.isSelected()) {
					chka1.setDisable(true);
					chku1.setDisable(true);
					// togglegroup activated so only one choice is possible
//					rdb1.setSelected(true);
//					rdb2.setSelected(true);
					rdbi1.setSelected(true);
					rdbi2.setSelected(true);
//					rdba_i.setSelected(true);
				} else {
					chka1.setDisable(false);
					chku1.setDisable(false);
					rdbi1.setSelected(false);
					rdbi2.setSelected(false);
				}
			});

			root.setLeft(cardLayout);
			root.setPadding(new Insets(5));

			// BorderPane root = (BorderPane)
			// FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene scene = new Scene(root, 600, 500);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// the launcher
	public static void main(String[] args) {
		launch(args);
	}
}