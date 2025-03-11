package com.example.aahello;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.Action;
import androidx.car.app.model.ItemList;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;
import androidx.car.app.model.PlaceListMapTemplate;

public class mapscreen extends Screen {
    public mapscreen(CarContext carContext) {
        super(carContext);
    }

    ItemList.Builder itemListBuilder = new ItemList.Builder();

    @NonNull
    @Override
    public Template onGetTemplate() {
        return new PlaceListMapTemplate.Builder()
                .setHeaderAction(Action.BACK).setLoading(true)
                .setTitle("Maps")
//                .setItemList(
//                        itemListBuilder.addItem(
//                                new Row.Builder().addText("vv").setBrowsable(false).setTitle("ff").build()
//                        ).build()
//                )
                .build();

    }
}
