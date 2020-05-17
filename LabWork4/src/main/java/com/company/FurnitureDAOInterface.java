package com.company;

import java.sql.SQLException;
import java.util.List;

public interface FurnitureDAOInterface {
    void addFurniture(Chair chair) throws SQLException;
    void updateFurniture(Chair chair) throws SQLException;
    Chair getFurnitureById(Long idFurniture) throws SQLException;
    List<Chair>  getAllFurnitures() throws SQLException;
    void deleteFurniture(Chair chair) throws SQLException;
}
