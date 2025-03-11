package com.example.aahello;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.Action;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.ListTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;
import androidx.car.app.model.Toggle;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.MutableLiveData;

public class ListTemplateSwitches extends Screen {

    // LiveData to store the switch states
    private MutableLiveData<Boolean> switchState1 = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> switchState2 = new MutableLiveData<>(false);

    public ListTemplateSwitches(CarContext carContext) {
        super(carContext);
    }

    ItemList.Builder itemListBuilder = new ItemList.Builder();

    @NonNull
    @Override
    public Template onGetTemplate() {
        CarIcon sampleImage = new CarIcon.Builder(
                IconCompat.createWithResource(getCarContext(), R.mipmap.ic_launcher)) // Load from resources
                .build();



        Toggle toggle1 = new Toggle.Builder((isChecked) -> {
            // Update switch state when toggled
            switchState1.setValue(isChecked);
        }).setChecked(switchState1.getValue() != null && switchState1.getValue()).build();

        // Toggle for Row 2
        Toggle toggle2 = new Toggle.Builder((isChecked) -> {
            // Update switch state when toggled
            switchState2.setValue(isChecked);
        }).setChecked(switchState2.getValue() != null && switchState2.getValue()).build();


        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Map Settings")
                        .build()
        );

        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 1")
                        .addText("Description for item 1")
                        .setToggle(toggle1)

                        .build()
        );

        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 2")
                        .setImage(sampleImage,
                                Row.IMAGE_TYPE_LARGE)
                        .addText("Description for item 2")
                        .setToggle(toggle2)

                        .build()
        );

        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 3")
                        .setImage(sampleImage,
                                Row.IMAGE_TYPE_LARGE)
                        .addText("Description for item 3")
                        .setToggle(toggle2)
                        .build()
        );

        itemListBuilder.addItem(
                new Row.Builder()
                        .setTitle("Item 4")
                        .setImage(sampleImage,
                                Row.IMAGE_TYPE_LARGE)
                        .addText("Description for item 4")
                        .setToggle(toggle1)
                        .build()
        );


        // Build the ListTemplate
        ListTemplate listTemplate = new ListTemplate.Builder()
                .setTitle("Settings")
                .setSingleList(itemListBuilder.build()) // Set the list of items
                .setHeaderAction(Action.BACK) // Set the back button action
                .build();

        return listTemplate;
    }
}
