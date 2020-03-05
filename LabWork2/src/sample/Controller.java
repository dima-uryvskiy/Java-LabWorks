package sample;

import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static void FindRow(TableView<Furniture> table, int index, String field, String value)
    {
        ArrayList<String[]> listTable = new ArrayList<String[]>();
        for (Furniture objects: table.getItems()) {
            listTable.add(objects.returnArray());
        }

        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        dictionary.put("type", 0);
        dictionary.put("name", 1);
        dictionary.put("width", 2);
        dictionary.put("height", 3);
        dictionary.put("length", 4);
        dictionary.put("color", 5);

        for (String[] arrayValues: listTable)
        {
            if (arrayValues[dictionary.get(field.toLowerCase())].indexOf(value) != -1)
                break;
            index++;
        }
        table.getSelectionModel().select(index);
    }
}
