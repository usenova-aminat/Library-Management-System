package org.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class LibraryController {

    // Поле для ввода поиска
    @FXML
    private TextField searchField;

    // Таблица для отображения данных
    @FXML
    private TableView<Book> tableView;

    // Столбцы для таблицы
    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    // ImageView для отображения баннера
    @FXML
    private ImageView bannerImageView;



    // Список данных для таблицы
    private ObservableList<Book> bookList = FXCollections.observableArrayList(
            new Book("1984", "George Orwell"),
            new Book("Brave New World", "Aldous Huxley"),
            new Book("Fahrenheit 451", "Ray Bradbury")
    );

    // Список для фильтрации данных
    private ObservableList<Book> filteredList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        if (bannerImageView != null) {
            // Убедитесь, что размеры ImageView установлены
            bannerImageView.setFitWidth(600);
            bannerImageView.setFitHeight(300);

            // Создаём прямоугольник для клипа
            Rectangle clip = new Rectangle();
            clip.setWidth(bannerImageView.getFitWidth());  // Устанавливаем ширину
            clip.setHeight(bannerImageView.getFitHeight()); // Устанавливаем высоту
            clip.setArcWidth(40); // Радиус скругления углов по ширине
            clip.setArcHeight(40); // Радиус скругления углов по высоте

            // Применяем clip к ImageView
            bannerImageView.setClip(clip);
        }
    }

    // Метод для закругления углов изображения
    private void applyRoundedCornersToImageView() {
        if (bannerImageView != null) {
            Rectangle clip = new Rectangle();
            clip.setWidth(bannerImageView.getFitWidth());
            clip.setHeight(bannerImageView.getFitHeight());
            clip.setArcWidth(40); // Радиус закругления по ширине
            clip.setArcHeight(40); // Радиус закругления по высоте
            bannerImageView.setClip(clip); // Применяем clip
        }
    }

    // Метод для фильтрации данных на основе ввода пользователя
    private void filterList(String query) {
        if (query == null || query.isEmpty()) {
            tableView.setItems(bookList); // Показываем все книги, если строка пустая
        } else {
            filteredList.clear();
            for (Book book : bookList) {
                if (book.getTitle().toLowerCase().contains(query.toLowerCase())
                        || book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(book); // Добавляем книги, которые соответствуют запросу
                }
            }
            tableView.setItems(filteredList); // Устанавливаем отфильтрованный список
        }
    }

    public void switchScene(String fxmlFile) {
        bestsellerButton.setOnAction(event -> {
            bestsellerButton.getScene().getWindow().hide();
        });
//        }
//        try {
//            System.out.println("Switching to: " + fxmlFile); // Отладка
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
//            Scene newScene = new Scene(fxmlLoader.load());
//            Stage currentStage = (Stage) searchField.getScene().getWindow();
//            currentStage.setScene(newScene);
//            System.out.println("Scene switched successfully to " + fxmlFile); // Отладка
//        } catch (IOException e) {
//            System.out.println("Failed to switch to scene: " + fxmlFile); // Отладка
//            e.printStackTrace();
//        }
    }

    @FXML
    public void switchToBestseller() {
        switchScene("bestseller-view.fxml");
    }
}