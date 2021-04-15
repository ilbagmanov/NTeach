package dao;

import model.Country;

public interface CountryDao extends CRUDDao<Country> {
    Country findById(int id);
    Country findByName(String name);
}
