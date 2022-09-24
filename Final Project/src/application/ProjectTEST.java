package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ProjectTEST extends Application {

	BinaryDataSaver binaryDataSaver;
	public Question selectedEditData;

	public ArrayList<Question> questionArrayList;
	private TextField questionTextField;
	private TextField choice1TextField;
	private TextField choice2TextField;
	private TextField choice3TextField;
	private TextField choice4Field;
	private ComboBox<String> answerComboBox;
	private Button buttonAddNew;
	private ObservableList<Question> dataObservableList;
	private boolean editMode;
	private int selectedIndex;
	public String answer = "Choice 0";
	public RadioButton radioBtn1 = new RadioButton();
	public RadioButton radioBtn2 = new RadioButton();
	public RadioButton radioBtn3 = new RadioButton();
	public RadioButton radioBtn4 = new RadioButton();
	public String choice1;
	public String choice2;
	public String choice3;
	public String choice4;
	public Label lblQuestion;
	public Label result;
	public Label score;
	public Button submit ; 
	public int questionsCount = 0;
	public int correctQuestionCount = 0;

	// Methods for reset all text field 
	void resetInputField() {
		questionTextField.setText("");
		choice1TextField.setText("");
		choice2TextField.setText("");
		choice3TextField.setText("");
		choice4Field.setText("");
		answerComboBox.getSelectionModel().clearSelection();
	}

	// Methods for button of create new question  
	public void save() {

		if (questionTextField.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Question Not entered", ButtonType.OK);
			alert.showAndWait();
			return;
		}

		if (choice1TextField.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Choice1 Not entered", ButtonType.OK);
			alert.showAndWait();
			return;
		}
		if (choice2TextField.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Choice2 not selected", ButtonType.OK);
			alert.showAndWait();
			return;
		}
		if (choice3TextField.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Choice3 not selected", ButtonType.OK);
			alert.showAndWait();
			return;
		}
		if (choice4Field.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Choice4 not selected", ButtonType.OK);
			alert.showAndWait();
			return;
		}
		if (answerComboBox.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Select Correct answer", ButtonType.OK);
			alert.showAndWait();
			return;
		}
		editQuestion();

	}

	
	// Methods for button of edit a question 
	public void editQuestion() {
		final String question = questionTextField.getText();
		final String opt1 = choice1TextField.getText();
		final String opt2 = choice2TextField.getText();
		final String opt3 = choice3TextField.getText();
		final String opt4 = choice4Field.getText();
		String answer = answerComboBox.getSelectionModel().getSelectedItem();

		Question questionModel = new Question(question, opt1, opt2, opt3, opt4, answer);

		if (editMode == true) {

			questionArrayList.remove(selectedIndex);
			questionArrayList.add(selectedIndex, questionModel);
			binaryDataSaver.saveDataToBinaryFile(questionArrayList);

			dataObservableList.remove(selectedIndex);
			dataObservableList.add(selectedIndex, questionModel);

			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Question Updated", ButtonType.OK);
			alert.showAndWait();
			buttonAddNew.setText("Create");
		} else {
			questionArrayList.add(questionModel);
			binaryDataSaver.saveDataToBinaryFile(questionArrayList);
			dataObservableList.add(questionModel);
		}
		resetInputField();

	}

	
	// Methods for button of delete a question 
	public void deleteQuestion() {
		questionArrayList.remove(selectedIndex);
		dataObservableList.remove(selectedIndex);
		binaryDataSaver.saveDataToBinaryFile(questionArrayList);
		resetInputField();
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Question Deleted", ButtonType.OK);
		alert.showAndWait();
	}

	DisplayPane dPane = new DisplayPane();

	// Class for displaying the TableView 
	// with some action event 
	public class DisplayPane extends VBox {

		public DisplayPane() {
			binaryDataSaver = new BinaryDataSaver();

			TableView<Question> tableView = new TableView<>();
			tableView.setPrefHeight(323.0);
			tableView.setPrefWidth(800);
			tableView.setLayoutX(10.0);
			tableView.setLayoutY(66);

			TableColumn columnQuestion = new TableColumn("Question");
			columnQuestion.setPrefWidth(150);
			TableColumn choice1Column = new TableColumn("Choice1");
			choice1Column.setPrefWidth(150);
			TableColumn choice2Column = new TableColumn("Choice2");
			choice2Column.setPrefWidth(150);
			TableColumn choice3Column = new TableColumn("Choice3");
			choice3Column.setPrefWidth(150);
			TableColumn choice4Column = new TableColumn("Choice4");
			choice4Column.setPrefWidth(150);
			TableColumn answerColumn = new TableColumn("Answer");
			answerColumn.setPrefWidth(150);
			TableColumn buttonColumn = new TableColumn("View / Edit /Delete");
			buttonColumn.setPrefWidth(180);

			Callback<TableColumn<Question, String>, TableCell<Question, String>> cellFactory = (
					final TableColumn<Question, String> param) -> {
				final TableCell<Question, String> cell = new TableCell<Question, String>() {

					final Button buttonView = new Button("View");
					final Button buttonEdit = new Button("Edit");
					final Button buttonDelete = new Button("Delete");
					HBox buttonBox = new HBox(buttonView, buttonEdit, buttonDelete);

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty == true) {
							setGraphic(null);
						} else {

							
							// event to edit data question  

							buttonEdit.setOnAction(event -> {
								selectedEditData = getTableView().getItems().get(getIndex());

								selectedIndex = getIndex();
								questionTextField.setText(selectedEditData.getQuestion());
								choice1TextField.setText(selectedEditData.getChoice1());
								choice2TextField.setText(selectedEditData.getChoice2());
								choice3TextField.setText(selectedEditData.getChoice3());
								choice4Field.setText(selectedEditData.getChoice4());
								answerComboBox.getSelectionModel().select(selectedEditData.getAnswer());
								buttonAddNew.setText("Update Question");
								editMode = true;
							});

							
							// event to delete data question  
							buttonDelete.setOnAction(event -> {
								selectedIndex = getIndex();
								deleteQuestion();
							});

							
							// event to send data to Answer Pane 
							buttonView.setOnAction(event -> {

								selectedEditData = getTableView().getItems().get(getIndex());

								choice1 = selectedEditData.getChoice1();
								choice2 = selectedEditData.getChoice2();
								choice3 = selectedEditData.getChoice3();
								choice4 = selectedEditData.getChoice4();

								lblQuestion.setText(selectedEditData.getQuestion());
								radioBtn1.setText(choice1);
								radioBtn2.setText(choice2);
								radioBtn3.setText(choice3);
								radioBtn4.setText(choice4);
								answer = selectedEditData.getAnswer();
								result.setText("");

							});

							setGraphic(buttonBox);
							setText(null);
						}
					}

				};
				return cell;
			};

			buttonColumn.setCellFactory(cellFactory);

			tableView.getColumns().addAll(columnQuestion, choice1Column, choice2Column, choice3Column, choice4Column,
					answerColumn, buttonColumn);

			columnQuestion.setCellValueFactory(new PropertyValueFactory<Question, String>("question"));
			choice1Column.setCellValueFactory(new PropertyValueFactory<Question, String>("choice1"));
			choice2Column.setCellValueFactory(new PropertyValueFactory<Question, String>("choice2"));
			choice3Column.setCellValueFactory(new PropertyValueFactory<Question, String>("choice3"));
			choice4Column.setCellValueFactory(new PropertyValueFactory<Question, String>("choice4"));
			answerColumn.setCellValueFactory(new PropertyValueFactory<Question, String>("answer"));

			getChildren().add(tableView);
			questionArrayList = binaryDataSaver.redDataToBinaryFile();
			dataObservableList = FXCollections.observableArrayList(questionArrayList);
			tableView.setItems(dataObservableList);

		}

	}

	
	// Quesstion Pane Part 

	QuestionPane qPane = new QuestionPane();
	public class QuestionPane extends VBox {

		public QuestionPane() {

			Pane editPane = new Pane();
			editPane.setStyle("-fx-background-color: white");
			editPane.setLayoutX(14);
			editPane.setLayoutY(392);
			editPane.setPrefHeight(353);
			editPane.setPrefWidth(1034);
			Label mainLabel = new Label("Question Pane");
			
			mainLabel.setLayoutX(300);
			mainLabel.setLayoutY(0);
			mainLabel.setFont(new Font(18));


			Label questionLabel = new Label("Question");
			questionLabel.setLayoutX(47);
			questionLabel.setLayoutY(35);
			Label choice1Label = new Label("Choice1");
			choice1Label.setLayoutX(47);
			choice1Label.setLayoutY(74);
			Label choice2Label = new Label("Choice2");
			choice2Label.setLayoutX(47);
			choice2Label.setLayoutY(116);
			Label choice3Label = new Label("Choice3");
			choice3Label.setLayoutX(47);
			choice3Label.setLayoutY(160);
			Label choice4Label = new Label("Choice4");
			choice4Label.setLayoutX(47);
			choice4Label.setLayoutY(209);
			Label answerLabel = new Label("Answer");
			answerLabel.setLayoutX(47);
			answerLabel.setLayoutY(254);

			editPane.getChildren().addAll(mainLabel, questionLabel, choice1Label, choice2Label, choice3Label, choice4Label,
					answerLabel);

			questionTextField = new TextField();
			questionTextField.setPrefHeight(27);
			questionTextField.setPrefWidth(484);
			questionTextField.setLayoutX(127);
			questionTextField.setLayoutY(32);
			choice1TextField = new TextField();
			choice1TextField.setPrefHeight(27);
			choice1TextField.setPrefWidth(484);
			choice1TextField.setLayoutX(127);
			choice1TextField.setLayoutY(69);
			choice2TextField = new TextField();
			choice2TextField.setPrefHeight(27);
			choice2TextField.setPrefWidth(484);
			choice2TextField.setLayoutX(127);
			choice2TextField.setLayoutY(110);
			choice3TextField = new TextField();
			choice3TextField.setPrefHeight(27);
			choice3TextField.setPrefWidth(484);
			choice3TextField.setLayoutX(127);
			choice3TextField.setLayoutY(152);
			choice4Field = new TextField();
			choice4Field.setPrefHeight(27);
			choice4Field.setPrefWidth(484);
			choice4Field.setLayoutX(127);
			choice4Field.setLayoutY(194);
			answerComboBox = new ComboBox<>();
			answerComboBox.setPrefHeight(27);
			answerComboBox.setPrefWidth(484);
			answerComboBox.setLayoutX(127);
			answerComboBox.setLayoutY(236);

			buttonAddNew = new Button("Create");
			buttonAddNew.setPrefHeight(34);
			buttonAddNew.setPrefWidth(164);
			buttonAddNew.setLayoutX(290);
			buttonAddNew.setLayoutY(294);

			buttonAddNew.setOnAction((ActionEvent event) -> {
				save();
			});

			editPane.getChildren().addAll(questionTextField, choice1TextField, choice2TextField, choice3TextField,
					choice4Field, answerComboBox, buttonAddNew);
			answerComboBox.getItems().addAll("Choice 1", "Choice 2", "Choice 3", "Choice 4");

			setAlignment(Pos.CENTER_LEFT);
			getChildren().add(editPane);
		}

	}

	
	// Answer Pane part 
	AnswerPane aPane = new AnswerPane();
	public class AnswerPane extends VBox {

		public AnswerPane() {
			Pane answerPane = new Pane();
			answerPane.setStyle("-fx-background-color: white");
			answerPane.setPrefWidth(120);


			Label mainLabel = new Label("Answer Pane");
			
			mainLabel.setLayoutX(850);
			mainLabel.setLayoutY(85);
			mainLabel.setFont(new Font(20));
			
			Label designed = new Label("Made by \n Abdullah Fahhad (s202063140) \n Shaher Al-Ahmadi (s201946570)");
			
			designed.setLayoutX(850);
			designed.setLayoutY(350);
			designed.setFont(new Font(18));
			designed.setTextFill(Color.BLACK);
		
			
			Label designed2 = new Label("All rights reserved");
			designed2.setLayoutX(1000);
			designed2.setLayoutY(430);
			designed2.setFont(new Font(14));
			designed2.setTextFill(Color.GREY);
			
			


			radioBtn1.setLayoutX(750);
			radioBtn1.setFont(new Font(16));
			radioBtn2.setLayoutX(850);
			radioBtn2.setFont(new Font(16));
			radioBtn3.setLayoutX(950);
			radioBtn3.setFont(new Font(16));
			radioBtn4.setLayoutX(1050);
			radioBtn4.setFont(new Font(16));

			radioBtn1.setLayoutY(160);
			radioBtn2.setLayoutY(160);
			radioBtn3.setLayoutY(160);
			radioBtn4.setLayoutY(160);


			lblQuestion = new Label();
			lblQuestion.setLayoutX(900);
			lblQuestion.setLayoutY(130);
			lblQuestion.setFont(new Font(18));

			result = new Label();
			result.setLayoutX(1200);
			result.setLayoutY(250);
			result.setFont(new Font(16));

			score = new Label();
			score.setLayoutX(900);
			score.setLayoutY(250);
			score.setFont(new Font(16));

			submit = new Button("Submit");
			submit.setFont(new Font(16));
			submit.setLayoutX(880);
			submit.setLayoutY(200);

			
			// event to check if the answer is correct or not 
			submit.setOnAction(event -> {
				convertAnswer();

				if (radioBtn1.isSelected()) {

					if (radioBtn1.getText().equals(answer)) {

						correctQuestionCount++; // increment the total number correct answer  
						result.setText("Correct");
						result.setTextFill(Color.GREEN);
					} else {
						result.setText("Incorrect");
						result.setTextFill(Color.RED);
					}
				}

				else if (radioBtn2.isSelected()) {

					if (radioBtn2.getText().equals(answer)) {

						correctQuestionCount++;
						result.setText("Correct");
						result.setTextFill(Color.GREEN);
					} else {
						result.setText("Incorrect");
						result.setTextFill(Color.RED);
					}
				} else if (radioBtn3.isSelected()) {

					if (radioBtn3.getText().equals(answer)) {

						correctQuestionCount++;
						result.setText("Correct");
						result.setTextFill(Color.GREEN);
					} else {
						result.setText("Incorrect");
						result.setTextFill(Color.RED);
					}
				}

				else if (radioBtn4.isSelected()) {

					if (radioBtn4.getText().equals(answer)) {

						correctQuestionCount++;
						result.setText("Correct");
						result.setTextFill(Color.GREEN);
					} else {
						result.setText("Incorrect");
						result.setTextFill(Color.RED);
					}
				}

				questionsCount++; // increment the total number of question 
				
				
				// after each question radio will unSelected
				radioBtn1.setSelected(false);
				radioBtn2.setSelected(false);
				radioBtn3.setSelected(false);
				radioBtn4.setSelected(false);
				score.setText("The score is " + correctQuestionCount + " out of " + questionsCount);

			});

			answerPane.getChildren().addAll(mainLabel, submit, result, score, lblQuestion, radioBtn1, radioBtn2, radioBtn3, radioBtn4, designed , designed2);

			setAlignment(Pos.CENTER);
			getChildren().add(answerPane);

		}

		
		// Method to convert the String of answer to value of answer 
		public String convertAnswer() {

			if (answer.equals("Choice 1")) {
				answer = choice1;
			} else if (answer.equals("Choice 2")) {
				answer = choice2;
			}

			else if (answer.equals("Choice 3")) {
				answer = choice3;
			} else if (answer.equals("Choice 4")) {
				answer = choice4;
			}
			return answer;
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		VBox containerBox = new VBox(15);
		containerBox.setPrefWidth(930);
		containerBox.setPrefHeight(780);

		BorderPane pan = new BorderPane();
		pan.getChildren().addAll(aPane, qPane);


		containerBox.getChildren().addAll(dPane, pan);
		

		StackPane root = new StackPane();
		root.getChildren().add(containerBox);

		Scene scene = new Scene(root, 1170, 780);
		primaryStage.setTitle("Question Bank Creator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
