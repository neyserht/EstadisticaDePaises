module neyser.estadisticadepaises {
    requires javafx.controls;
    requires javafx.fxml;


    opens neyser.estadisticadepaises to javafx.fxml;
    exports neyser.estadisticadepaises;
}