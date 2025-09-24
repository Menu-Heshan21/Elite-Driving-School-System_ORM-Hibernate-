package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    // Sidebar Navigation Buttons
    @FXML
    private Button rolebtn;
    @FXML
    private Button userBtn;
    @FXML
    private Button instructorBtn;
    @FXML
    private Button coursesBtn;
    @FXML
    private Button studentBtn;
    @FXML
    private Button lessonBtn;
    @FXML
    private Button paymentBtn;
    @FXML
    private Button logoutBtn;

    // Quick Action Buttons
    @FXML
    private Button quickUserBtn;
    @FXML
    private Button quickInstructorBtn;
    @FXML
    private Button quickCourseBtn;
    @FXML
    private Button quickStudentBtn;
    @FXML
    private Button quickLessonBtn;
    @FXML
    private Button quickPaymentBtn;

    // Statistics Labels
    @FXML
    private Label totalUsersLabel;
    @FXML
    private Label totalInstructorsLabel;
    @FXML
    private Label totalStudentsLabel;
    @FXML
    private Label monthlyRevenueLabel;
    @FXML
    private Label systemuserId;
    @FXML
    private Label activeinstructorId;
    @FXML
    private Label entrollestudentId;
    @FXML
    private Label monthlyrevenueId;

    // Recent Activities Table
    @FXML
    private TableView<Object> recentActivitiesTable;
    @FXML
    private TableColumn<?, ?> activityTimeColumn;
    @FXML
    private TableColumn<?, ?> activityTypeColumn;
    @FXML
    private TableColumn<?, ?> activityDescriptionColumn;
    @FXML
    private TableColumn<?, ?> activityUserColumn;
    @FXML
    private TableColumn<?, ?> activityStatusColumn;

    // Main Content Area
    @FXML
    private AnchorPane mainContentPane;

    private String currentUserRole;
    private Button activeButton; // Keep track of the currently active button

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDashboardData();
        setupRecentActivitiesTable();
    }

    public void initializeWithUserRole(String userRole) {
        this.currentUserRole = userRole;
        if ("receptionist".equals(userRole)) {
            // Disable buttons not accessible to receptionists
            rolebtn.setDisable(true);
            userBtn.setDisable(true);
            coursesBtn.setDisable(true);
            // Quick action buttons should also be disabled if the corresponding page is
            // restricted
            quickUserBtn.setDisable(true);
            quickCourseBtn.setDisable(true);
        }
    }

    private void loadDashboardData() {
        // These values should be loaded from a database in a real application
        totalUsersLabel.setText("15");
        totalInstructorsLabel.setText("25");
        totalStudentsLabel.setText("150");
        monthlyRevenueLabel.setText("LKR 2,250,000");
    }

    private void setupRecentActivitiesTable() {
        // This is a placeholder; you would typically configure column cell factories
        // and load data from a database here.
        ObservableList<Object> activities = FXCollections.observableArrayList();
        recentActivitiesTable.setItems(activities);
    }

    private void loadFXMLInMainContent(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + fxmlFileName));
        Parent content = loader.load();
        mainContentPane.getChildren().setAll(content);
        AnchorPane.setTopAnchor(content, 0.0);
        AnchorPane.setRightAnchor(content, 0.0);
        AnchorPane.setBottomAnchor(content, 0.0);
        AnchorPane.setLeftAnchor(content, 0.0);
    }

    private void setActiveButton(Button button) {
        // Reset the style of the previous active button
        if (activeButton != null) {
            activeButton.setStyle("-fx-background-color: transparent; -fx-background-radius: 10;");
            activeButton.setTextFill(javafx.scene.paint.Color.web("#64748B"));
        }

        // Set the style of the new active button
        button.setStyle("-fx-background-color: #E0F2FE; -fx-background-radius: 10;");
        button.setTextFill(javafx.scene.paint.Color.web("#3B82F6"));
        activeButton = button;
    }

    // Sidebar Navigation Button Actions
    @FXML
    private void btnRoleOnAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Role.fxml");
        setActiveButton(rolebtn);
    }

    @FXML
    private void btnUserOnAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("User.fxml");
        setActiveButton(userBtn);
    }

    @FXML
    private void btnInstructorOnAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Instructor.fxml");
        setActiveButton(instructorBtn);
    }

    @FXML
    private void btnCourseOnAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Course.fxml");
        setActiveButton(coursesBtn);
    }

    @FXML
    private void btnStudentOnAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Student.fxml");
        setActiveButton(studentBtn);
    }

    @FXML
    private void btnLessonOnAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Lesson.fxml");
        setActiveButton(lessonBtn);
    }

    @FXML
    private void btnPaymentOnAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Payment.fxml");
        setActiveButton(paymentBtn);
    }

    @FXML
    private void btnLogoutOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GoodBye.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Goodbye");
        stage.setScene(new Scene(root));
        stage.show();

        Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
        currentStage.close();
    }

    // Quick Action Button Methods
    @FXML
    private void quickUserAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("User.fxml");
        setActiveButton(userBtn);
    }

    @FXML
    private void quickInstructorAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Instructor.fxml");
        setActiveButton(instructorBtn);
    }

    @FXML
    private void quickCourseAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Course.fxml");
        setActiveButton(coursesBtn);
    }

    @FXML
    private void quickStudentAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Student.fxml");
        setActiveButton(studentBtn);
    }

    @FXML
    private void quickLessonAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Lesson.fxml");
        setActiveButton(lessonBtn);
    }

    @FXML
    private void quickPaymentAction(ActionEvent event) throws IOException {
        loadFXMLInMainContent("Payment.fxml");
        setActiveButton(paymentBtn);
    }

    public void initialize(String admin) {

    }
}