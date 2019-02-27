module memory.game {
    requires javafx.controls;
    requires javafx.fxml;
    opens pl.techplayground to javafx.fxml;
    exports pl.techplayground;
}