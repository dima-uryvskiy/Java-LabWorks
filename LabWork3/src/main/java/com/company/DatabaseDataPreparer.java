package com.company;
import org.javatuples.Pair;
import java.lang.reflect.Field;

public class DatabaseDataPreparer
{
    public static Pair<String, String> PrepearData(Furniture DataSours)
    {
        StringBuilder allFieldsAtOneString = new StringBuilder();
        StringBuilder allDataAtOneString = new StringBuilder();
        Field[] allFields = DataSours.getClass().getFields();
        for(Field field: allFields)
        {
            allFieldsAtOneString.append(field.getName()+",");
            try {
                allDataAtOneString.append("'" + String.valueOf(field.get(DataSours)) + "',");
            }
            catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        allFieldsAtOneString.delete(allFieldsAtOneString.length() - 1, allFieldsAtOneString.length());
        allDataAtOneString.delete(allDataAtOneString.length() - 1, allDataAtOneString.length());
        return new Pair<String, String>(allFieldsAtOneString.toString(), allDataAtOneString.toString());
    }
}
