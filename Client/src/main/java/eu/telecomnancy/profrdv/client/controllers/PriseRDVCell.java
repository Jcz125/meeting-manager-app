package eu.telecomnancy.profrdv.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.io.IOException;

public class PriseRDVCell extends ListCell<String>
{
    @FXML Label prof;
    private FXMLLoader mLLoader;

    public PriseRDVCell() {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("RDVCellButton.fxml"));
//        fxmlLoader.setController(this);
//        try
//        {
//            fxmlLoader.load();
//        }
//        catch (IOException e)
//        {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void updateItem(String string, boolean empty)
    {
        super.updateItem(string,empty);
        if(empty || string == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("PriseRDVCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            prof.setText(string);

            setText(null);
            //setGraphic(gridPane);
        }
    }
}