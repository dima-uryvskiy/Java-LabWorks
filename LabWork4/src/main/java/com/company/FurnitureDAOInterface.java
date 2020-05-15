package com.company;

import java.sql.SQLException;
import java.util.List;

public interface FurnitureDAOInterface {
    void addFurniture(Furniture furniture) throws SQLException;
    void updateFurniture(Furniture furniture) throws SQLException;
    Furniture getFurnitureById(Long idFurniture) throws SQLException;
    List<Furniture>  getAllFurnitures() throws SQLException;
    void deleteFurniture(Furniture furniture) throws SQLException;
}
