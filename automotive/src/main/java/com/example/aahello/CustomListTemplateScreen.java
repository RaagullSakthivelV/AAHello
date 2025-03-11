package com.example.aahello;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.Action;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.ListTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;
import androidx.car.app.model.CarIcon;
import androidx.core.graphics.drawable.IconCompat;





public class CustomListTemplateScreen extends Screen {
    public CustomListTemplateScreen(CarContext carContext) {
        super(carContext);
    }

    ItemList.Builder itemListBuilder = new ItemList.Builder();

    @NonNull
    @Override
    public Template onGetTemplate() {

    CarIcon sampleImage = new CarIcon.Builder(
        IconCompat.createWithResource(getCarContext(), R.mipmap.ic_launcher)) // Load from resources
        .build();


        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 1")
                        .setImage(sampleImage,
                                Row.IMAGE_TYPE_LARGE)
                        .addText("Description for item 1")
                        .build()
        );

        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 2")
                        .setImage(sampleImage,
                                Row.IMAGE_TYPE_LARGE)
                        .addText("Description for item 2")
                        .build()
        );

        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 3")
                        .setImage(sampleImage,
                                Row.IMAGE_TYPE_LARGE)
                        .addText("Description for item 3")
                        .build()
        );

        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 4")
                        .setImage(sampleImage,
                                Row.IMAGE_TYPE_LARGE)
                        .addText("Description for item 4")
                        .build()
        );


        // Build the ListTemplate
        ListTemplate listTemplate = new ListTemplate.Builder()
                .setTitle("My List Template")
                .setSingleList(itemListBuilder.build()) // Set the list of items
                .setHeaderAction(Action.BACK) // Set the back button action
                .build();

        return listTemplate;
    }
}
