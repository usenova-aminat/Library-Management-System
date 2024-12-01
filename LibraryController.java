package org.example.librarymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
        // Привязка данных к столбцам таблицы
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        // Установка начального списка в таблицу
        tableView.setItems(bookList);

        // Добавляем слушатель для поля поиска
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterList(newValue);
        });
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
}