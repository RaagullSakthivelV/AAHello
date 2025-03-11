package com.example.aahello;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.Pane;
import androidx.car.app.model.PaneTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;
import androidx.car.app.model.Action;




public class HelloWorldScreen extends Screen {
    public HelloWorldScreen(CarContext carContext) {
        super(carContext);
    }
    @NonNull
    @Override
    public Template onGetTemplate() {
        Action gotoCustomListTemplateScreen = new Action.Builder()
                .setTitle("List Template")
                .setOnClickListener(() -> {
                    // Handle the action click event
                    // For example, transition to another screen or execute a specific logic
                    getScreenManager().push(new CustomListTemplateScreen(getCarContext()));
                })
                .build();
        Action gotoListTemplateSwitches = new Action.Builder()
                .setTitle("List Template Switches")
                .setOnClickListener(() -> {
                    // Handle the action click event
                    // For example, transition to another screen or execute a specific logic
                    getScreenManager().push(new ListTemplateSwitches(getCarContext()));
                })
                .build();
        Action gotomapscreen = new Action.Builder()
                .setTitle("Map")
                .setOnClickListener(() -> {
                    // Handle the action click event
                    // For example, transition to another screen or execute a specific logic
                    getScreenManager().push(new mapscreen(getCarContext()));
                })
                .build();
        Row row = new Row.Builder().setTitle("Row Title").addText("Row Text").build();
        Row row1 = new Row.Builder().setTitle("Hey Makkalae").addText(
                "Vanakkam CBE"
        ).addText("Cheen Tapaku tam tam").build();

        return new PaneTemplate.Builder(new Pane.Builder().addRow(row).addAction(gotoListTemplateSwitches).addAction(gotomapscreen).addRow(row1).build()).setTitle("AA Hello!!!").build();

    }
}
